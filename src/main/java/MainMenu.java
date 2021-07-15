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

    private String name;
    Scanner scanner = new Scanner(System.in);

    public MainMenu(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Method to create a new lead
    public void newLead() {

        System.out.println("Would you like to create a new lead?   y / n ");
        try {
            switch (scanner.nextLine().trim()) {
                case "Y":
                case "y": {
                    Lead newLead = new Lead();
                    System.out.println("Please input the customers name: ");
                    newLead.setName(scanner.nextLine().trim());
                    if (newLead.getName().isEmpty()){
                        throw new IllegalArgumentException("No name input");
                    }
                    System.out.println("Please input the customers phone number: ");
                    newLead.setPhoneNumber(scanner.nextLine().trim());
                    if (newLead.getPhoneNumber().isEmpty()){
                        throw new IllegalArgumentException("No PhoneNumber input");
                    }
                    System.out.println("Please input the customers email address: ");
                    newLead.setEmail(scanner.nextLine().trim());
                    if (newLead.getEmail().isEmpty()){
                        throw new IllegalArgumentException("No email input");
                    }
                    System.out.println("Please input the customers company name: ");
                    newLead.setCompanyName(scanner.nextLine().trim());
                    if (newLead.getCompanyName().isEmpty()){
                        throw new IllegalArgumentException("No name input");
                    }
                    theLeads.put(newLead.getId(), newLead);
                    System.out.println(theLeads.get(newLead.getId()));
                    break;
                }
                case "N":
                case "n": {
                    // Would normally go back in the menu at this point
                    System.out.println("You said no");
                    break;
                }
                default:
                    throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {

            System.out.println("Invalid input - please start again");
            newLead();
        }
    }

    // Method to convert Lead to Opportunity
    public void convertLead(String id) {


        Lead lead = theLeads.get(id);
        System.out.println("Would you like to convert lead " + lead.getCompanyName()  + " into an opportunity?    y / n ");
        Scanner scanner = new Scanner(System.in);
        try {
            switch (scanner.nextLine().trim()) {
                case "Y":
                case "y": {
                    Opportunity newOpp = new Opportunity();
                    System.out.println("Please input the product that " + lead.getCompanyName() + " is interested in: \n " +
                            "HYBRID, FLATBED OR BOX");
                    newOpp.setTruck(Truck.valueOf(scanner.nextLine().trim().toUpperCase(Locale.ROOT)));
                    System.out.println("Please input the quantity that " + lead.getCompanyName()  + " is interested in: ");
                    newOpp.setQuantity(Integer.parseInt(scanner.nextLine().trim()));
                    Contact newContact = new Contact(lead.getName(),lead.getPhoneNumber(), lead.getEmail(), lead.getCompanyName()); // Converts lead into contact
                    newOpp.setDecisionMaker(newContact); // Assigns contact as the decisionMaker
                    theContacts.put(newContact.getId(), newContact);  // Adds contact to contact Map
                    theOpportunities.put(newOpp.getId(), newOpp); // Adds Opportunity to opportunities map
                    theLeads.remove(lead.getId()); // Removes converted lead from Leads map ("Database")
                    // createAccount(newContact, newOpp); // Not sure whether to put this here or in Menu
                    break;
                }
                case "N":
                case "n": {
                    System.out.println("You said no");
                    // Should return to main menu here
                    break;
                }
                default:
                    throw new IllegalArgumentException("Invalid input - please start again");
            }
        } catch (Exception e) {

            System.out.println("Invalid input - please start again");
            convertLead(id); // Catches errors and returns to start of method - Is there a simple alternative?
        }

    }

    // Method called to create a new account
    public void createAccount(Contact contact, Opportunity opportunity) {

        Scanner scanner = new Scanner(System.in);
        try {

            Account newAccount = new Account(contact, opportunity);

            System.out.println("Please input the company industry: \n" + "PRODUCE, ECOMMERCE, " +
                    "MANUFACTURING, MEDICAL, OTHER");
            newAccount.setIndustry(Industry.valueOf(scanner.nextLine().trim().toUpperCase(Locale.ROOT))); // ENUM Selection
            System.out.println("Please input the employee count for " + newAccount.getCompanyName() +":  "); //**Needs amending to display name in contact list
            newAccount.setEmployeeCount(Integer.parseInt(scanner.nextLine().trim()));
            System.out.println("Please input the city for " + newAccount.getCompanyName() +":  ");
            newAccount.setCity(scanner.nextLine().trim());
            System.out.println("Please input the Country for " + newAccount.getCompanyName() +":  ");
            newAccount.setCountry(scanner.nextLine().trim());
            theAccounts.put(newAccount.getId(), newAccount); // Adds new account to Accounts Map (database)
        } catch (Exception e) {

            System.out.println("Invalid input - please start again");
            createAccount(contact, opportunity); // Catches errors and returns to start of method - Is there a better way??
        }
    }

    public void showLeads(){
        for (String key : theLeads.keySet()){
            System.out.println("ID: " + key + " Name: " + theLeads.get(key).getName() );
        }
    }

    public Lead lookUpLeadId(String id) throws RuntimeException{
        return (Lead) theLeads.get(id);
    }


}

