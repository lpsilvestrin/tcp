package Dados;


public class Revisao {

	private Revisor revisor;

	private int nota;

	public Revisao(Revisor revisor, int nota) {
		this.revisor = revisor;
		this.nota = nota;
	}

	public Revisor getRevisor() {
		return this.revisor;
	}

	public int getNota() {
		return this.nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public boolean verificarRecebida() {
		return false;
	}

}
