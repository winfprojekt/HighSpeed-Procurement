package controller;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.text.Text;
import main.Main;
import javafx.scene.control.TextField;

import java.io.IOException;

import javafx.event.ActionEvent;

import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class BestellungController {
	@FXML
	private Button btnHeader;
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
	private Button btnRegBest;
	@FXML
	private Button btnEilBest;
	@FXML
	private TableView<?> tableBestBearb;
	@FXML
	private TableColumn<?, ?> colBestName;
	@FXML
	private TableColumn<?, ?> colBestID;
	@FXML
	private TableColumn<?, ?> colLiefID;
	@FXML
	private TableColumn<?, ?> colProdTyp;
	@FXML
	private TableColumn<?, ?> colProdHerst;
	@FXML
	private TableColumn<?, ?> colMenge;
	@FXML
	private TableColumn<?, ?> colBestTyp;
	@FXML
	private TableColumn<?, ?> colStatus;
	@FXML
	private TableColumn<?, ?> colDate;
	@FXML
	private TextField textfieldStorno;
	@FXML
	private Button btnStorno;
	@FXML
	private Text userMailLogged;

	@FXML
	public void handleHomeButton(ActionEvent event) throws IOException {
		Main.set_pane(1);
	}

	@FXML
	private void handleLiefButtonAction(ActionEvent event) {
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
	@FXML
	public void createRegBestellung(ActionEvent event) throws IOException{
		Main.set_pane(8);
	}
}
