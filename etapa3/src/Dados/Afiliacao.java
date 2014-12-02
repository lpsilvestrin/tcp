package Dados;

public class Afiliacao {
	
	private int id;
	private String nome;

	public Afiliacao(int id, String nome) {
		this.nome = nome;
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

}
