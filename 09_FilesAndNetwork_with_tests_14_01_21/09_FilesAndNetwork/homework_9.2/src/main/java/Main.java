import java.io.File;
import java.util.Scanner;

public class Main {

    private static Scanner scanner;

    public static void main(String[] args) {
        for (;;) {
            scanner = new Scanner(System.in);
            try {
                File pathToFolder = takePath("\nВведите путь до исходной папки: ");

                if (pathToFolder.exists() && pathToFolder.isDirectory()) {

                    File destinationFolder = takePath("\nВведите путь до папки назначения:");

                    String source = pathToFolder.toString();
                    String destination = destinationFolder.toString();

                    if (destinationFolder.exists() && destinationFolder.isDirectory()) {
                        FileUtils.copyFolder(source, destination);
                        System.out.println("Папка успешно скопирована!");
                    } else {
                        System.out.println("Такой папки не существует!");
                    }
                } else {
                    System.out.println("Такой папки не существует!");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private static File takePath(String message) {
        for (; ; ) {
            try {
                System.out.println(message);
                String line = scanner.nextLine();
                if (line != null) {
                    return new File(line);
                }
                System.out.println("Неверно указан путь!");
            } catch (NullPointerException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}

