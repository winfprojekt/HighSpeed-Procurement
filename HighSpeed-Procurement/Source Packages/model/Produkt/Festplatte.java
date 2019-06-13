package model.Produkt;



import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import model.Bestellung.Produkt;

public class Festplatte extends Produkt {

private String anschluss;
private int speicherkapazitaet;


	public Festplatte(String name, String hersteller, String anschluss, int speicherkapazitaet) {
		super("Festplatte", name, hersteller);		
		this.anschluss=anschluss;
		this.speicherkapazitaet= speicherkapazitaet;		
	}

	public Festplatte(int iD, String name, String hersteller, String string) {
		super("Festplatte", name, hersteller);
		String [] parts = new String[2];
		parts= string.split(";");
		this.anschluss=parts[0];
		this.speicherkapazitaet= Integer.parseInt(parts[1]);
	}



	public String getAnschluss() {
		return anschluss;
	}

	public void setAnschluss(String anschluss) {
		this.anschluss = anschluss;
	}

	public int getSpeicherkapazitaet() {
		return speicherkapazitaet;
	}

	public void setSpeicherkapazitaet(int speicherkapazitaet) {
		this.speicherkapazitaet = speicherkapazitaet;
	}
	
	public String objectToString() {
		// Produktfremde variablen des Objekts in einem Sring zusammenfassen
		String s = this.anschluss+";"+Integer.toString(this.speicherkapazitaet);
		return s;
	}
	
	public void writeOne(TextField [] Textfelder) {
		//@Override
		//Auf dem Layer ein Produkt darstellen
		// Felder mit Produktdaten beschreiben
				Textfelder[0].setText(this.getName());
				Textfelder[1].setText(this.getHersteller());
				Textfelder[2].setText(this.getAnschluss());
				Textfelder[3].setText(Integer.toString(this.getSpeicherkapazitaet()));
			
			}

	public static Produkt readLayer(TextField [] Textfelder) {
		//@Override
		//Aus dem Layer ein Produkt einlesen
			
		
		// Felder casten und Objekte bauen
				try {
					String name=Textfelder[0].getText();
					String hersteller=Textfelder[1].getText();
					
					String anschluss=Textfelder[2].getText();
					int speicherkapazitaet=Integer.parseInt(Textfelder[3].getText());
					

					
					

					Festplatte festplatte=new Festplatte(name,hersteller,anschluss,speicherkapazitaet);
					return festplatte;
				} catch (Exception e) {
					// Generelle Fehlermeldung "Falscher Datentyp!" in einem Dialog auf FX
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error Dialog: Festplatte.readLayer()");
					alert.setHeaderText("Folgender Fehler ist aufgetreten:");
					alert.setContentText("Falscher Datentyp! Bitte �berpr�fen sie ihre Eingaben!");

				}
				return null;	
	}


}
