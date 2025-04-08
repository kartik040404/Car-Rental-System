package com.example.carrentalsystem.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    private int vehicleID;
    private String make;
    private String model;
    private int year;
    private double dailyRate;
    private Status status;
    private int passengerCapacity;
    private double engineCapacity;

}
//Vehicle(vehicleID=1, make=Toyota, model=Corolla, year=2022, dailyRate=50.0, status=Available, passengerCapacity=5, engineCapacity=1.0)