package controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import main.Main;
import model.Produkt.Produkt;
import model.Produktportfolio.Angebot;
import util.DBUtil;
import javafx.scene.control.Label;

import javafx.scene.control.RadioButton;

import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;
import model.Bestellung.*;

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
	private TableView<Teilbestellung> tableTeilbestellungen;
	@FXML
	private TableColumn<Teilbestellung, String> colTeilbestName;
	@FXML
	private TableColumn<Teilbestellung, Integer> colTeilbestID;
	@FXML
	private TableColumn<Teilbestellung, Integer> colTeilAngID;
	@FXML
	private TableColumn<Teilbestellung, Integer> colTeilProdID;
	@FXML
	private TableColumn<Teilbestellung, String> colTeilProdTyp;
	@FXML
	private TableColumn<Teilbestellung, String> colTeilProdName;
	@FXML
	private TableColumn<Teilbestellung, String> colTeilHerst;
	@FXML
	private TableColumn<Teilbestellung, Integer> colTeilMenge;
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
	private ObservableList<Teilbestellung> oblistTeilBest = FXCollections.observableArrayList();
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

	public void handleTeilbestellungHinzufügen() throws IndexOutOfBoundsException {
		int choiceAngID = Integer.parseInt(textfieldAngID.getText());
		int choiceMenge = Integer.parseInt(textfieldMenge.getText());
		String choiceName = txtfieldBestName.getText();
		boolean angebotValue = oblistAngebot.stream().filter(p -> p.getAngID() == choiceAngID).findFirst().isPresent();
		if (angebotValue == true && !textfieldMenge.getText().isEmpty() && !choiceName.isEmpty()) {
			for (int i = 0; i < oblistAngebot.size(); i++) {
				if (choiceAngID == oblistAngebot.get(i).getAngID()) {
					System.out.println("Test");
					Teilbestellung t1 = new Teilbestellung(i, choiceName, oblistAngebot.get(i).getAngID(),
							oblistAngebot.get(i).getProduktID(), oblistAngebot.get(i).getProduktTyp(),
							oblistAngebot.get(i).getProduktName(), oblistAngebot.get(i).getHersteller(), choiceMenge);
					oblistTeilBest.add(t1);
					tableTeilbestellungen.setItems(oblistTeilBest);
				}
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Fehler");
			alert.setHeaderText("Sie haben eine falsche Angebot-ID eingegeben!");
			alert.setContentText("Bitte geben Sie eine gültige Angebot-ID");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				alert.close();
			}
		}
		colTeilbestID.setCellValueFactory(new PropertyValueFactory<>("iD"));
		colTeilbestName.setCellValueFactory(new PropertyValueFactory<>("name"));
		colTeilAngID.setCellValueFactory(new PropertyValueFactory<>("angID"));
		colTeilProdID.setCellValueFactory(new PropertyValueFactory<>("prodID"));
		colTeilProdTyp.setCellValueFactory(new PropertyValueFactory<>("prodTyp"));
		colTeilProdName.setCellValueFactory(new PropertyValueFactory<>("prodName"));
		colTeilHerst.setCellValueFactory(new PropertyValueFactory<>("hersteller"));
		colTeilMenge.setCellValueFactory(new PropertyValueFactory<>("menge"));
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		dbu = new DBUtil();
		chooseAngebot();
		btnHinzu.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				handleTeilbestellungHinzufügen();

			}

		});

	}

}
