package Dados;

import java.util.ArrayList;

public class BancoDeDados {
	
	private ArrayList<Pesquisador> pesquisadores;

	private ArrayList<Conferencia> conferencias;

	private ArrayList<Artigo> artigos;

	private ArrayList<Afiliacao> afiliacoes;

	private ArrayList<Revisao> revisoes;

	private ArrayList<TopicoDePesquisa> topicospesquisa;

	public BancoDeDados() {
		
		
		
	}
	
	public ArrayList<Pesquisador> getPesquisadores() {
		return this.pesquisadores;
	}
	
	public ArrayList<Conferencia> getConferencias() {
		return this.conferencias;
	}
	
	public ArrayList<Aritgo> getArtigos() {
		return this.artigos;
	}
	
	public ArrayList<Afiliacao> getAfiliacoes() {
		return this.afiliacoes;
	}
	
	public ArrayList<Revisao> getRevisoes() {
		return this.revisoes;
	}
	
	public ArrayList<TopicoDePesquisa> getTopicoDePesquisa() {
		return this.topicospesquisa;
	}
	
}
