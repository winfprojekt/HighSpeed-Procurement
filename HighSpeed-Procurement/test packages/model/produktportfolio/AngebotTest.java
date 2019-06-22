package model.produktportfolio;

import javafx.scene.control.TableView;
import model.produkt.Produkt;
import javafx.scene.control.TextField;
import model.lieferant.Lieferant;
import org.junit.*;
import static org.junit.Assert.*;

public class AngebotTest {
	@Test
	public void testAngebot_1()
		throws Exception {
		int angID = 1;
		Lieferant lieferant = new Lieferant();
		Produkt produkt = Produkt.readLayer(new TextField[] {});

		Angebot result = new Angebot(angID, lieferant, produkt);

		assertNotNull(result);
		assertEquals(1, result.getAngID());
		assertEquals(null, result.getHersteller());
		assertEquals(null, result.getProdukt());
		assertEquals(0, result.getLieferantID());
		assertEquals(null, result.getProduktName());
		assertEquals(0.0, result.getEinzelpreis(), 1.0);
		assertEquals(null, result.getProduktTyp());
		assertEquals(0, result.getProduktID());
		assertEquals(0, result.getGultigkeitsdauer());
	}

	@Test
	public void testAngebot_2()
		throws Exception {
		Lieferant lieferant = new Lieferant();
		Produkt produkt = Produkt.readLayer(new TextField[] {});
		double einzelpreis = 1.0;
		int gultigkeitsdauer = 1;

		Angebot result = new Angebot(lieferant, produkt, einzelpreis, gultigkeitsdauer);

		assertNotNull(result);
		assertEquals(0, result.getAngID());
		assertEquals(null, result.getHersteller());
		assertEquals(null, result.getProdukt());
		assertEquals(0, result.getLieferantID());
		assertEquals(null, result.getProduktName());
		assertEquals(1.0, result.getEinzelpreis(), 1.0);
		assertEquals(null, result.getProduktTyp());
		assertEquals(0, result.getProduktID());
		assertEquals(1, result.getGultigkeitsdauer());
	}

	@Test
	public void testAngebot_3()
		throws Exception {
		int angID = 1;
		Lieferant lieferant = new Lieferant();
		Produkt produkt = Produkt.readLayer(new TextField[] {});
		double einzelpreis = 1.0;
		int gultigkeitsdauer = 1;

		Angebot result = new Angebot(angID, lieferant, produkt, einzelpreis, gultigkeitsdauer);

		assertNotNull(result);
		assertEquals(1, result.getAngID());
		assertEquals(null, result.getHersteller());
		assertEquals(null, result.getProdukt());
		assertEquals(0, result.getLieferantID());
		assertEquals(null, result.getProduktName());
		assertEquals(1.0, result.getEinzelpreis(), 1.0);
		assertEquals(null, result.getProduktTyp());
		assertEquals(0, result.getProduktID());
		assertEquals(1, result.getGultigkeitsdauer());
	}

	@Test
	public void testAngebot_4()
		throws Exception {
		int angID = 1;
		int lieferantID = 1;
		int produktID = 1;
		String produktTyp = "";
		String produktName = "";
		String hersteller = "";
		double einzelpreis = 1.0;

		Angebot result = new Angebot(angID, lieferantID, produktID, produktTyp, produktName, hersteller, einzelpreis);

		assertNotNull(result);
		assertEquals(1, result.getAngID());
		assertEquals(null, result.getLieferant());
		assertEquals("", result.getHersteller());
		assertEquals(null, result.getProdukt());
		assertEquals(1, result.getLieferantID());
		assertEquals("", result.getProduktName());
		assertEquals(1.0, result.getEinzelpreis(), 1.0);
		assertEquals("", result.getProduktTyp());
		assertEquals(1, result.getProduktID());
		assertEquals(0, result.getGultigkeitsdauer());
	}

