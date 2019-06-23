package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import main.Main;
import util.BasePDFViewer;

public class HilfeController implements Initializable {
	@FXML
	private Button btnHeader;
	@FXML
	private Text userMailLogged;
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
	private Label lblHeaderHilfe;
	@FXML
	private Label lblKontakt;
	@FXML
	private Label lblMail;
	@FXML
	private Label lblTelefon;
	@FXML
	private Hyperlink suppHyper;
	@FXML
	private Hyperlink buchHyper;
	@FXML
	public void handleHomeButton(ActionEvent event) throws IOException {
		Main.set_pane(1);
	}

	@FXML
	private void handleLiefButtonAction(ActionEvent event) throws IOException {
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		buchHyper.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				BasePDFViewer bpdf = new BasePDFViewer("C:\\Users\\Denislav\\git\\HighSpeed-Procurement\\HighSpeed-Procurement\\source packages\\resources\\Benutzerhandbuch.pdf");

				
			}

		});

	}
}
