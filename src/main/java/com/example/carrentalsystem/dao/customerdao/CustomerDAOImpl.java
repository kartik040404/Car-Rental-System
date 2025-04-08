package com.example.carrentalsystem.dao.customerdao;

import com.example.carrentalsystem.model.Customer;
import com.example.carrentalsystem.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO{
    static Connection connection;
    static PreparedStatement preparedStatement;
    @Override
    public void addCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        connection= ConnectionHelper.getConnection();
        String stmt="Insert into Customer (firstName,lastName,email,phoneNumber) values(?,?,?,?);";
        preparedStatement=connection.prepareStatement(stmt);
        preparedStatement.setString(1,customer.getFirstName());
        preparedStatement.setString(2,customer.getLastName());
        preparedStatement.setString(3,customer.getEmail());
        preparedStatement.setString(4,customer.getPhoneNumber());
        int rowsInserted=preparedStatement.executeUpdate();
        if(rowsInserted>0){
            System.out.println("Customer record inserted successfully");
        }
        preparedStatement.close();
        connection.close();
    }

    @Override
    public void removeCustomer(int customerID) throws SQLException, ClassNotFoundException {
            String stmt="Delete from Customer where customerID=?";
            connection=ConnectionHelper.getConnection();
            preparedStatement=connection.prepareStatement(stmt);
            preparedStatement.setInt(1,customerID);
            int rowsDeleted=preparedStatement.executeUpdate();
            if(rowsDeleted>0){
                System.out.println("Employee records deleted successfully");
            }
            connection.close();
            preparedStatement.close();
    }

    @Override
    public List<Customer> listCustomers() throws SQLException, ClassNotFoundException {
        connection=ConnectionHelper.getConnection();
        String stmt="Select * from Customer";
        preparedStatement=connection.prepareStatement(stmt);
        ResultSet resultSet=preparedStatement.executeQuery();
        List<Customer> customerList=new ArrayList<>();
        Customer customer=null;
        while (resultSet.next()){
            customer=new Customer();
            customer.setCustomerID(resultSet.getInt("customerID"));
            customer.setFirstName(resultSet.getString("firstName"));
            customer.setLastName(resultSet.getString("lastName"));
            customer.setEmail(resultSet.getString("email"));
            customer.setPhoneNumber(resultSet.getString("phoneNumber"));
            customerList.add(customer);
        }
        connection.close();
        preparedStatement.close();
        return customerList;
    }

    @Override
    public Customer findCustomerById(int customerID) throws SQLException, ClassNotFoundException {
         connection=ConnectionHelper.getConnection();
         String stmt="Select * from Customer where customerID=?";
         preparedStatement=connection.prepareStatement(stmt);
         preparedStatement.setInt(1,customerID);
         ResultSet resultSet=preparedStatement.executeQuery();
         Customer customer=null;
         if(resultSet.next()){
             customer=new Customer();
             customer.setCustomerID(resultSet.getInt("customerID"));
             customer.setFirstName(resultSet.getString("firstName"));
             customer.setLastName(resultSet.getString("lastName"));
             customer.setEmail(resultSet.getString("email"));
             customer.setPhoneNumber(resultSet.getString("phoneNumber"));
         }
        connection.close();
        preparedStatement.close();
        return customer;
    }
}
