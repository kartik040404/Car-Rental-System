package com.example.carrentalsystem.dao.vehicledao;

import com.example.carrentalsystem.model.Vehicle;

import java.sql.SQLException;
import java.util.List;

public interface VehicleDAO {
    void addVehicle(Vehicle vehicle) throws SQLException, ClassNotFoundException;
    void removeVehicle(int vehicleID) throws SQLException, ClassNotFoundException;
    List<Vehicle> listAvailableVehicles() throws SQLException, ClassNotFoundException;
    List<Vehicle> listRentedVehicles() throws SQLException, ClassNotFoundException;
    Vehicle findVehicleById(int vehicleID) throws SQLException, ClassNotFoundException;

}
