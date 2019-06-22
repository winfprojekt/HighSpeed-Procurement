package model.bestellung;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.ArrayList;
import model.lieferant.Lieferant;
import java.util.Date;
import javafx.beans.property.StringProperty;
import org.junit.*;
import static org.junit.Assert.*;

public class TeilbestellungTest {
	@Test
	public void testTeilbestellung_1()
		throws Exception {
		String bestUUID = "";
		String name = "";
		int angID = 1;
		int liefID = 1;
		int prodID = 1;
		String prodTyp = "";
		String prodName = "";
		String hersteller = "";
		int menge = 1;
		double gesamtpreis = 1.0;

		Teilbestellung result = new Teilbestellung(bestUUID, name, angID, liefID, prodID, prodTyp, prodName, hersteller, menge, gesamtpreis);

		assertNotNull(result);
		assertEquals("Teilbestellung [lieferant=null, liefID=1]", result.toString());
		assertEquals("", result.getName());
		assertEquals(null, result.readAll());
		assertEquals(null, result.getStatus());
		assertEquals(null, result.getBestellungsTyp());
		assertEquals(null, result.getErstelltAm());
		assertEquals(1.0, result.getGesamtpreis(), 1.0);
		assertEquals(1, result.getAngID());
		assertEquals(null, result.getStatusNew());
		assertEquals(new Integer(1), result.getLiefID());
		assertEquals(1, result.getProdID());
		assertEquals(null, result.objectToString());
		assertEquals("", result.getProdTyp());
		assertEquals("", result.getProdName());
		assertEquals(1, result.getMenge());
		assertEquals(null, result.getLieferant());
		assertEquals("", result.getHersteller());
		assertEquals("Produkt:   Menge: 1 Gesamtpreis: 1.0", result.getTeilStrin());
		assertEquals("", result.getBestUUID());
	}

	@Test
	public void testTeilbestellung_2()
		throws Exception {
		String bestUUID = "";
		String name = "";
		int liefID = 1;
		String prodTyp = "";
		String prodName = "";
		String hersteller = "";
		int menge = 1;
		String bestellungsTyp = "";
		String status = "";
		double gesamtpreis = 1.0;

		Teilbestellung result = new Teilbestellung(bestUUID, name, liefID, prodTyp, prodName, hersteller, menge, bestellungsTyp, status, gesamtpreis);

		assertNotNull(result);
		assertEquals("Teilbestellung [lieferant=null, liefID=1]", result.toString());
		assertEquals("", result.getName());
		assertEquals(null, result.readAll());
		assertEquals(null, result.getStatus());
		assertEquals("", result.getBestellungsTyp());
		assertEquals(null, result.getErstelltAm());
		assertEquals(1.0, result.getGesamtpreis(), 1.0);
		assertEquals(0, result.getAngID());
		assertEquals("", result.getStatusNew());
		assertEquals(new Integer(1), result.getLiefID());
		assertEquals(0, result.getProdID());
		assertEquals(null, result.objectToString());
		assertEquals("", result.getProdTyp());
		assertEquals("", result.getProdName());
		assertEquals(1, result.getMenge());
		assertEquals(null, result.getLieferant());
		assertEquals("", result.getHersteller());
		assertEquals("Produkt:   Menge: 1 Gesamtpreis: 1.0", result.getTeilStrin());
		assertEquals("", result.getBestUUID());
	}

	@Test
	public void testTeilbestellung_3()
		throws Exception {
		String bestUUID = "";
		String name = "";
		int liefID = 1;
		String prodTyp = "";
		String prodName = "";
		String hersteller = "";
		int menge = 1;
		String bestellungsTyp = "";
		String status = "";
		double gesamtpreis = 1.0;
		Timestamp erstelltAm = new Timestamp(1L);

		Teilbestellung result = new Teilbestellung(bestUUID, name, liefID, prodTyp, prodName, hersteller, menge, bestellungsTyp, status, gesamtpreis, erstelltAm);

		assertNotNull(result);
		assertEquals("Teilbestellung [lieferant=null, liefID=1]", result.toString());
		assertEquals("", result.getName());
		assertEquals(null, result.readAll());
		assertEquals(null, result.getStatus());
		assertEquals("", result.getBestellungsTyp());
		assertEquals(1.0, result.getGesamtpreis(), 1.0);
		assertEquals(0, result.getAngID());
		assertEquals("", result.getStatusNew());
		assertEquals(new Integer(1), result.getLiefID());
		assertEquals(0, result.getProdID());
		assertEquals(null, result.objectToString());
		assertEquals("", result.getProdTyp());
		assertEquals("", result.getProdName());
		assertEquals(1, result.getMenge());
		assertEquals(null, result.getLieferant());
		assertEquals("", result.getHersteller());
		assertEquals("Produkt:   Menge: 1 Gesamtpreis: 1.0", result.getTeilStrin());
		assertEquals("", result.getBestUUID());
	}

