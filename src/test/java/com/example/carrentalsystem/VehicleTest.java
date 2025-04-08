package com.example.carrentalsystem;

import com.example.carrentalsystem.model.Customer;
import com.example.carrentalsystem.model.Status;
import com.example.carrentalsystem.model.Vehicle;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class VehicleTest {
    @Test
    public void testGetterAndSetter(){
        Vehicle vehicle=new Vehicle();
        vehicle.setVehicleID(1);
        vehicle.setMake("Toyota");
        vehicle.setModel("Corolla");
        vehicle.setYear(2022);
        vehicle.setDailyRate(50);
        vehicle.setStatus(Status.valueOf("Available"));
        vehicle.setPassengerCapacity(5);
        vehicle.setEngineCapacity(1);
        assertEquals(1,vehicle.getVehicleID());
        assertEquals("Toyota",vehicle.getMake());
        assertEquals("Corolla",vehicle.getModel());
        assertEquals(2022,vehicle.getYear());
        assertEquals(50.0,vehicle.getDailyRate(),50.0);
        assertEquals("Available",vehicle.getStatus().name());
        assertEquals(5,vehicle.getPassengerCapacity());
        assertEquals(1.0,vehicle.getEngineCapacity(),1.0);
    }

    @Test
    public void testToString(){
        Vehicle vehicle=new Vehicle(1,"Toyota","Corolla",2022,50,Status.valueOf("Available"),5,1);
        String result="Vehicle(vehicleID=1, make=Toyota, model=Corolla, year=2022, dailyRate=50.0, status=Available, passengerCapacity=5, engineCapacity=1.0)";
        assertEquals(vehicle.toString(),result);
    }

    @Test
    public void testConstructor(){
        Vehicle vehicle=new Vehicle();
        assertNotNull(vehicle);
        Vehicle vehicle1=new Vehicle(1,"Toyota","Corolla",2022,50,Status.valueOf("Available"),5,1);
        assertEquals(1,vehicle1.getVehicleID());
        assertEquals("Toyota",vehicle1.getMake());
        assertEquals("Corolla",vehicle1.getModel());
        assertEquals(2022,vehicle1.getYear());
        assertEquals(50,vehicle1.getDailyRate(),50.0);
        assertEquals("Available",vehicle1.getStatus().name());
        assertEquals(5,vehicle1.getPassengerCapacity());
        assertEquals(1,vehicle1.getEngineCapacity(),1.0);
    }
}
