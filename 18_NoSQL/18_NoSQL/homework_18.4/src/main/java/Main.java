import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.*;
import org.bson.BsonDocument;
import org.bson.BsonString;
import org.bson.Document;

import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.mongodb.client.model.Aggregates.group;

public class Main {

    public static void main(String[] args) throws IOException {

        char ignore, choice;
        String nameStore, nameGoods;
        int priceGoods;
        Scanner scanner = new Scanner(System.in);
        Document stores = new Document();
        List<String> listGoods = new ArrayList<>();

        // Избавления от логов в MongoDB
        Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
        mongoLogger.setLevel(Level.SEVERE);

        // Подключение к MongoDB
        MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);
        MongoDatabase database = mongoClient.getDatabase("local");

        // Создаем коллекцию для товаров
        MongoCollection<Document> collectionGoods = database.getCollection("goods");

        // Создаем коллекцию для магазинов
        MongoCollection<Document> collectionStores = database.getCollection("stores");

        // Создаем коллекцию для выставления товаров в магазин
        MongoCollection<Document> collectionGoodsInStore = database.getCollection("goods_in_store");

        // Удаляем все магазины
        collectionStores.drop();

        // Удаляем весь товар
        collectionGoods.drop();

        // Удаляем товар и магазин
        collectionGoodsInStore.drop();

        // Сделаем добавление магазина, товара, выкладку товара
        // и статистику товара через консоль
        for (; ; ) {
            do {
                System.out.println("\nСписок команд: ");
                System.out.println("\t1. ДОБАВИТЬ_МАГАЗИН");
                System.out.println("\t2. ДОБАВИТЬ_ТОВАР");
                System.out.println("\t3. ВЫСТАВИТЬ_ТОВАР");
                System.out.println("\t4. СТАТИСТИКА_ТОВАРОВ");
                System.out.println("\tBыбepитe (q - выход): ");
                System.out.println("Выберите номер команды: ");

                choice = (char) System.in.read();

                do {
                    ignore = (char) System.in.read();
                } while (ignore != '\n');
            } while (choice < '1' | choice > '4' & choice != 'q');

            if (choice == 'q') break;

            switch (choice) {
                case '1' -> {
                    // Добавление магазина
                    System.out.println("Введите название магазина: ");
                    nameStore = scanner.next();
                    stores = new Document()
                            .append("store", nameStore);
                    collectionStores.insertOne(stores);
                }
                case '2' -> {
                    // Добавление товара
                    do {
                        System.out.println("Введите название товара: ");
                        while (!scanner.hasNext("[А-Яа-я]+")) {
                            System.out.println("Неверный ввод, попробуйте еще раз!");
                            scanner.next();
                        }
                        nameGoods = scanner.next();
                    } while (nameGoods.matches("\\d+"));
                    do {
                        System.out.println("Введите цену товара:");
                        while (!scanner.hasNextInt()) {
                            System.out.println("Неверный ввод, попробуйте еще раз!");
                            scanner.next();
                        }
                        priceGoods = scanner.nextInt();
                    } while (priceGoods <= 0);
                    Document goods = new Document()
                            .append("goods", nameGoods).append("price", priceGoods);
                    listGoods.add(nameGoods);
                    collectionGoods.insertOne(goods);
                }
                case '3' -> {
                    // Добавление товара в магазин
                    stores.append("goods", listGoods);
                    collectionGoodsInStore.insertOne(stores);
                    System.out.println("Товар успешно выставлен на полках магазина!");
                }
//                    listGoods.clear();
                case '4' -> {
                    // Статистика товара
                    System.out.println("Количество товара в магазине: " + collectionGoods.countDocuments());
                    AggregateIterable<Document> aggregate1 = collectionGoods
                            .aggregate(List.of(group("_id", new BsonField("averagePrice",
                                    new BsonDocument("$avg", new BsonString("$price"))))));
                    Document result1 = aggregate1.first();
                    double averagePrice = Objects.requireNonNull(result1).getDouble("averagePrice");
                    System.out.println("Cредняя цена товара: " + averagePrice);
                    AggregateIterable<Document> aggregate2 = collectionGoods
                            .aggregate(List.of(group("_id", new BsonField("maxPrice",
                                    new BsonDocument("$max", new BsonString("$price"))))));
                    Document result2 = aggregate2.first();
                    int maxPrice = Objects.requireNonNull(result2).getInteger("maxPrice");
                    System.out.println("Самый дорогой товар: " + maxPrice);
                    AggregateIterable<Document> aggregate3 = collectionGoods
                            .aggregate(List.of(group("_id", new BsonField("minPrice",
                                    new BsonDocument("$min", new BsonString("$price"))))));
                    Document result3 = aggregate3.first();
                    int minPrice = Objects.requireNonNull(result3).getInteger("minPrice");
                    System.out.println("Самый дешевый товар: " + minPrice);
                    System.out.println("Количество товаров дешевле 100 рублей: " +
                            collectionGoods.countDocuments(Document.parse("{price : {$lt : 100}}")));
                }
            }
        }
        // Выводим список магазинов
        System.out.println("Список магазинов: ");
        collectionStores.find().forEach((Consumer<Document>) System.out::println);

        // Выводим список товаров
        System.out.println("\nСписок товаров: ");
        collectionGoods.find().forEach((Consumer<Document>) System.out::println);

        // Выводим список товаров в магазине
        System.out.println("\nСписок товаров в магазине: ");
        collectionGoodsInStore.find().forEach((Consumer<Document>) System.out::println);
    }
}
