package model.Produkt;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import model.Bestellung.Produkt;

public class Motherboard extends Produkt {
private double mhz;
private String motherboardTyp;
private String chipsatz;
private String prozessorsockel;
private int anzahlProzessoren;



	public Motherboard(String name, String hersteller, double mhz, String motherboardTyp, String chipsatz, String prozessorsockel, int anzahlProzessoren){
		super("Motherboard", name, hersteller);
		this.mhz=mhz;
		this.motherboardTyp=motherboardTyp;
		this.chipsatz=chipsatz;
		this.prozessorsockel=prozessorsockel;
		this.anzahlProzessoren=anzahlProzessoren;
		
	}


	public Motherboard(int iD, String name, String hersteller, String string) {
		super("Motherboard", name, hersteller);
		String [] parts = new String[5];
		parts= string.split(";");
		this.mhz=Double.parseDouble(parts[0]);
		this.motherboardTyp=parts[1];
		this.chipsatz=parts[2];
		this.prozessorsockel=parts[3];
		this.anzahlProzessoren=Integer.parseInt(parts[4]);
		
	}


	public double getMhz() {
		return mhz;
	}


	public void setMhz(double mhz) {
		this.mhz = mhz;
	}


	public String getMotherboardTyp() {
		return motherboardTyp;
	}


	public void setProdukttyp(String motherboardTyp) {
		this.motherboardTyp = motherboardTyp;
	}


	public String getChipsatz() {
		return chipsatz;
	}


	public void setChipsatz(String chipsatz) {
		this.chipsatz = chipsatz;
	}


	public String getProzessorsockel() {
		return prozessorsockel;
	}


	public void setProzessorsockel(String prozessorsockel) {
		this.prozessorsockel = prozessorsockel;
	}


	public int getAnzahlProzessoren() {
		return anzahlProzessoren;
	}


	public void setAnzahlProzessoren(int anzahlProzessoren) {
		this.anzahlProzessoren = anzahlProzessoren;
	}
	
	//zusätliche Logik
	
		public String objectToString() {
			// Produktfremde variablen des Objekts in einem Sring zusammenfassen
			String s = this.mhz+";"+this.motherboardTyp+";"+this.chipsatz+";"+this.prozessorsockel+";"+Integer.toString(this.anzahlProzessoren);
			return s;
		}
		
		public void writeOne(TextField [] Textfelder) {
			//@Override
			//Auf dem Layer ein Produkt darstellen
			// Felder mit Produktdaten beschreiben
					Textfelder[0].setText(this.getName());
					Textfelder[1].setText(this.getHersteller());
					Textfelder[2].setText(Double.toString(this.getMhz()));
					Textfelder[3].setText(this.getMotherboardTyp());
					Textfelder[4].setText(this.chipsatz);
					Textfelder[5].setText(this.prozessorsockel);
					Textfelder[6].setText(Integer.toString(this.anzahlProzessoren));

				}
		
		public static Produkt readLayer(TextField [] Textfelder) {
			//@Override
			//Aus dem Layer ein Produkt einlesen
				
			
			// Felder casten und Objekte bauen
					try {
						String name=Textfelder[0].getText();
						String hersteller=Textfelder[1].getText();
						double mhz=Double.parseDouble(Textfelder[2].getText());
						String motherboardTyp=Textfelder[3].getText();
						String chipsatz=Textfelder[4].getText();
						String prozessorsockel=Textfelder[5].getText();
						int anzahlProzessoren=Integer.parseInt(Textfelder[6].getText());						

						Motherboard motherboard=new Motherboard(name,hersteller,mhz,motherboardTyp,chipsatz,prozessorsockel,anzahlProzessoren);
						return motherboard;
					} catch (Exception e) {
						// Generelle Fehlermeldung "Falscher Datentyp!" in einem Dialog auf FX
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Error Dialog: Motherboard.readLayer()");
						alert.setHeaderText("Folgender Fehler ist aufgetreten:");
						alert.setContentText("Falscher Datentyp! Bitte ï¿½berprï¿½fen sie ihre Eingaben!");

					}
					return null;	
		}

}
