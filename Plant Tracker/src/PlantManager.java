import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlantManager {
    private final List<Plant> plants = new ArrayList<>();

    public List<Plant> getPlants() { return plants; }
    public void addPlant(Plant plant) { plants.add(plant); }
    public void removePlant(Plant plant) { plants.remove(plant); }

    public void displayPlants() {
        clearScreen();

        for (Plant plant : plants) {
            plant.printInfo();
        }
    }

    public void userAddPlant(Scanner scanner) {

        Plant userPlant = new Plant();

        clearScreen();
        System.out.println("== Add a New Plant ==");

        System.out.print("Name: ");
        userPlant.setName(scanner.nextLine());

        System.out.print("Description: ");
        userPlant.setDescription(scanner.nextLine());

        System.out.print("Location: ");
        userPlant.setLocation(scanner.nextLine());

        float height = 0f;
        while (true) {
            System.out.print("Height(in): ");
            String input = scanner.nextLine();

            try {
                height = Float.parseFloat(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number (ex: 5.2)");
            }
        }

        userPlant.setHeight(height);
        addPlant(userPlant);

        System.out.println("\nPlant added successfully!");
        scanner.nextLine();
    }

    public void userEditPlant(Scanner scanner) {
        clearScreen();
        if (plants.isEmpty()) {
            System.out.println("No plants to edit!");
            scanner.nextLine();
            return;
        }

        Plant selectedPlant = userSelectPlant(scanner);
        clearScreen();

        System.out.println("== Edit an Existing Plant ==");
        while (true) {
            System.out.println("Editing: " + selectedPlant.getName());
            System.out.println("[1] Name");
            System.out.println("[2] Description");
            System.out.println("[3] Location");
            System.out.println("[4] Height");
            System.out.println("[5] Done");
            System.out.print("Select a field: ");

            String option = scanner.nextLine();

            switch(option) {
                case "1":
                    System.out.print("New name: ");
                    selectedPlant.setName(scanner.nextLine());
                    break;
                case "2":
                    System.out.print("New description: ");
                    selectedPlant.setDescription(scanner.nextLine());
                    break;
                case "3":
                    System.out.print("New location: ");
                    selectedPlant.setLocation(scanner.nextLine());
                    break;
                case "4":
                    System.out.print("New height (in): ");

                    try {
                        float newHeight = Float.parseFloat(scanner.nextLine());
                        selectedPlant.setHeight(newHeight);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid Number.");
                    }
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Invalid Choice. Try again.");
            }
        }
    }

    private Plant userSelectPlant(Scanner scanner) {
        System.out.println("== Select an Existing Plant ==");
        for (int i = 0; i < plants.size(); i++) {
            System.out.printf("%d" + " | " +  plants.get(i).getName() + "\n", i + 1);
        }

        int choice = -1;
        while (true) {
            System.out.print("Select a plant number: ");
            String input = scanner.nextLine();

            try {
                choice = Integer.parseInt(input) - 1;
                if (choice >= 0 && choice < plants.size()) {
                    break;
                } else {
                    System.out.println("Please select a valid number from the list.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, enter a number.");
            }
        }

        return plants.get(choice);
    }

    public void userDeletePlant(Scanner scanner) {
        clearScreen();
        if (plants.isEmpty()) {
            System.out.println("No plants to delete!");
            scanner.nextLine();
            return;
        }
        Plant selectedPlant = userSelectPlant(scanner);
        clearScreen();

        System.out.println("== Delete an Existing Plant ==");
        plants.remove(selectedPlant);
        System.out.println("Plant removed successfully!");
        scanner.nextLine();
    }

    public void userAddTask(Scanner scanner) {
        clearScreen();

        System.out.println("== Delete an Existing Plant ==");

        Plant selectedPlant = userSelectPlant(scanner);
    }

    /* NOT USED.
    public Plant findPlantByName(String name) {
        return plants.stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
    */

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
