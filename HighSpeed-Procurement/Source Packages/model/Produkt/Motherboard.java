package Produkt;

public class Motherboard extends Produkt {
private double mhz;
private String motherboardTyp;
private String chipsatz;
private String prozessorsockel;
private int anzahlProzessoren;


	public Motherboard(String typ, String name, String hersteller, double mhz, String motherboardTyp, String chipsatz, String prozessorsockel, int anzahlProzessoren){
		super(typ, name, hersteller);
		this.mhz=mhz;
		this.motherboardTyp=motherboardTyp;
		this.chipsatz=chipsatz;
		this.prozessorsockel=prozessorsockel;
		this.anzahlProzessoren=anzahlProzessoren;
		
	}


	public Motherboard(int iD, String typ, String name, String hersteller, String string) {
		super(typ, name, hersteller);
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

}
