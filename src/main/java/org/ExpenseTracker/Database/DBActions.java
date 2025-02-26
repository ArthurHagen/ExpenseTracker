package org.ExpenseTracker.Database;

import java.sql.SQLException;

import org.ExpenseTracker.Database.Impl.DBActionsImpl;
import org.ExpenseTracker.Datatypes.Payment;

public interface DBActions {


    public void insertPayment(Payment payment) throws SQLException, Exception;

    public Payment[] getAllPayments() throws SQLException;
}
