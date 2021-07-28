import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.List;


public class MainMenu {

    public static Map<String, Lead> theLeads = new HashMap<>();
    public static Map<String, Account> theAccounts = new HashMap<>();
    public static Map<String, Contact> theContacts = new HashMap<>();
    public static Map<String, Opportunity> theOpportunities = new HashMap<>();

    Scanner scanner = new Scanner(System.in);

    enum consoleTextColor {
        ANSI_BLACK("\033[0;30m"),
        ANSI_RED("\033[0;31m"),
        ANSI_GREEN("\033[0;32m"),
        ANSI_YELLOW("\033[0;33m"),
        ANSI_BLUE("\033[0;34m"),
        ANSI_PURPLE("\033[0;35m"),
        ANSI_CYAN("\033[0;36m"),
        ANSI_WHITE("\033[0;37m"),
        ANSI_RESET("\u001B[0m"),
        BLACK_BOLD("\033[1;30m"),
        RED_BOLD("\033[1;31m"),
        GREEN_BOLD("\033[1;32m"),
        YELLOW_BOLD("\033[1;33m"),
        BLUE_BOLD("\033[1;34m"),
        PURPLE_BOLD("\033[1;35m"),
        CYAN_BOLD("\033[1;36m"),
        WHITE_BOLD("\033[1;37m");



        private final String color;

        consoleTextColor(String color) {
            this.color = color;
        }
    }

    private static final String colorMain = consoleTextColor.ANSI_YELLOW.color;
    private static final String colorMainBold = consoleTextColor.WHITE_BOLD.color;
    private static final String colorInput = consoleTextColor.CYAN_BOLD.color;
    private static final String colorHeadline = consoleTextColor.ANSI_BLUE.color;
    private static final String colorHeadlineBold = consoleTextColor.BLUE_BOLD.color;
    private static final String colorTable = consoleTextColor.GREEN_BOLD.color;
    private static final String colorError = consoleTextColor.ANSI_RED.color;
    private static final String colorLogo = consoleTextColor.ANSI_GREEN.color;
    private static final String reset = MainMenu.consoleTextColor.ANSI_RESET.color;
    private static boolean wasRun = false;

    public MainMenu() {

    }

