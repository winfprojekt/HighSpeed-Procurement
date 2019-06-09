package Produkt;

public class Chassis extends Produkt {

private String teilenummer;
private int gtin;

	public Chassis(String typ, String name, String hersteller, String teilenummer, int gtin) {
		super(typ, name, hersteller);
		
		this.teilenummer=teilenummer;
		this.gtin=gtin;
		
	
	}

	public Chassis(int iD, String typ, String name, String hersteller, String string) {
		super(typ, name, hersteller);
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
		
}
	
	


