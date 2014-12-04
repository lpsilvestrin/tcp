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

	public void alocarRevisores(ListaDeMembros revisores, int numrevisores) {
		this.numrevisores = numrevisores;
		this.log.append("Iniciando alocação.\n");
		for (Artigo artigo : this.artigos) {
			if(artigo.getNumRevisores() < numrevisores) {
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
				
				while (artigo.getNumRevisores() < numrevisores) {
					MembroDeComite revisor = revisoresAptos.getPrimeiroMembro();
					Revisor revisorSelecionado = new Revisor(revisor);
					revisorSelecionado.addQtdArtigosAlocados();
					artigo.addRevisor(revisorSelecionado);
					
					revisoresAptos.excluirMembro(revisor);
					log.append("Artigo id " + artigo.getId() + " alocado ao revisor id " + revisor.getId());
				}
			}
		}
		log.append("Fim da alocação.");
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
