import java.util.ArrayList;
package util;

class Bestellung {
	// iD ?
	private ArrayList <Position> produktportfolio;
	
	//Konstruktor
	public Bestellung(ArrayList<Position> produktportfolio) {
		super();
		this.produktportfolio = produktportfolio;
	}
 
	//Getter + Setter
	public ArrayList<Position> getProduktportfolio() {
		return produktportfolio;
	}

	public void setProduktportfolio(ArrayList<Position> produktportfolio) {
		this.produktportfolio = produktportfolio;
	}
	
	


}
