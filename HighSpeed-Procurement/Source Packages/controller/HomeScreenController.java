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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import main.Main;
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
	private TableColumn<model.Lieferant.Lieferant,String> colName;
	@FXML
	private TableColumn<model.Lieferant.Lieferant,String> colAddr;
	@FXML
	private TableColumn<model.Lieferant.Lieferant,String> colType;
	@FXML
	private TableColumn<model.Lieferant.Lieferant,Integer> colNum;
	@FXML
	private TableColumn<model.Lieferant.Lieferant,String> colDate;
	
	private ObservableList<model.Lieferant.Lieferant> oblist = FXCollections.observableArrayList();
	private Connection connection = util.DBUtil.getConnection();
	private Statement stmt = null;
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
	public void handleAbmeldenButton (ActionEvent event) throws IOException {
		Main.close();
		
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		dbu = new DBUtil();
		loadDatabaseData();
	}
	public void loadDatabaseData() {
		String query = "SELECT * FROM USER_INFO";
		try {
			stmt =connection.createStatement();
			rs=stmt.executeQuery(query);
			
			while(rs.next()) {
				oblist.add(new model.Lieferant.Lieferant(((Integer)rs.getInt(1)),rs.getString(2), rs.getString(3),rs.getString(4)));
			}
			stmt.close();
			rs.close();
			connection.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		colNum.setCellValueFactory(new PropertyValueFactory<>("id"));
		colName.setCellValueFactory(new PropertyValueFactory<>("name"));
		colAddr.setCellValueFactory(new PropertyValueFactory<>("adresse"));
		colType.setCellValueFactory(new PropertyValueFactory<>("typ"));
		//colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
		tableLieferant.setItems(oblist);
	}
	
}
