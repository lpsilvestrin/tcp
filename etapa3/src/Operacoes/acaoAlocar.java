package Operacoes;

import java.util.ArrayList;

import Interface.UIUtils;

import Dados.ListagemArtigos;

public class acaoAlocar {

	private Operacoes operacoes;
	
	public acaoAlocar(Operacoes operacoes) {
		this.operacoes = operacoes;
	}
	
	public void executar() {
		
		UIUtils uiUtils = UIUtils.INSTANCE;
		ArrayList<String> conferencias = this.operacoes.getListaSiglasConfNaoAlocadas();
		for (String sigla: conferencias) {
			System.out.println(sigla);
		}
		
		String siglaSelecionada = uiUtils.readString("Conferência");
		int numRevisores = uiUtils.readInteger("Número de revisores", 2, 5);
		this.operacoes.criarAlocacao(siglaSelecionada, numRevisores);
		StringBuffer log = this.operacoes.getLog(siglaSelecionada);
		
		System.out.println(log);
		
	}

}
