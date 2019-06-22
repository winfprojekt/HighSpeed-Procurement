package model.lieferant;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.junit.*;
import static org.junit.Assert.*;

public class LieferantTest {
	@Test
	public void testLieferant_1()
		throws Exception {

		Lieferant result = new Lieferant();

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
	public void testLieferant_2()
		throws Exception {
		Adresse adresse = new Adresse("", "", 1, "");
		Kontaktdaten kontaktdaten = new Kontaktdaten("", "");
		Bankdaten bankdaten = new Bankdaten("", "", "", 1);
		String typ = "";

		Lieferant result = new Lieferant(adresse, kontaktdaten, bankdaten, typ);

		assertNotNull(result);
		assertEquals(null, result.getName());
		assertEquals(0, result.getID());
		assertEquals(null, result.getDate());
		assertEquals("", result.getTyp());
	}

	@Test
	public void testLieferant_3()
		throws Exception {
		int id = 1;
		String name = "";
		Adresse adresse = new Adresse("", "", 1, "");
		String typ = "";
		Timestamp date = new Timestamp(1L);

		Lieferant result = new Lieferant(id, name, adresse, typ, date);

		assertNotNull(result);
		assertEquals("", result.getName());
		assertEquals(1, result.getID());
		assertEquals(null, result.getKontaktdaten());
		assertEquals("", result.getTyp());
		assertEquals(null, result.getBankdaten());
	}

	@Test
	public void testLieferant_4()
		throws Exception {
		int iD = 1;
		Adresse adresse = new Adresse("", "", 1, "");
		Kontaktdaten kontaktdaten = new Kontaktdaten("", "");
		Bankdaten bankdaten = new Bankdaten("", "", "", 1);
		String typ = "";

		Lieferant result = new Lieferant(iD, adresse, kontaktdaten, bankdaten, typ);

		assertNotNull(result);
		assertEquals(null, result.getName());
		assertEquals(1, result.getID());
		assertEquals(null, result.getDate());
		assertEquals("", result.getTyp());
	}

	@Test
	public void testCreate_1()
		throws Exception {
		Lieferant fixture = new Lieferant(1, "", new Adresse("", "", 1, ""), "", new Timestamp(1L));
		fixture.setBankdaten(new Bankdaten("", "", "", 1));
		fixture.setKontaktdaten(new Kontaktdaten("", ""));

		fixture.create();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at model.lieferant.Lieferant.create(Lieferant.java:330)
	}

	@Test
	public void testCreate_2()
		throws Exception {
		Lieferant fixture = new Lieferant(1, "", new Adresse("", "", 1, ""), "", new Timestamp(1L));
		fixture.setBankdaten(new Bankdaten("", "", "", 1));
		fixture.setKontaktdaten(new Kontaktdaten("", ""));

		fixture.create();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at model.lieferant.Lieferant.create(Lieferant.java:330)
	}

	@Test
	public void testCreate_3()
		throws Exception {
		Lieferant fixture = new Lieferant(1, "", new Adresse("", "", 1, ""), "", new Timestamp(1L));
		fixture.setBankdaten(new Bankdaten("", "", "", 1));
		fixture.setKontaktdaten(new Kontaktdaten("", ""));

		fixture.create();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at model.lieferant.Lieferant.create(Lieferant.java:330)
	}

	@Test
	public void testGetAdresse_1()
		throws Exception {
		Lieferant fixture = new Lieferant(1, "", new Adresse("", "", 1, ""), "", new Timestamp(1L));
		fixture.setBankdaten(new Bankdaten("", "", "", 1));
		fixture.setKontaktdaten(new Kontaktdaten("", ""));

		Adresse result = fixture.getAdresse();

		assertNotNull(result);
		assertEquals(" , , 1  ", result.toString());
		assertEquals(null, result.getName());
		assertEquals("", result.getStrasseUndNummer());
		assertEquals("Adresse [name=null, strasseUndNummer=, stadt=, postleitzahl=1, land=]", result.toString1());
		assertEquals("", result.getStadt());
		assertEquals("", result.getLand());
		assertEquals(1, result.getPostleitzahl());
	}

	@Test
	public void testGetBankdaten_1()
		throws Exception {
		Lieferant fixture = new Lieferant(1, "", new Adresse("", "", 1, ""), "", new Timestamp(1L));
		fixture.setBankdaten(new Bankdaten("", "", "", 1));
		fixture.setKontaktdaten(new Kontaktdaten("", ""));

		Bankdaten result = fixture.getBankdaten();

		assertNotNull(result);
		assertEquals("Bankdaten [bank=, iBAN=, bicSwift=, steuernummer=1]", result.toString());
		assertEquals("", result.getiBAN());
		assertEquals("", result.getBicSwift());
		assertEquals(1, result.getSteuernummer());
		assertEquals("", result.getBank());
	}

	@Test
	public void testGetDate_1()
		throws Exception {
		Lieferant fixture = new Lieferant(1, "", new Adresse("", "", 1, ""), "", new Timestamp(1L));
		fixture.setBankdaten(new Bankdaten("", "", "", 1));
		fixture.setKontaktdaten(new Kontaktdaten("", ""));

		Timestamp result = fixture.getDate();

		assertNotNull(result);
		assertEquals(DateFormat.getInstance().format(new Date(1L)), DateFormat.getInstance().format(result));
		assertEquals(1L, result.getTime());
	}

	@Test
	public void testGetID_1()
		throws Exception {
		Lieferant fixture = new Lieferant(1, "", new Adresse("", "", 1, ""), "", new Timestamp(1L));
		fixture.setBankdaten(new Bankdaten("", "", "", 1));
		fixture.setKontaktdaten(new Kontaktdaten("", ""));

		int result = fixture.getID();

		assertEquals(1, result);
	}

	@Test
	public void testGetKontaktdaten_1()
		throws Exception {
		Lieferant fixture = new Lieferant(1, "", new Adresse("", "", 1, ""), "", new Timestamp(1L));
		fixture.setBankdaten(new Bankdaten("", "", "", 1));
		fixture.setKontaktdaten(new Kontaktdaten("", ""));

		Kontaktdaten result = fixture.getKontaktdaten();

		assertNotNull(result);
		assertEquals("Kontaktdaten [email=, telefonnummer=]", result.toString());
		assertEquals("", result.getEmail());
		assertEquals("", result.getTelefonnummer());
	}

	@Test
	public void testGetName_1()
		throws Exception {
		Lieferant fixture = new Lieferant(1, "", new Adresse("", "", 1, ""), "", new Timestamp(1L));
		fixture.setBankdaten(new Bankdaten("", "", "", 1));
		fixture.setKontaktdaten(new Kontaktdaten("", ""));

		String result = fixture.getName();

		assertEquals("", result);
	}

	@Test
	public void testGetTyp_1()
		throws Exception {
		Lieferant fixture = new Lieferant(1, "", new Adresse("", "", 1, ""), "", new Timestamp(1L));
		fixture.setBankdaten(new Bankdaten("", "", "", 1));
		fixture.setKontaktdaten(new Kontaktdaten("", ""));

		String result = fixture.getTyp();

		assertEquals("", result);
	}

	@Test
	public void testReadAll_1()
		throws Exception {

		ArrayList<Lieferant> result = Lieferant.readAll();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at model.lieferant.Lieferant.readAll(Lieferant.java:150)
		assertNotNull(result);
	}

	@Test
	public void testReadAll_2()
		throws Exception {

		ArrayList<Lieferant> result = Lieferant.readAll();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at model.lieferant.Lieferant.readAll(Lieferant.java:150)
		assertNotNull(result);
	}

	@Test
	public void testReadAll_3()
		throws Exception {

		ArrayList<Lieferant> result = Lieferant.readAll();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at model.lieferant.Lieferant.readAll(Lieferant.java:150)
		assertNotNull(result);
	}

	@Test
	public void testReadAll_4()
		throws Exception {

		ArrayList<Lieferant> result = Lieferant.readAll();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at model.lieferant.Lieferant.readAll(Lieferant.java:150)
		assertNotNull(result);
	}

	@Test
	public void testReadAll_5()
		throws Exception {

		ArrayList<Lieferant> result = Lieferant.readAll();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at model.lieferant.Lieferant.readAll(Lieferant.java:150)
		assertNotNull(result);
	}

	@Test
	public void testReadAll_6()
		throws Exception {

		ArrayList<Lieferant> result = Lieferant.readAll();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at model.lieferant.Lieferant.readAll(Lieferant.java:150)
		assertNotNull(result);
	}

	@Test
	public void testReadLayer_1()
		throws Exception {
		TextField[] textfelder = new TextField[] {null, new TextField(), new TextField(), new TextField(), new TextField(), new TextField(), new TextField(), new TextField(), new TextField(), new TextField(), new TextField(), new TextField()};

		Lieferant result = Lieferant.readLayer(textfelder);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.scene.control.TextField
		assertNotNull(result);
	}

	@Test
	public void testReadLayer_2()
		throws Exception {
		TextField[] textfelder = new TextField[] {null, new TextField(), new TextField(), new TextField()};

		Lieferant result = Lieferant.readLayer(textfelder);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.scene.control.TextField
		assertNotNull(result);
	}

	@Test
	public void testReadLayer_3()
		throws Exception {
		TextField[] textfelder = new TextField[] {null, new TextField(), new TextField(), new TextField(), new TextField(), new TextField(), new TextField(), new TextField(), new TextField(), new TextField(), new TextField()};

		Lieferant result = Lieferant.readLayer(textfelder);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.scene.control.TextField
		assertNotNull(result);
	}

	@Test
	public void testReadOne_1()
		throws Exception {
		int iD = 1;

		Lieferant result = Lieferant.readOne(iD);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at model.lieferant.Lieferant.readOne(Lieferant.java:196)
		assertNotNull(result);
	}

	@Test
	public void testReadOne_2()
		throws Exception {
		int iD = 1;

		Lieferant result = Lieferant.readOne(iD);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at model.lieferant.Lieferant.readOne(Lieferant.java:196)
		assertNotNull(result);
	}

	@Test
	public void testReadOne_3()
		throws Exception {
		int iD = 1;

		Lieferant result = Lieferant.readOne(iD);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at model.lieferant.Lieferant.readOne(Lieferant.java:196)
		assertNotNull(result);
	}

	@Test
	public void testReadOne_4()
		throws Exception {
		int iD = 1;

		Lieferant result = Lieferant.readOne(iD);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at model.lieferant.Lieferant.readOne(Lieferant.java:196)
		assertNotNull(result);
	}

	@Test
	public void testReadOne_5()
		throws Exception {
		int iD = 1;

		Lieferant result = Lieferant.readOne(iD);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at model.lieferant.Lieferant.readOne(Lieferant.java:196)
		assertNotNull(result);
	}

	@Test
	public void testReadOne_6()
		throws Exception {
		int iD = 1;

		Lieferant result = Lieferant.readOne(iD);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at model.lieferant.Lieferant.readOne(Lieferant.java:196)
		assertNotNull(result);
	}

	@Test
	public void testReadOne_7()
		throws Exception {
		int iD = 1;

		Lieferant result = Lieferant.readOne(iD);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at model.lieferant.Lieferant.readOne(Lieferant.java:196)
		assertNotNull(result);
	}

	@Test
	public void testReadOne_8()
		throws Exception {
		int iD = 1;

		Lieferant result = Lieferant.readOne(iD);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at model.lieferant.Lieferant.readOne(Lieferant.java:196)
		assertNotNull(result);
	}

	@Test
	public void testReadOne_9()
		throws Exception {
		int iD = 1;

		Lieferant result = Lieferant.readOne(iD);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at model.lieferant.Lieferant.readOne(Lieferant.java:196)
		assertNotNull(result);
	}

	@Test
	public void testReadOne_10()
		throws Exception {
		int iD = 1;

		Lieferant result = Lieferant.readOne(iD);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at model.lieferant.Lieferant.readOne(Lieferant.java:196)
		assertNotNull(result);
	}

	@Test
	public void testSetAdresse_1()
		throws Exception {
		Lieferant fixture = new Lieferant(1, "", new Adresse("", "", 1, ""), "", new Timestamp(1L));
		fixture.setBankdaten(new Bankdaten("", "", "", 1));
		fixture.setKontaktdaten(new Kontaktdaten("", ""));
		Adresse adresse = new Adresse("", "", 1, "");

		fixture.setAdresse(adresse);

	}

	@Test
	public void testSetBankdaten_1()
		throws Exception {
		Lieferant fixture = new Lieferant(1, "", new Adresse("", "", 1, ""), "", new Timestamp(1L));
		fixture.setBankdaten(new Bankdaten("", "", "", 1));
		fixture.setKontaktdaten(new Kontaktdaten("", ""));
		Bankdaten bankdaten = new Bankdaten("", "", "", 1);

		fixture.setBankdaten(bankdaten);

	}

	@Test
	public void testSetDate_1()
		throws Exception {
		Lieferant fixture = new Lieferant(1, "", new Adresse("", "", 1, ""), "", new Timestamp(1L));
		fixture.setBankdaten(new Bankdaten("", "", "", 1));
		fixture.setKontaktdaten(new Kontaktdaten("", ""));
		Timestamp date = new Timestamp(1L);

		fixture.setDate(date);

	}

	@Test
	public void testSetID_1()
		throws Exception {
		Lieferant fixture = new Lieferant(1, "", new Adresse("", "", 1, ""), "", new Timestamp(1L));
		fixture.setBankdaten(new Bankdaten("", "", "", 1));
		fixture.setKontaktdaten(new Kontaktdaten("", ""));
		int iD = 1;

		fixture.setID(iD);

	}

	@Test
	public void testSetKontaktdaten_1()
		throws Exception {
		Lieferant fixture = new Lieferant(1, "", new Adresse("", "", 1, ""), "", new Timestamp(1L));
		fixture.setBankdaten(new Bankdaten("", "", "", 1));
		fixture.setKontaktdaten(new Kontaktdaten("", ""));
		Kontaktdaten kontaktdaten = new Kontaktdaten("", "");

		fixture.setKontaktdaten(kontaktdaten);

	}

	@Test
	public void testSetName_1()
		throws Exception {
		Lieferant fixture = new Lieferant(1, "", new Adresse("", "", 1, ""), "", new Timestamp(1L));
		fixture.setBankdaten(new Bankdaten("", "", "", 1));
		fixture.setKontaktdaten(new Kontaktdaten("", ""));
		String name = "";

		fixture.setName(name);

	}

	@Test
	public void testSetTyp_1()
		throws Exception {
		Lieferant fixture = new Lieferant(1, "", new Adresse("", "", 1, ""), "", new Timestamp(1L));
		fixture.setBankdaten(new Bankdaten("", "", "", 1));
		fixture.setKontaktdaten(new Kontaktdaten("", ""));
		String typ = "";

		fixture.setTyp(typ);

	}

	@Test
	public void testUpdate_1()
		throws Exception {
		Lieferant fixture = new Lieferant(1, "", new Adresse("", "", 1, ""), "", new Timestamp(1L));
		fixture.setBankdaten(new Bankdaten("", "", "", 1));
		fixture.setKontaktdaten(new Kontaktdaten("", ""));
		int iD = 1;

		fixture.update(iD);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at model.lieferant.Lieferant.update(Lieferant.java:364)
	}

	@Test
	public void testUpdate_2()
		throws Exception {
		Lieferant fixture = new Lieferant(1, "", new Adresse("", "", 1, ""), "", new Timestamp(1L));
		fixture.setBankdaten(new Bankdaten("", "", "", 1));
		fixture.setKontaktdaten(new Kontaktdaten("", ""));
		int iD = 1;

		fixture.update(iD);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at model.lieferant.Lieferant.update(Lieferant.java:364)
	}

	@Test
	public void testUpdate_3()
		throws Exception {
		Lieferant fixture = new Lieferant(1, "", new Adresse("", "", 1, ""), "", new Timestamp(1L));
		fixture.setBankdaten(new Bankdaten("", "", "", 1));
		fixture.setKontaktdaten(new Kontaktdaten("", ""));
		int iD = 1;

		fixture.update(iD);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at model.lieferant.Lieferant.update(Lieferant.java:364)
	}

	@Test
	public void testWriteAll_1()
		throws Exception {
		ArrayList<Lieferant> alleLieferanten = new ArrayList();
		TableView<Lieferant> table = new TableView();

		Lieferant.writeAll(alleLieferanten, table);

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
		ArrayList<Lieferant> alleLieferanten = new ArrayList();
		TableView<Lieferant> table = new TableView();

		Lieferant.writeAll(alleLieferanten, table);

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
		Lieferant fixture = new Lieferant(1, "", new Adresse("", "", 1, ""), "", new Timestamp(1L));
		fixture.setBankdaten(new Bankdaten("", "", "", 1));
		fixture.setKontaktdaten(new Kontaktdaten("", ""));
		TextField[] textfelder = new TextField[] {null, new TextField(), new TextField(), new TextField(), new TextField(), new TextField(), new TextField(), new TextField(), new TextField(), new TextField(), new TextField(), new TextField()};

		fixture.writeOne(textfelder);

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.scene.control.TextField
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
		new org.junit.runner.JUnitCore().run(LieferantTest.class);
	}
}