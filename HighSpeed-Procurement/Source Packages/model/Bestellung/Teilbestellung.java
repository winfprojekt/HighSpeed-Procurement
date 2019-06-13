package model.Bestellung;
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


class Teilbestellung {
	
	private int iD;
	private User user;
	private Lieferant lieferant;
	private ArrayList <Position> positionen;
	private String status;
	
	private static Connection connection = util.DBUtil.getConnection();




	//Konstruktor
	public Teilbestellung(int iD, User user, Lieferant lieferant, ArrayList<Position> positionen, String status) {
		super();
		this.iD=iD;
		this.user = user;
		this.lieferant = lieferant;
		this.positionen = positionen;
		this.status = status;
	}
	//Konstruktor ohne ID
	
	public Teilbestellung(User user, Lieferant lieferant, ArrayList<Position> positionen) {
		super();
		this.user = user;
		this.lieferant = lieferant;
		this.positionen = positionen;
		this.status = "in Bearbeitung";
	}
	
	//Konstruktor mit String für DB
	public Teilbestellung(int iD, User user, Lieferant lieferant, String status, String string) {
		super();
		this.iD = iD;
		this.user = user;
		this.lieferant = lieferant;
		this.status = status;
		ArrayList <Position> positionen=new ArrayList<Position>();
		String [] parts =string.split(";");
		for (int i=0 ;i<parts.length;i++) {
			String[] parts2 =parts[i].split("/");
			positionen.add(new Position(Angebot.readOne(Integer.parseInt(parts2[0])),Integer.parseInt(parts2[1])));
		}

		this.positionen=positionen;
	}

	//Getter + Setter
	public int getiD() {
		return iD;
	}

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
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

	//zusï¿½tzliche Logik
	public static ArrayList<Teilbestellung> readAll(){
		//Alle Teilbestellungen aus der Datenbank einlesen und zurï¿½ckgeben
	

		try {
			// Alle Teilbestellungen aus der Datenbank abfragen

			ArrayList<Teilbestellung> alleTeilbestellungen = new ArrayList<Teilbestellung>();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM TEILBESTELLUNGEN");
			while (rs.next()) {
				//1 Teilbestellung bauen
				int iD = Integer.parseInt(rs.getString("ID"));
				User user = User.readOne(Integer.parseInt(rs.getString("USER")));
				Lieferant lieferant = Lieferant.readOne(Integer.parseInt(rs.getString("LIEFERANT")));
				String status = rs.getString("STATUS");
				Teilbestellung teilbestellung = new Teilbestellung(iD,user,lieferant,status,null);
				alleTeilbestellungen.add(teilbestellung);
				 
			}
			return alleTeilbestellungen;
		} catch (SQLException e) {
			// Fehlermeldung ausgeben in einem Dialog auf FX "Datenbankabfrage
			// Fehlgeschlagen"

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog: Teilbestellung.readAll()");
			alert.setHeaderText("Folgender Fehler ist aufgetreten:");
			alert.setContentText("Datenbankabfrage fehlgeschlagen!");

			/*
			 * }catch(Exception e) {
			 * 
			 * 
			 * Alert alert=new Alert(AlertType.ERROR);
			 * alert.setTitle("Error Dialog: Teilbestellung.readAll()" );
			 * alert.setHeaderText("Folgender Fehler ist aufgetreten:");
			 * alert.setContentText("Konstruktion der Lieferantenobjekte fehlgeschlagen!");
			 */
		}
		return null;
	}
	 
