package application;

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
    	loader.setLocation(getClass().getResource("LoginView.fxml"));
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
        launch(args);
    }
}