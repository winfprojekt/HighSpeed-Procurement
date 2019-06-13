package model.Produkt;



import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import model.Bestellung.Produkt;

public class Chassis extends Produkt {

private String teilenummer;
private int gtin;


	public Chassis(String name, String hersteller, String teilenummer, int gtin) {
		super("Chassis", name, hersteller);
		
		this.teilenummer=teilenummer;
		this.gtin=gtin;
		
	
	}

	public Chassis(int iD, String name, String hersteller, String string) {
		super("Chassis", name, hersteller);
		String [] parts = new String[2];
		parts= string.split(";");
		this.teilenummer=parts[0];
		this.gtin=Integer.parseInt(parts[1]);
	}

	public String getTeilenummer() {
		return teilenummer;
	}

	public void setTeilenummer(String teilenummer) {
		this.teilenummer = teilenummer;
	}

	public int getGtin() {
		return gtin;
	}

	public void setGtin(int gtin) {
		this.gtin = gtin;
	}
		
	public String objectToString() {
		// Produktfremde variablen des Objekts in einem Sring zusammenfassen
		String s = this.teilenummer+";"+Integer.toString(this.gtin);
		return s;
	}
	
	public void writeOne(TextField [] Textfelder) {
		//@Override
		//Auf dem Layer ein Produkt darstellen
		// Felder mit Produktdaten beschreiben
				Textfelder[0].setText(this.getName());
				Textfelder[1].setText(this.getHersteller());
				Textfelder[2].setText(this.getTeilenummer());
				Textfelder[3].setText(Integer.toString(this.getGtin()));
			
			}

	public static Produkt readLayer(TextField [] Textfelder) {
		//@Override
		//Aus dem Layer ein Produkt einlesen
			
		
		// Felder casten und Objekte bauen
				try {
					String name=Textfelder[0].getText();
					String hersteller=Textfelder[1].getText();
					
					String teilenummer=Textfelder[2].getText();
					int gtin=Integer.parseInt(Textfelder[3].getText());					

					Chassis chassis=new Chassis(name,hersteller,teilenummer,gtin);
					return chassis;
				} catch (Exception e) {
					// Generelle Fehlermeldung "Falscher Datentyp!" in einem Dialog auf FX
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error Dialog: Chassis.readLayer()");
					alert.setHeaderText("Folgender Fehler ist aufgetreten:");
					alert.setContentText("Falscher Datentyp! Bitte �berpr�fen sie ihre Eingaben!");

				}
				return null;	
	}
		
}
	
	


