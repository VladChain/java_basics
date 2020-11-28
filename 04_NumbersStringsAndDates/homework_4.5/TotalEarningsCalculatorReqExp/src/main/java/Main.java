import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введите текст: ");
//        Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей
//        Коля заработал 50000 рублей, Федя - 45800 рубля, а Саша - 23000 рублей
//        Толя заработал 35000 рублей, а Лера - 45000 рублей
//        Никто ничего не заработал
        String text = scanner.nextLine();
        System.out.println(calculateSalarySum(text));
    }
    public static int calculateSalarySum(String text) {
        int sum = 0;

        String[] digitArray = text.split(",");
        for (int i = 0; i < digitArray.length; i++) {
            if (digitArray.length == 1) {
                return sum;
            } else {
                sum += Integer.parseInt(digitArray[i].replaceAll("[^0-9]", ""));
            }
        }
//        Короткий вариант цикла:
//        for (String digit : digitArray) {
//            sum += Integer.parseInt(digit.replaceAll("[^0-9]", ""));
//        }
        return sum;
    }
}