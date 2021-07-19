import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class OperationSystem {

    enum consoleTextColor {
        ANSI_GREEN("\u001B[32m"),
        ANSI_BLUE("\\u001B[34m"),
        ANSI_RED("\u001B[31m"),
        ANSI_YELLOW("\u001B[33m"),
        ANSI_PURPLE("\u001B[35m"),
        ANSI_CYAN("\u001B[36m"),
        ANSI_RESET("\u001B[0m");


        private final String color;

        consoleTextColor(String color) {
            this.color = color;
        }
    }

    //Pattern pattern = Pattern.compile("^[1-9][0-9]{1,4}$");


    private static Scanner scanner = new Scanner(System.in);
    private static String color = consoleTextColor.ANSI_GREEN.color;
    private static String reset = consoleTextColor.ANSI_RESET.color;

    public void OS() {

        boolean on = true;

        while(on) {
            System.out.println("\n" + color
            + "╔══════════════════════════════════════════════════════════════════════════════╗\n"
            + "║                          WELCOME TO LBL CRM SYSTEM                           ║\n"
            + "╠══════════════════════════════════════════════════════════════════════════════╣\n"
            + "║ WHAT WOULD YOU LIKE TO DO?                                                   ║\n"
            + "╠══════════════════════════════════════════════════════════════════════════════╣\n"
            + "║ 1. To create new Lead - type: 'New Lead'                                     ║\n"
            + "║ 2. To check Leads list - type: 'Show Leads'                                  ║\n"
            + "║ 3. To check individual Lead's details - type: 'Lookup Lead ' + Lead Id       ║\n"
            + "║ 4. To convert Lead into Opportunity - type: - 'convert ' + Lead Id           ║\n"
            + "║ 5. To check Opportunity list - type: 'Show Opportunity'                      ║\n"
            + "║ 6. To check Contact list - type: - 'Show Contacts'                           ║\n"
            + "║ 7. To check Account list - type: - 'Show Accounts'                           ║\n"
            + "║ 8. To quit - type: - 'Quit'                                                  ║\n"
            + "╚══════════════════════════════════════════════════════════════════════════════╝\n"
            );

            String input = scanner.nextLine().trim().toLowerCase(Locale.ROOT);

            try {
                switch(input) {
                    //String x = input.substring(input.indexOf("Lead") + 3, input.length());
                    case "new lead":
                        Lead.newLead();
                        break;
                    case "show leads":
                        Lead.showLeads();
                        break;
                    //case "Lookup Lead " + :
                    case "convert 1":
                        Lead.convertLead("1");
                        break;
                    case "show opportunity":
                        Opportunity.showOportunities();
                        break;
                    case "show contacts":
                        Contact.showContacts();
                        break;
                    case "show accounts":
                        Account.showAccounts();
                        break;
                    case "quit":
                        System.out.println("Thank you for using our LBL CRM SYSTEM!");
                        on = false;
                        break;
                    default:
                        throw new IllegalArgumentException();

                }
            } catch (IllegalArgumentException e) {

                System.out.println("Invalid input - please start again");
                OS();
            }
        }



    }








}
