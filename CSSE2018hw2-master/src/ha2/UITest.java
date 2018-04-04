package ha2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UITest {
	UserInterface u=null;
	@Before
	public void setUp() throws Exception {
		u=new UserInterface();
	}

	@After
	public void tearDown() throws Exception {
		u=null;
	}
	

	@Test
	public void sayHelloTest() {
		
	}

}
