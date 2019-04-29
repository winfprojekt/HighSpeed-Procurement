package application.UserRoles;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {
    private String user ="";
    private String password;
    private Set<Role> roles;
    User u = new User(user, password,roles);

	@BeforeEach
	void setUp() throws Exception {
		user=null;
		password=null;
		roles=null;
	}

	@AfterEach
	void tearDown() throws Exception {
		user=null;
		password=null;
		roles=null;
	}

	@Test
	void testHashCode() {
		int result =u.hashCode();
		assertEquals(0,result);
	}


	@Test
	void testGetUser() {
		String result = u.getUser();
		assertEquals("",result);
	}

	@Test
	void testGetPassword() {
		String result = u.getPassword();
		assertEquals(null,result);
	}

	@Test
	void testGetRoles() {
		Set <Role> result = u.getRoles();
		assertEquals(null,result);
	}


}
