package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import main.Main;
import model.bestellung.Teilbestellung;
import model.lieferant.Adresse;
import util.DBUtil;

public class HomeScreenController implements Initializable {

	@FXML
	private Button btnHome;
	@FXML
	private Button btnLief;
	@FXML
	private Button btnBest;
	@FXML
	private Button btnPortfolio;
	@FXML
	private Button btnHilfe;
	@FXML
	private Button btnHeader;
	@FXML
	private Text userMailLogged;
	@FXML
	private Button btnLogout;
	@FXML
	private Label liefOverview;
	@FXML
	private Label bestellOverview;
	@FXML
	private TableView <model.lieferant.Lieferant> tableLieferant;
	@FXML
	private TableColumn<model.lieferant.Lieferant,Integer> colNum;
	@FXML
	private TableColumn<model.lieferant.Lieferant,String> colName;
	@FXML
	private TableColumn<model.lieferant.Lieferant,Adresse> colAdr;
	@FXML
	private TableColumn<model.lieferant.Lieferant,String> colTyp;
	@FXML
	private TableColumn<model.lieferant.Lieferant,Timestamp> colDate;
	@FXML
	private Hyperlink linkStornieren;
	@FXML
	private TableView<Teilbestellung> tableBestellung;
	@FXML
	private TableColumn<Teilbestellung, String> colBestName;
	@FXML
	private TableColumn<Teilbestellung, String> colBestUUID;
	@FXML
	private TableColumn<Teilbestellung, Integer> colLiefID;
	@FXML
	private TableColumn<Teilbestellung, String> colProdTyp;
	@FXML
	private TableColumn<Teilbestellung, String> colProdHerst;
	@FXML
	private TableColumn<Teilbestellung, Integer> colMenge;
	@FXML
	private TableColumn<Teilbestellung, String> colBestTyp;
	@FXML
	private TableColumn<Teilbestellung, String> colStatus;
	@FXML
	private TableColumn<Teilbestellung, Double> colGesamtpreis;
	@FXML
	private TableColumn<Teilbestellung, String> colProdName;
	@FXML
	private TableColumn<Teilbestellung,Timestamp> colBestDate;
	
	private ObservableList<model.lieferant.Lieferant> oblist = FXCollections.observableArrayList();
	private ObservableList<Teilbestellung> oblistTeilBest = FXCollections.observableArrayList();
	private Connection connection = util.DBUtil.getConnection();
	private PreparedStatement stmt;
	private ResultSet rs = null;
	private DBUtil dbu;
	
	public static final String title = "HighSpeed-Procurement (Home)";

	// When the "Lieferant"-Button is pressed a new scene is loaded
	@FXML
	private void handleLiefButtonAction(ActionEvent event) {
			Main.set_pane(2);

	}

	@FXML
	public void handleBestButton(ActionEvent event) throws IOException {

		Main.set_pane(5);

	}
	@FXML
	public void handleProduktButton(ActionEvent event) throws IOException {

		Main.set_pane(6);

	}
	@FXML
	public void handleHilfeButton(ActionEvent event) throws IOException {

		Main.set_pane(7);

	}
	@FXML
	public void handleAbmeldenButton (ActionEvent event) throws IOException {
		Main.close();
		
	}

	public void loadDatabaseData() {
		String query = "SELECT * FROM Lieferant";
		try {
			stmt =connection.prepareStatement(query);
			rs=stmt.executeQuery(query);
			
			while(rs.next()) {
				model.lieferant.Lieferant l1 = new model.lieferant.Lieferant(
						rs.getInt("ID"),
						rs.getString("Name"),
						new Adresse(rs.getString("Adresse"),rs.getString("Stadt"),rs.getInt("PLZ"),rs.getString("Land").toString()),
						rs.getString("Typ"),
						rs.getTimestamp("Timestamp"));
				oblist.add(l1);
			}
			connection.close();
			stmt.close();
			rs.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		colNum.setCellValueFactory(new PropertyValueFactory<>("iD"));
		colName.setCellValueFactory(new PropertyValueFactory<>("name"));
		colAdr.setCellValueFactory(new PropertyValueFactory<>("adresse"));
		colTyp.setCellValueFactory(new PropertyValueFactory<>("typ"));
		colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
		tableLieferant.setItems(oblist);
	}
	private void loadDatabaseBestellung(){
		final Connection connection = util.DBUtil.getConnection();
		final PreparedStatement stmt;
		final ResultSet rs;
		final String query = "SELECT * FROM Teilbestellungen";
		try {
			stmt = connection.prepareStatement(query);
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				// p1 = new Produkt(rs.getInt("ID"));
				Teilbestellung teil = new Teilbestellung(rs.getString("UUID"), rs.getString("Name"),
						rs.getInt("Lieferant_ID"), rs.getString("Produkttyp"), rs.getString("Produktname"),
						rs.getString("Hersteller"), rs.getInt("Menge"),rs.getString("Typ"), rs.getString("Status"),
						rs.getDouble("Gesamtpreis"), rs.getTimestamp("Erstellungsdatum"));

				oblistTeilBest.add(teil);
				tableBestellung.setItems(oblistTeilBest);
			}
			stmt.close();
			rs.close();
			connection.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		colBestUUID.setCellValueFactory(new PropertyValueFactory<>("bestUUID"));
		colBestName.setCellValueFactory(new PropertyValueFactory<>("name"));
		colLiefID.setCellValueFactory(new PropertyValueFactory<>("liefID"));
		colProdTyp.setCellValueFactory(new PropertyValueFactory<>("prodTyp"));
		colProdName.setCellValueFactory(new PropertyValueFactory<>("prodName"));
		colProdHerst.setCellValueFactory(new PropertyValueFactory<>("hersteller"));
		colMenge.setCellValueFactory(new PropertyValueFactory<>("menge"));
		colBestTyp.setCellValueFactory(new PropertyValueFactory<>("bestellungsTyp"));
		colStatus.setCellValueFactory(cellData -> cellData.getValue().statusNewProperty());
		colStatus.setCellFactory(ComboBoxTableCell.forTableColumn("in Bearbeitung","versendet","eingetroffen","storniert"));
		colGesamtpreis.setCellValueFactory(new PropertyValueFactory<>("gesamtpreis"));
		colBestDate.setCellValueFactory(new PropertyValueFactory<>("erstelltAm"));
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		dbu = new DBUtil();
		loadDatabaseData();
		loadDatabaseBestellung();
		tableLieferant.refresh();
		tableBestellung.refresh();

	}
}
