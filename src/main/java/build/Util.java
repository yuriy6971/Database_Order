package build;

import java.sql.*;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    static final String DB_CONNECTION = "jdbc:mysgl://localhost:3306/orders";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "a1234";


    public  Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            conn = (Connection) DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            System.out.println("Connection OK!");
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Connection Error");
        }
        return conn;
    }

}
