import java.util.Date;

public class Task {

    private final String type;
    private boolean completed = false;
    private Date date;

    public Task(String type) {
        this.type = type;
    }

    public void toggleCompletion() { completed = !completed; }
    public String getType() { return type; }
    public Date getDate() { return date; }
    public Boolean isCompleted() { return completed; }

    public void printInfo() {
        System.out.print(type + " | Completed: " + (completed ? "Yes" : "No"));
    }

}
