package util;

class Angebot {
	//private int iD;???
	private Lieferant lieferant;
	private Produkt produkt;
	private double Einzelpreis;
	// private int gültigkeitsdauer;

	//Konstruktor
	public Angebot(Lieferant lieferant, Produkt produkt, double einzelpreis) {
		super();
		this.lieferant = lieferant;
		this.produkt = produkt;
		Einzelpreis = einzelpreis;
	}
	
	//Getter + Setter
	public Lieferant getLieferant() {
		return lieferant;
	}
	public void setLieferant(Lieferant lieferant) {
		this.lieferant = lieferant;
	}
	public Produkt getProdukt() {
		return produkt;
	}
	public void setProdukt(Produkt produkt) {
		this.produkt = produkt;
	}
	public double getEinzelpreis() {
		return Einzelpreis;
	}
	public void setEinzelpreis(double einzelpreis) {
		Einzelpreis = einzelpreis;
	}

}
 