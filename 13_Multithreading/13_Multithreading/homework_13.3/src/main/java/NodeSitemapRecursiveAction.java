import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.concurrent.RecursiveAction;
import java.util.regex.Pattern;

import static java.lang.Thread.sleep;

// Наследуем RecursiveAction, т.к. нам не надо возвращаемое значение в методе compute()
public class NodeSitemapRecursiveAction extends RecursiveAction {

    private NodeSitemap node;

    public NodeSitemapRecursiveAction(NodeSitemap node) {
        this.node = node;
    }

    @Override
    protected void compute() {
        try {
            sleep(500);
            Connection connection = Jsoup.connect(node.getUrl()).timeout(10000);
            Document document = connection.get();
            Elements elements = document.select("body").select("a");
            for (Element element : elements) {
                String childUrl = element.absUrl("href");
                if (isCorrectUrl(childUrl)) {
                    childUrl = replaceElements(childUrl);
                    node.addChild(new NodeSitemap(childUrl));
                }
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        for (NodeSitemap child : node.getChildren()) {
            NodeSitemapRecursiveAction task = new NodeSitemapRecursiveAction(child);
            task.compute();
        }
    }

    // Создаем шаблоны и проверяем корректность URL адреса
    private boolean isCorrectUrl(String url) {
        Pattern patternRoot = Pattern.compile("^" + node.getUrl());
        Pattern patternNotFile = Pattern.compile("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|pdf))$)");
        Pattern patternNotAnchor = Pattern.compile("#([\\w\\-]+)?$");

        return patternRoot.matcher(url).lookingAt() && !patternNotFile.matcher(url).find()
                && !patternNotAnchor.matcher(url).find();
    }

    // Убираем ненужные элементы в URL адресе
    private String replaceElements(String url) {
        return url.replaceAll("\\?.+", "");
    }
}
