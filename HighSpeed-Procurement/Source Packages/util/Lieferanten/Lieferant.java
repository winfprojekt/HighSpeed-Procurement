package Lieferanten;

import java.awt.TextField;
import java.util.ArrayList;

protected class Lieferant {
	
	private int iD;								
	private Adresse adresse;
	private Kontaktdaten kontaktdaten;
	private Bankdaten bankdaten;			
	private String lieferantenTyp;

	//Konstruktor
	public Lieferant(Adresse adresse, Kontaktdaten kontaktdaten, Bankdaten bankdaten,
			String lieferantenTyp) {
		super();
		this.iD = nextInvoiceNumber;
		nextInvoiceNumber++;
		this.adresse = adresse;
		this.kontaktdaten = kontaktdaten;
		this.bankdaten = bankdaten;
		this.lieferantenTyp = lieferantenTyp;
	}

	
	//toString

	@Override
	public String toString() {
		return "Lieferant [iD=" + iD + ",\nadresse=" + adresse + ",\nkontaktdaten=" + kontaktdaten + ", \nbankdaten="
				+ bankdaten + ", \nlieferdaten=" + lieferdaten + "]";
	}

	//Getter

	public int getiD() {
		return iD;
	}


	public Adresse getAdresse() {
		return adresse;
	}


	public Kontaktdaten getKontaktdaten() {
		return kontaktdaten;
	}


	public Bankdaten getBankdaten() {
		return bankdaten;
	}


