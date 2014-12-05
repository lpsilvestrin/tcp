package Operacoes;

import java.util.ArrayList;

import Dados.ArticleException;
import Dados.InvalidConferenceException;
import Interface.UIUtils;

public class acaoRevisao {

	private Operacoes operacoes;

	public acaoRevisao(Operacoes operacoes) {
		this.operacoes = operacoes;
	}
	
	public void executar() {
		
		UIUtils uiUtils = UIUtils.INSTANCE;
		
		ArrayList<String> conferencias = this.operacoes.getListaConferenciasSiglas();
		for (String sigla : conferencias) {
			System.out.println(sigla);
		}
		String siglaSelecionada = null;
		ArrayList<String> artigos = null;
		while (siglaSelecionada == null) {
			try {
				
				siglaSelecionada = uiUtils.readString("Conferência");
				artigos = this.operacoes.getListaArtigosString(siglaSelecionada);
			} catch (InvalidConferenceException e) {
				System.out.println(e.getMessage());
				siglaSelecionada = null;
			}
		}
		for (String artigoString : artigos) {
			System.out.println(artigoString);
		}
		
		int idArtigo = uiUtils.readInteger("Id do artigo");
		ArrayList<String> revisores = this.operacoes.getListaRevisoresString(idArtigo);
		for (String revString : revisores) {
			System.out.println(revString);
		}
		
		int idRevisor = uiUtils.readInteger("Id do revisor");
		int nota = uiUtils.readInteger("Nota", -3, 3);
		try {
			this.operacoes.addRevisaoArtigo(idArtigo, idRevisor, nota);
		} catch (ArticleException e) {
			System.out.println(e.getMessage());
		}
	}

}
