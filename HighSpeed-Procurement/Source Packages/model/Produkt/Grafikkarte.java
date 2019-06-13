package model.Produkt;



import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import model.Bestellung.Produkt;

public class Grafikkarte extends Produkt {
	
private double mhz;
private String chipsatz;
private int videospeicher;



	public Grafikkarte(String name, String hersteller, double mhz, String chipsatz, int videospeicher) {
		super("Grafikkarte", name, hersteller);
		this.mhz=mhz;		
		this.chipsatz=chipsatz;
		this.videospeicher=videospeicher;
	
	}

	public Grafikkarte(int iD, String name, String hersteller, String string) {
		super("Grafikkarte", name, hersteller);
		String [] parts = new String[3];
		parts= string.split(";");
		this.mhz=Double.parseDouble(parts[0]);		
		this.chipsatz=parts[1];
		this.videospeicher=Integer.parseInt(parts[2]);
	}

	public double getMhz() {
		return mhz;
	}

	public void setMhz(double mhz) {
		this.mhz = mhz;
	}

	public String getChipsatz() {
		return chipsatz;
	}

	public void setChipsatz(String chipsatz) {
		this.chipsatz = chipsatz;
	}

	public int getVideospeicher() {
		return videospeicher;
	}

	public void setVideospeicher(int videospeicher) {
		this.videospeicher = videospeicher;
	}
	
	//zusätliche Logik

	public String objectToString() {
		// Produktfremde variablen des Objekts in einem Sring zusammenfassen
		String s = Double.toString(this.mhz)+";"+this.chipsatz+";"+Integer.toString(this.videospeicher);
		return s;
	}
	
	public void writeOne(TextField [] Textfelder) {
		//@Override
		//Auf dem Layer ein Produkt darstellen
		// Felder mit Produktdaten beschreiben
				Textfelder[0].setText(this.getName());
				Textfelder[1].setText(this.getHersteller());
				Textfelder[2].setText(Double.toString(this.getMhz()));
				Textfelder[3].setText(this.getChipsatz());
				Textfelder[4].setText(Integer.toString(this.getVideospeicher()));
		
		
			}

	public static Produkt readLayer(TextField [] Textfelder) {
		//@Override
		//Aus dem Layer ein Produkt einlesen
			
		
		// Felder casten und Objekte bauen
				try {
					String name=Textfelder[0].getText();
					String hersteller=Textfelder[1].getText();
					double mhz=Double.parseDouble(Textfelder[2].getText());
					String chipsatz=Textfelder[3].getText();
					int videospeicher=Integer.parseInt(Textfelder[4].getText());	
					

					Grafikkarte grafikkarte=new Grafikkarte(name,hersteller,mhz,chipsatz,videospeicher);
					return grafikkarte;
				} catch (Exception e) {
					// Generelle Fehlermeldung "Falscher Datentyp!" in einem Dialog auf FX
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error Dialog: Grafikkarte.readLayer()");
					alert.setHeaderText("Folgender Fehler ist aufgetreten:");
					alert.setContentText("Falscher Datentyp! Bitte ï¿½berprï¿½fen sie ihre Eingaben!");

				}
				return null;	
	}

}
