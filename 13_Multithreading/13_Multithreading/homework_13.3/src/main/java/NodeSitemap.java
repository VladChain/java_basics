import java.util.concurrent.CopyOnWriteArrayList;

public class NodeSitemap {

    private String url;
    private volatile NodeSitemap parent;
    private volatile CopyOnWriteArrayList<NodeSitemap> children;
    private volatile int depth;

    public NodeSitemap(String url) {
        this.url = url;
        parent = null;
        this.children = new CopyOnWriteArrayList<>();
        depth = 0;
    }

    public String getUrl() {
        return url;
    }

    // Проверяем наш URL адрес на соответствие
    private boolean contains(String url) {
        if (this.url.equals(url)) {
            return true;
        }
        for (NodeSitemap child : children) {
            if (child.contains(url)) {
                return true;
            }
        }
        return false;
    }

    private void setParent(NodeSitemap parent) {
        synchronized (this) {
            this.parent = parent;
            this.depth = calculateDepth();
        }
    }

    public NodeSitemap getRootElement() {
        return parent == null ? this : parent.getRootElement();
    }

    public CopyOnWriteArrayList<NodeSitemap> getChildren() {
        return children;
    }

    // Добавляем дочерние ссылки к ссылки основного сайта
    public synchronized void addChild(NodeSitemap element) {
        NodeSitemap root = getRootElement();
        if (!root.contains(element.getUrl())) {
            element.setParent(this);
            children.add(element);
        }
    }

    // Подсчет глубины отступа каждой следующей вложенной ссылки
    private int calculateDepth() {
        int result = 0;
        if (parent == null) {
            return result;
        }
        result = 1 + parent.calculateDepth();
        return result;
    }
}
