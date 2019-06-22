package controller;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.text.Text;
import main.Main;

import java.io.IOException;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class HilfeController {
	@FXML
	private Button btnHeader;
	@FXML
	private Text userMailLogged;
	@FXML
	private Button btnBest;
	@FXML
	private Button btnPortfolio;
	@FXML
	private Button btnHilfe;
	@FXML
	private Button btnHome;
	@FXML
	private Button btnLogout;
	@FXML
	private Button btnLief;
	@FXML
	private Label lblHeaderHilfe;
	@FXML
	private Label lblKontakt;
	@FXML
	private Label lblMail;
	@FXML
	private Label lblTelefon;
	
	@FXML
	public void handleHomeButton(ActionEvent event) throws IOException {
		Main.set_pane(1);
	}
	
	@FXML
	private void handleLiefButtonAction(ActionEvent event) throws IOException{
		Main.set_pane(2);

	}

	@FXML
	public void handleBestButton(ActionEvent event) throws IOException {

		Main.set_pane(5);

	}

	@FXML
	public void handleProduktButton(ActionEvent event) throws IOException {

		Main.set_pane(6);

	}

	@FXML
	public void handleHilfeButton(ActionEvent event) throws IOException {

		Main.set_pane(7);

	}

	@FXML
	public void handleAbmeldenButton(ActionEvent event) throws IOException {
		Main.close();

	}

}
