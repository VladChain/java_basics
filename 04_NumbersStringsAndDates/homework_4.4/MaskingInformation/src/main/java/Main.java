import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введите данные: ");
//         Номер кредитной карты <4008 1234 5678> 8912
//         Пин код <6160>     должно быть +++ вместо ***   !!!
//         Номер паспорта <45 08 361>513
//         Номер паспорта <<45 08 36513
//         Номер паспорта 45 08 36513
//         Номер кредитной карты <4008> 1234 <5678> 8912   !!!
        String input = scanner.nextLine();
        System.out.println(searchAndReplaceDiamonds(input, "***"));
    }
    public static String searchAndReplaceDiamonds(String text, String placeholder) {
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
        }
        if (!text.isEmpty() && text.indexOf('<') < 0 || text.indexOf('>') < 0) {
            return text;
        } else {
            int diamondFirst = text.indexOf('<');

            int diamondMidFirst = text.indexOf('>');
            if (diamondMidFirst > 0) {
                diamondMidFirst++;
            }
            int diamondMidLast = text.lastIndexOf('<');

            int diamondLast = text.lastIndexOf('>');
            if (diamondLast > 0) {
                diamondLast++;
            }
            while (text.contains(">")) {
                String diamonds2 = text.substring(diamondFirst, diamondMidFirst);
                String diamonds3 = text.substring(diamondMidLast, diamondLast);

                if ((diamonds2.length() < 10) && (diamonds3.length() < 10)
                        && text.length() <15) {
                    text = text.replace(diamonds2, "+++")
                            .replace(diamonds3, "+++");
                } else {
                    text = text.replace(diamonds2, "***")
                            .replace(diamonds3, "***");
                }
            }
        }
        return text; // return text.replaceAll("<(.*)>", "***");
    }
}