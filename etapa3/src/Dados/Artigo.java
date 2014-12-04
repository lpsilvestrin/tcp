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

	public void addRevisao(Revisor revisor, int nota) {
		Revisao revisao = new Revisao(revisor, nota);
		revisoes.add(revisao);
	}

	public boolean verificarAceitacao() {
		return false;
	}

	public void addRevisor(Revisor revisor) {
		this.revisores.add(revisor);
	}

	public boolean ehRevisor(Revisor revisor) {
		for (Revisor r : this.revisores) {
			if (r.equals(revisor)) {
				return true;
			}
		}
		return false;
	}
	
	public double getMedia() {
		return 0;
	}

	public int getNumRevisores() {
		return this.revisores.size();
	}
	
	public ArrayList<Revisor> getRevisores() {
		return this.revisores;
	}
	
}
