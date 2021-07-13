import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class Lead extends ClientInformation {

    public static Map<String, Lead> theLeads = new HashMap<>();

    private static final AtomicLong idCounter = new AtomicLong();
    private final String id = String.valueOf(idCounter.getAndIncrement());

    public Lead() {
    }

    public Lead(String name, String phoneNumber, String email, String companyName) {
        super(name, phoneNumber, email, companyName);
    }

    public String getId() {
        return id;
    }

    public static AtomicLong getIdCounter() {
        return idCounter;
    }


}


