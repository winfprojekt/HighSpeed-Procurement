package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LieferantController {
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
	
	//When the "Home"-Icon is pressed a new scene is loaded
	@FXML
	protected void handleHomeButton(ActionEvent event) throws IOException {

		AnchorPane homeParent = FXMLLoader.load(getClass().getResource("HomeScreenView.fxml"));
		//Scene lieferantScene = new Scene(lieferantParent);
		rootPane.getChildren().setAll(homeParent);

		// get the Stage information
/*		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(lieferantScene);
		window.show();
*/
	}

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

