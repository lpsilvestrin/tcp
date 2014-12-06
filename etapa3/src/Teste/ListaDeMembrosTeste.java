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
	public void testOrdenarNumeroDeArtigos() {
		ListaDeMembros l = new ListaDeMembros();
		MembroDeComite membro2 = new MembroDeComite(2, "membro2", new Afiliacao("UFSC"));
		membro.addQtdArtigosAlocados();
		l.addMembro(membro);
		l.addMembro(membro2);
		l.ordenarNumeroDeArtigos();
		assertEquals(membro2, l.getPrimeiroMembro());
	}
	
	@Test
	public void testOrdenarId() {
		ListaDeMembros l = new ListaDeMembros();
		MembroDeComite membro2 = new MembroDeComite(2, "membro2", new Afiliacao("UFSC"));
		l.addMembro(membro2);
		l.addMembro(membro);
		l.ordenarId();
		assertEquals(membro, l.getPrimeiroMembro());
	}

	@Test
	public void testGetPrimeiroMembro() {
		ListaDeMembros l = new ListaDeMembros();
		assertNull(l.getPrimeiroMembro());
		l.addMembro(membro);
		assertEquals(membro, l.getPrimeiroMembro());
	}

	@Test
	public void testExcluirMembro() {
		ListaDeMembros l = new ListaDeMembros();
		l.addMembro(membro);
		l.excluirMembro(membro);
		assertNull(l.getPrimeiroMembro());
	}

}
