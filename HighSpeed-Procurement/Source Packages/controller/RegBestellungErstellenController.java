package controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import main.Main;
import model.Produkt.Produkt;
import model.Produktportfolio.Angebot;
import util.DBUtil;
import javafx.scene.control.Label;

import javafx.scene.control.RadioButton;

import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class RegBestellungErstellenController implements Initializable {
	@FXML
	private Label lblHeader;
	@FXML
	private TextField txtfieldBestName;
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
	private TableColumn<Angebot, String> colAngProdName;
	@FXML
	private TableColumn<Angebot, String> colAngHersteller;
	@FXML
	private Label lblTeilbestellungen;
	@FXML
	private Label lblAngebotID;
	@FXML
	private TextField textfieldAngID;
	@FXML
	private Label lblMenge;
	@FXML
	private TextField textfieldMenge;
	@FXML
	private TableView<?> tableTeilbestellungen;
	@FXML
	private TableColumn<?, ?> colTeilbestID;
	@FXML
	private TableColumn<?, ?> colTeilAngID;
	@FXML
	private TableColumn<?, ?> colTeilProdID;
	@FXML
	private TableColumn<?, ?> colTeilProdTyp;
	@FXML
	private TableColumn<?, ?> colTeilProdName;
	@FXML
	private TableColumn<?, ?> colTeilHerst;
	@FXML
	private TableColumn<?, ?> colTeilMenge;
	@FXML
	private Button btnHinzu;
	@FXML
	private Button btnBestErstellen;
	@FXML
	private Button btnAbbrechen;
	@FXML
	private RadioButton radioBS;
	@FXML
	private ToggleGroup produkt;
	@FXML
	private RadioButton radioGrafik;
	@FXML
	private RadioButton radioHaupt;
	@FXML
	private RadioButton radioFestplatte;
	@FXML
	private RadioButton radioProzessor;
	private ObservableList<Angebot> oblistAngebot = FXCollections.observableArrayList();
	private DBUtil dbu;

	@FXML
	private void handleAbbrechenAction(ActionEvent e) {
		// When "Abbrechen"-Button is
		// pressed the application routes the user back to the home screen (pane with
		// idx=1)
		Main.set_pane(5);
	}

	public void loadDatabaseAngebot(String query) {
		final Connection connection = util.DBUtil.getConnection();
		final PreparedStatement stmt;
		final ResultSet rs;
		try {
			stmt = connection.prepareStatement(query);
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				// p1 = new Produkt(rs.getInt("ID"));
				Angebot a1 = new Angebot(rs.getInt("ID"), rs.getInt("ID_Lieferant"), rs.getInt("ID_Produkt"),
						rs.getString("Produkttyp"), rs.getString("Produktname"), rs.getString("Hersteller"));

				oblistAngebot.add(a1);
			}
			stmt.close();
			rs.close();
			connection.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		colAngID.setCellValueFactory(new PropertyValueFactory<>("angID"));
		colAngLiefID.setCellValueFactory(new PropertyValueFactory<>("lieferantID"));
		colAngProdID.setCellValueFactory(new PropertyValueFactory<>("produktID"));
		colAngProdTyp.setCellValueFactory(new PropertyValueFactory<>("produktTyp"));
		colAngProdName.setCellValueFactory(new PropertyValueFactory<>("produktName"));
		colAngHersteller.setCellValueFactory(new PropertyValueFactory<>("hersteller"));

	}

	public void chooseAngebot() {

		radioFestplatte.selectedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
				if (radioFestplatte.isSelected() == true) {
					oblistAngebot.removeAll(oblistAngebot);
					loadDatabaseAngebot("SELECT * from Angebote where Produkttyp = 'Festplatte'");
					tableAngOverview.setItems(null);
					tableAngOverview.refresh();
					tableAngOverview.setItems(oblistAngebot);

				}

			}

		});
		radioProzessor.selectedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
				if (radioProzessor.isSelected() == true) {
					oblistAngebot.removeAll(oblistAngebot);
					loadDatabaseAngebot("SELECT * from Angebote where Produkttyp = 'Prozessor'");
					tableAngOverview.setItems(null);
					tableAngOverview.refresh();
					tableAngOverview.setItems(oblistAngebot);

				}

			}

		});
		radioHaupt.selectedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
				if (radioHaupt.isSelected() == true) {
					oblistAngebot.removeAll(oblistAngebot);
					loadDatabaseAngebot("SELECT * from Angebote where Produkttyp = 'Hauptspeicher'");
					tableAngOverview.setItems(null);
					tableAngOverview.refresh();
					tableAngOverview.setItems(oblistAngebot);
				}

			}

		});
		radioGrafik.selectedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
				if (radioGrafik.isSelected() == true) {
					oblistAngebot.removeAll(oblistAngebot);
					loadDatabaseAngebot("SELECT * from Angebote where Produkttyp = 'Grafikkarte'");
					tableAngOverview.setItems(null);
					tableAngOverview.refresh();
					tableAngOverview.setItems(oblistAngebot);

				}

			}

		});
		radioBS.selectedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
				if (radioBS.isSelected() == true) {
					oblistAngebot.removeAll(oblistAngebot);
					loadDatabaseAngebot("SELECT * from Angebote where Produkttyp = 'Betriebssystem'");
					tableAngOverview.setItems(null);
					tableAngOverview.refresh();
					tableAngOverview.setItems(oblistAngebot);

				}

			}

		});

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		dbu = new DBUtil();
		chooseAngebot();
		
	}

}
