import java.util.concurrent.atomic.AtomicLong;

public class Contact extends ClientInformation {


    private static final AtomicLong idCounter = new AtomicLong();
    private final String id = String.valueOf(idCounter.getAndIncrement());

    public Contact() {
    }

    public Contact(ClientInformation client) {
        super(client);
    }


    @Override
    public String getId() {
        return id;
    }
}
