package Produkt;

import java.awt.TextField;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.Lieferant.Lieferant;

public class Produkt {
private int iD;
private String typ;
private String name;
private String hersteller;
private static final TextField [] Textfelder = {/*Textfelder Einf�gen*/};
private static Connection connection=null;


 public Produkt (String typ, String name, String hersteller) {
	this.typ = typ;
	this.name = name;
	this.hersteller= hersteller;
}


	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}

	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHersteller() {
		return hersteller;
	}

	public void setHersteller(String hersteller) {
		this.hersteller = hersteller;
	}

	@Override
	public String toString() {
		return "Produkt [iD=" + iD + ", typ=" + typ + ", name=" + name + ", hersteller=" + hersteller + "]";
	}
	
	public Produkt readOne(int iD) {
		//Ein Produkt aus der Datenbank einlesen und zur�ckgeben
		
		 		//Ein Produkt aus der DB abfragen
		 		try{
		 			Statement stmt = connection.createStatement(); 		
		 			ResultSet rs = stmt.executeQuery("SELECT * FROM PRODUKTE WHERE ID = '"+Integer.toString(iD)+"'");
		 		
		 			//eigentlich nur ein Ergebnis aber Fehler ohne "while"
		 			while(rs.next()){
		 			
		 			// 1 Produkt bauen
		 				String typ=rs.getString("TYP");
		 				String name=rs.getString("NAME");
		 				String hersteller=rs.getString("HERSTELLER");
		 				switch(typ){
		 				case "Prozessor":
		 		             Prozessor prozessor = new Prozessor(iD,typ,name,hersteller,rs.getString("STRING"));
		 		             return prozessor;
		 		             
		 				case "Operationssystem":
		 					Operationssystem operationssystem = new Operationssystem(iD,typ,name,hersteller,rs.getString("String"));
		 					return operationssystem;
		 					
		 				case "Netzwerkteil":
		 					Netzwerkteil netzwerkteil = new Netzwerkteil(iD,typ,name,hersteller,rs.getString("STRING"));
		 		             return netzwerkteil;
		 		             
		 				case "Motherboard":
		 					Motherboard motherboard = new Motherboard(iD,typ,name,hersteller,rs.getString("STRING"));
		 		             return motherboard;
		 		             
		 				case "Laufwerk":
		 					Laufwerk laufwerk = new Laufwerk(iD,typ,name,hersteller,rs.getString("STRING"));
		 		             return laufwerk;
		 		             
		 				case "Hauptspeicher":
		 					Hauptspeicher hauptspeicher = new Hauptspeicher(iD,typ,name,hersteller,rs.getString("STRING"));
		 		             return hauptspeicher;
		 		             
		 				case "Grafikkarte":
		 					Grafikkarte grafikkarte = new Grafikkarte(iD,typ,name,hersteller,rs.getString("STRING"));
		 		             return grafikkarte;
		 		             
		 				case "Festplatte":
		 					Festplatte festplatte = new Festplatte(iD,typ,name,hersteller,rs.getString("STRING"));
		 		             return festplatte;
		 		             
		 				case "Chassis":
		 					Chassis chassis = new Chassis(iD,typ,name,hersteller,rs.getString("STRING"));
		 		             return chassis;		 						 					
		 				}	
		 			}
		 			
		 			}catch(SQLException e) {
		 	 			// + Fehlermeldung ausgeben in einem Dialog auf FX "Datenbankabfrage Fehlgeschlagen" 	 			
		 	 			Alert alert=new Alert(AlertType.ERROR);
		 	 			alert.setTitle("Error Dialog: Lieferant.readOne()" );
		 	 			alert.setHeaderText("Folgender Fehler ist aufgetreten:");
		 	 			alert.setContentText("Datenbankabfrage fehlgeschlagen!"); 			
		 	 		
		 	 		/*}catch(Exception e) {  
		 	 			Alert alert=new Alert(AlertType.ERROR);
		 	 			alert.setTitle("Error Dialog: Lieferant.readOne()" );
		 	 			alert.setHeaderText("Folgender Fehler ist aufgetreten:");
		 	 			alert.setContentText("Konstruktion des Lieferantenobjekt fehlgeschlagen!");*/ 			
		 	 		} 		
				return null; 			 	
		 	
	}
	
	public ArrayList<Produkt> readAll(){
		//Alle Produkte aus der Datenbank einlesen und zur�ckgeben

		try {
			// Alle Produkte aus der Datenbank abfragen

			ArrayList<Produkt> alleProdukte = new ArrayList<Produkt>();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Produkte");
			while (rs.next()) {
				// 1 Produkt bauen
				String typ=rs.getString("TYP");
 				String name=rs.getString("NAME");
 				String hersteller=rs.getString("HERSTELLER");
 				switch(typ){
 				case "Prozessor":
 		             Prozessor prozessor = new Prozessor(iD,typ,name,hersteller,rs.getString("STRING"));
 		            alleProdukte.add(prozessor);
 		             
 				case "Operationssystem":
 					Operationssystem operationssystem = new Operationssystem(iD,typ,name,hersteller,rs.getString("String"));
 					alleProdukte.add(operationssystem);
 					
 				case "Netzwerkteil":
 					Netzwerkteil netzwerkteil = new Netzwerkteil(iD,typ,name,hersteller,rs.getString("STRING"));
 					alleProdukte.add(netzwerkteil);
 		             
 				case "Motherboard":
 					Motherboard motherboard = new Motherboard(iD,typ,name,hersteller,rs.getString("STRING"));
 					alleProdukte.add(motherboard); 		             
 				case "Laufwerk":
 					Laufwerk laufwerk = new Laufwerk(iD,typ,name,hersteller,rs.getString("STRING"));
 					alleProdukte.add(laufwerk); 		             
 				case "Hauptspeicher":
 					Hauptspeicher hauptspeicher = new Hauptspeicher(iD,typ,name,hersteller,rs.getString("STRING"));
 					alleProdukte.add(hauptspeicher); 		             
 				case "Grafikkarte":
 					Grafikkarte grafikkarte = new Grafikkarte(iD,typ,name,hersteller,rs.getString("STRING"));
 					alleProdukte.add(grafikkarte); 		             
 				case "Festplatte":
 					Festplatte festplatte = new Festplatte(iD,typ,name,hersteller,rs.getString("STRING"));
 					alleProdukte.add(festplatte); 		             
 				case "Chassis":
 					Chassis chassis = new Chassis(iD,typ,name,hersteller,rs.getString("STRING"));
 					alleProdukte.add(chassis); 					
 				}	
			}
			return alleProdukte;
		} catch (SQLException e) {
			// Fehlermeldung ausgeben in einem Dialog auf FX "Datenbankabfrage
			// Fehlgeschlagen"

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog: Lieferant.readAll()");
			alert.setHeaderText("Folgender Fehler ist aufgetreten:");
			alert.setContentText("Datenbankabfrage fehlgeschlagen!");

			/*
			 * }catch(Exception e) {
			 * 
			 * 
			 * Alert alert=new Alert(AlertType.ERROR);
			 * alert.setTitle("Error Dialog: Lieferant.readAll()" );
			 * alert.setHeaderText("Folgender Fehler ist aufgetreten:");
			 * alert.setContentText("Konstruktion der Lieferantenobjekte fehlgeschlagen!");
			 */
		}
		return null;
	}
	
	
	public void writeOne() {
		//Auf dem Layer ein Produkt darstellen
		System.out.println("Methode wurde nicht korrekt �berschrieben!");

		//leer, zum �berschreiben gedacht

			
	}
	
	public void writeAll(ArrayList<Produkt> produkte) {
		//Auf der Tabelle auf dem Layer alle Produkte darstellen
		//vlt zum �berschreiben gedacht ?
	}
	
	public void create() {
		//Ein Produkt in der DB speichern
		
		//uberprufenfen ob readOneLayer() Daten erheben konnte				
		if (!(this == null)) {
			//string f�r die Datenbank bauen
			String string =this.objectToString();		

					try {
						// Datenbank speichern
						Statement stmt = connection.createStatement();
						stmt.executeUpdate("INSERT INTO PRODUKTE (TYP, NAME, HERSTELLER, STRING)"
								+ " VALUES " + "('" + this.getTyp()+ "','"+this.getName()+ "';'"+this.getHersteller()+ "';'"+string+ "'");

					} catch (SQLException e) {
						// Meldung Lieferant speichern fehlgeschlagen
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Error Dialog: Lieferant.create()");
						alert.setHeaderText("Folgender Fehler ist aufgetreten:");
						alert.setContentText("Speichern in der Datenbank fehlgeschlagen!");
						return;
					}
					// Meldung Lieferant erfolgreich gespeichert
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Dialog: Lieferant.create()");
					alert.setHeaderText("Folgendes Ereignis ist eingetreten:");
					alert.setContentText("Lieferant erfolgreich gespeichert!");
				}
	}
	
	public void update(int iD) {
		//Einen bestimmtes bestehendes Produkt in der Datenbank durch neue Werte ersetzen
		
		// uberprufen ob readOneLayer() Daten erheben konnte
				if (!(this == null)) {
					//string f�r die Datenbank bauen
					String string =this.objectToString();

					try {
						// In der Datenbank speichern
						Statement stmt = connection.createStatement();

						stmt.executeUpdate("Update LIEFERANTEN Set TYP ='" + this.getTyp() + "',NAME='"+this.getName()
							+ "',HERSTELLER='"+this.getHersteller()+"',STRING='"+string+"' WHERE ID='" + iD + "'");
								
					} catch (SQLException e) {
						// Meldung Lieferant speichern fehlgeschlagen
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Error Dialog: Lieferant.create()");
						alert.setHeaderText("Folgender Fehler ist aufgetreten:");
						alert.setContentText("Speichern in der Datenbank fehlgeschlagen!");
						return;
					}
					// Meldung Lieferant erfolgreich gespeichert
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Dialog: Lieferant.create()");
					alert.setHeaderText("Folgendes Ereignis ist eingetreten:");
					alert.setContentText("Lieferant erfolgreich gespeichert!");
				}
	}
	
	public String objectToString() {
		System.out.println("Methode wurde nicht korrekt �berschrieben!");
		return null;
		//leer , zum �berschreiben gedacht
	}
	
	
	public Produkt readLayer() {
		System.out.println("Methode wurde nicht korrekt �berschrieben!");
		//leer , zum �berschreiben gedacht
		return null;
		
	}
}
