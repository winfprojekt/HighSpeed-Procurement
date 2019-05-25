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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
	@FXML
	private Text actiontarget;

	@FXML
	private Text actiontarget2;

	@FXML
	private PasswordField passwordField;
	@FXML
	private TextField usernameTextbox;
	@FXML
	private Text welcome;

	/*
	 * @FXML protected void handleSubmitButtonAction(ActionEvent event) {
	 * 
	 * 
	 * if (!passwordField.getText().equals("admin") ||
	 * !usernameTextbox.getText().equals("admin")) {
	 * actiontarget.setText("Failed to Authenticate"); } else
	 * actiontarget2.setText("Success!");
	 * 
	 * 
	 * }
	 */

	@FXML
	protected void handleSubmitButtonAction(ActionEvent event) throws IOException {

		if (!passwordField.getText().equals("admin") || !usernameTextbox.getText().equals("admin")) {
			actiontarget.setText("Wrong username and/or password!!");
		} else {
			actiontarget2.setText("Success!");
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("HomeScreenView.fxml"));
			Parent homeScreenParent = loader.load();
			Scene homeScreenScene = new Scene(homeScreenParent, 1100, 650);

			// get the Stage information
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(homeScreenScene);
			window.show();
		}
	}

	@FXML
	protected void resetSubmitButtonAction(MouseEvent event) {
		actiontarget.setText(" ");
		actiontarget2.setText(" ");

	}
}
