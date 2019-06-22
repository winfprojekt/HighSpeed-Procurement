package controller;

import javafx.event.ActionEvent;
import org.junit.*;
import static org.junit.Assert.*;

public class HilfeControllerTest {
	@Test
	public void testHandleAbmeldenButton_1()
		throws Exception {
		HilfeController fixture = new HilfeController();
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
		//       at controller.HilfeController.handleAbmeldenButton(HilfeController.java:76)
	}

	@Test
	public void testHandleBestButton_1()
		throws Exception {
		HilfeController fixture = new HilfeController();
		ActionEvent event = new ActionEvent();

		fixture.handleBestButton(event);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at main.Main.set_pane(Main.java:90)
		//       at controller.HilfeController.handleBestButton(HilfeController.java:56)
	}

	@Test
	public void testHandleHilfeButton_1()
		throws Exception {
		HilfeController fixture = new HilfeController();
		ActionEvent event = new ActionEvent();

		fixture.handleHilfeButton(event);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at main.Main.set_pane(Main.java:90)
		//       at controller.HilfeController.handleHilfeButton(HilfeController.java:70)
	}

	@Test
	public void testHandleHomeButton_1()
		throws Exception {
		HilfeController fixture = new HilfeController();
		ActionEvent event = new ActionEvent();

		fixture.handleHomeButton(event);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at main.Main.set_pane(Main.java:90)
		//       at controller.HilfeController.handleHomeButton(HilfeController.java:44)
	}

	@Test
	public void testHandleProduktButton_1()
		throws Exception {
		HilfeController fixture = new HilfeController();
		ActionEvent event = new ActionEvent();

		fixture.handleProduktButton(event);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at main.Main.set_pane(Main.java:90)
		//       at controller.HilfeController.handleProduktButton(HilfeController.java:63)
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
		new org.junit.runner.JUnitCore().run(HilfeControllerTest.class);
	}
}