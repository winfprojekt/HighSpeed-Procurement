package model.Produkt;



import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import model.Bestellung.Produkt;


public class Prozessor extends Produkt{
private int anzahlKerne;
private String prozessorsockel;
private double prozessortakt;


	public Prozessor(String name, String hersteller, int anzahlKerne, String prozessorsockel, double prozessortakt) {
		super("Prozessor", name, hersteller);
		this.anzahlKerne=anzahlKerne;
		this.prozessorsockel=prozessorsockel;
		this.prozessortakt=prozessortakt;
	
		
	}
	public Prozessor(int iD, String name, String hersteller, String string) {
		//Konstruktor mit String aus der DB
		super("Prozessor", name, hersteller);
		String [] parts = new String[3];
		parts= string.split(";");
		this.anzahlKerne=Integer.parseInt(parts[0]);
		this.prozessorsockel=parts[1];
		this.prozessortakt=Double.parseDouble(parts[2]);	
		
	}
	

	public int getAnzahlKerne() {
		return anzahlKerne;
	}

	public void setAnzahlKerne(int anzahlKerne) {
		this.anzahlKerne = anzahlKerne;
	}

	public String getProzessorsockel() {
		return prozessorsockel;
	}

	public void setProzessorsockel(String prozessorsockel) {
		this.prozessorsockel = prozessorsockel;
	}

	public double getProzessortakt() {
		return prozessortakt;
	}

	public void setProzessortakt(double prozessortakt) {
		this.prozessortakt = prozessortakt;
	}
	
	//zusätliche Logik
	
	public String objectToString() {
		//@Override
		// Produktfremde variablen des Objekts in einem Sring zusammenfassen
		String s = Integer.toString(this.anzahlKerne)+";"+this.prozessorsockel+";"+Double.toString(this.prozessortakt);
		return s;
	}
	
	public void writeOne(TextField [] Textfelder) {
		//@Override
		//Auf dem Layer ein Produkt darstellen
		// Felder mit Produktdaten beschreiben
				Textfelder[0].setText(this.getName());
				Textfelder[1].setText(this.getHersteller());
				Textfelder[2].setText(Integer.toString(this.getAnzahlKerne()));
				Textfelder[3].setText(this.getProzessorsockel());		
				Textfelder[4].setText(Double.toString(this.getProzessortakt()));

				
			}
	
	public static Produkt readLayer(TextField [] Textfelder) {
		//@Override
		//Aus dem Layer ein Produkt einlesen
			
		
		// Felder casten und Objekte bauen
				try {
					String name=Textfelder[0].getText();
					String hersteller=Textfelder[1].getText();
					int anzahlKerne=Integer.parseInt(Textfelder[2].getText());
					String prozessorsockel=Textfelder[3].getText();
					Double prozessortakt=Double.parseDouble(Textfelder[4].getText());

					Prozessor prozessor=new Prozessor(name,hersteller,anzahlKerne,prozessorsockel,prozessortakt);
					return prozessor;
				} catch (Exception e) {
					// Generelle Fehlermeldung "Falscher Datentyp!" in einem Dialog auf FX
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error Dialog: Prozessor.readLayer()");
					alert.setHeaderText("Folgender Fehler ist aufgetreten:");
					alert.setContentText("Falscher Datentyp! Bitte ï¿½berprï¿½fen sie ihre Eingaben!");

				}
				return null;
		
		
	}
}



