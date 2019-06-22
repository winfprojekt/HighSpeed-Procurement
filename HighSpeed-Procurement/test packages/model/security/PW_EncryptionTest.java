package model.security;

import org.junit.*;
import static org.junit.Assert.*;

public class PW_EncryptionTest {
	@Test
	public void testPW_Encryption_1()
		throws Exception {
		String data = "";

		PW_Encryption result = new PW_Encryption(data);

		assertNotNull(result);
		assertEquals("E3B0C44298FC1C149AFBF4C8996FB92427AE41E4649B934CA495991B7852B855", result.getData());
	}

	@Test
	public void testPW_Encryption_2()
		throws Exception {
		String data = "";

		PW_Encryption result = new PW_Encryption(data);

		assertNotNull(result);
		assertEquals("E3B0C44298FC1C149AFBF4C8996FB92427AE41E4649B934CA495991B7852B855", result.getData());
	}

	@Test
	public void testGetData_1()
		throws Exception {
		PW_Encryption fixture = new PW_Encryption("");

		String result = fixture.getData();

		assertEquals("E3B0C44298FC1C149AFBF4C8996FB92427AE41E4649B934CA495991B7852B855", result);
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
		new org.junit.runner.JUnitCore().run(PW_EncryptionTest.class);
	}
}