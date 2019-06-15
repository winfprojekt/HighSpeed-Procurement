package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import main.Main;
import model.Lieferant.Adresse;
import model.Lieferant.Dummy;
import model.Lieferant.Lieferant;
import model.Produkt.Produkt;
import model.Produktportfolio.Angebot;
import util.DBUtil;

public class ProduktportfolioController implements Initializable {
	@FXML
	private Button btnHeader;
	@FXML
	private Label userMailLogged;
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
	private Label lblLiefOverview;
	@FXML
	private TableView<Lieferant> tableLiefOverview;
	@FXML
	private TableColumn<Lieferant, Integer> colLiefID;
	@FXML
	private TableColumn<Lieferant, String> colName;
	@FXML
	private TableColumn<Lieferant, Adresse> colAdr;
	@FXML
	private TableColumn<Lieferant, String> colLiefTyp;
	@FXML
	private TableColumn<Lieferant, Timestamp> colDate;
	@FXML
	private Label lblProdOverview;
	@FXML
	private TableView<Produkt> tableProdOverview;
	@FXML
	private TableColumn<Produkt, Integer> colProdID;
	@FXML
	private TableColumn<Produkt, String> colProdName;
	@FXML
	private TableColumn<Produkt, String> colProdTyp;
	@FXML
	private TableColumn<Produkt, String> colHersteller;
	@FXML
	private Label lblLiefID;
	@FXML
	private Label lblProdID;
	@FXML
	private TextField liefID;
	@FXML
	private TextField prodID;
	@FXML
	private Button btnCreate;
	@FXML
	private Label lblAngebote;
	@FXML
	private TableView<Angebot> tableAngOverview;
	@FXML
	private TableColumn<Angebot, Integer> colAngID;
	@FXML
	private TableColumn<Angebot, Integer> colAngLiefID;
	@FXML
	private TableColumn<Angebot, Integer> colAngProdID;
	@FXML
	private TableColumn<Angebot, String> colAngProdTyp;
	@FXML
	private TableColumn<?, ?> colAngHersteller;
	@FXML
	private Button btnDelete;
	@FXML
	private Button btnSpeichern;
	@FXML
	private Button btnAbbrechen;
	@FXML
	private ToggleGroup produkt;
	@FXML
	private RadioButton radioProzessor;
	@FXML
	private RadioButton radioFestplatte;
	@FXML
	private RadioButton radioHaupt;
	@FXML
	private RadioButton radioGrafik;
	@FXML
	private RadioButton radioBS;

	private ObservableList<Lieferant> oblistLieferant = FXCollections.observableArrayList();
	private ObservableList<Produkt> oblistProdukt = FXCollections.observableArrayList();
	private ObservableList<Angebot> oblistAngebot = FXCollections.observableArrayList();
	private DBUtil dbu;
	private Produkt p1;
	private Lieferant l1;

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

	public void loadDatabaseLieferant() {
		final Connection connection = util.DBUtil.getConnection();
		final PreparedStatement stmt;
		final ResultSet rs;

		String query = "SELECT * FROM Lieferant";
		try {
			stmt = connection.prepareStatement(query);
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				l1 = new Lieferant(
						rs.getInt("ID"), rs.getString("Name"), new Adresse(rs.getString("Adresse"),
								rs.getString("Stadt"), rs.getInt("PLZ"), rs.getString("Land").toString()),
						rs.getString("Typ"), rs.getTimestamp("Timestamp"));
				oblistLieferant.add(l1);
			}
			stmt.close();
			rs.close();
			connection.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		colLiefID.setCellValueFactory(new PropertyValueFactory<>("iD"));
		colName.setCellValueFactory(new PropertyValueFactory<>("name"));
		colAdr.setCellValueFactory(new PropertyValueFactory<>("adresse"));
		colLiefTyp.setCellValueFactory(new PropertyValueFactory<>("typ"));
		colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
		tableLiefOverview.setItems(oblistLieferant);
	}

	public void loadDatabaseProdukt(String query) {
		final Connection connection = util.DBUtil.getConnection();
		final PreparedStatement stmt;
		final ResultSet rs;
		try {
			stmt = connection.prepareStatement(query);
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				// p1 = new Produkt(rs.getInt("ID"));
				p1 = new Produkt(rs.getInt("ID"), rs.getString("Typ"), rs.getString("Name"),
						rs.getString("Hersteller"));

				oblistProdukt.add(p1);
			}
			stmt.close();
			rs.close();
			connection.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		colProdID.setCellValueFactory(new PropertyValueFactory<>("ident"));
		// colProdID.setCellValueFactory(cellData -> cellData.getValue().getIdent());
		colProdTyp.setCellValueFactory(new PropertyValueFactory<>("typ"));
		colProdName.setCellValueFactory(new PropertyValueFactory<>("name"));
		colHersteller.setCellValueFactory(new PropertyValueFactory<>("hersteller"));

	}

