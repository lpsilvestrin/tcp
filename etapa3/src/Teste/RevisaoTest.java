package Teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import Dados.*;

public class RevisaoTest {
	private Revisor revisor;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		revisor = new Revisor(new MembroDeComite(0, "revisor", new Afiliacao("ufrgs")));
	}

	@Test
	public void testRevisao() {
		Revisao r = new Revisao(revisor, 3);
		assertNotNull(r);
	}

	@Test
	public void testGetRevisor() {
		Revisao r = new Revisao(revisor, 3);
		assertEquals(revisor, r.getRevisor());
	}

	@Test
	public void testGetNota() {
		Revisao r;
		r = new Revisao(revisor, 3);
		assertEquals(3, r.getNota());
		r = new Revisao(revisor, 2);
		assertEquals(2, r.getNota());
	}

	@Test
	public void testSetNota() {
		Revisao r;
		r = new Revisao(revisor, 2);
		assertEquals(2, r.getNota());
		r.setNota(-2);
		assertEquals(-2, r.getNota());
	}

}
