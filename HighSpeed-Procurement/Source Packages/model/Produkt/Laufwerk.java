package model.Produkt;



import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import model.Bestellung.Produkt;

public class Laufwerk extends Produkt{
	

private String format;
private String laufwerkTyp;
private String verbindung;



	public Laufwerk(String name, String hersteller, String format, String laufwerkTyp, String verbindung) {
		super("Laufwerk", name, hersteller);
	
		this.format=format;
		this.laufwerkTyp=laufwerkTyp;
		this.verbindung=verbindung;
	
	}


	public Laufwerk(int iD, String name, String hersteller, String string) {
		super("Laufwerk", name, hersteller);
		String [] parts = new String[3];
		parts= string.split(";");
		this.format=parts[0];
		this.laufwerkTyp=parts[1];
		this.verbindung=parts[2];
		// TODO Auto-generated constructor stub
	}


	public String getFormat() {
		return format;
	}


	public void setFormat(String format) {
		this.format = format;
	}


	public String getLaufwerkTyp() {
		return laufwerkTyp;
	}


	public void setLaufwerkTyp(String laufwerkTyp) {
		this.laufwerkTyp = laufwerkTyp;
	}


	public String getVerbindung() {
		return verbindung;
	}


	public void setVerbindung(String verbindung) {
		this.verbindung = verbindung;
	}
	
	//zusätliche Logik
	
			public String objectToString() {
				// Produktfremde variablen des Objekts in einem Sring zusammenfassen
				String s = this.format+";"+this.laufwerkTyp+";"+this.verbindung;
				return s;
			}
			
			
			public void writeOne(TextField [] Textfelder) {
				//@Override
				//Auf dem Layer ein Produkt darstellen
				// Felder mit Produktdaten beschreiben
						Textfelder[0].setText(this.getName());
						Textfelder[1].setText(this.getHersteller());
						Textfelder[2].setText(this.getFormat());
						Textfelder[3].setText(this.getLaufwerkTyp());
						Textfelder[4].setText(this.getVerbindung());

					}
			
			public static Produkt readLayer(TextField [] Textfelder) {
				//@Override
				//Aus dem Layer ein Produkt einlesen
					
				
				// Felder casten und Objekte bauen
						try {
							String name=Textfelder[0].getText();
							String hersteller=Textfelder[1].getText();
							String format=Textfelder[2].getText();
							String laufwerkTyp=Textfelder[3].getText();
							String verbindung=Textfelder[4].getText();						

							Laufwerk laufwerk=new Laufwerk(name,hersteller,format,laufwerkTyp,verbindung);
							return laufwerk;
						} catch (Exception e) {
							// Generelle Fehlermeldung "Falscher Datentyp!" in einem Dialog auf FX
							Alert alert = new Alert(AlertType.ERROR);
							alert.setTitle("Error Dialog: Laufwerk.readLayer()");
							alert.setHeaderText("Folgender Fehler ist aufgetreten:");
							alert.setContentText("Falscher Datentyp! Bitte ï¿½berprï¿½fen sie ihre Eingaben!");

						}
						return null;	
			}
	
}