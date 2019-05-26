package controller;

import java.io.IOException;
import java.net.URI;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

public class HomeScreenController {

	@FXML
	private Text actiontarget;

	@FXML
	private Text actiontarget2;

	@FXML
	private PasswordField passwordField;
	@FXML
	private Text welcome;
	@FXML
	private Button btnHome;
	@FXML
	private Button btnLief;
	@FXML
	private Button btnBest;
	@FXML
	private Button btnPortfolio;
	@FXML
	private Button btnHilfe;
	@FXML
	private Button btnHeader;
	@FXML
	private Text userMailLogged;
	@FXML
	private Button btnLogout;
	@FXML
	private AnchorPane rootPane;
	
	//When the "Lieferant"-Button is pressed a new scene is loaded
	@FXML
	protected void handleLiefButtonAction(ActionEvent event) throws IOException {

		AnchorPane lieferantParent = FXMLLoader.load(getClass().getResource("LieferantView.fxml"));
		//Scene lieferantScene = new Scene(lieferantParent);
		rootPane.getChildren().setAll(lieferantParent);

		// get the Stage information
	//Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		//window.setScene(lieferantScene);
		//window.show();

	}
	/*public void initialize (URI location, ResourceBundle resources){
		btnLief.setOnAction(event -> {
			try {
				handleLiefButton(event);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}*/

	protected void handleBestButton(ActionEvent event) throws IOException {

		Parent bestellungParent = FXMLLoader.load(getClass().getResource("BestellungView.fxml"));
		Scene bestellungScene = new Scene(bestellungParent);

		// get the Stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(bestellungScene);
		window.show();

	}
	protected void handleProduktButton(ActionEvent event) throws IOException {

		Parent produktportfolioParent = FXMLLoader.load(getClass().getResource("ProduktportfolioView.fxml"));
		Scene produktportfolioScene = new Scene(produktportfolioParent);

		// get the Stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(produktportfolioScene);
		window.show();

	}
	protected void handleHilfeButton(ActionEvent event) throws IOException {

		Parent hilfeParent = FXMLLoader.load(getClass().getResource("HilfeView.fxml"));
		Scene hilfeScene = new Scene(hilfeParent);

		// get the Stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(hilfeScene);
		window.show();

	}
}
