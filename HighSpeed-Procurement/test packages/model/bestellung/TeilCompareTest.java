package model.bestellung;

import java.sql.Timestamp;
import org.junit.*;
import static org.junit.Assert.*;

public class TeilCompareTest {
	@Test
	public void testCompare_1()
		throws Exception {
		TeilCompare fixture = new TeilCompare();
		Teilbestellung o1 = new Teilbestellung("", "", 1, "", "", "", 1, "", "", 1.0, new Timestamp(1L));
		Teilbestellung o2 = new Teilbestellung("", "", 1, "", "", "", 1, "", "", 1.0, new Timestamp(1L));

		int result = fixture.compare(o1, o2);

		assertEquals(0, result);
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
		new org.junit.runner.JUnitCore().run(TeilCompareTest.class);
	}
}