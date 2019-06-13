package model.Produktportfolio;

public class TableAngebot {
	int iD;String produktName ;String lieferantenName; double einzelpreis;int gultigkeitsdauer; 
	 
	 public TableAngebot(int iD,String produktName ,String lieferantenName, double einzelpreis,int gultigkeitsdauer ) {
		 this.iD = iD; this.lieferantenName = lieferantenName; this.einzelpreis = einzelpreis; this.gultigkeitsdauer = gultigkeitsdauer;} }