import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;

public class Loadeer {
    private static final String fileName = "C:/Users/АДМИН/IdeaProjects/Git/GitLab/java_basics/19_Performance/" +
            "19_Performance/VoteAnalyzer/res/data-18M.xml";

    public static void main(String[] args) throws Exception {
        SAXParsingAndWriting();
        DBConnection.printVoterCounts();
        DBConnection.getConnection().close();
    }

    private static void SAXParsingAndWriting() throws ParserConfigurationException, SAXException, IOException {
        long start = System.currentTimeMillis();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        XMLHandler handler = new XMLHandler();
        parser.parse(new File(fileName), handler);
        handler.clear();
        System.out.println("Total time for SAX Parsing: " + (System.currentTimeMillis() - start));
    }
}