	public void chooseProduct() {

		radioFestplatte.selectedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
				if (radioFestplatte.isSelected() == true) {
					oblistProdukt.removeAll(oblistProdukt);
					loadDatabaseProdukt("SELECT * from Produkte where Typ = 'Festplatte'");
					tableProdOverview.setItems(null);
					tableProdOverview.refresh();
					tableProdOverview.setItems(oblistProdukt);

				}

			}

		});
		radioProzessor.selectedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
				if (radioProzessor.isSelected() == true) {
					oblistProdukt.removeAll(oblistProdukt);
					loadDatabaseProdukt("SELECT * from Produkte where Typ = 'Prozessor'");
					tableProdOverview.setItems(null);
					tableProdOverview.refresh();
					tableProdOverview.setItems(oblistProdukt);

				}

			}

		});
		radioHaupt.selectedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
				if (radioHaupt.isSelected() == true) {
					oblistProdukt.removeAll(oblistProdukt);
					loadDatabaseProdukt("SELECT * from Produkte where Typ = 'Hauptspeicher'");
					tableProdOverview.setItems(null);
					tableProdOverview.refresh();
					tableProdOverview.setItems(oblistProdukt);

				}

			}

		});
		radioGrafik.selectedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
				if (radioGrafik.isSelected() == true) {
					oblistProdukt.removeAll(oblistProdukt);
					loadDatabaseProdukt("SELECT * from Produkte where Typ = 'Grafikkarte'");
					tableProdOverview.setItems(null);
					tableProdOverview.refresh();
					tableProdOverview.setItems(oblistProdukt);

				}

			}

		});
		radioBS.selectedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
				if (radioBS.isSelected() == true) {
					oblistProdukt.removeAll(oblistProdukt);
					loadDatabaseProdukt("SELECT * from Produkte where Typ = 'Betriebssystem'");
					tableProdOverview.setItems(null);
					tableProdOverview.refresh();
					tableProdOverview.setItems(oblistProdukt);

				}

			}

		});

	}

	public void handleAngebotErstellen() throws IndexOutOfBoundsException {
		int choiceLief = Integer.parseInt(liefID.getText());
		int choiceProd = Integer.parseInt(prodID.getText());
		for (int i = 0; i < oblistLieferant.size(); i++) {
			if (choiceLief == oblistLieferant.get(i).getID()) {
				for (int j = 0; j < oblistProdukt.size(); j++) {
					if (choiceProd == oblistProdukt.get(j).getIdent()) {
						System.out.println("Test");
						String comboID = liefID.getText() + prodID.getText();
						int combointID = Integer.valueOf(comboID);
						System.out.println(comboID);
						Angebot a1 = new Angebot(combointID, oblistLieferant.get(i).getID(),
								oblistProdukt.get(j).getIdent(), oblistProdukt.get(j).getTyp(),
								oblistProdukt.get(j).getHersteller());
						oblistAngebot.add(a1);
						tableAngOverview.setItems(oblistAngebot);
					}
				}
			} else {
				System.out.println("Error.");
			}
		}

		colAngID.setCellValueFactory(new PropertyValueFactory<>("angID"));
		colAngLiefID.setCellValueFactory(new PropertyValueFactory<>("lieferantID"));
		colAngProdID.setCellValueFactory(new PropertyValueFactory<>("produktID"));
		colAngProdTyp.setCellValueFactory(new PropertyValueFactory<>("produktTyp"));
		colAngHersteller.setCellValueFactory(new PropertyValueFactory<>("hersteller"));
	}
	//Speichern von den Angeboten in der Datenbank
	@FXML
	public void angebotSpeichern() {
		final Connection connection = util.DBUtil.getConnection();
		final PreparedStatement stmt;
		final ResultSet rs;
		try {
			String query = "INSERT INTO Angebote (`ID`, `ID_Lieferant`, `ID_Produkt`, `Produkt`, `Produkttyp`)"
					+ " VALUES ([value-3],[value-4],[value-5],[value-6],[value-7])";
			stmt = connection.prepareStatement(query);
			rs = stmt.executeQuery(query);

			while (rs.next()) {
		for (int i = 0; i < oblistAngebot.size(); i++) {
			Angebot a = oblistAngebot.get(i);
			
		}
			}
		}catch(Exception e) {
			
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		dbu = new DBUtil();
		loadDatabaseLieferant();
		chooseProduct();
		btnCreate.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				handleAngebotErstellen();

			}

		});
		btnDelete.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				//tableAngOverview.getSelectionModel().getSelectedItems().clear();
				tableAngOverview.getItems().removeAll(tableAngOverview.getSelectionModel().getSelectedItem());
				tableAngOverview.refresh();

			}

		});
	}
}