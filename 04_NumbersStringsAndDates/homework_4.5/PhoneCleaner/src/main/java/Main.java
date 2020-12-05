import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

//        System.out.println("Введите номер: ");
//    +7 909 123-45-67  =  79091234567     +++
//    +7 (909) 1234567  =  79091234567     +++
//    8-905-1234567     =  79051234567 - поменять 8 на 7
//    9-453-1234567     =  код не 7 и не 8
//    905-1234567       = 7 + 9051234567
//    8-905-123         =   +++
//    8-905-12345672342 =   +++

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            input = input.replaceAll("[\\s+\\-,()]", "");
            Pattern p = Pattern.compile(".+");
            Matcher m = p.matcher(input);
            while (m.find()) {
                input = m.group();
            }
            if (input.length() == 10) {
                input = "7" + input;
            }
            if (input.startsWith("8")) {
                input = input.replaceFirst("8", "7");
            }
            if (input.startsWith("9")) {
                System.out.println("Неверный формат номера");
                break;
            }
            if (input.length() == 11) {
                String[] digits = input.split("");
                StringBuilder number = new StringBuilder();
                for (String symbols : digits) {
                    number.append(symbols);
                }
                System.out.println(number.toString());
            } else {
                System.out.println("Неверный формат номера");
            }
            break;
        }
    }
}
