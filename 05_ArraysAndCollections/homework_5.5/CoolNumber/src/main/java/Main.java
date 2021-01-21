import java.util.*;

public class Main {
    /*
    TODO:
     - реализовать методы класса CoolNumbers
     - посчитать время поиска введимого номера в консоль в каждой из структуры данных
     - проанализоровать полученные данные
     */
    private static CoolNumbers coolNumbers = new CoolNumbers();

    public static void main(String[] args) {
        long startSearch;
        long endSearch;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер: ");
        String numberSearch = scanner.nextLine();

        List<String> list = coolNumbers.generateCoolNumbers();
        startSearch = System.nanoTime();
        System.out.println(coolNumbers.bruteForceSearchInList(list, numberSearch));
        endSearch = System.nanoTime();
        System.out.println("Время поиска перебором: " + (endSearch - startSearch) + "нс");

        startSearch = System.nanoTime();
        System.out.println(coolNumbers.binarySearchInList(list, numberSearch));
        endSearch = System.nanoTime();
        System.out.println("Время бинарного поиска: " + (endSearch - startSearch) + "нс");

        startSearch = System.nanoTime();
        HashSet<String> hashSet = new HashSet<>(list);
        System.out.println(coolNumbers.searchInHashSet(hashSet, numberSearch));
        endSearch = System.nanoTime();
        System.out.println("Поиск в HashSet: " + (endSearch - startSearch) + "нс");

        startSearch = System.nanoTime();
        TreeSet<String> treeSet = new TreeSet<>(list);
        System.out.println(coolNumbers.searchInTreeSet(treeSet, numberSearch));
        endSearch = System.nanoTime();
        System.out.println("Поиск в TreeSet: " + (endSearch - startSearch) + "нс");

        // Самый быстрый поиск номера:
        // 1-е место - Поиск перебором;
        // 2-е место - Бинарный поиск;
        // 3-е место - Поиск в HashSet;
        // 4-е место - Поиск в TreeSet

        // У999УУ199
    }
}
