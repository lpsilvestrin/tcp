package Teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Dados.*;

public class TopicoDePesquisaTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testTopicoDePesquisa() {
		TopicoDePesquisa t = new TopicoDePesquisa("tópico");
		assertNotNull(t);
	}

	@Test
	public void testGetTitulo() {
		TopicoDePesquisa topico;
		String titulo;
		titulo = "titulo1";
		topico = new TopicoDePesquisa(titulo);
		assertEquals(titulo,topico.getTitulo());
		titulo = "titulo2";
		topico = new TopicoDePesquisa(titulo);
		assertEquals(titulo,topico.getTitulo());
	}

}
