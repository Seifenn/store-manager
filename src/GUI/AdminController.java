package GUI;

import Database.Connector;
import Product.Product;
import Product.ProductUtilization;
import admin.Worker;
import com.mysql.cj.protocol.Resultset;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.nio.FloatBuffer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.ResourceBundle;

public class AdminController {
    @FXML
    private Button btnHome;

    @FXML
    private Button btnStock;

    @FXML
    private Button btnManageProducts;

    @FXML
    private Button btnManageEmployees;

    @FXML
    private Button btnShowHistory;

    @FXML
    private Button btngetreport;

    @FXML
    private Button btnSignout;

    @FXML
    private Pane pnStock;

    @FXML
    private ScrollPane sc;

    @FXML
    private VBox pnItems;

    @FXML
    private Pane pnShowHistory;

    @FXML
    private ScrollPane sc1;

    @FXML
    private VBox pnItems1;

    @FXML
    private Pane pnSignout;

    @FXML
    private Pane pnaddproduct;

    @FXML
    private TextField product_name;

    @FXML
    private Button btnaddproduct;

    @FXML
    private Label addproduct_msg;

    @FXML
    private TextField product_brand;

    @FXML
    private TextField product_quantity;

    @FXML
    private TextField product_price;

    @FXML
    private Pane pnupdateproduct;

    @FXML
    private TextField productid_update_field;

    @FXML
    private Button btn_update_quantity;

    @FXML
    private Label updateproduct_msg;

    @FXML
    private TextField productname_update_field;

    @FXML
    private TextField brand_update_field;

    @FXML
    private TextField price_update_field;

    @FXML
    private TextField quantity_update_field;

    @FXML
    private Button btn_update_price;

    @FXML
    private Button btn_update_brand;

    @FXML
    private Button btn_update_productname;

    @FXML
    private Button btn_update_all_product;

    @FXML
    private Pane pnupdateemployee;

    @FXML
    private TextField empid_update_field;

    @FXML
    private Label updateemp_msg;

    @FXML
    private TextField empname_update_field;

    @FXML
    private Button btn_update_empname;

    @FXML
    private Button btn_update_all_emp;

    @FXML
    private TextField empusername_update_field;

    @FXML
    private Button btn_update_empusername;

    @FXML
    private TextField emplastname_update_field;

    @FXML
    private Button btn_update_emplastname;

    @FXML
    private TextField empCIN_update_field;

    @FXML
    private Button btn_update_empCIN;

    @FXML
    private TextField emppassword_update_field;

    @FXML
    private TextField empsalary_update_field;

    @FXML
    private Button btn_update_emppassword;

    @FXML
    private Button btn_update_empsalary;

    @FXML
    private Pane pnHome;

    @FXML
    private Pane pnremoveemployee;

    @FXML
    private Button btnremoveemployee;

    @FXML
    private Pane pndeleteproduct;

    @FXML
    private TextField product_id_delete;

    @FXML
    private Button btndeleteproduct;

    @FXML
    private Pane pnManageProducts;

    @FXML
    private Button btnaddprod;

    @FXML
    private Button btndeleteprod;

    @FXML
    private Button btnupdateprod;

    @FXML
    private Pane pngetreport;
    @FXML
    private Pane pnShowemployees;


    @FXML
    private Pane pnManageEmployees;

    @FXML
    private Button btnaddemp;

    @FXML
    private Button btnremoveemp;

    @FXML
    private Pane pnaddemployee;

    @FXML
    private TextField empfirstname;

    @FXML
    private Button btnaddemployee;

    @FXML
    private Label addemp_msg;

    @FXML
    private TextField emplastname;

    @FXML
    private TextField empusername;

    @FXML
    private TextField emppassword;

    @FXML
    private TextField empcin;

    @FXML
    private TextField empsalary;

    @FXML
    private Button btnupdateemp;

    @FXML
    private Button btn_update_all;

    @FXML
    private Label deleteproduct_msg;

    @FXML
    private TextField empid_delete_field;

