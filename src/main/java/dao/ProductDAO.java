package dao;

import entity.Products;

import java.sql.SQLException;
import java.util.List;

public interface ProductDAO {

    //create;
    void add (Products prdc) throws SQLException;
    //read;
    List<Products> getAll () throws SQLException;

    List<Products> getParameter () throws SQLException;
    //update;
    void update (Products prdc) throws SQLException;
    //delete;
    void remove (Products prdc) throws SQLException;
}
