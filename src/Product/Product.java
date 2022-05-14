package Product;

import java.text.DecimalFormat;

public class Product {
    private int productid;

    public Product(int productid, String productname, int quantity, String brand, double price) {
        DecimalFormat df = new DecimalFormat("###.##");
        df.format(price);
        this.productid = productid;
        this.productname = productname;
        this.quantity = quantity;
        this.brand = brand;
        this.price = price;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    private String productname;
    private int quantity;
    private String brand;
    private double price;

    public Product(String productname, int quantity, String brand, double price) {

        this.productname = productname;
        this.quantity = quantity;
        this.brand = brand;
        this.price = price;
    }

    public Product(String productname, int quantity, String brand) {
        this.productname = productname;
        this.quantity = quantity;
        this.brand = brand;
    }

    public void showproducts(){}
    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
