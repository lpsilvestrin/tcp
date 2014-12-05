package Teste;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Dados.*;

public class MembroDeComiteTeste {
	private Afiliacao afiliacao1;
	private Pesquisador pesquisador1;
	private ArrayList<TopicoDePesquisa> topicos;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		afiliacao1 = new Afiliacao("afiliacao");
		pesquisador1 = new Pesquisador(0, "teste", afiliacao1);
		topicos = new ArrayList<>();
	}

	@Test
	public void testMembroDeComite() {
		MembroDeComite m1 = new MembroDeComite(0, "teste", afiliacao1);
		MembroDeComite m2 = new MembroDeComite(0, "teste", afiliacao1, topicos);
		MembroDeComite m3 = new MembroDeComite(pesquisador1);
		assertNotNull(m1);
		assertNotNull(m2);
		assertNotNull(m3);
	}

	@Test
	public void testAddQtdArtigosAlocados() {
		MembroDeComite m1 = new MembroDeComite(0, "teste", afiliacao1);
		m1.addQtdArtigosAlocados();
		m1.addQtdArtigosAlocados();
		m1.addQtdArtigosAlocados();
	}

	@Test
	public void testGetQtdArtigosAlocados() {
		MembroDeComite m1 = new MembroDeComite(0, "teste", afiliacao1);
		assertEquals(0, m1.getQtdArtigosAlocados());
		m1.addQtdArtigosAlocados();
		assertEquals(1, m1.getQtdArtigosAlocados());
		m1.addQtdArtigosAlocados();
		assertEquals(2, m1.getQtdArtigosAlocados());
	}

}
