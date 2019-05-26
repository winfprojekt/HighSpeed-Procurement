package controller;

import java.io.IOException;

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
	@FXML
	private Button btnSubmit;
	@FXML
	private AnchorPane loginPane;

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

			AnchorPane homePane = FXMLLoader.load(getClass().getResource("HomeScreenView.fxml"));

			loginPane.getChildren().setAll(homePane);

		}
	}

	@FXML
	protected void resetSubmitButtonAction(MouseEvent event) {
		actiontarget.setText(" ");
		actiontarget2.setText(" ");

	}
}