    @FXML
    private Label deleteemp_msg;
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
    private Label stock_field2;

    @FXML
    private Label prodsold_field2;

    @FXML
    private Label income_field2;
    @FXML
    private Label product_id_field;

    @FXML
    private Label productname_field;

    @FXML
    private Label productbrand_field;

    @FXML
    private Label productquantity_field;

    @FXML
    private Label productprice_field;
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

    @FXML
    private TableView<Product> table1;

    @FXML
    private TableColumn<Product,String> tc_productname1;

    @FXML
    private TableColumn<Product, String> tc_brand1;

    @FXML
    private TableColumn<Product, Float> tc_price1;

    @FXML
    private TableColumn<Product, Integer> tc_quantity1;

    @FXML
    private TableColumn<Product, Integer> tc_productid1;

    @FXML
    private Button btnShowemployee;

    @FXML
    private TableView<Worker> EmpTable;

    @FXML
    private TableColumn<Worker,Integer> tc_empid;

    @FXML
    private TableColumn<Worker,String> tc_empname;

    @FXML
    private TableColumn<Worker,String> tc_emplastname;

    @FXML
    private TableColumn<Worker,String> tc_empusername;

    @FXML
    private TableColumn<Worker,String> tc_emppassword;

    @FXML
    private TableColumn<Worker,Integer> tc_empCIN;

    @FXML
    private TableColumn<Worker, Float> tc_empsalary;






    public AdminController() {

    }

