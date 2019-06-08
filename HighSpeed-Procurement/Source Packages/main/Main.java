package main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
	static AnchorPane root;
	static List<AnchorPane> anchor = new ArrayList<AnchorPane>();
	private static int idx_crsr = 0;
	private static Stage rootStage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			root = (AnchorPane) FXMLLoader.load(getClass().getResource("/controller/rootView.fxml"));
			//idx=0
			anchor.add((AnchorPane) FXMLLoader.load(getClass().getResource("/controller/LoginView.fxml")));
			//idx=1
			anchor.add((AnchorPane) FXMLLoader.load(getClass().getResource("/controller/HomeScreenView.fxml")));
			//idx=2
			anchor.add((AnchorPane) FXMLLoader.load(getClass().getResource("/controller/LieferantView.fxml")));
			//idx=3
			anchor.add((AnchorPane) FXMLLoader.load(getClass().getResource("/controller/LieferantErstellenView.fxml")));
			//idx=4
			anchor.add((AnchorPane) FXMLLoader.load(getClass().getResource("/controller/BestellungView.fxml")));
			//idx=5
			anchor.add((AnchorPane) FXMLLoader.load(getClass().getResource("/controller/ProduktportfolioView.fxml")));
			//idx=6
			anchor.add((AnchorPane) FXMLLoader.load(getClass().getResource("/controller/HilfeView.fxml")));
			root.getChildren().add(anchor.get(0));
			Scene scene = new Scene(root, 400, 330);
			scene.getStylesheets().add(getClass().getResource("/resources/Login.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("HighSpeed-Procurement");
			primaryStage.show();
			rootStage = primaryStage;

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void init_app() {
		for (int i = 0; i < anchor.size(); i++) {

		}

	}

	public static AnchorPane get_pane(int idx) {

		return anchor.get(idx);

	}

	public static void set_pane(int idx) {
		root.getChildren().remove(anchor.get(idx_crsr));
		root.getChildren().add(anchor.get(idx));
		rootStage.setMaximized(true);

		idx_crsr = idx;
	}
	public static void close() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Abmeldung");
		alert.setHeaderText("Sie werden von der Applikation abgemeldet.");
		alert.setContentText("Wollen Sie sich wirklich abmelden?");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
			Platform.exit();
		} else {
		    alert.close();
		}
		
	}

	public static void main(String[] args) {
		// create an Object from DBUtil-class
		util.DBUtil db = new util.DBUtil();
		// connect to the database "aj9s-einkauf"
		try {
			db.connectToMysql("193.196.143.168", "aj9s-einkauf", "aj9s-einkauf", "DYUcen7KXKo3dPzt", "UTC");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		launch(args);
	}


}