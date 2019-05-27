package util;

class Adresse {
	private String name;
	private String straßeUndNummer;
	private String stadt;
	private int postleitzahl;
	private String land; 
	
	
	//Konstruktor
	public Adresse(String name, String straßeUndNummer, String stadt, int postleitzahl, String land) {
		super();
		this.name = name;
		this.straßeUndNummer = straßeUndNummer;
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



	public String getStraßeUndNummer() {
		return straßeUndNummer;
	}



	public void setStraßeUndNummer(String straßeUndNummer) {
		this.straßeUndNummer = straßeUndNummer;
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


	// toString
	@Override
	public String toString() {
		return "Adresse [name=" + name + ", straßeUndNummer=" + straßeUndNummer + ", stadt=" + stadt + ", postleitzahl="
				+ postleitzahl + ", land=" + land + "]";
	}

	
	
}
