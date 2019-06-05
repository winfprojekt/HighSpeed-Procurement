package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import main.Main;
import javafx.scene.control.Label;

import javafx.scene.control.ComboBox;

import javafx.scene.control.ChoiceBox;

public class LieferantErstellenController {
	@FXML
	private Label lblHeader;
	@FXML
	private Label lblName;
	@FXML
	private Label lblAddr;
	@FXML
	private Label lblStadt;
	@FXML
	private Label lblPLZ;
	@FXML
	private Label lblLand;
	@FXML
	private Label lblDienstleist;
	@FXML
	private Label lblTyp;
	@FXML
	private TextField textfieldName;
	@FXML
	private TextField textfieldAddr;
	@FXML
	private TextField textfieldStadt;
	@FXML
	private TextField textFieldPLZ;
	@FXML
	private ChoiceBox <?> choiceboxLand;
	@FXML
	private ComboBox <?> comboboxDienstl;
	@FXML
	private ChoiceBox <?> choiceboxLTyp;
	@FXML
	private Label lblMail;
	@FXML
	private Label lblTelefon;
	@FXML
	private Label lblBank;
	@FXML
	private Label lblIBAN;
	@FXML
	private Label lblSWIFT;
	@FXML
	private Label lblSteuer;
	@FXML
	private TextField textfieldMail;
	@FXML
	private TextField textfieldTelnum;
	@FXML
	private TextField textfieldBank;
	@FXML
	private TextField textfieldIBAN;
	@FXML
	private TextField textfieldSWIFT;
	@FXML
	private TextField textfieldSteuer;
	@FXML
	private Button btnSpeichern;
	@FXML
	private Button btnAbbrechen;
	
	@FXML
	private void handleSpeichernAction (ActionEvent e) {
		
		
	}
	@FXML
	private void handleAbbrechenAction (ActionEvent e) {
		//When "Abbrechen"-Button is 
		//pressed the application routes the user back to the home screen (pane with idx=1)
		Main.set_pane(1);
	}

}
