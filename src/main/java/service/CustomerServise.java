package service;
import build.Util;
import dao.CustomersDao;
import entity.Customers;

import javax.swing.table.TableRowSorter;
import java.sql.*;
import java.util.*;


public class CustomerServise extends Util implements CustomersDao {

    Connection conn = getConnection();

    public CustomerServise() throws SQLException {
    }

    @Override
    public void add(Customers cust) throws SQLException {
        PreparedStatement ps = null;
        String sql = "INSERT INTO Customers (firstName,lastName,phone,city,VALUES (?,?,?,?)) ";
        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1,cust.getFirstName());
            ps.setString(2,cust.getLsastName());
            ps.setString(3,cust.getPhone());
            ps.setString(4,cust.getCity());

            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }ps.close();
         conn.close();

    }

    @Override
    public List<Customers> getAll() throws SQLException {
        List<Customers> listcust = new ArrayList<>();

        String sgl = "SELECT * FROM Customers";
        Statement st = null;
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sgl);

            while (rs.next()){
                Customers cust = new Customers();
                cust.setCust_id(rs.getInt(1));
                cust.setFirstName(rs.getString(2));
                cust.setLsastName(rs.getString(3));
                cust.setPhone(rs.getString(4));
                cust.setCity(rs.getString(5));

                listcust.add(cust);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            st.close();
            conn.close();;
        }

        return listcust;
    }

    @Override
    public List<Customers> getParameter() throws SQLException {
        Scanner sc = new Scanner(System.in);
        List<Customers> listcustparam = new ArrayList<>();
        System.out.println("Enter conditions for selecting customers");
        String st = sc.nextLine();
        String sql = "SELECT * FROM Customers WHERE";
        String sqlSumm = st + sql;

        Statement stat = null;
        try {
            stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sqlSumm);

            while (rs.next()){

                Customers cust = new Customers();
                cust.setCust_id(rs.getInt(1));
                cust.setFirstName(rs.getString(2));
                cust.setLsastName(rs.getString(3));
                cust.setPhone(rs.getString(4));
                cust.setCity(rs.getString(5));

                listcustparam.add(cust);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            stat.close();
            conn.close();
        }
        return listcustparam;
    }

    @Override
    public void update(Customers cust) throws SQLException {
        PreparedStatement ps = null;
        String sql = "UPDATE Customers SET firstName ?,lastname ?,phone ?,city ? WHERE cust_id ?";
        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1,cust.getFirstName());
            ps.setString(2,cust.getLsastName());
            ps.setString(3,cust.getPhone());
            ps.setString(4,cust.getCity());
            ps.setInt(5,cust.getCust_id());

            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            ps.close();
            conn.close();
        }


    }

    @Override
    public void remove(Customers cust) throws SQLException {
        PreparedStatement ps = null;

        String sql = "DELETE FROM Customers WHERE cust_id ?";
        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1,cust.getCust_id());

            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            ps.close();
            conn.close();
        }

    }
}
