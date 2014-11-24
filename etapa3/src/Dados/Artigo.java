import java.util.ArrayList;
import Dados.Pesquisador;
import Dados.TopicoDePesquisa;
import Dados.Revisao;

public class Artigo {

	private int id;

	private String titulo;

	private Pesquisador autor;

	private String conferencia;

	private TopicoDePesquisa topicopesquisa;

	private ArrayList<Revisao> revisoes;

	private Pesquisador pesquisador;

	private Revisao revisao;

	public void Artigo(int id, String titulo, Pesquisador autor, String conferencia, TopicoDePesquisa topicopesquisa) {

	}

	public int getId() {
		return 0;
	}

	public String getTitulo() {
		return null;
	}

	public Pesquisador getAutor() {
		return null;
	}

	public String getConferencia() {
		return null;
	}

	public TopicoDePesquisa getTopicoPesquisa() {
		return null;
	}

	public void addRevisao(Revisor revisor, int nota) {

	}

	public boolean verificarAceitacao() {
		return false;
	}

	public void addRevisor(Revisor revisor) {

	}

	public double getMedia() {
		return 0;
	}

}