	@Test
	public void testCreate_1()
		throws Exception {
		Teilbestellung fixture = new Teilbestellung("", "", 1, "", "", "", 1, "", "", 1.0, new Timestamp(1L));
		fixture.setLieferant(new Lieferant());
		fixture.setAngID(1);
		fixture.setProdID(1);
		fixture.setStatus("");

		fixture.create();

	}

	@Test
	public void testGetAngID_1()
		throws Exception {
		Teilbestellung fixture = new Teilbestellung("", "", 1, "", "", "", 1, "", "", 1.0, new Timestamp(1L));
		fixture.setLieferant(new Lieferant());
		fixture.setAngID(1);
		fixture.setProdID(1);
		fixture.setStatus("");

		int result = fixture.getAngID();

		assertEquals(1, result);
	}

	@Test
	public void testGetBestUUID_1()
		throws Exception {
		Teilbestellung fixture = new Teilbestellung("", "", 1, "", "", "", 1, "", "", 1.0, new Timestamp(1L));
		fixture.setLieferant(new Lieferant());
		fixture.setAngID(1);
		fixture.setProdID(1);
		fixture.setStatus("");

		String result = fixture.getBestUUID();

		assertEquals("", result);
	}

	@Test
	public void testGetBestellungsTyp_1()
		throws Exception {
		Teilbestellung fixture = new Teilbestellung("", "", 1, "", "", "", 1, "", "", 1.0, new Timestamp(1L));
		fixture.setLieferant(new Lieferant());
		fixture.setAngID(1);
		fixture.setProdID(1);
		fixture.setStatus("");

		String result = fixture.getBestellungsTyp();

		assertEquals("", result);
	}

	@Test
	public void testGetErstelltAm_1()
		throws Exception {
		Teilbestellung fixture = new Teilbestellung("", "", 1, "", "", "", 1, "", "", 1.0, new Timestamp(1L));
		fixture.setLieferant(new Lieferant());
		fixture.setAngID(1);
		fixture.setProdID(1);
		fixture.setStatus("");

		Timestamp result = fixture.getErstelltAm();

		assertNotNull(result);
		assertEquals(DateFormat.getInstance().format(new Date(1L)), DateFormat.getInstance().format(result));
		assertEquals(1L, result.getTime());
	}

	@Test
	public void testGetGesamtpreis_1()
		throws Exception {
		Teilbestellung fixture = new Teilbestellung("", "", 1, "", "", "", 1, "", "", 1.0, new Timestamp(1L));
		fixture.setLieferant(new Lieferant());
		fixture.setAngID(1);
		fixture.setProdID(1);
		fixture.setStatus("");

		double result = fixture.getGesamtpreis();

		assertEquals(1.0, result, 0.1);
	}

	@Test
	public void testGetHersteller_1()
		throws Exception {
		Teilbestellung fixture = new Teilbestellung("", "", 1, "", "", "", 1, "", "", 1.0, new Timestamp(1L));
		fixture.setLieferant(new Lieferant());
		fixture.setAngID(1);
		fixture.setProdID(1);
		fixture.setStatus("");

		String result = fixture.getHersteller();

		assertEquals("", result);
	}

	@Test
	public void testGetLiefID_1()
		throws Exception {
		Teilbestellung fixture = new Teilbestellung("", "", 1, "", "", "", 1, "", "", 1.0, new Timestamp(1L));
		fixture.setLieferant(new Lieferant());
		fixture.setAngID(1);
		fixture.setProdID(1);
		fixture.setStatus("");

		Integer result = fixture.getLiefID();

		assertNotNull(result);
		assertEquals("1", result.toString());
		assertEquals((byte) 1, result.byteValue());
		assertEquals((short) 1, result.shortValue());
		assertEquals(1, result.intValue());
		assertEquals(1L, result.longValue());
		assertEquals(1.0f, result.floatValue(), 1.0f);
		assertEquals(1.0, result.doubleValue(), 1.0);
	}

