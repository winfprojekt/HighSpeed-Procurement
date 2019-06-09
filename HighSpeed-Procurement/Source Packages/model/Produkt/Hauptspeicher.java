package Produkt;

public class Hauptspeicher extends Produkt{
	private String marke;
	private String speicherTyp;
	private int speicherkapazitaet;

public Hauptspeicher(String typ, String name, String hersteller, String marke, String speicherTyp, int speicherkapazitaet) {
	super(typ, name, hersteller);
	this.marke=marke;
	this.speicherTyp=speicherTyp;
	this.speicherkapazitaet=speicherkapazitaet;
	}

public Hauptspeicher(int iD, String typ, String name, String hersteller, String string) {
	super(typ, name, hersteller);
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

	
}

