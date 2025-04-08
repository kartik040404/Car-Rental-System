package com.example.carrentalsystem.main;

import com.example.carrentalsystem.bal.customerbal.CustomerBal;
import com.example.carrentalsystem.bal.customerbal.VehicleBal;
import com.example.carrentalsystem.exception.VehicleNotFoundException;
import com.example.carrentalsystem.model.Customer;
import com.example.carrentalsystem.model.Status;
import com.example.carrentalsystem.model.Vehicle;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleMain {
    VehicleBal vehicleBal;
    Scanner sc;
    VehicleMain(){
        sc=new Scanner(System.in);
        vehicleBal=new VehicleBal();
    }
    public void addVehicleMain() throws SQLException, ClassNotFoundException {
        Vehicle vehicle=new Vehicle();
        System.out.println("Enter Vehicle ID:");
        vehicle.setVehicleID(sc.nextInt());
        System.out.println("Enter make:");
        vehicle.setMake(sc.next());
        System.out.println("Enter Mdoel:");
        vehicle.setModel(sc.next());
        System.out.println("Enter Year: ");
        vehicle.setYear(sc.nextInt());
        System.out.println("Enter Daily Rate");
        vehicle.setDailyRate(sc.nextDouble());
        System.out.println("Enter Status (Available/NotAvailable)");
        vehicle.setStatus(Status.valueOf(sc.next()));
        System.out.println("Enter Passenger Capacity");
        vehicle.setPassengerCapacity(sc.nextInt());
        System.out.println("Enter Engine Capacity");
        vehicle.setEngineCapacity(sc.nextDouble());
        vehicleBal.addVehicleBal(vehicle);
    }

    public void removeVehicleMain() throws SQLException, ClassNotFoundException, VehicleNotFoundException {
        int vehicleID;
        System.out.println("Enter Vehicle ID");
        vehicleID=sc.nextInt();
        vehicleBal.removeVehicleBal(vehicleID);
    }

    public void listAvailableVehiclesMain() throws SQLException, ClassNotFoundException {
        List<Vehicle> vehicleList=new ArrayList<>();
        vehicleList=vehicleBal.listAvailableVehiclesBal();
        if(!vehicleList.isEmpty()){
            for(Vehicle vehicle:vehicleList){
                System.out.println(vehicle);
            }
        }
        else System.out.println("No records found");
    }

    public void listRentedVehiclesMain() throws SQLException, ClassNotFoundException {
        List<Vehicle> vehicleList=new ArrayList<>();
        vehicleList=vehicleBal.listRentedVehiclesBal();
        if(!vehicleList.isEmpty()){
            for(Vehicle vehicle:vehicleList){
                System.out.println(vehicle);
            }
        }
        else System.out.println("No records found");
    }

    public void findVehicleByIdMain() throws SQLException, ClassNotFoundException, VehicleNotFoundException {
        int vehicleID;
        System.out.println("Enter Vehicle ID:");
        vehicleID=sc.nextInt();
        try {

        Vehicle vehicle=vehicleBal.findVehicleByIdBal(vehicleID);
            System.out.println(vehicle);
//        if(vehicle!=null) System.out.println(vehicle);
//        else System.out.println("No vehicle found");
        }
        catch(VehicleNotFoundException e){
            System.err.println(e.getMessage());
        }
    }
}
