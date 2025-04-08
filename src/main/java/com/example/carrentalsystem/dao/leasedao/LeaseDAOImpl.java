package com.example.carrentalsystem.dao.leasedao;

import com.example.carrentalsystem.model.Customer;
import com.example.carrentalsystem.model.Lease;
import com.example.carrentalsystem.model.Type;
import com.example.carrentalsystem.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LeaseDAOImpl implements LeaseDAO{
    static Connection connection;
    static PreparedStatement preparedStatement;
    @Override
    public void createLease(int customerID, int carID, Date startDate, Date endDate) throws SQLException, ClassNotFoundException {
        connection= ConnectionHelper.getConnection();
        String stmt="Insert into Lease (vehicleID,customerID,startDate,endDate,type) values(?,?,?,?,?)";
        long diffInMillies = Math.abs(endDate.getTime() - startDate.getTime());
        long diffInDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        String leaseType;
        if (diffInDays >= 28) {
            leaseType = "MonthlyLease";
        } else {
            leaseType = "DailyLease";
        }
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String startDateStr=sdf.format(startDate);
        String endDateStr=sdf.format(endDate);
        preparedStatement=connection.prepareStatement(stmt);
        preparedStatement.setInt(1,customerID);
        preparedStatement.setInt(2,carID);
        preparedStatement.setString(3,startDateStr);
        preparedStatement.setString(4,endDateStr);
        preparedStatement.setString(5,leaseType);
        int rowsInserted=preparedStatement.executeUpdate();
        if(rowsInserted>0){
            System.out.println("Lease record inserted successfully");
        }
        preparedStatement.close();
        connection.close();
    }

    @Override
    public Lease returnCar(int leaseID) throws SQLException, ClassNotFoundException {
        connection=ConnectionHelper.getConnection();
        String stmt="Select * from Lease where leaseID=?";
        preparedStatement=connection.prepareStatement(stmt);
        preparedStatement.setInt(1,leaseID);
        ResultSet resultSet=preparedStatement.executeQuery();
        Lease lease=null;
        if(resultSet.next()){
            lease=new Lease();
            lease.setLeaseID(resultSet.getInt("leaseID"));
            lease.setCustomerID(resultSet.getInt("customerID"));
            lease.setVehicleID(resultSet.getInt("vehicleID"));
            lease.setStartDate(resultSet.getDate("startDate"));
            lease.setEndDate(resultSet.getDate("endDate"));
            lease.setType(Type.valueOf(resultSet.getString("type")));
        }
        connection.close();
        preparedStatement.close();
        return lease;
    }

    @Override
    public List<Lease> listActiveLease() throws SQLException, ClassNotFoundException {
        connection=ConnectionHelper.getConnection();
        String stmt="Select * from Lease where curDate() between startDate and endDate;";
        preparedStatement=connection.prepareStatement(stmt);
        ResultSet resultSet=preparedStatement.executeQuery();
        List<Lease> leaseList=new ArrayList<>();
        Lease lease=null;
        while (resultSet.next()){
            lease=new Lease();
            lease.setLeaseID(resultSet.getInt("leaseID"));
            lease.setCustomerID(resultSet.getInt("customerID"));
            lease.setVehicleID(resultSet.getInt("vehicleID"));
            lease.setStartDate(resultSet.getDate("startDate"));
            lease.setEndDate(resultSet.getDate("endDate"));
            lease.setType(Type.valueOf(resultSet.getString("type")));
            leaseList.add(lease);
        }
        connection.close();
        preparedStatement.close();
        return leaseList;
    }

    @Override
    public List<Lease> listLeaseHistory() throws SQLException, ClassNotFoundException {
        connection=ConnectionHelper.getConnection();
        String stmt=" select * from lease where endDate<curDate();";
        preparedStatement=connection.prepareStatement(stmt);
        ResultSet resultSet=preparedStatement.executeQuery();
        List<Lease> leaseList=new ArrayList<>();
        Lease lease=null;
        while (resultSet.next()){
            lease=new Lease();
            lease.setLeaseID(resultSet.getInt("leaseID"));
            lease.setCustomerID(resultSet.getInt("customerID"));
            lease.setVehicleID(resultSet.getInt("vehicleID"));
            lease.setStartDate(resultSet.getDate("startDate"));
            lease.setEndDate(resultSet.getDate("endDate"));
            lease.setType(Type.valueOf(resultSet.getString("type")));
            leaseList.add(lease);
        }
        connection.close();
        preparedStatement.close();
        return leaseList;
    }
}
