package Dados;

public class Revisor extends MembroDeComite {

	private int qtdArtigosAlocados;
	
	public Revisor(int id, String nome, Afiliacao afiliacao) {
		super(id, nome, afiliacao);
		this.qtdArtigosAlocados = 0;
	}

	public void addQtdArtigosAlocados() {
		this.qtdArtigosAlocados += 1;
	}

	public int getQtdArtigosAlocados() {
		return this.qtdArtigosAlocados;
	}
	
}
