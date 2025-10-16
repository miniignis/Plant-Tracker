import java.util.List;
import java.util.Scanner;

public class Menu {

    private MenuItem currentMenu;
    private int selectedIndex = 0;

    public Menu(MenuItem root) {
        this.currentMenu = root;
    }

    public void navigate(Scanner scanner) {
        while (true) {

            System.out.print("\033[H\033[2J");
            System.out.flush();

            display();
            String input = scanner.nextLine().trim().toLowerCase();

            switch (input) {
                case "w":
                    if (selectedIndex > 0) selectedIndex--;
                    break;
                case "s":
                    if (selectedIndex < currentMenu.getChildren().size() - 1) selectedIndex++;
                    break;
                case "":
                    if (currentMenu.getChildren().isEmpty()) {
                        currentMenu.doAction();
                    } else {
                        MenuItem menuSelected = currentMenu.getChildren().get(selectedIndex);
                        if (!menuSelected.getChildren().isEmpty()) {
                            currentMenu = menuSelected;
                            selectedIndex = 0;
                        } else {
                            menuSelected.doAction();
                        }
                    }
                    break;
                case "q":
                    if (currentMenu.getParent() != null) {
                        currentMenu = currentMenu.getParent();
                        selectedIndex = 0;
                    }
                    break;
            }
        }
    }

    public void display() {
        System.out.print("\n== " + currentMenu.getTitle() + " ==\n");

        List<MenuItem> children = currentMenu.getChildren();

        for (int i = 0; i < children.size(); i++) {
            if (i == selectedIndex) {
                System.out.print("> ");
            }
            System.out.println(children.get(i).getTitle());
        }

        System.out.println("== [W/S]MOVE  [ENTER]SELECT  [Q]BACK ==");
    }
}