	public static void writeAll(ArrayList<Teilbestellung> teilbestellungen,TableView<Teilbestellung> teilbestellungTable) {
		//Auf der Tabelle auf dem Layer alle Teilbestellungen darstellen

		ObservableList<Teilbestellung> tabelleninhalt = FXCollections.observableArrayList();

		for (Teilbestellung teilbestellung : teilbestellungen) {
			// teilbestellung adden
			tabelleninhalt.add(teilbestellung);
		
			
			//Achtung !! Tabelle so bauen, dass Positionen nicht ausgegeben werden

		}

		// Daten in der Tabelle Anzeigen
		teilbestellungTable.setItems(tabelleninhalt);
	}
	public static void updateStatus(int teilbestellungID, String s) {

			try {
				// In der Datenbank speichern
				Statement stmt = connection.createStatement();

				stmt.executeUpdate("Update TEILBESTELLUNGEN Set STATUS ='" + s + "' WHERE ID='" + Integer.toString(teilbestellungID) + "'");

			} catch (SQLException e) {
				// Meldung Lieferant speichern fehlgeschlagen
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Dialog: Teilbestellung.updateStatus()");
				alert.setHeaderText("Folgender Fehler ist aufgetreten:");
				alert.setContentText("Speichern in der Datenbank fehlgeschlagen!");
				return;
			}
			// Meldung Lieferant erfolgreich gespeichert
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog: Teilbestellung.updateStatus()");
			alert.setHeaderText("Folgendes Ereignis ist eingetreten:");
			alert.setContentText("Lieferant erfolgreich gespeichert!");
		
	}
		
	
	public void create() {
		//Eine Teilbestellung in der Datenbank speichern
		
		// ï¿½berprï¿½fen ob readLayer() Daten erheben konnte
		if (!(this == null)) {

			try {
				// Datenbank speichern
				Statement stmt = connection.createStatement();
				stmt.executeUpdate("INSERT INTO TEILBESTELLUNGEN (ID, USER, LIEFERANT, STATUS, STRING) VALUES " + "('"
						+ Integer.toString(this.getiD())+"'('"+ Integer.toString(this.getUser().getID())+"'('"
						+ Integer.toString(this.getLieferant().getID())+"'('"+this.getStatus() +"'('"
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
	
	public String objectToString() {
		//Aus den Angebot.iDs und Mengen einen String bauen der zum Speichern in der Datenbank notwendig ist
		
		String s="";
		for(Position position : this.positionen) {
			s = s + Integer.toString(position.getAngebot().getiD())+"/"+Integer.toString(position.getMenge())+";";
		}
		return s;
	}
	
	
	public String toText() {
	//Aus der Teilbestellung einen String bauen der als Mailvorlage dient
		StringBuffer sb = new StringBuffer();
		sb.append("Sehr geehrte Damen und Herren,\n\n");
		sb.append("Wir haben eine neue Bestellung für Sie erstellt.\n\n");
		sb.append("Bestellungsnummer: ");
		sb.append(this.iD);
		sb.append("\n");
		for(int i = 0; i<this.positionen.size(); i++) {
			sb.append("Einzelteil: ");
			sb.append(this.positionen.get(i).getAngebot().getProdukt().getName());
			sb.append("\n");
			sb.append("Teilennummer: ");
			sb.append(this.positionen.get(i).getAngebot().getProdukt().getiD());
			sb.append("\n");
			sb.append("Menge: ");
			sb.append(this.positionen.get(i).getMenge());
			sb.append("\n");
		}
		sb.append("Mit freundlichen Grüßen\n");
		sb.append(this.user.getUser());
		sb.append("\n\n");
		sb.append("HighSpeedProcurement");
		String toBeMailed = sb.toString();
		return toBeMailed;		
	}
	
	public Mail objectToMail() {
		//Aus der Teilbestellung eine Mail bauen mithilfe von toText();
		
		String TextBody = this.toText();		
		Mail newMail = new Mail(TextBody,this.iD,User.isLoggedIn().getUser(), this.lieferant.getKontaktdaten().getEmail());
	
		return newMail;
	}
	public static Teilbestellung readOne(int tbID) {

		try {
			// Produktportfolio aus der Datenbank abfragen	

			
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM PPRODUKTPORTFOLIOS WHERE ID ='"+Integer.toString(tbID)+"'");
			while (rs.next()) {
				
				// 1 PP bauen
				
				Lieferant lieferant = Lieferant.readOne(Integer.parseInt(rs.getString("LIEFERANTID")));
				User user = User.readOne(Integer.parseInt(rs.getString("USERID")));
				Teilbestellung teilbestellung = new Teilbestellung(tbID,user,lieferant,rs.getString("STRING"),rs.getString("STATUS"));
				// ArayList mit TB beschreiben				
				return teilbestellung;
				
			}
			
		} catch (SQLException e) {
			// Fehlermeldung ausgeben in einem Dialog auf FX "Datenbankabfrage
			// Fehlgeschlagen"

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog: Teilbestellung.readOne()");
			alert.setHeaderText("Folgender Fehler ist aufgetreten:");
			alert.setContentText("Datenbankabfrage fehlgeschlagen!");

			/*
			 * }catch(Exception e) {
			 * 
			 * 
			 * Alert alert=new Alert(AlertType.ERROR);
			 * alert.setTitle("Error Dialog: Teilbestellung.readOne()" );
			 * alert.setHeaderText("Folgender Fehler ist aufgetreten:");
			 * alert.setContentText("Konstruktion der Lieferantenobjekte fehlgeschlagen!");
			 */
		}
		return null;
	}
	
	
}