	@Test
	public void testGetLieferant_1()
		throws Exception {
		Teilbestellung fixture = new Teilbestellung("", "", 1, "", "", "", 1, "", "", 1.0, new Timestamp(1L));
		fixture.setLieferant(new Lieferant());
		fixture.setAngID(1);
		fixture.setProdID(1);
		fixture.setStatus("");

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
	public void testGetMenge_1()
		throws Exception {
		Teilbestellung fixture = new Teilbestellung("", "", 1, "", "", "", 1, "", "", 1.0, new Timestamp(1L));
		fixture.setLieferant(new Lieferant());
		fixture.setAngID(1);
		fixture.setProdID(1);
		fixture.setStatus("");

		int result = fixture.getMenge();

		assertEquals(1, result);
	}

	@Test
	public void testGetName_1()
		throws Exception {
		Teilbestellung fixture = new Teilbestellung("", "", 1, "", "", "", 1, "", "", 1.0, new Timestamp(1L));
		fixture.setLieferant(new Lieferant());
		fixture.setAngID(1);
		fixture.setProdID(1);
		fixture.setStatus("");

		String result = fixture.getName();

		assertEquals("", result);
	}

	@Test
	public void testGetProdID_1()
		throws Exception {
		Teilbestellung fixture = new Teilbestellung("", "", 1, "", "", "", 1, "", "", 1.0, new Timestamp(1L));
		fixture.setLieferant(new Lieferant());
		fixture.setAngID(1);
		fixture.setProdID(1);
		fixture.setStatus("");

		int result = fixture.getProdID();

		assertEquals(1, result);
	}

	@Test
	public void testGetProdName_1()
		throws Exception {
		Teilbestellung fixture = new Teilbestellung("", "", 1, "", "", "", 1, "", "", 1.0, new Timestamp(1L));
		fixture.setLieferant(new Lieferant());
		fixture.setAngID(1);
		fixture.setProdID(1);
		fixture.setStatus("");

		String result = fixture.getProdName();

		assertEquals("", result);
	}

	@Test
	public void testGetProdTyp_1()
		throws Exception {
		Teilbestellung fixture = new Teilbestellung("", "", 1, "", "", "", 1, "", "", 1.0, new Timestamp(1L));
		fixture.setLieferant(new Lieferant());
		fixture.setAngID(1);
		fixture.setProdID(1);
		fixture.setStatus("");

		String result = fixture.getProdTyp();

		assertEquals("", result);
	}

	@Test
	public void testGetStatus_1()
		throws Exception {
		Teilbestellung fixture = new Teilbestellung("", "", 1, "", "", "", 1, "", "", 1.0, new Timestamp(1L));
		fixture.setLieferant(new Lieferant());
		fixture.setAngID(1);
		fixture.setProdID(1);
		fixture.setStatus("");

		String result = fixture.getStatus();

		assertEquals("", result);
	}

	@Test
	public void testGetStatusNew_1()
		throws Exception {
		Teilbestellung fixture = new Teilbestellung("", "", 1, "", "", "", 1, "", "", 1.0, new Timestamp(1L));
		fixture.setLieferant(new Lieferant());
		fixture.setAngID(1);
		fixture.setProdID(1);
		fixture.setStatus("");

		String result = fixture.getStatusNew();

		assertEquals("", result);
	}

	@Test
	public void testGetTeilStrin_1()
		throws Exception {
		Teilbestellung fixture = new Teilbestellung("", "", 1, "", "", "", 1, "", "", 1.0, new Timestamp(1L));
		fixture.setLieferant(new Lieferant());
		fixture.setAngID(1);
		fixture.setProdID(1);
		fixture.setStatus("");

		String result = fixture.getTeilStrin();

		assertEquals("Produkt:   Menge: 1 Gesamtpreis: 1.0", result);
	}

	@Test
	public void testObjectToString_1()
		throws Exception {
		Teilbestellung fixture = new Teilbestellung("", "", 1, "", "", "", 1, "", "", 1.0, new Timestamp(1L));
		fixture.setLieferant(new Lieferant());
		fixture.setAngID(1);
		fixture.setProdID(1);
		fixture.setStatus("");

		String result = fixture.objectToString();

		assertEquals(null, result);
	}

	@Test
	public void testReadAll_1()
		throws Exception {
		Teilbestellung fixture = new Teilbestellung("", "", 1, "", "", "", 1, "", "", 1.0, new Timestamp(1L));
		fixture.setLieferant(new Lieferant());
		fixture.setAngID(1);
		fixture.setProdID(1);
		fixture.setStatus("");

		ArrayList<Teilbestellung> result = fixture.readAll();

		assertEquals(null, result);
	}

	@Test
	public void testSetAngID_1()
		throws Exception {
		Teilbestellung fixture = new Teilbestellung("", "", 1, "", "", "", 1, "", "", 1.0, new Timestamp(1L));
		fixture.setLieferant(new Lieferant());
		fixture.setAngID(1);
		fixture.setProdID(1);
		fixture.setStatus("");
		int angID = 1;

		fixture.setAngID(angID);

	}

	@Test
	public void testSetBestID_1()
		throws Exception {
		Teilbestellung fixture = new Teilbestellung("", "", 1, "", "", "", 1, "", "", 1.0, new Timestamp(1L));
		fixture.setLieferant(new Lieferant());
		fixture.setAngID(1);
		fixture.setProdID(1);
		fixture.setStatus("");
		String bestUUID = "";

		fixture.setBestID(bestUUID);

	}

	@Test
	public void testSetBestUUID_1()
		throws Exception {
		Teilbestellung fixture = new Teilbestellung("", "", 1, "", "", "", 1, "", "", 1.0, new Timestamp(1L));
		fixture.setLieferant(new Lieferant());
		fixture.setAngID(1);
		fixture.setProdID(1);
		fixture.setStatus("");
		String bestUUID = "";

		fixture.setBestUUID(bestUUID);

	}

	@Test
	public void testSetBestellungsTyp_1()
		throws Exception {
		Teilbestellung fixture = new Teilbestellung("", "", 1, "", "", "", 1, "", "", 1.0, new Timestamp(1L));
		fixture.setLieferant(new Lieferant());
		fixture.setAngID(1);
		fixture.setProdID(1);
		fixture.setStatus("");
		String bestellungsTyp = "";

		fixture.setBestellungsTyp(bestellungsTyp);

	}

	@Test
	public void testSetErstelltAm_1()
		throws Exception {
		Teilbestellung fixture = new Teilbestellung("", "", 1, "", "", "", 1, "", "", 1.0, new Timestamp(1L));
		fixture.setLieferant(new Lieferant());
		fixture.setAngID(1);
		fixture.setProdID(1);
		fixture.setStatus("");
		Timestamp erstelltAm = new Timestamp(1L);

		fixture.setErstelltAm(erstelltAm);

	}

	@Test
	public void testSetGesamtpreis_1()
		throws Exception {
		Teilbestellung fixture = new Teilbestellung("", "", 1, "", "", "", 1, "", "", 1.0, new Timestamp(1L));
		fixture.setLieferant(new Lieferant());
		fixture.setAngID(1);
		fixture.setProdID(1);
		fixture.setStatus("");
		double gesamtpreis = 1.0;

		fixture.setGesamtpreis(gesamtpreis);

	}

	@Test
	public void testSetHersteller_1()
		throws Exception {
		Teilbestellung fixture = new Teilbestellung("", "", 1, "", "", "", 1, "", "", 1.0, new Timestamp(1L));
		fixture.setLieferant(new Lieferant());
		fixture.setAngID(1);
		fixture.setProdID(1);
		fixture.setStatus("");
		String hersteller = "";

		fixture.setHersteller(hersteller);

	}

	@Test
	public void testSetLiefID_1()
		throws Exception {
		Teilbestellung fixture = new Teilbestellung("", "", 1, "", "", "", 1, "", "", 1.0, new Timestamp(1L));
		fixture.setLieferant(new Lieferant());
		fixture.setAngID(1);
		fixture.setProdID(1);
		fixture.setStatus("");
		Integer liefID = new Integer(1);

		fixture.setLiefID(liefID);

	}

	@Test
	public void testSetLieferant_1()
		throws Exception {
		Teilbestellung fixture = new Teilbestellung("", "", 1, "", "", "", 1, "", "", 1.0, new Timestamp(1L));
		fixture.setLieferant(new Lieferant());
		fixture.setAngID(1);
		fixture.setProdID(1);
		fixture.setStatus("");
		Lieferant lieferant = new Lieferant();

		fixture.setLieferant(lieferant);

	}

	@Test
	public void testSetMenge_1()
		throws Exception {
		Teilbestellung fixture = new Teilbestellung("", "", 1, "", "", "", 1, "", "", 1.0, new Timestamp(1L));
		fixture.setLieferant(new Lieferant());
		fixture.setAngID(1);
		fixture.setProdID(1);
		fixture.setStatus("");
		int menge = 1;

		fixture.setMenge(menge);

	}

	@Test
	public void testSetName_1()
		throws Exception {
		Teilbestellung fixture = new Teilbestellung("", "", 1, "", "", "", 1, "", "", 1.0, new Timestamp(1L));
		fixture.setLieferant(new Lieferant());
		fixture.setAngID(1);
		fixture.setProdID(1);
		fixture.setStatus("");
		String name = "";

		fixture.setName(name);

	}

	@Test
	public void testSetProdID_1()
		throws Exception {
		Teilbestellung fixture = new Teilbestellung("", "", 1, "", "", "", 1, "", "", 1.0, new Timestamp(1L));
		fixture.setLieferant(new Lieferant());
		fixture.setAngID(1);
		fixture.setProdID(1);
		fixture.setStatus("");
		int prodID = 1;

		fixture.setProdID(prodID);

	}

	@Test
	public void testSetProdName_1()
		throws Exception {
		Teilbestellung fixture = new Teilbestellung("", "", 1, "", "", "", 1, "", "", 1.0, new Timestamp(1L));
		fixture.setLieferant(new Lieferant());
		fixture.setAngID(1);
		fixture.setProdID(1);
		fixture.setStatus("");
		String prodName = "";

		fixture.setProdName(prodName);

	}

	@Test
	public void testSetProdTyp_1()
		throws Exception {
		Teilbestellung fixture = new Teilbestellung("", "", 1, "", "", "", 1, "", "", 1.0, new Timestamp(1L));
		fixture.setLieferant(new Lieferant());
		fixture.setAngID(1);
		fixture.setProdID(1);
		fixture.setStatus("");
		String prodTyp = "";

		fixture.setProdTyp(prodTyp);

	}

	@Test
	public void testSetStatus_1()
		throws Exception {
		Teilbestellung fixture = new Teilbestellung("", "", 1, "", "", "", 1, "", "", 1.0, new Timestamp(1L));
		fixture.setLieferant(new Lieferant());
		fixture.setAngID(1);
		fixture.setProdID(1);
		fixture.setStatus("");
		String status = "";

		fixture.setStatus(status);

	}

	@Test
	public void testSetStatusNew_1()
		throws Exception {
		Teilbestellung fixture = new Teilbestellung("", "", 1, "", "", "", 1, "", "", 1.0, new Timestamp(1L));
		fixture.setLieferant(new Lieferant());
		fixture.setAngID(1);
		fixture.setProdID(1);
		fixture.setStatus("");
		String statusNew = "";

		fixture.setStatusNew(statusNew);

	}

	@Test
	public void testStatusNewProperty_1()
		throws Exception {
		Teilbestellung fixture = new Teilbestellung("", "", 1, "", "", "", 1, "", "", 1.0, new Timestamp(1L));
		fixture.setLieferant(new Lieferant());
		fixture.setAngID(1);
		fixture.setProdID(1);
		fixture.setStatus("");

		StringProperty result = fixture.statusNewProperty();

		assertNotNull(result);
		assertEquals("StringProperty [value: ]", result.toString());
		assertEquals("", result.getValue());
		assertEquals("", result.getValueSafe());
	}

	@Test
	public void testStringToObject_1()
		throws Exception {
		Teilbestellung fixture = new Teilbestellung("", "", 1, "", "", "", 1, "", "", 1.0, new Timestamp(1L));
		fixture.setLieferant(new Lieferant());
		fixture.setAngID(1);
		fixture.setProdID(1);
		fixture.setStatus("");
		String string = "";

		Teilbestellung result = fixture.stringToObject(string);

		assertEquals(null, result);
	}

	@Test
	public void testToString_1()
		throws Exception {
		Teilbestellung fixture = new Teilbestellung("", "", 1, "", "", "", 1, "", "", 1.0, new Timestamp(1L));
		fixture.setLieferant(new Lieferant());
		fixture.setAngID(1);
		fixture.setProdID(1);
		fixture.setStatus("");

		String result = fixture.toString();

		assertEquals("Teilbestellung [lieferant=model.lieferant.Lieferant@720d3604, liefID=1]", result);
	}

	@Test
	public void testWriteAll_1()
		throws Exception {
		Teilbestellung fixture = new Teilbestellung("", "", 1, "", "", "", 1, "", "", 1.0, new Timestamp(1L));
		fixture.setLieferant(new Lieferant());
		fixture.setAngID(1);
		fixture.setProdID(1);
		fixture.setStatus("");
		ArrayList<Teilbestellung> teilbestellungen = new ArrayList();

		fixture.writeAll(teilbestellungen);

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
		new org.junit.runner.JUnitCore().run(TeilbestellungTest.class);
	}
}