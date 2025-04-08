package com.example.carrentalsystem.model;

import java.util.Date;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Lease {
    private int leaseID;
    private int vehicleID;
    private int customerID;
    private Date startDate;
    private Date endDate;
    private Type type;
}
