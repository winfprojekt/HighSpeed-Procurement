package Lieferanten;

public class Lieferdaten {
	private String lieferbareDienstleistungen;	//private Lieferbaredienstleistungen lieferbareDienstleistungen
	private String lieferantenTyp;				//private Lieferantentyp lieferanTyp
	
	
	public Lieferdaten(String lieferbareDienstleistungen, String lieferantenTyp) {
		super();
		this.lieferbareDienstleistungen = lieferbareDienstleistungen;
		this.lieferantenTyp = lieferantenTyp;
	}
	
	public Lieferdaten update (String lieferbareDienstleistungen, String lieferantenTyp) {
		this.lieferbareDienstleistungen = lieferbareDienstleistungen;
		this.lieferantenTyp = lieferantenTyp;
		return this;
	}
	@Override
	public String toString() {
		return "Lieferdaten [lieferbareDienstleistungen=" + lieferbareDienstleistungen + ", lieferantenTyp="
				+ lieferantenTyp + "]";
	}
	public String getLieferbareDienstleistungen() {
		return lieferbareDienstleistungen;
	}
	public void setLieferbareDienstleistungen(String lieferbareDienstleistungen) {
		this.lieferbareDienstleistungen = lieferbareDienstleistungen;
	}
	public String getLieferantenTyp() {
		return lieferantenTyp;
	}
	public void setLieferantenTyp(String lieferantenTyp) {
		this.lieferantenTyp = lieferantenTyp;
	}

}
