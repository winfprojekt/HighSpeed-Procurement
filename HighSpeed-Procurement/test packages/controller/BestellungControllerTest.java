package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import org.junit.*;
import static org.junit.Assert.*;

public class BestellungControllerTest {
	@Test
	public void testBestellungController_1()
		throws Exception {
		BestellungController result = new BestellungController();
		assertNotNull(result);
	}

	@Test
	public void testCreateRegBestellung_1()
		throws Exception {
		BestellungController fixture = new BestellungController();
		ActionEvent event = new ActionEvent();

		fixture.createRegBestellung(event);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at main.Main.set_pane(Main.java:90)
		//       at controller.BestellungController.createRegBestellung(BestellungController.java:128)
	}

	@Test
	public void testHandleAbmeldenButton_1()
		throws Exception {
		BestellungController fixture = new BestellungController();
		ActionEvent event = new ActionEvent();

		fixture.handleAbmeldenButton(event);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: javafx.scene.control.Control
		//       at javafx.scene.control.DialogPane.createContentLabel(DialogPane.java:166)
		//       at javafx.scene.control.DialogPane.<init>(DialogPane.java:217)
		//       at javafx.scene.control.Dialog.<init>(Dialog.java:478)
		//       at javafx.scene.control.Alert.<init>(Alert.java:245)
		//       at javafx.scene.control.Alert.<init>(Alert.java:223)
		//       at main.Main.close(Main.java:100)
		//       at controller.BestellungController.handleAbmeldenButton(BestellungController.java:122)
	}

	@Test
	public void testHandleBestButton_1()
		throws Exception {
		BestellungController fixture = new BestellungController();
		ActionEvent event = new ActionEvent();

		fixture.handleBestButton(event);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at main.Main.set_pane(Main.java:90)
		//       at controller.BestellungController.handleBestButton(BestellungController.java:102)
	}

	@Test
	public void testHandleEilBEstellung_1()
		throws Exception {
		BestellungController fixture = new BestellungController();
		ActionEvent event = new ActionEvent();

		fixture.handleEilBEstellung(event);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at main.Main.set_pane(Main.java:90)
		//       at controller.BestellungController.handleEilBEstellung(BestellungController.java:133)
	}

	@Test
	public void testHandleHilfeButton_1()
		throws Exception {
		BestellungController fixture = new BestellungController();
		ActionEvent event = new ActionEvent();

		fixture.handleHilfeButton(event);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at main.Main.set_pane(Main.java:90)
		//       at controller.BestellungController.handleHilfeButton(BestellungController.java:116)
	}

	@Test
	public void testHandleHomeButton_1()
		throws Exception {
		BestellungController fixture = new BestellungController();
		ActionEvent event = new ActionEvent();

		fixture.handleHomeButton(event);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at main.Main.set_pane(Main.java:90)
		//       at controller.BestellungController.handleHomeButton(BestellungController.java:90)
	}

	@Test
	public void testHandleProduktButton_1()
		throws Exception {
		BestellungController fixture = new BestellungController();
		ActionEvent event = new ActionEvent();

		fixture.handleProduktButton(event);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at main.Main.set_pane(Main.java:90)
		//       at controller.BestellungController.handleProduktButton(BestellungController.java:109)
	}

	@Test
	public void testInitialize_1()
		throws Exception {
		BestellungController fixture = new BestellungController();
		URL arg0 = new URL("");
		ResourceBundle arg1 = ResourceBundle.getBundle("");

		fixture.initialize(arg0, arg1);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.net.MalformedURLException: no protocol: 
		//       at java.net.URL.<init>(URL.java:586)
		//       at java.net.URL.<init>(URL.java:483)
		//       at java.net.URL.<init>(URL.java:432)
	}

	@Test
	public void testSaveBestellung_1()
		throws Exception {
		BestellungController fixture = new BestellungController();

		fixture.saveBestellung();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: javafx.scene.control.Control
		//       at javafx.scene.control.DialogPane.createContentLabel(DialogPane.java:166)
		//       at javafx.scene.control.DialogPane.<init>(DialogPane.java:217)
		//       at javafx.scene.control.Dialog.<init>(Dialog.java:478)
		//       at javafx.scene.control.Alert.<init>(Alert.java:245)
		//       at javafx.scene.control.Alert.<init>(Alert.java:223)
		//       at controller.BestellungController.saveBestellung(BestellungController.java:204)
	}

