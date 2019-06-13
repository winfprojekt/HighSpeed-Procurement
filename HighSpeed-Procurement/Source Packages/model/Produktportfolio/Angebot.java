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
import javafx.scene.control.TextField;


class Angebot {
	private int iD;
	private Lieferant lieferant;
	private Produkt produkt;
	private double einzelpreis;
	private int gultigkeitsdauer;
	
	private static Connection connection = util.DBUtil.getConnection();

	
	//Innere KLasse zur Tabellendarstellung
	/*public class TableAngebot {
		int iD;String produktName ;String lieferantenName; double einzelpreis;int gultigkeitsdauer; 
		 
		 public TableAngebot(int iD,String produktName ,String lieferantenName, double einzelpreis,int gultigkeitsdauer ) {
			 this.iD = iD; this.lieferantenName = lieferantenName; this.einzelpreis = einzelpreis; this.gultigkeitsdauer = gultigkeitsdauer;} }*/

	//Konstruktor
	public Angebot(Lieferant lieferant, Produkt produkt, double einzelpreis,int gultigkeitsdauer) {
		super();
		this.lieferant = lieferant;
		this.produkt = produkt;
		this.einzelpreis = einzelpreis;
		this.gultigkeitsdauer=gultigkeitsdauer;
	}
		
		//Konstruktor 2
		public Angebot(int iD,Lieferant lieferant, Produkt produkt, double einzelpreis,int gultigkeitsdauer) {
			super();
			this.iD=iD;
			this.lieferant = lieferant;
			this.produkt = produkt;
			this.einzelpreis = einzelpreis;
			this.gultigkeitsdauer=gultigkeitsdauer;	
	}
	
