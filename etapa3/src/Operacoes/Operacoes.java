package Operacoes;

import java.util.ArrayList;

import Dados.Artigo;
import Dados.BancoDeDados;
import Dados.Conferencia;
import Dados.ListagemArtigos;
import Dados.Pesquisador;
import Dados.Revisor;

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
		Conferencia conf = this.bancoDeDados.getConferencia(siglaConf);
		ListagemArtigos alocacao = conf.getAlocacao();

		return alocacao.getArtigos();
	}

	public ArrayList<Artigo> getListaArtigosAceitos(String siglaConf) {
		ArrayList<Artigo> artigos = getListaArtigos(siglaConf);
		ArrayList<Artigo> aceitos = new ArrayList<Artigo>();
		
		for (Artigo a : artigos) {
			if (a.verificarAceitacao()) {
				aceitos.add(a);
			}
		}
		return aceitos;
	}

	public ArrayList<Conferencia> getListaConferencias() {
		return this.bancoDeDados.getConferencias();
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

	public ArrayList<Revisor> getListaRevisores(int artigoId) {
		Artigo artigo = this.bancoDeDados.getArtigo(artigoId);
		return artigo.getRevisores();
	}

	public StringBuffer getLog(String siglaConf) {
		Conferencia conferencia = this.bancoDeDados.getConferencia(siglaConf);
		return conferencia.getAlocacao().getLog();
	}

	public ArrayList<Artigo> getListaArtigosRejeitados(String siglaConf) {
		ArrayList<Artigo> artigos = getListaArtigos(siglaConf);
		ArrayList<Artigo> rejeitados = new ArrayList<Artigo>();
		
		for (Artigo a : artigos) {
			if (!a.verificarAceitacao()) {
				rejeitados.add(a);
			}
		}
		return rejeitados;
	}

}
