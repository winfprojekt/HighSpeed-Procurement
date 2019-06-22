package model.lieferant;

import org.junit.*;
import static org.junit.Assert.*;

public class BankdatenTest {
	@Test
	public void testBankdaten_1()
		throws Exception {
		String bank = "";
		String iBAN = "";
		String bicSwift = "";
		int steuernummer = 1;

		Bankdaten result = new Bankdaten(bank, iBAN, bicSwift, steuernummer);

		assertNotNull(result);
		assertEquals("Bankdaten [bank=, iBAN=, bicSwift=, steuernummer=1]", result.toString());
		assertEquals("", result.getiBAN());
		assertEquals("", result.getBicSwift());
		assertEquals(1, result.getSteuernummer());
		assertEquals("", result.getBank());
	}

	@Test
	public void testGetBank_1()
		throws Exception {
		Bankdaten fixture = new Bankdaten("", "", "", 1);

		String result = fixture.getBank();

		assertEquals("", result);
	}

	@Test
	public void testGetBicSwift_1()
		throws Exception {
		Bankdaten fixture = new Bankdaten("", "", "", 1);

		String result = fixture.getBicSwift();

		assertEquals("", result);
	}

	@Test
	public void testGetSteuernummer_1()
		throws Exception {
		Bankdaten fixture = new Bankdaten("", "", "", 1);

		int result = fixture.getSteuernummer();

		assertEquals(1, result);
	}

	@Test
	public void testGetiBAN_1()
		throws Exception {
		Bankdaten fixture = new Bankdaten("", "", "", 1);

		String result = fixture.getiBAN();

		assertEquals("", result);
	}

	@Test
	public void testSetBank_1()
		throws Exception {
		Bankdaten fixture = new Bankdaten("", "", "", 1);
		String bank = "";

		fixture.setBank(bank);

	}

	@Test
	public void testSetBicSwift_1()
		throws Exception {
		Bankdaten fixture = new Bankdaten("", "", "", 1);
		String bicSwift = "";

		fixture.setBicSwift(bicSwift);

	}

	@Test
	public void testSetSteuernummer_1()
		throws Exception {
		Bankdaten fixture = new Bankdaten("", "", "", 1);
		int steuernummer = 1;

		fixture.setSteuernummer(steuernummer);

	}

	@Test
	public void testSetiBAN_1()
		throws Exception {
		Bankdaten fixture = new Bankdaten("", "", "", 1);
		String iBAN = "";

		fixture.setiBAN(iBAN);

	}

	@Test
	public void testToString_1()
		throws Exception {
		Bankdaten fixture = new Bankdaten("", "", "", 1);

		String result = fixture.toString();

		assertEquals("Bankdaten [bank=, iBAN=, bicSwift=, steuernummer=1]", result);
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
		new org.junit.runner.JUnitCore().run(BankdatenTest.class);
	}
}