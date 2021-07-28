
import java.util.List;
import java.util.ArrayList;

public class Account extends ClientInformation{

    private Industry industry;
    private int employeeCount;
    private String city;
    private String country;
    private List<Contact> contactList = new ArrayList<>();
    private List<Opportunity> opportunityList = new ArrayList<>();

    private static final String colorMain = "\u001B[33m";
    private static final String colorMainBold = "\033[1;37m";
    private static final String colorTable = "\u001B[32m";
    private static final String colorHeadlineBold = "\033[1;34m";
    private static final String reset = "\u001B[0m";

    public Account() {
    }

    public Account(Contact contact, Opportunity opportunity){
        addContact(contact);
        addOpportunity(opportunity);
    }


    public Account(Industry industry, int employeeCount, String city, String country, Contact contact, Opportunity opportunity) {
        setIndustry(industry);
        setEmployeeCount(employeeCount);
        setCity(city);
        setCountry(country);
        addContact(contact);
        addOpportunity(opportunity);
    }

    public String getId() {
        return id;
    }

    public Industry getIndustry() {
        return industry;
    }

    public void setIndustry(Industry industry) {
        this.industry = industry;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getContactList() {
        return String.format("%-1s %-15s %-1s %-48s %-1s %-25s %-1s %-45s %-1s %-48s %-1s\n",
                             colorMain + "║",
                             colorTable + contactList.get(0).getId(),
                             colorMain + "║",
                             colorTable + contactList.get(0).getName(),
                             colorMain + "║",
                             colorTable + contactList.get(0).getPhoneNumber(),
                             colorMain + "║",
                             colorTable + contactList.get(0).getEmail(),
                             colorMain + "║",
                             colorTable + contactList.get(0).getCompanyName(),
                             colorMain + "║"+ reset);
    }

    public String getCompanyName(){
        return contactList.get(0).getCompanyName();
    }

    public void addContact(Contact contact) {
        contactList.add(contact);
    }

    public String getOpportunityList() {
        System.out.println(colorMain + "\n╔════════════╦═════ " + colorMainBold + "New Opportunity created" + colorMain + " ════════════════╦═══════════════════════════╦═══════════════════════════╗" + reset);
        System.out.printf("%-1s %-17s %-1s %-24s %-1s %-24s %-1s %-24s %-1s %-50s %-1s\n",
                          colorMain + "║",
                          colorHeadlineBold + "ID",
                          colorMain + "║",
                          colorHeadlineBold + "Status",
                          colorMain + "║",
                          colorHeadlineBold + "Product",
                          colorMain + "║",
                          colorHeadlineBold + "Quantity",
                          colorMain + "║",
                          colorHeadlineBold + "Decision maker",
                          colorMain + "║\n" +
                          colorMain + "╠════════════╬══════════════════════╬═══════════════════╬═══════════════════════════╬═══════════════════════════╣\n");
        return String.format("%-1s %-15s %-1s %-22s %-1s %-22s %-1s %-22s %-1s %-48s %-1s\n",
                             colorMain + "║",
                             colorTable + opportunityList.get(0).getId(),
                             colorMain + "║",
                             colorTable + opportunityList.get(0).getStatus(),
                             colorMain + "║",
                             colorTable + opportunityList.get(0).getProduct(),
                             colorMain + "║",
                             colorTable + opportunityList.get(0).getQuantity(),
                             colorMain + "║",
                             colorTable + opportunityList.get(0).getDecisionMaker().getName(),
                             colorMain + "║"+ reset);
    }

    public void addOpportunity(Opportunity opportunity) {
        opportunityList.add(opportunity);
    }


    @Override
    public String toString() {
        System.out.println(colorMain + "\n╔════════════╦═════ " + colorMainBold + "New Account created" + colorMain + " ════════════════╦═══════════════════════════╦═══════════════════════════╗" + reset);
        System.out.printf("%-1s %-17s %-1s %-27s %-1s %-24s %-1s %-32s %-1s %-32s %-1s\n",
                          colorMain + "║",
                          colorHeadlineBold + "ID",
                          colorMain + "║",
                          colorHeadlineBold + "Industry",
                          colorMain + "║",
                          colorHeadlineBold + "Employee Count",
                          colorMain + "║",
                          colorHeadlineBold + "City",
                          colorMain + "║",
                          colorHeadlineBold + "Country",
                          colorMain + "║\n" +
                          colorMain + "╠════════════╬══════════════════════╬═══════════════════╬═══════════════════════════╬═══════════════════════════╣");
        return  colorMain +
                String.format("%-1s %-15s %-1s %-25s %-1s %-22s %-1s %-30s %-1s %-30s %-1s\n",
                              colorMain + "║",
                              colorTable + id,
                              colorMain + "║",
                              colorTable + industry,
                              colorMain + "║",
                              colorTable + employeeCount,
                              colorMain + "║",
                              colorTable + city,
                              colorMain + "║",
                              colorTable + country,
                              colorMain + "║") + reset;
    }
}

