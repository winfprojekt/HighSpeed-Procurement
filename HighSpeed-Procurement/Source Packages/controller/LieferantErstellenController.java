package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import main.Main;
import model.Lieferant.Lieferant;
import util.DBUtil;

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
	private ChoiceBox<Lieferant> choiceboxLand;
	@FXML
	private ComboBox<Lieferant> comboboxDienstl;
	@FXML
	private ChoiceBox<Lieferant> choiceboxLTyp;
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
	private TextField textfieldLand;
	@FXML
	private TextField textfieldTyp;
	@FXML
	private Button btnSpeichern;
	@FXML
	private Button btnAbbrechen;

	private Connection connection = util.DBUtil.getConnection();
	private Statement stmt;
	private ResultSet rs = null;
	private DBUtil dbu;

	@FXML
	private void handleSpeichernAction(ActionEvent e) {

		try {
			stmt = connection.createStatement();
			// int update =stmt.executeUpdate("INSERT INTO Lieferant ID, Name, "
			// + "Adresse, PLZ, Land, Typ, E-Mail, Telefonnummer, Bank, IBAN, SWIFT,
			// Steuernummer, Timestamp "
			// + "VALUES "+"('"+30+"', '"+textfieldName.getText()+"',
			// '"+textfieldAddr.getText()+"', '"+textFieldPLZ.getText()+"',
			// '"+textfieldLand.getText()+"', '"+textfieldTyp.getText()+"',
			// '"+textfieldMail.getText()+"', '"+textfieldTelnum.getText()+"',
			// '"+textfieldBank.getText()+"', '"+textfieldIBAN.getText()+"',
			// '"+textfieldSWIFT.getText()+"', '"+textfieldSteuer.getText()+"') ");
			int update = stmt.executeUpdate(
					"INSERT INTO Lieferant (Name, Adresse, Stadt, PLZ, Land, Typ, Mail, Telefonnummer, Bank, IBAN, SWIFT, Steuernummer) VALUES "
							+ "('" + textfieldName.getText() + "', '" + textfieldAddr.getText() + "', '"
							+ textfieldStadt.getText() + "', '" + textFieldPLZ.getText() + "', '"
							+ textfieldLand.getText() + "', '" + textfieldTyp.getText() + "', '"
							+ textfieldMail.getText() + "', '" + textfieldTelnum.getText() + "', '"
							+ textfieldBank.getText() + "', '" + textfieldIBAN.getText() + "', '"
							+ textfieldSWIFT.getText() + "', '" + textfieldSteuer.getText() + "'  )");

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

		TextField[] Textfelder = { textfieldName, textfieldAddr, textfieldStadt, textFieldPLZ, textfieldMail,
				textfieldTelnum, textfieldBank, textfieldIBAN, textfieldSWIFT, textfieldSteuer, textfieldLand,
				textfieldTyp };
		Lieferant.readLayer(Textfelder);
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Neuanlage Lieferant");
		alert.setHeaderText("Der Lieferant wurde erfolgreich angelegt!");
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
			alert.close();
			Main.set_pane(2);
			textfieldName.clear();
			textfieldAddr.clear();
			textfieldStadt.clear();
			textFieldPLZ.clear();
			textFieldPLZ.clear();
			textfieldMail.clear();
			textfieldTelnum.clear();
			textfieldBank.clear();
			textfieldIBAN.clear();
			textfieldSWIFT.clear();
			textfieldSteuer.clear();
			textfieldLand.clear();
			textfieldTyp.clear();
		}
		
		
	}

	@FXML
	private void handleAbbrechenAction(ActionEvent e) {
		// When "Abbrechen"-Button is
		// pressed the application routes the user back to the main supplier screen
		// (pane with idx=2)
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Neuanlage abbrechen");
		alert.setHeaderText("Der Prozess wird abgebrochen.");
		alert.setContentText("Wollen Sie wirklich den Prozess abbrechen?");
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
			alert.close();
			Main.set_pane(2);
			textfieldName.clear();
			textfieldAddr.clear();
			textfieldStadt.clear();
			textFieldPLZ.clear();
			textFieldPLZ.clear();
			textfieldMail.clear();
			textfieldTelnum.clear();
			textfieldBank.clear();
			textfieldIBAN.clear();
			textfieldSWIFT.clear();
			textfieldSteuer.clear();
			textfieldLand.clear();
			textfieldTyp.clear();
		}
		else {
			alert.close();
		}

	}

	public String getTextfieldName() {
		return textfieldName.getText();
	}

	public String getTextfieldAddr() {
		return textfieldAddr.getText();
	}

	public String getTextfieldStadt() {
		return textfieldStadt.getText();
	}

	public int getTextFieldPLZ() {
		return Integer.valueOf(textFieldPLZ.getText());
	}

	public ChoiceBox<?> getChoiceboxLand() {
		return choiceboxLand;
	}

	public ComboBox<?> getComboboxDienstl() {
		return comboboxDienstl;
	}

	public ChoiceBox<?> getChoiceboxLTyp() {
		return choiceboxLTyp;
	}

	public String getTextfieldMail() {
		return textfieldMail.getText();
	}

	public Integer getTextfieldTelnum() {
		return Integer.valueOf(textfieldTelnum.getText());
	}

	public String getTextfieldBank() {
		return textfieldBank.getText();
	}

	public Integer getTextfieldIBAN() {
		return Integer.valueOf(textfieldIBAN.getText());
	}

	public String getTextfieldSWIFT() {
		return textfieldSWIFT.getText();
	}

	public String getTextfieldSteuer() {
		return textfieldSteuer.getText();
	}

	public String getTextfieldLand() {
		return textfieldLand.getText();
	}

	public String getTextfieldTyp() {
		return textfieldTyp.getText();
	}

}
