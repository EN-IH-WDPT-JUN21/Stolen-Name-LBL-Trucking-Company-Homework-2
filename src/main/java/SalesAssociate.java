import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

public class SalesAssociate {

    private static final AtomicLong idCounter = new AtomicLong();
    private final String id = String.valueOf(idCounter.getAndIncrement());
    private String name;

    public SalesAssociate(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void newLead() {

        System.out.println("Would you like to create a new lead?   y / n ");
        Scanner scanner = new Scanner(System.in);
        try {
            switch (scanner.nextLine().trim()) {
                case "Y":
                case "y": {
                    Lead newLead = new Lead();
                    System.out.println("Please input the customers name: ");
                    newLead.setName(scanner.nextLine().trim());
                    System.out.println("Please input the customers phone number: ");
                    newLead.setPhoneNumber(scanner.nextLine().trim());
                    System.out.println("Please input the customers email address: ");
                    newLead.setEmail(scanner.nextLine().trim());
                    System.out.println("Please input the customers company name: ");
                    newLead.setCompanyName(scanner.nextLine().trim());
                    Lead.theLeads.put(newLead.getId(), newLead);
                    break;
                }
                case "N":
                case "n": {
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

    public void convertLead(Lead lead) {
        System.out.println("Would you like to convert lead " + lead.getName() + " into an opportunity?    y / n ");
        Scanner scanner = new Scanner(System.in);
        try {
            switch (scanner.nextLine().trim()) {
                case "Y":
                case "y": {
                    Opportunity newOpp = new Opportunity(lead);
                    System.out.println("Please input the product that " + lead.getName() + " is interested in: \n " +
                            "HYBRID, FLATBED OR BOX");
                    newOpp.setProduct(Truck.valueOf(scanner.nextLine().trim().toUpperCase(Locale.ROOT)));
                    System.out.println("Please input the quantity that " + newOpp.getName() + " is interested in: ");
                    newOpp.setQuantity(Integer.parseInt(scanner.nextLine().trim()));
                    Contact newContact = new Contact(lead);
                    newOpp.setDecisionMaker(newContact);

                    Contact.theContacts.put(newContact.getId(), newContact);  // Adds to
                    Opportunity.theOpportunities.put(newOpp.getId(), newOpp);
                    Lead.theLeads.remove(lead.getId());
                    createAccount(newContact, newOpp);
                    break;
                }
                case "N":
                case "n": {
                    System.out.println("You said no");
                    break;
                }
                default:
                    throw new IllegalArgumentException("Invalid input - please start again");
            }
        } catch (Exception e) {
            System.out.println("invalid input");
            convertLead(lead);
        }

    }

    public void createAccount(Contact contact, Opportunity opportunity) {
        Scanner scanner = new Scanner(System.in);
        try {
            Account newAccount = new Account(contact, opportunity);
            System.out.println("Please input the company industry: \n" + "PRODUCE, ECOMMERCE, " +
                    "MANUFACTURING, MEDICAL, OTHER");
            newAccount.setIndustry(Industry.valueOf(scanner.nextLine().trim().toUpperCase(Locale.ROOT)));
            System.out.println("Please input the employee count for " + newAccount.getName() +":  ");
            newAccount.setEmployeeCount(Integer.parseInt(scanner.nextLine().trim()));
            System.out.println("Please input the city for " + newAccount.getName() +":  ");
            newAccount.setCity(scanner.nextLine().trim());
            System.out.println("Please input the Country for " + newAccount.getName() +":  ");
            newAccount.setCountry(scanner.nextLine().trim());
            Account.theAccounts.put(newAccount.getId(), newAccount);
            newAccount.addContact(contact); // Adds contact to Accounts contact list
            newAccount.addOpportunity(opportunity); // adds opportunity to the Accounts opportunity list
        } catch (Exception e) {
            System.out.println("invalid input");
            createAccount(contact, opportunity);
        }
    }

    public String showLeads(){
        return Lead.theLeads.toString();
    }

    public Lead lookUpLeadId(String id) throws RuntimeException{
        return (Lead) Lead.theLeads.get(id);
    }


}

