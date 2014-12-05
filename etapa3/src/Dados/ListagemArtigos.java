package Dados;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class ListagemArtigos {

	private int numrevisores;

	private ArrayList<Artigo> artigos;

	private StringBuffer log;

	public ListagemArtigos() {
		artigos = new ArrayList<Artigo>();
		this.log = new StringBuffer();
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
				Iterator<MembroDeComite> it = revisoresAptos.getMembros().iterator();
				while (it.hasNext()) {
					MembroDeComite membro = it.next();
					if (membro.getId() == autor.getId()) {
						it.remove();	
					} else if (membro.getAfiliacao().equals(autor.getAfiliacao())) {
						it.remove();
					} else if(!membro.possuiTopicoPesquisa(artigo.getTopicoPesquisa())) {
						it.remove();
					} else if (artigo.ehRevisor(membro)){
						it.remove();
					}
				}
				
				revisoresAptos.ordenarNumeroDeArtigos();
				while (artigo.getNumRevisores() < numrevisores &&
					   !revisoresAptos.isEmpty()) {
					MembroDeComite revisor = revisoresAptos.getPrimeiroMembro();
					Revisor revisorSelecionado = new Revisor(revisor);
					revisorSelecionado.addQtdArtigosAlocados();
					artigo.addRevisor(revisorSelecionado);
					
					revisoresAptos.excluirMembro(revisor);
					this.log.append("Artigo id " + artigo.getId() + " alocado ao revisor id " + revisor.getId() + "\n");
				}
			}
		}
		this.log.append("Fim da alocação.");
	}

	public ArrayList<Artigo> getArtigos() {
		return this.artigos;
	}
	
	public void addArtigo(Artigo artigo) {
		this.artigos.add(artigo);
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
	
	public boolean verificaRevisoesPendentes() {
		
		boolean pendentes = false;
		for (Artigo artigo : this.artigos) {
			if (artigo.verificaRevisoesPendentes(this.getNumRevisores())) {
				pendentes = true;
			}
		}
		return pendentes;
	}
	
	public ArrayList<Artigo> getListaArtigosAceitos() {
		ArrayList<Artigo> aceitos = new ArrayList<Artigo>();
		
		for (Artigo a : this.artigos) {
			if (a.verificarAceitacao()) {
				aceitos.add(a);
			}
		}
		return aceitos;
	}
	
	public ArrayList<Artigo> getListaArtigosRejeitados() {
		ArrayList<Artigo> rejeitados = new ArrayList<Artigo>();
		
		for (Artigo a : this.artigos) {
			if (!a.verificarAceitacao()) {
				rejeitados.add(a);
			}
		}
		return rejeitados;
	}
}
