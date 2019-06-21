package controller;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import main.Main;
import model.Bestellung.TeilCompare;
import model.Bestellung.Teilbestellung;
import model.Produktportfolio.Angebot;
import util.DBUtil;

public class EilBestellungErstellenController implements Initializable, Serializable {
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
	private TableColumn<Angebot, Double> colAngPreis;
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
	private TableColumn<Teilbestellung, Integer> colTeilLiefID;
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
	private TableColumn<Teilbestellung, Double> colTeilGesamtpreis;
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
	private Label lblName;
	@FXML
	private RadioButton radioProzessor;
	private ObservableList<Angebot> oblistAngebot = FXCollections.observableArrayList();
	private ObservableList<Teilbestellung> oblistTeilBest = FXCollections.observableArrayList();
	private DBUtil dbu;
	Teilbestellung t1;
	ArrayList<Teilbestellung> teilbestellungen = new ArrayList<Teilbestellung>();
	ArrayList<ArrayList> global = new ArrayList<ArrayList>();

	@FXML
	private void handleAbbrechenAction(ActionEvent e) {
		// When "Abbrechen"-Button is
		// pressed the application routes the user back to the home screen (pane with
		// idx=1)
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Prozess abbrechen");
		alert.setHeaderText("Der Prozess wird abgebrochen.");
		alert.setContentText("Wollen Sie wirklich den Prozess abbrechen?");
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			Main.set_pane(5);
			oblistAngebot.removeAll(oblistAngebot);
			oblistTeilBest.removeAll(oblistTeilBest);
			textfieldAngID.clear();
			textfieldMenge.clear();
			txtfieldBestName.clear();
		} else {
			alert.close();
		}

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
						rs.getString("Produkttyp"), rs.getString("Produktname"), rs.getString("Hersteller"),
						rs.getDouble("Einzelpreis"));

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
		colAngPreis.setCellValueFactory(new PropertyValueFactory<>("einzelpreis"));

	}

	public void chooseAngebot() {

		radioFestplatte.selectedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
				if (radioFestplatte.isSelected() == true) {
					oblistAngebot.removeAll(oblistAngebot);
					loadDatabaseAngebot(
							"SELECT * FROM Angebote AS a LEFT JOIN Lieferant AS l ON a.ID_Lieferant = l.ID WHERE a.Produkttyp = 'Festplatte' AND l.Typ LIKE '%Eil%'");
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
					loadDatabaseAngebot(
							"SELECT * FROM Angebote AS a LEFT JOIN Lieferant AS l ON a.ID_Lieferant = l.ID WHERE a.Produkttyp = 'Prozessor' AND l.Typ LIKE '%Eil%'");
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
					loadDatabaseAngebot(
							"SELECT * FROM Angebote AS a LEFT JOIN Lieferant AS l ON a.ID_Lieferant = l.ID WHERE a.Produkttyp = 'Hauptspeicher' AND l.Typ LIKE '%Eil%'");
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
					loadDatabaseAngebot(
							"SELECT * FROM Angebote AS a LEFT JOIN Lieferant AS l ON a.ID_Lieferant = l.ID WHERE a.Produkttyp = 'Grafikkarte' AND l.Typ LIKE '%Eil%'");
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
					loadDatabaseAngebot(
							"SELECT * FROM Angebote AS a LEFT JOIN Lieferant AS l ON a.ID_Lieferant = l.ID WHERE a.Produkttyp = 'Betriebssystem' AND l.Typ LIKE '%Eil%'");
					tableAngOverview.setItems(null);
					tableAngOverview.refresh();
					tableAngOverview.setItems(oblistAngebot);

				}

			}

		});
	}

	public void handleTeilbestellungHinzufügen() throws IndexOutOfBoundsException {
		if (!textfieldMenge.getText().isEmpty() && !textfieldAngID.getText().isEmpty()) {
			int choiceAngID = Integer.parseInt(textfieldAngID.getText());
			int choiceMenge = Integer.parseInt(textfieldMenge.getText());
			String choiceName = txtfieldBestName.getText();
			boolean angebotValue = oblistAngebot.stream().filter(p -> p.getAngID() == choiceAngID).findFirst()
					.isPresent();
			boolean bestellungValue = oblistTeilBest.stream().noneMatch(bestID -> oblistTeilBest.contains(bestID));
			if (angebotValue == true && bestellungValue && !textfieldMenge.getText().isEmpty()
					&& !choiceName.isEmpty()) {
				for (int i = 0; i < oblistAngebot.size(); i++) {
					if (choiceAngID == oblistAngebot.get(i).getAngID()) {
						double gesamtPreis = (double) (oblistAngebot.get(i).getEinzelpreis()) * choiceMenge;
						t1 = new Teilbestellung(Main.generateUUID(), choiceName, oblistAngebot.get(i).getAngID(),
								oblistAngebot.get(i).getLieferantID(), oblistAngebot.get(i).getProduktID(),
								oblistAngebot.get(i).getProduktTyp(), oblistAngebot.get(i).getProduktName(),
								oblistAngebot.get(i).getHersteller(), choiceMenge, gesamtPreis);
						oblistTeilBest.add(t1);
						tableTeilbestellungen.setItems(oblistTeilBest);
						textfieldAngID.clear();
						textfieldMenge.clear();
						txtfieldBestName.clear();
					}
				}
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Fehler");
				alert.setHeaderText("Bitte füllen Sie alle Eingabefelder aus!");
				alert.setContentText("Bitte geben Sie eine gültige Angebot-ID und den Namen der Bestellung an!");
				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {
					alert.close();
				}
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Fehler");
			alert.setHeaderText("Bitte füllen Sie alle Eingabefelder aus!");
			alert.setContentText("Bitte geben Sie eine gültige Lieferant-/ und Produkt-ID und den Einzelpreis ein!");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				alert.close();
			}
		}
		colTeilbestID.setCellValueFactory(new PropertyValueFactory<>("bestUUID"));
		colTeilbestName.setCellValueFactory(new PropertyValueFactory<>("name"));
		colTeilAngID.setCellValueFactory(new PropertyValueFactory<>("angID"));
		colTeilLiefID.setCellValueFactory(new PropertyValueFactory<>("liefID"));
		colTeilProdID.setCellValueFactory(new PropertyValueFactory<>("prodID"));
		colTeilProdTyp.setCellValueFactory(new PropertyValueFactory<>("prodTyp"));
		colTeilProdName.setCellValueFactory(new PropertyValueFactory<>("prodName"));
		colTeilHerst.setCellValueFactory(new PropertyValueFactory<>("hersteller"));
		colTeilMenge.setCellValueFactory(new PropertyValueFactory<>("menge"));
		colTeilGesamtpreis.setCellValueFactory(new PropertyValueFactory<>("gesamtpreis"));
	}

	/**
	 * @param filepath    - Where the file is saved (locally) Example:
	 *                    "C:\\Users\\Denislav\\Desktop\\output.txt"
	 * @param stringInput - The String input to be saved Example: "Test"
	 */
	public void writeStringToFile(String filepath, String stringInput) {
		try {
			String stringOutput = "";
			OutputStream output = new FileOutputStream(filepath);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] b = stringInput.getBytes("ISO-8859-1");
			baos.write(b);
			stringOutput = baos.toString("UTF-8");
			baos.writeTo(output);
			output.close();
			System.out.println("Erfolgreich gespeichert!");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// ArrayList mit Teilbestellungen
	public ArrayList<Teilbestellung> createBestellung() {

		teilbestellungen.addAll(oblistTeilBest);

		return teilbestellungen;

	}

	// ArrayLists mit Teilbestellungen (sortiert nach Lieferant)
	public void createBestellungLieferant() {
		ArrayList<Teilbestellung> liefTeilBestellung = new ArrayList<Teilbestellung>();
		liefTeilBestellung.addAll(oblistTeilBest);

		Collections.sort(liefTeilBestellung, new TeilCompare());
		System.out.println("Sortiert  " + liefTeilBestellung);

		createTeilList(liefTeilBestellung);

		System.out.println("Global ArrayList" + global);

		feedMail(global);

	}

	public void createTeilList(ArrayList<Teilbestellung> o1) {

		if (o1.size() == 0) {

			System.out.println("Array Finished");

		} else {
			Integer start = o1.get(0).getLiefID();
			int i = 0;

			while (o1.get(0).getLiefID() == o1.get(i).getLiefID()) {
				i++;

				if (o1.size() == i) {
					break;
				}

			}
			ArrayList<Teilbestellung> splitter = new ArrayList<Teilbestellung>(o1.subList(0, i));
			System.out.println(i);
			o1.subList(0, i).clear();

			global.add(splitter);

			createTeilList(o1);

		}

	}

	public void feedMail(ArrayList<ArrayList> o) {
		String output = "";
		ArrayList<Teilbestellung> db = new ArrayList<Teilbestellung>();

		for (int i = 0; i < o.size(); i++) {
			ArrayList<Teilbestellung> tb = new ArrayList<Teilbestellung>();
			tb = o.get(i);

			output = "";
			db.clear();

			for (int x = 0; x < tb.size(); x++) {
				System.out.println("Size " + tb.size());
				System.out.println("Count " + x);

				output += "\n" + tb.get(x).getTeilStrin();
				db.add(tb.get(i));

			}

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/controller/MailSendenView.fxml"));
			try {
				Parent root = loader.load();

				MailSendenController MS = loader.getController();
				MS.display(output, db);

				Stage stage = new Stage();
				stage.setScene(new Scene(root));
				stage.show();

			} catch (IOException e) { // TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void saveBestellung() {
		final Connection connection = util.DBUtil.getConnection();
		PreparedStatement stmt;
		try {
			int i;
			String bestName;
			String teilID;
			int angID;
			int liefID;
			int prodID;
			String prodTyp;
			String prodHerst;
			String prodName;
			String bestTyp;
			int menge;
			double gesamtpreis;
			if (oblistTeilBest.isEmpty() == false) {
				for (i = 0; i < oblistTeilBest.size(); i++) {
					Teilbestellung t = oblistTeilBest.get(i);
					teilID = t.getBestUUID();
					bestName = t.getName();
					angID = t.getAngID();
					liefID = t.getLiefID();
					prodID = t.getProdID();
					prodTyp = t.getProdTyp();
					prodName = t.getProdName();
					prodHerst = t.getHersteller();
					menge = t.getMenge();
					gesamtpreis = t.getGesamtpreis();
					bestTyp = "Eilbestellung";
					String query = "INSERT INTO Teilbestellungen (UUID,Name,Angebot_ID,Lieferant_ID,Produkt_ID,Produkttyp,Produktname,Hersteller,Menge,Gesamtpreis,Typ, Status)"
							+ " VALUES ('" + teilID + "','" + bestName + "', " + angID + "," + liefID + "," + prodID
							+ ",'" + prodTyp + "','" + prodName + "','" + prodHerst + "'," + menge + "," + gesamtpreis
							+ ",'" + bestTyp + "'," + " 'in Bearbeitung' " + ")";
					stmt = connection.prepareStatement(query);
					stmt.executeUpdate(query);

				}

			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Fehler");
				alert.setHeaderText("Sie haben keine Bestellungen erfasst!");
				alert.setContentText("Bitte erfassen Sie eine oder mehrere Bestellungen!");
				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {
					alert.close();
					textfieldAngID.clear();
					textfieldMenge.clear();
					txtfieldBestName.clear();
				}

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		chooseAngebot();
		btnHinzu.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				handleTeilbestellungHinzufügen();

			}

		});
		btnBestErstellen.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				createBestellung();
				saveBestellung();
				createBestellungLieferant();

			}

		});
		tableAngOverview.refresh();
		tableTeilbestellungen.refresh();

	}

}
