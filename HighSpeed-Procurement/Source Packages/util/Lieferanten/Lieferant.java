package Lieferanten;

public class Lieferant {
	private static int nextInvoiceNumber = 0;
	private int iD;								//Fällt bei jedem Programmstort noch auf 0
	private Adresse adresse;
	private Kontaktdaten kontaktdaten;
	private Bankdaten bankdaten;
	private Lieferdaten lieferdaten;			//private Liefearantentyp lieferantenTyp?
	
	
	public Lieferant(Adresse adresse, Kontaktdaten kontaktdaten, Bankdaten bankdaten,
			Lieferdaten lieferdaten) {
		super();
		this.iD = nextInvoiceNumber;
		nextInvoiceNumber++;
		this.adresse = adresse;
		this.kontaktdaten = kontaktdaten;
		this.bankdaten = bankdaten;
		this.lieferdaten = lieferdaten;
	}

	
	public Lieferant update(Adresse adresse, Kontaktdaten kontaktdaten, Bankdaten bankdaten,
			Lieferdaten lieferdaten) {
		this.adresse = adresse;
		this.kontaktdaten = kontaktdaten;
		this.bankdaten = bankdaten;
		this.lieferdaten = lieferdaten;
		System.out.println(this.iD+", "+this.adresse.getName() +" wurde erfolgreich geändert!");
		return this;
	}


	@Override
	public String toString() {
		return "Lieferant [iD=" + iD + ",\nadresse=" + adresse + ",\nkontaktdaten=" + kontaktdaten + ", \nbankdaten="
				+ bankdaten + ", \nlieferdaten=" + lieferdaten + "]";
	}


	public static int getNextInvoiceNumber() {
		return nextInvoiceNumber;
	}


	public int getiD() {
		return iD;
	}


	public Adresse getAdresse() {
		return adresse;
	}


	public Kontaktdaten getKontaktdaten() {
		return kontaktdaten;
	}


	public Bankdaten getBankdaten() {
		return bankdaten;
	}


	public Lieferdaten getLieferdaten() {
		return lieferdaten;
	}


	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}


	public void setKontaktdaten(Kontaktdaten kontaktdaten) {
		this.kontaktdaten = kontaktdaten;
	}


	public void setBankdaten(Bankdaten bankdaten) {
		this.bankdaten = bankdaten;
	}


	public void setLieferdaten(Lieferdaten lieferdaten) {
		this.lieferdaten = lieferdaten;
	}

}
