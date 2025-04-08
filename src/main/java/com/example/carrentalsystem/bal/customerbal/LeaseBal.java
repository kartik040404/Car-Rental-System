package com.example.carrentalsystem.bal.customerbal;

import com.example.carrentalsystem.dao.leasedao.LeaseDAO;
import com.example.carrentalsystem.dao.leasedao.LeaseDAOImpl;
import com.example.carrentalsystem.exception.CustomerNotFoundException;
import com.example.carrentalsystem.exception.LeaseNotFoundException;
import com.example.carrentalsystem.model.Lease;

import java.util.Date;
import java.sql.SQLException;
import java.util.List;

public class LeaseBal {
    static LeaseDAO leaseDAO;
    static {
        leaseDAO=new LeaseDAOImpl();
    }
    public boolean checkLeaseID(int leaseID) throws LeaseNotFoundException, SQLException, ClassNotFoundException {
        if(leaseDAO.returnCar(leaseID)==null){
            throw new LeaseNotFoundException("Lease ID not Found");
        }
        else return true;
    }
    public void createLeaseBal(int customerID, int carID, Date startDate, Date endDate) throws SQLException, ClassNotFoundException {
        leaseDAO.createLease(customerID,carID,startDate,endDate);
    }

    public Lease returnCar(int leaseID) throws SQLException, ClassNotFoundException, LeaseNotFoundException {
        if(checkLeaseID(leaseID)){
        return leaseDAO.returnCar(leaseID);
        }
        return null;
    }
    public List<Lease> listActiveLease() throws SQLException, ClassNotFoundException {
        return leaseDAO.listActiveLease();
    }
    public List<Lease> listLeaseHistory() throws SQLException, ClassNotFoundException {
        return leaseDAO.listLeaseHistory();
    }
}
