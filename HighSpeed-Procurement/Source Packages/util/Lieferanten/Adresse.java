package Lieferanten;

public class Adresse {
	private String name;
	private String stra�eUndNummer;
	private String stadt;
	private int postleitzahl; //7 Stellen
	private String land; //private Land land?
	
	
	
	public Adresse(String name, String stra�eUndNummer, String stadt, int postleitzahl, String land) {
		super();
		this.name = name;
		this.stra�eUndNummer = stra�eUndNummer;
		this.stadt = stadt;
		this.postleitzahl = postleitzahl;
		this.land = land;
	}
	
	public Adresse update (String name, String stra�eUndNummer, String stadt, int postleitzahl, String land) {
		this.name = name;
		this.stra�eUndNummer = stra�eUndNummer;
		this.stadt = stadt;
		this.postleitzahl = postleitzahl;
		this.land = land;
		
		return this;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getStra�eUndNummer() {
		return stra�eUndNummer;
	}



	public void setStra�eUndNummer(String stra�eUndNummer) {
		this.stra�eUndNummer = stra�eUndNummer;
	}



	public String getStadt() {
		return stadt;
	}



	public void setStadt(String stadt) {
		this.stadt = stadt;
	}



	public int getPostleitzahl() {
		return postleitzahl;
	}



	public void setPostleitzahl(int postleitzahl) {
		this.postleitzahl = postleitzahl;
	}



	public String getLand() {
		return land;
	}



	public void setLand(String land) {
		this.land = land;
	}



	@Override
	public String toString() {
		return "Adresse [name=" + name + ", stra�eUndNummer=" + stra�eUndNummer + ", stadt=" + stadt + ", postleitzahl="
				+ postleitzahl + ", land=" + land + "]";
	}

	
	
}
