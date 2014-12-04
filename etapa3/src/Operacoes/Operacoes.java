package Operacoes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Dados.Artigo;
import Dados.BancoDeDados;
import Dados.Conferencia;
import Dados.ListagemArtigos;
import Dados.MembroDeComite;
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
	
	public ArrayList<String> getListaArtigosString(String siglaConf) {
		Conferencia conf = this.bancoDeDados.getConferencia(siglaConf);
		ListagemArtigos alocacao = conf.getAlocacao();
		ArrayList<String> artigos = new ArrayList<String>();
		for (Artigo a : alocacao.getArtigos()) {
			artigos.add(a.getId() + " - " + a.getTitulo());
		}
		return artigos;
	}

	public ArrayList<Artigo> getListaArtigosAceitos(String siglaConf) {
		ArrayList<Artigo> acetios = getListaArtigos(siglaConf);
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

	public ArrayList<String> getListaConferenciasSiglas() {
		ArrayList<String> siglas = new ArrayList<String>();
		ArrayList<Conferencia> confs = getListaConferencias();
		for(Conferencia conf : confs) {
			siglas.add(conf.getSigla());
		}
		
		return siglas;
	}
	
	public ArrayList<String> getListaSiglasConfNaoAlocadas() {
		ArrayList<Conferencia> conferencias = this.bancoDeDados.getConferencias();
		ArrayList<String> naoAlocadas = new ArrayList<String>();
		for (Conferencia conf : conferencias) {
			if (!conf.alocacaoRealizada()) {
				naoAlocadas.add(conf.getSigla());
			}
		}
		return naoAlocadas;
	}

	public void addRevisaoArtigo(int artigoId, int revisorId, int nota) {
		Artigo artigo = listagemArtigos.getArtigo(artigoId);
		artigo.addRevisao(revisorId, nota);
	}

	public ArrayList<String> getListaRevisoresString(int artigoId) {
		Artigo artigo = this.bancoDeDados.getArtigo(artigoId);
		ArrayList<String> revisores = new ArrayList<String>();
		for (Revisor r : artigo.getRevisores()) {
			revisores.add(r.getId() + " - " + r.getNome());
		}
		
		return revisores;
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
		ArrayList<Artigo> rejeitados = getListaArtigos(siglaConf);
		Collections.sort(rejeitados, new ComparadorArtigoPorMediaCresc());
		
		return rejeitados;
	}
	
	public boolean verificaRevisoesPendentes(String siglaConf) {
		Conferencia conferencia = this.bancoDeDados.getConferencia(siglaConf);
		return conferencia.getAlocacao().verificaRevisoesPendentes();
	}
	
	private class ComparadorArtigoPorMediaCresc implements Comparator<Artigo> {
		@Override
		public int compare(Artigo artigo1, Artigo artigo2) {
			return Double.compare(artigo1.getMedia(), artigo2.getMedia());
		}
	}
	
	private class ComparadorArtigoPorMediaDecresc implements Comparator<Artigo> {
		@Override
		public int compare(Artigo artigo1, Artigo artigo2) {
			return Double.compare(artigo1.getMedia(), artigo2.getMedia());
		}
	}
	
}
