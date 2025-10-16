import java.util.ArrayList;
import java.util.List;

public class Plant {
    private String name;
    private String description;
    private String location;
    private float height; // Replace with list of heights + dates later...
    private List<Task> tasks = new ArrayList<>();

    public Plant() {
        this.name = "NO NAME SET";
        this.description = "NO DESCRIPTION SET";
        this.location = "NO LOCATION SET";
        this.height = 0f;
    }

    public Plant(String name, String description) {
        this.name = name;
        this.description = description;
        this.location = "None";
        this.height = 0f;
    }

    public Plant(String name, String description, String location, float height) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.height = height;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getLocation() { return location; }
    public float getHeight () { return height; }

    public void setName(String name) {
        if (name.isEmpty()) return;
        this.name = name;
    }

    public void setDescription(String description) {
        if (description.isEmpty()) return;
        this.description = description;
    }

    public void setLocation(String location) {
        if (location.isEmpty()) return;
        this.location = location;
    }

    public void setHeight (float height) {
        if (height < 0) return;
        this.height = height;
    }

    public void addTask(Task task) { tasks.add(task); }
    public void removeTask(Task task) { tasks.remove(task); }
    public List<Task> getTasks() { return tasks; }

    public void printInfo() {
        System.out.print("\n[" + name);
        System.out.print(" | Description: " + description);
        System.out.print(" | Location: " + location);
        System.out.print(" | Height(in): " + height);
        System.out.print(" | Tasks: ");
        if (tasks.isEmpty()) {
            System.out.print(" (No Tasks Set)");
        } else {
            for (Task task : tasks) {
                task.printInfo();
            }
        }
        System.out.print("]");
    }

}
