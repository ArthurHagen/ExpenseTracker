package org.ExpenseTracker.Database.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.ExpenseTracker.Database.DBActions;
import org.ExpenseTracker.Datatypes.Payment;

public class DBActionsImpl implements DBActions {

    private Connection _database;
    private Statement _statement;

    public DBActionsImpl(String dbPath) throws SQLException {
            _database  = DriverManager.getConnection("jdbc:sqlite:" + dbPath);
            _statement = _database.createStatement();
    }

    @Override
    public void insertPayment(Payment payment) throws SQLException {
        _statement.executeUpdate(
            String.format(
                "insert into payments values(\"%s\", %f);",
                payment.getRecipient(),
                payment.getValue())
            );


    }

    @Override
    public Payment[] getAllPayments() throws SQLException {
        ResultSet payments = _statement.executeQuery("select * from payments");
        ResultSet lengthQuery = _statement.executeQuery("select count(value) from payments");
        lengthQuery.next();
        int resultLength = lengthQuery.getInt(1);

        Payment[] result = new Payment[resultLength];

                    
        int i = 0;
        while (payments.next()) {
            result[i] = new Payment(
                payments.getString("recipient"),
                payments.getDouble("value")
            ); 
            i++;
        }

        return result;
    }
    
}
