
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Loaders {

    private static HashMap<Integer, WorkTimes> voteStationWorkTimes = new HashMap<>();
    private static HashMap<Voters, Integer> voterCounts = new HashMap<>();

    public static void main(String[] args) throws Exception {

        String fileName = "C:/Users/АДМИН/IdeaProjects/Git/GitLab/java_basics/19_Performance/19_Performance/VoteAnalyzer/res/data-0.2M.xml";

        // Использование DOM-парсера:
        long usage = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long start1 = System.currentTimeMillis();

        parseFile(fileName);

        //Printing results
        System.out.println("Voting station work times: ");
        for (Integer votingStation : voteStationWorkTimes.keySet()) {
            WorkTimes workTime = voteStationWorkTimes.get(votingStation);
            System.out.println("\t" + votingStation + " - " + workTime);
        }

        System.out.println("Duplicated voters: ");
        for (Voters voter : voterCounts.keySet()) {
            Integer count = voterCounts.get(voter);
            if (count > 1) {
                System.out.println("\t" + voter + " - " + count);
            }
        }

        usage = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory() - usage;
        long end1 = System.currentTimeMillis();
        System.out.println("Использование DOM-парсера занимает памяти: " + usage + " Кб.");
        System.out.println("Время использование DOM-парсера занимает: " + (end1 - start1) + " ms\n");

        // Использование SAXParser’а:
        usage = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long start2 = System.currentTimeMillis();

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        XMLHandlers handler = new XMLHandlers();
        parser.parse(new File(fileName), handler);
        handler.printDuplicatedVoters();

        usage = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory() - usage;
        long end2 = System.currentTimeMillis();
        System.out.println("Использование SAXParser’а занимает памяти: " + usage + " Кб.");
        System.out.println("Время использование SAXParser’а занимает: " + (end2 - start2) + " ms");
    }

    private static void parseFile(String fileName) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new File(fileName));

        findEqualVoters(doc);
        fixWorkTimes(doc);
    }

    private static void findEqualVoters(Document doc) throws Exception {
        NodeList voters = doc.getElementsByTagName("voter");
        int votersCount = voters.getLength();
        for (int i = 0; i < votersCount; i++) {
            Node node = voters.item(i);
            NamedNodeMap attributes = node.getAttributes();

            String name = attributes.getNamedItem("name").getNodeValue();
            SimpleDateFormat birthDayFormat = new SimpleDateFormat("yyyy.MM.dd");
            Date birthDay = birthDayFormat
                    .parse(attributes.getNamedItem("birthDay").getNodeValue());

            Voters voter = new Voters(name, birthDay);
            Integer count = voterCounts.get(voter);
            voterCounts.put(voter, count == null ? 1 : count + 1);
        }
    }

    private static void fixWorkTimes(Document doc) throws Exception {
        NodeList visits = doc.getElementsByTagName("visit");
        int visitCount = visits.getLength();
        for (int i = 0; i < visitCount; i++) {
            Node node = visits.item(i);
            NamedNodeMap attributes = node.getAttributes();

            Integer station = Integer.parseInt(attributes.getNamedItem("station").getNodeValue());
            SimpleDateFormat visitDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
            Date time = visitDateFormat.parse(attributes.getNamedItem("time").getNodeValue());
            WorkTimes workTime = voteStationWorkTimes.get(station);
            if (workTime == null) {
                workTime = new WorkTimes();
                voteStationWorkTimes.put(station, workTime);
            }
            workTime.addVisitTime(time.getTime());
        }
    }
}