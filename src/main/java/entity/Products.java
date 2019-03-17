package entity;

import java.util.Objects;

public class Products {
    private int prod_id;
    private String name;
    private int price;
    private int guantity;

    public Products(){

    }

    public int getProd_id() {
        return prod_id;
    }

    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getGuantity() {
        return guantity;
    }

    public void setGuantity(int guantity) {
        this.guantity = guantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return prod_id == products.prod_id &&
                price == products.price &&
                guantity == products.guantity &&
                Objects.equals(name, products.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prod_id, name, price, guantity);
    }

    @Override
    public String toString() {
        return "Products{" +
                "prod_id=" + prod_id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", guantity=" + guantity +
                '}';
    }
}
