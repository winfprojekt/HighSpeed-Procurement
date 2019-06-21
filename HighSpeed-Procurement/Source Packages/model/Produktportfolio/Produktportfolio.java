

package model.Produktportfolio;
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

public class Produktportfolio {
	
	private int iD;
	private ArrayList <Angebot> angebote;
	private static Connection connection = util.DBUtil.getConnection();
	
	//Konstruktor
	public Produktportfolio(ArrayList<Angebot> angebote) {
		super();
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



	public static	ArrayList <Integer>	readAllID(){
		//Alle Produktportfolios aus der Datenbank einlesen und zur�ckgeben
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

			// zur Liste hinzuf�gen
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
			s = s +Integer.toString(angebot.getAngID())+";";
		}
		return s;
	}
		

	public	void	create() {
		//Ein Produktportfolio in der Datenbank speichern
		//achtung ObjectToString nutzen

			
			// �berpr�fen ob readLayer() Daten erheben konnte
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



