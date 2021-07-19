//For creating basic Leads. Extends Client information in order to retain a unique ID counter.

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Lead extends ClientInformation {

    protected String name;
    protected String phoneNumber;
    protected String email;
    protected String companyName;
    public static Map<String, Lead> theLeads = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public Lead() {
    }

    public Lead(String name, String phoneNumber, String email, String companyName) {
        setName(name);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setCompanyName(companyName);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    // Method to create a new lead
    public static void newLead() {

        try {
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
                throw new IllegalArgumentException("No Company Name input");
            }
            int count = theLeads.size();
            theLeads.put(newLead.getId(), newLead);
            if (theLeads.size() > count) {
                System.out.println(theLeads.get(newLead.getId()));
            }

        } catch (IllegalArgumentException e) {

            System.out.println("Invalid input - please start again");
            newLead();
        }
    }

    public static void showLeads(){
        System.out.println("═════════════ Total Number Of Leads: " + theLeads.size() + " ═════════════");
        for (String key : theLeads.keySet()){
            System.out.println("ID: " + key + " Name: " + theLeads.get(key).getName() );
        }
    }

    // Method to convert Lead to Opportunity
    public static void convertLead(String id) {

        Lead lead = theLeads.get(id);
        System.out.println("Would you like to convert: " + lead.getName() + " from: "
                + lead.getCompanyName()  + " into an opportunity?    y / n ");
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
                    Contact.theContacts.put(newContact.getId(), newContact);  // Adds contact to contact Map
                    Opportunity.theOpportunities.put(newOpp.getId(), newOpp); // Adds Opportunity to opportunities map
                    theLeads.remove(lead.getId()); // Removes converted lead from Leads map ("Database")
                    createAccount(newContact, newOpp); // Not sure whether to put this here or in Menu
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
    public static void createAccount(Contact contact, Opportunity opportunity) {

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
            Account.theAccounts.put(newAccount.getId(), newAccount); // Adds new account to Accounts Map (database)
        } catch (Exception e) {

            System.out.println("Invalid input - please start again");
            createAccount(contact, opportunity); // Catches errors and returns to start of method - Is there a better way??
        }
    }

    public static Lead lookUpLeadId(String id) throws RuntimeException{
        return (Lead) theLeads.get(id);
    }

    public String getId() {
        return id;
    }


    public String toString() {
        return "name='" + getName() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", companyName='" + getCompanyName() + '\'' +
                '}';
    }

}


