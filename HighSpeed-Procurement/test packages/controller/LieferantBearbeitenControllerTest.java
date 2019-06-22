package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import org.junit.*;
import static org.junit.Assert.*;

public class LieferantBearbeitenControllerTest {
	@Test
	public void testLieferantBearbeitenController_1()
		throws Exception {
		LieferantBearbeitenController result = new LieferantBearbeitenController();
		assertNotNull(result);
	}

	@Test
	public void testHandleAbbrechenAction_1()
		throws Exception {
		LieferantBearbeitenController fixture = new LieferantBearbeitenController();
		fixture.nameDisplay = new SimpleStringProperty();
		ActionEvent event = new ActionEvent();

		fixture.handleAbbrechenAction(event);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: javafx.scene.control.Control
		//       at javafx.scene.control.DialogPane.createContentLabel(DialogPane.java:166)
		//       at javafx.scene.control.DialogPane.<init>(DialogPane.java:217)
		//       at javafx.scene.control.Dialog.<init>(Dialog.java:478)
		//       at javafx.scene.control.Alert.<init>(Alert.java:245)
		//       at javafx.scene.control.Alert.<init>(Alert.java:223)
		//       at controller.LieferantBearbeitenController.handleAbbrechenAction(LieferantBearbeitenController.java:88)
	}

	@Test
	public void testHandleAbbrechenAction_2()
		throws Exception {
		LieferantBearbeitenController fixture = new LieferantBearbeitenController();
		fixture.nameDisplay = new SimpleStringProperty();
		ActionEvent event = new ActionEvent();

		fixture.handleAbbrechenAction(event);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: javafx.scene.control.Control
		//       at javafx.scene.control.DialogPane.createContentLabel(DialogPane.java:166)
		//       at javafx.scene.control.DialogPane.<init>(DialogPane.java:217)
		//       at javafx.scene.control.Dialog.<init>(Dialog.java:478)
		//       at javafx.scene.control.Alert.<init>(Alert.java:245)
		//       at javafx.scene.control.Alert.<init>(Alert.java:223)
		//       at controller.LieferantBearbeitenController.handleAbbrechenAction(LieferantBearbeitenController.java:88)
	}

	@Test
	public void testHandleSpeichernAction_1()
		throws Exception {
		LieferantBearbeitenController fixture = new LieferantBearbeitenController();
		fixture.nameDisplay = new SimpleStringProperty();
		ActionEvent event = new ActionEvent();

		fixture.handleSpeichernAction(event);

	}

	@Test
	public void testInitialize_1()
		throws Exception {
		LieferantBearbeitenController fixture = new LieferantBearbeitenController();
		fixture.nameDisplay = new SimpleStringProperty();
		URL arg0 = new URL("");
		ResourceBundle arg1 = ResourceBundle.getBundle("");

		fixture.initialize(arg0, arg1);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.net.MalformedURLException: no protocol: 
		//       at java.net.URL.<init>(URL.java:586)
		//       at java.net.URL.<init>(URL.java:483)
		//       at java.net.URL.<init>(URL.java:432)
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
		new org.junit.runner.JUnitCore().run(LieferantBearbeitenControllerTest.class);
	}
}