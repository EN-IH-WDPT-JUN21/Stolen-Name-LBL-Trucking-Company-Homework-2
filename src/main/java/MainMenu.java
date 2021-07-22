import java.util.Locale;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;


public class MainMenu {

    public static Map<String, Lead> theLeads = new HashMap<>();
    public static Map<String, Account> theAccounts = new HashMap<>();
    public static Map<String, Contact> theContacts = new HashMap<>();
    public static Map<String, Opportunity> theOpportunities = new HashMap<>();

    Scanner scanner = new Scanner(System.in);

    enum consoleTextColor {
        ANSI_BLACK("\u001B[30m"),
        ANSI_RED("\u001B[31m"),
        ANSI_GREEN("\u001B[32m"),
        ANSI_YELLOW("\u001B[33m"),
        ANSI_BLUE("\033[1;34m"),
        ANSI_PURPLE("\u001B[35m"),
        ANSI_CYAN("\u001B[36m"),
        ANSI_WHITE("\033[0;37m"),
        ANSI_RESET("\u001B[0m");


        private final String color;

        consoleTextColor(String color) {
            this.color = color;
        }
    }

    private static String colorMain = consoleTextColor.ANSI_YELLOW.color;
    private static String colorInput = consoleTextColor.ANSI_CYAN.color;
    private static String colorError = consoleTextColor.ANSI_RED.color;
    private static String colorLogo = consoleTextColor.ANSI_GREEN.color;
    private static String reset = MainMenu.consoleTextColor.ANSI_RESET.color;

    public MainMenu() {

    }

    public void OS() throws RuntimeException {

        System.out.println("\n" + colorLogo
                                   + "                                                                                                \n" +
                                   "                                         *#### #####        ###################*   *####*         \n" +
                                   "                         #################### #####        ######################  #####          \n" +
                                   "                    ,######              ### #####        #####            ###### #####           \n" +
                                   "                  ####                  ### #####        #####    ############## #####            \n" +
                                   "                ####                   ### #####        #####      ###########  #####             \n" +
                                   "              ########################### #####        #####            ###### #####              \n" +
                                   "             ####################.###### ############ ###################### ############         \n" +
                                   "             ################ ####### # ############ #####################  ############          \n" + reset +
                         colorMain + "╔══════════════════════════════════════════════════════════════════════════════════════════════╗\n"
                                   + "║                                WELCOME TO LBL CRM SYSTEM                                     ║\n"
                                   + "╠══════════════════════════════════════════════════════════════════════════════════════════════╣\n"
                                   + "║     WHAT WOULD YOU LIKE TO DO?                                                               ║\n"
                                   + "╠══════════════════════════════════════════════════════════════════════════════════════════════╣\n"
                                   + "║ 1.  To create new Lead - type: 'New Lead'                                                    ║\n"
                                   + "║ 2.  To check Leads list - type: 'Show Leads'                                                 ║\n"
                                   + "║ 3.  To check individual Lead's details - type: 'Lookup Lead ' + Lead Id                      ║\n"
                                   + "║ 4.  To check individual Opportunity's details - type: 'Lookup Opportunity ' + Opportunity Id ║\n"
                                   + "║ 5.  To convert Lead into Opportunity - type: - 'convert ' + Lead Id                          ║\n"
                                   + "║ 6.  To check Opportunity list - type: 'Show Opportunities'                                   ║\n"
                                   + "║ 7.  To check Contact list - type: - 'Show Contacts'                                          ║\n"
                                   + "║ 8.  To check Account list - type: - 'Show Accounts'                                          ║\n"
                                   + "║ 9.  To change Opportunity status - type: - 'Change Opportunity' + Opportunity Id             ║\n"
                                   + "║ 10. To quit - type: - 'Quit'                                                                 ║\n"
                                   + "╚══════════════════════════════════════════════════════════════════════════════════════════════╝\n" + reset);

        try {

            // Creates String array from scanner input
            String[] input = scanner.nextLine().trim().toLowerCase().split("\\s+");

            if (input[0].equals("quit")) {
                System.out.println(colorMain + "\nThank you for using our LBL CRM SYSTEM!" + reset);
                throw new RuntimeException(colorError + "Exiting the program" + reset);
            } else if (input[0].equals("lookup") && input[1].equals("lead")) {
                System.out.println(lookUpLeadId(input[2]).toString());
            } else if (input[0].equals("lookup") && input[1].equals("opportunity")) {
                System.out.println(lookUpOppId(input[2]).toString());
            } else if (input.length < 2) {
                throw new IllegalArgumentException();
            } else if (input[0].equals("convert")) { // throws null point exception if number not in array
                createAccount(convertLead(input[1]));
            } else if (input[0].equals("change") && input[1].equals("opportunity")) {
                changeOppStatus(input[2]);

            } else {

                switch (input[0] + input[1]) {
                    //String x = input.substring(input.indexOf("Lead") + 3, input.length());
                    case "new" + "lead" -> newLead();
                    case "show" + "leads" -> showLeads();
                    case "show" + "opportunities" -> showOpportunities();
                    case "show" + "contacts" -> showContacts();
                    case "show" + "accounts" -> showAccounts();
                    default -> throw new IllegalArgumentException();
                }
            }
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println(colorError + "\nInvalid input" + reset);

        }
        System.out.println(colorInput + "\nPress enter to return to the main menu" + reset);
        scanner.nextLine();
        OS();

    }


