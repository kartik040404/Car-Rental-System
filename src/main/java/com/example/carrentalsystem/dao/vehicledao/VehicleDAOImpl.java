package com.example.carrentalsystem.dao.vehicledao;

import com.example.carrentalsystem.model.Customer;
import com.example.carrentalsystem.model.Status;
import com.example.carrentalsystem.model.Vehicle;
import com.example.carrentalsystem.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class VehicleDAOImpl implements VehicleDAO {
    static Connection connection;
    static PreparedStatement preparedStatement;

    @Override
    public void addVehicle(Vehicle vehicle) throws SQLException, ClassNotFoundException {
        connection = ConnectionHelper.getConnection();
        String stmt = "Insert into Vehicle (vehicleID,make,model,year,dailyRate,status,passengerCapacity,engineCapacity) values(?,?,?,?,?,?,?,?);";
        preparedStatement = connection.prepareStatement(stmt);
        preparedStatement.setInt(1, vehicle.getVehicleID());
        preparedStatement.setString(2, vehicle.getMake());
        preparedStatement.setString(3, vehicle.getModel());
        preparedStatement.setInt(4, vehicle.getYear());
        preparedStatement.setDouble(5, vehicle.getDailyRate());
        preparedStatement.setString(6, vehicle.getStatus().name());
        preparedStatement.setInt(7, vehicle.getPassengerCapacity());
        preparedStatement.setDouble(8, vehicle.getEngineCapacity());
        int rowsInserted = preparedStatement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Vehicle record inserted successfully");
        }
        preparedStatement.close();
        connection.close();
    }

    @Override
    public void removeVehicle(int vehicleID) throws SQLException, ClassNotFoundException {
        String stmt = "Delete from Vehicle where vehicleID=?";
        connection = ConnectionHelper.getConnection();
        preparedStatement = connection.prepareStatement(stmt);
        preparedStatement.setInt(1, vehicleID);
        int rowsDeleted = preparedStatement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("Vehicle records deleted successfully");
        }
        connection.close();
        preparedStatement.close();
    }

    @Override
    public List<Vehicle> listAvailableVehicles() throws SQLException, ClassNotFoundException {
        connection = ConnectionHelper.getConnection();
        String stmt = "Select * from Vehicle where status=\"Available\"";
        preparedStatement = connection.prepareStatement(stmt);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Vehicle> vehicleList = new ArrayList<>();
        Vehicle vehicle = null;
        while (resultSet.next()) {
            vehicle = new Vehicle();
            vehicle.setVehicleID(resultSet.getInt("vehicleID"));
            vehicle.setMake(resultSet.getString("make"));
            vehicle.setModel(resultSet.getString("model"));
            vehicle.setYear(resultSet.getInt("year"));
            vehicle.setDailyRate(resultSet.getDouble("dailyRate"));
            vehicle.setStatus(Status.valueOf(resultSet.getString("status")));
            vehicle.setPassengerCapacity(resultSet.getInt("passengerCapacity"));
            vehicle.setEngineCapacity(resultSet.getInt("engineCapacity"));
            vehicleList.add(vehicle);
        }
        connection.close();
        preparedStatement.close();
        return vehicleList;
    }

    @Override
    public List<Vehicle> listRentedVehicles() throws SQLException, ClassNotFoundException {

    connection=ConnectionHelper.getConnection();
    String stmt = "Select * from Vehicle where status=\"NotAvailable\"";
    preparedStatement=connection.prepareStatement(stmt);
    ResultSet resultSet = preparedStatement.executeQuery();
    List<Vehicle> vehicleList = new ArrayList<>();
    Vehicle vehicle = null;
        while(resultSet.next())

    {
        vehicle = new Vehicle();
        vehicle.setVehicleID(resultSet.getInt("vehicleID"));
        vehicle.setMake(resultSet.getString("make"));
        vehicle.setModel(resultSet.getString("model"));
        vehicle.setYear(resultSet.getInt("year"));
        vehicle.setDailyRate(resultSet.getDouble("dailyRate"));
        vehicle.setStatus(Status.valueOf(resultSet.getString("status")));
        vehicle.setPassengerCapacity(resultSet.getInt("passengerCapacity"));
        vehicle.setEngineCapacity(resultSet.getInt("engineCapacity"));
        vehicleList.add(vehicle);
    }
        connection.close();
        preparedStatement.close();
        return vehicleList;
}
    @Override
    public Vehicle findVehicleById(int vehicleID) throws SQLException, ClassNotFoundException {
        connection=ConnectionHelper.getConnection();
        String stmt="Select * from Vehicle where vehicleID=?";
        preparedStatement=connection.prepareStatement(stmt);
        preparedStatement.setInt(1,vehicleID);
        ResultSet resultSet=preparedStatement.executeQuery();
        Vehicle vehicle=null;
        if(resultSet.next()){
            vehicle=new Vehicle();
            vehicle.setVehicleID(resultSet.getInt("vehicleID"));
            vehicle.setMake(resultSet.getString("make"));
            vehicle.setModel(resultSet.getString("model"));
            vehicle.setYear(resultSet.getInt("year"));
            vehicle.setDailyRate(resultSet.getDouble("dailyRate"));
            vehicle.setStatus(Status.valueOf(resultSet.getString("status")));
            vehicle.setPassengerCapacity(resultSet.getInt("passengerCapacity"));
            vehicle.setEngineCapacity(resultSet.getInt("engineCapacity"));
        }
        connection.close();
        preparedStatement.close();
        return vehicle;
    }
}
