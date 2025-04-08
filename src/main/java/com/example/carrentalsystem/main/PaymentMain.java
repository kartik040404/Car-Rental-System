package com.example.carrentalsystem.main;

import com.example.carrentalsystem.bal.customerbal.CustomerBal;
import com.example.carrentalsystem.bal.customerbal.PaymentBal;

import java.sql.SQLException;
import java.util.Scanner;

public class PaymentMain {
    PaymentBal paymentBal;
    Scanner sc;
    PaymentMain(){
        sc=new Scanner(System.in);
        paymentBal=new PaymentBal();
    }

    public void recordPaymentMain() throws SQLException, ClassNotFoundException {
        System.out.println("Enter Lease ID:");
        int leaseID=sc.nextInt();
        System.out.println("Enter Amount :");
        double amount=sc.nextDouble();
        paymentBal.recordPaymentBal(leaseID,amount);
    }
}
