package Teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Dados.*;

public class RevisorTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		Revisor revisor = new Revisor(new MembroDeComite(1, "revisor", new Afiliacao("UFRGS")));
		assertNotNull(revisor);
	}

	@Test
	public void testRevisor() {
		fail("Not yet implemented");
	}

}
