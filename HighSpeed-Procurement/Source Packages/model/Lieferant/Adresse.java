package model.Lieferant;

public class Adresse {
	private String name;
	private String strasseUndNummer;
	private String stadt;
	private int postleitzahl;
	private String land; 
	
	
	//Konstruktor 0
	public Adresse(String name, String strasseUndNummer, String stadt, int postleitzahl, String land) {
		
		this.name = name;
		this.strasseUndNummer = strasseUndNummer;
		this.stadt = stadt;
		this.postleitzahl = postleitzahl;
		this.land = land;
	}
	

	//Konstruktor 1
	public Adresse(String strasseUndNummer, String stadt, int postleitzahl, String land) {
		
		this.strasseUndNummer = strasseUndNummer;
		this.stadt = stadt;
		this.postleitzahl = postleitzahl;
		this.land = land;
	}
	
	//Getter + Setter
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getStrasseUndNummer() {
		return strasseUndNummer;
	}



	public void setStrasseUndNummer(String strasseUndNummer) {
		this.strasseUndNummer = strasseUndNummer;
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


	// toString 0
	@Override
	public String toString() {
		return " " + strasseUndNummer + ", " + stadt + ", "
				+ postleitzahl + " " + land + " ";
		
	}

	//toString 1
	public String toString1() {
		return "Adresse [name=" + name + ", strasseUndNummer=" + strasseUndNummer + ", stadt=" + stadt + ", postleitzahl="
				+ postleitzahl + ", land=" + land + "]";
	}
	
}