	public Lieferdaten getLieferantenTyp) {
		return lieferantenTyp;
	}


		//Setter
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}


	public void setKontaktdaten(Kontaktdaten kontaktdaten) {
		this.kontaktdaten = kontaktdaten;
	}


	public void setBankdaten(Bankdaten bankdaten) {
		this.bankdaten = bankdaten;
	}


	public void setLieferantenTyp(Lieferdaten lieferdaten) {
		this.lieferantenTyp = lieferantenTyp;
	}

	// zusätzliche Logik
	
	//von der Datenbank alle Lieferanten einlesen
	public ArrayList<Lieferant> readAll() {
		//Alle Lieferanten aus der Datenbank auslesen
		ArrayList<Lieferant> alleLieferanten = new ArrayList<Lieferant>();
		// Aray List mit Lieferanten beschreiben
		return alleLieferanten;
	}
	
	/*public Lieferant readOneDB(int iD) {
	 * 
	 * Datenbankabfragen einfügen
	 * 
		Adresse adresse = new Adresse(name,straßeUndNummer,stadt,postleitzahl,land);
		Kontaktdaten kontaktdaten = Kontaktdaten(email,telefonnummer);
		Bankdaten bankdaten = Bankdaten(bank,iBAN,bicSwift,steuernummer);
		Lieferdaten lieferdaten = Lieferdaten(lieferbareDienstleistungen,lieferantenTyp);
		Lieferant lieferant = new Lieferant(adresse,kontaktdaten,bankdaten,lieferdaten);
		return lieferant;		
	}*/
	
	//vom Layer 1 Lieferant einlesen
	public Lieferant readOneLayer(TextField [] textfelder/*, ComboBox<String>[] comboBoxen*/){
		//Textboxen,etc außerhalb dieser Funktion als "new Array [] Textfeld textfelder" deklarieren
				if(fehleranalyse(textfelder)) {
					Adresse adresse = new Adresse(textfelder[0].getText(),textfelder[1].getText(),textfelder[2].getText(),Integer.parseInt(textfelder[3].getText()),"land"/*comboBoxen[0].getSelected()*/);
					Kontaktdaten kontaktdaten = new Kontaktdaten(textfelder[4].getText(),Integer.parseInt(textfelder[5].getText()));
					Bankdaten bankdaten = new Bankdaten(textfelder[6].getText(),textfelder[7].getText(),textfelder[8].getText(),Integer.parseInt(textfelder[9].getText()));
					Lieferdaten lieferdaten = new Lieferdaten("String1","string2");//comboBoxen[1].getSelected(),comboBoxen[2].getSelected()); 
					Lieferant lieferant = new Lieferant(adresse,kontaktdaten,bankdaten,lieferdaten);
					return lieferant;
				}
				else {
					return null;
				}		
	}
	
	//Auf layer Ausgeben
	//Alle
	public void writeAll(ArrayList<Lieferant> alleLieferanten) {
		/* Tabellengröße anpassen an*/ alleLieferanten.size();
		//  int arrayListCount = 0;
		for(Lieferant lieferant:alleLieferanten) {
			/*TabbelleColumns[arraListCount][0]= */lieferant.getAdresse().getName();
			lieferant.getAdresse().getStraßeUndNummer();
			lieferant.getAdresse().getStadt();
			Integer.toString(lieferant.getAdresse().getPostleitzahl());
			lieferant.getAdresse().getLand();
			
			lieferant.getKontaktdaten().getEmail();
			Integer.toString(lieferant.getKontaktdaten().getTelefonnummer());
			
			lieferant.getBankdaten().getBank();
			lieferant.getBankdaten().getiBAN();
			lieferant.getBankdaten().getBicSwift();
			Integer.toString(lieferant.getBankdaten().getSteuernummer());
			
			lieferant.getLieferdaten().getLieferbareDienstleistungen();
			lieferant.getLieferdaten().getLieferantenTyp();
			arrayListCount++;
		}
	}
	
	
	// nur einer
	public void writeOne(Lieferant lieferant,TextField[] textfelder/*, ComboBox<String>[] comboBoxen*/) {
		//Textboxen,etc außerhalb dieser Funktion als "new Array [] Textfeld textfelder" deklarieren
		
		//...
		//Felder zuordnen
		textfelder[0].setText(lieferant.getAdresse().getName());
		textfelder[1].setText(lieferant.getAdresse().getStraßeUndNummer());
		textfelder[2].setText(lieferant.getAdresse().getStadt());
		textfelder[3].setText(Integer.toString(lieferant.getAdresse().getPostleitzahl()));
		
		textfelder[4].setText(lieferant.getKontaktdaten().getEmail());
		textfelder[5].setText(Integer.toString(lieferant.getKontaktdaten().getTelefonnummer()));
		
		textfelder[6].setText(lieferant.getBankdaten().getBank());
		textfelder[7].setText(lieferant.getBankdaten().getiBAN());
		textfelder[8].setText(lieferant.getBankdaten().getBicSwift());
		textfelder[9].setText(Integer.toString(lieferant.getBankdaten().getSteuernummer()));
		
		lieferant.getAdresse().getLand();
		lieferant.getLieferdaten().getLieferbareDienstleistungen();
		lieferant.getLieferdaten().getLieferantenTyp();
	}
	
	//einen Lieferant in der Datenbank erstellen
	public void create() {
		//Textboxen,etc außerhalb dieser Funktion als "new Array [] Textfeld textfelder" deklarieren
		TextField[]textfelderLayer4= new TextField[10];
		if(readOneLayer(textfelderLayer4)==null) {
			//Datenbank speichern
		}
		else {
			return;
		}		
	}
	
	// einen Lieferant in der Datenbank ändern
	public void update() {
		
	}
	
	//Überprüfung der Nutzereingaben
	public String pflichtfelderAbfrage(TextField [] textfelder) {
		//Leere Rückgabe wenn alle Pflichtfelder ausgefüllt sind, ansonsten string aus allen leeren Pflichtfeldern.
				
		//Textboxen,etc außerhalb dieser Funktion als "new Array [] Textfeld textfelder" deklarieren
		
		String fehlercode="";		
		if (!(textfelder[0].getText().equals(""))){
			fehlercode += ", Name";
		}
		if(!(textfelder[1].getText().equals(""))){
			fehlercode += ", Straße und Nummer";
		}
		if(!(textfelder[2].getText().equals(""))){
			fehlercode += ", Stadt";
		}
		if(!(textfelder[3].getText().equals(""))){
			fehlercode += ", Postleitzahl";
		}
		if(!(textfelder[4].getText().equals(""))){
			fehlercode += ", E-Mail-Adresse";
		}
		if(!(textfelder[7].getText().equals(""))){
			fehlercode += ", IBAN";
		}
		if(!(textfelder[8].getText().equals(""))){
			fehlercode += ", BIC/Swift";
		}
		if(!(textfelder[9].getText().equals(""))){
			fehlercode += ", Steuernummer";
		}
		/*+ Lieferbare dienstleistungen Prüfen{
			fehlercode += ", Lieferbare Dienstleistungen";
		}*/	
		return fehlercode;
	}
	public String grammatikAbfrage(TextField [] textfelder) {
		//Achtung leere Felder sind kein Grammatik Widerspruch
		String fehlercode ="";
		return fehlercode;
	}
	
	
	public boolean fehleranalyse(TextField[] textfelder/*, ComboBox<String>[] comboBoxen*/) {
		if ((pflichtfelderAbfrage(textfelder).equals("")) && (grammatikAbfrage(textfelder).equals(""))) {
			return true;
		}
		else {
			String fehlercode = "";
			if((!(pflichtfelderAbfrage(textfelder).equals(""))) && (grammatikAbfrage(textfelder).equals(""))){
				fehlercode = "Folgende Pflichtfelder wurden nicht ausgefüllt:"+ pflichtfelderAbfrage(textfelder);
			}
			if((pflichtfelderAbfrage(textfelder).equals("")) && (!(grammatikAbfrage(textfelder).equals("")))){
				fehlercode = "Folgende Felder haben ein falsches Format:" + grammatikAbfrage(textfelder);
			}
			if((!(pflichtfelderAbfrage(textfelder).equals(""))) && (!(grammatikAbfrage(textfelder).equals("")))){
				fehlercode = "Folgende Pflichtfelder wurden nicht ausgefüllt:"+ pflichtfelderAbfrage(textfelder)
				+ "\n"+"Folgende Felder haben ein falsches Format:" + grammatikAbfrage(textfelder);
			}
			System.out.println(fehlercode);
			return false;
		}
	}
}
