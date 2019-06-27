package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import main.Main;
import model.bestellung.Teilbestellung;

public class BestellungController implements Initializable {
	@FXML
	private Button btnHeader;
	@FXML
	private Button btnBest;
	@FXML
	private Button btnPortfolio;
	@FXML
	private Button btnHilfe;
	@FXML
	private Button btnHome;
	@FXML
	private Button btnLogout;
	@FXML
	private Button btnLief;
	@FXML
	private Button btnRegBest;
	@FXML
	private Button btnEilBest;
	@FXML
	private Button btnSave;
	@FXML
	private Hyperlink linkStornieren;
	@FXML
	private TableView<Teilbestellung> tableBestBearb;
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
	private TableColumn<Teilbestellung, Timestamp> colDate;
	@FXML
	private TextField textfieldStorno;
	@FXML
	private Button btnStorno;
	@FXML
	private Text userMailLogged;
	private ObservableList<Teilbestellung> oblistTeilBest = FXCollections.observableArrayList();

	@FXML
	public void handleHomeButton(ActionEvent event) throws IOException {
		Main.set_pane(1);
	}

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
	public void handleAbmeldenButton(ActionEvent event) throws IOException {
		Main.close();

	}

	@FXML
	public void createRegBestellung(ActionEvent event) throws IOException {
		Main.set_pane(8);
	}

	@FXML
	public void handleEilBEstellung(ActionEvent event) throws IOException {
		Main.set_pane(10);
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
				tableBestBearb.setItems(oblistTeilBest);
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
		colDate.setCellValueFactory(new PropertyValueFactory<>("erstelltAm"));
	}
	@FXML
	public void saveBestellung() {
		final Connection connection = util.DBUtil.getConnection();
		PreparedStatement stmt;
		try {
			int i;
			String teilID;
			if (oblistTeilBest.isEmpty() == false) {
				for (i = 0; i < oblistTeilBest.size(); i++) {
					Teilbestellung t = oblistTeilBest.get(i);
					teilID = t.getBestUUID().toString();
					colStatus.getCellData(i);
					String status = t.getStatusNew().toString();
					String query = "UPDATE Teilbestellungen SET Status='"+ status +"' WHERE UUID = '"+ teilID+ "'";
					stmt = connection.prepareStatement(query);
					stmt.executeUpdate(query);

				}
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Gespeichert!");
				alert.setHeaderText("Erfolgreich!");
				alert.setContentText("Ihre Änderung(en) wurden erfolgreich gespeichert!");
				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {
					alert.close();
					textfieldStorno.clear();
					tableBestBearb.refresh();
				}

			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Fehler");
				alert.setHeaderText("Sie haben keine Änderungen gemacht!");
				alert.setContentText("Bitte machen Sie eine oder mehrere Änderungen!");
				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {
					alert.close();
					textfieldStorno.clear();
					tableBestBearb.refresh();
				}

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		loadDatabaseBestellung();
		linkStornieren.setTooltip(new Tooltip("Klicken Sie bitte auf der Spalte \"Status\" und setzen Sie den Status zu \"storniert\".\n Wenn Sie fertig mit Ihrer Änderungen sind, klicken Sie bitte auf \" Änderungen speichern\"!"));

	}
}
