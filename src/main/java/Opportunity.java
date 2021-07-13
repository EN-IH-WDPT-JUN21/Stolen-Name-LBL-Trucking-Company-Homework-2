import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class Opportunity {

    public static Map<String, Opportunity> theOpportunities = new HashMap<>();

    // This assigns a unique ID to the opportunity object
    private static final AtomicLong idCounter = new AtomicLong();
    private final String id = String.valueOf(idCounter.getAndIncrement());

    // This sets the status to Enum Open whenever an opportunity object is created
    private Status status = Status.OPEN;

    // Opportunity Specific variable - EnumTruck Truck, int quantity, ObjectContact DecisionMaker
    private Truck truck;
    private int quantity;
    private Contact decisionMaker;

    public Opportunity() {
    }

    public Opportunity(Truck truck, int quantity, Contact decisionMaker) {
        setTruck(truck);
        setQuantity(quantity);
        setDecisionMaker(decisionMaker);
    }


    public String getId() {
        return id;
    }

    public Truck getTruck() {
        return truck;
    }

    public void setTruck(Truck truck) {
        this.truck = truck;
    }

    public ClientInformation getDecisionMaker() {
        return decisionMaker;
    }

    public void setDecisionMaker(Contact decisionMaker) {
        this.decisionMaker = decisionMaker;
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

    public static AtomicLong getIdCounter() {
        return idCounter;
    }

    public String toString() {
        return "Opportunity{" +
                "id='" + id + '\'' +
                ", status=" + status +
                ", truck=" + truck +
                ", quantity=" + quantity +
                ", decisionMaker=" + decisionMaker.toString() +
                '}';
    }
}
