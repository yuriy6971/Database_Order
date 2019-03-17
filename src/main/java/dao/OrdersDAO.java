package dao;

import entity.Orders;

import java.sql.SQLException;
import java.util.List;

public interface OrdersDAO {
    //create;
    void add (Orders ord) throws SQLException;

    //read;
    List<Orders> getAll () throws SQLException;

    List<Orders> getParameter() throws SQLException;

    //delete;
    void remove (Orders ord) throws SQLException;
}
