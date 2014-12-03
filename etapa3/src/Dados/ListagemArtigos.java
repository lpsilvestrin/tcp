package Dados;

import java.util.ArrayList;

public class ListagemArtigos {

	private int numrevisores;

	private ArrayList<Artigo> artigos;

	private StringBuffer log;

	public ListagemArtigos() {
		artigos = new ArrayList<Artigo>();
	}

	public int getNumRevisores() {
		return this.numrevisores;
	}

	public StringBuffer getLog() {
		return this.log;
	}

	public void alocarRevisores(ListaDeMembros revisores) {
		
		Artigo artigo = this.getArtigoMenorID();
		ListaDeMembros revisoresAptos = new ListaDeMembros();
		for (MembroDeComite membro : revisores.getMembros()) {
			if (membro.getId() != artigo.getAutor()) {
				if (!membro.getAfiliacao().equals(obj))
			}
		}
		
	}

	public Artigo getArtigo(int id) {
		for (Artigo a : this.artigos) {
			if (a.getId() == id) {
				return a;
			}
		}
		return null;
	}

	public void setNumRevisores(int numrevisores) {
		this.numrevisores = numrevisores;
	}

	public Artigo getArtigoMenorID() {
		return this.artigos.get(0);
	}

}
