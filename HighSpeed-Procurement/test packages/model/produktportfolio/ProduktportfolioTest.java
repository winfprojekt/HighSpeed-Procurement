package model.produktportfolio;

import java.util.ArrayList;
import javafx.scene.control.TableView;
import org.junit.*;
import static org.junit.Assert.*;

public class ProduktportfolioTest {
	@Test
	public void testProduktportfolio_1()
		throws Exception {
		ArrayList<Angebot> angebote = new ArrayList();

		Produktportfolio result = new Produktportfolio(angebote);

		assertNotNull(result);
		assertEquals("", result.objectToString());
		assertEquals(0, result.getiD());
	}

	@Test
	public void testCreate_1()
		throws Exception {
		Produktportfolio fixture = new Produktportfolio(new ArrayList());
		fixture.setiD(1);

		fixture.create();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at model.produktportfolio.Produktportfolio.create(Produktportfolio.java:120)
	}

	@Test
	public void testCreate_2()
		throws Exception {
		Produktportfolio fixture = new Produktportfolio(new ArrayList());
		fixture.setiD(1);

		fixture.create();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at model.produktportfolio.Produktportfolio.create(Produktportfolio.java:120)
	}

	@Test
	public void testCreate_3()
		throws Exception {
		Produktportfolio fixture = new Produktportfolio(new ArrayList());
		fixture.setiD(1);

		fixture.create();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at model.produktportfolio.Produktportfolio.create(Produktportfolio.java:120)
	}

	@Test
	public void testGetAngebote_1()
		throws Exception {
		Produktportfolio fixture = new Produktportfolio(new ArrayList());
		fixture.setiD(1);

		ArrayList<Angebot> result = fixture.getAngebote();

		assertNotNull(result);
		assertEquals(0, result.size());
	}

	@Test
	public void testGetiD_1()
		throws Exception {
		Produktportfolio fixture = new Produktportfolio(new ArrayList());
		fixture.setiD(1);

		int result = fixture.getiD();

		assertEquals(1, result);
	}

	@Test
	public void testName_1()
		throws Exception {
		int ppID = 1;

		String result = Produktportfolio.name(ppID);

		assertEquals("Produktportfolio v1", result);
	}

	@Test
	public void testObjectToString_1()
		throws Exception {
		Produktportfolio fixture = new Produktportfolio(new ArrayList());
		fixture.setiD(1);

		String result = fixture.objectToString();

		assertEquals("", result);
	}

	@Test
	public void testObjectToString_2()
		throws Exception {
		Produktportfolio fixture = new Produktportfolio(new ArrayList());
		fixture.setiD(1);

		String result = fixture.objectToString();

		assertEquals("", result);
	}

	@Test
	public void testReadAllID_1()
		throws Exception {

		ArrayList<Integer> result = Produktportfolio.readAllID();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at model.produktportfolio.Produktportfolio.readAllID(Produktportfolio.java:51)
		assertNotNull(result);
	}

	@Test
	public void testReadAllID_2()
		throws Exception {

		ArrayList<Integer> result = Produktportfolio.readAllID();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at model.produktportfolio.Produktportfolio.readAllID(Produktportfolio.java:51)
		assertNotNull(result);
	}

	@Test
	public void testReadAllID_3()
		throws Exception {

		ArrayList<Integer> result = Produktportfolio.readAllID();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at model.produktportfolio.Produktportfolio.readAllID(Produktportfolio.java:51)
		assertNotNull(result);
	}

	@Test
	public void testReadAllID_4()
		throws Exception {

		ArrayList<Integer> result = Produktportfolio.readAllID();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at model.produktportfolio.Produktportfolio.readAllID(Produktportfolio.java:51)
		assertNotNull(result);
	}

	@Test
	public void testReadAllID_5()
		throws Exception {

		ArrayList<Integer> result = Produktportfolio.readAllID();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at model.produktportfolio.Produktportfolio.readAllID(Produktportfolio.java:51)
		assertNotNull(result);
	}

	@Test
	public void testReadAllID_6()
		throws Exception {

		ArrayList<Integer> result = Produktportfolio.readAllID();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at model.produktportfolio.Produktportfolio.readAllID(Produktportfolio.java:51)
		assertNotNull(result);
	}

