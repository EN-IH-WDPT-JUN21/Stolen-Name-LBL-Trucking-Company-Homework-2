import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class Contact extends Lead {

    public static Map<String, Contact> theContacts = new HashMap<>();

    public Contact(String name, String phoneNumber, String email, String companyName) {
        super(name, phoneNumber, email, companyName);
    }

    public Contact() {
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