	@Test
	public void testCreate_1()
		throws Exception {
		Angebot fixture = new Angebot(1, 1, 1, "", "", "", 1.0);
		fixture.setLieferant(new Lieferant());
		fixture.setGultigkeitsdauer(1);
		fixture.setProdukt(Produkt.readLayer(new TextField[] {}));

		fixture.create();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at model.produktportfolio.Angebot.create(Angebot.java:173)
	}

	@Test
	public void testCreate_2()
		throws Exception {
		Angebot fixture = new Angebot(1, 1, 1, "", "", "", 1.0);
		fixture.setLieferant(new Lieferant());
		fixture.setGultigkeitsdauer(1);
		fixture.setProdukt(Produkt.readLayer(new TextField[] {}));

		fixture.create();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at model.produktportfolio.Angebot.create(Angebot.java:173)
	}

	@Test
	public void testCreate_3()
		throws Exception {
		Angebot fixture = new Angebot(1, 1, 1, "", "", "", 1.0);
		fixture.setLieferant(new Lieferant());
		fixture.setGultigkeitsdauer(1);
		fixture.setProdukt(Produkt.readLayer(new TextField[] {}));

		fixture.create();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at model.produktportfolio.Angebot.create(Angebot.java:173)
	}

	@Test
	public void testDecreaseLaufzeitAll_1()
		throws Exception {
		Angebot fixture = new Angebot(1, 1, 1, "", "", "", 1.0);
		fixture.setLieferant(new Lieferant());
		fixture.setGultigkeitsdauer(1);
		fixture.setProdukt(Produkt.readLayer(new TextField[] {}));

		fixture.decreaseLaufzeitAll();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at model.produktportfolio.Angebot.decreaseLaufzeitAll(Angebot.java:225)
	}

	@Test
	public void testDecreaseLaufzeitAll_2()
		throws Exception {
		Angebot fixture = new Angebot(1, 1, 1, "", "", "", 1.0);
		fixture.setLieferant(new Lieferant());
		fixture.setGultigkeitsdauer(1);
		fixture.setProdukt(Produkt.readLayer(new TextField[] {}));

		fixture.decreaseLaufzeitAll();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at model.produktportfolio.Angebot.decreaseLaufzeitAll(Angebot.java:225)
	}

	@Test
	public void testDecreaseLaufzeitAll_3()
		throws Exception {
		Angebot fixture = new Angebot(1, 1, 1, "", "", "", 1.0);
		fixture.setLieferant(new Lieferant());
		fixture.setGultigkeitsdauer(1);
		fixture.setProdukt(Produkt.readLayer(new TextField[] {}));

		fixture.decreaseLaufzeitAll();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at model.produktportfolio.Angebot.decreaseLaufzeitAll(Angebot.java:225)
	}

	@Test
	public void testDecreaseLaufzeitAll_4()
		throws Exception {
		Angebot fixture = new Angebot(1, 1, 1, "", "", "", 1.0);
		fixture.setLieferant(new Lieferant());
		fixture.setGultigkeitsdauer(1);
		fixture.setProdukt(Produkt.readLayer(new TextField[] {}));

		fixture.decreaseLaufzeitAll();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at model.produktportfolio.Angebot.decreaseLaufzeitAll(Angebot.java:225)
	}

	@Test
	public void testDecreaseLaufzeitAll_5()
		throws Exception {
		Angebot fixture = new Angebot(1, 1, 1, "", "", "", 1.0);
		fixture.setLieferant(new Lieferant());
		fixture.setGultigkeitsdauer(1);
		fixture.setProdukt(Produkt.readLayer(new TextField[] {}));

		fixture.decreaseLaufzeitAll();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at model.produktportfolio.Angebot.decreaseLaufzeitAll(Angebot.java:225)
	}

	@Test
	public void testDecreaseLaufzeitAll_6()
		throws Exception {
		Angebot fixture = new Angebot(1, 1, 1, "", "", "", 1.0);
		fixture.setLieferant(new Lieferant());
		fixture.setGultigkeitsdauer(1);
		fixture.setProdukt(Produkt.readLayer(new TextField[] {}));

		fixture.decreaseLaufzeitAll();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at model.produktportfolio.Angebot.decreaseLaufzeitAll(Angebot.java:225)
	}

