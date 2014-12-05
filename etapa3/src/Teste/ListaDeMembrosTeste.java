package Teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Dados.*;

public class ListaDeMembrosTeste {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testListaDeMembros() {
		ListaDeMembros l = new ListaDeMembros();
		assertNotNull(l);
	}

	@Test
	public void testListaDeMembrosListaDeMembros() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddMembro() {
		fail("Not yet implemented");
	}

	@Test
	public void testExcluirMembro() {
		fail("Not yet implemented");
	}

	@Test
	public void testOrdenarNumeroDeArtigos() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPrimeiroMembro() {
		fail("Not yet implemented");
	}

}
