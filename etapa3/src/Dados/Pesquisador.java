package Dados;

import java.util.ArrayList;

public class Pesquisador {

	protected int id;

	protected String nome;

	protected Afiliacao afiliacao;

	protected ArrayList<TopicoDePesquisa> topicospesquisa;

	private TopicoDePesquisa topicoDePesquisa;

	public Pesquisador(int id, String nome, Afiliacao afiliacao) {

	}

	public void addTopicoPesquisa(TopicoDePesquisa topicopesquisa) {

	}

	public boolean possuiTopicoPesquisa(TopicoDePesquisa topicopesquisa) {
		return false;
	}

	public int getId() {
		return 0;
	}

	public String getNome() {
		return null;
	}

	public Afiliacao getAfiliacao() {
		return null;
	}

	public boolean isEqual(Pesquisador pesquisador) {
		return false;
	}

	public boolean pertenceAfiliacao(Afiliacao afiliacao) {
		return false;
	}

}
