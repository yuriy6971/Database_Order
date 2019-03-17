package service;
import build.Util;
import dao.OrdersDAO;
import entity.Orders;

import javax.swing.text.TableView;
import java.sql.*;
import java.util.*;


public class OrderService extends Util implements OrdersDAO {

    Connection conn = getConnection();

    public OrderService() throws SQLException {
    }

    @Override
    public void add(Orders ord) throws SQLException {
        PreparedStatement ps = null;
        String sql = "INSERT INTO Orders (cost_of_delivery,ordDate,customerId,productId, VALUES (?,?,?,?))";
        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1,ord.getCost_of_delivery());
            ps.setDate(2,ord.getOrdDate());
            ps.setInt(3,ord.getCust_id());
            ps.setInt(4,ord.getProd_id());

            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            ps.close();
            conn.close();
        }
    }

    @Override
    public List<Orders> getAll() throws SQLException {
        List<Orders> listord = new ArrayList<>();
        String sql = "SELECT * FROM ORDERS";

        Statement st = null;
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()){
                Orders ord = new Orders();
                ord.setId(rs.getInt(1));
                ord.setCost_of_delivery(rs.getInt(2));
                ord.setOrdDate(rs.getDate(3));
                ord.setCust_id(rs.getInt(4));
                ord.setProd_id(rs.getInt(5));

                listord.add(ord);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            st.close();
            conn.close();
        }

        return listord;
    }

    @Override
    public List<Orders> getParameter() throws SQLException {
        Scanner sc = new Scanner(System.in);
        List<Orders> listorderparam = new ArrayList<>();
        System.out.println("Enter conditions for selecting orders");
        String str = sc.nextLine();
        String sql = "SELECT * FROM ORDERS WHERE";
        String sqlSnmm = str + sql;

        Statement st = null;
        try {
            st = conn.createStatement();

            ResultSet rs = st.executeQuery(sqlSnmm);
            while (rs.next()){
                Orders ord = new Orders();

                ord.setId(rs.getInt(1));
                ord.setCost_of_delivery(rs.getInt(2));
                ord.setOrdDate(rs.getDate(3));
                ord.setCust_id(rs.getInt(4));
                ord.setProd_id(rs.getInt(5));

                listorderparam.add(ord);
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            st.close();
            conn.close();
        }
        return listorderparam;
    }

    @Override
    public void remove(Orders ord) throws SQLException {
        PreparedStatement ps = null;
        String sql = "DELETE FROM Orders WHERE ord_id ?";
        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1,ord.getId());

            ps.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ps.close();
            conn.close();
        }



    }
}
