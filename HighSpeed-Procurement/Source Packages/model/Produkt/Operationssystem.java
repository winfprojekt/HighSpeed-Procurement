package model.Produkt;


import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import model.Bestellung.Produkt;

public class Operationssystem extends Produkt {
	
	private int erscheinungsJahr;


	public Operationssystem(String name, String hersteller, int erscheinungsJahr) {
		super("Operationssystem", name, hersteller);
		this.erscheinungsJahr = erscheinungsJahr;
				
		
	}

	public Operationssystem(int iD, String name, String hersteller, String string) {
		super("Operationssystem", name, hersteller);
		this.erscheinungsJahr=Integer.parseInt(string);
		//parts einfügen wenn Variablen deklariert sind + public String objectToString() implementieren
	}
	
	//getter+ Setter	
	public int getErscheinungsJahr() {
		return erscheinungsJahr;
	}

	public void setErscheinungsJahr(int erscheinungsJahr) {
		this.erscheinungsJahr = erscheinungsJahr;
	}
	
	//zusätliche Logik
	
			public String objectToString() {
				// Produktfremde variablen des Objekts in einem Sring zusammenfassen
				return Integer.toString(this.erscheinungsJahr);
			}
			
			public void writeOne(TextField [] Textfelder) {
				//@Override
				//Auf dem Layer ein Produkt darstellen
				// Felder mit Produktdaten beschreiben
						Textfelder[0].setText(this.getName());
						Textfelder[1].setText(this.getHersteller());
						Textfelder[2].setText(Integer.toString(this.getErscheinungsJahr()));

						
					}
			
			public static Produkt readLayer(TextField [] Textfelder) {
				//@Override
				//Aus dem Layer ein Produkt einlesen
					
				
				// Felder casten und Objekte bauen
						try {
							String name=Textfelder[0].getText();
							String hersteller=Textfelder[1].getText();
							int erscheinungsjahr=Integer.parseInt(Textfelder[2].getText());
							

							Operationssystem operationssystem=new Operationssystem(name,hersteller,erscheinungsjahr);
							return operationssystem;
						} catch (Exception e) {
							// Generelle Fehlermeldung "Falscher Datentyp!" in einem Dialog auf FX
							Alert alert = new Alert(AlertType.ERROR);
							alert.setTitle("Error Dialog: Operationssystem.readLayer()");
							alert.setHeaderText("Folgender Fehler ist aufgetreten:");
							alert.setContentText("Falscher Datentyp! Bitte ï¿½berprï¿½fen sie ihre Eingaben!");

						}
						return null;	
			}

}
