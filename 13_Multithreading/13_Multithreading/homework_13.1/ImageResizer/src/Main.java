import java.io.File;

public class Main {

    private static int newWidth = 300;

    public static void main(String[] args) {
        String srcFolder = "C:/Users/АДМИН/Desktop/src";
        String dstFolder = "C:/Users/АДМИН/Desktop/dst";

        File srcDir = new File(srcFolder);

        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();
        if (files != null) {
            int middle = files.length / 2;

            // Двух ядерный процессор, два потока
            // Поток 1:
            File[] files1 = new File[middle];
            System.arraycopy(files, 0, files1, 0, files1.length);
            ImageResizer resizer1 = new ImageResizer(files1, newWidth, dstFolder, start);
            resizer1.start();

            // Поток 2:
            File[] files2 = new File[files.length - middle];
            System.arraycopy(files, middle, files2, 0, files2.length);
            ImageResizer resizer2 = new ImageResizer(files2, newWidth, dstFolder, start);
            resizer2.start();
        }
    }
}
