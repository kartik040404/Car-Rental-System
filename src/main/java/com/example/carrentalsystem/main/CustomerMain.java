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

    CustomerMain() {
        sc = new Scanner(System.in);
        customerBal = new CustomerBal();
    }

    public void addCustomerMain() throws SQLException, ClassNotFoundException, CustomerNotFoundException {
        Customer customer = new Customer();
        String firstName, lastName, email, phoneNumber;
        do {
            System.out.println("Enter First Name: ");
            firstName = sc.next();
            if (!customerBal.checkEmpty(firstName)) {
                System.out.println("First name should not be empty");
            } else break;
        } while (true);
        customer.setFirstName(firstName);
        do {
            System.out.println("Enter Last Name: ");
            lastName = sc.next();
            if (!customerBal.checkEmpty(lastName)) {
                System.out.println("Last name should not be empty");
            } else break;
        } while (true);

        customer.setLastName(lastName);
        do {
            System.out.println("Enter Email: ");
            email = sc.next();
            if (customerBal.checkEmpty(email)) {
                if (customerBal.checkEmail(email)) break;
                else System.out.println("Enter valid email address");
            } else System.out.println("Email should not be empty");
        } while (true);

        customer.setEmail(email);
        do {
            System.out.println("Enter Phone Number");
            phoneNumber = sc.next();
            if (customerBal.checkEmpty(phoneNumber)) {
                if (customerBal.checkPhoneNumber(phoneNumber)) break;
                else System.out.println("Enter valid phone number");
            } else System.out.println("Phone Number should not be empty");
        } while (true);
        customer.setPhoneNumber(phoneNumber);
        customerBal.addCustomerBal(customer);
    }

    public void removeCustomerMain() throws SQLException, ClassNotFoundException, CustomerNotFoundException {
        int customerID;
        System.out.println("Enter Customer ID");
        customerID = sc.nextInt();
        try {
            customerBal.removeCustomerBal(customerID);
        } catch (CustomerNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    public void listCustomerMain() throws SQLException, ClassNotFoundException {
        List<Customer> customerList = new ArrayList<>();
        customerList = customerBal.listCustomerBal();
        if (!customerList.isEmpty()) {
            for (Customer customer : customerList) {
                System.out.println(customer);
            }
        } else System.out.println("No records found");
    }

    public void findCustomerByIdMain() throws SQLException, ClassNotFoundException, CustomerNotFoundException {
        int customerID;
        System.out.println("Enter Customer ID:");
        customerID = sc.nextInt();
        try {
            Customer customer = customerBal.findCustomerByIdBal(customerID);
//            if (customer != null)
            System.out.println(customer);
//            else System.out.println("No customer found");
        } catch (CustomerNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
}
