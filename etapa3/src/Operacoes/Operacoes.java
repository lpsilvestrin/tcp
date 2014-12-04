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
	
	public void criarAlocacao(String sigla, int numrevisores) {
		Conferencia conferencia = bancoDeDados.getConferencia(sigla);
		conferencia.alocarRevisores(numrevisores);
	}

	public ArrayList<Artigo> getListaArtigos(String siglaConf) {
		return null;
	}

	public ArrayList<Artigo> getListaArtigosAceitos(String conferencia) {
		return null;
	}

	public ArrayList<Conferencia> getListaConferencias() {
		return null;
	}

	public ArrayList<Conferencia> getListaConferenciasNaoAlocadas() {
		ArrayList<Conferencia> conferencias = this.bancoDeDados.getConferencias();
		ArrayList<Conferencia> naoAlocadas = new ArrayList<Conferencia>();
		for (Conferencia conf : conferencias) {
			if (!conf.alocacaoRealizada()) {
				naoAlocadas.add(conf);
			}
		}
		return naoAlocadas;
	}

	public void addRevisaoArtigo(int artigoId, int revisorId, int nota) {
		Artigo artigo = listagemArtigos.getArtigo(artigoId);
		artigo.addRevisao(revisorId, nota);
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
