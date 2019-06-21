package model.Bestellung;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.User;
import model.Lieferant.Lieferant;
import model.Mail.MailService;

public class Teilbestellung implements Serializable {

	private String bestUUID;
	private User user;
	private Lieferant lieferant;
	private ArrayList<Position> positionen;
	private int angID;
	private int prodID;
	private Integer liefID;
	private String prodTyp;
	private String prodName;
	private String hersteller;
	private int menge;
	private String name;
	private double gesamtpreis;
	private String bestellungsTyp;
	private String status;
	private Timestamp erstelltAm;
	private final StringProperty statusNew = new SimpleStringProperty();
	public Teilbestellung(String bestUUID, String name, int angID, int liefID, int prodID, String prodTyp,
			String prodName, String hersteller, int menge, double gesamtpreis) {
		this.bestUUID = bestUUID;
		this.angID = angID;
		this.liefID = liefID;
		this.prodID = prodID;
		this.prodTyp = prodTyp;
		this.prodName = prodName;
		this.hersteller = hersteller;
		this.menge = menge;
		this.name = name;
		this.gesamtpreis = gesamtpreis;
	}

	public Teilbestellung(String bestUUID, String name, int liefID, String prodTyp, String prodName, String hersteller,
			int menge, String bestellungsTyp, String status, double gesamtpreis, Timestamp erstelltAm) {
		this.bestUUID = bestUUID;
		this.liefID = liefID;
		this.prodTyp = prodTyp;
		this.prodName = prodName;
		this.hersteller = hersteller;
		this.menge = menge;
		this.name = name;
		this.gesamtpreis = gesamtpreis;
		this.bestellungsTyp = bestellungsTyp;
		setStatusNew(status);
		this.erstelltAm = erstelltAm;
	}

	public Teilbestellung(String bestUUID, String name, int liefID, String prodTyp, String prodName, String hersteller,
			int menge, String bestellungsTyp, String status, double gesamtpreis) {
		this.bestUUID = bestUUID;
		this.liefID = liefID;
		this.prodTyp = prodTyp;
		this.prodName = prodName;
		this.hersteller = hersteller;
		this.menge = menge;
		this.name = name;
		this.gesamtpreis = gesamtpreis;
		this.bestellungsTyp = bestellungsTyp;
		setStatusNew(status);
	}

	public final StringProperty statusNewProperty() {
		return this.statusNew;
	}

	public final String getStatusNew() {
		return this.statusNewProperty().get();
	}

	public final void setStatusNew(final String statusNew) {
		this.statusNewProperty().set(statusNew);
	}

	public String getBestellungsTyp() {
		return bestellungsTyp;
	}

	public void setBestellungsTyp(String bestellungsTyp) {
		this.bestellungsTyp = bestellungsTyp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getErstelltAm() {
		return erstelltAm;
	}

	public void setErstelltAm(Timestamp erstelltAm) {
		this.erstelltAm = erstelltAm;
	}

	public void setBestUUID(String bestUUID) {
		this.bestUUID = bestUUID;
	}

	public Integer getLiefID() {
		return liefID;
	}

	public void setLiefID(Integer liefID) {
		this.liefID = liefID;
	}

	public double getGesamtpreis() {
		return gesamtpreis;
	}

	public void setGesamtpreis(double gesamtpreis) {
		this.gesamtpreis = gesamtpreis;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAngID() {
		return angID;
	}

	public void setAngID(int angID) {
		this.angID = angID;
	}

	public int getProdID() {
		return prodID;
	}

	public void setProdID(int prodID) {
		this.prodID = prodID;
	}

	public String getProdTyp() {
		return prodTyp;
	}

	public void setProdTyp(String prodTyp) {
		this.prodTyp = prodTyp;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getHersteller() {
		return hersteller;
	}

	public void setHersteller(String hersteller) {
		this.hersteller = hersteller;
	}

	public int getMenge() {
		return menge;
	}

	public void setMenge(int menge) {
		this.menge = menge;
	}

	// Konstruktor
	public Teilbestellung(int userID, Lieferant lieferant, ArrayList<Position> positionen) {
		super();
		this.user = user;
		this.lieferant = lieferant;
		this.positionen = positionen;
	}

	// Getter + Setter
	public String getBestUUID() {
		return bestUUID;
	}

	public void setBestID(String bestUUID) {
		this.bestUUID = bestUUID;
	}

	public User getUser() {
		return user;
	}

	public void setUser(int userID) {
		this.user = user;
	}

	public Lieferant getLieferant() {
		return lieferant;
	}

	public void setLieferant(Lieferant lieferant) {
		this.lieferant = lieferant;
	}

	public ArrayList<Position> getPositionen() {
		return positionen;
	}

	public void setPositionen(ArrayList<Position> positionen) {
		this.positionen = positionen;
	}

	// zus�tzliche Logik
	public ArrayList<Teilbestellung> readAll() {
		return null;
		// Alle Teilbestellungen aus der Datenbank einlesen und zur�ckgeben
	}

	public void writeAll(ArrayList<Teilbestellung> teilbestellungen) {
		// Auf der Tabelle auf dem Layer alle Teilbestellungen darstellen
	}

	public void create() {
		// Eine Teilbestellung in der Datenbank speichern
	}

	public String objectToString() {
		return null;
		// Aus den Angebot.iDs und Mengen einen String bauen der zum Speichern in der
		// Datenbank notwendig ist
	}

	public Teilbestellung stringToObject(String string) {
		return null;
		// Aus dem String ein Produktportfolio bef�llen (Gegenteil zu objectToString)
	}

	// Änderungen von Boris ab hier:

public String toText() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("Sehr geehrte Damen und Herren,\n");
		sb.append("Wir haben eine neue Bestellung für Sie erstellt.\n");
		sb.append("Bestellungsnummer: ");
		sb.append(this.bestUUID);
		sb.append("\n");
		for(int i = 0; i<this.positionen.size(); i++) {
			sb.append("Einzelteil: ");
			sb.append(this.positionen.get(i).getAngebot().getProdukt().getName());
			sb.append("\n");
			sb.append("Teilennummer: ");
			sb.append(this.positionen.get(i).getAngebot().getProdukt().getIdent());
			sb.append("\n");
			sb.append("Menge: ");
			sb.append(this.positionen.get(i).getMenge());
			sb.append("\n");
		}
		sb.append("Mit freundlichen Grüßen");
		sb.append(this.user.getUser());
		sb.append("\n");
		sb.append("HighSpeedProcurement");
		String toBeMailed = sb.toString();
		return toBeMailed;
	}
	
	public MailService objectToMail() {
		
		String TextBody = this.toText();
		
		MailService newMail = new MailService(TextBody, this.bestUUID, this.lieferant.getKontaktdaten().getEmail());
	
	return newMail;
	}
	@Override
	public String toString() {
		return "Teilbestellung [lieferant=" + lieferant + ", liefID=" + liefID + "]";
	}
	public String getTeilStrin() {
		String total = "Produkt: "+hersteller +" "+ prodName +" "+ "Menge: "+menge + " "+"Gesamtpreis: "+ menge*gesamtpreis;
		return total;
	}

}
