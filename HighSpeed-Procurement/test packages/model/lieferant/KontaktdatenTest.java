package model.lieferant;

import org.junit.*;
import static org.junit.Assert.*;

public class KontaktdatenTest {
	@Test
	public void testKontaktdaten_1()
		throws Exception {
		String email = "";
		String telefonnummer = "";

		Kontaktdaten result = new Kontaktdaten(email, telefonnummer);

		assertNotNull(result);
		assertEquals("Kontaktdaten [email=, telefonnummer=]", result.toString());
		assertEquals("", result.getEmail());
		assertEquals("", result.getTelefonnummer());
	}

	@Test
	public void testGetEmail_1()
		throws Exception {
		Kontaktdaten fixture = new Kontaktdaten("", "");

		String result = fixture.getEmail();

		assertEquals("", result);
	}

	@Test
	public void testGetTelefonnummer_1()
		throws Exception {
		Kontaktdaten fixture = new Kontaktdaten("", "");

		String result = fixture.getTelefonnummer();

		assertEquals("", result);
	}

	@Test
	public void testSetEmail_1()
		throws Exception {
		Kontaktdaten fixture = new Kontaktdaten("", "");
		String email = "";

		fixture.setEmail(email);

	}

	@Test
	public void testSetTelefonnummer_1()
		throws Exception {
		Kontaktdaten fixture = new Kontaktdaten("", "");
		String telefonnummer = "";

		fixture.setTelefonnummer(telefonnummer);

	}

	@Test
	public void testToString_1()
		throws Exception {
		Kontaktdaten fixture = new Kontaktdaten("", "");

		String result = fixture.toString();

		assertEquals("Kontaktdaten [email=, telefonnummer=]", result);
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
		new org.junit.runner.JUnitCore().run(KontaktdatenTest.class);
	}
}