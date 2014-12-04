package Operacoes;

import java.util.ArrayList;

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
		
		String siglaConf = uiUtils.readString("Conferência");
		boolean pendentes = this.operacoes.verificaRevisoesPendentes(siglaConf);
		if(pendentes) {
			System.out.println("Essa conferência possui revisões pendentes");
		} else {
			ArrayList<String> aceitos = this.operacoes.getListaArtigosAceitos(siglaConf);
			ArrayList<String> rejeitados = this.operacoes.getListaArtigosRejeitados(siglaConf);
			System.out.println("Artigos aceitos:");
			
			for (String artigo : aceitos) {
				System.out.println(artigo);
			}
			
			System.out.println("Aritos rejeitados");
			for (String artigo : rejeitados) {
				System.out.println(artigo);
			}
		}
	}

}
