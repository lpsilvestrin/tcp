package Operacoes;

import java.util.ArrayList;

import Dados.InvalidConferenceException;
import Interface.UIUtils;

public class acaoListagem {

	private Operacoes operacoes;

	public acaoListagem(Operacoes operacoes) {
		this.operacoes = operacoes;
	}
	
	public void executar() {
		UIUtils uiUtils = UIUtils.INSTANCE;
		
		ArrayList<String> conferencias = this.operacoes.getListaConferenciasSiglas();
		for (String sigla : conferencias) {
			System.out.println(sigla);
		}
		String siglaConf = null;
		boolean pendentes = false;
		while (siglaConf == null) {
			siglaConf = uiUtils.readString("Conferência");
			try {
				pendentes = this.operacoes.verificaRevisoesPendentes(siglaConf);
			} catch (InvalidConferenceException e) {
				System.out.println(e.getMessage());
				siglaConf = null;				
			}
		}
		if(pendentes) {
			System.out.println("Essa conferência possui revisões pendentes");
		} else {
			ArrayList<String> aceitos = this.operacoes.getListaArtigosAceitos(siglaConf);
			ArrayList<String> rejeitados = this.operacoes.getListaArtigosRejeitados(siglaConf);
			System.out.println("Artigos aceitos:");
			
			for (String artigo : aceitos) {
				System.out.println(artigo);
			}
			
			System.out.println("Artigos rejeitados");
			for (String artigo : rejeitados) {
				System.out.println(artigo);
			}
		}
	}

}
