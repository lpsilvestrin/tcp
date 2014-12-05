package Teste;

import static org.junit.Assert.*;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
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
		afiliacao1 = new Afiliacao("afiliacao");
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
		Conferencia c;
		c = new Conferencia("SIGLA");
		assertEquals("SIGLA",c.getSigla());
		c = new Conferencia("UFRGS");
		assertEquals("UFRGS",c.getSigla());
	}

	@Test
	public void testGetMembrosComite() {
		ArrayList<MembroDeComite> membros;
		Conferencia c = new Conferencia("SIGLA");
		membros = c.getMembrosComite();
		assertTrue(membros.isEmpty());
		membros.add(membroDeComite1);
		assertFalse(membros.isEmpty());
	}

	@Test
	public void testGetArtigosAceitos() {
		Conferencia c = new Conferencia("SIGLA");
		ArrayList<Artigo> listaArtigos;
		listaArtigos = c.getArtigosAceitos();
		assertTrue(listaArtigos.isEmpty());
		assertThat(listaArtigos.size(), equalTo(0));
	}

	@Test
	public void testGetMembroDeComite() {
		Conferencia c = new Conferencia("SIGLA");
		MembroDeComite m;
		c.addMembroComite(membroDeComite1);
		m = c.getMembroDeComite(0);
		assertEquals(membroDeComite1, m);
	}

	@Test
	public void testAlocarRevisores() {
		Conferencia c = new Conferencia("SIGLA");
		c.alocarRevisores(2);
	}

	@Test
	public void testAlocacaoRealizada() {
		Conferencia c = new Conferencia("SIGLA");
		c.alocarRevisores(2);
		assertFalse(c.alocacaoRealizada());
	}

}
