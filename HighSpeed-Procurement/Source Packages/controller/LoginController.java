package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import main.Main;

public class LoginController{
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
	@FXML
	private Label lblUsername;
	@FXML
	private Label lblPwd;
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
	private void handleSubmitButtonAction(ActionEvent event) throws IOException {

		if (!passwordField.getText().equals("admin") || !usernameTextbox.getText().equals("admin") || isInputValid()==false) {
			actiontarget.setText("Wrong username and/or password!!");
		} else {
			actiontarget2.setText("Success!");
			try {
				//AnchorPane homePane = FXMLLoader.load(getClass().getResource("HomeScreenView.fxml"));
				//loginPane.getChildren().setAll(homePane);
				Main.set_pane(1);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	@FXML
	private void resetSubmitButtonAction(MouseEvent event) {
		actiontarget.setText(" ");
		actiontarget2.setText(" ");

	}
	//Validation method
	private boolean isInputValid() {
		Boolean valid = false;
		if(!(usernameTextbox.getText()==null||usernameTextbox.getText().length()==0||passwordField.getText()==null||passwordField.getText().length()==0)) {
			try {
				valid=true;
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		return valid;
	}

}