	@Test
	public void testSaveBestellung_2()
		throws Exception {
		BestellungController fixture = new BestellungController();

		fixture.saveBestellung();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: javafx.scene.control.Control
		//       at javafx.scene.control.DialogPane.createContentLabel(DialogPane.java:166)
		//       at javafx.scene.control.DialogPane.<init>(DialogPane.java:217)
		//       at javafx.scene.control.Dialog.<init>(Dialog.java:478)
		//       at javafx.scene.control.Alert.<init>(Alert.java:245)
		//       at javafx.scene.control.Alert.<init>(Alert.java:223)
		//       at controller.BestellungController.saveBestellung(BestellungController.java:204)
	}

	@Test
	public void testSaveBestellung_3()
		throws Exception {
		BestellungController fixture = new BestellungController();

		fixture.saveBestellung();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: javafx.scene.control.Control
		//       at javafx.scene.control.DialogPane.createContentLabel(DialogPane.java:166)
		//       at javafx.scene.control.DialogPane.<init>(DialogPane.java:217)
		//       at javafx.scene.control.Dialog.<init>(Dialog.java:478)
		//       at javafx.scene.control.Alert.<init>(Alert.java:245)
		//       at javafx.scene.control.Alert.<init>(Alert.java:223)
		//       at controller.BestellungController.saveBestellung(BestellungController.java:204)
	}

	@Test
	public void testSaveBestellung_4()
		throws Exception {
		BestellungController fixture = new BestellungController();

		fixture.saveBestellung();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: javafx.scene.control.Control
		//       at javafx.scene.control.DialogPane.createContentLabel(DialogPane.java:166)
		//       at javafx.scene.control.DialogPane.<init>(DialogPane.java:217)
		//       at javafx.scene.control.Dialog.<init>(Dialog.java:478)
		//       at javafx.scene.control.Alert.<init>(Alert.java:245)
		//       at javafx.scene.control.Alert.<init>(Alert.java:223)
		//       at controller.BestellungController.saveBestellung(BestellungController.java:204)
	}

	@Test
	public void testSaveBestellung_5()
		throws Exception {
		BestellungController fixture = new BestellungController();

		fixture.saveBestellung();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: javafx.scene.control.Control
		//       at javafx.scene.control.DialogPane.createContentLabel(DialogPane.java:166)
		//       at javafx.scene.control.DialogPane.<init>(DialogPane.java:217)
		//       at javafx.scene.control.Dialog.<init>(Dialog.java:478)
		//       at javafx.scene.control.Alert.<init>(Alert.java:245)
		//       at javafx.scene.control.Alert.<init>(Alert.java:223)
		//       at controller.BestellungController.saveBestellung(BestellungController.java:204)
	}

	@Test
	public void testSaveBestellung_6()
		throws Exception {
		BestellungController fixture = new BestellungController();

		fixture.saveBestellung();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: javafx.scene.control.Control
		//       at javafx.scene.control.DialogPane.createContentLabel(DialogPane.java:166)
		//       at javafx.scene.control.DialogPane.<init>(DialogPane.java:217)
		//       at javafx.scene.control.Dialog.<init>(Dialog.java:478)
		//       at javafx.scene.control.Alert.<init>(Alert.java:245)
		//       at javafx.scene.control.Alert.<init>(Alert.java:223)
		//       at controller.BestellungController.saveBestellung(BestellungController.java:204)
	}

	@Test
	public void testSaveBestellung_7()
		throws Exception {
		BestellungController fixture = new BestellungController();

		fixture.saveBestellung();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: javafx.scene.control.Control
		//       at javafx.scene.control.DialogPane.createContentLabel(DialogPane.java:166)
		//       at javafx.scene.control.DialogPane.<init>(DialogPane.java:217)
		//       at javafx.scene.control.Dialog.<init>(Dialog.java:478)
		//       at javafx.scene.control.Alert.<init>(Alert.java:245)
		//       at javafx.scene.control.Alert.<init>(Alert.java:223)
		//       at controller.BestellungController.saveBestellung(BestellungController.java:204)
	}

	@Test
	public void testSaveBestellung_8()
		throws Exception {
		BestellungController fixture = new BestellungController();

		fixture.saveBestellung();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: javafx.scene.control.Control
		//       at javafx.scene.control.DialogPane.createContentLabel(DialogPane.java:166)
		//       at javafx.scene.control.DialogPane.<init>(DialogPane.java:217)
		//       at javafx.scene.control.Dialog.<init>(Dialog.java:478)
		//       at javafx.scene.control.Alert.<init>(Alert.java:245)
		//       at javafx.scene.control.Alert.<init>(Alert.java:223)
		//       at controller.BestellungController.saveBestellung(BestellungController.java:204)
	}

	@Before
	public void setUp()
		throws Exception {
	}

	@After
	public void tearDown()
		throws Exception {
	}

	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(BestellungControllerTest.class);
	}
}