package model.Bestellung;
import java.util.ArrayList;
import model.Mail.*;
import model.User;
import model.Lieferant.Lieferant;


class Teilbestellung {
	
	private int iD;
	private User user;
	private Lieferant lieferant;
	private ArrayList <Position> positionen;


	//Konstruktor
	public Teilbestellung(int userID, Lieferant lieferant, ArrayList<Position> positionen) {
		super();
		this.user = user;
		this.lieferant = lieferant;
		this.positionen = positionen;
	}

	//Getter + Setter
	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(int userID) {
		this.user = user;
	}

	public Lieferant getLieferant() {
		return lieferant;
	}

	public void setLieferant(Lieferant lieferant) {
		this.lieferant = lieferant;
	}

	public ArrayList<Position> getPositionen() {
		return positionen;
	}

	public void setPositionen(ArrayList<Position> positionen) {
		this.positionen = positionen;
	}

	//zus�tzliche Logik
	public ArrayList<Teilbestellung> readAll(){
		return null;
		//Alle Teilbestellungen aus der Datenbank einlesen und zur�ckgeben
	}
	
	public void writeAll(ArrayList<Teilbestellung> teilbestellungen) {
		//Auf der Tabelle auf dem Layer alle Teilbestellungen darstellen
	}
	
	public void create() {
		//Eine Teilbestellung in der Datenbank speichern
	}
	
	public String objectToString() {
		return null;
		//Aus den Angebot.iDs und Mengen einen String bauen der zum Speichern in der Datenbank notwendig ist
	}
	
	public Teilbestellung stringToObject(String string) {
		return null;
		//Aus dem String ein Produktportfolio bef�llen (Gegenteil zu objectToString)
	}
	
	//Änderungen von Boris ab hier:
	
	public String toText() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("Sehr geehrte Damen und Herren,\n\n");
		sb.append("Wir haben eine neue Bestellung f??ie erstellt.\n\n");
		sb.append("Bestellungsnummer: ");
		sb.append(this.iD);
		sb.append("\n");
		for(int i = 0; i<this.positionen.size(); i++) {
			sb.append("Einzelteil: ");
			sb.append(this.positionen.get(i).getAngebot().getProdukt().getName());
			sb.append("\n");
			sb.append("Teilennummer: ");
			sb.append(this.positionen.get(i).getAngebot().getProdukt().getIdent());
			sb.append("\n");
			sb.append("Menge: ");
			sb.append(this.positionen.get(i).getMenge());
			sb.append("\n");
		}
		sb.append("Mit freundlichen Gr??\n");
		sb.append(this.user.getUser());
		sb.append("\n\n");
		sb.append("HighSpeedProcurement");
		String toBeMailed = sb.toString();
		return toBeMailed;
	}
	
	public MailService objectToMail() {
		
		String TextBody = this.toText();
		
		MailService newMail = new MailService(TextBody, this.iD, this.lieferant.getKontaktdaten().getEmail());
	
	return newMail;
	}
	
}
