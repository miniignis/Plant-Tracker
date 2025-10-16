import java.util.ArrayList;
import java.util.List;

public class MenuItem {

    private final String title;
    private final Runnable action;
    private final List<MenuItem> children = new ArrayList<>();
    private MenuItem parent;

    public MenuItem(String title, Runnable action) {
        this.title = title;
        this.action = action;
    }

    public MenuItem(String title, Runnable action, List<MenuItem> children) {
        this.title = title;
        this.action = action;
        if (!children.isEmpty()) {
            for (MenuItem child : children) {
                addChild(child);
            }
        }
    }

    public void doAction() {
        if (action != null) {
            action.run();
        }
    }

    public void addChild(MenuItem child) {
        child.parent = this;
        children.add(child);
    }

    public String getTitle() {
        return title;
    }

    public MenuItem getParent() {
        return parent;
    }

    public List<MenuItem> getChildren() {
        return children;
    }
}
