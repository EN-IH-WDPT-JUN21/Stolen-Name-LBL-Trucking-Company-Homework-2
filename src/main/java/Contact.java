import java.util.HashMap;
import java.util.Map;


public class Contact extends Lead {

    public static Map<String, Contact> theContacts = new HashMap<>();

    private static final String colorMain = "\u001B[33m";
    private static final String colorMainBold = "\033[1;30m";
    private static final String colorTable = "\u001B[32m";
    private static final String colorHeadlineBold = "\033[1;34m";
    private static final String reset = "\u001B[0m";

    public Contact(String name, String phoneNumber, String email, String companyName) {
        super(name, phoneNumber, email, companyName);
    }

    public Contact() {
    }

    public String getId() {
        return id;
    }

    public String toString() {
        return  String.format("%-1s %-15s %-1s %-48s %-1s %-25s %-1s %-45s %-1s %-48s %-1s\n",
                              colorMain + "║",
                              colorTable + id,
                              colorMain + "║",
                              colorTable + name,
                              colorMain + "║",
                              colorTable + phoneNumber,
                              colorMain + "║",
                              colorTable + email,
                              colorMain + "║",
                              colorTable + companyName,
                              colorMain + "║"+ reset);
        /*return colorMain +
                "ID: " + getId() + "\n" +
                "Name: " + getName() + "\n" +
                "Phone Number: " + getPhoneNumber() + "\n" +
                "Email Address: " + getEmail() + "\n" +
                "Company name: " + getCompanyName();*/
    }
}
