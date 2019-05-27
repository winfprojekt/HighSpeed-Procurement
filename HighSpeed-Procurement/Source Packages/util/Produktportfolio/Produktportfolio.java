package util;
import java.util.ArrayList;

class Produktportfolio {
	
	private int iD;
	private ArrayList <Angebot> produktportfolio;
	
	
	
	//Konstruktor
	public Produktportfolio(ArrayList<Angebot> produktportfolio) {
		super();
		this.produktportfolio = produktportfolio;
	}
	
	//Getter + Setter
	public int getiD() {
		return iD;
	}
	public void setiD(int iD) {
		this.iD = iD;
	}
	public ArrayList<Angebot> getProduktportfolio() {
		return produktportfolio;
	}
	public void setProduktportfolio(ArrayList<Angebot> produktportfolio) {
		this.produktportfolio = produktportfolio;
	}
	
	//toString
	
}
