package com.example.carrentalsystem.main;

import com.example.carrentalsystem.bal.customerbal.CustomerBal;
import com.example.carrentalsystem.exception.CustomerNotFoundException;
import com.example.carrentalsystem.model.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerMain {
    CustomerBal customerBal;
    Scanner sc;
    CustomerMain(){
        sc=new Scanner(System.in);
        customerBal=new CustomerBal();
    }
    public void addCustomerMain() throws SQLException, ClassNotFoundException, CustomerNotFoundException {
        Customer customer=new Customer();

        System.out.println("Enter First Name");
        customer.setFirstName(sc.next());
        System.out.println("Enter Last Name");
        customer.setLastName(sc.next());
        System.out.println("Enter Email: ");
        customer.setEmail(sc.next());
        System.out.println("Enter Phone Number");
        customer.setPhoneNumber(sc.next());
        customerBal.addCustomerBal(customer);
    }

    public void removeCustomerMain() throws SQLException, ClassNotFoundException, CustomerNotFoundException {
        int customerID;
        System.out.println("Enter Customer ID");
        customerID=sc.nextInt();
        customerBal.removeCustomerBal(customerID);
    }

    public void listCustomerMain() throws SQLException, ClassNotFoundException {
        List<Customer> customerList=new ArrayList<>();
        customerList=customerBal.listCustomerBal();
        if(!customerList.isEmpty()){
            for(Customer customer:customerList){
                System.out.println(customer);
            }
        }
        else System.out.println("No records found");
    }

    public void findCustomerByIdMain() throws SQLException, ClassNotFoundException, CustomerNotFoundException {
        int customerID;
        System.out.println("Enter Customer ID:");
        customerID=sc.nextInt();
        try{

        Customer customer=customerBal.findCustomerByIdBal(customerID);
        if(customer!=null) System.out.println(customer);
        else System.out.println("No customer found");
        }catch (CustomerNotFoundException e){
            System.err.println(e.getMessage());
        }
    }
}
