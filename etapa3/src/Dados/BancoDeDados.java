package Dados;

import java.util.ArrayList;
import Dados.Afiliacao;
import Dados.Artigo;
import Dados.Conferencia;
import Dados.Pesquisador;


public class BancoDeDados {
	
	private ArrayList<Pesquisador> pesquisadores;

	private ArrayList<Conferencia> conferencias;

	private ArrayList<Artigo> artigos;

	private ArrayList<Afiliacao> afiliacoes;

	private ArrayList<Revisao> revisoes;

	private ArrayList<TopicoDePesquisa> topicospesquisa;

	public BancoDeDados() {
		this.pesquisadores = new ArrayList<>();
		this.conferencias = new ArrayList<>();
		this.artigos = new ArrayList<>();
		this.afiliacoes = new ArrayList<>();
		this.revisoes = new ArrayList<>();
		this.topicospesquisa = new ArrayList<>();
		initData();
				
	}
	
	public ArrayList<Pesquisador> getPesquisadores() {
		return this.pesquisadores;
	}
	
	public ArrayList<Conferencia> getConferencias() {
		return this.conferencias;
	}
	
	public ArrayList<Artigo> getArtigos() {
		return this.artigos;
	}
	
	public ArrayList<Afiliacao> getAfiliacoes() {
		return this.afiliacoes;
	}
	
	public ArrayList<Revisao> getRevisoes() {
		return this.revisoes;
	}
	
	public ArrayList<TopicoDePesquisa> getTopicoDePesquisa() {
		return this.topicospesquisa;
	}
	
	private void storeTopico(TopicoDePesquisa topico) {
		this.topicospesquisa.add(topico);
	}
	
	private void storeAfiliacao(Afiliacao afil) {
		this.afiliacoes.add(afil);
	}
	
	private void storeArtigo(Artigo art) {
		this.artigos.add(art);
	}
	
	private void storePesquisador(Pesquisador pesq) {
		this.pesquisadores.add(pesq);
	}
	
	private void storeConferencia(Conferencia conf) {
		this.conferencias.add(conf);
	}
	
	public Artigo getArtigo(int id) {
		
		for (Artigo artigo : this.artigos) {
			if (artigo.getId() == id) {
				return artigo;
			}
		}
		
		return null;
		
	}
	
	public Conferencia getConferencia(String sigla) {
		for (Conferencia conferencia : this.conferencias) {
			if(conferencia.getSigla().equalsIgnoreCase(sigla)) {
				return conferencia;
			}
		}
		
		return null;
	}
	
