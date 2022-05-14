package GUI;
import Database.Connector;
import Product.Product;
import Product.ProductUtilization;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;

public class WorkerController {
    @FXML
    private VBox pnItems = null;
    @FXML
    private Button btnHome;

    @FXML
    private Button btnMyinfo;

    @FXML
    private Button btnStock;

    @FXML
    private Button btnAddsale;

    @FXML
    private Button btnSettings;

    @FXML
    private Button btnSignout;
    @FXML
    private Pane pnStock;
    @FXML
    private Pane pnHome;

    @FXML
    private Pane pnMyinfo;

    @FXML
    private Pane pnAddsale;

    @FXML
    private Pane pnSettings;

    @FXML
    private Pane pnSignout;
    @FXML
    private TextField productid_sale;

    @FXML
    private Button btn_Regsale;

    @FXML
    private TextField brand_sale;

    @FXML
    private TextField quantity_sale;

    @FXML
    private Label addsale_msg;
    @FXML
    private Label stock_field;

    @FXML
    private Label prodsold_field;

    @FXML
    private Label income_field;
    @FXML
    private Label stock_field1;

    @FXML
    private Label prodsold_field1;

    @FXML
    private Label income_field1;

    @FXML
    private TableView<Product> table;

    @FXML
    private TableColumn<Product,String> tc_productname;

    @FXML
    private TableColumn<Product, String> tc_brand;

    @FXML
    private TableColumn<Product, Float> tc_price;

    @FXML
    private TableColumn<Product, Integer> tc_quantity;
    @FXML
    private TableColumn<Product, Integer> tc_productid;

    public WorkerController() {
    }

    public void table() throws SQLException {
        String query = "SELECT * FROM product";
        String query2 = "Select count(idproduct) from product";
        //Create a bew connector :
        Connector quant = new Connector();
        ResultSet result = null;

        result = quant.read(query2);

        //move to next row:
        result.next();
        int size = result.getInt("count(idproduct)");
        result.close();
        result = quant.read(query);
        System.out.println(size);
        tc_productname.setCellValueFactory(new PropertyValueFactory<>("productname"));
        tc_quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        tc_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        tc_brand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        tc_productid.setCellValueFactory(new PropertyValueFactory<>("productid"));
        while (result.next()) {
            int product_id = result.getInt("idproduct");
            String productname = result.getString("productname");
            String brand = result.getString("brand");
            int quantity = result.getInt("quantity");
            float price = result.getFloat("price");
            DecimalFormat df = new DecimalFormat("###.##");
            df.format(price);
            System.out.println(product_id + " " + productname + " " + brand + " " + quantity + " " + price);
            table.getItems().add(new Product(product_id, productname, quantity, brand, price));

        }
    }



    public void handleClicks(javafx.event.ActionEvent actionEvent) {
        try {
            if (actionEvent.getSource() == btnHome) {
                StockStats();
                pnHome.toFront();
            }
            if (actionEvent.getSource() == btnMyinfo) {
                pnMyinfo.toFront();
            }
            if (actionEvent.getSource() == btnStock) {
                StockStats();
                table.getItems().clear();
                table();
                pnStock.toFront();
            }
            if (actionEvent.getSource() == btnAddsale) {
                pnAddsale.toFront();
            }
            if (actionEvent.getSource() == btnSettings) {
                pnSettings.toFront();
            }
            if (actionEvent.getSource() == btnSignout) {
                Stage stage = (Stage) btnSignout.getScene().getWindow();
                stage.close();
            }
        } catch (SQLException e){

        }

    }


    public void Registersalebutton(javafx.event.ActionEvent event) throws SQLException {
        try{
            if (quantity_sale.getText().isBlank() || productid_sale.getText().isBlank()) {
                addsale_msg.setText("Failed to validate sale. All fields required");
                return;
            }
            Connector quant = new Connector();
            String productid = productid_sale.getText().toString();
            if (productid.isEmpty()) {
                addsale_msg.setText("Something went wrong, Input product ID to add a sale!");
                return;
            }
            int id = Integer.parseInt(productid);
            ResultSet found = quant.read("select * from product where idproduct='" + id + "'");
            if (!found.next()) {
                addsale_msg.setText("Something went wrong. The ID provided is not in the database !");
                return;
            }
            int salequantity = Integer.parseInt(quantity_sale.getText().toString());
            String query = "SELECT quantity,quantitysold FROM product WHERE idproduct='" +productid + "'";
            //Create a bew connector :
            ResultSet result = quant.read(query);
            //move to next row:
            result.next();

            int stockquant = result.getInt("quantity");
            int soldquant = result.getInt("quantitysold");
            if (stockquant - salequantity < 0) {
                addsale_msg.setAlignment(Pos.CENTER);
                addsale_msg.setText("Quantity larger than quantity availible in stock . Max Quantity is " + stockquant);
                return;

            }

            int newquant = stockquant-salequantity;
            int newsoldquant=soldquant+salequantity;
            String query1 = "update product set quantity='"+newquant+"',quantitysold='"+newsoldquant+"'where idproduct='"+productid+"'";
            int result1 = quant.create(query1);
            addsale_msg.setText("Sale succesfully added");
            return;
        } catch (Exception exception) {

            addsale_msg.setText("Something went wrong, Invalid type for the required field!");

        }
    }
    public void StockStats() throws SQLException{

        Connector connect = new Connector();
            ResultSet result = connect.read("select sum(quantity) as stock  from product");
            result.next();
            String stock = result.getString("stock");
            stock_field.setText(stock);
            stock_field1.setText(stock);
            result = connect.read("select sum(quantitysold) as sold from product");
            result.next();
            String sold = result.getString("sold");
            prodsold_field.setText(sold);
            prodsold_field1.setText(sold);
            result = connect.read("select sum(quantitysold*price) as income from product");
            result.next();
            float income = result.getFloat("income");
            DecimalFormat df = new DecimalFormat("###.##");
            df.format(income);
            income_field.setText(income+" DT");
            income_field1.setText(income+ " DT");

            System.out.println("Stock ="+stock+" Income = "+income+" Sold ="+sold);
    }


}
