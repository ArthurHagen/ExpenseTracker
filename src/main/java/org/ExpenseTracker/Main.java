package org.ExpenseTracker;

import org.ExpenseTracker.Database.DBActions;
import org.ExpenseTracker.Database.Impl.DBActionsImpl;
import org.ExpenseTracker.Datatypes.Payment;

public class Main {
    public static void main(String[] args) throws Exception {
        DBActions database = new DBActionsImpl("/home/burningturtle/Projects/java/ExpenseTracker/resource/expenses.db");
        //database.insertPayment(new Payment("Other", 36.0));
        Payment[] payments = database.getAllPayments();
        for (Payment payment: payments) {
            System.out.println(payment.getRecipient() + payment.getValue());
        }
    }
}