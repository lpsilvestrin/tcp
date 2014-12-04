package Dados;

import java.util.ArrayList;

public class Conferencia {

	private String sigla;

	private ListaDeMembros membroscomite;

	private ListagemArtigos alocacao;

	public Conferencia(String sigla) {
		this.sigla = sigla;
		membroscomite = new ListaDeMembros();
		alocacao = new ListagemArtigos();
	}

	public void addMembroComite(MembroDeComite membro) {
		membroscomite.addMembro(membro);
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
	}

	public boolean alocacaoRealizada() {
		return false;
	}

}
