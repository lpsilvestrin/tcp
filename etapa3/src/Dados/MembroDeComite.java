package Dados;

public class MembroDeComite extends Pesquisador {

	private int qtdArtigosAlocados;
	
	public MembroDeComite(int id, String nome, Afiliacao afiliacao) {
		super(id, nome, afiliacao);
		this.qtdArtigosAlocados = 0;
	}
	
	public MembroDeComite(Pesquisador pesquisador) {
		super(pesquisador.id, pesquisador.nome, pesquisador.afiliacao);
		this.qtdArtigosAlocados = 0;
	}
	
	public void addQtdArtigosAlocados() {
		this.qtdArtigosAlocados += 1;
	}

	public int getQtdArtigosAlocados() {
		return this.qtdArtigosAlocados;
	}
	
}
