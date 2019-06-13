package model.Bestellung;


class Mail {
	private String Text; //Inhalt
	private int bestellungsID;
	private String absender; //Mail adresse
	private String empfanger; //Mail adresse
	
	//Konstruktor
	public Mail(String text, int bestellungsID,String absender, String empfanger) {
		super();
		Text = text;
		this.bestellungsID = bestellungsID;
		this.empfanger = empfanger;
		this.absender=absender;
	}
	
	//Getter+Setter
	public String getText() {
		return Text;
	}
	public void setText(String text) {
		Text = text;
	}
	public int getBestellungsID() {
		return bestellungsID;
	}
	public void setBestellungsID(int bestellungsID) {
		this.bestellungsID = bestellungsID;
	}
	public String getAbsender() {
		return absender;
	}
	public void setAbsender(String absender) {
		this.absender = absender;
	}
	public String getEmpfanger() {
		return empfanger;
	}
	public void setEmpfanger(String empfanger) {
		this.empfanger = empfanger;
	}
	
	//zus�tzliche Logik
	
	public void write () {
		//Den Email String in einer daf�r vorhergesehenen Box ausgeben
	}
	
	public String readUpdated() {
		return null;
		//Den �berarbeiteten String wieder einlesen
	}
	
	public void send() {
		//Die Mail versenden
	}

}

