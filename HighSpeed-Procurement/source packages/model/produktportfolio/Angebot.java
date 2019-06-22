package model.produktportfolio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import model.lieferant.Lieferant;
import model.produkt.Produkt;

public class Angebot {
	private int angID;
	private Lieferant lieferant;
	private Produkt produkt;
	private double einzelpreis;
	private int gultigkeitsdauer;
	private int lieferantID;
	private int produktID;
	private String produktTyp;
	private String hersteller;
	private String produktName;

	

	private static Connection connection = util.DBUtil.getConnection();

	// Innere KLasse zur Tabellendarstellung
	/*
	 * public class TableAngebot { int iD;String produktName ;String
	 * lieferantenName; double einzelpreis;int gultigkeitsdauer;
	 * 
	 * public TableAngebot(int iD,String produktName ,String lieferantenName, double
	 * einzelpreis,int gultigkeitsdauer ) { this.iD = iD; this.lieferantenName =
	 * lieferantenName; this.einzelpreis = einzelpreis; this.gultigkeitsdauer =
	 * gultigkeitsdauer;} }
	 */

	// Konstruktor 0
	public Angebot(int angID, int lieferantID, int produktID, String produktTyp,String produktName, String hersteller, double einzelpreis) {
		super();
		this.angID = angID;
		this.lieferantID = lieferantID;
		this.produktID = produktID;
		this.produktTyp = produktTyp;
		this.produktName=produktName;
		this.hersteller = hersteller;
		this.einzelpreis=einzelpreis;
	}

	// Konstruktor
	public Angebot(Lieferant lieferant, Produkt produkt, double einzelpreis, int gultigkeitsdauer) {
		super();
		this.lieferant = lieferant;
		this.produkt = produkt;
		this.einzelpreis = einzelpreis;
		this.gultigkeitsdauer = gultigkeitsdauer;
	}

	// Konstruktor 2
	public Angebot(int angID, Lieferant lieferant, Produkt produkt, double einzelpreis, int gultigkeitsdauer) {
		super();
		this.angID = angID;
		this.lieferant = lieferant;
		this.produkt = produkt;
		this.einzelpreis = einzelpreis;
		this.gultigkeitsdauer = gultigkeitsdauer;
	}

	public Angebot(int angID, Lieferant lieferant, Produkt produkt) {
		super();
		this.angID = angID;
		this.lieferant = lieferant;
		this.produkt = produkt;
	}

	// Getter + Setter
	public String getProduktName() {
		return produktName;
	}

	public void setProduktName(String produktName) {
		this.produktName = produktName;
	}
	public String getHersteller() {
		return hersteller;
	}

	public void setHersteller(String hersteller) {
		this.hersteller = hersteller;
	}

	public Lieferant getLieferant() {
		return lieferant;
	}

	public void setLieferant(Lieferant lieferant) {
		this.lieferant = lieferant;
	}

	public int getAngID() {
		return angID;
	}

	public void setAngID(int id) {
		this.angID = id;
	}

	public int getGultigkeitsdauer() {
		return gultigkeitsdauer;
	}

	public void setGultigkeitsdauer(int gultigkeitsdauer) {
		this.gultigkeitsdauer = gultigkeitsdauer;
	}

	public Produkt getProdukt() {
		return produkt;
	}

	public void setProdukt(Produkt produkt) {
		this.produkt = produkt;
	}

	public double getEinzelpreis() {
		return einzelpreis;
	}

	public void setEinzelpreis(double einzelpreis) {
		this.einzelpreis = einzelpreis;
	}

	public int getLieferantID() {
		return lieferantID;
	}

	public void setLieferantID(int lieferantID) {
		this.lieferantID = lieferantID;
	}

	public int getProduktID() {
		return produktID;
	}

	public void setProduktID(int produktID) {
		this.produktID = produktID;
	}

	public String getProduktTyp() {
		return produktTyp;
	}

	public void setProduktTyp(String produktTyp) {
		this.produktTyp = produktTyp;
	}

	
	
	public void create() {
		// Ein Angebot in der Datenbank speichern

		// �berpr�fen ob readLayer() Daten erheben konnte
		if (!(this == null)) {

			try {
				// Datenbank speichern
				Statement stmt = connection.createStatement();
				stmt.executeUpdate("INSERT INTO ANGEBOTE (LIEFERANT, PRODUKT, PREIS, GULTIGKEITSDAUER) VALUES " + "('"
						+ Integer.toString(this.getLieferant().getID()) + "','"
						+ Integer.toString(this.getProdukt().getIdent()) + "','" + Double.toString(this.getEinzelpreis())
						+ "','" + Integer.toString(this.getGultigkeitsdauer()) + "')");

			} catch (SQLException e) {
				// Meldung Lieferant speichern fehlgeschlagen
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Dialog: Angebot.create()");
				alert.setHeaderText("Folgender Fehler ist aufgetreten:");
				alert.setContentText("Speichern in der Datenbank fehlgeschlagen!");
				return;
			}
			// Meldung Lieferant erfolgreich gespeichert
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog: Angebot.create()");
			alert.setHeaderText("Folgendes Ereignis ist eingetreten:");
			alert.setContentText("Angebot erfolgreich gespeichert!");
		}
	}

	public static Angebot readLayer(TableView<Lieferant> tableLieferant, TableView<Produkt> tableProdukt,
			TextField textfeldPreis, TextField textfeldGultigkeitsdauer) {
		// Aus dem Layer ein Angebot einlesen und zur�ckgeben incl. Grammatikabfrage
		try {
			// Felder casten und Objekte bauen

			Lieferant lieferant = tableLieferant.getSelectionModel().getSelectedItem();
			Produkt produkt = tableProdukt.getSelectionModel().getSelectedItem();
			double preis = Double.parseDouble(textfeldPreis.getText());
			int gultigkeitsdauer = Integer.parseInt(textfeldGultigkeitsdauer.getText());

			Angebot angebot = new Angebot(lieferant, produkt, preis, gultigkeitsdauer);
			return angebot;
		} catch (Exception e) {
			// Generelle Fehlermeldung "Falscher Datentyp!" in einem Dialog auf FX
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog: Angebot.readLayer()");
			alert.setHeaderText("Folgender Fehler ist aufgetreten:");
			alert.setContentText("Falscher Datentyp! Bitte �berpr�fen sie ihre Eingaben!");

		}
		return null;

	}

	public void decreaseLaufzeitAll() {
		// Die Laufzeitvariable aller Angebote um 1 verringern

		try {
			// Datenbank speichern
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT (ID, GULTIGKEITSDAUER) FROM ANGEBOTE");
			while (rs.next()) {
				Statement stmt2 = connection.createStatement();
				stmt2.executeUpdate("Update ANGEBOTE Set GULTIGKEITSDAUER ='"
						+ Integer.toString((Integer.parseInt(rs.getString("GULTIGKEITSDAUER")) - 1)) + "' WHERE ID='"
						+ rs.getString("ID") + "'");
			}

		} catch (SQLException e) {
			// Meldung Lieferant speichern fehlgeschlagen
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog: Angebot.decreaseLaufzeitAll()");
			alert.setHeaderText("Folgender Fehler ist aufgetreten:");
			alert.setContentText("Speichern in der Datenbank fehlgeschlagen!");
			return;
		}
		// Meldung Lieferant erfolgreich gespeichert
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog: Angebot.decreaseLaufzeitAll()");
		alert.setHeaderText("Folgendes Ereignis ist eingetreten:");
		alert.setContentText("Gultigkeitsdauer erfolgreich vermindert!");

	}

	

}
