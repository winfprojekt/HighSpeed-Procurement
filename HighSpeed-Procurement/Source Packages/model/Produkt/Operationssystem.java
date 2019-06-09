package Produkt;

public class Operationssystem extends Produkt {
	
	private int erscheinungsJahr;

	public Operationssystem(String typ, String name, String hersteller, int erscheinungsJahr) {
		super(typ, name, hersteller);
		this.erscheinungsJahr = erscheinungsJahr;
				
		
	}

	public Operationssystem(int iD, String typ, String name, String hersteller, String string) {
		super(typ, name, hersteller);
		this.erscheinungsJahr=Integer.parseInt(string);
		//parts einfügen wenn Variablen deklariert sind + public String objectToString() implementieren
	}
	
	//getter+ Setter	
	public int getErscheinungsJahr() {
		return erscheinungsJahr;
	}

	public void setErscheinungsJahr(int erscheinungsJahr) {
		this.erscheinungsJahr = erscheinungsJahr;
	}
	
	//zusätliche Logik
	
			public String objectToString() {
				// Produktfremde variablen des Objekts in einem Sring zusammenfassen
				return Integer.toString(this.erscheinungsJahr);
			}

}
