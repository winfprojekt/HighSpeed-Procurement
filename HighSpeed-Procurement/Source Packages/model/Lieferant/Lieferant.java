package model.Lieferant;

/**
 * @author Gruppe 2
 * 
 *
 */
package model.Lieferant;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;

import javafx.scene.control.TableView;
import javafx.scene.control.TextField;



//Innere Klasse für TableLieferant Objekte, da nicht alle Daten angezeigt werden sollen
public class Lieferant {
	class TableLieferant{String name;String stadt;String land;String typ;
		public TableLieferant(String name, String stadt, String land, String typ) {
			this.name = name;this.stadt = stadt;this.land = land;this.typ = typ;		
		}}

	private int iD;
	private Adresse adresse;
	private Kontaktdaten kontaktdaten;
	private Bankdaten bankdaten;
	private String typ;
	private static final TextField [] Textfelder=null;// = {LieferantController.textfieldName,textfieldAddr,textfieldStadt,textFieldPLZ,
			//textfieldMail,textfieldTelnum,textfieldBank,textfieldIBAN,textfieldSWIFT,textfieldSteuer};
	private static final ChoiceBox<String> [] Choiceboxen=null;;// = {choiceboxLand,choiceboxLTyp};
	private static Connection connection=null;
	private static final TableView<TableLieferant> table=null;
	
	//Konstruktor
	public Lieferant(Adresse adresse, Kontaktdaten kontaktdaten,Bankdaten bankdaten, String typ) {
		this.adresse=adresse;
		this.kontaktdaten=kontaktdaten;
		this.bankdaten=bankdaten;
		this.typ=typ;
	}
	
	//Konstruktor mit iD
		public Lieferant(int iD ,Adresse adresse, Kontaktdaten kontaktdaten,Bankdaten bankdaten, String typ) {
			this.iD=iD;
			this.adresse=adresse;
			this.kontaktdaten=kontaktdaten;
			this.bankdaten=bankdaten;
			this.typ=typ;
		}
	
	
	//Getter,Setter
	public int getID() {
		return iD;
	}
	
