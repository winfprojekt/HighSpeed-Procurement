package controller;

import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import main.Main;
import model.Security.PW_Encryption;
import util.DBUtil;

public class LoginController implements Initializable {
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

	private Connection connection = util.DBUtil.getConnection();
	private PreparedStatement stmt;
	private ResultSet rs = null;
	private DBUtil dbu;
	private String nameRs;
	private String check;
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
	private void handleSubmitButtonAction(ActionEvent event) throws IOException, NoSuchAlgorithmException {

		PW_Encryption pw = new PW_Encryption(passwordField.getText());

		String query = "SELECT password FROM USER_INFO WHERE name = '" + usernameTextbox.getText() + "' ";
		// String query = "SELECT * FROM USER_INFO";

		try {
			stmt = connection.prepareStatement(query);
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				check = rs.getString("password");
				System.out.println("Database " + check);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PW_Encryption PW_gen = new PW_Encryption(passwordField.getText());
		System.out.println("Eingabe " + PW_gen.getData());

		if (check.equalsIgnoreCase(PW_gen.getData())) {
			actiontarget2.setText("Success!");
			try {
				// AnchorPane homePane =
				// FXMLLoader.load(getClass().getResource("HomeScreenView.fxml"));
				// loginPane.getChildren().setAll(homePane);
				Main.set_pane(1);
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		} else {
			actiontarget.setText("Wrong username and/or password!!");
		}
	}

	@FXML
	private void resetSubmitButtonAction(MouseEvent event) {
		actiontarget.setText(" ");
		actiontarget2.setText(" ");

	}

	// Validation method
	private boolean isInputValid() {
		Boolean valid = false;
		if (!(usernameTextbox.getText() == null || usernameTextbox.getText().length() == 0
				|| passwordField.getText() == null || passwordField.getText().length() == 0)) {
			try {
				valid = true;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return valid;
	}

	public void loadDatabaseData() {
		String query = "SELECT * FROM USER_INFO";

		try {
			stmt = connection.prepareStatement(query);
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				nameRs = rs.getString("name");
				String emailRs = rs.getString("email");
			}

			System.out.println(nameRs);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		dbu = new DBUtil();
		loadDatabaseData();

	}

}
