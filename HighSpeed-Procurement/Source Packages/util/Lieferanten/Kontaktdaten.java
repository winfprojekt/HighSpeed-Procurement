package Lieferanten;

public class Kontaktdaten {
	private String email;
	private int telefonnummer;	//bestimmtes Format?
	
	
	
	public Kontaktdaten(String email, int telefonnummer) {
		super();
		this.email = email;
		this.telefonnummer = telefonnummer;
	}
	
	public Kontaktdaten update (String email, int telefonnummer) {
		this.email = email;
		this.telefonnummer = telefonnummer;
		return this;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public int getTelefonnummer() {
		return telefonnummer;
	}



	public void setTelefonnummer(int telefonnummer) {
		this.telefonnummer = telefonnummer;
	}



	@Override
	public String toString() {
		return "Kontaktdaten [email=" + email + ", telefonnummer=" + telefonnummer + "]";
	}	
	

}
