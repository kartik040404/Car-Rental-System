package com.example.carrentalsystem.bal.customerbal;

import com.example.carrentalsystem.dao.customerdao.CustomerDAO;
import com.example.carrentalsystem.dao.customerdao.CustomerDAOImpl;
import com.example.carrentalsystem.exception.CustomerNotFoundException;
import com.example.carrentalsystem.model.Customer;

import java.sql.SQLException;
import java.util.List;

public class CustomerBal {
    static CustomerDAO customerDAO;

    static {
        customerDAO = new CustomerDAOImpl();
    }
    public boolean checkCustomerID(int customerID) throws CustomerNotFoundException, SQLException, ClassNotFoundException {
        if(customerDAO.findCustomerById(customerID)==null){
            throw new CustomerNotFoundException("Customer ID not Found");
         }
        else return true;
    }

    public void addCustomerBal(Customer customer) throws SQLException, ClassNotFoundException, CustomerNotFoundException {
            customerDAO.addCustomer(customer);
    }

    public void removeCustomerBal(int customerID) throws SQLException, ClassNotFoundException, CustomerNotFoundException {
        if(checkCustomerID(customerID)){
        customerDAO.removeCustomer(customerID);
        }
    }

    public List<Customer> listCustomerBal() throws SQLException, ClassNotFoundException {
        return customerDAO.listCustomers();
    }
    public Customer findCustomerByIdBal(int customerID) throws SQLException, ClassNotFoundException, CustomerNotFoundException {
        if(checkCustomerID(customerID)){
        return customerDAO.findCustomerById(customerID);
        }
        return null;
    }
    public boolean validateFirstName(String firstName){
        if(firstName.trim().isEmpty())return false;
        return true;
    }

}
