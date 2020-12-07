import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        System.out.println(searchAndReplaceDiamonds(text, "***"));

//        Номер кредитной карты <4008 1234 5678> 8912
//        Пин код <6160>
//        Номер паспорта <45 08 361>513
//        Номер паспорта <<45 08 36513
//        Номер паспорта 45 08 36513
//        Номер кредитной карты <4008> 1234 <5678> 8912
    }

    public static String searchAndReplaceDiamonds(String text, String placeholder) {
        // Вариант 1:
        text = text.replaceAll("<[\\d\\s]+>", placeholder);
        return text;
    }
}
        // Вариант 2:
//        if (text.matches(".+\\<.+\\>.+\\<.+\\>.+")) {
//            text = text.replaceAll("\\<\\d+\\>", placeholder);
//        }
//        if (text.matches(".+\\<.+\\>.+")) {
//            text = text.replaceAll("\\<.+\\>", placeholder);
//        }
//        if (text.matches(".+\\<.+\\>")) {
//            text = text.replaceAll("\\<.+\\>", placeholder);
//        }