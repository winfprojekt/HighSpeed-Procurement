package Lieferanten;

protected class Adresse {
	private String name;
	private String straﬂeUndNummer;
	private String stadt;
	private int postleitzahl;
	private String land; 
	
	
	//Konstruktor
	public Adresse(String name, String straﬂeUndNummer, String stadt, int postleitzahl, String land) {
		super();
		this.name = name;
		this.straﬂeUndNummer = straﬂeUndNummer;
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



	public String getStraﬂeUndNummer() {
		return straﬂeUndNummer;
	}



	public void setStraﬂeUndNummer(String straﬂeUndNummer) {
		this.straﬂeUndNummer = straﬂeUndNummer;
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
		return "Adresse [name=" + name + ", straﬂeUndNummer=" + straﬂeUndNummer + ", stadt=" + stadt + ", postleitzahl="
				+ postleitzahl + ", land=" + land + "]";
	}

	
	
}