    public void OS() throws RuntimeException, AWTException {

        System.out.println("\n" + colorHeadline + colorLogo
                                   + "                                                                                                \n" +
                                   "                                         *#### #####        ###################*   *####*         \n" +
                                   "                         #################### #####        ######################  #####          \n" +
                                   "                    ,######              ### #####        #####            ###### #####           \n" +
                                   "                  ####                  ### #####        #####    ############## #####            \n" +
                                   "                ####                   ### #####        #####      ###########  #####             \n" +
                                   "              ########################### #####        #####            ###### #####              \n" +
                                   "             ####################.###### ############ ###################### ############         \n" +
                                   "             ################ ####### # ############ #####################  ############          \n" + reset +
         colorHeadline + colorMain + "╔═══════════════════════════════════════════════════════════════════════════════════════════════════╗\n"
                                   + "║                                " + colorMainBold + "WELCOME TO LBL CRM SYSTEM" + colorMain + "                                          ║\n"
                                   + "╠═══════════════════════════════════════════════════════════════════════════════════════════════════╣\n"
                                   + "║     " + colorMainBold + "WHAT WOULD YOU LIKE TO DO?" + colorMain + "                                                                    ║\n"
                                   + "╠═══════════════════════════════════════════════════════════════════════════════════════════════════╣\n"
                                   + "║ 1.  To create new Lead " + colorHeadline + "- type: 'new lead'" + colorMain + "                                                         ║\n"
                                   + "║ 2.  To check Leads list " + colorHeadline + "- type: 'show leads'" + colorMain + "                                                      ║\n"
                                   + "║ 3.  To check individual Lead's details " + colorHeadline + "- type: 'lookup lead ' + Lead Id" + colorMain + "                           ║\n"
                                   + "║ 4.  To convert Lead into Opportunity " + colorHeadline + "- type: - 'convert ' + Lead Id" + colorMain + "                               ║\n"
                                   + "║ 5.  To check Opportunity list " + colorHeadline + "- type: 'show opportunities'" + colorMain + "                                        ║\n"
                                   + "║ 6.  To check individual Opportunity's details " + colorHeadline + "- type: 'lookup opportunity ' + Opportunity Id" + colorMain + "      ║\n"
                                   + "║ 7.  To change Opportunity status to WON" + colorHeadline + "- type: 'close-won' + Opportunity Id" + colorMain + "                       ║\n"
                                   + "║ 8.  To change Opportunity status to LOST" + colorHeadline + "- type: 'close-lost' + Opportunity Id" + colorMain + "                     ║\n"
                                   + "║ 9.  To check Contact list " + colorHeadline + "- type: 'show contacts'" + colorMain + "                                                 ║\n"
                                   + "║ 10. To check Account list " + colorHeadline + "- type: 'show accounts'" + colorMain + "                                                 ║\n"
                                   + "║ 11. To quit " + colorHeadline + "- type: 'quit'" + colorMain + "                                                                        ║\n"
                                   + "╚═══════════════════════════════════════════════════════════════════════════════════════════════════╝\n" + reset);

        conoleFocusRunOnce();

        try {

            // Creates String array from scanner input
            String[] input = scanner.nextLine().trim().toLowerCase().split("\\s+");

            if (input[0].equals("quit")) {
                System.out.println(colorMainBold + "\nThank you for using our LBL CRM SYSTEM!" + reset);
                throw new RuntimeException(colorError + "Exiting the program" + reset);
            } else if (input[0].equals("lookup") && input[1].equals("lead")) {
                System.out.println(lookUpLeadId(input[2]).toString());
            } else if (input[0].equals("lookup") && input[1].equals("opportunity")) {
                System.out.println(lookUpOppId(input[2]).toString());
            } else if (input[0].equals("convert")) { // throws null point exception if number not in array
                createAccount(convertLead(input[1]));
            } else if (input[0].equals("close-lost")) {
                closeLost(input[1]);
            } else if (input[0].equals("close-won")) {
                closeWon(input[1]);
            } else if (input.length < 2) {
                throw new IllegalArgumentException();
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
        System.out.println(colorInput + "\nPress Enter to continue..." + reset);
        scanner.nextLine();
        OS();

    }


    // Method to create a new lead
    public Lead newLead() {

        System.out.println(colorInput + "\nWould you like to create a new lead?" + colorTable +"   y / n " + reset);
        try {
            switch (scanner.nextLine().trim().toLowerCase(Locale.ROOT)) {
                case "y" -> {
                    Lead newLead = new Lead();
                    //System.out.println(colorInput + "\nPlease input the customers name: " + reset);
                    String name;
                    String number;
                    String email;
                    String comName;
                    do {
                        System.out.println(colorInput + "\nPlease input the customers name: " + reset);
                        name = scanner.nextLine().trim();
                        newLead.setName(name);
                        if (!isValidName(name)) {
                            System.out.println(colorError + "Invalid name input. Please, try again" + reset);
                        }
                    } while (!isValidName(name));

                    do{
                        System.out.println(colorInput + "\nPlease input the customers phone number: " + reset);
                        number = scanner.nextLine().trim();
                        newLead.setPhoneNumber(number);
                        if (number.isEmpty()) {
                        System.out.println(colorError + "Please, provide phone number" + reset);
                        }
                    } while (number.isEmpty());
                    do{
                        System.out.println(colorInput + "\nPlease input the customers email address: " + reset);
                        email = scanner.nextLine().trim();
                        newLead.setEmail(email);
                        if (!isValidEmail(email)) {
                        System.out.println(colorError + "Invalid email format. Please, try again" + reset);
                        }
                    } while (!isValidEmail(email));
                    do{
                        System.out.println(colorInput + "\nPlease input the customers company name: " + reset);
                        comName = scanner.nextLine().trim();
                        newLead.setCompanyName(comName);
                        if (comName.isEmpty()) {
                        System.out.println(colorError + "No name input" + reset);
                        }
                    } while (comName.isEmpty());
                    theLeads.put(newLead.getId(), newLead);
                    System.out.println(colorMain + "\n╔════════════╦═════ " + colorMainBold + "New Lead created" + colorMain + " ══════════════════════╦══════════════════════╦══════════════════════════════════════════╦═════════════════════════════════════════════╗" + reset);
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
        System.out.println(colorInput + "\nWould you like to convert " +
                           colorTable + lead.getName() +
                           colorInput + " from " +
                           colorTable + lead.getCompanyName() +
                           colorInput + " into an opportunity?" +
                           colorTable + "    y / n " + reset);
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        try {
            switch (scanner.nextLine().trim().toLowerCase(Locale.ROOT)) {
                case "y" -> {
                    Opportunity newOpp = new Opportunity();
                    System.out.println(colorInput + "\nPlease input the product that " + colorTable + lead.getCompanyName() + colorInput + " is interested in: \n " +
                                       colorTable + "HYBRID, FLATBED OR BOX" + reset);
                    newOpp.setTruck(Truck.valueOf(scanner.nextLine().trim().toUpperCase(Locale.ROOT)));
                    System.out.println(colorInput + "\nPlease input the quantity that " + colorTable + lead.getCompanyName() + colorInput + " is interested in: " + reset);
                    newOpp.setQuantity(Integer.parseInt(scanner.nextLine().trim()));
                    Contact newContact = new Contact(lead.getName(), lead.getPhoneNumber(), lead.getEmail(), lead.getCompanyName()); // Converts lead into contact
                    newOpp.setDecisionMaker(newContact); // Assigns contact as the decisionMaker
                    theContacts.put(newContact.getId(), newContact);  // Adds contact to contact Map
                    theOpportunities.put(newOpp.getId(), newOpp); // Adds Opportunity to opportunities map
                    theLeads.remove(lead.getId()); // Removes converted lead from Leads map ("Database")
                    System.out.println(colorMain + "\n╔════════════╦═════ " + colorMainBold + "New Opportunity created" + colorMain + " ════════════╦═══════════════════╗" + reset);
                    System.out.printf("%-1s %-17s %-1s %-27s %-1s %-24s %-1s %-24s %-1s\n",
                                      colorMain + "║",
                                      colorHeadlineBold + "ID",
                                      colorMain + "║",
                                      colorHeadlineBold + "Status",
                                      colorMain + "║",
                                      colorHeadlineBold + "Product",
                                      colorMain + "║",
                                      colorHeadlineBold + "Quantity",
                                      colorMain + "║\n" +
                                      colorMain + "╠════════════╬══════════════════════╬═══════════════════╬═══════════════════╣");
                    System.out.println(theOpportunities.get(newOpp.getId()));
                    System.out.println(colorInput + "Press Enter to continue..." + reset);
                    scanner2.nextLine();
                    System.out.println(colorMain + "╔════════════╦═════ " + colorMainBold + "New Contact created" + colorMain + " ═══════════════════╦══════════════════════╦══════════════════════════════════════════╦═════════════════════════════════════════════╗" + reset);
                    System.out.printf(String.format("%-1s %-17s %-1s %-50s %-1s %-27s %-1s %-47s %-1s %-50s %-1s\n",
                                                    colorMain + "║",
                                                    colorHeadlineBold + "ID",
                                                    colorMain + "║",
                                                    colorHeadlineBold + "Name",
                                                    colorMain + "║",
                                                    colorHeadlineBold + "Phone Number",
                                                    colorMain + "║",
                                                    colorHeadlineBold + "Email Address",
                                                    colorMain + "║",
                                                    colorHeadlineBold + "Company name",
                                                    colorMain + "║\n" +
                                                    colorMain + "╠════════════╬═════════════════════════════════════════════╬══════════════════════╬══════════════════════════════════════════╬═════════════════════════════════════════════╣" + reset));
                    System.out.println(theContacts.get(newContact.getId()));
                    System.out.println(colorInput + "Press Enter to continue..." + reset);
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
        System.out.println(colorMain + "\n═════════════ " + colorMainBold + "Creating new Account" + colorMain + " ═════════════\n");
        Scanner scanner = new Scanner(System.in);
        String country;
        try {

            Account newAccount = new Account(opportunity.getDecisionMaker(), opportunity);

            System.out.println(colorInput + "Please input the company industry: \n" +
                               colorTable + "PRODUCE, ECOMMERCE, MANUFACTURING, MEDICAL OR OTHER" + reset);
            newAccount.setIndustry(Industry.valueOf(scanner.nextLine().trim().toUpperCase(Locale.ROOT))); // ENUM Selection
            System.out.println(colorInput + "\nPlease input the employee count for " + colorTable + newAccount.getCompanyName() + colorInput + ":  " + reset); //**Needs amending to display name in contact list
            newAccount.setEmployeeCount(Integer.parseInt(scanner.nextLine().trim()));
            System.out.println(colorInput + "\nPlease input the city for " + colorTable + newAccount.getCompanyName() + colorInput + ":  " + reset);
            newAccount.setCity(scanner.nextLine().trim().toUpperCase(Locale.ROOT));
            do{
                System.out.println(colorInput + "\nPlease input the Country for " + colorTable + newAccount.getCompanyName() + colorInput + ":  " + reset);
                country = scanner.nextLine().trim().toUpperCase(Locale.ROOT);
                newAccount.setCountry(country);
                if(isValidCountry(country)){
                    System.out.println(colorError + "Invalid country. Please, try again" + reset);
                }
            } while (isValidCountry(country));
            theAccounts.put(newAccount.getId(), newAccount); // Adds new account to Accounts Map (database)
            //System.out.println(colorMain + "\n ═════════════ New Account Created ═════════════\n");
            System.out.println(theAccounts.get(newAccount.getId()));
            return newAccount;
        } catch (Exception e) {

            System.out.println(colorError + "\n***Invalid input - please start again***\n" + reset);
            createAccount(opportunity); // Catches errors and returns to start of method - Is there a better way??
        }
        return null;
    }

    public void showLeads() {
        System.out.println(colorMain + "\n╔════════════╦═══ " + colorMainBold + "Total Number Of Leads: " + theLeads.size() + colorMain + " ════════════════╗" + reset);
        System.out.printf("%-1s %-17s %-1s %-50s %-1s\n",
                          colorMain + "║",
                          colorHeadlineBold + "ID",
                          colorMain + "║",
                          colorHeadlineBold + "Name",
                          colorMain + "║");
        System.out.printf("%-1s%-12s%-1s%-45s%-1s\n",
                          colorMain + "╠",
                          "════════════",
                          "╬",
                          "═════════════════════════════════════════════",
                          "╣" + reset);
        for (String key : theLeads.keySet()) {
            System.out.printf("%-1s %-17s %-1s %-50s %-1s\n",
                              colorMain + "║",
                              colorTable + key,
                              colorMain + "║",
                              colorTable + theLeads.get(key).getName(),
                              colorMain + "║" + reset);
        }
    }

    public void showContacts() {
        System.out.println(colorMain + "\n╔════════════╦════════ " + colorMainBold + "Total Number Of Contacts: " + theContacts.size() + colorMain + " ════════╦══════════════════════════════════════════╗" + reset);
        System.out.printf("%-1s %-17s %-1s %-50s %-1s %-47s %-1s\n",
                          colorMain + "║",
                          colorHeadlineBold + "ID",
                          colorMain + "║",
                          colorHeadlineBold + "Name",
                          colorMain + "║",
                          colorHeadlineBold + "Company name",
                          colorMain + "║");
        System.out.printf("%-1s%-12s%-1s%-45s%-1s%-32s%-1s\n",
                          colorMain + "╠",
                          "════════════",
                          "╬",
                          "═════════════════════════════════════════════",
                          "╬",
                          "══════════════════════════════════════════",
                          "╣" + reset);
        for (String key : theContacts.keySet()) {
            System.out.printf("%-1s %-17s %-1s %-50s %-1s %-47s %-1s\n",
                              colorMain + "║",
                              colorTable + key,
                              colorMain + "║",
                              colorTable + theContacts.get(key).getName(),
                              colorMain + "║",
                              colorTable + theContacts.get(key).getCompanyName(),
                              colorMain + "║" + reset);
        }
    }

    public static void showOpportunities() {
        System.out.println(colorMain + "\n╔════════════╦═════ " + colorMainBold + "Total Number Of Opportunities: " + theOpportunities.size() + colorMain + " ══════╦══════════════════════════════════════════╗" + reset);
        System.out.printf("%-1s %-17s %-1s %-24s %-1s %-17s %-1s %-17s %-1s %-47s %-1s\n",
                          colorMain + "║",
                          colorHeadlineBold + "ID",
                          colorMain + "║",
                          colorHeadlineBold + "Contract status",
                          colorMain + "║",
                          colorHeadlineBold + "Product",
                          colorMain + "║",
                          colorHeadlineBold + "Quantity",
                          colorMain + "║",
                          colorHeadlineBold + "Decision maker",
                          colorMain + "║");
        System.out.printf("%-1s%-12s%-1s%-19s%-1s%-12s%-1s%-12s%-1s%-42s%-1s\n",
                          colorMain + "╠",
                          "════════════",
                          "╬",
                          "═══════════════════",
                          "╬",
                          "════════════",
                          "╬",
                          "════════════",
                          "╬",
                          "══════════════════════════════════════════",
                          "╣" + reset);
        for (String key : theOpportunities.keySet()) {
            System.out.printf("%-1s %-17s %-1s %-24s %-1s %-17s %-1s %-17s %-1s %-47s %-1s\n",
                              colorMain + "║",
                              colorTable + key,
                              colorMain + "║",
                              colorTable + theOpportunities.get(key).getStatus(),
                              colorMain + "║",
                              colorTable + theOpportunities.get(key).getProduct(),
                              colorMain + "║",
                              colorTable + theOpportunities.get(key).getQuantity(),
                              colorMain + "║",
                              colorTable + theOpportunities.get(key).getDecisionMaker().getName(),
                              colorMain + "║" + reset);
        }
    }

    public static void showAccounts() {
        System.out.println(colorMain + "\n╔════════════╦═══ " + colorMainBold + "Total Number Of Accounts: " + theAccounts.size() + colorMain + " ═════════════╗" + reset);
        System.out.printf("%-1s %-17s %-1s %-50s %-1s\n",
                          colorMain + "║",
                          colorHeadlineBold + "ID",
                          colorMain + "║",
                          colorHeadlineBold + "Company name",
                          colorMain + "║");
        System.out.printf("%-1s%-12s%-1s%-45s%-1s\n",
                          colorMain + "╠",
                          "════════════",
                          "╬",
                          "═════════════════════════════════════════════",
                          "╣" + reset);
        for (String key : theAccounts.keySet()) {
            System.out.printf("%-1s %-17s %-1s %-50s %-1s\n",
                              colorMain + "║",
                              colorTable + key,
                              colorMain + "║",
                              colorTable + theAccounts.get(key).getCompanyName(),
                              colorMain + "║" + reset);
        }
    }


    public Lead lookUpLeadId(String id) throws RuntimeException {
        System.out.println(colorMain + "\n╔════════════╦═════ " + colorMainBold + "Lead details" + colorMain + " ══════════════════════════╦══════════════════════╦══════════════════════════════════════════╦═════════════════════════════════════════════╗" + reset);
        return theLeads.get(id);
    }

    //look up opportunity by Id
    public String lookUpOppId(String id) throws RuntimeException {
        System.out.println(colorMain + "\n╔════════════╦═══ " + colorMainBold + "Contract details" + colorMain + " ═╦═══════════════════╦═══════════════════╗" + reset);
        System.out.printf("%-1s %-17s %-1s %-27s %-1s %-24s %-1s %-24s %-1s\n",
                              colorMain + "║",
                              colorHeadlineBold + "ID",
                              colorMain + "║",
                              colorHeadlineBold + "Contract status",
                              colorMain + "║",
                              colorHeadlineBold + "Product",
                              colorMain + "║",
                              colorHeadlineBold + "Quantity",
                              colorMain + "║\n" +
                              colorMain + "╠════════════╬══════════════════════╬═══════════════════╬═══════════════════╣" + reset);
        return theOpportunities.get(id) +
                            colorMain + "\n╔════════════╦═══ " + colorMainBold + "Decision maker details" + colorMain + " ══════════════════╦══════════════════════╦══════════════════════════════════════════╦═════════════════════════════════════════════╗\n" + reset +
                            String.format("%-1s %-17s %-1s %-50s %-1s %-27s %-1s %-47s %-1s %-50s %-1s\n",
                              colorMain + "║",
                              colorHeadlineBold + "ID",
                              colorMain + "║",
                              colorHeadlineBold + "Name",
                              colorMain + "║",
                              colorHeadlineBold + "Phone Number",
                              colorMain + "║",
                              colorHeadlineBold + "Email Address",
                              colorMain + "║",
                              colorHeadlineBold + "Company name",
                              colorMain + "║\n" +
                                      colorMain + "╠════════════╬═════════════════════════════════════════════╬══════════════════════╬══════════════════════════════════════════╬═════════════════════════════════════════════╣\n"
                                      + reset +
                              theOpportunities.get(id).getDecisionMaker());
    }

    /*//Change opportunity status
    public void changeOppStatus(String id) {
        Opportunity opp = theOpportunities.get(id);
        System.out.println(colorMain + "\n╔════════════╦═════ " + colorMainBold + "Opportunity details" + colorMain + " ════════════════╦═══════════════════╗" + reset);
        System.out.printf("%-1s %-17s %-1s %-27s %-1s %-24s %-1s %-24s %-1s\n",
                          colorMain + "║",
                          colorHeadlineBold + "ID",
                          colorMain + "║",
                          colorHeadlineBold + "Status",
                          colorMain + "║",
                          colorHeadlineBold + "Product",
                          colorMain + "║",
                          colorHeadlineBold + "Quantity",
                          colorMain + "║\n" +
                                  colorMain + "╠════════════╬══════════════════════╬═══════════════════╬═══════════════════╣");
        System.out.println(opp);
        System.out.println(colorInput + "Would you like to change the status of this opportunity?" + colorTable + "   y / n" + reset);
        Scanner scanner = new Scanner(System.in);
        try {
            switch (scanner.nextLine().trim().toLowerCase(Locale.ROOT)) {
                case "y": {
                    System.out.println(colorInput + "\nPlease select the status you would like to change to?\n" +
                                               colorTable + "OPEN, CLOSED_WON, CLOSED_LOST" + reset);           //Do we want to keep open option?
                    opp.setStatus(Status.valueOf(scanner.nextLine().trim().toUpperCase(Locale.ROOT)));
                    System.out.println(colorMain + "\n═════════════ " + colorMainBold + "Status Changed!" + colorMain + " ═════════════" + reset);
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
    }*/

    //Change opportunity status to LOST
    public void closeLost(String id) {
        Opportunity opp = theOpportunities.get(id);
        System.out.println(colorMain + "\n╔════════════╦═════ " + colorMainBold + "Opportunity details" + colorMain + " ════════════════╦═══════════════════╗" + reset);
        System.out.printf("%-1s %-17s %-1s %-27s %-1s %-24s %-1s %-24s %-1s\n",
                          colorMain + "║",
                          colorHeadlineBold + "ID",
                          colorMain + "║",
                          colorHeadlineBold + "Status",
                          colorMain + "║",
                          colorHeadlineBold + "Product",
                          colorMain + "║",
                          colorHeadlineBold + "Quantity",
                          colorMain + "║\n" +
                                  colorMain + "╠════════════╬══════════════════════╬═══════════════════╬═══════════════════╣");
        System.out.println(opp);
        System.out.println(colorInput + "Would you like to change the status of this opportunity to " + colorTable + "LOST?   y / n" + reset);
        Scanner scanner = new Scanner(System.in);
        try {
            switch (scanner.nextLine().trim().toLowerCase(Locale.ROOT)) {
                case "y": {
                    opp.setStatus(Status.CLOSED_LOST);
                    System.out.println(colorMain + "\n═════════════ " + colorMainBold + "Status Changed!" + colorMain + " ═════════════" + reset);
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
            closeLost(id);
        }
    }

    public void consoleFocus() throws AWTException {
        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_4);
        robot.keyRelease(KeyEvent.VK_4);
        robot.keyRelease(KeyEvent.VK_ALT);
    }

    public void conoleFocusRunOnce() throws AWTException {
        if (!wasRun) {
            wasRun = true;
            consoleFocus();
        }
    }

    //Change opportunity status to Won
    public void closeWon(String id) {
        Opportunity opp = theOpportunities.get(id);
        System.out.println(colorMain + "\n╔════════════╦═════ " + colorMainBold + "Opportunity details" + colorMain + " ════════════════╦═══════════════════╗" + reset);
        System.out.printf("%-1s %-17s %-1s %-27s %-1s %-24s %-1s %-24s %-1s\n",
                          colorMain + "║",
                          colorHeadlineBold + "ID",
                          colorMain + "║",
                          colorHeadlineBold + "Status",
                          colorMain + "║",
                          colorHeadlineBold + "Product",
                          colorMain + "║",
                          colorHeadlineBold + "Quantity",
                          colorMain + "║\n" +
                                  colorMain + "╠════════════╬══════════════════════╬═══════════════════╬═══════════════════╣");
        System.out.println(opp);
        System.out.println(colorInput + "Would you like to change the status of this opportunity to " + colorTable + "WON?   y / n" + reset);
        Scanner scanner = new Scanner(System.in);
        try {
            switch (scanner.nextLine().trim().toLowerCase(Locale.ROOT)) {
                case "y": {
                    opp.setStatus(Status.CLOSED_WON);
                    System.out.println(colorMain + "\n═════════════ " + colorMainBold + "Status Changed!" + colorMain + " ═════════════" + reset);
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
            closeLost(id);
        }
    }

    //Email format validation
    public static boolean isValidEmail(String email){
        return email.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$");
    }

    //Country name validation
    public static boolean isValidCountry(String country){
        List<String> countries = new ArrayList<>();

        // retrieve the list of countries and populate country names
        String[] isoCountries = Locale.getISOCountries();
        for (String code : isoCountries) {
            Locale locale = new Locale("en", code);
            String name = locale.getDisplayCountry().toUpperCase(Locale.ROOT);

            if (!"".equals(name)) {
                countries.add(name);
            }
        }

        return !countries.contains(country);
    }

    //Name input validation (contains only alphabetic characters)
    public static boolean isValidName(String name){
        return name.matches("^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$");
    }
}


