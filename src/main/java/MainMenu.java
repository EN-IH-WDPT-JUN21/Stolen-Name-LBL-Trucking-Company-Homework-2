import java.util.Locale;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

public class MainMenu {

    public static Map<String, Lead> theLeads = new HashMap<>();
    public static Map<String, Account> theAccounts = new HashMap<>();
    public static Map<String, Contact> theContacts = new HashMap<>();
    public static Map<String, Opportunity> theOpportunities = new HashMap<>();

    Scanner scanner = new Scanner(System.in);

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

    private static String color = MainMenu.consoleTextColor.ANSI_GREEN.color;
    private static String reset = MainMenu.consoleTextColor.ANSI_RESET.color;

    public MainMenu() {

    }

    public void OS() throws RuntimeException{

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
                + "║ 5. To check Opportunity list - type: 'Show Opportunities'                    ║\n"
                + "║ 6. To check Contact list - type: - 'Show Contacts'                           ║\n"
                + "║ 7. To check Account list - type: - 'Show Accounts'                           ║\n"
                + "║ 8. To quit - type: - 'Quit'                                                  ║\n"
                + "╚══════════════════════════════════════════════════════════════════════════════╝\n"
        );

        try {

            // Creates String array from scanner input
            String[] input = scanner.nextLine().trim().toLowerCase().split("\\s+");

            if (input[0].equals("quit")) {
                System.out.println("Thank you for using our LBL CRM SYSTEM!");
                throw new RuntimeException("Exiting the program");
            } else if (input[0].equals("lookup") && input[1].equals("lead")) {
                System.out.println(lookUpLeadId(input[2]).toString());
            } else if (input.length < 2) {
                throw new IllegalArgumentException();
            } else if (input[0].equals("convert")) { // throws null point exception if number not in array
                createAccount(convertLead(input[1]));
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
            System.out.println("Invalid input");

        }
        System.out.println("\n Press enter to return to the main menu");
        scanner.nextLine();
        OS();

    }


