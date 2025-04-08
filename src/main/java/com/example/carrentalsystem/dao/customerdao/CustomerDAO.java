package com.example.carrentalsystem.dao.customerdao;

import com.example.carrentalsystem.model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO {
        void addCustomer(Customer customer) throws SQLException, ClassNotFoundException;
        void removeCustomer(int customerID) throws SQLException, ClassNotFoundException;
        List<Customer> listCustomers() throws SQLException, ClassNotFoundException;
        Customer findCustomerById(int customerID) throws SQLException, ClassNotFoundException;
}
