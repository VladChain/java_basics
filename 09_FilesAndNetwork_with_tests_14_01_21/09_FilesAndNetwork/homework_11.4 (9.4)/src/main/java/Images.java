import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Images {

    private Scanner scanner;
    private static File destinationFolder;

    public void download(Document doc) {
        scanner = new Scanner(System.in);
        for (; ; ) {
            try {
                Elements imgTags = doc.select("[src$=.jpg]");

                destinationFolder = takePath("\n������� ���� � �����, " +
                        "� ������� ������ ������� �����������: ");

                if (destinationFolder.exists() && destinationFolder.isDirectory()) {
                    List<String> srcList = new ArrayList<>();
                    imgTags.forEach(imgTag -> srcList.add(imgTag.attr("abs:src")));
                    srcList.forEach(Images::downloadImg);

                    Stream<Path> stream = Files.list(Paths.get(String.valueOf(destinationFolder)));
                    System.out.println("\n����� ������� ������� � ����� "
                            + destinationFolder.getName() + "!\n");
                    System.out.println("������ ������, ������� �� ������� � �����\n" + doc.location() +
                            " � ���� � ����� " + destinationFolder.getName() + ":\n");
                    stream.forEachOrdered((s) -> System.out.println(s.getFileName()));
                } else {
                    System.out.println("����� ����� ���!");
                }

            } catch (IOException e) {
                System.err.println("�� ������� ��������� ����!");
                System.exit(1);
            }
        }
    }

    private static void downloadImg(String imgSrc) {
        String imgName = imgSrc.substring(imgSrc.lastIndexOf('/'));
        try {
            try (InputStream bis = new BufferedInputStream(new URL(imgSrc).openStream());
                 ByteArrayOutputStream baos = new ByteArrayOutputStream();
                 FileOutputStream fos = new FileOutputStream(destinationFolder + imgName)) {

                byte[] buf = new byte[1024];
                int n;
                while ((n = bis.read(buf)) != -1)
                    baos.write(buf, 0, n);
                fos.write(baos.toByteArray());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private File takePath(String message) {
        for (; ; ) {
            try {
                System.out.println(message);
                String line = scanner.nextLine();
                if (line != null)
                    return new File(line);
            } catch (NullPointerException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
