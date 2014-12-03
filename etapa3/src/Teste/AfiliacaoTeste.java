package Teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Dados.*;

public class AfiliacaoTeste {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAfiliacao() {
		Afiliacao a = new Afiliacao("nome");
		assertNotNull(a);
	}
	
	@Test
	public void testGetNome() {
		String nome;
		Afiliacao a;
		nome = "Nome 1";
		a = new Afiliacao(nome);
		assertEquals(nome, a.getNome());
		nome = "Nome 2";
		a = new Afiliacao(nome);
		assertEquals(nome, a.getNome());
	}
}
