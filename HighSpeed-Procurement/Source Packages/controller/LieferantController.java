package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.Main;
import model.Lieferant.Adresse;
import model.Lieferant.Bankdaten;
import model.Lieferant.Kontaktdaten;
import model.Lieferant.Lieferant;
import util.DBUtil;

public class LieferantController implements Initializable {
	@FXML
	private Text actiontarget;

	@FXML
	private Text actiontarget2;

	@FXML
	private PasswordField passwordField;
	@FXML
	private Text welcome;
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
	private AnchorPane rootPane;
	@FXML
	private Button btnAnlegen;
	@FXML
	private TableView <model.Lieferant.Lieferant> tableBearbeiten;;
	@FXML
	private TableColumn<model.Lieferant.Lieferant,String> colName;
	@FXML
	private TableColumn<model.Lieferant.Lieferant,String> colAdresse;
	@FXML
	private TableColumn<model.Lieferant.Lieferant,String> colTyp;
	@FXML
	private TableColumn<model.Lieferant.Lieferant,Integer> colNummer;
	@FXML
	private TableColumn<model.Lieferant.Lieferant,String> colDate;
	
	private ObservableList<model.Lieferant.Lieferant> oblist = FXCollections.observableArrayList();
	private Connection connection = util.DBUtil.getConnection();
	private Statement stmt = null;
	private ResultSet rs = null;
	private DBUtil dbu;
	
	@FXML
	public void handleHomeButton(ActionEvent event) throws IOException {
		Main.set_pane(1);
	}
	@FXML
	public void handleBestButton(ActionEvent event) throws IOException {

		Main.set_pane(4);

	}
	@FXML
	public void handleProduktButton(ActionEvent event) throws IOException {

		Main.set_pane(5);

	}
	@FXML
	public void handleHilfeButton(ActionEvent event) throws IOException {

		Main.set_pane(6);

	}
	@FXML
	public void handleLiefAnlegenButton (ActionEvent event) throws IOException {

		Main.set_pane(3);

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
			stmt =connection.createStatement();
			rs=stmt.executeQuery(query);
			
			while(rs.next()) {
				/*oblist.add(new model.Lieferant.Lieferant(
						new Adresse (rs.getString("ADRESSE"), rs.getString("STADT"), rs.getInt("PLZ"), rs.getString("LAND")),
						new Kontaktdaten (rs.getString("EMAIL"),rs.getString("TELEFONNUMMER")),
						new Bankdaten(rs.getString("BANK"),rs.getString("IBAN"), rs.getString("B/S"),rs.getInt("STEUERNUMMER")),
						rs.getString("TYP")));*/
			}
			stmt.close();
			rs.close();
			connection.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		colNummer.setCellValueFactory(new PropertyValueFactory<>("id"));
		colName.setCellValueFactory(new PropertyValueFactory<>("name"));
		colAdresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
		colTyp.setCellValueFactory(new PropertyValueFactory<>("typ"));
		//colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
		tableBearbeiten.setItems(oblist);
	}
	
}

