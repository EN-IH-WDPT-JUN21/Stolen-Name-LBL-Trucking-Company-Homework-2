import java.util.concurrent.atomic.AtomicLong;

public class Opportunity extends ClientInformation {

    // This assigns a unique ID to the opportunity object
    private static final AtomicLong idCounter = new AtomicLong();
    private String id = String.valueOf(idCounter.getAndIncrement());

    // This sets the status to Enum Open whenever an opportunity object is created
    private Status status = Status.OPEN;

    // Opportunity Specific variable - EnumTruck Truck, int quantity, ObjectContact DecisionMaker
    private Truck truck;
    private int quantity;
    private Contact decisionMaker;

    public Opportunity() {
    }

    public Opportunity(ClientInformation client) {
        super(client);
    }

    public Opportunity(ClientInformation lead, Truck truck, int quantity, Contact decisionMaker) {
        super(lead.getName(), lead.getPhoneNumber(), lead.getEmail(), lead.getCompanyName());
        setProduct(truck);
        setQuantity(quantity);
        setDecisionMaker(decisionMaker);
    }

    @Override
    public String getId() {
        return id;
    }

    public Truck getTruck() {
        return truck;
    }

    public void setTruck(Truck truck) {
        this.truck = truck;
    }

    public Contact getDecisionMaker() {
        return decisionMaker;
    }

    public void setDecisionMaker(Contact decisionMaker) {
        this.decisionMaker = decisionMaker;
    }

    public Truck getProduct() {
        return truck;
    }

    public void setProduct(Truck truck) {
        this.truck = truck;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
