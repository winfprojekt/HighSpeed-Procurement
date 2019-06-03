/*package model.Bestellung;
import Lieferant.Kontaktdaten.email;
import Teilbestellung.iD;

class Mail {
	private String Text;
	private model.Bestellung.iD bestellungsID;
	private User.email absender;
	private Lieferant.Kontaktdaten.email empf�nger;
	
	//Konstruktor
	public Mail(String text, iD bestellungsID, email empf�nger) {
		super();
		Text = text;
		this.bestellungsID = bestellungsID;
		this.empf�nger = empf�nger;
	}
	
	//Getter+Setter
	public String getText() {
		return Text;
	}
	public void setText(String text) {
		Text = text;
	}
	public model.Bestellung.iD getBestellungsID() {
		return bestellungsID;
	}
	public void setBestellungsID(Teilbestellung.iD bestellungsID) {
		this.bestellungsID = bestellungsID;
	}
	public User.email getAbsender() {
		return absender;
	}
	public void setAbsender(User.email absender) {
		this.absender = absender;
	}
	public Lieferant.Kontaktdaten.email getEmpf�nger() {
		return empf�nger;
	}
	public void setEmpf�nger(Lieferant.Kontaktdaten.email empf�nger) {
		this.empf�nger = empf�nger;
	}
	
	//zus�tzliche Logik
	
	public void write () {
		//Den Email String in einer daf�r vorhergesehenen Box ausgeben
	}
	
	public Mail readUpdated() {
		//Den �berarbeiteten String wieder einlesen
	}
	
	public void send() {
		//Die Mail versenden
	}

}



*/