package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.fxml.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
	protected void handleSubmitButtonAction(ActionEvent event) throws IOException {

		Parent homeScreenParent = FXMLLoader.load(getClass().getResource("Login.fxml"));
		Scene homeScreenScene = new Scene(homeScreenParent);

		// get the Stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(homeScreenScene);
		window.show();

	}

	@FXML
	protected void resetSubmitButtonAction(MouseEvent event) {
		actiontarget.setText(" ");
		actiontarget2.setText(" ");
		/*
		 * }
		 * 
		 * @FXML protected void setLoggedUser(ActionEvent event) {
		 * userMailLogged.setText(LoginController.usernameTextbox.getText()); }
		 */
	}
}