	@Test
	public void testDecreaseLaufzeitAll_7()
		throws Exception {
		Angebot fixture = new Angebot(1, 1, 1, "", "", "", 1.0);
		fixture.setLieferant(new Lieferant());
		fixture.setGultigkeitsdauer(1);
		fixture.setProdukt(Produkt.readLayer(new TextField[] {}));

		fixture.decreaseLaufzeitAll();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at model.produktportfolio.Angebot.decreaseLaufzeitAll(Angebot.java:225)
	}

	@Test
	public void testDecreaseLaufzeitAll_8()
		throws Exception {
		Angebot fixture = new Angebot(1, 1, 1, "", "", "", 1.0);
		fixture.setLieferant(new Lieferant());
		fixture.setGultigkeitsdauer(1);
		fixture.setProdukt(Produkt.readLayer(new TextField[] {}));

		fixture.decreaseLaufzeitAll();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at model.produktportfolio.Angebot.decreaseLaufzeitAll(Angebot.java:225)
	}

	@Test
	public void testDecreaseLaufzeitAll_9()
		throws Exception {
		Angebot fixture = new Angebot(1, 1, 1, "", "", "", 1.0);
		fixture.setLieferant(new Lieferant());
		fixture.setGultigkeitsdauer(1);
		fixture.setProdukt(Produkt.readLayer(new TextField[] {}));

		fixture.decreaseLaufzeitAll();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at model.produktportfolio.Angebot.decreaseLaufzeitAll(Angebot.java:225)
	}

	@Test
	public void testDecreaseLaufzeitAll_10()
		throws Exception {
		Angebot fixture = new Angebot(1, 1, 1, "", "", "", 1.0);
		fixture.setLieferant(new Lieferant());
		fixture.setGultigkeitsdauer(1);
		fixture.setProdukt(Produkt.readLayer(new TextField[] {}));

		fixture.decreaseLaufzeitAll();

		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at model.produktportfolio.Angebot.decreaseLaufzeitAll(Angebot.java:225)
	}

	@Test
	public void testGetAngID_1()
		throws Exception {
		Angebot fixture = new Angebot(1, 1, 1, "", "", "", 1.0);
		fixture.setLieferant(new Lieferant());
		fixture.setGultigkeitsdauer(1);
		fixture.setProdukt(Produkt.readLayer(new TextField[] {}));

		int result = fixture.getAngID();

		assertEquals(1, result);
	}

	@Test
	public void testGetEinzelpreis_1()
		throws Exception {
		Angebot fixture = new Angebot(1, 1, 1, "", "", "", 1.0);
		fixture.setLieferant(new Lieferant());
		fixture.setGultigkeitsdauer(1);
		fixture.setProdukt(Produkt.readLayer(new TextField[] {}));

		double result = fixture.getEinzelpreis();

		assertEquals(1.0, result, 0.1);
	}

	@Test
	public void testGetGultigkeitsdauer_1()
		throws Exception {
		Angebot fixture = new Angebot(1, 1, 1, "", "", "", 1.0);
		fixture.setLieferant(new Lieferant());
		fixture.setGultigkeitsdauer(1);
		fixture.setProdukt(Produkt.readLayer(new TextField[] {}));

		int result = fixture.getGultigkeitsdauer();

		assertEquals(1, result);
	}

	@Test
	public void testGetHersteller_1()
		throws Exception {
		Angebot fixture = new Angebot(1, 1, 1, "", "", "", 1.0);
		fixture.setLieferant(new Lieferant());
		fixture.setGultigkeitsdauer(1);
		fixture.setProdukt(Produkt.readLayer(new TextField[] {}));

		String result = fixture.getHersteller();

		assertEquals("", result);
	}

