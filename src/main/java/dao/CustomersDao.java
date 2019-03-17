package dao;

import entity.Customers;

import java.sql.SQLException;
import java.util.List;

public interface CustomersDao {
    //create;
    void add (Customers cust) throws SQLException;

    //read;
    List<Customers> getAll () throws SQLException;

    List<Customers> getParameter () throws SQLException;

    //update;
    void update (Customers cust) throws SQLException;
    //delete;
    void remove (Customers cust) throws SQLException;
}
