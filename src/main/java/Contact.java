import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class Contact extends ClientInformation {

    public static Map<String, Contact> theContacts = new HashMap<>();


    private static final AtomicLong idCounter = new AtomicLong();
    private final String id = String.valueOf(idCounter.getAndIncrement());

    public Contact() {
    }

    public Contact(Lead lead) {
        super(lead);
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
