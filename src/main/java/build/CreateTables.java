package build;
import java.sql.*;

public class CreateTables {

    public static void initTableCustomers () throws SQLException {
        Util ut = new Util();
        Statement st = ut.getConnection().createStatement();

        try {
            st.execute("CREATE TABLE Customers ( cust_id INT NOT NULL PRYMARY KEY AUTO_INCREMENT,first_name VARCHAR(50)" +
                    "NOT NULL,last_name VARCHAR(50),phone VARCHAR(20)NOT NULL,adress VARCHAR(125)");
            st.execute("ALTER TABLE Customers AUTO_INCREMENT = 1001");

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            st.close();
        }
    }
    public static void initTableProducts() throws SQLException {
        Util ut = new Util();
        Statement st = ut.getConnection().createStatement();

        try {
            st.execute("CREATE TABLE Products " +
                    "(prod_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT," +
                    "name VARCHAR(128)NOT NULL," +
                    "price INT NOT NULL,guantity INT");
            st.execute("ALTER TABLE Products AUTO_INCREMENT = 2001");

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            st.close();
        }
    }
    public static void initTableOrders() throws SQLException {
        Util ut = new Util();
        Statement st = ut.getConnection().createStatement();

        try {
            st.execute("CREATE TABLE Orders (ord_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,cost_of_delivery INT NOT NULL" +
                    "ordDate DATE NOT NULL,customerId INT NOT NULL,productId INT NOT NULL,FOREIGN KEY (customerId) REFERENCES" +
                    "Customers (cust_id),ON UPDATE CASCADE,ON DELETE RESTRICT,FOREGIN KEY (productId) REFERENCES Product (prod_id)," +
                    "ON UPDATE CASCADE,ON DELETE RESTRICT");
             st.execute("ALTER TABLE Orders AUTO INCREMENT = 3001");

        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            st.close();
        }

    }
}
