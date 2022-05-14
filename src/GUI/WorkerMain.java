package GUI;

import com.google.common.io.Resources;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class WorkerMain extends Application {
    private double x, y;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent adminroot = FXMLLoader.load(getClass().getResource("WorkerUI.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("AdminUI.fxml"));
        primaryStage.setScene(new Scene(root));
        Stage admin = new Stage();
        admin.setScene(new Scene(adminroot));
        AnchorPane rootPane;
        AdminController controller = new AdminController();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("products.fxml"));
        fxmlLoader.setController(controller);



        //Set stage borderless :
        primaryStage.initStyle(StageStyle.UNDECORATED);
        admin.initStyle(StageStyle.UNDECORATED);


        root.setOnMousePressed(event ->{
            x= event.getSceneX();
            y=event.getSceneY();
        } );
        root.setOnMouseDragged(event -> {
         primaryStage.setX(event.getScreenX()- x);
         primaryStage.setY(event.getSceneY()- y);
        });
        adminroot.setOnMousePressed(event ->{
            x= event.getSceneX();
            y=event.getSceneY();
        } );
        adminroot.setOnMouseDragged(event -> {
            admin.setX(event.getScreenX()- x);
            admin.setY(event.getSceneY()- y);
        });

        primaryStage.show();
        admin.show();
    }



    public static void main(String[] args) {
        launch(args);


    }
}
