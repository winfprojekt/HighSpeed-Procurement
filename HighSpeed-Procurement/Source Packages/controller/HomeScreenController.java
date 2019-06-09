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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import main.Main;
import model.Lieferant.Adresse;
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
	private TableView <model.Lieferant.Lieferant> tableLieferant;
	@FXML
	private TableColumn<model.Lieferant.Lieferant,Integer> colNum;
	@FXML
	private TableColumn<model.Lieferant.Lieferant,String> colName;
	@FXML
	private TableColumn<model.Lieferant.Lieferant,Adresse> colAdr;
	@FXML
	private TableColumn<model.Lieferant.Lieferant,String> colTyp;
	@FXML
	private TableColumn<model.Lieferant.Lieferant,Timestamp> colDate;
	
	private ObservableList<model.Lieferant.Lieferant> oblist = FXCollections.observableArrayList();
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
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		dbu = new DBUtil();
		loadDatabaseData();
	}
	public void loadDatabaseData() {
		String query = "SELECT * FROM Lieferant";
		try {
			stmt =connection.prepareStatement(query);
			rs=stmt.executeQuery(query);
			
			while(rs.next()) {
				model.Lieferant.Lieferant l1 = new model.Lieferant.Lieferant(
						rs.getInt("ID"),
						rs.getString("Name"),
						new Adresse(rs.getString("Adresse"),rs.getString("Stadt"),rs.getInt("PLZ"),rs.getString("Land").toString()),
						rs.getString("Typ"),
						rs.getTimestamp("Timestamp"));
				oblist.add(l1);
			}
			stmt.close();
			rs.close();
			connection.close();
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
	
}
