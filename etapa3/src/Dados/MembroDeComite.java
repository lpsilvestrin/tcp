package Dados;

import java.util.ArrayList;

public class MembroDeComite extends Pesquisador {

	private int qtdArtigosAlocados;
	
	public MembroDeComite(int id, String nome, Afiliacao afiliacao, ArrayList<TopicoDePesquisa> topicos) {
		super(id, nome, afiliacao, topicos);
		this.qtdArtigosAlocados = 0;
	}
	
	public MembroDeComite(Pesquisador pesquisador) {
		super(pesquisador.id, pesquisador.nome, pesquisador.afiliacao, pesquisador.topicospesquisa);
		this.qtdArtigosAlocados = 0;
	}
	
	public void addQtdArtigosAlocados() {
		this.qtdArtigosAlocados += 1;
	}

	public int getQtdArtigosAlocados() {
		return this.qtdArtigosAlocados;
	}
	
}
