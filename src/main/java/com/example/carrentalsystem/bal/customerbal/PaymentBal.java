package com.example.carrentalsystem.bal.customerbal;

import com.example.carrentalsystem.dao.paymentdao.PaymentDAO;
import com.example.carrentalsystem.dao.paymentdao.PaymentDAOImpl;

import java.sql.SQLException;

public class PaymentBal {
    static PaymentDAO paymentDAO;
    static {
        paymentDAO=new PaymentDAOImpl();
    }

    public void recordPaymentBal(int leaseID,double amount) throws SQLException, ClassNotFoundException {
        paymentDAO.recordPayment(leaseID,amount);
    }
}