    public void ShowEmployee() throws SQLException {
        String query = "SELECT * FROM worker";
        //Create a bew connector :
        Connector quant = new Connector();
        ResultSet result;
        //move to next row:
        result = quant.read(query);
        tc_empname.setCellValueFactory(new PropertyValueFactory<>("name"));
        tc_emplastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        tc_empusername.setCellValueFactory(new PropertyValueFactory<>("username"));
        tc_emppassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        tc_empid.setCellValueFactory(new PropertyValueFactory<>("empid"));
        tc_empsalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        tc_empCIN.setCellValueFactory(new PropertyValueFactory<>("cin"));

        while (result.next()) {
            int empid =result.getInt("idWorker");
            String name = result.getString("name");
            String lastname = result.getString("lastname");
            String username = result.getString("username");
            String password = result.getString("password");
            int cin = result.getInt("cin");
            float salary = result.getFloat("salary");
            DecimalFormat df = new DecimalFormat("###.##");
            df.format(salary);
            EmpTable.getItems().add(new Worker(name,lastname,username,password,cin,salary,empid));


        }
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
              int product_id =result.getInt("idproduct");
              String productname = result.getString("productname");
              String brand = result.getString("brand");
              int quantity = result.getInt("quantity");
              float price = result.getFloat("price");
              DecimalFormat df = new DecimalFormat("###.##");
              df.format(price);
              System.out.println(product_id+" "+productname + " " + brand + " " + quantity + " " + price);
              table.getItems().add(new Product(product_id,productname,quantity,brand,price));


          }
      }

    public void historyofsellings() throws SQLException {
        String query = "SELECT * FROM product";
        //Create a bew connector :
        Connector quant = new Connector();
        ResultSet result ;
        //move to next row:
        result = quant.read(query);
        tc_productname1.setCellValueFactory(new PropertyValueFactory<>("productname"));
        tc_quantity1.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        tc_price1.setCellValueFactory(new PropertyValueFactory<>("price"));
        tc_brand1.setCellValueFactory(new PropertyValueFactory<>("brand"));
        tc_productid1.setCellValueFactory(new PropertyValueFactory<>("productid"));
        while (result.next()) {
            int product_id =result.getInt("idproduct");
            String productname = result.getString("productname");
            String brand = result.getString("brand");
            int quantity = result.getInt("quantitysold");
            float price = result.getFloat("price");
            DecimalFormat df = new DecimalFormat("###.##");
            df.format(price);
            System.out.println(product_id+" "+productname + " " + brand + " " + quantity + " " + price);
            table1.getItems().add(new Product(product_id,productname,quantity,brand,price));


        }
    }

    public void handleClicks(javafx.event.ActionEvent actionEvent) {

            try {
                if (actionEvent.getSource() == btnHome) {
                    StockStats();
                    pnHome.toFront();
                }
                if (actionEvent.getSource() == btnManageProducts) {
                    pnManageProducts.toFront();
                }
                if (actionEvent.getSource() == btnManageEmployees) {
                    pnManageEmployees.toFront();
                }
                if (actionEvent.getSource() == btnShowHistory) {
                    table1.getItems().clear();
                    StockStats();
                    historyofsellings();
                    pnShowHistory.toFront();
                }
                if (actionEvent.getSource() == btnStock){
                    table.getItems().clear();
                    table();
                    StockStats();
                    pnStock.toFront();
                }
                if (actionEvent.getSource() == btnSignout) {
                    pnSignout.toFront();
                }
                if (actionEvent.getSource() == btnaddemp) {
                    pnaddemployee.toFront();
                }
                if (actionEvent.getSource() == btnremoveemp) {
                    pnremoveemployee.toFront();
                }
                if (actionEvent.getSource() == btnaddprod) {
                    pnaddproduct.toFront();
                }
                if (actionEvent.getSource() == btndeleteprod) {
                    pndeleteproduct.toFront();
                }
                if (actionEvent.getSource() == btngetreport) {
                    pngetreport.toFront();
                }
                if (actionEvent.getSource() == btnSignout) {
                    Stage stage = (Stage) btnSignout.getScene().getWindow();
                    stage.close();
                }
                if (actionEvent.getSource() == btnupdateprod) {
                    pnupdateproduct.toFront();
                }
                if (actionEvent.getSource() == btnupdateemp) {
                    pnupdateemployee.toFront();
                }
                if (actionEvent.getSource() == btnShowemployee) {
                    EmpTable.getItems().clear();
                    ShowEmployee();
                    pnShowemployees.toFront();
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }


    }

    public void AddProduct(javafx.event.ActionEvent event) throws SQLException {
        try {
            if (product_name.getText().isBlank() == true || product_brand.getText().isBlank() == true || product_price.getText().isBlank() == true || product_quantity.getText().isBlank() == true) {
                addproduct_msg.setText("Failed to add product. All fields required");
                return;
            }
            Connector connect = new Connector();
            String brand = product_brand.getText().toString();
            String product = product_name.getText().toString();
            int price = Integer.parseInt(product_price.getText().toString());
            int quantity = Integer.parseInt(product_quantity.getText().toString());
            Random rand = new Random();
            int id = rand.nextInt(Integer.MAX_VALUE);
            String query = "insert into product (idproduct, brand, productname ,quantity ,price) "
                    + " values( '" + id + "','" + brand + "','" + product + "','" + quantity + "','" + price + "')";

            int result = connect.create(query);
            if (result == 1) {
                addproduct_msg.setText("Product added successfully to the database");
            }
        } catch (Exception exception) {
            addproduct_msg.setText("Something went wrong, Invalid type for the required field!");
        }
    }



    public void DeleteProduct(javafx.event.ActionEvent event) {
        try {
            Connector connect = new Connector();
            String init = product_id_delete.getText();
            if (init.isEmpty()) {
                deleteproduct_msg.setText("Something went wrong, Input product ID to remove product!");
                return;
            }
            int id = Integer.parseInt(init.toString());
            ResultSet found = connect.read("select * from product where idproduct='" + id + "'");
            if (!found.next()) {
                deleteproduct_msg.setText("Something went wrong, Proper ID is required!");
                return;
            }
            int delete = connect.create("delete from product where idproduct ='"+ id +"'");
            if(delete == 1){
                deleteproduct_msg.setText("Product succesfully deleted");
            }
        } catch (Exception exception) {
            deleteproduct_msg.setText("Something went wrong, Invalid type for the required field!");
        }
    }

    public void UpdateProduct(javafx.event.ActionEvent event) {
        try {
            Connector connect = new Connector();
            String init = productid_update_field.getText();
            if (init.isEmpty()) {
                updateproduct_msg.setText("Something went wrong, Input product ID to be updated!");
                return;
            }
            int id = Integer.parseInt(init.toString());
            ResultSet found = connect.read("select * from product where idproduct='" + id + "'");
            if (!found.next()) {
                updateproduct_msg.setText("Something went wrong, Proper ID is required!");
                return;
            }
            String name = productname_update_field.getText().toString();
            String brand = brand_update_field.getText().toString();
            String price = price_update_field.getText().toString();
            String quantity = quantity_update_field.getText().toString();
            String query = "";
            String operation = "";

            if (!name.isEmpty() && btn_update_productname.isFocused()) {
                query = "update product set productname='" + name + "' where idproduct='" + id + "'";
                operation = "name";
            }
            if (!brand.isEmpty() && btn_update_brand.isFocused()) {
                query = "update product set brand='" + brand + "' where idproduct='" + id + "'";
                operation = "brand";
            }
            if (!price.isEmpty() && btn_update_price.isFocused()) {
                query = "update product set price='" + price + "' where idproduct='" + id + "'";
                operation = "price";
            }
            if (!quantity.isEmpty() && btn_update_quantity.isFocused()) {
                query = "update product set quantity='" + quantity + "' where idproduct='" + id + "'";
                operation = "quantity";
            }
            if (!(name.isEmpty() || brand.isEmpty() || price.isEmpty() || quantity.isEmpty()) && btn_update_all_product.isFocused()) {
                query = "update product set productname='" + name + "', brand='" + brand + "', quantity='" + quantity + "' , price='" + price + "' " + "where idproduct='" + id + "'";
                operation = "total specifications";
            }
            if (query != "") {
                int result = connect.create(query);
                updateproduct_msg.setText("Product " + operation + " updated successfully!");
                return;
            }
            updateproduct_msg.setText("Something went wrong, All targeted fields are required!");
        } catch (Exception exception) {
            updateproduct_msg.setText("Something went wrong, Invalid type for the required field!");
        }


    }
    public void AddEmployee(javafx.event.ActionEvent event) throws SQLException{
        try{
            if (empsalary.getText().isBlank() || empusername.getText().isBlank() || empfirstname.getText().isBlank() ||
                    emplastname.getText().isBlank() || empcin.getText().isBlank() || emppassword.getText().isBlank()) {
                addemp_msg.setText("Failed to add Employee. All fields required");
                return;
            }
            Connector connect = new Connector();
            String firstname = empfirstname.getText().toString();
            String lastname = emplastname.getText().toString();
            String username = empusername.getText().toString();
            String password = emppassword.getText().toString();
            int CIN = Integer.parseInt(empcin.getText().toString());
            float salary =Float.parseFloat(empsalary.getText().toString());
            Random rand = new Random();
            int id = rand.nextInt(Integer.MAX_VALUE);
            String query = "insert into worker (idWorker, name, lastname ,username ,password,cin,salary) "
                    + " values( '" + id + "','" + firstname + "','" + lastname + "','" + username
                    + "','" + password + "','"+ CIN +"','"+ salary +"')";

            int result = connect.create(query);
            if (result == 1) {
                addemp_msg.setText("Employee added successfully to the database");
            }

        } catch (Exception exception){
            addemp_msg.setText("Something went wrong, Invalid type for the required field!");
        }
    }
    public void DeleteEmployee(javafx.event.ActionEvent event) {
        try {
            Connector connect = new Connector();
            String init = empid_delete_field.getText();
            if (init.isEmpty()) {
                deleteemp_msg.setText("Something went wrong, Input employee ID to remove employee!");
                return;
            }
            int id = Integer.parseInt(init.toString());
            ResultSet found = connect.read("select * from worker where idWorker='" + id + "'");
            if (!found.next()) {
                deleteemp_msg.setText("Something went wrong. The ID provided is not in the database !");
                return;
            }
            int delete = connect.create("delete from worker where idWorker ='"+ id +"'");
            if(delete == 1){
                deleteemp_msg.setText("Employee successfully deleted");
            }
        } catch (Exception exception) {
            deleteemp_msg.setText("Something went wrong. Invalid type for the required field!");
        }
    }
    public void UpdateEmployee(javafx.event.ActionEvent event) {
        try {
            Connector connect = new Connector();
            String init = empid_update_field.getText();
            if (init.isEmpty()) {
                updateemp_msg.setText("Something went wrong, Input Employee ID to be updated!");
                return;
            }
            int id = Integer.parseInt(init.toString());
            ResultSet found = connect.read("select * from worker where idWorker='" + id + "'");
            if (!found.next()) {
                updateemp_msg.setText("Something went wrong . The ID provided is not in the database !");
                return;
            }
            String firstname = empname_update_field.getText().toString();
            String lastname = emplastname_update_field.getText().toString();
            String username = empusername_update_field.getText().toString();
            String password = emppassword_update_field.getText().toString();
            String CIN = empCIN_update_field.getText().toString();
            String salary = empsalary_update_field.getText().toString();
            String query = "";
            String operation = "";

            if (!firstname.isEmpty() && btn_update_empname.isFocused()) {
                query = "update worker set name='" + firstname + "' where idWorker='" + id + "'";
                operation = "first name";
            }
            if (!lastname.isEmpty() && btn_update_emplastname.isFocused()) {
                query = "update worker set lastname='" + lastname + "' where idWorker='" + id + "'";
                operation = "last name";
            }
            if (!username.isEmpty() && btn_update_empusername.isFocused()) {
                query = "update worker set username='" + username + "' where idWorker='" + id + "'";
                operation = "username";
            }
            if (!password.isEmpty() && btn_update_emppassword.isFocused()) {
                query = "update worker set password='" + password + "' where idWorker='" + id + "'";
                operation = "password";
            }
            if (!CIN.isEmpty() && btn_update_empCIN.isFocused()) {
                query = "update worker set cin='" + CIN + "' where idWorker='" + id + "'";
                operation = "CIN";
            }
            if (!salary.isEmpty() && btn_update_empsalary.isFocused()) {
                query = "update worker set salary='" + salary + "' where idWorker='" + id + "'";
                operation = "salary";
            }
            if (!(firstname.isEmpty() || lastname.isEmpty() || username.isEmpty() || password.isEmpty()|| CIN.isEmpty()|| salary.isEmpty()) && btn_update_all_emp.isFocused()) {
                query = "update worker set name='" + firstname + "', lastname='" + lastname + "', username='" + username + "' , password='" + password
                        + "', cin='"+CIN+"',salary='"+salary +"'" + "where idWorker='" + id + "'";
                operation = "total specifications";
            }
            if (query != "") {
                int result = connect.create(query);
                updateemp_msg.setText("Employee " + operation + " updated successfully!");
                return;
            }
            updateemp_msg.setText("Something went wrong, All targeted fields are required!");
        } catch (Exception exception) {
            updateemp_msg.setText("Something went wrong, Invalid type for the required field!");
        }


    }
    public void StockStats() throws SQLException{

            Connector connect = new Connector();
                ResultSet result = connect.read("select sum(quantity) as stock  from product");
                result.next();
                String stock = result.getString("stock");
                stock_field.setText(stock);
                stock_field1.setText(stock);
                stock_field2.setText(stock);
                result = connect.read("select sum(quantitysold) as sold from product");
                result.next();
                String sold = result.getString("sold");
                prodsold_field.setText(sold);
                prodsold_field1.setText(sold);
                prodsold_field2.setText(sold);
                result = connect.read("select sum(quantitysold*price) as income from product");
                result.next();
                float income = result.getFloat("income");
                DecimalFormat df = new DecimalFormat("###.##");
                df.format(income);
                income_field.setText(income+" DT");
                income_field1.setText(income+ " DT");
                income_field2.setText(income+" DT");

                System.out.println("Stock ="+stock+" Income = "+income+" Sold ="+sold);
            }


}