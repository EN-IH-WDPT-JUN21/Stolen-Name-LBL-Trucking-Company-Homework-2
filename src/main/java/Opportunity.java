//Extends ClientInformation class to retain Unique ID incrementing.

import java.util.HashMap;
import java.util.Map;

public class Opportunity extends ClientInformation {

    public static Map<String, Opportunity> theOpportunities = new HashMap<>();

    // This sets the status to Enum Open whenever an opportunity object is created
    private Status status = Status.OPEN;

    // Opportunity Specific variable - EnumTruck Truck, int quantity, ObjectContact DecisionMaker
    private Truck product;
    private int quantity;
    private Contact decisionMaker;

    public Opportunity() {
    }

    public Opportunity(Truck product, int quantity, Contact decisionMaker) {
        setTruck(product);
        setQuantity(quantity);
        setDecisionMaker(decisionMaker);
    }


    public String getId() {
        return id;
    }

    public Truck getProduct() {
        return product;
    }

    public void setTruck(Truck product) {
        this.product = product;
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

    public static void showOportunities(){
        System.out.println("═════════════ Total Number Of Opportunities: " + theOpportunities.size() + " ═════════════");
        for (String key : theOpportunities.keySet()){
            System.out.println("ID: " + key + " Name: " + theOpportunities.get(key).getDecisionMaker() );
        }
    }

    public String toString() {
        return "Opportunity{" +
                "id='" + id + '\'' +
                ", status= " + status +
                ", product= " + product +
                ", quantity= " + quantity +
                ", decisionMaker= " + decisionMaker.toString() +
                '}';
    }
}
