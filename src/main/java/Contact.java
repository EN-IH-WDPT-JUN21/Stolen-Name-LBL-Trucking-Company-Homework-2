import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class Contact extends Lead {

    public Contact(String name, String phoneNumber, String email, String companyName) {
        super(name, phoneNumber, email, companyName);
    }

    public Contact() {
    }

    public static void showContacts(){
        for (String key : theLeads.keySet()){
            System.out.println("ID: " + key + " Name: " + Lead.theContacts.get(key).getName() );
        }
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
