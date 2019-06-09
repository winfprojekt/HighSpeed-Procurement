package model.Lieferant;

public class Kontaktdaten {
	private String email;
	private String telefonnummer;

	// Konstruktor
	public Kontaktdaten(String email, String telefonnummer) {
		super();
		this.email = email;
		this.telefonnummer = telefonnummer;
	}

	// Getter
	public String getEmail() {
		return email;
	}

	public String getTelefonnummer() {
		return telefonnummer;
	}

	// Setter
	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
	}

	// toString
	@Override
	public String toString() {
		return "Kontaktdaten [email=" + email + ", telefonnummer=" + telefonnummer + "]";
	}

}
