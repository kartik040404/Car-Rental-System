package com.example.carrentalsystem;

import com.example.carrentalsystem.model.Lease;
import com.example.carrentalsystem.model.Status;
import com.example.carrentalsystem.model.Type;
import com.example.carrentalsystem.model.Vehicle;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LeaseTest {

    static SimpleDateFormat simpleDateFormat;
    static {
        simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
    }
    @Test
    public void testGetterAndSetter() throws ParseException {
        Lease lease=new Lease();
        lease.setLeaseID(1);
        lease.setVehicleID(1);
        lease.setCustomerID(1);
        lease.setStartDate(simpleDateFormat.parse("2024-03-01"));
        lease.setEndDate(simpleDateFormat.parse("2024-03-05"));
        lease.setType(Type.valueOf("DailyLease"));
        assertEquals(1,lease.getLeaseID());
        assertEquals(1,lease.getVehicleID());
        assertEquals(1,lease.getCustomerID());
        assertEquals("2024-03-01",simpleDateFormat.format(lease.getStartDate()));
        assertEquals("2024-03-05",simpleDateFormat.format(lease.getEndDate()));
        assertEquals("DailyLease",lease.getType().name());
    }

    @Test
    public void testToString() throws ParseException {
        Lease lease=new Lease(1, 1, 1,  simpleDateFormat.parse("2024-03-01"), simpleDateFormat.parse("2024-03-05"),Type.valueOf("DailyLease"));
        String result="Lease(leaseID=1, vehicleID=1, customerID=1, startDate=Fri Mar 01 00:00:00 IST 2024, endDate=Tue Mar 05 00:00:00 IST 2024, type=DailyLease)";
        assertEquals(lease.toString(),result);
    }

    @Test
    public void testConstructor() throws ParseException {
        Lease lease=new Lease();
        assertNotNull(lease);
        Lease lease1=new Lease(1, 1, 1,  simpleDateFormat.parse("2024-03-01"), simpleDateFormat.parse("2024-03-05"),Type.valueOf("DailyLease"));
        assertEquals(1,lease1.getLeaseID());
        assertEquals(1,lease1.getVehicleID());
        assertEquals(1,lease1.getCustomerID());
        assertEquals("2024-03-01",simpleDateFormat.format(lease1.getStartDate()));
        assertEquals("2024-03-05",simpleDateFormat.format(lease1.getEndDate()));
        assertEquals("DailyLease",lease1.getType().name());
    }
}
