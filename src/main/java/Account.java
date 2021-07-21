
import java.util.List;
import java.util.ArrayList;

public class Account extends ClientInformation{

    private Industry industry;
    private int employeeCount;
    private String city;
    private String country;
    private List<Contact> contactList = new ArrayList<>();
    private List<Opportunity> opportunityList = new ArrayList<>();

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

    public List<Contact> getContactList() {
        return contactList;
    }

    public String getCompanyName(){
        return contactList.get(0).getCompanyName();
    }

    public void addContact(Contact contact) {
        contactList.add(contact);
    }

    public List<Opportunity> getOpportunityList() {
        return opportunityList;
    }

    public void addOpportunity(Opportunity opportunity) {
        opportunityList.add(opportunity);
    }


    @Override
    public String toString() {
        return  "ID: " + id + "\n" +
                "Industry: " + industry + "\n" +
                "Employee Count: " + employeeCount + "\n" +
                "City: " + city + "\n" +
                "Country: " + country + "\n" +
                "\nList of Contacts: \n" +
                contactList + "\n" +
                "\nList of Opportunities: \n" +
                opportunityList;
    }

}

