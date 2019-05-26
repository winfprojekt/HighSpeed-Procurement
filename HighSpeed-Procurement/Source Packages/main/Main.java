package main;

import java.sql.SQLException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
    	try {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/controller/LoginView.fxml"));
    	Parent content = loader.load(); 
        primaryStage.setTitle("HighSpeed-Procurement");
        primaryStage.setScene(new Scene(content, 400, 300));
        primaryStage.show();
    }
    catch (Exception e) {
    	e.printStackTrace();
    }
   }

    public static void main(String[] args) {
    	//create an Object from DBUtil-class
    	util.DBUtil db = new util.DBUtil();
    	//connect to the database "aj9s-einkauf"
        try {
			db.connectToMysql("193.196.143.168", "aj9s-einkauf", "aj9s-einkauf", "DYUcen7KXKo3dPzt", "UTC");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
        launch(args);
        
    }
}