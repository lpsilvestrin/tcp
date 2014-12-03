package Dados;

import java.util.ArrayList;

public class Conferencia {

	private String sigla;

	private ListaDeMembros membroscomite;

	private ListagemArtigos alocacao;

	private ListaDeMembros listaDeMembros;

	private ListagemArtigos listagemArtigos;

	public Conferencia(String sigla) {
		this.sigla = sigla;
	}

	public void addMembroComite(MembroDeComite membro) {
		
	}

	public String getSigla() {
		return this.sigla;
	}

	public ArrayList<MembroDeComite> getMembrosComite() {
		return membroscomite.getMembros();
	}

	public ArrayList<Artigo> getArtigosAceitos() {
		return null;
	}

	public void getMembroDeComite(int id) {
		
	}

	public void alocarRevisores(int numrevisores) {

	}

	public boolean alocacaoRealizada() {
		return false;
	}

}
