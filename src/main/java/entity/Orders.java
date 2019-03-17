package entity;

import java.util.Date;
import java.util.Objects;

public class Orders {

    private int ord_id;
    private int cost_of_delivery;
    private Date ordDate;
    private int customerId;
    private int productId;

    public Orders(){

    }

    public int getId() {
        return ord_id;
    }

    public void setId(int id) {
        this.ord_id = ord_id;
    }

    public int getCost_of_delivery() {
        return cost_of_delivery;
    }

    public void setCost_of_delivery(int cost_of_delivery) {
        this.cost_of_delivery = cost_of_delivery;
    }

    public java.sql.Date getOrdDate() {
        return (java.sql.Date) ordDate;
    }

    public void setOrdDate(Date ordDate) {
        this.ordDate = ordDate;
    }

    public int getCust_id() {
        return customerId;
    }

    public void setCust_id(int cust_id) {
        this.customerId = customerId;
    }

    public int getProd_id() {
        return productId;
    }

    public void setProd_id(int prod_id) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return ord_id == orders.ord_id &&
                cost_of_delivery == orders.cost_of_delivery &&
                customerId == orders.customerId &&
                productId == orders.productId &&
                Objects.equals(ordDate, orders.ordDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ord_id, cost_of_delivery, ordDate, customerId, productId);
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + ord_id +
                ", cost_of_delivery=" + cost_of_delivery +
                ", ordDate=" + ordDate +
                ", cust_id=" + customerId +
                ", prod_id=" + productId +
                '}';
    }
}
