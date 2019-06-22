package model.produkt;

import java.util.ArrayList;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.junit.*;
import static org.junit.Assert.*;

public class ProduktTest {
	@Test
	public void testProdukt_1()
		throws Exception {
		int ident = 1;
		String typ = "";
		String name = "";
		String hersteller = "";

		Produkt result = new Produkt(ident, typ, name, hersteller);

		assertNotNull(result);
		assertEquals("Produkt [iD=1, typ=, name=, hersteller=]", result.toString());
		assertEquals("", result.getName());
		assertEquals(null, result.objectToString());
		assertEquals("", result.getHersteller());
		assertEquals("", result.getTyp());
		assertEquals(1, result.getIdent());
	}

	@Test
	public void testCreate_1()
		throws Exception {
		Produkt fixture = new Produkt(1, "", "", "");

		fixture.create();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at model.produkt.Produkt.create(Produkt.java:121)
	}

	@Test
	public void testCreate_2()
		throws Exception {
		Produkt fixture = new Produkt(1, "", "", "");

		fixture.create();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at model.produkt.Produkt.create(Produkt.java:121)
	}

	@Test
	public void testCreate_3()
		throws Exception {
		Produkt fixture = new Produkt(1, "", "", "");

		fixture.create();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at model.produkt.Produkt.create(Produkt.java:121)
	}

	@Test
	public void testGetHersteller_1()
		throws Exception {
		Produkt fixture = new Produkt(1, "", "", "");

		String result = fixture.getHersteller();

		assertEquals("", result);
	}

	@Test
	public void testGetIdent_1()
		throws Exception {
		Produkt fixture = new Produkt(1, "", "", "");

		int result = fixture.getIdent();

		assertEquals(1, result);
	}

	@Test
	public void testGetName_1()
		throws Exception {
		Produkt fixture = new Produkt(1, "", "", "");

		String result = fixture.getName();

		assertEquals("", result);
	}

	@Test
	public void testGetTyp_1()
		throws Exception {
		Produkt fixture = new Produkt(1, "", "", "");

		String result = fixture.getTyp();

		assertEquals("", result);
	}

	@Test
	public void testObjectToString_1()
		throws Exception {
		Produkt fixture = new Produkt(1, "", "", "");

		String result = fixture.objectToString();

		assertEquals(null, result);
	}

	@Test
	public void testReadLayer_1()
		throws Exception {
		TextField[] textFields = new TextField[] {};

		Produkt result = Produkt.readLayer(textFields);

		assertEquals(null, result);
	}

	@Test
	public void testSetHersteller_1()
		throws Exception {
		Produkt fixture = new Produkt(1, "", "", "");
		String hersteller = "";

		fixture.setHersteller(hersteller);

	}

	@Test
	public void testSetIdent_1()
		throws Exception {
		Produkt fixture = new Produkt(1, "", "", "");
		int iD = 1;

		fixture.setIdent(iD);

	}

	@Test
	public void testSetName_1()
		throws Exception {
		Produkt fixture = new Produkt(1, "", "", "");
		String name = "";

		fixture.setName(name);

	}

	@Test
	public void testSetTyp_1()
		throws Exception {
		Produkt fixture = new Produkt(1, "", "", "");
		String typ = "";

		fixture.setTyp(typ);

	}

	@Test
	public void testToString_1()
		throws Exception {
		Produkt fixture = new Produkt(1, "", "", "");

		String result = fixture.toString();

		assertEquals("Produkt [iD=1, typ=, name=, hersteller=]", result);
	}

	@Test
	public void testUpdate_1()
		throws Exception {
		Produkt fixture = new Produkt(1, "", "", "");
		int iD = 1;

		fixture.update(iD);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at model.produkt.Produkt.update(Produkt.java:152)
	}

	@Test
	public void testUpdate_2()
		throws Exception {
		Produkt fixture = new Produkt(1, "", "", "");
		int iD = 1;

		fixture.update(iD);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at model.produkt.Produkt.update(Produkt.java:152)
	}

	@Test
	public void testUpdate_3()
		throws Exception {
		Produkt fixture = new Produkt(1, "", "", "");
		int iD = 1;

		fixture.update(iD);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at model.produkt.Produkt.update(Produkt.java:152)
	}

	@Test
	public void testWriteAll_1()
		throws Exception {
		ArrayList<Produkt> alleProdukte = new ArrayList();
		TableView<Produkt> table = new TableView();

		Produkt.writeAll(alleProdukte, table);

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
	public void testWriteAll_2()
		throws Exception {
		ArrayList<Produkt> alleProdukte = new ArrayList();
		TableView<Produkt> table = new TableView();

		Produkt.writeAll(alleProdukte, table);

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
	public void testWriteOne_1()
		throws Exception {
		Produkt fixture = new Produkt(1, "", "", "");
		TextField[] Textfelder = new TextField[] {};

		fixture.writeOne(Textfelder);

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
		new org.junit.runner.JUnitCore().run(ProduktTest.class);
	}
}