	public void setID(int iD) {
		this.iD=iD;
	}
		
	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
		
	}
	
	public Kontaktdaten getKontaktdaten() {
		return kontaktdaten;
	}

	public void setKontaktdaten(Kontaktdaten kontaktdaten) {
		this.kontaktdaten=kontaktdaten;
		
	}
	
	public Bankdaten getBankdaten() {
		return bankdaten;
	}
	
	
	public void setBankdaten(Bankdaten bankdaten) {
		this.bankdaten=bankdaten;
	}

	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}



	// Lieferanten-Funktionen


 	public ArrayList<Lieferant> readAll() {
	//Alle Lieferanten aus der Datenbank auslesen
 		
 		try {
 		//Alle Lieferanten aus der Datenbank abfragen

 		ArrayList<Lieferant> alleLieferanten = new ArrayList<Lieferant>();
 		Statement stmt = connection.createStatement();
 		ResultSet rs = stmt.executeQuery("SELECT * FROM LIEFERANTEN");
 		while (rs.next()) {
 			// 1 Lieferant bauen
 			Adresse adresse = new Adresse(rs.getString("NAME"), rs.getString("STRASSEUNDNUMMER"), rs.getString("STADT"),
 					Integer.parseInt(rs.getString("PLZ")), rs.getString("LAND"));
 			Kontaktdaten kontaktdaten= new Kontaktdaten(rs.getString("EMAIL"), Integer.parseInt(rs.getString("TELEFONNUMMER")));
 			Bankdaten bankdaten = new Bankdaten(rs.getString("BANK"), rs.getString("IBAN"), rs.getString("BICSWIFT"), rs.getString("STEUERNUMMER"));
 			Lieferant lieferant = new Lieferant(Integer.parseInt(rs.getString("ID")),adresse,kontaktdaten,bankdaten, rs.getString("TYP"));
 			
 			// ArayList mit Lieferant beschreiben
 			alleLieferanten.add(lieferant);	
 		}
 		return alleLieferanten;
 		}catch(SQLException e) {
 		// Fehlermeldung ausgeben in einem Dialog auf FX "Datenbankabfrage Fehlgeschlagen"
 			
 			Alert alert=new Alert(AlertType.ERROR);
 			alert.setTitle("Error Dialog: Lieferant.readAll()" );
 			alert.setHeaderText("Folgender Fehler ist aufgetreten:");
 			alert.setContentText("Datenbankabfrage fehlgeschlagen!"); 			
 		
 		/*}catch(Exception e) {
 			
 			
 			Alert alert=new Alert(AlertType.ERROR);
 			alert.setTitle("Error Dialog: Lieferant.readAll()" );
 			alert.setHeaderText("Folgender Fehler ist aufgetreten:");
 			alert.setContentText("Konstruktion der Lieferantenobjekte fehlgeschlagen!");*/ 			
 		}
 		return null;
 	}

 	public Lieferant readOne(int iD) {
 	//Einen Lieferant aus der Datenbank auslesen
 		
 		//Einen Lieferant aus der DB abfragen
 		try{
 			Statement stmt = connection.createStatement(); 		
 			ResultSet rs = stmt.executeQuery("SELECT * FROM LIEFERANTEN WHERE ID = '"+Integer.toString(iD)+"'");
 		
 			//eigentlich nur ein Ergebnis aber Fehler ohne "while"
 			while(rs.next()){
 			
 			// 1 Lieferant bauen
 				Adresse adresse = new Adresse(rs.getString("NAME"), rs.getString("STRASSEUNDNUMMER"), rs.getString("STADT"),
 						Integer.parseInt(rs.getString("PLZ")), rs.getString("LAND"));
 				Kontaktdaten kontaktdaten = new Kontaktdaten(rs.getString("EMAIL"), Integer.parseInt(rs.getString("TELEFONNUMMER")));
 				Bankdaten bankdaten = new Bankdaten(rs.getString("BANK"), rs.getString("IBAN"), rs.getString("BICSWIFT"), rs.getString("STEUERNUMMER"));
 				Lieferant lieferant = new Lieferant(Integer.parseInt(rs.getString("ID")),adresse,kontaktdaten,bankdaten, rs.getString("TYP"));
 		
 				return lieferant;
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
 	
 	private void grammatik(){
 		//Genaue Überprüfung Bei genug zeit implementieren
 		//Genaue exceptions werfen die einen Fehlertext enthalten (je nach Fehler und Feld)
 	}
 			
 	
 	public Lieferant readOneLayer(){
 	//vom Layer 1 Lieferant einlesen	

 		//Aktivieren wenn grammatik() implementiert ist
 		/*try { 	
 		grammatik();
 		}
 		catch(Exception e) {
 			// + Genaue Fehlermeldung von e ausgeben in einem Dialog auf FX
 			Alert alert=new Alert(AlertType.ERROR);
	 		alert.setTitle("Error Dialog: Lieferant.readOneLayer()" );
	 		alert.setHeaderText("Folgender Fehler ist aufgetreten:");
	 		alert.setContentText(e.toString());
	 		return null;
 		}*/
 		
 		//Felder casten und Objekte bauen
 		try {
 			Adresse adresse = new Adresse(Textfelder[0].getText(),Textfelder[1].getText(),Textfelder[2].getText(),
 					Integer.parseInt(Textfelder[3].getText()),(String) Choiceboxen[0].getSelectionModel().getSelectedItem());
 			
 			Kontaktdaten kontaktdaten = new	Kontaktdaten(Textfelder[4].getText(),Integer.parseInt(Textfelder[5].getText()));
 			Bankdaten bankdaten = new Bankdaten(Textfelder[6].getText(),Textfelder[7].getText(),Textfelder[8].getText(),
 					Textfelder[9].getText());
 			
 			String typ = (String) Choiceboxen[1].getSelectionModel().getSelectedItem();
 			Lieferant lieferant = new Lieferant(adresse,kontaktdaten,bankdaten,typ);
		
		return lieferant;
		}
 		catch(Exception e){
 			//Generelle Fehlermeldung "Falscher Datentyp!" in einem Dialog auf FX
 			Alert alert=new Alert(AlertType.ERROR);
	 		alert.setTitle("Error Dialog: Lieferant.readOneLayer()" );
	 		alert.setHeaderText("Folgender Fehler ist aufgetreten:");
	 		alert.setContentText("Falscher Datentyp! Bitte überprüfen sie ihre Eingaben!"); 
 		
 		}
 		return null;
 	}

 	
 	public void writeAll(ArrayList<Lieferant>alleLieferanten){
 	//Alle Lieferanten auf Layer ausgeben 	
 		
 		//Tabellengröße an Arraylänge anpassen?
 		
 		
 		
 	
 		ObservableList<TableLieferant> tabelleninhalt = FXCollections.observableArrayList();
 	
 		for(Lieferant lieferant:alleLieferanten) {
 			//neues TableLieferant Objekt bauen
 			TableLieferant tableLieferant= new TableLieferant(lieferant.getAdresse().getName(),
 					lieferant.getAdresse().getStadt(),lieferant.getAdresse().getLand(),lieferant.getTyp());
 			
 			//zur Liste hinzufügen
 			tabelleninhalt.add(tableLieferant);

 		} 
 	
 		// Daten in der Tabelle Anzeigen
 		table.setItems(tabelleninhalt);
 	}

 
 	public void writeOne() {
 		//einen Lieferant auf einem Layer ausgeben
 		
 		//Felder mit Lieferantendaten beschreiben
 		Textfelder[0].setText(this.getAdresse().getName());
 		Textfelder[1].setText(this.getAdresse().getStrasseUndNummer());
 		Textfelder[2].setText(this.getAdresse().getStadt());
 		Textfelder[3].setText(Integer.toString(this.getAdresse().getPostleitzahl()));

 		Textfelder[4].setText(this.getKontaktdaten().getEmail());
 		Textfelder[5].setText(Integer.toString(this.getKontaktdaten().getTelefonnummer()));

 		Textfelder[6].setText(this.getBankdaten().getBank());
 		Textfelder[7].setText(this.getBankdaten().getiBAN());
 		Textfelder[8].setText(this.getBankdaten().getBicSwift());
 		Textfelder[9].setText(this.getBankdaten().getSteuernummer());

 		Choiceboxen[0].getSelectionModel().select(this.getAdresse().getLand());
	
 		Choiceboxen[1].getSelectionModel().select(this.getTyp());
	}
 	
 	
 	public void create(){
 	//einen Lieferant in der Datenbank erstellen
 		
 		//Überprüfen ob readOneLayer() Daten erheben konnte
 		if(!(this==null)){
 			
 			try {
 				//Datenbank speichern
 				Statement stmt = connection.createStatement();
 				stmt.executeUpdate("INSERT INTO LIEFERANTEN (TYP, NAME, STRASSEUNDNUMMER, STADT,"
 						+ "PLZ, LAND, BANK, IBAN, BICSWIFT, STEUERNR, EMAIL, TELEFONNR ) VALUES "+"('" 
 						+ this.getTyp()+"','"+ this.getAdresse().getName()+"','"
 						+ this.getAdresse().getStrasseUndNummer()+"','"+this.getAdresse().getStadt()+"','"
 						+ Integer.toString(this.getAdresse().getPostleitzahl())+ "','"+this.getAdresse().getLand()+"','"
 						+ this.getBankdaten().getBank()+"','"+this.getBankdaten().getiBAN()+"','"
 						+ this.getBankdaten().getBicSwift()+"','"+this.getBankdaten().getSteuernummer()+"','"
 						+ this.getKontaktdaten().getEmail()+"','"+this.getKontaktdaten().getEmail()+"')");
 				
 			}catch(SQLException e) { 				
 				//Meldung Lieferant speichern fehlgeschlagen
 				Alert alert=new Alert(AlertType.ERROR);
 		 		alert.setTitle("Error Dialog: Lieferant.create()" );
 		 		alert.setHeaderText("Folgender Fehler ist aufgetreten:");
 		 		alert.setContentText("Speichern in der Datenbank fehlgeschlagen!");
 		 		return;
 			}
 			//Meldung Lieferant erfolgreich gespeichert
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Dialog: Lieferant.create()" );
				alert.setHeaderText("Folgendes Ereignis ist eingetreten:");
				alert.setContentText("Lieferant erfolgreich gespeichert!");
 		}		
 	}



	public void update(int iD ) {
		// einen Lieferant in der Datenbank andern

		//Überprüfen ob readOneLayer() Daten erheben konnte
 		if(!(this==null)){
 			
 			try {
 				//In der Datenbank speichern
 				Statement stmt = connection.createStatement();
 			
 				stmt.executeUpdate("Update LIEFERANTEN Set TYP ='"+ this.getTyp()+"',NAME='"+ this.getAdresse().getName()+"',STRASSEUNDNUMMER='"
 						+ this.getAdresse().getStrasseUndNummer()+"',STADT='"+this.getAdresse().getStadt()+"',PLZ='"
 						+ Integer.toString(this.getAdresse().getPostleitzahl())+ "',LAND='"+this.getAdresse().getLand()+"',BANK='"
 						+ this.getBankdaten().getBank()+"',IBAN='"+this.getBankdaten().getiBAN()+"',BICSWIFT='"
 						+ this.getBankdaten().getBicSwift()+"',STEUERNR='"+this.getBankdaten().getSteuernummer()+"',EMAIL='"
 						+ this.getKontaktdaten().getEmail()+"',TELEFONNR='"+this.getKontaktdaten().getEmail() 				
 						
 						+"' WHERE ID='"+iD+"'");
 				
 			}catch(SQLException e) { 				
 				//Meldung Lieferant speichern fehlgeschlagen
 				Alert alert=new Alert(AlertType.ERROR);
 		 		alert.setTitle("Error Dialog: Lieferant.create()" );
 		 		alert.setHeaderText("Folgender Fehler ist aufgetreten:");
 		 		alert.setContentText("Speichern in der Datenbank fehlgeschlagen!");
 		 		return;
 			}
 			//Meldung Lieferant erfolgreich gespeichert
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Dialog: Lieferant.create()" );
				alert.setHeaderText("Folgendes Ereignis ist eingetreten:");
				alert.setContentText("Lieferant erfolgreich gespeichert!");
 		} 		
	}
}





//kleine Test klasse
/*public class Lieferant {

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}
	public Integer getID() {
		return id;
	}
	public void setID(Integer id) {
		this.id=id;
	}

	private  String name;
	private  String adresse;
	private  String typ;
	private  Integer id;

	public Lieferant(Integer id, String name, String adresse, String typ) {
		this.id=id;
		this.name = name;
		this.adresse = adresse;
		this.typ = typ;

	}


}/*

