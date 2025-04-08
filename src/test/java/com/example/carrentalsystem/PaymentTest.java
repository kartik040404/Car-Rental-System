package com.example.carrentalsystem;

import com.example.carrentalsystem.model.Payment;
import com.example.carrentalsystem.model.Status;
import com.example.carrentalsystem.model.Vehicle;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PaymentTest {
    static SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
    @Test
    public void testGetterAndSetter() throws ParseException {
        Payment payment=new Payment();
        payment.setPaymentID(1);
        payment.setLeaseID(1);
        payment.setPaymentDate(simpleDateFormat.parse("2025-01-01"));
        payment.setAmount(500);
        assertEquals(1,payment.getPaymentID());
        assertEquals(1,payment.getLeaseID());
        assertEquals("2025-01-01",simpleDateFormat.format(payment.getPaymentDate()));
        assertEquals(500.0,payment.getAmount(),500.0);
    }

    @Test
    public void testToString() throws ParseException {
        Payment payment=new Payment(1,1,simpleDateFormat.parse("2025-01-01"),500);
        String result="Payment(paymentID=1, leaseID=1, paymentDate=Wed Jan 01 00:00:00 IST 2025, amount=500.0)";
        assertEquals(payment.toString(),result);
    }

    @Test
    public void testConstructor() throws ParseException {
        Payment payment=new Payment();
        assertNotNull(payment);
        Payment payment1=new Payment(1,1,simpleDateFormat.parse("2025-01-01"),500);
        assertEquals(1,payment1.getPaymentID());
        assertEquals(1,payment1.getLeaseID());
        assertEquals("2025-01-01",simpleDateFormat.format(payment1.getPaymentDate()));
        assertEquals(500.0,payment1.getAmount(),500.0);
    }
}
