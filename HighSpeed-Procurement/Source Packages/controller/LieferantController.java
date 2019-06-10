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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import main.Main;
import model.Lieferant.Adresse;
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
	private Label lblAnlegen;
	@FXML
	private Label lblBearbeiten;
	@FXML
	private TableView<model.Lieferant.Lieferant> tableBearbeiten;;
	@FXML
	private TableColumn<model.Lieferant.Lieferant, Integer> colNum;
	@FXML
	private TableColumn<model.Lieferant.Lieferant, String> colName;
	@FXML
	private TableColumn<model.Lieferant.Lieferant, Adresse> colAdr;
	@FXML
	private TableColumn<model.Lieferant.Lieferant, String> colTyp;
	@FXML
	private TableColumn<model.Lieferant.Lieferant, Timestamp> colDate;

	public model.Lieferant.Lieferant lief;
	private ObservableList<model.Lieferant.Lieferant> oblist = FXCollections.observableArrayList();
	private Connection connection = util.DBUtil.getConnection();
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private DBUtil dbu;

	@FXML
	public void handleHomeButton(ActionEvent event) throws IOException {
		Main.set_pane(1);
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
	public void handleLiefAnlegenButton(ActionEvent event) throws IOException {

		Main.set_pane(3);

	}

	@FXML
	public void handleAbmeldenButton(ActionEvent event) throws IOException {
		Main.close();

	}

	@FXML
	public Lieferant handleLiefBearbeiten() throws IOException {

		/*
		 * tableBearbeiten.setOnMouseClicked((MouseEvent event) -> { if
		 * (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2)
		 * { int index = tableBearbeiten.getSelectionModel().getSelectedIndex(); lief =
		 * tableBearbeiten.getItems().get(index);
		 * 
		 * System.out.println(lief); }
		 * 
		 * });
		 */
		return lief;

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		dbu = new DBUtil();
		loadDatabaseData();
		tableBearbeiten.setOnMouseClicked(event -> {
			if (event.getClickCount() == 2) {
				Main.set_pane(4);
				lief = tableBearbeiten.getSelectionModel().getSelectedItem();
				controller.LieferantBearbeitenController lbc = new controller.LieferantBearbeitenController();
				lbc.nameDisplay.set(lief.getName());
				
			}
		});
	}
	/*
	 * .addListener(new ChangeListener<model.Lieferant.Lieferant>() {
	 * 
	 * @Override public void changed(ObservableValue<? extends
	 * model.Lieferant.Lieferant> observable, model.Lieferant.Lieferant oldValue,
	 * model.Lieferant.Lieferant newValue) {
	 * controller.LieferantBearbeitenController lbc = new
	 * controller.LieferantBearbeitenController();
	 * 
	 * lbc.nameDisplay.set(lief.getName()); Main.set_pane(4);
	 * 
	 * } });
	 */

	/*
	 * tableBearbeiten.setOnMouseClicked(event -> { if (event.getClickCount() == 2)
	 * { Main.set_pane(4); // get clicked Item (Lieferant)
	 * System.out.println(tableBearbeiten.getSelectionModel().getSelectedItem());
	 * 
	 * } });
	 */

	public void loadDatabaseData() {
		String query = "SELECT * FROM Lieferant";
		try {
			stmt = connection.prepareStatement(query);
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				lief = new model.Lieferant.Lieferant(
						rs.getInt("ID"), rs.getString("Name"), new Adresse(rs.getString("Adresse"),
								rs.getString("Stadt"), rs.getInt("PLZ"), rs.getString("Land").toString()),
						rs.getString("Typ"), rs.getTimestamp("Timestamp"));
				oblist.add(lief);
			}
			stmt.close();
			rs.close();
			connection.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		colNum.setCellValueFactory(new PropertyValueFactory<>("iD"));
		colName.setCellValueFactory(new PropertyValueFactory<>("name"));
		colAdr.setCellValueFactory(new PropertyValueFactory<>("adresse"));
		colTyp.setCellValueFactory(new PropertyValueFactory<>("typ"));
		colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
		tableBearbeiten.setItems(oblist);
	}

	public model.Lieferant.Lieferant getLief() {
		return lief;
	}

	public void setLief(model.Lieferant.Lieferant lief) {
		this.lief = lief;
	}

}
