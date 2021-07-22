import java.util.HashMap;
import java.util.Map;


public class Contact extends Lead {

    public static Map<String, Contact> theContacts = new HashMap<>();

    private static String colorMain = "\u001B[33m";
    private static String reset = "\u001B[0m";

    public Contact(String name, String phoneNumber, String email, String companyName) {
        super(name, phoneNumber, email, companyName);
    }

    public Contact() {
    }



    public String getId() {
        return id;
    }

    public String toString() {
        return colorMain +
                "ID: " + getId() + "\n" +
                "Name: " + getName() + "\n" +
                "Phone Number: " + getPhoneNumber() + "\n" +
                "Email Address: " + getEmail() + "\n" +
                "Company Name: " + getCompanyName();
    }


}
