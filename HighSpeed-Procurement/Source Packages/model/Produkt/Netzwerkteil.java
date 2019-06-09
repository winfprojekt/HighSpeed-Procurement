package Produkt;

public class Netzwerkteil extends Produkt{
private double ampere;
private double volt;

	public Netzwerkteil(String typ, String name, String hersteller,double ampere,double volt) {
		super(typ, name, hersteller);
		this.ampere=ampere;
		this.volt=volt;
		
		
	}
	public Netzwerkteil(int iD, String typ, String name, String hersteller, String string) {
		super(typ, name, hersteller);
		String [] parts = new String[2];
		parts= string.split(";");
		this.ampere=Double.parseDouble(parts[0]);
		this.volt=Double.parseDouble(parts[1]);
	}
	public double getAmpere() {
		return ampere;
	}
	public void setAmpere(double ampere) {
		this.ampere = ampere;
	}
	public double getVolt() {
		return volt;
	}
	public void setVolt(double volt) {
		this.volt = volt;
	}
	
	//zusätliche Logik
	
		public String objectToString() {
			// Produktfremde variablen des Objekts in einem Sring zusammenfassen
			String s = Double.toString(this.ampere)+";"+Double.toString(this.volt);
			return s;
		}

}
