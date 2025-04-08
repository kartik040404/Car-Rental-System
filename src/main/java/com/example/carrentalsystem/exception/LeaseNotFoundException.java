package com.example.carrentalsystem.exception;

public class LeaseNotFoundException extends Exception{
        public LeaseNotFoundException(String error){
            super(error);
        }
}
