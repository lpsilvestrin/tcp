package Interface;
import Operacoes.Operacoes;
import Operacoes.acaoAlocar;
import Operacoes.acaoListagem;
import Operacoes.acaoRevisao;

public class InterfacePrincipal {

	private Operacoes operacoes;

	private acaoListagem acaoListagem;

	private acaoAlocar acaoAlocar;

	private acaoRevisao acaoRevisao;
	
	private int opcao;
	
	public InterfacePrincipal(Operacoes operacoes) {
		this.operacoes = operacoes;
		this.opcao = 0;
	}
	
	public void iniciaInterface() {
		UIUtils uiUtils = UIUtils.INSTANCE;
		
		do {
			System.out.println("Escolha uma opção:");
			System.out.println("1 - Alocar artigos");
			System.out.println("2 - Fazer revisão");
			System.out.println("3 - Listar artigos");
			System.out.println("0 - Sair");
			
			opcao = uiUtils.readInteger("Opcao", 0, 3); 
		} while (opcao != 0);
	}
	
}