    // Method to create a new lead
    public Lead newLead() {

        System.out.println("Would you like to create a new lead?   y / n ");
        try {
            switch (scanner.nextLine().trim()) {
                case "Y", "y" -> {
                    Lead newLead = new Lead();
                    System.out.println("Please input the customers name: ");
                    newLead.setName(scanner.nextLine().trim());
                    if (newLead.getName().isEmpty()) {
                        throw new IllegalArgumentException("No name input");
                    }
                    System.out.println("Please input the customers phone number: ");
                    newLead.setPhoneNumber(scanner.nextLine().trim());
                    if (newLead.getPhoneNumber().isEmpty()) {
                        throw new IllegalArgumentException("No PhoneNumber input");
                    }
                    System.out.println("Please input the customers email address: ");
                    newLead.setEmail(scanner.nextLine().trim());
                    if (newLead.getEmail().isEmpty()) {
                        throw new IllegalArgumentException("No email input");
                    }
                    System.out.println("Please input the customers company name: ");
                    newLead.setCompanyName(scanner.nextLine().trim());
                    if (newLead.getCompanyName().isEmpty()) {
                        throw new IllegalArgumentException("No name input");
                    }
                    theLeads.put(newLead.getId(), newLead);
                    System.out.println("\n═════════════ New Lead Created ═════════════\n");
                    System.out.println(theLeads.get(newLead.getId()));
                    return newLead;
                }
                case "N", "n" -> // Would normally go back in the menu at this point
                        System.out.println("You said no");
                default -> throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {

            System.out.println("\n***Invalid input - please start again***\n");
            newLead();
        }
        return null;
    }

    // Method to convert Lead to Opportunity
    public Opportunity convertLead(String id) throws NullPointerException {

        Lead lead = theLeads.get(id);
        System.out.println("Would you like to convert " + lead.getName() + " from: " + lead.getCompanyName() +
                " into an opportunity?    y / n ");
        Scanner scanner = new Scanner(System.in);
        try {
            switch (scanner.nextLine().trim()) {
                case "Y", "y" -> {
                    Opportunity newOpp = new Opportunity();
                    System.out.println("Please input the product that " + lead.getCompanyName() + " is interested in: \n " +
                            "HYBRID, FLATBED OR BOX");
                    newOpp.setTruck(Truck.valueOf(scanner.nextLine().trim().toUpperCase(Locale.ROOT)));
                    System.out.println("Please input the quantity that " + lead.getCompanyName() + " is interested in: ");
                    newOpp.setQuantity(Integer.parseInt(scanner.nextLine().trim()));
                    Contact newContact = new Contact(lead.getName(), lead.getPhoneNumber(), lead.getEmail(), lead.getCompanyName()); // Converts lead into contact
                    newOpp.setDecisionMaker(newContact); // Assigns contact as the decisionMaker
                    theContacts.put(newContact.getId(), newContact);  // Adds contact to contact Map
                    theOpportunities.put(newOpp.getId(), newOpp); // Adds Opportunity to opportunities map
                    theLeads.remove(lead.getId()); // Removes converted lead from Leads map ("Database")
                    System.out.println("\n ═════════════ New Opportunity Created ═════════════\n");
                    System.out.println(theOpportunities.get(newOpp.getId()));
                    System.out.println("\n═════════════ New Contact Created ═════════════\n");
                    System.out.println(theContacts.get(newContact.getId()));
                    return newOpp;
                    //createAccount(newContact, newOpp); // Not sure whether to put this here or in Menu
                }
                case "N", "n" -> // Should return to main menu here
                        System.out.println("You said no");
                default -> throw new IllegalArgumentException("Invalid input - please start again");
            }
        } catch (Exception e) {

            System.out.println("\n***Invalid input - please start again***\n");
            convertLead(id); // Catches errors and returns to start of method - Is there a simple alternative?
        }
        return null;
    }

    // Method called to create a new account
    public Account createAccount(Opportunity opportunity) {
        System.out.println("\n═════════════ Account Creation ═════════════\n");
        Scanner scanner = new Scanner(System.in);
        try {

            Account newAccount = new Account(opportunity.getDecisionMaker(), opportunity);

            System.out.println("Please input the company industry: \n" + "PRODUCE, ECOMMERCE, " +
                    "MANUFACTURING, MEDICAL, OTHER");
            newAccount.setIndustry(Industry.valueOf(scanner.nextLine().trim().toUpperCase(Locale.ROOT))); // ENUM Selection
            System.out.println("Please input the employee count for " + newAccount.getCompanyName() + ":  "); //**Needs amending to display name in contact list
            newAccount.setEmployeeCount(Integer.parseInt(scanner.nextLine().trim()));
            System.out.println("Please input the city for " + newAccount.getCompanyName() + ":  ");
            newAccount.setCity(scanner.nextLine().trim());
            System.out.println("Please input the Country for " + newAccount.getCompanyName() + ":  ");
            newAccount.setCountry(scanner.nextLine().trim());
            theAccounts.put(newAccount.getId(), newAccount); // Adds new account to Accounts Map (database)
            System.out.println("\n ═════════════ New Account Created ═════════════\n");
            System.out.println(theAccounts.get(newAccount.getId()));
            return newAccount;
        } catch (Exception e) {

            System.out.println("\n***Invalid input - please start again***\n");
            createAccount(opportunity); // Catches errors and returns to start of method - Is there a better way??
        }
        return null;
    }

    public void showLeads() {
        System.out.println("\n═════════════ Total Number Of Leads: " + theLeads.size() + " ═════════════\n");
        for (String key : theLeads.keySet()) {
            System.out.println("ID: " + key + "  |  Name: " + theLeads.get(key).getName());
        }
    }

    public void showContacts() {
        System.out.println("\n═════════════ Total Number Of Contacts: " + theContacts.size() + " ═════════════\n");
        for (String key : theContacts.keySet()) {
            System.out.println("ID: " + key + "  |  Name: " + theContacts.get(key).getName());
        }
    }

    public static void showOpportunities() {
        System.out.println("\n═════════════ Total Number Of Opportunities: " + theOpportunities.size() + " ═════════════\n");
        for (String key : theOpportunities.keySet()) {
            System.out.println("ID: " + key +
                               "  ║  Contract status: " + theOpportunities.get(key).getStatus() +
                               "  ║  Product: " + theOpportunities.get(key).getProduct() +
                               "  ║  Quantity: " + theOpportunities.get(key).getQuantity() +
                               "  ║  Decision maker: " + theOpportunities.get(key).getDecisionMaker().getName());
        }
    }

    public static void showAccounts() {
        System.out.println("\n ═════════════ Total Number Of Accounts: " + theAccounts.size() + " ═════════════\n");
        for (String key : theAccounts.keySet()) {
            System.out.println("ID: " + key + "  |  Name: " + theAccounts.get(key).getCompanyName());
        }
    }


    public Lead lookUpLeadId(String id) throws RuntimeException {
        return theLeads.get(id);
    }


}

