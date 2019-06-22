package model.lieferant;

import org.junit.*;
import static org.junit.Assert.*;

public class AdresseTest {
	@Test
	public void testAdresse_1()
		throws Exception {
		String strasseUndNummer = "";
		String stadt = "";
		int postleitzahl = 1;
		String land = "";

		Adresse result = new Adresse(strasseUndNummer, stadt, postleitzahl, land);

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
	public void testAdresse_2()
		throws Exception {
		String name = "";
		String strasseUndNummer = "";
		String stadt = "";
		int postleitzahl = 1;
		String land = "";

		Adresse result = new Adresse(name, strasseUndNummer, stadt, postleitzahl, land);

		assertNotNull(result);
		assertEquals(" , , 1  ", result.toString());
		assertEquals("", result.getName());
		assertEquals("", result.getStrasseUndNummer());
		assertEquals("Adresse [name=, strasseUndNummer=, stadt=, postleitzahl=1, land=]", result.toString1());
		assertEquals("", result.getStadt());
		assertEquals("", result.getLand());
		assertEquals(1, result.getPostleitzahl());
	}

	@Test
	public void testGetLand_1()
		throws Exception {
		Adresse fixture = new Adresse("", "", "", 1, "");

		String result = fixture.getLand();

		assertEquals("", result);
	}

	@Test
	public void testGetName_1()
		throws Exception {
		Adresse fixture = new Adresse("", "", "", 1, "");

		String result = fixture.getName();

		assertEquals("", result);
	}

	@Test
	public void testGetPostleitzahl_1()
		throws Exception {
		Adresse fixture = new Adresse("", "", "", 1, "");

		int result = fixture.getPostleitzahl();

		assertEquals(1, result);
	}

	@Test
	public void testGetStadt_1()
		throws Exception {
		Adresse fixture = new Adresse("", "", "", 1, "");

		String result = fixture.getStadt();

		assertEquals("", result);
	}

	@Test
	public void testGetStrasseUndNummer_1()
		throws Exception {
		Adresse fixture = new Adresse("", "", "", 1, "");

		String result = fixture.getStrasseUndNummer();

		assertEquals("", result);
	}

	@Test
	public void testSetLand_1()
		throws Exception {
		Adresse fixture = new Adresse("", "", "", 1, "");
		String land = "";

		fixture.setLand(land);

	}

	@Test
	public void testSetName_1()
		throws Exception {
		Adresse fixture = new Adresse("", "", "", 1, "");
		String name = "";

		fixture.setName(name);

	}

	@Test
	public void testSetPostleitzahl_1()
		throws Exception {
		Adresse fixture = new Adresse("", "", "", 1, "");
		int postleitzahl = 1;

		fixture.setPostleitzahl(postleitzahl);

	}

	@Test
	public void testSetStadt_1()
		throws Exception {
		Adresse fixture = new Adresse("", "", "", 1, "");
		String stadt = "";

		fixture.setStadt(stadt);

	}

	@Test
	public void testSetStrasseUndNummer_1()
		throws Exception {
		Adresse fixture = new Adresse("", "", "", 1, "");
		String strasseUndNummer = "";

		fixture.setStrasseUndNummer(strasseUndNummer);

	}

	@Test
	public void testToString_1()
		throws Exception {
		Adresse fixture = new Adresse("", "", "", 1, "");

		String result = fixture.toString();

		assertEquals(" , , 1  ", result);
	}

	@Test
	public void testToString1_1()
		throws Exception {
		Adresse fixture = new Adresse("", "", "", 1, "");

		String result = fixture.toString1();

		assertEquals("Adresse [name=, strasseUndNummer=, stadt=, postleitzahl=1, land=]", result);
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
		new org.junit.runner.JUnitCore().run(AdresseTest.class);
	}
}