    // Method to create a new lead
    public Lead newLead() {

        System.out.println(colorInput + "\nWould you like to create a new lead?   y / n " + reset);
        try {
            switch (scanner.nextLine().trim().toLowerCase(Locale.ROOT)) {
                case "y" -> {
                    Lead newLead = new Lead();
                    System.out.println(colorInput + "\nPlease input the customers name: " + reset);
                    newLead.setName(scanner.nextLine().trim());
                    if (newLead.getName().isEmpty()) {
                        throw new IllegalArgumentException(colorError + "No name input" + reset);
                    }
                    System.out.println(colorInput + "\nPlease input the customers phone number: " + reset);
                    newLead.setPhoneNumber(scanner.nextLine().trim());
                    if (newLead.getPhoneNumber().isEmpty()) {
                        throw new IllegalArgumentException("No PhoneNumber input" + reset);
                    }
                    System.out.println(colorInput + "\nPlease input the customers email address: " + reset);
                    newLead.setEmail(scanner.nextLine().trim());
                    if (newLead.getEmail().isEmpty()) {
                        throw new IllegalArgumentException(colorError + "No email input" + reset);
                    }
                    System.out.println(colorInput + "\nPlease input the customers company name: " + reset);
                    newLead.setCompanyName(scanner.nextLine().trim());
                    if (newLead.getCompanyName().isEmpty()) {
                        throw new IllegalArgumentException(colorError + "No name input" + reset);
                    }
                    theLeads.put(newLead.getId(), newLead);
                    System.out.println(colorMain + "\n═════════════ New Lead Created ═════════════\n");
                    System.out.println(theLeads.get(newLead.getId()));
                    return newLead;
                }
                case "n" -> // Would normally go back in the menu at this point
                        System.out.println(colorError + "You said no" + reset);
                default -> throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {

            System.out.println(colorError + "\n***Invalid input - please start again***\n" + reset);
            newLead();
        }
        return null;
    }

    // Method to convert Lead to Opportunity
    public Opportunity convertLead(String id) throws NullPointerException {

        Lead lead = theLeads.get(id);
        System.out.println(colorInput + "\nWould you like to convert " + lead.getName() + " from: " + lead.getCompanyName() +
                                   " into an opportunity?    y / n " + reset);
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        try {
            switch (scanner.nextLine().trim().toLowerCase(Locale.ROOT)) {
                case "y" -> {
                    Opportunity newOpp = new Opportunity();
                    System.out.println(colorInput + "\nPlease input the product that " + lead.getCompanyName() + " is interested in: \n " +
                                               "HYBRID, FLATBED OR BOX" + reset);
                    newOpp.setTruck(Truck.valueOf(scanner.nextLine().trim().toUpperCase(Locale.ROOT)));
                    System.out.println(colorInput + "\nPlease input the quantity that " + lead.getCompanyName() + " is interested in: " + reset);
                    newOpp.setQuantity(Integer.parseInt(scanner.nextLine().trim()));
                    Contact newContact = new Contact(lead.getName(), lead.getPhoneNumber(), lead.getEmail(), lead.getCompanyName()); // Converts lead into contact
                    newOpp.setDecisionMaker(newContact); // Assigns contact as the decisionMaker
                    theContacts.put(newContact.getId(), newContact);  // Adds contact to contact Map
                    theOpportunities.put(newOpp.getId(), newOpp); // Adds Opportunity to opportunities map
                    theLeads.remove(lead.getId()); // Removes converted lead from Leads map ("Database")
                    System.out.println(colorMain + "\n ═════════════ New Opportunity Created ═════════════\n");
                    System.out.println(theOpportunities.get(newOpp.getId()));
                    System.out.println(colorInput + "\nPress enter to continue..." + reset);
                    scanner2.nextLine();
                    System.out.println(colorMain + "\n═════════════ New Contact Created ═════════════\n");
                    System.out.println(theContacts.get(newContact.getId()));
                    System.out.println(colorInput + "\nPress enter to continue..." + reset);
                    scanner2.nextLine();
                    return newOpp;
                    //createAccount(newContact, newOpp); // Not sure whether to put this here or in Menu
                }
                case "n" -> {// Should return to main menu here
                    System.out.println(colorError + "You said no" + reset);
                    OS();
                }
                default -> throw new IllegalArgumentException(colorError + "Invalid input - please start again" + reset);
            }
        } catch (Exception e) {

            System.out.println(colorError + "\n***Invalid input - please start again***\n" + reset);
            convertLead(id); // Catches errors and returns to start of method - Is there a simple alternative?
        }
        return null;
    }

    // Method called to create a new account
    public Account createAccount(Opportunity opportunity) {
        System.out.println(colorMain + "\n═════════════ Account Creation ═════════════\n");
        Scanner scanner = new Scanner(System.in);
        try {

            Account newAccount = new Account(opportunity.getDecisionMaker(), opportunity);

            System.out.println(colorInput + "Please input the company industry: \n" +
                                       "PRODUCE\n" +
                                       "ECOMMERCE\n" +
                                       "MANUFACTURING\n" +
                                       "MEDICAL\n" +
                                       "OTHER\n" + reset);
            newAccount.setIndustry(Industry.valueOf(scanner.nextLine().trim().toUpperCase(Locale.ROOT))); // ENUM Selection
            System.out.println(colorInput + "\nPlease input the employee count for " + newAccount.getCompanyName() + ":  " + reset); //**Needs amending to display name in contact list
            newAccount.setEmployeeCount(Integer.parseInt(scanner.nextLine().trim()));
            System.out.println(colorInput + "\nPlease input the city for " + newAccount.getCompanyName() + ":  " + reset);
            newAccount.setCity(scanner.nextLine().trim());
            System.out.println(colorInput + "\nPlease input the Country for " + newAccount.getCompanyName() + ":  " + reset);
            newAccount.setCountry(scanner.nextLine().trim());
            theAccounts.put(newAccount.getId(), newAccount); // Adds new account to Accounts Map (database)
            System.out.println(colorMain + "\n ═════════════ New Account Created ═════════════\n");
            System.out.println(theAccounts.get(newAccount.getId()));
            return newAccount;
        } catch (Exception e) {

            System.out.println(colorError + "\n***Invalid input - please start again***\n" + reset);
            createAccount(opportunity); // Catches errors and returns to start of method - Is there a better way??
        }
        return null;
    }

    public void showLeads() {
        System.out.println(colorMain + "\n═════════════ Total Number Of Leads: " + theLeads.size() + " ═════════════\n" + reset);
        for (String key : theLeads.keySet()) {
            System.out.println(colorMain + "ID: " + key + "  ║  Name: " + theLeads.get(key).getName() + reset);
        }
    }

    public void showContacts() {
        System.out.println(colorMain + "\n═════════════ Total Number Of Contacts: " + theContacts.size() + " ═════════════\n" + reset);
        for (String key : theContacts.keySet()) {
            System.out.println(colorMain + "ID: " + key + "  ║  Name: " + theContacts.get(key).getName() +
                                       "  ║  Company Name: " + theContacts.get(key).getCompanyName() + reset);
        }
    }

    public static void showOpportunities() {
        System.out.println(colorMain + "\n═════════════ Total Number Of Opportunities: " + theOpportunities.size() + " ═════════════\n" + reset);
        for (String key : theOpportunities.keySet()) {
            System.out.println(colorMain + "ID: " + key +
                                       "  ║  Contract status: " + theOpportunities.get(key).getStatus() +
                                       "  ║  Product: " + theOpportunities.get(key).getProduct() +
                                       "  ║  Quantity: " + theOpportunities.get(key).getQuantity() +
                                       "  ║  Decision maker: " + theOpportunities.get(key).getDecisionMaker().getName() + reset);
        }
    }

    public static void showAccounts() {
        System.out.println(colorMain + "\n ═════════════ Total Number Of Accounts: " + theAccounts.size() + " ═════════════\n" + reset);
        for (String key : theAccounts.keySet()) {
            System.out.println(colorMain + "ID: " + key + "  ║  Name: " + theAccounts.get(key).getCompanyName() + reset);
        }
    }


    public Lead lookUpLeadId(String id) throws RuntimeException {
        return theLeads.get(id);
    }

    //look up opportunity by Id
    public Opportunity lookUpOppId(String id) throws RuntimeException {
        return theOpportunities.get(id);
    }

    //Change opportunity status
    public void changeOppStatus(String id) {
        Opportunity opp = theOpportunities.get(id);
        System.out.println(colorInput + "\nWould you like to change the status of this opportunity?   y / n\n" +
                                        opp + reset);
        Scanner scanner = new Scanner(System.in);
        try {
            switch (scanner.nextLine().trim().toLowerCase(Locale.ROOT)) {
                case "y": {
                    System.out.println(colorInput + "\nPlease select the status you would like to change to?\n " +
                                               "OPEN, CLOSED_WON, CLOSED_LOST\n" + reset);           //Do we want to keep open option?
                    opp.setStatus(Status.valueOf(scanner.nextLine().trim().toUpperCase(Locale.ROOT)));
                    System.out.println(colorMain + "\n═════════════ Status Changed! ═════════════" + reset);
                }
                break;
                case "n": {
                    System.out.println(colorError + "You said no" + reset);
                    OS();
                }
                break;

                default:
                    throw new IllegalArgumentException(colorError + "Invalid input - please try again" + reset);
            }

        } catch (Exception e) {
            System.out.println(colorError + "\n***Invalid input - please start again***\n" + reset);
            changeOppStatus(id);
        }
    }
}


