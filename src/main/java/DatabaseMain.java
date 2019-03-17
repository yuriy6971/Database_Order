
import build.CreateTables;
import entity.Customers;
import entity.Orders;
import entity.Products;
import service.CustomerServise;
import service.OrderService;
import service.ProductsService;

import java.util.*;
import java.sql.*;
import java.util.concurrent.Callable;


public class DatabaseMain {
    public static void main(String[] args) throws SQLException {

        CreateTables.initTableCustomers();
        CreateTables.initTableProducts();
        CreateTables.initTableOrders();

        CustomerServise custserv = new CustomerServise();
        ProductsService prodserv = new ProductsService();
        OrderService ordserv = new OrderService();

        Customers cust1 = new Customers();
        Customers cust2 = new Customers();

        cust1.setFirstName("Ivan");
        cust1.setLsastName("Petrov");
        cust1.setPhone("11223366");
        cust1.setCity("Chernigov");

        cust2.setFirstName("Igor");
        cust2.setLsastName("Ivanov");
        cust2.setPhone("222664455");
        cust2.setCity("Kiev");

        try {
            custserv.add(cust1);
            custserv.add(cust2);
        }catch (SQLException e){
            e.printStackTrace();
        }
        Products prod1 = new Products();
        Products prod2 = new Products();

        prod1.setName("television");
        prod1.setPrice(7500);

        prod2.setName("Washer");
        prod2.setPrice(5200);
        prod2.setGuantity(2);

        try {
            prodserv.add(prod1);
            prodserv.add(prod2);
        }catch (SQLException e){
            e.printStackTrace();
        }

        Orders ord1 = new Orders();
        Orders ord2 = new Orders();

        Calendar calen1 = Calendar.getInstance();
        calen1.set(2017,06,17);
        Calendar calen2 = Calendar.getInstance();
        calen2.set(2018,11,02);


        ord1.setCost_of_delivery(380);
        ord1.setOrdDate(new java.sql.Date(calen1.getTime().getTime()));
        ord1.setCust_id(1001);
        ord1.setProd_id(2001);

        ord2.setCost_of_delivery(170);
        ord2.setOrdDate(new java.sql.Date(calen2.getTime().getTime()));
        ord2.setCust_id(1002);
        ord2.setProd_id(2002);

        try {
            ordserv.add(ord1);
            ordserv.add(ord2);
        }catch (SQLException e){
            e.printStackTrace();
        }


    }
}
