package com.example.carrentalsystem.dao.paymentdao;

import com.example.carrentalsystem.model.Lease;

import java.sql.SQLException;

public interface PaymentDAO {
    void recordPayment(int leaseID,double amount) throws SQLException, ClassNotFoundException;
}
