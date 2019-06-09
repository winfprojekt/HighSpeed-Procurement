package Produkt;

public class Prozessor extends Produkt{
private int anzahlKerne;
private String prozessorsockel;
private double prozessortakt;

	public Prozessor(String typ, String name, String hersteller, int anzahlKerne, String prozessorsockel, double prozessortakt) {
		super(typ, name, hersteller);
		this.anzahlKerne=anzahlKerne;
		this.prozessorsockel=prozessorsockel;
		this.prozessortakt=prozessortakt;
	
		
	}
	public Prozessor(int iD, String typ, String name, String hersteller, String string) {
		//Konstruktor mit String aus der DB
		super(typ, name, hersteller);
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
		// Produktfremde variablen des Objekts in einem Sring zusammenfassen
		String s = Integer.toString(this.anzahlKerne)+";"+this.prozessorsockel+";"+Double.toString(this.prozessortakt);
		return s;
	}

	
	
}



