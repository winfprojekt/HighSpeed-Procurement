package controller;

import java.net.URL;
import model.lieferant.Lieferant;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import org.junit.*;
import static org.junit.Assert.*;
import com.mysql.cj.conf.HostInfo;
import com.mysql.cj.jdbc.ConnectionImpl;

public class LieferantControllerTest {
	@Test
	public void testLieferantController_1()
		throws Exception {
		LieferantController result = new LieferantController();
		assertNotNull(result);
	}

	@Test
	public void testGetLief_1()
		throws Exception {
		LieferantController fixture = new LieferantController();
		fixture.setLief(new Lieferant());

		Lieferant result = fixture.getLief();

		assertNotNull(result);
		assertEquals(null, result.getName());
		assertEquals(0, result.getID());
		assertEquals(null, result.getDate());
		assertEquals(null, result.getAdresse());
		assertEquals(null, result.getKontaktdaten());
		assertEquals(null, result.getTyp());
		assertEquals(null, result.getBankdaten());
	}

	@Test
	public void testHandleAbmeldenButton_1()
		throws Exception {
		LieferantController fixture = new LieferantController();
		fixture.setLief(new Lieferant());
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
		//       at controller.LieferantController.handleAbmeldenButton(LieferantController.java:120)
	}

	@Test
	public void testHandleBestButton_1()
		throws Exception {
		LieferantController fixture = new LieferantController();
		fixture.setLief(new Lieferant());
		ActionEvent event = new ActionEvent();

		fixture.handleBestButton(event);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at main.Main.set_pane(Main.java:90)
		//       at controller.LieferantController.handleBestButton(LieferantController.java:93)
	}

	@Test
	public void testHandleHilfeButton_1()
		throws Exception {
		LieferantController fixture = new LieferantController();
		fixture.setLief(new Lieferant());
		ActionEvent event = new ActionEvent();

		fixture.handleHilfeButton(event);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at main.Main.set_pane(Main.java:90)
		//       at controller.LieferantController.handleHilfeButton(LieferantController.java:107)
	}

	@Test
	public void testHandleHomeButton_1()
		throws Exception {
		LieferantController fixture = new LieferantController();
		fixture.setLief(new Lieferant());
		ActionEvent event = new ActionEvent();

		fixture.handleHomeButton(event);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at main.Main.set_pane(Main.java:90)
		//       at controller.LieferantController.handleHomeButton(LieferantController.java:87)
	}

	@Test
	public void testHandleLiefAnlegenButton_1()
		throws Exception {
		LieferantController fixture = new LieferantController();
		fixture.setLief(new Lieferant());
		ActionEvent event = new ActionEvent();

		fixture.handleLiefAnlegenButton(event);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at main.Main.set_pane(Main.java:90)
		//       at controller.LieferantController.handleLiefAnlegenButton(LieferantController.java:114)
	}

	@Test
	public void testHandleLiefBearbeiten_1()
		throws Exception {
		LieferantController fixture = new LieferantController();
		fixture.setLief(new Lieferant());

		Lieferant result = fixture.handleLiefBearbeiten();

		assertNotNull(result);
		assertEquals(null, result.getName());
		assertEquals(0, result.getID());
		assertEquals(null, result.getDate());
		assertEquals(null, result.getAdresse());
		assertEquals(null, result.getKontaktdaten());
		assertEquals(null, result.getTyp());
		assertEquals(null, result.getBankdaten());
	}

	@Test
	public void testHandleProduktButton_1()
		throws Exception {
		LieferantController fixture = new LieferantController();
		fixture.setLief(new Lieferant());
		ActionEvent event = new ActionEvent();

		fixture.handleProduktButton(event);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at main.Main.set_pane(Main.java:90)
		//       at controller.LieferantController.handleProduktButton(LieferantController.java:100)
	}

