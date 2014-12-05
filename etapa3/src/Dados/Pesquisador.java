package Dados;

import java.util.ArrayList;

import Teste.TopicoDePesquisaTest;

import com.sun.java.swing.plaf.motif.MotifBorders.ToggleButtonBorder;


public class Pesquisador {

	protected int id;

	protected String nome;

	protected Afiliacao afiliacao;

	protected ArrayList<TopicoDePesquisa> topicospesquisa;

	public Pesquisador(int id, String nome, Afiliacao afiliacao) {
		this.id = id;
		this.nome = nome;
		this.afiliacao = afiliacao;
		this.topicospesquisa = new ArrayList<TopicoDePesquisa>();
	}

	public void addTopicoPesquisa(TopicoDePesquisa topicopesquisa) {
		this.topicospesquisa.add(topicopesquisa);
	}

	public boolean possuiTopicoPesquisa(TopicoDePesquisa topicopesquisa) {
		boolean possui = false;
		for (TopicoDePesquisa topico : this.topicospesquisa) {
			if (topico.equals(topicopesquisa)) {
				possui = true;
			}
		}
		return possui;
	}

	public int getId() {
		return this.id;
	}

	public String getNome() {
		return this.nome;
	}

	public Afiliacao getAfiliacao() {
		return this.afiliacao;
	}

	public boolean isEqual(Pesquisador pesquisador) {
		if (this.id == pesquisador.getId()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean pertenceAfiliacao(Afiliacao afiliacao) {
		if (afiliacao.getNome().equals(this.afiliacao.getNome())) {
			return true;
		} else {
			return false;
		}
	}

}
