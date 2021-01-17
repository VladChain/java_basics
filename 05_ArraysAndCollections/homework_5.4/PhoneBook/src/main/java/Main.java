import java.util.Scanner;

public class Main {
    private static String input;
    private static PhoneBook phoneBook = new PhoneBook();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nВведите номер, имя или команду:");
            input = scanner.nextLine();

            if (input.matches("END"))
                break;

            else if (input.matches("LIST")) {
                System.out.println(phoneBook.getAllContacts());
            } else
                checkInput(input);
        }
    }

    public static void checkInput(String str) {

        if (str.matches("^[а-яА-Я]+$")) {
            if (phoneBook.getPhonesByName(str).contains(str)) {
                System.out.println(str + " - " + phoneBook.getPhonesByName(str));
            } else {
                System.out.println("Такого имени в телефонной книге нет. \n" +
                        "Введите номер телефона для абонента " + str + ":");
                phoneBook.addContact(scanner.nextLine(), str);
            }
        } else if (str.matches("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$")) {
            if (phoneBook.getNameByPhone(str).contains(str)) {
                System.out.println(phoneBook.getNameByPhone(str) + " - " + str);
            } else {
                System.out.println("Такого номера нет в телефонной книге. \n" +
                        "Введите имя абонента для номера " + str + ":");
                phoneBook.addContact(str, scanner.nextLine());
            }
        } else {
            System.out.println("Неверный формат ввода.");
        }
    }
}
//    Маша - 79001234567
//    Миша - 79991234567