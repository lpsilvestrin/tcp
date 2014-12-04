package Dados;

public class Revisor extends MembroDeComite {

	private int qtdArtigosAlocados;

	public Revisor(MembroDeComite membroDeComite) {
		super(membroDeComite.id, membroDeComite.nome, membroDeComite.afiliacao);
		this.qtdArtigosAlocados = 0;
	}
	
	public void addQtdArtigosAlocados() {
		this.qtdArtigosAlocados += 1;
	}

	public int getQtdArtigosAlocados() {
		return this.qtdArtigosAlocados;
	}
	
}
