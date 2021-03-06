package Dados;

import java.util.ArrayList;

public class Conferencia {

	private String sigla;

	private ListaDeMembros membroscomite;

	private ListagemArtigos alocacao;
	
	private boolean alocacaoRealizada;

	public Conferencia(String sigla) {
		this.sigla = sigla;
		this.membroscomite = new ListaDeMembros();
		this.alocacao = new ListagemArtigos();
		this.alocacaoRealizada = false;
	}

	public void addMembroComite(MembroDeComite membro) {
		membroscomite.addMembro(membro);
	}

	public void addArtigo(Artigo artigo) {
		this.alocacao.addArtigo(artigo);
	}
	
	public String getSigla() {
		return this.sigla;
	}

	public ListagemArtigos getAlocacao() {
		return this.alocacao;
	}
	
	public ArrayList<MembroDeComite> getMembrosComite() {
		return membroscomite.getMembros();
	}

	public ArrayList<Artigo> getArtigosAceitos() {
		return this.alocacao.getListaArtigosAceitos();
	}

	public ArrayList<Artigo> getArtigosRejeitados() {
		return this.alocacao.getListaArtigosRejeitados();
	}
	
	public MembroDeComite getMembroDeComite(int id) {
		ArrayList<MembroDeComite> membros = getMembrosComite();
		for (MembroDeComite m : membros) {
			if (m.getId() == id) {
				return m;
			}
		}
		
		return null;
	}

	public void alocarRevisores(int numrevisores) {
		alocacao.alocarRevisores(membroscomite, numrevisores);
		this.alocacaoRealizada = true;
		
	}
	
	/* para inicialização hard-coded na Base de Dados */
	public void setAlocacaoRealizada() {
		this.alocacaoRealizada = true;
	}

	public boolean alocacaoRealizada() {
		return this.alocacaoRealizada;
	}
	
	public void setNumRevisores(int num) {
		this.getAlocacao().setNumRevisores(num);
	}
	
	public int getNumRevisores() {
		return this.getAlocacao().getNumRevisores();
	}
	
}
