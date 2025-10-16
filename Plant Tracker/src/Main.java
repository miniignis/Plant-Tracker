import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PlantManager manager = new PlantManager();

        MenuItem rootMenu = new MenuItem("Plant Tracker", null, List.of(
                new MenuItem("Manage Plants", null, List.of(
                        new MenuItem("View", () -> {
                            manager.displayPlants();
                            input.nextLine();
                        }),
                        new MenuItem("Add", () -> manager.userAddPlant(input)),
                        new MenuItem("Edit", () -> manager.userEditPlant(input)),
                        new MenuItem("Delete", () -> manager.userDeletePlant(input)),
                        new MenuItem("Manage Tasks", null)
                )),
                new MenuItem("View Summaries", null),
                new MenuItem("Exit", () -> {
                    System.exit(0); // Replace later
                })
        ));

        Menu menu = new Menu(rootMenu);
        menu.navigate(input);
    }
}