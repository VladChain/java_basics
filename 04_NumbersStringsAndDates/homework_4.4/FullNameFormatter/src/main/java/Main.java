import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введите фамилию, имя, отчество:");

        String input = scanner.nextLine(); // Иванов Иван Иванович, Иван, 1111 2222 3333,
        // Иван Иван Иванович ввввв, Салтыков-Щедрин Михаил Евграфович

        StringBuilder symbols = new StringBuilder(input);
        for (int i = 0; i < input.length(); i++) {
            char digits = input.charAt(i);
            if (digits > 47 && digits < 58) {
                symbols.append(digits);
            }
            int space = input.length() - input.replace(" ", "").length();
            if (space == 0 || space > 2) {
                symbols.append(space);
            }
        }
        if (!input.isEmpty() && input.contentEquals(symbols)) {
            int spaceIndexFirst = input.indexOf(' ');
            int spaceIndexLast = input.lastIndexOf(' ');

            String surname = input.substring(0, spaceIndexFirst);
            String name = input.substring(spaceIndexFirst, spaceIndexLast);
            String fathername = input.substring(spaceIndexLast);

            System.out.printf("Фамилия: %s\nИмя:%s\nОтчество:%s", surname, name, fathername);

        } else System.out.println("Введенная строка не является ФИО");
    }
}