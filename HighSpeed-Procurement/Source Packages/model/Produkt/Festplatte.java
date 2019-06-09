package Produkt;

public class Festplatte extends Produkt {

private String anschluss;
private int speicherkapazitaet;

	public Festplatte(String typ, String name, String hersteller, String anschluss, int speicherkapazitaet) {
		super(typ, name, hersteller);		
		this.anschluss=anschluss;
		this.speicherkapazitaet= speicherkapazitaet;		
	}

	public Festplatte(int iD, String typ, String name, String hersteller, String string) {
		super(typ, name, hersteller);
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


}
