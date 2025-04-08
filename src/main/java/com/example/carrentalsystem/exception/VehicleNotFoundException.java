package com.example.carrentalsystem.exception;

public class VehicleNotFoundException extends Exception{
        public VehicleNotFoundException(String error){
            super(error);
        }
}
