package Operacoes;

import java.util.ArrayList;

import Dados.Artigo;
import Dados.BancoDeDados;
import Dados.Conferencia;
import Dados.ListagemArtigos;
import Dados.Pesquisador;

public class Operacoes {

	private Conferencia conferencia;

	private ListagemArtigos listagemArtigos;

	private BancoDeDados bancoDeDados;

	public Operacoes() {
		bancoDeDados = new BancoDeDados();
	}
	
	public void criarAlocacao(String conferencia, int numrevisores) {
		
	}

	public ArrayList<Artigo> getListaArtigos(String conferencia) {
		return null;
	}

	public ArrayList<Artigo> getListaArtigosAceitos(String conferencia) {
		return null;
	}

	public ArrayList<Conferencia> getListaConferencias() {
		return null;
	}

	public ArrayList<Conferencia> getListaConferenciasNaoAlocadas() {
		return null;
	}

	public void addRevisaoArtigo(int artigoId, int revisorId, int nota) {
		Artigo artigo = listagemArtigos.getArtigo(artigoId);
		ArrayList<Revisor> revisores = artigo.getRevisores();
		artigo.addRevisao(revisor, nota);
	}

	public ArrayList<Pesquisador> getListaRevisores() {
		return null;
	}

	public StringBuffer getLog(String conferencia) {
		return null;
	}

	public ArrayList<Artigo> getListaArtigosRejeitados(String conferencia) {
		return null;
	}

}
