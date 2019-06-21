package controller;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import main.Main;
import model.Bestellung.Teilbestellung;
import model.Lieferant.Kontaktdaten;
import model.Lieferant.Lieferant;
import controller.RegBestellungErstellenController;

public class MailSendenController implements Initializable {
	@FXML
	private Label empfaengerMailLabel;
	@FXML
	private TextArea bstlTextfield;
	@FXML
	private TextArea zstzTextfield;
	@FXML
	private Button btnAbbrechen;
	@FXML
	private Button btnSenden;
	@FXML
	private Label counterLabel;
	@FXML
	private Label lblHeader;
	@FXML
	private Label lblEmpfaenger;
	@FXML
	private Label lblBesText;
	@FXML
	private Label lblZusatz;
	@FXML
	private Label lblSender;
	@FXML
	private TextField empfField;

	private String mailString = "";

	private String saveString;
	RegBestellungErstellenController rbc = new RegBestellungErstellenController();

	ArrayList<Teilbestellung> db = new ArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		/*
		 * Angebot an = new Angebot("h&k@web.de", "Intel Core I7", 350.18); Position pos
		 * = new Position (an, 5); ArrayList <Position> posList = new ArrayList();
		 * posList.add(pos); posList.add(pos);
		 * 
		 * Teilbestellung t0 = new Teilbestellung("barbe@web.de", an.getLiefString(),
		 * posList);
		 */

	}

	public void display(String t1, ArrayList<Teilbestellung> db) {

		bstlTextfield.setText("Sehr geehrte Damen und Herren, \n" + "Wir hätten die folgende Bestllung für Sie.\n\n"
				+ t1 + " EUR " + "\n\n" + "Mit feundlichen Grüßen \n\nHighSpeed-Procurement GmbH" + "\n"
				+ zstzTextfield.getText());

		mailString = "Sehr geehrte Damen und Herren, \n" + "Wir hätten die folgende Bestllung für Sie.\n\n" + t1
				+ " EUR " + "\n\n" + "Mit feundlichen Grüßen \n\nHighSpeed-Procurement GmbH";

		saveString = "Sehr geehrte Damen und Herren, \n" + "Wir hätten die folgende Bestllung für Sie.\n\n" + t1
				+ " EUR " + "\n\n" + "Mit feundlichen Grüßen \n\nHighSpeed-Procurement GmbH";

		System.out.println("dsplay");

		/*
		 * MailService ms = new MailService(mailString, 1, "winfprojekt@yahoo.com");
		 * ms.send();
		 */

	}

	public void writeStringToFile(String filepath, String stringInput) {
		try {
			String stringOutput = "";
			OutputStream output = new FileOutputStream(filepath);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] b = stringInput.getBytes("ISO-8859-1");
			baos.write(b);
			stringOutput = baos.toString("UTF-8");
			baos.writeTo(output);
			output.close();
			System.out.println("Erfolgreich gespeichert!");

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void abbrechen() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Prozess abbrechen");
		alert.setHeaderText("Der Prozess wird abgebrochen.");
		alert.setContentText("Wollen Sie wirklich den Prozess abbrechen?");
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			Stage stage = (Stage) btnAbbrechen.getScene().getWindow();
			stage.close();
		} else {
			alert.close();
		}

	}

	public void senden() {
		writeStringToFile("C:\\Users\\Denislav\\Desktop\\output.txt", saveString);
		Stage stage = (Stage) btnSenden.getScene().getWindow();
		stage.close();

	}

}
