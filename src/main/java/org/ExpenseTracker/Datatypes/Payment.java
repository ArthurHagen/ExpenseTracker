package org.ExpenseTracker.Datatypes;

public class Payment {
    private String recipient;
    private double value;
    
    public Payment(String recipient, double value) {
        this.recipient = recipient;
        this.value = value;
    }

    public String getRecipient() {
        return recipient;
    }

    public double getValue() {
        return value;
    }
}
