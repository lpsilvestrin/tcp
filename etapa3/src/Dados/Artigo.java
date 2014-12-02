package Dados;

import java.util.ArrayList;

import Teste.RevisaoTest;

public class Artigo {

	private int id;

	private String titulo;

	private int autor;

	private String conferencia;

	private TopicoDePesquisa topicopesquisa;

	private ArrayList<Revisao> revisoes;

	public Artigo(int id, String titulo, int autor, String conferencia, TopicoDePesquisa topicopesquisa) {
	
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.conferencia = conferencia;
		this.topicopesquisa = topicopesquisa;
		revisoes = new ArrayList<Revisao>();
		
	}

	public int getId() {
		return this.id;
	}
	
	public String getTitulo() {
		return this.titulo;
	}

	public int getAutor() {
		return this.autor;
	}

	public String getConferencia() {
		return this.conferencia;
	}

	public TopicoDePesquisa getTopicoPesquisa() {
		return this.topicopesquisa;
	}

	public void addRevisao(Revisor revisor, int nota) {
		
	}

	public boolean verificarAceitacao() {
		return false;
	}

	public void addRevisor(Revisor revisor) {

	}

	public double getMedia() {
		return 0;
	}

}
