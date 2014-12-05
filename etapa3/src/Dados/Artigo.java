package Dados;

import java.util.ArrayList;

import Teste.RevisaoTest;

public class Artigo {

	private int id;

	private String titulo;

	private Pesquisador autor;

	private String conferencia;

	private TopicoDePesquisa topicopesquisa;

	private ArrayList<Revisao> revisoes;
	
	private ArrayList<Revisor> revisores;

	public Artigo(int id, String titulo, Pesquisador autor, String conferencia, TopicoDePesquisa topicopesquisa) {
	
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.conferencia = conferencia;
		this.topicopesquisa = topicopesquisa;
		this.revisoes = new ArrayList<Revisao>();
		this.revisores = new ArrayList<Revisor>();
		
	}

	public int getId() {
		return this.id;
	}
	
	public String getTitulo() {
		return this.titulo;
	}

	public Pesquisador getAutor() {
		return this.autor;
	}

	public String getConferencia() {
		return this.conferencia;
	}

	public TopicoDePesquisa getTopicoPesquisa() {
		return this.topicopesquisa;
	}

	public void addRevisao(int revisorId, int nota) throws ArticleException {
		if (ehRevisor(revisorId)) {
			Revisao revisao = new Revisao(getRevisor(revisorId), nota);
			revisoes.add(revisao);
		} else {
			throw new ArticleException();
		}
	}

	public boolean verificarAceitacao() {
		double media = getMedia();
		
		if (media >= 0) {
			return true;
		} else {
			return false;
		}
	}

	public void addRevisor(Revisor revisor) {
		this.revisores.add(revisor);
	}
	
	public boolean ehRevisor(int revisorId) {
		for (Revisor r : this.revisores) {
			if (r.getId() == revisorId){
				return true;
			}
		}
		return false;
	}
	
	public double getMedia() {
		float soma = 0;
		float cont = 0;
		for (Revisao r : this.revisoes) {
			soma += r.getNota();
			cont++;
		}
		
		return soma/cont;
	}

	public int getNumRevisores() {
		return this.revisores.size();
	}
	
	public ArrayList<Revisor> getRevisores() {
		return this.revisores;
	}
	
	private Revisor getRevisor(int id) {
		for (Revisor r : this.revisores) {
			if (r.getId() == id) {
				return r;
			}
		}
		
		return null;
	}
	
	public boolean verificaRevisoesPendentes(int numRevisores) {
		if (numRevisores > revisoes.size()) {
			return true;
		} else {
			return false;
		}
	}
	
}
