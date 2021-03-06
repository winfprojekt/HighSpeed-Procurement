package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
			root = (AnchorPane) FXMLLoader.load(getClass().getResource("/controller/RootView.fxml"));
			// idx=0
			anchor.add((AnchorPane) FXMLLoader.load(getClass().getResource("/controller/LoginView.fxml")));
			// idx=1
			anchor.add((AnchorPane) FXMLLoader.load(getClass().getResource("/controller/HomeScreenView.fxml")));
			// idx=2
			anchor.add((AnchorPane) FXMLLoader.load(getClass().getResource("/controller/LieferantView.fxml")));
			// idx=3
			anchor.add((AnchorPane) FXMLLoader.load(getClass().getResource("/controller/LieferantErstellenView.fxml")));
			// idx=4
			anchor.add((AnchorPane) FXMLLoader.load(getClass().getResource("/controller/LieferantBearbeitenView.fxml")));
			// idx=5
			anchor.add((AnchorPane) FXMLLoader.load(getClass().getResource("/controller/BestellungView.fxml")));
			// idx=6
			anchor.add((AnchorPane) FXMLLoader.load(getClass().getResource("/controller/ProduktportfolioView.fxml")));
			// idx=7
			anchor.add((AnchorPane) FXMLLoader.load(getClass().getResource("/controller/HilfeView.fxml")));
			// idx=8
			anchor.add((AnchorPane) FXMLLoader.load(getClass().getResource("/controller/RegBestellungErstellenView.fxml")));
			// idx=9
			anchor.add((AnchorPane) FXMLLoader.load(getClass().getResource("/controller/MailSendenView.fxml")));
			// idx=10
			anchor.add((AnchorPane) FXMLLoader.load(getClass().getResource("/controller/EilBestellungErstellenView.fxml")));

			root.getChildren().add(anchor.get(0));
			Scene scene = new Scene(root, 430, 330);
			scene.getStylesheets().add(getClass().getResource("/resources/Login.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("HighSpeed-Procurement");
			primaryStage.show();
			rootStage = primaryStage;

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}


	public static String generateUUID() {
		UUID uuid = UUID.randomUUID();
		String randomUUIDString = uuid.toString();
		return randomUUIDString;
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
	public static void resetPane() {
		Platform.exit();
	}
	public static void close() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Abmeldung");
		alert.setHeaderText("Sie werden von der Applikation abgemeldet.");
		alert.setContentText("Wollen Sie sich wirklich abmelden?");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			Platform.exit();
		} else {
			alert.close();
		}

	}

	public static void main(String[] args) {

		launch(args);
	}

}