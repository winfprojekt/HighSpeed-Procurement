package Produkt;

public class Laufwerk extends Produkt{
	

private String format;
private String laufwerkTyp;
private String verbindung;


	public Laufwerk(String typ, String name, String hersteller, String format, String laufwerkTyp, String verbindung) {
		super(typ, name, hersteller);
	
		this.format=format;
		this.laufwerkTyp=laufwerkTyp;
		this.verbindung=verbindung;
	
	}


	public Laufwerk(int iD, String typ, String name, String hersteller, String string) {
		super(typ, name, hersteller);
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
	
}