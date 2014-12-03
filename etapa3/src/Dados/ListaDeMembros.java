package Dados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
		Collections.sort(this.membrosDeComite, new ComparadorMembrosDeComite());
	}

	public MembroDeComite getPrimeiroMembro() {
		return membrosDeComite.get(0);
	}
	
	public class ComparadorMembrosDeComite implements Comparator<MembroDeComite> {
		@Override
		public int compare(MembroDeComite membro1, MembroDeComite membro2) {
			return Integer.compare(membro1.getQtdArtigosAlocados(), membro2.getQtdArtigosAlocados());
		}
	}

}


