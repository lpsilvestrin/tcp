package Teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Dados.*;

public class ListagemArtigosTeste {
	private Artigo artigo1;
	private Artigo artigo2;
	private Artigo artigo3;
	private TopicoDePesquisa t1;
	private TopicoDePesquisa t2;
	private TopicoDePesquisa t3;
	private Afiliacao afiliacao1;
	private Afiliacao afiliacao2;
	private ListaDeMembros lm;
	private MembroDeComite m1;
	private MembroDeComite m2;
	private MembroDeComite m3;
	private Pesquisador p1;
	private Pesquisador p2;
	private Pesquisador p3;
	private Conferencia conf1;
	private Conferencia conf2;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		conf1 = new Conferencia("CONF1");
		conf2 = new Conferencia("CONF2");
		t1 = new TopicoDePesquisa("Topico1");
		t2 = new TopicoDePesquisa("Topico2");
		t3 = new TopicoDePesquisa("Topico3");
		afiliacao1 = new Afiliacao("Afiliacao1");
		afiliacao2 = new Afiliacao("Afiliacao2");
		lm = new ListaDeMembros();
		m1 = new MembroDeComite(1, "membro1", afiliacao1);
		m2 = new MembroDeComite(2, "membro2", afiliacao2);
		m3 = new MembroDeComite(3, "membro2", afiliacao2);
		m1.addTopicoPesquisa(t1);
		m1.addTopicoPesquisa(t2);
		m2.addTopicoPesquisa(t2);
		m2.addTopicoPesquisa(t3);
		m3.addTopicoPesquisa(t3);
		m3.addTopicoPesquisa(t1);
		lm.addMembro(m1);
		lm.addMembro(m2);
		lm.addMembro(m3);
		p1 = new Pesquisador(4, "pesquisador1", afiliacao1);
		p1.addTopicoPesquisa(t1);
		p2 = new Pesquisador(5, "pesquisador2", afiliacao1);
		p2.addTopicoPesquisa(t2);
		p3 = new Pesquisador(6, "pesquisador3", afiliacao2);
		p3.addTopicoPesquisa(t3);
		artigo1 = new Artigo(1, "artigo1", p1, conf1.getSigla(), t1);
		artigo2 = new Artigo(2, "artigo2", p2, conf2.getSigla(), t2);
		artigo3 = new Artigo(3, "artigo3", p3, conf2.getSigla(), t3);
	}
	
	@Test
	public void testListagemArtigos() {
		ListagemArtigos l1 = new ListagemArtigos();
		assertNotNull(l1);
	}
	
	@Test
	public void testAddArtigo() {
		ListagemArtigos l1 = new ListagemArtigos();
		l1.addArtigo(artigo1);
		l1.addArtigo(artigo2);
		l1.addArtigo(artigo3);
		assertNotNull(l1);
	}
	
	@Test
	public void testAlocarRevisores() {
		ListagemArtigos l1 = new ListagemArtigos();
		l1.addArtigo(artigo1);
		l1.addArtigo(artigo2);
		l1.addArtigo(artigo3);
		l1.alocarRevisores(lm, 2);
	}

	@Test
	public void testGetNumRevisores() {
		ListagemArtigos l1 = new ListagemArtigos();
		l1.addArtigo(artigo1);
		l1.addArtigo(artigo2);
		l1.addArtigo(artigo3);
		assertEquals(0, l1.getNumRevisores());
		l1.alocarRevisores(lm, 2);
		assertEquals(2, l1.getNumRevisores());
	}

	@Test
	public void testGetLog() {
		ListagemArtigos l1 = new ListagemArtigos();
		StringBuffer b = l1.getLog();
		assertNotNull(b);
	}

	@Test
	public void testGetArtigo() {
		ListagemArtigos l1 = new ListagemArtigos();
		l1.addArtigo(artigo1);
		l1.addArtigo(artigo2);
		assertEquals(artigo1, l1.getArtigo(artigo1.getId()));
		assertEquals(artigo2, l1.getArtigo(artigo2.getId()));
		assertNull(l1.getArtigo(artigo3.getId()));
	}

	@Test
	public void testSetNumRevisores() {
		ListagemArtigos l1 = new ListagemArtigos();
		l1.setNumRevisores(3);
	}

	@Test
	public void testGetArtigoMenorID() {
		ListagemArtigos l1 = new ListagemArtigos();
		assertNull(l1.getArtigoMenorID());
		l1.addArtigo(artigo2);
		assertEquals(artigo2, l1.getArtigoMenorID());
		l1.addArtigo(artigo1);
		assertEquals(artigo1, l1.getArtigoMenorID());
	}

}
