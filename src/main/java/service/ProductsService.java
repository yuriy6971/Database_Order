package service;
import build.Util;
import dao.ProductDAO;
import entity.Products;

import java.util.*;
import java.sql.*;


public class ProductsService extends Util implements ProductDAO {

    Connection conn = getConnection();

    public ProductsService() throws SQLException {
    }

    @Override
    public void add(Products prod) throws SQLException {
        PreparedStatement ps = null;
        String sql = "INSERT INTO Products (name,price,weight VALUES (?,?,?)) ";
        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1,prod.getName());
            ps.setInt(2,prod.getPrice());
            ps.setInt(3,prod.getGuantity());

            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }ps.close();
        conn.close();

    }

    @Override
    public List<Products> getAll() throws SQLException {
        List<Products> listprod = new ArrayList<>();

        String sgl = "SELECT * FROM Customers";
        Statement st = null;
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sgl);

            while (rs.next()){
                Products prod = new Products();
                prod.setProd_id(rs.getInt(1));
                prod.setName(rs.getString(2));
                prod.setPrice(rs.getInt(3));
                prod.setGuantity(rs.getInt(4));


                listprod.add(prod);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            st.close();
            conn.close();;
        }

        return listprod;
    }

    @Override
    public List<Products> getParameter() throws SQLException {
        Scanner sc = new Scanner(System.in);
        List<Products> listprodparam = new ArrayList<>();
        System.out.println("Enter conditions for selecting Products");
        String st = sc.nextLine();
        String sql = "SELECT * FROM Customers WHERE";
        String sqlSumm = st + sql;

        Statement stat = null;
        try {
            stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sqlSumm);

            while (rs.next()){

                Products prod = new Products();
                prod.setProd_id(rs.getInt(1));
                prod.setName(rs.getString(2));
                prod.setPrice(rs.getInt(3));
                prod.setGuantity(rs.getInt(4));

                listprodparam.add(prod);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            stat.close();
            conn.close();
        }
        return listprodparam;
    }

    @Override
    public void update(Products prod) throws SQLException {
        PreparedStatement ps = null;
        String sql = "UPDATE Customers SET name ?,price ?,guantity ?, WHERE prod_id ?";
        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1,prod.getName());
            ps.setInt(2,prod.getPrice());
            ps.setInt(3,prod.getGuantity());
            ps.setInt(5,prod.getProd_id());

            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            ps.close();
            conn.close();
        }


    }

    @Override
    public void remove(Products prod) throws SQLException {
        PreparedStatement ps = null;

        String sql = "DELETE FROM Customers WHERE cust_id ?";
        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1,prod.getProd_id());

            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            ps.close();
            conn.close();
        }

    }
}
