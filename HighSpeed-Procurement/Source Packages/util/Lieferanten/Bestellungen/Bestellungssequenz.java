import java.util.ArrayList;
package util;

class Bestellungssequenz extends Bestellung{
	
	private int iD; // Bsp: 5.5?

	//Konstruktor
	public Bestellungssequenz(ArrayList<Position> produktportfolio, int iD) {
		super(produktportfolio); // auto generated ? aber wieso produktportfolio?
		this.iD = iD;
	}

	//Getter + Setter
	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}
	
}
