package model.Produkt;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import model.Bestellung.Produkt;

public class Netzwerkteil extends Produkt{
private double ampere;
private double volt;


	public Netzwerkteil(String name, String hersteller,double ampere,double volt) {
		super("Netzwerkteil", name, hersteller);
		this.ampere=ampere;
		this.volt=volt;
		
		
	}
	public Netzwerkteil(int iD, String name, String hersteller, String string) {
		super("Netzwerkteil", name, hersteller);
		String [] parts = new String[2];
		parts= string.split(";");
		this.ampere=Double.parseDouble(parts[0]);
		this.volt=Double.parseDouble(parts[1]);
	}
	public double getAmpere() {
		return ampere;
	}
	public void setAmpere(double ampere) {
		this.ampere = ampere;
	}
	public double getVolt() {
		return volt;
	}
	public void setVolt(double volt) {
		this.volt = volt;
	}
	
	//zusätliche Logik
	
		public String objectToString() {
			// Produktfremde variablen des Objekts in einem Sring zusammenfassen
			String s = Double.toString(this.ampere)+";"+Double.toString(this.volt);
			return s;
		}
		
		public void writeOne(TextField [] Textfelder) {
			//@Override
			//Auf dem Layer ein Produkt darstellen
			// Felder mit Produktdaten beschreiben
					Textfelder[0].setText(this.getName());
					Textfelder[1].setText(this.getHersteller());
					Textfelder[2].setText(Double.toString(this.getAmpere()));
					Textfelder[3].setText(Double.toString(this.getVolt()));

					

					
				}
		
		public static Produkt readLayer(TextField [] Textfelder) {
			//@Override
			//Aus dem Layer ein Produkt einlesen
				
			
			// Felder casten und Objekte bauen
					try {
						String name=Textfelder[0].getText();
						String hersteller=Textfelder[1].getText();
						double ampere=Double.parseDouble(Textfelder[2].getText());
						double volt=Double.parseDouble(Textfelder[3].getText());
						

						Netzwerkteil netzwerkteil=new Netzwerkteil(name,hersteller,ampere,volt);
						return netzwerkteil;
					} catch (Exception e) {
						// Generelle Fehlermeldung "Falscher Datentyp!" in einem Dialog auf FX
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Error Dialog: Netzwekteil.readLayer()");
						alert.setHeaderText("Folgender Fehler ist aufgetreten:");
						alert.setContentText("Falscher Datentyp! Bitte ï¿½berprï¿½fen sie ihre Eingaben!");

					}
					return null;	
		}

}
