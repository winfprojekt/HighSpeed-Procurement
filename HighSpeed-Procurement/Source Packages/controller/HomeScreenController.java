package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
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
	
	ObservableList<model.Lieferant.Lieferant> oblist = FXCollections.observableArrayList();
	Connection connection = util.DBUtil.getConnection();
	PreparedStatement stmt = null;
	ResultSet rs = null;
	
	public static final String title = "HighSpeed-Procurement (Home)";

	// When the "Lieferant"-Button is pressed a new scene is loaded
	@FXML
	private void handleLiefButtonAction(ActionEvent event) {
			Main.set_pane(2);

	}

	@FXML
	private void handleBestButton(ActionEvent event) throws IOException {

		Parent bestellungParent = FXMLLoader.load(getClass().getResource("BestellungView.fxml"));
		Scene bestellungScene = new Scene(bestellungParent);

		// get the Stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(bestellungScene);
		window.show();

	}
	@FXML
	private void handleProduktButton(ActionEvent event) throws IOException {

		Parent produktportfolioParent = FXMLLoader.load(getClass().getResource("ProduktportfolioView.fxml"));
		Scene produktportfolioScene = new Scene(produktportfolioParent);

		// get the Stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(produktportfolioScene);
		window.show();

	}
	@FXML
	private void handleHilfeButton(ActionEvent event) throws IOException {

		Parent hilfeParent = FXMLLoader.load(getClass().getResource("HilfeView.fxml"));
		Scene hilfeScene = new Scene(hilfeParent);

		// get the Stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(hilfeScene);
		window.show();

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		colName.setCellValueFactory(new PropertyValueFactory<>("NAME"));
		colAddr.setCellValueFactory(new PropertyValueFactory<>("ADDRESS"));
		colType.setCellValueFactory(new PropertyValueFactory<>("TYPE"));
		tableLieferant.setItems(oblist);
		loadDatabaseData();
	}
	public void loadDatabaseData() {
		String query = "SELECT * FROM Supplier";
		try {
			stmt =connection.prepareStatement(query);
			rs=stmt.executeQuery();
			
			while(rs.next()) {
				oblist.add(new model.Lieferant.Lieferant(rs.getString("NAME"), rs.getString("ADDRESS"),rs.getString("TYPE")));
				tableLieferant.setItems(oblist);
			}
			stmt.close();
			rs.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
