package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.Node;
import javafx.scene.ParallelCamera;
import javafx.scene.control.Tooltip;
import org.junit.*;
import static org.junit.Assert.*;

public class LoginControllerTest {
	@Test
	public void testLoginController_1()
		throws Exception {
		LoginController result = new LoginController();
		assertNotNull(result);
	}

	@Test
	public void testInitialize_1()
		throws Exception {
		LoginController fixture = new LoginController();
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
	public void testIsInputValid_1()
		throws Exception {
		LoginController fixture = new LoginController();

		boolean result = fixture.isInputValid();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at controller.LoginController.isInputValid(LoginController.java:111)
		assertTrue(result);
	}

	@Test
	public void testIsInputValid_2()
		throws Exception {
		LoginController fixture = new LoginController();

		boolean result = fixture.isInputValid();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at controller.LoginController.isInputValid(LoginController.java:111)
		assertTrue(result);
	}

	@Test
	public void testIsInputValid_3()
		throws Exception {
		LoginController fixture = new LoginController();

		boolean result = fixture.isInputValid();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at controller.LoginController.isInputValid(LoginController.java:111)
		assertTrue(result);
	}

	@Test
	public void testIsInputValid_4()
		throws Exception {
		LoginController fixture = new LoginController();

		boolean result = fixture.isInputValid();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at controller.LoginController.isInputValid(LoginController.java:111)
		assertTrue(result);
	}

	@Test
	public void testIsInputValid_5()
		throws Exception {
		LoginController fixture = new LoginController();

		boolean result = fixture.isInputValid();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at controller.LoginController.isInputValid(LoginController.java:111)
		assertTrue(result);
	}

	@Test
	public void testLoadDatabaseData_1()
		throws Exception {
		LoginController fixture = new LoginController();

		fixture.loadDatabaseData();

	}

	@Test
	public void testLoadDatabaseData_2()
		throws Exception {
		LoginController fixture = new LoginController();

		fixture.loadDatabaseData();

	}

	@Test
	public void testLoadDatabaseData_3()
		throws Exception {
		LoginController fixture = new LoginController();

		fixture.loadDatabaseData();

	}

	@Test
	public void testLoadDatabaseData_4()
		throws Exception {
		LoginController fixture = new LoginController();

		fixture.loadDatabaseData();

	}

	@Test
	public void testLoadDatabaseData_5()
		throws Exception {
		LoginController fixture = new LoginController();

		fixture.loadDatabaseData();

	}

	@Test
	public void testLoadDatabaseData_6()
		throws Exception {
		LoginController fixture = new LoginController();

		fixture.loadDatabaseData();

	}

	@Test
	public void testLoadDatabaseData_7()
		throws Exception {
		LoginController fixture = new LoginController();

		fixture.loadDatabaseData();

	}

	@Test
	public void testLoadDatabaseData_8()
		throws Exception {
		LoginController fixture = new LoginController();

		fixture.loadDatabaseData();

	}

	@Test
	public void testSetTooltip_1()
		throws Exception {
		Tooltip tooltip = new Tooltip();
		Node node = new ParallelCamera();

		LoginController.setTooltip(tooltip, node);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.scene.control.Tooltip
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
		new org.junit.runner.JUnitCore().run(LoginControllerTest.class);
	}
}