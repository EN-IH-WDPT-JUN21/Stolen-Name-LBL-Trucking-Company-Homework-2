
public class Main {

    public static MainMenu menu = new MainMenu();

    public static void main(String[] args) {

        try {
            while (true) {
                menu.OS();
            }
        } catch (RuntimeException e) {

        }
    }
}
