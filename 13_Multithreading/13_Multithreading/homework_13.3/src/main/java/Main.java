import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.concurrent.ForkJoinPool;

public class Main {

    private static final String ROOT_SITE = "https://skillbox.ru/";

    public static void main(String[] args) throws IOException {

        NodeSitemap sitemapRoot = new NodeSitemap(ROOT_SITE);
        new ForkJoinPool().invoke(new NodeSitemapRecursiveAction(sitemapRoot));

        // Создаем наш файл для записи ссылок и печатаем в консоль полученный результат
        FileOutputStream stream = new FileOutputStream("data/sitemap.txt");
        String result = createSitemap(sitemapRoot, 0);
        stream.write(result.getBytes());
        System.out.println(result);
        stream.flush();
        stream.close();
    }

    // Формируем наши ссылки с отступами и переносами на следующую строку
    public static String createSitemap(NodeSitemap node, int depth) {
        String tabs = String.join("", Collections.nCopies(depth, "\t"));
        StringBuilder result = new StringBuilder(tabs + node.getUrl());
        node.getChildren().forEach(child -> {
            result.append("\n").append(createSitemap(child, depth + 1));
        });
        return result.toString();
    }
}
