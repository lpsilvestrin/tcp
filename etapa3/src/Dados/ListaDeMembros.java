package Dados;

import java.util.ArrayList;

public class ListaDeMembros {

	private ArrayList<MembroDeComite> membrosDeComite;

	public ListaDeMembros() {
		this.membrosDeComite = new ArrayList<MembroDeComite>();
	}

	public ListaDeMembros(ListaDeMembros lista) {

	}
	
	public ArrayList<MembroDeComite> getMembros() {
		return this.membrosDeComite;
	}
	
	public void addMembro(MembroDeComite membro) {
		this.membrosDeComite.add(membro);
	}

	public void excluirMembro(MembroDeComite membro) {
		this.membrosDeComite.remove(membro);
	}

	public void ordenarNumeroDeArtigos() {
		
	}

	public MembroDeComite getPrimeiroMembro() {
		return null;
	}

}
