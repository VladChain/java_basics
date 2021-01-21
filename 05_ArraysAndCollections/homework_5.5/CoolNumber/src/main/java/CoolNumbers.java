import java.util.*;

public class CoolNumbers {

    private static ArrayList<String> coolNumbers = new ArrayList<>();

    public static List<String> generateCoolNumbers() {
        String[] letters = {"А", "В", "С", "Е", "Н", "К", "М", "О", "Р", "Т", "Х", "У"};

        String[] numbers = new String[9];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = String.valueOf(111 + 111 * i);
        }

        String[] regions = new String[199];
        for (int j = 0; j < regions.length; j++) {
            if (j < 9) {
                regions[j] = 0 + String.valueOf(j + 1);
            } else {
                regions[j] = String.valueOf(j + 1);
            }
        }

        ArrayList<String> autoNumbers = new ArrayList<>();
        for (int let1 = 0; let1 < letters.length; let1++) {
            for (int num = 0; num < numbers.length; num++) {
                for (int let2 = 0; let2 < letters.length; let2++) {
                    for (int let3 = 0; let3 < letters.length; let3++) {
                        for (int reg = 0; reg < regions.length; reg++) {
                            autoNumbers.add(letters[let1] + numbers[num] + letters[let2] +
                                    letters[let3] + regions[reg]);
                        }
                    }
                }
            }
        }
        return autoNumbers;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        return list.contains(number);
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        Collections.sort(sortedList);
        int i = Collections.binarySearch(sortedList, number);
        if (i < 0) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        return hashSet.contains(number);
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        return treeSet.contains(number);
    }
}