	@Test
	public void testInitialize_1()
		throws Exception {
		LieferantController fixture = new LieferantController();
		fixture.setLief(new Lieferant());
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
	public void testLoadDatabaseData_1()
		throws Exception {
		LieferantController fixture = new LieferantController();
		fixture.setLief(new Lieferant());

		fixture.loadDatabaseData();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at controller.LieferantController.loadDatabaseData(LieferantController.java:197)
	}

	@Test
	public void testLoadDatabaseData_2()
		throws Exception {
		LieferantController fixture = new LieferantController();
		fixture.setLief(new Lieferant());

		fixture.loadDatabaseData();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at controller.LieferantController.loadDatabaseData(LieferantController.java:197)
	}

	@Test
	public void testLoadDatabaseData_3()
		throws Exception {
		LieferantController fixture = new LieferantController();
		fixture.setLief(new Lieferant());

		fixture.loadDatabaseData();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at controller.LieferantController.loadDatabaseData(LieferantController.java:197)
	}

	@Test
	public void testLoadDatabaseData_4()
		throws Exception {
		LieferantController fixture = new LieferantController();
		fixture.setLief(new Lieferant());

		fixture.loadDatabaseData();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at controller.LieferantController.loadDatabaseData(LieferantController.java:197)
	}

	@Test
	public void testLoadDatabaseData_5()
		throws Exception {
		LieferantController fixture = new LieferantController();
		fixture.setLief(new Lieferant());

		fixture.loadDatabaseData();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at controller.LieferantController.loadDatabaseData(LieferantController.java:197)
	}

	@Test
	public void testLoadDatabaseData_6()
		throws Exception {
		LieferantController fixture = new LieferantController();
		fixture.setLief(new Lieferant());

		fixture.loadDatabaseData();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at controller.LieferantController.loadDatabaseData(LieferantController.java:197)
	}

	@Test
	public void testLoadDatabaseData_7()
		throws Exception {
		LieferantController fixture = new LieferantController();
		fixture.setLief(new Lieferant());

		fixture.loadDatabaseData();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at controller.LieferantController.loadDatabaseData(LieferantController.java:197)
	}

	@Test
	public void testLoadDatabaseData_8()
		throws Exception {
		LieferantController fixture = new LieferantController();
		fixture.setLief(new Lieferant());

		fixture.loadDatabaseData();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at controller.LieferantController.loadDatabaseData(LieferantController.java:197)
	}

	@Test
	public void testLoadDatabaseData_9()
		throws Exception {
		LieferantController fixture = new LieferantController();
		fixture.setLief(new Lieferant());

		fixture.loadDatabaseData();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at controller.LieferantController.loadDatabaseData(LieferantController.java:197)
	}

	@Test
	public void testLoadDatabaseData_10()
		throws Exception {
		LieferantController fixture = new LieferantController();
		fixture.setLief(new Lieferant());

		fixture.loadDatabaseData();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at controller.LieferantController.loadDatabaseData(LieferantController.java:197)
	}

	@Test
	public void testLoadRepeat_1()
		throws Exception {
		LieferantController fixture = new LieferantController();
		fixture.setLief(new Lieferant());
		Connection con = ConnectionImpl.getInstance(new HostInfo());

		fixture.loadRepeat(con);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at java.util.Hashtable.put(Hashtable.java:459)
		//       at java.util.Properties.setProperty(Properties.java:166)
		//       at com.mysql.cj.conf.HostInfo.exposeAsProperties(HostInfo.java:229)
		//       at com.mysql.cj.jdbc.ConnectionImpl.<init>(ConnectionImpl.java:391)
		//       at com.mysql.cj.jdbc.ConnectionImpl.getInstance(ConnectionImpl.java:240)
	}

	@Test
	public void testLoadRepeat_2()
		throws Exception {
		LieferantController fixture = new LieferantController();
		fixture.setLief(new Lieferant());
		Connection con = ConnectionImpl.getInstance(new HostInfo());

		fixture.loadRepeat(con);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at java.util.Hashtable.put(Hashtable.java:459)
		//       at java.util.Properties.setProperty(Properties.java:166)
		//       at com.mysql.cj.conf.HostInfo.exposeAsProperties(HostInfo.java:229)
		//       at com.mysql.cj.jdbc.ConnectionImpl.<init>(ConnectionImpl.java:391)
		//       at com.mysql.cj.jdbc.ConnectionImpl.getInstance(ConnectionImpl.java:240)
	}

	@Test
	public void testLoadRepeat_3()
		throws Exception {
		LieferantController fixture = new LieferantController();
		fixture.setLief(new Lieferant());
		Connection con = ConnectionImpl.getInstance(new HostInfo());

		fixture.loadRepeat(con);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at java.util.Hashtable.put(Hashtable.java:459)
		//       at java.util.Properties.setProperty(Properties.java:166)
		//       at com.mysql.cj.conf.HostInfo.exposeAsProperties(HostInfo.java:229)
		//       at com.mysql.cj.jdbc.ConnectionImpl.<init>(ConnectionImpl.java:391)
		//       at com.mysql.cj.jdbc.ConnectionImpl.getInstance(ConnectionImpl.java:240)
	}

	@Test
	public void testLoadRepeat_4()
		throws Exception {
		LieferantController fixture = new LieferantController();
		fixture.setLief(new Lieferant());
		Connection con = ConnectionImpl.getInstance(new HostInfo());

		fixture.loadRepeat(con);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at java.util.Hashtable.put(Hashtable.java:459)
		//       at java.util.Properties.setProperty(Properties.java:166)
		//       at com.mysql.cj.conf.HostInfo.exposeAsProperties(HostInfo.java:229)
		//       at com.mysql.cj.jdbc.ConnectionImpl.<init>(ConnectionImpl.java:391)
		//       at com.mysql.cj.jdbc.ConnectionImpl.getInstance(ConnectionImpl.java:240)
	}

	@Test
	public void testLoadRepeat_5()
		throws Exception {
		LieferantController fixture = new LieferantController();
		fixture.setLief(new Lieferant());
		Connection con = ConnectionImpl.getInstance(new HostInfo());

		fixture.loadRepeat(con);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at java.util.Hashtable.put(Hashtable.java:459)
		//       at java.util.Properties.setProperty(Properties.java:166)
		//       at com.mysql.cj.conf.HostInfo.exposeAsProperties(HostInfo.java:229)
		//       at com.mysql.cj.jdbc.ConnectionImpl.<init>(ConnectionImpl.java:391)
		//       at com.mysql.cj.jdbc.ConnectionImpl.getInstance(ConnectionImpl.java:240)
	}

	@Test
	public void testLoadRepeat_6()
		throws Exception {
		LieferantController fixture = new LieferantController();
		fixture.setLief(new Lieferant());
		Connection con = ConnectionImpl.getInstance(new HostInfo());

		fixture.loadRepeat(con);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at java.util.Hashtable.put(Hashtable.java:459)
		//       at java.util.Properties.setProperty(Properties.java:166)
		//       at com.mysql.cj.conf.HostInfo.exposeAsProperties(HostInfo.java:229)
		//       at com.mysql.cj.jdbc.ConnectionImpl.<init>(ConnectionImpl.java:391)
		//       at com.mysql.cj.jdbc.ConnectionImpl.getInstance(ConnectionImpl.java:240)
	}

	@Test
	public void testLoadRepeat_7()
		throws Exception {
		LieferantController fixture = new LieferantController();
		fixture.setLief(new Lieferant());
		Connection con = ConnectionImpl.getInstance(new HostInfo());

		fixture.loadRepeat(con);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at java.util.Hashtable.put(Hashtable.java:459)
		//       at java.util.Properties.setProperty(Properties.java:166)
		//       at com.mysql.cj.conf.HostInfo.exposeAsProperties(HostInfo.java:229)
		//       at com.mysql.cj.jdbc.ConnectionImpl.<init>(ConnectionImpl.java:391)
		//       at com.mysql.cj.jdbc.ConnectionImpl.getInstance(ConnectionImpl.java:240)
	}

	@Test
	public void testLoadRepeat_8()
		throws Exception {
		LieferantController fixture = new LieferantController();
		fixture.setLief(new Lieferant());
		Connection con = ConnectionImpl.getInstance(new HostInfo());

		fixture.loadRepeat(con);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at java.util.Hashtable.put(Hashtable.java:459)
		//       at java.util.Properties.setProperty(Properties.java:166)
		//       at com.mysql.cj.conf.HostInfo.exposeAsProperties(HostInfo.java:229)
		//       at com.mysql.cj.jdbc.ConnectionImpl.<init>(ConnectionImpl.java:391)
		//       at com.mysql.cj.jdbc.ConnectionImpl.getInstance(ConnectionImpl.java:240)
	}

	@Test
	public void testLoadRepeat_9()
		throws Exception {
		LieferantController fixture = new LieferantController();
		fixture.setLief(new Lieferant());
		Connection con = ConnectionImpl.getInstance(new HostInfo());

		fixture.loadRepeat(con);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at java.util.Hashtable.put(Hashtable.java:459)
		//       at java.util.Properties.setProperty(Properties.java:166)
		//       at com.mysql.cj.conf.HostInfo.exposeAsProperties(HostInfo.java:229)
		//       at com.mysql.cj.jdbc.ConnectionImpl.<init>(ConnectionImpl.java:391)
		//       at com.mysql.cj.jdbc.ConnectionImpl.getInstance(ConnectionImpl.java:240)
	}

	@Test
	public void testLoadRepeat_10()
		throws Exception {
		LieferantController fixture = new LieferantController();
		fixture.setLief(new Lieferant());
		Connection con = ConnectionImpl.getInstance(new HostInfo());

		fixture.loadRepeat(con);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at java.util.Hashtable.put(Hashtable.java:459)
		//       at java.util.Properties.setProperty(Properties.java:166)
		//       at com.mysql.cj.conf.HostInfo.exposeAsProperties(HostInfo.java:229)
		//       at com.mysql.cj.jdbc.ConnectionImpl.<init>(ConnectionImpl.java:391)
		//       at com.mysql.cj.jdbc.ConnectionImpl.getInstance(ConnectionImpl.java:240)
	}

	@Test
	public void testSetLief_1()
		throws Exception {
		LieferantController fixture = new LieferantController();
		fixture.setLief(new Lieferant());
		Lieferant lief = new Lieferant();

		fixture.setLief(lief);

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
		new org.junit.runner.JUnitCore().run(LieferantControllerTest.class);
	}
}