package main;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.junit.*;
import static org.junit.Assert.*;

public class MainTest {
	@Test
	public void testMain_1()
		throws Exception {
		Main result = new Main();
		assertNotNull(result);
	}

	@Test
	public void testClose_1()
		throws Exception {

		Main.close();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: javafx.scene.control.Control
		//       at javafx.scene.control.DialogPane.createContentLabel(DialogPane.java:166)
		//       at javafx.scene.control.DialogPane.<init>(DialogPane.java:217)
		//       at javafx.scene.control.Dialog.<init>(Dialog.java:478)
		//       at javafx.scene.control.Alert.<init>(Alert.java:245)
		//       at javafx.scene.control.Alert.<init>(Alert.java:223)
		//       at main.Main.close(Main.java:100)
	}

	@Test
	public void testClose_2()
		throws Exception {

		Main.close();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: javafx.scene.control.Control
		//       at javafx.scene.control.DialogPane.createContentLabel(DialogPane.java:166)
		//       at javafx.scene.control.DialogPane.<init>(DialogPane.java:217)
		//       at javafx.scene.control.Dialog.<init>(Dialog.java:478)
		//       at javafx.scene.control.Alert.<init>(Alert.java:245)
		//       at javafx.scene.control.Alert.<init>(Alert.java:223)
		//       at main.Main.close(Main.java:100)
	}

	@Test
	public void testGenerateUUID_1()
		throws Exception {

		String result = Main.generateUUID();

		assertEquals("db7943ef-370d-4aa0-8423-b0b3831ecf19", result);
	}

	@Test
	public void testGet_pane_1()
		throws Exception {
		int idx = 1;

		AnchorPane result = Main.get_pane(idx);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IndexOutOfBoundsException: Index: 1, Size: 0
		//       at java.util.ArrayList.rangeCheck(ArrayList.java:653)
		//       at java.util.ArrayList.get(ArrayList.java:429)
		//       at main.Main.get_pane(Main.java:85)
		assertNotNull(result);
	}

	@Test
	public void testMain_2()
		throws Exception {
		String[] args = new String[] {};

		Main.main(args);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalStateException: Application launch must not be called more than once
		//       at com.sun.javafx.application.LauncherImpl.launchApplication(LauncherImpl.java:162)
		//       at com.sun.javafx.application.LauncherImpl.launchApplication(LauncherImpl.java:143)
		//       at javafx.application.Application.launch(Application.java:252)
		//       at main.Main.main(Main.java:124)
	}

	@Test
	public void testResetPane_1()
		throws Exception {

		Main.resetPane();

	}

	@Test
	public void testSet_pane_1()
		throws Exception {
		int idx = 1;

		Main.set_pane(idx);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at main.Main.set_pane(Main.java:90)
	}

	@Test
	public void testStart_1()
		throws Exception {
		Main fixture = new Main();
		Stage primaryStage = new Stage();

		fixture.start(primaryStage);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.stage.Screen
		//       at javafx.stage.Window.<init>(Window.java:1179)
		//       at javafx.stage.Stage.<init>(Stage.java:236)
		//       at javafx.stage.Stage.<init>(Stage.java:224)
	}

	@Test
	public void testStart_2()
		throws Exception {
		Main fixture = new Main();
		Stage primaryStage = new Stage();

		fixture.start(primaryStage);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.stage.Screen
		//       at javafx.stage.Window.<init>(Window.java:1179)
		//       at javafx.stage.Stage.<init>(Stage.java:236)
		//       at javafx.stage.Stage.<init>(Stage.java:224)
	}

	@Test
	public void testStart_3()
		throws Exception {
		Main fixture = new Main();
		Stage primaryStage = new Stage();

		fixture.start(primaryStage);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.stage.Screen
		//       at javafx.stage.Window.<init>(Window.java:1179)
		//       at javafx.stage.Stage.<init>(Stage.java:236)
		//       at javafx.stage.Stage.<init>(Stage.java:224)
	}

	@Test
	public void testStart_4()
		throws Exception {
		Main fixture = new Main();
		Stage primaryStage = new Stage();

		fixture.start(primaryStage);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.stage.Screen
		//       at javafx.stage.Window.<init>(Window.java:1179)
		//       at javafx.stage.Stage.<init>(Stage.java:236)
		//       at javafx.stage.Stage.<init>(Stage.java:224)
	}

	@Test
	public void testStart_5()
		throws Exception {
		Main fixture = new Main();
		Stage primaryStage = new Stage();

		fixture.start(primaryStage);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.stage.Screen
		//       at javafx.stage.Window.<init>(Window.java:1179)
		//       at javafx.stage.Stage.<init>(Stage.java:236)
		//       at javafx.stage.Stage.<init>(Stage.java:224)
	}

	@Test
	public void testStart_6()
		throws Exception {
		Main fixture = new Main();
		Stage primaryStage = new Stage();

		fixture.start(primaryStage);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.stage.Screen
		//       at javafx.stage.Window.<init>(Window.java:1179)
		//       at javafx.stage.Stage.<init>(Stage.java:236)
		//       at javafx.stage.Stage.<init>(Stage.java:224)
	}

	@Test
	public void testStart_7()
		throws Exception {
		Main fixture = new Main();
		Stage primaryStage = new Stage();

		fixture.start(primaryStage);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.stage.Screen
		//       at javafx.stage.Window.<init>(Window.java:1179)
		//       at javafx.stage.Stage.<init>(Stage.java:236)
		//       at javafx.stage.Stage.<init>(Stage.java:224)
	}

	@Test
	public void testStart_8()
		throws Exception {
		Main fixture = new Main();
		Stage primaryStage = new Stage();

		fixture.start(primaryStage);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.stage.Screen
		//       at javafx.stage.Window.<init>(Window.java:1179)
		//       at javafx.stage.Stage.<init>(Stage.java:236)
		//       at javafx.stage.Stage.<init>(Stage.java:224)
	}

	@Test
	public void testStart_9()
		throws Exception {
		Main fixture = new Main();
		Stage primaryStage = new Stage();

		fixture.start(primaryStage);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.stage.Screen
		//       at javafx.stage.Window.<init>(Window.java:1179)
		//       at javafx.stage.Stage.<init>(Stage.java:236)
		//       at javafx.stage.Stage.<init>(Stage.java:224)
	}

	@Test
	public void testStart_10()
		throws Exception {
		Main fixture = new Main();
		Stage primaryStage = new Stage();

		fixture.start(primaryStage);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.stage.Screen
		//       at javafx.stage.Window.<init>(Window.java:1179)
		//       at javafx.stage.Stage.<init>(Stage.java:236)
		//       at javafx.stage.Stage.<init>(Stage.java:224)
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
		new org.junit.runner.JUnitCore().run(MainTest.class);
	}
}