package entity;

import java.util.Objects;

public class Customers {



    private int cust_id;
    private String firstName;
    private String lsastName;
    private String phone;
    private String city;

    public Customers(){

    }

    public int getCust_id() {
        return cust_id;
    }

    public void setCust_id(int cust_id) {
        this.cust_id = cust_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLsastName() {
        return lsastName;
    }

    public void setLsastName(String lsastName) {
        this.lsastName = lsastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customers customers = (Customers) o;
        return cust_id == customers.cust_id &&
                Objects.equals(firstName, customers.firstName) &&
                Objects.equals(lsastName, customers.lsastName) &&
                Objects.equals(phone, customers.phone) &&
                Objects.equals(city, customers.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cust_id, firstName, lsastName, phone, city);
    }

    @Override
    public String toString() {
        return "Customers{" +
                "cust_id=" + cust_id +
                ", firstName='" + firstName + '\'' +
                ", lsastName='" + lsastName + '\'' +
                ", phone='" + phone + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
