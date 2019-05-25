package TestModel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Role;

class RoleTest {
	private Long roleId=123L;
	private String name;
	Role r=new Role (roleId, name);

	@BeforeEach
	void setUp() throws Exception {
		roleId=null;
		name = null;
	}

	@AfterEach
	void tearDown() throws Exception {
		roleId=null;
		name=null;
	}

	@Test
	void testGetRoleId() {
		Long result = r.getRoleId();
		assertTrue(result==123);
	}
	@Test 
	void testGetName() {
		String result = r.getName();
		assertEquals(null,result);
	}
	@Test
	void testHashCode() {
		int result =r.hashCode();
		assertEquals(123,result);
	}

}
