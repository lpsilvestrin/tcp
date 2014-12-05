package Teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import Dados.*;

public class ConferenciaTeste {
	private MembroDeComite membroDeComite1;
	private Afiliacao afiliacao1;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		afiliacao1 = new Afiliacao("afiliacao")
		membroDeComite1 = new MembroDeComite(0, "nome", afiliacao1);
	}

	@Test
	public void testConferencia() {
		Conferencia c = new Conferencia("SIGLA");
		assertNotNull(c);
	}

	@Test
	public void testAddMembroComite() {
		Conferencia c = new Conferencia("SIGLA");
		c.addMembroComite(membroDeComite1);
	}

	@Test
	public void testGetSigla() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMembrosComite() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetArtigosAceitos() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMembroDeComite() {
		fail("Not yet implemented");
	}

	@Test
	public void testAlocarRevisores() {
		fail("Not yet implemented");
	}

	@Test
	public void testAlocacaoRealizada() {
		fail("Not yet implemented");
	}

}
