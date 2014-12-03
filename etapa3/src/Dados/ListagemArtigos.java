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
		Pesquisador autor = artigo.getAutor();
		ListaDeMembros revisoresAptos = new ListaDeMembros(revisores);
		
		for (MembroDeComite membro : revisoresAptos.getMembros()) {
			
			if (membro.getId() == autor.getId()) {
				revisoresAptos.excluirMembro(membro);	
			} else if (membro.getAfiliacao().equals(autor.getAfiliacao())) {
				revisoresAptos.excluirMembro(membro);
			} else if(!membro.possuiTopicoPesquisa(artigo.getTopicoPesquisa())) {
				revisoresAptos.excluirMembro(membro);
			} else if (artigo.ehRevisor(membro)){
				revisoresAptos.excluirMembro(membro);
			}
		}
		
		revisoresAptos.ordenarNumeroDeArtigos();
		
		for (i = 0; i < numrevisores; i++) {
			MembroDeComite revisor = revisoresAptos.getPrimeiroMembro();
			artigo.addRevisor(revisor);
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
