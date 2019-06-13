

package model.Produktortfolio;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;

class Produktportfolio {
	
	private int iD;
	private ArrayList <Angebot> angebote;
	private static Connection connection = util.DBUtil.getConnection();
	
	//Konstruktor
	public Produktportfolio(ArrayList<Angebot> angebote) {
		super();
		this.angebote = angebote;
	}
	
	//Konstruktor mit string aus DB
		public Produktportfolio(int iD, String s) {
			super();
			this.iD = iD;
			ArrayList <Angebot> angebote = new ArrayList<Angebot>();
			String [] parts =s.split(";");
			for (int i=0 ;i<parts.length;i++) {
				angebote.add(Angebot.readOne(Integer.parseInt(parts[i])));
			}
			
			this.angebote = angebote;
		}
	
	//Getter + Setter
	public int getiD() {
		return iD;
	}
	public void setiD(int iD) {
		this.iD = iD;
	}
	public ArrayList<Angebot> getAngebote() {
		return angebote;
	}
	public void setAngebote(ArrayList<Angebot> angebote) {
		this.angebote = angebote;
	}


	public static Produktportfolio readLayer(TableView<TableAngebot> tableProduktportfolio ) {
		//Aus dem Layer ein Produktportfolio einlesen und zurückgeben	
		ArrayList <Angebot> angebote = new ArrayList<Angebot>();
		tableProduktportfolio.getItems().forEach(tableAngebot ->{angebote.add(Angebot.readOne(tableAngebot.iD));} );
		Produktportfolio produktportfolio = new Produktportfolio(angebote);
		return produktportfolio;
	}
	public static	ArrayList <Integer>	readAllID(){
		//Alle Produktportfolios aus der Datenbank einlesen und zurückgeben
		try {
			ArrayList<Integer> ppIDs = new ArrayList<Integer>();	
			
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT ID FROM ANGEBOTE");
			
			while (rs.next()) {
				ppIDs.add(Integer.parseInt(rs.getString("ID")));
			}
			
			return ppIDs;
		} catch (SQLException e) {
			// Fehlermeldung ausgeben in einem Dialog auf FX "Datenbankabfrage
			// Fehlgeschlagen"

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog: Produktportfolio.readAll()");
			alert.setHeaderText("Folgender Fehler ist aufgetreten:");
			alert.setContentText("Datenbankabfrage fehlgeschlagen!");

			/*
			 * }catch(Exception e) {
			 * 
			 * 
			 * Alert alert=new Alert(AlertType.ERROR);
			 * alert.setTitle("Error Dialog: Produktportfolio.readAll()" );
			 * alert.setHeaderText("Folgender Fehler ist aufgetreten:");
			 * alert.setContentText("Konstruktion der Lieferantenobjekte fehlgeschlagen!");
			 */
		}
		return null;
	}
	public static	void	writeAllNames(ArrayList <Integer> produktportfolioIDs,TableView<String> tableChoosePP) {
		//Auf der Tabelle auf dem Layer alle Produkte darstellen
		ObservableList<String> tabelleninhalt = FXCollections.observableArrayList();

		for (int ppID : produktportfolioIDs) {

			// zur Liste hinzufï¿½gen
			tabelleninhalt.add(Produktportfolio.name(ppID));

		}

		// Daten in der Tabelle Anzeigen
		tableChoosePP.setItems(tabelleninhalt);
	
	}
	public static	String	name(int ppID) {
		//Aus der ID eines Produktportfolios einen Namen bilden	
		return "Produktportfolio v"+Integer.toString(ppID);
	}
	public	String	objectToString() {
		//Aus den Angebot.iDs einen String bauen der zum Speichern in der Datenbank notwendig ist	

		String s="";
		for(Angebot angebot : this.angebote) {
			s = s +Integer.toString(angebot.getiD())+";";
		}
		return s;
	}
		
	public static	Produktportfolio	readOne(int ppID) {
		//Ein Produktportfolio aus der Datenbank einlesen und zurückgeben
		//achtung StringToObject nutzen
		
		try {
			// Produktportfolio aus der Datenbank abfragen	

			
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT STRING FROM PPRODUKTPORTFOLIOS WHERE ID ='"+Integer.toString(ppID)+"'");
			while (rs.next()) {
				
				// 1 PP bauen
			
				Produktportfolio produktportfolio = new Produktportfolio(ppID,rs.getString("STRING"));
				// ArayList mit PP beschreiben				
				return produktportfolio;
				
			}
			
		} catch (SQLException e) {
			// Fehlermeldung ausgeben in einem Dialog auf FX "Datenbankabfrage
			// Fehlgeschlagen"

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog: Produktportfolio.readOne()");
			alert.setHeaderText("Folgender Fehler ist aufgetreten:");
			alert.setContentText("Datenbankabfrage fehlgeschlagen!");

			/*
			 * }catch(Exception e) {
			 * 
			 * 
			 * Alert alert=new Alert(AlertType.ERROR);
			 * alert.setTitle("Error Dialog: Produktportfolio.readOne()" );
			 * alert.setHeaderText("Folgender Fehler ist aufgetreten:");
			 * alert.setContentText("Konstruktion der Lieferantenobjekte fehlgeschlagen!");
			 */
		}
		return null;

	}
	public	void	create() {
		//Ein Produktportfolio in der Datenbank speichern
		//achtung ObjectToString nutzen

			
			// ï¿½berprï¿½fen ob readLayer() Daten erheben konnte
					if (!(this == null)) {

						try {
							// Datenbank speichern
							Statement stmt = connection.createStatement();
							stmt.executeUpdate("INSERT INTO PRODUKTPORTFOLIOS (STRING) VALUES " + "('"
								+ this.objectToString()	+  "')");

						} catch (SQLException e) {
							// Meldung Lieferant speichern fehlgeschlagen
							Alert alert = new Alert(AlertType.ERROR);
							alert.setTitle("Error Dialog: Angebot.create()");
							alert.setHeaderText("Folgender Fehler ist aufgetreten:");
							alert.setContentText("Speichern in der Datenbank fehlgeschlagen!");
							return;
						}
						// Meldung Lieferant erfolgreich gespeichert
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Information Dialog: Angebot.create()");
						alert.setHeaderText("Folgendes Ereignis ist eingetreten:");
						alert.setContentText("Angebot erfolgreich gespeichert!");
					}
	}
	public void writeAngebote() {
		
	}
}



