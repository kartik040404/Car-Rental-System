package com.example.carrentalsystem.main;

import com.example.carrentalsystem.bal.customerbal.CustomerBal;
import com.example.carrentalsystem.exception.CustomerNotFoundException;
import com.example.carrentalsystem.exception.LeaseNotFoundException;
import com.example.carrentalsystem.exception.VehicleNotFoundException;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class CarRentalSystemMain {
    static int ch;
    static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException, ParseException, CustomerNotFoundException, VehicleNotFoundException, LeaseNotFoundException {
        int choice;
        do {
            System.out.println("****** CAR RENTAL SYSTEM ******");
            System.out.println("Enter your choice:");
            System.out.println("1) Customer");
            System.out.println("2) Vehicle");
            System.out.println("3) Lease");
            System.out.println("4) Payment");
            System.out.println("5) Exit");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    CustomerMain customerMain = new CustomerMain();
                    do {
                        System.out.println("* Customer");
                        System.out.println("1) Add Customer");
                        System.out.println("2) Remove Customer");
                        System.out.println("3) Show Customer");
                        System.out.println("4) Search Customer");
                        System.out.println("5) Exit");
                        ch = scanner.nextInt();
                        switch (ch) {
                            case 1:
                                customerMain.addCustomerMain();
                                break;
                            case 2:
                                customerMain.removeCustomerMain();
                                break;
                            case 3:
                                customerMain.listCustomerMain();
                                break;
                            case 4:
                                customerMain.findCustomerByIdMain();
                                break;
                            case 5:
                                break;
                            default:
                                System.out.println("Wrong choice,Please enter valid choice");
                        }
                    } while (ch != 5);
                    break;
                case 2:
                    VehicleMain vehicleMain = new VehicleMain();
                    do {
                        System.out.println("* Vehicle");
                        System.out.println("1) Add Vehicle");
                        System.out.println("2) Remove Vehicle");
                        System.out.println("3) Show Available Vehicle");
                        System.out.println("4) Show Rented Vehicle");
                        System.out.println("5) Search Vehicle");
                        System.out.println("6) Exit");
                        ch = scanner.nextInt();
                        switch (ch) {
                            case 1:
                                vehicleMain.addVehicleMain();
                                break;
                            case 2:
                                vehicleMain.removeVehicleMain();
                                break;
                            case 3:
                                vehicleMain.listAvailableVehiclesMain();
                                break;
                            case 4:
                                vehicleMain.listRentedVehiclesMain();
                                break;
                            case 5:
                                vehicleMain.findVehicleByIdMain();
                                break;
                            case 6:
                                break;
                            default:
                                System.out.println("Wrong choice,Please enter valid choice");
                        }
                    } while (ch != 6);
                    break;
                case 3:
                     LeaseMain leaseMain=new LeaseMain();
                    do {
                        System.out.println("* Lease");
                        System.out.println("1) Create Lease Record");
                        System.out.println("2) Search Lease Record");
                        System.out.println("3) Show Active Lease Record");
                        System.out.println("4) Show History Lease Record");
                        System.out.println("5) Exit");
                        ch = scanner.nextInt();
                        switch (ch) {
                            case 1:
                                leaseMain.createLeaseMain();
                                break;
                            case 2:
                                leaseMain.returnCarMain();
                                break;
                            case 3:
                                leaseMain.listActiveLeaseMain();
                                break;
                            case 4:
                                leaseMain.listLeaseHistoryMain();
                                break;
                            case 5:
                                break;
                            default:
                                System.out.println("Wrong choice,Please enter valid choice");
                        }
                    } while (ch != 5);
                    break;

                case 4:
                     PaymentMain paymentMain=new PaymentMain();
                    do {
                        System.out.println("* Payment");
                        System.out.println("1) Record Payment");
                        System.out.println("2) Exit");
                        ch = scanner.nextInt();
                        switch (ch) {
                            case 1:
                                paymentMain.recordPaymentMain();
                                break;
                            case 2:
                                break;
                            default:
                                System.out.println("Wrong choice,Please enter valid choice");
                        }
                    } while (ch != 2);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Wrong choice,please enter valid choice");
            }
        } while (choice != 5);
    }
}
