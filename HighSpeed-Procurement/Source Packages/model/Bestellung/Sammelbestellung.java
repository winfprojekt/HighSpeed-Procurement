package model.Bestellung;
import java.util.ArrayList;
//import java.util.Spliterator;

import javafx.scene.control.TableView;
import model.User;
import model.Lieferant.Lieferant;
import model.Produktportfolio.Angebot;

class Sammelbestellung {
	private ArrayList <Position> positionen;
	private User user;


	
	//Konstruktor
	public Sammelbestellung(ArrayList<Position> positionen, User user) {
		super();
		this.positionen = positionen;
		this.user= user;
	}
 
	//Getter + Setter
	public ArrayList<Position> getPositionen() {
		return positionen;
	}

	public void setPositionen(ArrayList<Position> positionen) {
		this.positionen = positionen;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	//zusatzliche Logik
	public ArrayList<Teilbestellung> split(){
		//Die Sammelbestellung in mehrere Teilbestellungen von jeweils nur einem Lieferant Teilen und als ArrayList zur�ckgeben	

		
		ArrayList<Teilbestellung> teilbestellungen = new ArrayList<Teilbestellung>();
		ArrayList<Lieferant>lieferanten= new ArrayList<Lieferant>();
		for(Position position : this.positionen) {
			
				boolean neuerLieferant = true;
				int arrayCount;
				//if (lieferanten != null) {
					for(Lieferant lieferant :lieferanten) {
						arrayCount = -1;
						int i =0;
						if (position.getAngebot().getLieferant() == lieferant) {
							neuerLieferant = false;
							arrayCount= i;
						}
						i++;
						if(neuerLieferant && arrayCount==-1) {
							ArrayList<Position> neuePositionen = new ArrayList<Position>();
							neuePositionen.add(position);
							lieferanten.add(position.getAngebot().getLieferant());
							Teilbestellung teilbestellung = new Teilbestellung(this.getUser(),position.getAngebot().getLieferant(),neuePositionen);
							teilbestellungen.add(teilbestellung);
						}
						else{
							teilbestellungen.get(arrayCount).getPositionen().add(position);		
						}
					}
		}					
		
		return teilbestellungen;
		
	}
	
	public static Sammelbestellung readLayer(int activeUserID,TableView<TablePosition> bestellungTable) {
		//Aus dem Layer eine Sammelbestellung einlesen und zuruckgeben
		ArrayList <Position> positionen = new ArrayList<Position>();
	
		bestellungTable.getItems().forEach(tablePosition ->{
			positionen.add(new Position(Angebot.readOne(tablePosition.angebotID)
					,tablePosition.menge));} );
		Sammelbestellung sammelbestellung = new Sammelbestellung(positionen,User.readOne(activeUserID));
		return sammelbestellung;
	
	}
	
	/* Tims Version 
	 
	 
	 public ArrayList<ArrayList<Teilbestellung>> split(){
		
		ArrayList<ArrayList<Teilbestellung>> teilbestellungen = new ArrayList <ArrayList<Teilbestellung>>();
		teilbestellungen.add((ArrayList<Teilbestellung>) lieferant.spliterator());
		
		for(int i=lieferant.getiD();i<positionen.size();i++) {
			if (i!=i+1) {
				teilbestellungen.add((ArrayList<Teilbestellung>) lieferant.spliterator());
				
				
			}
			else {
				i++;
			}
			
			
			
		}
		
		
		//Die Sammelbestellung in mehrere Teilbestellungen von jeweils nur einem Lieferant Teilen und als ArrayList zurï¿½ckgeben	
		
		return teilbestellungen;
		
	}
	
	public Sammelbestellung readLayer() {
		ArrayList <Sammelbestellung> sammelbestellung= new ArrayList <Sammelbestellung>();
		for (int i=0; i<bestellungTable.getItems().size();i++) {
			Position position= bestellungTable.getItems().get(i);
			sammelbestellung.addAll(new ArrayList<>());
			sammelbestellung.get(i).add(position.Lieferantenname.get());
			sammelbestellung.get(i).add(position.LieferantenID.get());
			sammelbestellung.get(i).add(position.AngebotID.get());
			sammelbestellung.get(i).add(position.Produktname.get());
			sammelbestellung.get(i).add(position.ProduktID.get());
			sammelbestellung.get(i).add(position.Einzelpreis.get());
			sammelbestellung.get(i).add(position.Menge.get());
			
			//einzelne positionen werden in sammelbestellung arraylist gespeichert
			// richtige Spaltennamen müssen noch angegeben werden, wenn oberfläche fertig ist
			
			for (int a=0; a<sammelbestellung.size();i++) {
				for (int j=0; j<sammelbestellung.get(a).size();j++) {
					System.out.println(sammelbestellung.get(a).get(j));
				}
			}
			//dient nur zur ausgabe
		}
		
		
		return null;
		//Aus dem Layer eine Sammelbestellung einlesen und zuruckgeben
	}
	private int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	private char[] get(int j) {
		// TODO Auto-generated method stub
		return null;
	}
	
	// + in Teilbestellung
	 /* public Spliterator<Teilbestellung> spliterator() {
		// TODO Auto-generated method stub
		//Methode für split von sammelbestellung in teilbestellungen 
		return null;
	}
	
	 */
	

}
