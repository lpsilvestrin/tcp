package Teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Dados.*;

public class PesquisadorTest {
	private Afiliacao afiliacao1;
	private Afiliacao afiliacao2;
	private TopicoDePesquisa topico1;
	private TopicoDePesquisa topico2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		afiliacao1 = new Afiliacao("a");
		afiliacao2 = new Afiliacao("b");
		topico1 = new TopicoDePesquisa("Topico 1");
		topico2 = new TopicoDePesquisa("Topico 2");
	}

	@Test
	public void testPesquisador() {
		Pesquisador p = new Pesquisador(0, "Teste", afiliacao1);
		assertNotNull(p);
	}

	@Test
	public void testAddTopicoPesquisa() {
		Pesquisador p = new Pesquisador(0, "Teste", afiliacao1);
		p.addTopicoPesquisa(new TopicoDePesquisa("Titulo"));
	}

	@Test
	public void testPossuiTopicoPesquisa() {
		Pesquisador p = new Pesquisador(0, "Teste", afiliacao1);
		assertFalse(p.possuiTopicoPesquisa(topico1));
		assertFalse(p.possuiTopicoPesquisa(topico2));
		p.addTopicoPesquisa(topico1);
		assertTrue(p.possuiTopicoPesquisa(topico1));
		assertFalse(p.possuiTopicoPesquisa(topico2));
		p.addTopicoPesquisa(topico2);
		assertTrue(p.possuiTopicoPesquisa(topico1));
		assertTrue(p.possuiTopicoPesquisa(topico2));
	}

	@Test
	public void testGetId() {
		Pesquisador p;
		int id = 0;
		p = new Pesquisador(id, "Teste", afiliacao1);
		assertEquals(p.getId(), id);
		id = 35;
		p = new Pesquisador(id, "Teste", afiliacao1);
		assertEquals(p.getId(), id);
		id = (int) Math.floor(Math.random() * 100.0);
		p = new Pesquisador(id, "Teste", afiliacao1);
		assertEquals(p.getId(), id);
		id = (int) Math.floor(Math.random() * 100.0);
		p = new Pesquisador(id, "Teste", afiliacao1);
		assertEquals(p.getId(), id);
	}

	@Test
	public void testGetNome() {
		Pesquisador p;
		String nome = "teste";
		p = new Pesquisador(0, nome, afiliacao1);
		assertEquals(nome,p.getNome());
		nome = "João";
		p = new Pesquisador(0, nome, afiliacao1);
		assertEquals(nome,p.getNome());
	}

	@Test
	public void testGetAfiliacao() {
		Pesquisador p;
		p = new Pesquisador(0, "teste", afiliacao1);
		assertEquals(p.getAfiliacao(), afiliacao1);
	}

	@Test
	public void testIsEqual() {
		Pesquisador p1, p2;
		p1 = new Pesquisador(0, "teste", afiliacao1);
		p2 = new Pesquisador(0, "teste", afiliacao1);
		assertTrue(p1.isEqual(p2));
		assertTrue(p2.isEqual(p1));
		p2 = new Pesquisador(2, "teste", afiliacao1);
		assertFalse(p1.isEqual(p2));
		assertFalse(p2.isEqual(p1));
		p2 = new Pesquisador(0, "teste", afiliacao2);
		assertFalse(p1.isEqual(p2));
		assertFalse(p2.isEqual(p1));
		p2 = new Pesquisador(0, "aaaa", afiliacao1);
		assertFalse(p1.isEqual(p2));
		assertFalse(p2.isEqual(p1));
		p2 = new Pesquisador(3, "bbbbb", afiliacao2);
		assertFalse(p1.isEqual(p2));
		assertFalse(p2.isEqual(p1));
	}

	@Test
	public void testPertenceAfiliacao() {
		Pesquisador p;
		p = new Pesquisador(0, "teste", afiliacao1);
		assertTrue(p.pertenceAfiliacao(afiliacao1));
		assertFalse(p.pertenceAfiliacao(afiliacao2));
	}

}