	@Test
	public void testReadAllID_7()
		throws Exception {

		ArrayList<Integer> result = Produktportfolio.readAllID();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at model.produktportfolio.Produktportfolio.readAllID(Produktportfolio.java:51)
		assertNotNull(result);
	}

	@Test
	public void testReadAllID_8()
		throws Exception {

		ArrayList<Integer> result = Produktportfolio.readAllID();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at model.produktportfolio.Produktportfolio.readAllID(Produktportfolio.java:51)
		assertNotNull(result);
	}

	@Test
	public void testSetAngebote_1()
		throws Exception {
		Produktportfolio fixture = new Produktportfolio(new ArrayList());
		fixture.setiD(1);
		ArrayList<Angebot> angebote = new ArrayList();

		fixture.setAngebote(angebote);

	}

	@Test
	public void testSetiD_1()
		throws Exception {
		Produktportfolio fixture = new Produktportfolio(new ArrayList());
		fixture.setiD(1);
		int iD = 1;

		fixture.setiD(iD);

	}

	@Test
	public void testWriteAllNames_1()
		throws Exception {
		ArrayList<Integer> produktportfolioIDs = new ArrayList();
		TableView<String> tableChoosePP = new TableView();

		Produktportfolio.writeAllNames(produktportfolioIDs, tableChoosePP);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: javafx.scene.control.Control
		//       at java.lang.Class.getDeclaredConstructors0(Native Method)
		//       at java.lang.Class.privateGetDeclaredConstructors(Class.java:2671)
		//       at java.lang.Class.getConstructor0(Class.java:3075)
		//       at java.lang.Class.getDeclaredConstructor(Class.java:2178)
		//       at com.instantiations.eclipse.analysis.expression.model.InstanceCreationExpression.findConstructor(InstanceCreationExpression.java:572)
		//       at com.instantiations.eclipse.analysis.expression.model.InstanceCreationExpression.execute(InstanceCreationExpression.java:452)
		//       at com.instantiations.eclipse.analysis.expression.model.MethodInvocationExpression.execute(MethodInvocationExpression.java:568)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionRequest.execute(ExecutionRequest.java:286)
		//       at com.instantiations.assist.eclipse.junit.execution.communication.LocalExecutionClient$1.run(LocalExecutionClient.java:158)
		//       at java.lang.Thread.run(Thread.java:745)
	}

	@Test
	public void testWriteAllNames_2()
		throws Exception {
		ArrayList<Integer> produktportfolioIDs = new ArrayList();
		TableView<String> tableChoosePP = new TableView();

		Produktportfolio.writeAllNames(produktportfolioIDs, tableChoosePP);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: javafx.scene.control.Control
		//       at java.lang.Class.getDeclaredConstructors0(Native Method)
		//       at java.lang.Class.privateGetDeclaredConstructors(Class.java:2671)
		//       at java.lang.Class.getConstructor0(Class.java:3075)
		//       at java.lang.Class.getDeclaredConstructor(Class.java:2178)
		//       at com.instantiations.eclipse.analysis.expression.model.InstanceCreationExpression.findConstructor(InstanceCreationExpression.java:572)
		//       at com.instantiations.eclipse.analysis.expression.model.InstanceCreationExpression.execute(InstanceCreationExpression.java:452)
		//       at com.instantiations.eclipse.analysis.expression.model.MethodInvocationExpression.execute(MethodInvocationExpression.java:568)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionRequest.execute(ExecutionRequest.java:286)
		//       at com.instantiations.assist.eclipse.junit.execution.communication.LocalExecutionClient$1.run(LocalExecutionClient.java:158)
		//       at java.lang.Thread.run(Thread.java:745)
	}

	@Test
	public void testWriteAngebote_1()
		throws Exception {
		Produktportfolio fixture = new Produktportfolio(new ArrayList());
		fixture.setiD(1);

		fixture.writeAngebote();

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
		new org.junit.runner.JUnitCore().run(ProduktportfolioTest.class);
	}
}