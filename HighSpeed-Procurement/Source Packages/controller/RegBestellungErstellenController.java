package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.control.ToggleGroup;
import main.Main;
import model.Produktportfolio.Angebot;
import javafx.scene.control.Label;

import javafx.scene.control.RadioButton;

import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class RegBestellungErstellenController {
	@FXML
	private Label lblHeader;
	@FXML
	private TextField txtfieldBestName;
	@FXML
	private Label lblAngebote;
	@FXML
	private TableView<Angebot> tableAngOverview;
	@FXML
	private TableColumn<Angebot, Integer> colAngID;
	@FXML
	private TableColumn<Angebot, Integer> colAngLiefID;
	@FXML
	private TableColumn<Angebot, Integer> colAngProdID;
	@FXML
	private TableColumn<Angebot, String> colAngProdTyp;
	@FXML
	private TableColumn<Angebot, String> colAngProdName;
	@FXML
	private TableColumn<Angebot, String> colAngHersteller;
	@FXML
	private Label lblTeilbestellungen;
	@FXML
	private Label lblAngebotID;
	@FXML
	private TextField textfieldAngID;
	@FXML
	private Label lblMenge;
	@FXML
	private TextField textfieldMenge;
	@FXML
	private TableView<?> tableTeilbestellungen;
	@FXML
	private TableColumn<?, ?> colTeilbestID;
	@FXML
	private TableColumn<?, ?> colTeilAngID;
	@FXML
	private TableColumn<?, ?> colTeilProdID;
	@FXML
	private TableColumn<?, ?> colTeilProdTyp;
	@FXML
	private TableColumn<?, ?> colTeilProdName;
	@FXML
	private TableColumn<?, ?> colTeilHerst;
	@FXML
	private TableColumn<?, ?> colTeilMenge;
	@FXML
	private Button btnHinzu;
	@FXML
	private Button btnBestErstellen;
	@FXML
	private Button btnAbbrechen;
	@FXML
	private RadioButton radioBS;
	@FXML
	private ToggleGroup produkt;
	@FXML
	private RadioButton radioGrafik;
	@FXML
	private RadioButton radioHaupt;
	@FXML
	private RadioButton radioFestplatte;
	@FXML
	private RadioButton radioProzessor;
	
	@FXML
	private void handleAbbrechenAction (ActionEvent e) {
		//When "Abbrechen"-Button is 
		//pressed the application routes the user back to the home screen (pane with idx=1)
		Main.set_pane(5);
	}

}
