import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.InsertOneModel;
import com.mongodb.client.model.WriteModel;
import org.bson.Document;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);
        MongoDatabase database = mongoClient.getDatabase("local");

        // Создаем коллекцию
        MongoCollection<Document> collection = database.getCollection("students");

        // Удалим из нее все документы
        collection.drop();

        // Создадим список документов
        List<WriteModel<Document>> documents = new ArrayList<>();

        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get("C:/Users/АДМИН/Desktop/mongo.csv"));

            for (String line : lines) {
                String[] fragments1 = new String[0];
                if (line.contains(" ")) {
                    fragments1 = line.replace(" ", ",").split(",");
                    for (int i = 0; i <= fragments1[2].length(); i++) {
                        fragments1[i] = Arrays.toString(fragments1[i].split(","))
                                .replace("[","").replace("]","");
                    }
                }
                String[] fragments2 = new String[0];
                if (line.contains("\"")) {
                    fragments2 = line.split("\"");
                    fragments2[1] = Arrays.toString(fragments2[1].split("\""))
                            .replace("[","").replace("]","");
                }
                documents.add(
                        new InsertOneModel<>(
                                new Document()
                                        .append("Name", fragments1[0])
                                        .append("FamilyName", fragments1[1])
                                        .append("Age", fragments1[2])
                                        .append("Course", fragments2[1])
                        )
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Вставляем документ в коллекцию
        collection.bulkWrite(documents);

        // Выводим в консоль
        collection.find().forEach((Consumer<Document>) System.out::println);
    }
}
