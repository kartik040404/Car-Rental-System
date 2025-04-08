package com.example.carrentalsystem.dao.leasedao;

import com.example.carrentalsystem.model.Lease;

 import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface LeaseDAO {
    void createLease(int customerID, int carID, Date startDate, Date endDate) throws SQLException, ClassNotFoundException;
    Lease returnCar(int leaseID) throws SQLException, ClassNotFoundException;
    List<Lease> listActiveLease() throws SQLException, ClassNotFoundException;
    List<Lease> listLeaseHistory() throws SQLException, ClassNotFoundException;

}
