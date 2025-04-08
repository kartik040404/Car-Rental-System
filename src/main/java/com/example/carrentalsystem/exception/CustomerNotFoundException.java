package com.example.carrentalsystem.exception;

public class CustomerNotFoundException extends Exception{
        public CustomerNotFoundException(String error){
            super(error);
        }
}
