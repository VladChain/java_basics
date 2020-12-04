import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

//        System.out.println("Введите ФИО: ");
//    Иванов Иван Иванович
//    Салтыков-Щедрин Михаил Евграфович
//    Иван Иван Иванович вв2ввв
//    1111 2222 3333
//    Иван

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            Pattern p = Pattern.compile(".+");
            Matcher m = p.matcher(input);
            if (m.find()) {
                input = m.group();
            }
            if (!input.isEmpty() && !input.equals("0") &&
                    input.matches("[а-яА-Я-]+\\s[а-яА-Я]+\\s[а-яА-я]+")) {
                String title = "Фамилия: Имя: Отчество: ";
                String[] date = title.split("\\s+");
                String[] fullName = input.split("\\s+");
                StringBuilder words = new StringBuilder();
                for (int i = 0; i < fullName.length; i++) {
                    words.append(date[i]).append(" ")
                            .append(fullName[i]).append("\n");
                }
                System.out.println(words.toString());
            } else {
                System.out.println("Введенная строка не является ФИО");
            }
            break;
        }
    }
}