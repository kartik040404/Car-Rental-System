package com.example.carrentalsystem.model;

import java.util.Date;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Payment {
    private int paymentID;
    private int leaseID;
    private Date paymentDate;
    private double amount;


}
