
public class Main {

    public static MainMenu menu = new MainMenu();

    public static void main(String[] args) {

        Lead lead1 = new Lead("Test1", "testnum1", "test1@test.gmail.com", "TestCompany1");
        Lead lead2 = new Lead("Test2", "testnum2", "test2@test.gmail.com", "TestCompany2");
        Lead lead3 = new Lead("Test3", "testnum2", "test2@test.gmail.com", "TestCompany2");

        MainMenu.theLeads.put(lead1.getId(), lead1);
        MainMenu.theLeads.put(lead2.getId(), lead2);
        MainMenu.theLeads.put(lead3.getId(), lead3);

        try {
            while (true) {
                menu.OS();
            }
        } catch (RuntimeException e) {
        }
    }
}
