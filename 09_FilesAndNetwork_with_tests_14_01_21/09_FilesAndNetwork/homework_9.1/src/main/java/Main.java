import java.io.File;
import java.util.Scanner;

public class Main {

    private static Scanner scanner;
    private static final FileUtils file = new FileUtils();

    public static void main(String[] args)  {
        for(;;) {
            scanner = new Scanner(System.in);
            File pathToFolder = takePath("\nВведите путь до папки: ");
            System.out.println(pathToFolder.getPath());

            String path = pathToFolder.toString();
            printSize(path);
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
            } catch (IllegalArgumentException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static void printSize(String path) {
        long size = FileUtils.calculateFolderSize(path);
        if (FileUtils.calculateFolderSize(path) >= 1073741824) {
            double sizes = (size / Math.pow(1024, 3));
            System.out.printf("Размер папки %s %.1f Gb\n", path, sizes);
        } else if (size >= 1048576) {
            double sizes = (size / Math.pow(1024, 2));
            System.out.printf("Размер папки %s %.1f Mb\n", path, sizes);
        } else if (FileUtils.calculateFolderSize(path) >= 1024) {
            double sizes = (double) (size / 1024);
            System.out.printf("Размер папки %s %.0f Kb\n", path, sizes);
        } else {
            System.out.printf("Размер папки %s %s byte\n", path, size);
        }
    }
}
