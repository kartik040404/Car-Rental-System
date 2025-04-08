package com.example.carrentalsystem.dao.paymentdao;

import com.example.carrentalsystem.model.Lease;
import com.example.carrentalsystem.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class PaymentDAOImpl implements PaymentDAO{
    static Connection connection;
    static PreparedStatement preparedStatement;
    @Override
    public void recordPayment(int leaseID, double amount) throws SQLException, ClassNotFoundException {
        connection= ConnectionHelper.getConnection();
        String stmt="Insert into Payment (leaseID,paymentDate,amount) values(?,?,?)";
        preparedStatement=connection.prepareStatement(stmt);
        preparedStatement.setInt(1,leaseID);
        preparedStatement.setString(2, String.valueOf(LocalDate.now()));
        preparedStatement.setDouble(3,amount);
        int rowsInserted=preparedStatement.executeUpdate();
        if(rowsInserted>0){
            System.out.println("Payment record inserted successfully");
        }
        preparedStatement.close();
        connection.close();
    }
}
