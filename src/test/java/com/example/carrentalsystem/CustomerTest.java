package com.example.carrentalsystem;

import com.example.carrentalsystem.model.Customer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CustomerTest {
    @Test
    public void testGetterAndSetter(){
            Customer customer=new Customer();
            customer.setCustomerID(1);
            customer.setFirstName("firstName");
            customer.setLastName("lastName");
            customer.setEmail("email@example.com");
            customer.setPhoneNumber("1212121212");
            assertEquals(1,customer.getCustomerID());
            assertEquals("firstName",customer.getFirstName());
            assertEquals("lastName",customer.getLastName());
            assertEquals("email@example.com",customer.getEmail());
            assertEquals("1212121212",customer.getPhoneNumber());
    }

    @Test
    public void testToString(){
        Customer customer=new Customer(1,"firstName","lastName","email@example.com","1212121212");
        String result="Customer{customerID=1, firstName='firstName', lastName='lastName', email='email@example.com', phoneNumber='1212121212'}\n";
        assertEquals(customer.toString()+"\n",result);
    }

    @Test
    public void testConstructor(){
        Customer customer=new Customer();
        assertNotNull(customer);
        Customer customer1=new Customer(1,"firstName","lastName","email@example.com","1212121212");
        assertEquals(1,customer1.getCustomerID());
        assertEquals("firstName",customer1.getFirstName());
        assertEquals("lastName",customer1.getLastName());
        assertEquals("email@example.com",customer1.getEmail());
        assertEquals("1212121212",customer1.getPhoneNumber());
    }
}
