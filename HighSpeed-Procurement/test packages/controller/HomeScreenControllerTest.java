package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import org.junit.*;
import static org.junit.Assert.*;

public class HomeScreenControllerTest {
	@Test
	public void testHomeScreenController_1()
		throws Exception {
		HomeScreenController result = new HomeScreenController();
		assertNotNull(result);
	}

	@Test
	public void testHandleAbmeldenButton_1()
		throws Exception {
		HomeScreenController fixture = new HomeScreenController();
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
		//       at controller.HomeScreenController.handleAbmeldenButton(HomeScreenController.java:126)
	}

	@Test
	public void testHandleBestButton_1()
		throws Exception {
		HomeScreenController fixture = new HomeScreenController();
		ActionEvent event = new ActionEvent();

		fixture.handleBestButton(event);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at main.Main.set_pane(Main.java:90)
		//       at controller.HomeScreenController.handleBestButton(HomeScreenController.java:109)
	}

	@Test
	public void testHandleHilfeButton_1()
		throws Exception {
		HomeScreenController fixture = new HomeScreenController();
		ActionEvent event = new ActionEvent();

		fixture.handleHilfeButton(event);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at main.Main.set_pane(Main.java:90)
		//       at controller.HomeScreenController.handleHilfeButton(HomeScreenController.java:121)
	}

	@Test
	public void testHandleProduktButton_1()
		throws Exception {
		HomeScreenController fixture = new HomeScreenController();
		ActionEvent event = new ActionEvent();

		fixture.handleProduktButton(event);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at main.Main.set_pane(Main.java:90)
		//       at controller.HomeScreenController.handleProduktButton(HomeScreenController.java:115)
	}

	@Test
	public void testInitialize_1()
		throws Exception {
		HomeScreenController fixture = new HomeScreenController();
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
		HomeScreenController fixture = new HomeScreenController();

		fixture.loadDatabaseData();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at controller.HomeScreenController.loadDatabaseData(HomeScreenController.java:151)
	}

	@Test
	public void testLoadDatabaseData_2()
		throws Exception {
		HomeScreenController fixture = new HomeScreenController();

		fixture.loadDatabaseData();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at controller.HomeScreenController.loadDatabaseData(HomeScreenController.java:151)
	}

	@Test
	public void testLoadDatabaseData_3()
		throws Exception {
		HomeScreenController fixture = new HomeScreenController();

		fixture.loadDatabaseData();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at controller.HomeScreenController.loadDatabaseData(HomeScreenController.java:151)
	}

	@Test
	public void testLoadDatabaseData_4()
		throws Exception {
		HomeScreenController fixture = new HomeScreenController();

		fixture.loadDatabaseData();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at controller.HomeScreenController.loadDatabaseData(HomeScreenController.java:151)
	}

	@Test
	public void testLoadDatabaseData_5()
		throws Exception {
		HomeScreenController fixture = new HomeScreenController();

		fixture.loadDatabaseData();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at controller.HomeScreenController.loadDatabaseData(HomeScreenController.java:151)
	}

	@Test
	public void testLoadDatabaseData_6()
		throws Exception {
		HomeScreenController fixture = new HomeScreenController();

		fixture.loadDatabaseData();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at controller.HomeScreenController.loadDatabaseData(HomeScreenController.java:151)
	}

	@Test
	public void testLoadDatabaseData_7()
		throws Exception {
		HomeScreenController fixture = new HomeScreenController();

		fixture.loadDatabaseData();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at controller.HomeScreenController.loadDatabaseData(HomeScreenController.java:151)
	}

	@Test
	public void testLoadDatabaseData_8()
		throws Exception {
		HomeScreenController fixture = new HomeScreenController();

		fixture.loadDatabaseData();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at controller.HomeScreenController.loadDatabaseData(HomeScreenController.java:151)
	}

	@Test
	public void testLoadDatabaseData_9()
		throws Exception {
		HomeScreenController fixture = new HomeScreenController();

		fixture.loadDatabaseData();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at controller.HomeScreenController.loadDatabaseData(HomeScreenController.java:151)
	}

	@Test
	public void testLoadDatabaseData_10()
		throws Exception {
		HomeScreenController fixture = new HomeScreenController();

		fixture.loadDatabaseData();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at controller.HomeScreenController.loadDatabaseData(HomeScreenController.java:151)
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
		new org.junit.runner.JUnitCore().run(HomeScreenControllerTest.class);
	}
}