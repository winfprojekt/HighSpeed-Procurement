package Lieferanten;

protected class Kontaktdaten {
	private String email;
	private int telefonnummer;
	
	
	//Konstruktor
	public Kontaktdaten(String email, int telefonnummer) {
		super();
		this.email = email;
		this.telefonnummer = telefonnummer;
	}
	

	//Getter
	public String getEmail() {
		return email;
	}

	public int getTelefonnummer() {
		return telefonnummer;
	}

	//Setter
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setTelefonnummer(int telefonnummer) {
		this.telefonnummer = telefonnummer;
	}


	//toString
	@Override
	public String toString() {
		return "Kontaktdaten [email=" + email + ", telefonnummer=" + telefonnummer + "]";
	}	
	

}