	private void initData() {
		try {
			
			
			Afiliacao af1 =	new Afiliacao("UFRGS");
			storeAfiliacao(af1);
			Afiliacao af2 =	new Afiliacao("USP");
			storeAfiliacao(af2);
			Afiliacao af3 =	new Afiliacao("UFRJ");
			storeAfiliacao(af3);
			
			TopicoDePesquisa topic0 = new TopicoDePesquisa("Software Product Lines");
			storeTopico(topic0);
			TopicoDePesquisa topic1 = new TopicoDePesquisa("Software Reuse");
			storeTopico(topic1);
			TopicoDePesquisa topic2 = new TopicoDePesquisa("Modularity");
			storeTopico(topic2);
			TopicoDePesquisa topic3 = new TopicoDePesquisa("Software Testing");
			storeTopico(topic3);
			TopicoDePesquisa topic4 = new TopicoDePesquisa("Software Architecture");
			storeTopico(topic4);
			TopicoDePesquisa topic5 = new TopicoDePesquisa("Aspect-oriented Programming");
			storeTopico(topic5);
			TopicoDePesquisa topic6 = new TopicoDePesquisa("Software Quality");
			storeTopico(topic6);

			int pesqId = 0;
            Pesquisador p1 = new Pesquisador(++pesqId, "João", this.afiliacoes.get(0));
            p1.addTopicoPesquisa(this.topicospesquisa.get(0));
            p1.addTopicoPesquisa(this.topicospesquisa.get(1));
            p1.addTopicoPesquisa(this.topicospesquisa.get(2));
            storePesquisador(p1);
            Pesquisador p2 = new Pesquisador(++pesqId, "Ana", this.afiliacoes.get(1));
            p2.addTopicoPesquisa(this.topicospesquisa.get(1));
            p2.addTopicoPesquisa(this.topicospesquisa.get(2));
            p2.addTopicoPesquisa(this.topicospesquisa.get(4));
            storePesquisador(p2);
            Pesquisador p3 = new Pesquisador(++pesqId, "Manoel", this.afiliacoes.get(0));
            p3.addTopicoPesquisa(this.topicospesquisa.get(0));
            p3.addTopicoPesquisa(this.topicospesquisa.get(3));
            storePesquisador(p3);
            Pesquisador p4 = new Pesquisador(++pesqId, "Joana", this.afiliacoes.get(2));
            p4.addTopicoPesquisa(this.topicospesquisa.get(0));
            p4.addTopicoPesquisa(this.topicospesquisa.get(1));
            p4.addTopicoPesquisa(this.topicospesquisa.get(4));
            p4.addTopicoPesquisa(this.topicospesquisa.get(5));
            storePesquisador(p4);
            Pesquisador p5 = new Pesquisador(++pesqId, "Miguel", this.afiliacoes.get(0));
            p5.addTopicoPesquisa(this.topicospesquisa.get(1));
            p5.addTopicoPesquisa(this.topicospesquisa.get(2));
            p5.addTopicoPesquisa(this.topicospesquisa.get(4));
            storePesquisador(p5);
            Pesquisador p6 = new Pesquisador(++pesqId, "Beatriz", this.afiliacoes.get(2));
            p6.addTopicoPesquisa(this.topicospesquisa.get(2));
            p6.addTopicoPesquisa(this.topicospesquisa.get(3));
            p6.addTopicoPesquisa(this.topicospesquisa.get(4));
            storePesquisador(p6);
            Pesquisador p7 = new Pesquisador(++pesqId, "Suzana", this.afiliacoes.get(0));
            p7.addTopicoPesquisa(this.topicospesquisa.get(1));
            p7.addTopicoPesquisa(this.topicospesquisa.get(2));
            p7.addTopicoPesquisa(this.topicospesquisa.get(5));
            storePesquisador(p7);
            Pesquisador p8 = new Pesquisador(++pesqId, "Natasha", this.afiliacoes.get(2));
            p8.addTopicoPesquisa(this.topicospesquisa.get(0));
            p8.addTopicoPesquisa(this.topicospesquisa.get(1));
            p8.addTopicoPesquisa(this.topicospesquisa.get(2));
            p8.addTopicoPesquisa(this.topicospesquisa.get(6));
            storePesquisador(p8);
            Pesquisador p9 = new Pesquisador(++pesqId, "Pedro", this.afiliacoes.get(1));
            p9.addTopicoPesquisa(this.topicospesquisa.get(4));
            p9.addTopicoPesquisa(this.topicospesquisa.get(5));
            storePesquisador(p9);
            Pesquisador p10 = new Pesquisador(++pesqId, "Carlos", this.afiliacoes.get(1));
            p10.addTopicoPesquisa(this.topicospesquisa.get(1));
            p10.addTopicoPesquisa(this.topicospesquisa.get(2));
            p10.addTopicoPesquisa(this.topicospesquisa.get(3));
            storePesquisador(p10);
			
            Conferencia icse = new Conferencia("ICSE");
			for (int i = 1; i < 8; i++) {
				Pesquisador pesq = this.pesquisadores.get(i - 1);
				icse.addMembroComite(new MembroDeComite(pesq));
			}
			storeConferencia(icse);
			Conferencia fse = new Conferencia("FSE");
			for (int i = 1; i < 8; i++) {
				Pesquisador pesq = this.pesquisadores.get(i - 1);
				icse.addMembroComite(new MembroDeComite(pesq));
			}
			storeConferencia(fse);
			Conferencia sbes = new Conferencia("SBES");
			for (int i = 4; i < 11; i++) {
				Pesquisador pesq = this.pesquisadores.get(i - 1);
				sbes.addMembroComite(new MembroDeComite(pesq));
			}
			
			int artId = 0;
			Artigo art1 = new Artigo(++artId, "Coupling and Cohesion", this.pesquisadores.get(1), "SBES", this.topicospesquisa.get(2));
			art1.addRevisor(new Revisor(new MembroDeComite(this.pesquisadores.get(7))));
			art1.addRevisor(new Revisor(new MembroDeComite(this.pesquisadores.get(9))));
			art1.addRevisao(8, 2);
			storeArtigo(art1);
			
			Artigo art2 = new Artigo(++artId, "Design Patterns", this.pesquisadores.get(5), "FSE", this.topicospesquisa.get(1));
			art2.addRevisor(new Revisor(new MembroDeComite(this.pesquisadores.get(6))));
			art2.addRevisor(new Revisor(new MembroDeComite(this.pesquisadores.get(1))));
			art2.addRevisao(7, 2);
			art2.addRevisao(2, 3);
			storeArtigo(art2);
			
			Artigo art3 = new Artigo(++artId, "AspectJ", this.pesquisadores.get(6), "FSE", this.topicospesquisa.get(5));
			art3.addRevisor(new Revisor(new MembroDeComite(this.pesquisadores.get(3))));
			art3.addRevisor(new Revisor(new MembroDeComite(this.pesquisadores.get(5))));
			art3.addRevisao(4, -1);
			art3.addRevisao(6, 1);
			storeArtigo(art3);
			
			Artigo art4 = new Artigo(++artId, "Feature Model", this.pesquisadores.get(7), "FSE", this.topicospesquisa.get(0));
			art4.addRevisor(new Revisor(new MembroDeComite(this.pesquisadores.get(0))));
			art4.addRevisor(new Revisor(new MembroDeComite(this.pesquisadores.get(2))));
			art4.addRevisao(1, 1);
			art4.addRevisao(3, 0);
			storeArtigo(art4);
			
			Artigo art5 = new Artigo(++artId, "Architecture Recovery", this.pesquisadores.get(8), "FSE", this.topicospesquisa.get(4));
			art5.addRevisor(new Revisor(new MembroDeComite(this.pesquisadores.get(3))));
			art5.addRevisor(new Revisor(new MembroDeComite(this.pesquisadores.get(4))));
			art5.addRevisao(4,  -3);
			art5.addRevisao(5, -3);
			storeArtigo(art5);
			
			Artigo art6 = new Artigo(++artId, "Functional Testing", this.pesquisadores.get(9), "FSE", this.topicospesquisa.get(3));
			art6.addRevisor(new Revisor(new MembroDeComite(this.pesquisadores.get(2))));
			art6.addRevisor(new Revisor(new MembroDeComite(this.pesquisadores.get(5))));
			art6.addRevisao(3,  -1);
			art6.addRevisao(6, 0);
			storeArtigo(art6);
			
			Artigo art7 = new Artigo(++artId, "COTs", this.pesquisadores.get(5), "ICSE", this.topicospesquisa.get(1));
			storeArtigo(art7);
			Artigo art8 = new Artigo(++artId, "Pointcut", this.pesquisadores.get(6), "ICSE", this.topicospesquisa.get(5));
			storeArtigo(art8);
			Artigo art9 = new Artigo(++artId, "Product Derivation", this.pesquisadores.get(7), "ICSE", this.topicospesquisa.get(0));
			storeArtigo(art9);
			Artigo art10 = new Artigo(++artId, "Architecture Comformance", this.pesquisadores.get(8), "ICSE", this.topicospesquisa.get(4));
			storeArtigo(art10);
			Artigo art11 = new Artigo(++artId, "Structural Testing", this.pesquisadores.get(9), "ICSE", this.topicospesquisa.get(3));
			storeArtigo(art11);
					

		} catch (Exception e) {
			System.err.println("Base de dados não pode ser inicializada.\n");
            //error(e);                                                       
            //e.printStackTrace();                                                
        }     
	} 
}
