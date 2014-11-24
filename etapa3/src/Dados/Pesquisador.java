import java.util.ArrayList;

public class Pesquisador {

	protected int id;

	protected String nome;

	protected AfiliacaoTeste afiliacao;

	protected ArrayList<TopicoDePesquisa> topicospesquisa;

	private TopicoDePesquisa topicoDePesquisa;

	private AfiliacaoTeste afiliacao;

	public void Pesquisador(int id, String nome, AfiliacaoTeste afiliacao) {

	}

	public void addTopicoPesquisa(TopicoDePesquisa topicopesquisa) {

	}

	public boolean possuiTopicoPesquisa(TopicoDePesquisa topicopesquisa) {
		return false;
	}

	public int getId() {
		return 0;
	}

	public String getNome() {
		return null;
	}

	public AfiliacaoTeste getAfiliacao() {
		return null;
	}

	public boolean isEqual(Pesquisador pesquisador) {
		return false;
	}

	public boolean pertenceAfiliacao(AfiliacaoTeste afiliacao) {
		return false;
	}

}
