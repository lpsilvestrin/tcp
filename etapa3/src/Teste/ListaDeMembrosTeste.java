package Teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Dados.*;

public class ListaDeMembrosTeste {
	private MembroDeComite membro;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		membro = new MembroDeComite(1, "membro", new Afiliacao("ufrgs"));
	}

	@Test
	public void testListaDeMembros() {
		ListaDeMembros l = new ListaDeMembros();
		assertNotNull(l);
	}

	@Test
	public void testListaDeMembrosListaDeMembros() {
		ListaDeMembros l = new ListaDeMembros(new ListaDeMembros());
		assertNotNull(l);
	}

	@Test
	public void testAddMembro() {
		ListaDeMembros l = new ListaDeMembros();
		l.addMembro(membro);
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
