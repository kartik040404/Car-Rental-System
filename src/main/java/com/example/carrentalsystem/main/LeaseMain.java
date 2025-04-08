package com.example.carrentalsystem.main;

import com.example.carrentalsystem.bal.customerbal.LeaseBal;
import com.example.carrentalsystem.exception.LeaseNotFoundException;
import com.example.carrentalsystem.model.Customer;
import com.example.carrentalsystem.model.Lease;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class LeaseMain {
    LeaseBal leaseBal;
    Scanner sc;
    LeaseMain(){
        sc=new Scanner(System.in);
        leaseBal=new LeaseBal();
    }

    public void createLeaseMain() throws ParseException, SQLException, ClassNotFoundException {
        System.out.println("Enter Customer ID:");
        int customerID=sc.nextInt();
        System.out.println("Enter Vehicle ID:");
        int vehicleID=sc.nextInt();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Enter Start Date (yyyy-mm-dd):");
        Date startDate=sdf.parse(sc.next());
        System.out.println("Enter End Date (yyyy-mm-dd):");
        Date endDate=sdf.parse(sc.next());
        leaseBal.createLeaseBal(customerID,vehicleID,startDate,endDate);
    }

    public void returnCarMain() throws SQLException, ClassNotFoundException, LeaseNotFoundException {
        int leaseID;
        System.out.println("Enter Lease ID:");
        leaseID=sc.nextInt();
        try{

        Lease lease=leaseBal.returnCar(leaseID);
            System.out.println(lease);
//        if(lease!=null) System.out.println(lease);
//        else System.out.println("No Lease Details found");
        }catch (LeaseNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    public void listActiveLeaseMain() throws SQLException, ClassNotFoundException {
        List<Lease> leaseList=new ArrayList<>();
        leaseList=leaseBal.listActiveLease();
        if(!leaseList.isEmpty()){
            for(Lease lease:leaseList){
                System.out.println(lease);
            }
        }
        else System.out.println("No records found");
    }
    public void listLeaseHistoryMain() throws SQLException, ClassNotFoundException {
        List<Lease> leaseList=new ArrayList<>();
        leaseList=leaseBal.listLeaseHistory();
        if(!leaseList.isEmpty()){
            for(Lease lease:leaseList){
                System.out.println(lease);
            }
        }
        else System.out.println("No records found");
    }
}
