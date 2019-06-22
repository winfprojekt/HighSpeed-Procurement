package controller;

import java.net.URL;
import java.util.ArrayList;
import model.bestellung.Teilbestellung;
import java.util.ResourceBundle;
import org.junit.*;
import static org.junit.Assert.*;

public class MailSendenControllerTest {
	@Test
	public void testMailSendenController_1()
		throws Exception {
		MailSendenController result = new MailSendenController();
		assertNotNull(result);
	}

	@Test
	public void testAbbrechen_1()
		throws Exception {
		MailSendenController fixture = new MailSendenController();
		fixture.db = new ArrayList();
		fixture.rbc = new RegBestellungErstellenController();

		fixture.abbrechen();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: javafx.scene.control.Control
		//       at javafx.scene.control.DialogPane.createContentLabel(DialogPane.java:166)
		//       at javafx.scene.control.DialogPane.<init>(DialogPane.java:217)
		//       at javafx.scene.control.Dialog.<init>(Dialog.java:478)
		//       at javafx.scene.control.Alert.<init>(Alert.java:245)
		//       at javafx.scene.control.Alert.<init>(Alert.java:223)
		//       at controller.MailSendenController.abbrechen(MailSendenController.java:109)
	}

	@Test
	public void testAbbrechen_2()
		throws Exception {
		MailSendenController fixture = new MailSendenController();
		fixture.db = new ArrayList();
		fixture.rbc = new RegBestellungErstellenController();

		fixture.abbrechen();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: javafx.scene.control.Control
		//       at javafx.scene.control.DialogPane.createContentLabel(DialogPane.java:166)
		//       at javafx.scene.control.DialogPane.<init>(DialogPane.java:217)
		//       at javafx.scene.control.Dialog.<init>(Dialog.java:478)
		//       at javafx.scene.control.Alert.<init>(Alert.java:245)
		//       at javafx.scene.control.Alert.<init>(Alert.java:223)
		//       at controller.MailSendenController.abbrechen(MailSendenController.java:109)
	}

	@Test
	public void testDisplay_1()
		throws Exception {
		MailSendenController fixture = new MailSendenController();
		fixture.db = new ArrayList();
		fixture.rbc = new RegBestellungErstellenController();
		String t1 = "";
		ArrayList<Teilbestellung> db = new ArrayList();

		fixture.display(t1, db);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at controller.MailSendenController.display(MailSendenController.java:73)
	}

	@Test
	public void testInitialize_1()
		throws Exception {
		MailSendenController fixture = new MailSendenController();
		fixture.db = new ArrayList();
		fixture.rbc = new RegBestellungErstellenController();
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
	public void testSenden_1()
		throws Exception {
		MailSendenController fixture = new MailSendenController();
		fixture.db = new ArrayList();
		fixture.rbc = new RegBestellungErstellenController();

		fixture.senden();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at controller.MailSendenController.senden(MailSendenController.java:125)
	}

	@Test
	public void testWriteStringToFile_1()
		throws Exception {
		MailSendenController fixture = new MailSendenController();
		fixture.db = new ArrayList();
		fixture.rbc = new RegBestellungErstellenController();
		String filepath = "";
		String stringInput = "";

		fixture.writeStringToFile(filepath, stringInput);

	}

	@Test
	public void testWriteStringToFile_2()
		throws Exception {
		MailSendenController fixture = new MailSendenController();
		fixture.db = new ArrayList();
		fixture.rbc = new RegBestellungErstellenController();
		String filepath = "";
		String stringInput = "";

		fixture.writeStringToFile(filepath, stringInput);

	}

	@Test
	public void testWriteStringToFile_3()
		throws Exception {
		MailSendenController fixture = new MailSendenController();
		fixture.db = new ArrayList();
		fixture.rbc = new RegBestellungErstellenController();
		String filepath = "";
		String stringInput = "";

		fixture.writeStringToFile(filepath, stringInput);

	}

	@Test
	public void testWriteStringToFile_4()
		throws Exception {
		MailSendenController fixture = new MailSendenController();
		fixture.db = new ArrayList();
		fixture.rbc = new RegBestellungErstellenController();
		String filepath = "";
		String stringInput = "";

		fixture.writeStringToFile(filepath, stringInput);

	}

	@Test
	public void testWriteStringToFile_5()
		throws Exception {
		MailSendenController fixture = new MailSendenController();
		fixture.db = new ArrayList();
		fixture.rbc = new RegBestellungErstellenController();
		String filepath = "";
		String stringInput = "";

		fixture.writeStringToFile(filepath, stringInput);

	}

	@Test
	public void testWriteStringToFile_6()
		throws Exception {
		MailSendenController fixture = new MailSendenController();
		fixture.db = new ArrayList();
		fixture.rbc = new RegBestellungErstellenController();
		String filepath = "";
		String stringInput = "";

		fixture.writeStringToFile(filepath, stringInput);

	}

	@Test
	public void testWriteStringToFile_7()
		throws Exception {
		MailSendenController fixture = new MailSendenController();
		fixture.db = new ArrayList();
		fixture.rbc = new RegBestellungErstellenController();
		String filepath = "";
		String stringInput = "";

		fixture.writeStringToFile(filepath, stringInput);

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
		new org.junit.runner.JUnitCore().run(MailSendenControllerTest.class);
	}
}