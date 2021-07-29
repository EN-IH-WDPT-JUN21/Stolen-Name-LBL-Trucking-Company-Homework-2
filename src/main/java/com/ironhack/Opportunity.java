package com.ironhack;//Extends com.ironhack.ClientInformation class to retain Unique ID incrementing.

import com.ironhack.enums.Status;
import com.ironhack.enums.Truck;
import com.ironhack.exceptions.ExceedsMaxValue;

public class Opportunity extends ClientInformation {

    // This sets the status to Enum Open whenever an opportunity object is created
    private Status status = Status.OPEN;

    // com.ironhack.Opportunity Specific variable - EnumTruck com.ironhack.enums.Truck, int quantity, ObjectContact DecisionMaker
    private Truck product;
    private int quantity;
    private Contact decisionMaker;

    private static final String colorMain = "\u001B[33m";
    private static final String colorMainBold = "\033[1;30m";
    private static final String colorTable = "\u001B[32m";
    private static final String colorHeadlineBold = "\033[1;34m";
    private static final String reset = "\u001B[0m";

    public Opportunity() {
    }

    public Opportunity(Truck product, int quantity, Contact decisionMaker) throws ExceedsMaxValue {
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

    public Contact getDecisionMaker() {
        return decisionMaker;
    }

    public void setDecisionMaker(Contact decisionMaker) {
        this.decisionMaker = decisionMaker;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) throws ExceedsMaxValue {
         if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive. Please try again.");
        } if (String.valueOf(quantity).length() > 17) {
            throw new ExceedsMaxValue("Exceeds maximum value. Please try again.");
        }

        this.quantity = quantity;
    }


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    public String toString() {
        return  String.format("%-1s %-15s %-1s %-25s %-1s %-22s %-1s %-22s %-1s\n",
                              colorMain + "║",
                              colorTable + id,
                              colorMain + "║",
                              colorTable + status,
                              colorMain + "║",
                              colorTable + product,
                              colorMain + "║",
                              colorTable + quantity,
                              colorMain + "║"+ reset);
        /*return colorMain +
                "\nID: " + id + "\n" +
                "Contract status: " + status + "\n" +
                "Product: " + product + "\n" +
                "Quantity: " + quantity + "\n" +
                "\nDecision maker:\n" + decisionMaker.toString();*/
    }
}
