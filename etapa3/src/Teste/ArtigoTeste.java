package Teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Dados.*;

public class ArtigoTeste {
	private Afiliacao afil;
	private Pesquisador pesq;
	private TopicoDePesquisa topico;
	private Revisor revisor;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		afil = new Afiliacao("afiliacao");
		pesq = new Pesquisador(1, "Pesquisador", afil);
		pesq.addTopicoPesquisa(topico);
		topico = new TopicoDePesquisa("topico");
		revisor = new Revisor(new MembroDeComite(2, "revisor", afil));
	}

	@Test
	public void testArtigo() {
		Artigo a1 = new Artigo(1, "artigo1", pesq, "CONF", topico);
		assertNotNull(a1);
	}

	@Test
	public void testGetId() {
		Artigo a1;
		a1 = new Artigo(1, "artigo1", pesq, "CONF", topico);
		assertEquals(1, a1.getId());
		a1 = new Artigo(2, "artigo1", pesq, "CONF", topico);
		assertEquals(2, a1.getId());
	}

	@Test
	public void testGetTitulo() {
		Artigo a1;
		a1 = new Artigo(1, "artigo1", pesq, "CONF", topico);
		assertEquals("artigo1", a1.getTitulo());
	}

	@Test
	public void testGetAutor() {
		Artigo a1;
		a1 = new Artigo(1, "artigo1", pesq, "CONF", topico);
		assertEquals(pesq, a1.getAutor());
	}

	@Test
	public void testGetConferencia() {
		Artigo a1;
		a1 = new Artigo(1, "artigo1", pesq, "CONF", topico);
		assertEquals("CONF", a1.getConferencia());
	}

	@Test
	public void testGetTopicoPesquisa() {
		Artigo a1;
		a1 = new Artigo(1, "artigo1", pesq, "CONF", topico);
		assertEquals(topico, a1.getTopicoPesquisa());
	}

	@Test
	public void testAddRevisor() {
		Artigo a1;
		a1 = new Artigo(1, "artigo1", pesq, "CONF", topico);
		a1.addRevisor(revisor);
	}

	@Test
	public void testAddRevisao() {
		Artigo a1;
		a1 = new Artigo(1, "artigo1", pesq, "CONF", topico);
		a1.addRevisor(revisor);
		try {
			a1.addRevisao(2, 4);
			assertTrue(false);
		} catch (ArticleException e) {
		}
		try {
			a1.addRevisao(2, 3);
		} catch (ArticleException e) {
			assertTrue(e.getMessage(), false);
		}
	}

	@Test
	public void testVerificarAceitacao() {
		Artigo a1;
		a1 = new Artigo(1, "artigo1", pesq, "CONF", topico);
		try {
			a1.addRevisao(revisor.getId(), 2);
			assertTrue("nota de não revisor aceita", false);
		} catch (ArticleException e) {
		}
		a1.addRevisor(revisor);
		try {
			a1.addRevisao(revisor.getId(), 4);
			assertTrue("nota maior que 3 foi aceita", false);
		} catch (ArticleException e) {
		}
		try {
			a1.addRevisao(revisor.getId(), -4);
			assertTrue("nota menor que -3 foi aceita", false);
		} catch (ArticleException e) {
		}
		try {
			a1.addRevisao(revisor.getId(), 2);
		} catch (ArticleException e) {
			assertTrue("nota 2 deu errado", false);
		}
		assertTrue(a1.verificarAceitacao());
	}

	@Test
	public void testGetMedia() {
		Artigo a1;
		a1 = new Artigo(1, "artigo1", pesq, "CONF", topico);
		a1.addRevisor(revisor);
		try {
			a1.addRevisao(2, 3);
		} catch (ArticleException e) {
			assertTrue(e.getMessage(), false);
		}
		assertEquals(3.0, a1.getMedia(),0.1);
	}
	
	@Test
	public void testVerificaRevisoesPendentes() {
		Artigo a1;
		a1 = new Artigo(1, "artigo1", pesq, "CONF", topico);
		a1.addRevisor(revisor);
		try {
			a1.addRevisao(2, 2);
		} catch (ArticleException e) {
			assertTrue("addRevisao", false);
		}
		assertFalse(a1.verificaRevisoesPendentes(1));
	}

}
