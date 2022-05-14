package Product;

import Database.Connector;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductUtilization extends Product {
    public ProductUtilization(String productname, int quantity, String brand, double price) {
        super(productname, quantity, brand, price);
    }

    public ProductUtilization(String productname, int quantity, String brand) {
        super(productname, quantity, brand);
    }

    public int addsale() throws SQLException {
        String query = "SELECT quantity,quantitysold FROM product WHERE productname='" + this.getProductname() + "' and brand='" + this.getBrand() + "'";
        //Create a bew connector :
        Connector quant = new Connector();
        ResultSet result = quant.read(query);
        //move to next row:
        result.next();
        int stockquant = result.getInt("quantity");
        int soldquant = result.getInt("quantitysold");
        if (stockquant - this.getQuantity() < 0) {
            quant.end();
           return stockquant;
        }
        int newquant = stockquant-this.getQuantity();
        int newsoldquant=soldquant+this.getQuantity();
        String query1 = "update product set quantity='"+newquant+"',quantitysold='"+newsoldquant+"'where productname='"+this.getProductname()+"' and brand='"+this.getBrand()+"'";
        int result1 = quant.create(query1);
        return Integer.MAX_VALUE;
    }
}

