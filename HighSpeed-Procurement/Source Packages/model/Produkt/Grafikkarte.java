package Produkt;

public class Grafikkarte extends Produkt {
	
private double mhz;
private String chipsatz;
private int videospeicher;


	public Grafikkarte(String typ, String name, String hersteller, double mhz, String chipsatz, int videospeicher) {
		super(typ, name, hersteller);
		this.mhz=mhz;		
		this.chipsatz=chipsatz;
		this.videospeicher=videospeicher;
	
	}

	public Grafikkarte(int iD, String typ, String name, String hersteller, String string) {
		super(typ, name, hersteller);
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

}
