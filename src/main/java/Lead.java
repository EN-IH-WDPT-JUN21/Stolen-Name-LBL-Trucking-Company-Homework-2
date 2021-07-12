import java.util.concurrent.atomic.AtomicLong;

public class Lead extends ClientInformation {

    private static final AtomicLong idCounter = new AtomicLong();
    private final String id = String.valueOf(idCounter.getAndIncrement());

    public Lead() {
    }

    public Lead(String name, String phoneNumber, String email, String companyName) {
        super(name, phoneNumber, email, companyName);
    }

    @Override
    public String getId() {
        return id;
    }
}


