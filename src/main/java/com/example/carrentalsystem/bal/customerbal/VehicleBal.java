package com.example.carrentalsystem.bal.customerbal;

import com.example.carrentalsystem.dao.vehicledao.VehicleDAO;
import com.example.carrentalsystem.dao.vehicledao.VehicleDAOImpl;
import com.example.carrentalsystem.exception.CustomerNotFoundException;
import com.example.carrentalsystem.exception.VehicleNotFoundException;
import com.example.carrentalsystem.model.Customer;
import com.example.carrentalsystem.model.Vehicle;

import java.sql.SQLException;
import java.util.List;

public class VehicleBal {
    static VehicleDAO vehicleDAO;
    static {
        vehicleDAO=new VehicleDAOImpl();
    }
    public boolean checkVehicleID(int vehicleID) throws VehicleNotFoundException, SQLException, ClassNotFoundException {
        if(vehicleDAO.findVehicleById(vehicleID)==null){
            throw new VehicleNotFoundException("Vehicle ID not Found");
        }
        else return true;
    }
    public void addVehicleBal(Vehicle vehicle) throws SQLException, ClassNotFoundException {
        vehicleDAO.addVehicle(vehicle);
    }
    public void removeVehicleBal(int vehicleID) throws SQLException, ClassNotFoundException, VehicleNotFoundException {
        if(checkVehicleID(vehicleID)){
        vehicleDAO.removeVehicle(vehicleID);
        }
    }

    public List<Vehicle> listAvailableVehiclesBal() throws SQLException, ClassNotFoundException {
        return vehicleDAO.listAvailableVehicles();
    }
    public List<Vehicle> listRentedVehiclesBal() throws SQLException, ClassNotFoundException {
        return vehicleDAO.listRentedVehicles();
    }
    public Vehicle findVehicleByIdBal(int vehicleID) throws SQLException, ClassNotFoundException, VehicleNotFoundException {
        if(checkVehicleID(vehicleID)){
        return vehicleDAO.findVehicleById(vehicleID);
        }
        return null;
    }
}
