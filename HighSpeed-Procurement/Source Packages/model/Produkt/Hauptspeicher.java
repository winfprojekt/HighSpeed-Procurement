package model.Produkt;



import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import model.Bestellung.Produkt;

public class Hauptspeicher extends Produkt{
	private String marke;
	private String speicherTyp;
	private int speicherkapazitaet;


public Hauptspeicher(String name, String hersteller, String marke, String speicherTyp, int speicherkapazitaet) {
	super("Hauptspeicher", name, hersteller);
	this.marke=marke;
	this.speicherTyp=speicherTyp;
	this.speicherkapazitaet=speicherkapazitaet;
	}

public Hauptspeicher(int iD, String name, String hersteller, String string) {
	super("Hauptspeicher", name, hersteller);
	String [] parts = new String[3];
	parts= string.split(";");
	this.marke=parts[0];
	this.speicherTyp=parts[1];
	this.speicherkapazitaet=Integer.parseInt(parts[2]);
	
}

public String getMarke() {
	return marke;
}

public void setMarke(String marke) {
	this.marke = marke;
}

public String getSpeicherTyp() {
	return speicherTyp;
}

public void setSpeicherTyp(String speicherTyp) {
	this.speicherTyp = speicherTyp;
}

public int getSpeicherkapazitaet() {
	return speicherkapazitaet;
}

public void setSpeicherkapazitaet(int speicherkapazitaet) {
	this.speicherkapazitaet = speicherkapazitaet;
}

//zusätliche Logik

public String objectToString() {
	// Produktfremde variablen des Objekts in einem Sring zusammenfassen
	String s = this.marke+";"+this.speicherTyp+";"+Integer.toString(this.speicherkapazitaet);
	return s;
}

public void writeOne(TextField [] Textfelder) {
	//@Override
	//Auf dem Layer ein Produkt darstellen
	// Felder mit Produktdaten beschreiben
			Textfelder[0].setText(this.getName());
			Textfelder[1].setText(this.getHersteller());
			Textfelder[2].setText(this.getMarke());
			Textfelder[3].setText(this.getSpeicherTyp());
			Textfelder[4].setText(Integer.toString(this.getSpeicherkapazitaet()));
	
		}

public static Produkt readLayer(TextField [] Textfelder) {
	//@Override
	//Aus dem Layer ein Produkt einlesen
		
	
	// Felder casten und Objekte bauen
			try {
				String name=Textfelder[0].getText();
				String hersteller=Textfelder[1].getText();
				String marke=Textfelder[2].getText();
				String speicherTyp=Textfelder[3].getText();
				int speicherkapazitaet=Integer.parseInt(Textfelder[4].getText());						

				Hauptspeicher hauptspeicher=new Hauptspeicher(name,hersteller,marke,speicherTyp,speicherkapazitaet);
				return hauptspeicher;
			} catch (Exception e) {
				// Generelle Fehlermeldung "Falscher Datentyp!" in einem Dialog auf FX
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Dialog: Hauptspeicher.readLayer()");
				alert.setHeaderText("Folgender Fehler ist aufgetreten:");
				alert.setContentText("Falscher Datentyp! Bitte ï¿½berprï¿½fen sie ihre Eingaben!");

			}
			return null;	
}

	
}