	@Test
	public void testGetLieferant_1()
		throws Exception {
		Angebot fixture = new Angebot(1, 1, 1, "", "", "", 1.0);
		fixture.setLieferant(new Lieferant());
		fixture.setGultigkeitsdauer(1);
		fixture.setProdukt(Produkt.readLayer(new TextField[] {}));

		Lieferant result = fixture.getLieferant();

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
	public void testGetLieferantID_1()
		throws Exception {
		Angebot fixture = new Angebot(1, 1, 1, "", "", "", 1.0);
		fixture.setLieferant(new Lieferant());
		fixture.setGultigkeitsdauer(1);
		fixture.setProdukt(Produkt.readLayer(new TextField[] {}));

		int result = fixture.getLieferantID();

		assertEquals(1, result);
	}

	@Test
	public void testGetProdukt_1()
		throws Exception {
		Angebot fixture = new Angebot(1, 1, 1, "", "", "", 1.0);
		fixture.setLieferant(new Lieferant());
		fixture.setGultigkeitsdauer(1);
		fixture.setProdukt(Produkt.readLayer(new TextField[] {}));

		Produkt result = fixture.getProdukt();

		assertEquals(null, result);
	}

	@Test
	public void testGetProduktID_1()
		throws Exception {
		Angebot fixture = new Angebot(1, 1, 1, "", "", "", 1.0);
		fixture.setLieferant(new Lieferant());
		fixture.setGultigkeitsdauer(1);
		fixture.setProdukt(Produkt.readLayer(new TextField[] {}));

		int result = fixture.getProduktID();

		assertEquals(1, result);
	}

	@Test
	public void testGetProduktName_1()
		throws Exception {
		Angebot fixture = new Angebot(1, 1, 1, "", "", "", 1.0);
		fixture.setLieferant(new Lieferant());
		fixture.setGultigkeitsdauer(1);
		fixture.setProdukt(Produkt.readLayer(new TextField[] {}));

		String result = fixture.getProduktName();

		assertEquals("", result);
	}

	@Test
	public void testGetProduktTyp_1()
		throws Exception {
		Angebot fixture = new Angebot(1, 1, 1, "", "", "", 1.0);
		fixture.setLieferant(new Lieferant());
		fixture.setGultigkeitsdauer(1);
		fixture.setProdukt(Produkt.readLayer(new TextField[] {}));

		String result = fixture.getProduktTyp();

		assertEquals("", result);
	}

	@Test
	public void testReadLayer_1()
		throws Exception {
		TableView<Lieferant> tableLieferant = new TableView();
		TableView<Produkt> tableProdukt = new TableView();
		TextField textfeldPreis = new TextField();
		TextField textfeldGultigkeitsdauer = new TextField();

		Angebot result = Angebot.readLayer(tableLieferant, tableProdukt, textfeldPreis, textfeldGultigkeitsdauer);

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
		assertNotNull(result);
	}

	@Test
	public void testReadLayer_2()
		throws Exception {
		TableView<Lieferant> tableLieferant = new TableView();
		TableView<Produkt> tableProdukt = new TableView();
		TextField textfeldPreis = new TextField();
		TextField textfeldGultigkeitsdauer = new TextField();

		Angebot result = Angebot.readLayer(tableLieferant, tableProdukt, textfeldPreis, textfeldGultigkeitsdauer);

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
		assertNotNull(result);
	}

	@Test
	public void testReadLayer_3()
		throws Exception {
		TableView<Lieferant> tableLieferant = new TableView();
		TableView<Produkt> tableProdukt = new TableView();
		TextField textfeldPreis = new TextField();
		TextField textfeldGultigkeitsdauer = new TextField();

		Angebot result = Angebot.readLayer(tableLieferant, tableProdukt, textfeldPreis, textfeldGultigkeitsdauer);

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
		assertNotNull(result);
	}

	@Test
	public void testSetAngID_1()
		throws Exception {
		Angebot fixture = new Angebot(1, 1, 1, "", "", "", 1.0);
		fixture.setLieferant(new Lieferant());
		fixture.setGultigkeitsdauer(1);
		fixture.setProdukt(Produkt.readLayer(new TextField[] {}));
		int id = 1;

		fixture.setAngID(id);

	}

	@Test
	public void testSetEinzelpreis_1()
		throws Exception {
		Angebot fixture = new Angebot(1, 1, 1, "", "", "", 1.0);
		fixture.setLieferant(new Lieferant());
		fixture.setGultigkeitsdauer(1);
		fixture.setProdukt(Produkt.readLayer(new TextField[] {}));
		double einzelpreis = 1.0;

		fixture.setEinzelpreis(einzelpreis);

	}

	@Test
	public void testSetGultigkeitsdauer_1()
		throws Exception {
		Angebot fixture = new Angebot(1, 1, 1, "", "", "", 1.0);
		fixture.setLieferant(new Lieferant());
		fixture.setGultigkeitsdauer(1);
		fixture.setProdukt(Produkt.readLayer(new TextField[] {}));
		int gultigkeitsdauer = 1;

		fixture.setGultigkeitsdauer(gultigkeitsdauer);

	}

	@Test
	public void testSetHersteller_1()
		throws Exception {
		Angebot fixture = new Angebot(1, 1, 1, "", "", "", 1.0);
		fixture.setLieferant(new Lieferant());
		fixture.setGultigkeitsdauer(1);
		fixture.setProdukt(Produkt.readLayer(new TextField[] {}));
		String hersteller = "";

		fixture.setHersteller(hersteller);

	}

	@Test
	public void testSetLieferant_1()
		throws Exception {
		Angebot fixture = new Angebot(1, 1, 1, "", "", "", 1.0);
		fixture.setLieferant(new Lieferant());
		fixture.setGultigkeitsdauer(1);
		fixture.setProdukt(Produkt.readLayer(new TextField[] {}));
		Lieferant lieferant = new Lieferant();

		fixture.setLieferant(lieferant);

	}

	@Test
	public void testSetLieferantID_1()
		throws Exception {
		Angebot fixture = new Angebot(1, 1, 1, "", "", "", 1.0);
		fixture.setLieferant(new Lieferant());
		fixture.setGultigkeitsdauer(1);
		fixture.setProdukt(Produkt.readLayer(new TextField[] {}));
		int lieferantID = 1;

		fixture.setLieferantID(lieferantID);

	}

	@Test
	public void testSetProdukt_1()
		throws Exception {
		Angebot fixture = new Angebot(1, 1, 1, "", "", "", 1.0);
		fixture.setLieferant(new Lieferant());
		fixture.setGultigkeitsdauer(1);
		fixture.setProdukt(Produkt.readLayer(new TextField[] {}));
		Produkt produkt = Produkt.readLayer(new TextField[] {});

		fixture.setProdukt(produkt);

	}

	@Test
	public void testSetProduktID_1()
		throws Exception {
		Angebot fixture = new Angebot(1, 1, 1, "", "", "", 1.0);
		fixture.setLieferant(new Lieferant());
		fixture.setGultigkeitsdauer(1);
		fixture.setProdukt(Produkt.readLayer(new TextField[] {}));
		int produktID = 1;

		fixture.setProduktID(produktID);

	}

	@Test
	public void testSetProduktName_1()
		throws Exception {
		Angebot fixture = new Angebot(1, 1, 1, "", "", "", 1.0);
		fixture.setLieferant(new Lieferant());
		fixture.setGultigkeitsdauer(1);
		fixture.setProdukt(Produkt.readLayer(new TextField[] {}));
		String produktName = "";

		fixture.setProduktName(produktName);

	}

	@Test
	public void testSetProduktTyp_1()
		throws Exception {
		Angebot fixture = new Angebot(1, 1, 1, "", "", "", 1.0);
		fixture.setLieferant(new Lieferant());
		fixture.setGultigkeitsdauer(1);
		fixture.setProdukt(Produkt.readLayer(new TextField[] {}));
		String produktTyp = "";

		fixture.setProduktTyp(produktTyp);

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
		new org.junit.runner.JUnitCore().run(AngebotTest.class);
	}
}