	//Getter + Setter
	public Lieferant getLieferant() {
		return lieferant;
	}
	public void setLieferant(Lieferant lieferant) {
		this.lieferant = lieferant;
	}
	
	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}

	public int getGultigkeitsdauer() {
		return gultigkeitsdauer;
	}

	public void setGultigkeitsdauer(int gultigkeitsdauer) {
		this.gultigkeitsdauer = gultigkeitsdauer;
	}

	public Produkt getProdukt() {
		return produkt;
	}
	public void setProdukt(Produkt produkt) {
		this.produkt = produkt;
	}
	public double getEinzelpreis() {
		return einzelpreis;
	}
	public void setEinzelpreis(double einzelpreis) {
		this.einzelpreis = einzelpreis;
	}
	
	//Zusätzliche Logik
	public static	ArrayList <Angebot>	readActive(){
		//Alle Angebote, deren Laufzeitwert >=1 ist, aus der Datenbank einlesen und zurückgeben	
		
		try {
			ArrayList<Angebot> angeboteList = new ArrayList<Angebot>();
			// Angebot aus der Datenbank abfragen
			

			
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM ANGEBOTE WHERE GULTIGKEITSDAUER >= 1 ");
			while (rs.next()) {
				
				// 1 Angebot bauen
				Lieferant lieferant = Lieferant.readOne(Integer.parseInt(rs.getString("LIEFERANT")));
				Produkt produkt= Produkt.readOne(Integer.parseInt(rs.getString("PRODUKT")));
				Angebot angebot= new Angebot(Integer.parseInt(rs.getString("ID")),lieferant,produkt,
						Integer.parseInt(rs.getString("PREIS")),Integer.parseInt(rs.getString("GULTIGKEITSDAUER")));
				// ArayList mit Lieferant beschreiben
				
				angeboteList.add(angebot);
			}
			
			return angeboteList;
		} catch (SQLException e) {
			// Fehlermeldung ausgeben in einem Dialog auf FX "Datenbankabfrage
			// Fehlgeschlagen"

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog: Angebot.readActive()");
			alert.setHeaderText("Folgender Fehler ist aufgetreten:");
			alert.setContentText("Datenbankabfrage fehlgeschlagen!");

			/*
			 * }catch(Exception e) {
			 * 
			 * 
			 * Alert alert=new Alert(AlertType.ERROR);
			 * alert.setTitle("Error Dialog: Angebot.readActive()" );
			 * alert.setHeaderText("Folgender Fehler ist aufgetreten:");
			 * alert.setContentText("Konstruktion der Lieferantenobjekte fehlgeschlagen!");
			 */
		}
		return null;
	}
	public static Angebot readOne(int iD) {

		try {
			// Angebot aus der Datenbank abfragen	

			
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM ANGEBOTE WHERE ID ='"+Integer.toString(iD)+"'");
			while (rs.next()) {
				
				// 1 Angebot bauen
				Lieferant lieferant = Lieferant.readOne(Integer.parseInt(rs.getString("LIEFERANT")));
				Produkt produkt= Produkt.readOne(Integer.parseInt(rs.getString("PRODUKT")));
				Angebot angebot= new Angebot(Integer.parseInt(rs.getString("ID")),lieferant,produkt,
						Integer.parseInt(rs.getString("PREIS")),Integer.parseInt(rs.getString("GULTIGKEITSDAUER")));
				// ArayList mit Lieferant beschreiben
				
				return angebot;
			}
			
		} catch (SQLException e) {
			// Fehlermeldung ausgeben in einem Dialog auf FX "Datenbankabfrage
			// Fehlgeschlagen"

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog: Angebot.readOne()");
			alert.setHeaderText("Folgender Fehler ist aufgetreten:");
			alert.setContentText("Datenbankabfrage fehlgeschlagen!");

			/*
			 * }catch(Exception e) {
			 * 
			 * 
			 * Alert alert=new Alert(AlertType.ERROR);
			 * alert.setTitle("Error Dialog: Angebot.readOne()" );
			 * alert.setHeaderText("Folgender Fehler ist aufgetreten:");
			 * alert.setContentText("Konstruktion der Lieferantenobjekte fehlgeschlagen!");
			 */
		}
		return null;

}
	
	public	ArrayList <Angebot>	readByID(ArrayList <Integer> angebotIDs){
		//Alle Angebote, deren ID in den Methodenkopf gegeben werden einlesen und zurückgeben

				try {
					ArrayList<Angebot> angeboteList = new ArrayList<Angebot>();
					// Angebot aus der Datenbank abfragen
					for (int idCount: angebotIDs) {

					
					Statement stmt = connection.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT * FROM ANGEBOTE WHERE ID ='"+Integer.toString(idCount)+"'");
					while (rs.next()) {
						
						// 1 Angebot bauen
						Lieferant lieferant = Lieferant.readOne(Integer.parseInt(rs.getString("LIEFERANT")));
						Produkt produkt= Produkt.readOne(Integer.parseInt(rs.getString("PRODUKT")));
						Angebot angebot= new Angebot(Integer.parseInt(rs.getString("ID")),lieferant,produkt,
								Integer.parseInt(rs.getString("PREIS")),Integer.parseInt(rs.getString("GULTIGKEITSDAUER")));
						// ArayList mit Lieferant beschreiben
						
						angeboteList.add(angebot);
					}
					}
					return angeboteList;
				} catch (SQLException e) {
					// Fehlermeldung ausgeben in einem Dialog auf FX "Datenbankabfrage
					// Fehlgeschlagen"

					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error Dialog: Angebot.readOne()");
					alert.setHeaderText("Folgender Fehler ist aufgetreten:");
					alert.setContentText("Datenbankabfrage fehlgeschlagen!");

					/*
					 * }catch(Exception e) {
					 * 
					 * 
					 * Alert alert=new Alert(AlertType.ERROR);
					 * alert.setTitle("Error Dialog: Angebot.readOne()" );
					 * alert.setHeaderText("Folgender Fehler ist aufgetreten:");
					 * alert.setContentText("Konstruktion der Lieferantenobjekte fehlgeschlagen!");
					 */
				}
				return null;
		
	}
	public	void	writeOne() {
		//Auf der Tabelle auf dem Layer ein Angebot darstellen	
		//womöglich überflüssig
	}
	public	static void	writeList(ArrayList <Angebot> angebote,TableView<TableAngebot> tablePpBestellung /*Layer Bestellung anlegen */) {
		//Auf der Tabelle auf dem Layer eine Liste aus Angeboten darstellen	
		
		// Tabellengrï¿½ï¿½e an Arraylï¿½nge anpassen?

		ObservableList<TableAngebot> tabelleninhalt = FXCollections.observableArrayList();

				for (Angebot angebot : angebote) {
					// neues TableLieferant Objekt bauen
					TableAngebot tableAngebot = new TableAngebot(angebot.getiD(),angebot.getProdukt().getName(),angebot.getLieferant().getName(),
							angebot.getEinzelpreis(),angebot.getGultigkeitsdauer());

					// zur Liste hinzufï¿½gen
					tabelleninhalt.add(tableAngebot);

				}

				// Daten in der Tabelle Anzeigen
				tablePpBestellung.setItems(tabelleninhalt);
			}
	
	public	void create() {
		//Ein Angebot in der Datenbank speichern
		
		// ï¿½berprï¿½fen ob readLayer() Daten erheben konnte
				if (!(this == null)) {

					try {
						// Datenbank speichern
						Statement stmt = connection.createStatement();
						stmt.executeUpdate("INSERT INTO ANGEBOTE (LIEFERANT, PRODUKT, PREIS, GULTIGKEITSDAUER) VALUES " + "('"
								+ Integer.toString(this.getLieferant().getID())+ "','" + Integer.toString(this.getProdukt().getiD()) + "','"
								+ Double.toString(this.getEinzelpreis())+ "','"+ Integer.toString(this.getGultigkeitsdauer()) + "')");

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
	public static	Angebot	readLayer(TableView<Lieferant> tableLieferant, TableView<Produkt> tableProdukt, TextField textfeldPreis, TextField textfeldGultigkeitsdauer) {
		//Aus dem Layer ein Angebot einlesen und zurückgeben	incl. Grammatikabfrage
		try {
			//Felder casten und Objekte bauen
			
			Lieferant lieferant= tableLieferant.getSelectionModel().getSelectedItem();
			Produkt produkt=tableProdukt.getSelectionModel().getSelectedItem();
			double preis=Double.parseDouble(textfeldPreis.getText());
			int gultigkeitsdauer = Integer.parseInt(textfeldGultigkeitsdauer.getText());

			Angebot angebot=new Angebot(lieferant,produkt,preis,gultigkeitsdauer);
			return angebot;
		} catch (Exception e) {
			// Generelle Fehlermeldung "Falscher Datentyp!" in einem Dialog auf FX
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog: Angebot.readLayer()");
			alert.setHeaderText("Folgender Fehler ist aufgetreten:");
			alert.setContentText("Falscher Datentyp! Bitte ï¿½berprï¿½fen sie ihre Eingaben!");

		}
		return null;
		
	}
	public	void decreaseLaufzeitAll() {
		//Die Laufzeitvariable aller Angebote um 1 verringern	

			try {
				// Datenbank speichern
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT (ID, GULTIGKEITSDAUER) FROM ANGEBOTE");
				while (rs.next()) {
					Statement stmt2 = connection.createStatement();
					stmt2.executeUpdate("Update ANGEBOTE Set GULTIGKEITSDAUER ='"+Integer.toString((Integer.parseInt(rs.getString("GULTIGKEITSDAUER"))-1))
					+"' WHERE ID='" + rs.getString("ID") + "'");					
				}

			} catch (SQLException e) {
				// Meldung Lieferant speichern fehlgeschlagen
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Dialog: Angebot.decreaseLaufzeitAll()");
				alert.setHeaderText("Folgender Fehler ist aufgetreten:");
				alert.setContentText("Speichern in der Datenbank fehlgeschlagen!");
				return;
			}
			// Meldung Lieferant erfolgreich gespeichert
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog: Angebot.decreaseLaufzeitAll()");
			alert.setHeaderText("Folgendes Ereignis ist eingetreten:");
			alert.setContentText("Gultigkeitsdauer erfolgreich vermindert!");
		
	}
	
	
	public void addToPP(TableView<TableAngebot> tableProduktportfolio/* Layer Prdouktportfolio anlegen*/) {
		// Das Angebot objekt auf dem Layer Produktportfolio erstellen zur Produktportfoliotabelle hinzufügen
		
		//Tabelle vergrößern?
		
		TableAngebot tableAngebot = new TableAngebot(this.getiD(),this.getProdukt().getName(),this.getLieferant().getName(),
				this.getEinzelpreis(),this.getGultigkeitsdauer());
		tableProduktportfolio.getItems().add(tableAngebot);

	}
		
		

}
