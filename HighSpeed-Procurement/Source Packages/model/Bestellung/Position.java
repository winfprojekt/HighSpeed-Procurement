package model.Bestellung;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Produktportfolio.Angebot;
import model.Produktportfolio.TableAngebot;
import javafx.scene.control.Alert.AlertType;

class Position {
	private int menge;
	private Angebot angebot;
	
	//Innere KLasse zur Tabellendarstellung
		/*public class TablePosition {
			int menge;int angebotID;String produktName ;String lieferantenName; double einzelpreis;int gultigkeitsdauer; 
			 
			 public TablePosition(int menge, int angebotID,String produktName ,String lieferantenName, double einzelpreis,int gultigkeitsdauer ) {
				this.menge = menge; this.angebotID = angebotID; this.lieferantenName = lieferantenName; this.einzelpreis = einzelpreis; this.gultigkeitsdauer = gultigkeitsdauer;} }*/


	
	//Konstruktor
	public Position(Angebot angebot, int menge) {
		super();
		this.angebot = angebot;
		this.menge = menge;
	}
	
	//Getter + Setter
	public Angebot getAngebot() {
		return angebot;
	}
	public void setAngebot(Angebot angebot) {
		this.angebot = angebot;
	}
	public int getMenge() {
		return menge;
	}
	public void setMenge(int menge) {
		this.menge = menge;
	}
	public static Position readLayer(TableView<TableAngebot> tableAngebote,TextField textfeldMenge) {
		// Vlt zum �berarbeiten? Da �Ayer noch nicht klar
		
		try {
			//Felder casten und Objekte bauen
			
			int menge = Integer.parseInt(textfeldMenge.getText());
			Angebot angebot=Angebot.readOne(tableAngebote.getSelectionModel().getSelectedItem().iD);
		
			Position position = new Position(angebot,menge);
			return position;
		} catch (Exception e) {
			// Generelle Fehlermeldung "Falscher Datentyp!" in einem Dialog auf FX
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog: Angebot.readLayer()");
			alert.setHeaderText("Folgender Fehler ist aufgetreten:");
			alert.setContentText("Falscher Datentyp! Bitte �berpr�fen sie ihre Eingaben!");

		}
		return null;
		
		
	}
	public void addToSB(TableView<TablePosition> tableView,TableView<TableAngebot> tableAngebote,TextField textfeldMenge) {
		readLayer(tableAngebote,textfeldMenge);
		
			// Das Position objekt auf dem Layer Betsellung erstellen zur Bestellungstabelle hinzuf�gen
			
			//Tabelle vergr��ern?
			
			TablePosition tablePosition = new TablePosition(this.getMenge(),this.angebot.getAngID(),this.getAngebot().getProdukt().getName(),
					this.getAngebot().getLieferant().getName(),this.getAngebot().getEinzelpreis());
			tableView.getItems().add(tablePosition);

		
		
	}
	public static void writeList(ArrayList<Position> positionen,TableView<TablePosition> tableTeilbestellung) {
		//Muss implenetiert werden
		// Tabellengr��e an Arrayl�nge anpassen?

				ObservableList<TablePosition> tabelleninhalt = FXCollections.observableArrayList();

						for (Position position : positionen) {
							// neues TableLieferant Objekt bauen
							TablePosition tablePosition = new TablePosition(position.getMenge(),position.getAngebot().getAngID(),
									position.getAngebot().getProdukt().getName(),position.getAngebot().getLieferant().getName(),
									position.getAngebot().getEinzelpreis());

							// zur Liste hinzuf�gen
							tabelleninhalt.add(tablePosition);

						}

						// Daten in der Tabelle Anzeigen
						tableTeilbestellung.setItems(tabelleninhalt);
	}
	
	
	
	
	

}
