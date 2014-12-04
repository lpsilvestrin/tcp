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
	
	private void storeTopico(int id, TopicoDePesquisa topico) {
		this.topicospesquisa.add(id, topico);
	}
	
	private void storeAfiliacao(int id, Afiliacao afil) {
		this.afiliacoes.add(id, afil);
	}
	
	private void storeArtigo(int id, Artigo art) {
		this.artigos.add(id, art);
	}
	
	private void storePesquisador(int id, Pesquisador pesq) {
		this.pesquisadores.add(id, pesq);
	}
	
	private void storeConferencia(int id, Conferencia conf) {
		this.conferencias.add(id, conf);
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
			int afilId = 0;
			
			Afiliacao af1 =	new Afiliacao("UFRGS");
			storeAfiliacao(++afilId, af1);
			Afiliacao af2 =	new Afiliacao("USP");
			storeAfiliacao(++afilId, af2);
			Afiliacao af3 =	new Afiliacao("UFRJ");
			storeAfiliacao(++afilId, af3);
			
			TopicoDePesquisa topic0 = new TopicoDePesquisa("Software Product Lines");
			storeTopico(0, topic0);
			TopicoDePesquisa topic1 = new TopicoDePesquisa("Software Reuse");
			storeTopico(1, topic1);
			TopicoDePesquisa topic2 = new TopicoDePesquisa("Modularity");
			storeTopico(2, topic2);
			TopicoDePesquisa topic3 = new TopicoDePesquisa("Software Testing");
			storeTopico(3, topic3);
			TopicoDePesquisa topic4 = new TopicoDePesquisa("Software Architecture");
			storeTopico(4, topic4);
			TopicoDePesquisa topic5 = new TopicoDePesquisa("Aspect-oriented Programming");
			storeTopico(5, topic5);
			TopicoDePesquisa topic6 = new TopicoDePesquisa("Software Quality");
			storeTopico(6, topic6);

			int pesqId = 0;
            Pesquisador p1 = new Pesquisador(++pesqId, "João", this.afiliacoes.get(0));
            p1.addTopicoPesquisa(this.topicospesquisa.get(0));
            p1.addTopicoPesquisa(this.topicospesquisa.get(1));
            p1.addTopicoPesquisa(this.topicospesquisa.get(2));
            storePesquisador(pesqId, p1);
            Pesquisador p2 = new Pesquisador(++pesqId, "Ana", this.afiliacoes.get(1));
            p2.addTopicoPesquisa(this.topicospesquisa.get(1));
            p2.addTopicoPesquisa(this.topicospesquisa.get(2));
            p2.addTopicoPesquisa(this.topicospesquisa.get(4));
            storePesquisador(pesqId, p2);
            Pesquisador p3 = new Pesquisador(++pesqId, "Manoel", this.afiliacoes.get(0));
            p3.addTopicoPesquisa(this.topicospesquisa.get(0));
            p3.addTopicoPesquisa(this.topicospesquisa.get(3));
            storePesquisador(pesqId, p3);
            Pesquisador p4 = new Pesquisador(++pesqId, "Joana", this.afiliacoes.get(2));
            p4.addTopicoPesquisa(this.topicospesquisa.get(0));
            p4.addTopicoPesquisa(this.topicospesquisa.get(1));
            p4.addTopicoPesquisa(this.topicospesquisa.get(4));
            p4.addTopicoPesquisa(this.topicospesquisa.get(5));
            storePesquisador(pesqId, p4);
            Pesquisador p5 = new Pesquisador(++pesqId, "Miguel", this.afiliacoes.get(0));
            p5.addTopicoPesquisa(this.topicospesquisa.get(1));
            p5.addTopicoPesquisa(this.topicospesquisa.get(2));
            p5.addTopicoPesquisa(this.topicospesquisa.get(4));
            storePesquisador(pesqId, p5);
            Pesquisador p6 = new Pesquisador(++pesqId, "Beatriz", this.afiliacoes.get(2));
            p6.addTopicoPesquisa(this.topicospesquisa.get(2));
            p6.addTopicoPesquisa(this.topicospesquisa.get(3));
            p6.addTopicoPesquisa(this.topicospesquisa.get(4));
            storePesquisador(pesqId, p6);
            Pesquisador p7 = new Pesquisador(++pesqId, "Suzana", this.afiliacoes.get(0));
            p7.addTopicoPesquisa(this.topicospesquisa.get(1));
            p7.addTopicoPesquisa(this.topicospesquisa.get(2));
            p7.addTopicoPesquisa(this.topicospesquisa.get(5));
            storePesquisador(pesqId, p7);
            Pesquisador p8 = new Pesquisador(++pesqId, "Natasha", this.afiliacoes.get(2));
            p8.addTopicoPesquisa(this.topicospesquisa.get(0));
            p8.addTopicoPesquisa(this.topicospesquisa.get(1));
            p8.addTopicoPesquisa(this.topicospesquisa.get(2));
            p8.addTopicoPesquisa(this.topicospesquisa.get(6));
            storePesquisador(pesqId, p8);
            Pesquisador p9 = new Pesquisador(++pesqId, "Pedro", this.afiliacoes.get(1));
            p9.addTopicoPesquisa(this.topicospesquisa.get(4));
            p9.addTopicoPesquisa(this.topicospesquisa.get(5));
            storePesquisador(pesqId, p9);
            Pesquisador p10 = new Pesquisador(++pesqId, "Carlos", this.afiliacoes.get(1));
            p10.addTopicoPesquisa(this.topicospesquisa.get(1));
            p10.addTopicoPesquisa(this.topicospesquisa.get(2));
            p10.addTopicoPesquisa(this.topicospesquisa.get(3));
            storePesquisador(pesqId, p10);
			
            int confId = 0;
            Conferencia icse = new Conferencia("ICSE");
			for (int i = 1; i < 8; i++) {
				Pesquisador pesq = this.pesquisadores.get(i);
				icse.addMembroComite(new MembroDeComite(pesq));
			}
			storeConferencia(confId++, icse);
			Conferencia fse = new Conferencia("FSE");
			for (int i = 1; i < 8; i++) {
				Pesquisador pesq = this.pesquisadores.get(i);
				icse.addMembroComite(new MembroDeComite(pesq));
			}
			storeConferencia(confId++, fse);
			Conferencia sbes = new Conferencia("SBES");
			for (int i = 4; i < 11; i++) {
				Pesquisador pesq = this.pesquisadores.get(i);
				sbes.addMembroComite(new MembroDeComite(pesq));
			}
			
			int artId = 0;
			Artigo art1 = new Artigo(++artId, "Coupling and Cohesion", this.pesquisadores.get(1), "SBES", this.topicospesquisa.get(2));
			art1.addRevisor(new Revisor(new MembroDeComite(this.pesquisadores.get(8))));
			art1.addRevisor(new Revisor(new MembroDeComite(this.pesquisadores.get(10))));
			art1.addRevisao(8, 2);	
			storeArtigo(artId, art1);
			
			Artigo art2 = new Artigo(++artId, "Design Patterns", this.pesquisadores.get(6), "FSE", this.topicospesquisa.get(1));
			art2.addRevisor(new Revisor(new MembroDeComite(this.pesquisadores.get(7))));
			art2.addRevisor(new Revisor(new MembroDeComite(this.pesquisadores.get(2))));
			art2.addRevisao(7, 2);
			art2.addRevisao(2, 3);
			storeArtigo(artId, art2);
			
			Artigo art3 = new Artigo(++artId, "AspectJ", this.pesquisadores.get(7), "FSE", this.topicospesquisa.get(5));
			art3.addRevisor(new Revisor(new MembroDeComite(this.pesquisadores.get(4))));
			art3.addRevisor(new Revisor(new MembroDeComite(this.pesquisadores.get(6))));
			art3.addRevisao(4, -1);
			art3.addRevisao(6, 1);
			storeArtigo(artId, art3);
			
			Artigo art4 = new Artigo(++artId, "Feature Model", this.pesquisadores.get(8), "FSE", this.topicospesquisa.get(0));
			art4.addRevisor(new Revisor(new MembroDeComite(this.pesquisadores.get(1))));
			art4.addRevisor(new Revisor(new MembroDeComite(this.pesquisadores.get(3))));
			art4.addRevisao(1, 1);
			art4.addRevisao(3, 0);
			storeArtigo(artId, art4);
			
			Artigo art5 = new Artigo(++artId, "Architecture Recovery", this.pesquisadores.get(9), "FSE", this.topicospesquisa.get(4));
			art5.addRevisor(new Revisor(new MembroDeComite(this.pesquisadores.get(4))));
			art5.addRevisor(new Revisor(new MembroDeComite(this.pesquisadores.get(5))));
			art5.addRevisao(4,  -3);
			art5.addRevisao(5, -3);
			storeArtigo(artId, art5);
			
			Artigo art6 = new Artigo(++artId, "Functional Testing", this.pesquisadores.get(10), "FSE", this.topicospesquisa.get(3));
			art6.addRevisor(new Revisor(new MembroDeComite(this.pesquisadores.get(3))));
			art6.addRevisor(new Revisor(new MembroDeComite(this.pesquisadores.get(6))));
			art6.addRevisao(3,  -1);
			art6.addRevisao(6, 0);
			storeArtigo(artId, art6);
			
			Artigo art7 = new Artigo(++artId, "COTs", this.pesquisadores.get(6), "ICSE", this.topicospesquisa.get(1));
			storeArtigo(artId, art7);
			Artigo art8 = new Artigo(++artId, "Pointcut", this.pesquisadores.get(7), "ICSE", this.topicospesquisa.get(5));
			storeArtigo(artId, art8);
			Artigo art9 = new Artigo(++artId, "Product Derivation", this.pesquisadores.get(8), "ICSE", this.topicospesquisa.get(0));
			storeArtigo(artId, art9);
			Artigo art10 = new Artigo(++artId, "Architecture Comformance", this.pesquisadores.get(9), "ICSE", this.topicospesquisa.get(4));
			storeArtigo(artId, art10);
			Artigo art11 = new Artigo(++artId, "Structural Testing", this.pesquisadores.get(10), "ICSE", this.topicospesquisa.get(3));
			storeArtigo(artId, art11);
					

		}  catch (Exception e) {                                                 
            //error(e);                                                       
            //e.printStackTrace();                                                
        }     
	}
}
