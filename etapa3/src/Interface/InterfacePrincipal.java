package Interface;
import java.io.BufferedReader;                                                  
import java.io.InputStreamReader;
import Operacoes.Operacoes;
import Operacoes.acaoAlocar;
import Operacoes.acaoListagem;
import Operacoes.acaoRevisao;

public class InterfacePrincipal {

	private Operacoes operacoes;

	private acaoListagem acaoListagem;

	private acaoAlocar acaoAlocar;

	private acaoRevisao acaoRevisao;
	
	private Integer opcao;
	
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
			this.opcao = uiUtils.readInteger("Opcao", 0, 3); 
			
			switch (this.opcao) {
			case 1:
				this.acaoAlocar = new acaoAlocar(this.operacoes);
				System.out.println("Executando alocação.");
				this.acaoAlocar.executar();
				break;
			case 2:
				this.acaoRevisao = new acaoRevisao(this.operacoes);
				this.acaoRevisao.executar();
				break;
			case 3:
				this.acaoListagem = new acaoListagem(this.operacoes);
				this.acaoListagem.executar();
				break;
			case 0:
				System.out.println("Sistema encerrado.");
				break;
			default:
				System.out.println("Opção inválida");
				break;
			}				
		} while (this.opcao != 0);
	}
}
