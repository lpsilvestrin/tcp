package Dados;

import java.util.ArrayList;
import Artigo
import Conferencia
import ListaDeMembros
import MembroDeComite
import Pesquisador
import Revisao
import Revisor

public class BancoDeDados {
	
	private ArrayList<Pesquisador> pesquisadores;

	private ArrayList<Conferencia> conferencias;

	private ArrayList<Artigo> artigos;

	private ArrayList<Afiliacao> afiliacoes;

	private ArrayList<Revisao> revisoes;

	private ArrayList<TopicoDePesquisa> topicospesquisa;

	public BancoDeDados() {
		
		
		
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
	
	private void storePesquisador(int id, Pesquisador pesq) {
		this.afiliacoes.add(id, pesq);
	}
	
	private void storeConferencia(int id, Conferencia conf) {
		this.conferencias.add(id, conf);
	}
	
	private void initData() {
		try {
			int afilId = 0; //primeiro p
			
			Afiliacao af1 =	new Afiliacao(++afilId, "UFRGS");
			storeAfiliacao(afilId, af1);
			Afiliacao af2 =	new Afiliacao(++afilId, "USP");
			storeAfiliacao(afilId, af2);
			Afiliacao af3 =	new Afiliacao(++afilId, "UFRJ");
			storeAfiliacao(afilId, af3);
			
			int topicId = 0;
			TopicoDePesquisa topic0 = new TopicoDePesquisa("Software Product Lines");
			this.topicospesquisa.add(0, topic0);
			TopicoDePesquisa topic1 = new TopicoDePesquisa("Software Reuse");
			this.topicospesquisa.add(1, topic1);
			TopicoDePesquisa topic2 = new TopicoDePesquisa("Modularity");
			this.topicospesquisa.add(2, topic2);
			TopicoDePesquisa topic3 = new TopicoDePesquisa("Software Testing");
			this.topicospesquisa.add(3, topic3);
			TopicoDePesquisa topic4 = new TopicoDePesquisa("Software Architecture");
			this.topicospesquisa.add(4, topic4);
			TopicoDePesquisa topic5 = new TopicoDePesquisa("Aspect-oriented Programming");
			this.topicospesquisa.add(5, topic5);
			TopicoDePesquisa topic6 = new TopicoDePesquisa("Software Quality");
			this.topicospesquisa.add(6, topic6);

			int	pesqId = 0;
			MembroDeComite p1 = new MembroDeComite(++pesqId, "João", this.afiliacoes.get(0));
            p1.addTopicoPesquisa(this.topicospesquisa.get(0));
            p1.addTopicoPesquisa(this.topicospesquisa.get(1));
            p1.addTopicoPesquisa(this.topicospesquisa.get(2));
            storePesquisador(pesqId, p1);
            MembroDeComite p2 = new MembroDeComite(++pesqId, "Ana", this.afiliacoes.get(1));
            p2.addTopicoPesquisa(this.topicospesquisa.get(1));
            p2.addTopicoPesquisa(this.topicospesquisa.get(2));
            p2.addTopicoPesquisa(this.topicospesquisa.get(4));
            storePesquisador(pesqId, p2);
            MembroDeComite p3 = new MembroDeComite(++pesqId, "Manoel", this.afiliacoes.get(0));
            p3.addTopicoPesquisa(this.topicospesquisa.get(0));
            p3.addTopicoPesquisa(this.topicospesquisa.get(3));
            storePesquisador(pesqId, p3);
            MembroDeComite p4 = new MembroDeComite(++pesqId, "Joana", this.afiliacoes.get(2));
            p4.addTopicoPesquisa(this.topicospesquisa.get(0));
            p4.addTopicoPesquisa(this.topicospesquisa.get(1));
            p4.addTopicoPesquisa(this.topicospesquisa.get(4));
            p4.addTopicoPesquisa(this.topicospesquisa.get(5));
            storePesquisador(pesqId, p4);
            MembroDeComite p5 = new MembroDeComite(++pesqId, "Miguel", this.afiliacoes.get(0));
            p5.addTopicoPesquisa(this.topicospesquisa.get(1));
            p5.addTopicoPesquisa(this.topicospesquisa.get(2));
            p5.addTopicoPesquisa(this.topicospesquisa.get(4));
            storePesquisador(pesqId, p5);
            MembroDeComite p6 = new MembroDeComite(++pesqId, "Beatriz", this.afiliacoes.get(2));
            p6.addTopicoPesquisa(this.topicospesquisa.get(2));
            p6.addTopicoPesquisa(this.topicospesquisa.get(3));
            p6.addTopicoPesquisa(this.topicospesquisa.get(4));
            storePesquisador(pesqId, p6);
            MembroDeComite p7 = new MembroDeComite(++pesqId, "Suzana", this.afiliacoes.get(0));
            p7.addTopicoPesquisa(this.topicospesquisa.get(1));
            p7.addTopicoPesquisa(this.topicospesquisa.get(2));
            p7.addTopicoPesquisa(this.topicospesquisa.get(5));
            storePesquisador(pesqId, p7);
            MembroDeComite p8 = new MembroDeComite(++pesqId, "Natasha", this.afiliacoes.get(2));
            p8.addTopicoPesquisa(this.topicospesquisa.get(0));
            p8.addTopicoPesquisa(this.topicospesquisa.get(1));
            p8.addTopicoPesquisa(this.topicospesquisa.get(2));
            p8.addTopicoPesquisa(this.topicospesquisa.get(6));
            storePesquisador(pesqId, p8);
            MembroDeComite p9 = new MembroDeComite(++pesqId, "Pedro", this.afiliacoes.get(1));
            p9.addTopicoPesquisa(this.topicospesquisa.get(4));
            p9.addTopicoPesquisa(this.topicospesquisa.get(5));
            storePesquisador(pesqId, p9);
            MembroDeComite p10 = new MembroDeComite(++pesqId, "Carlos", this.afiliacoes.get(1));
            p10.addTopicoPesquisa(this.topicospesquisa.get(1));
            p10.addTopicoPesquisa(this.topicospesquisa.get(2));
            p10.addTopicoPesquisa(this.topicospesquisa.get(3));
            storePesquisador(pesqId, p10);
			
			Conferencia icse = new Conferencia("ICSE");
			for (int i = 1; i < 8; i++) {
				icse.addMembroComite(this.pesquisadores.get(i));
			}
			storeConferencia(icse);
			Conferencia fse = new Conferencia("FSE");
			for (int i = 1; i < 8; i++) {
				fse.addMembroComite(this.pesquisadores.get(i));
			}
			storeConferencia(fse);
			Conferencia sbes = new Conferencia("SBES");
			for (int i = 4; i < 11; i++) {
				sbes.addMembroComite(this.pesquisadores.get(i));
			}
			
			int artId = 0;
			Artigo art1 = new Artigo(++artId, "Coupling and Cohesion", 1, "SBES", this.topicospesquisa.get(2));
			storeArtigo(artId, art1);
			Artigo art2 = new Artigo(++artId, "Design Patterns", 6, "FSE", this.topicospesquisa.get(1));
			storeArtigo(artId, art2);
			Artigo art3 = new Artigo(++artId, "AspectJ", 7, "FSE", this.topicospesquisa.get(5));
			storeArtigo(artId, art3);
			Artigo art4 = new Artigo(++artId, "Feature Model", 8, "FSE", this.topicospesquisa.get(0));
			storeArtigo(artId, art4);
			Artigo art5 = new Artigo(++artId, "Architecture Recovery", 9, "FSE", this.topicospesquisa.get(4));
			storeArtigo(artId, art5);
			Artigo art6 = new Artigo(++artId, "Functional Testing", 10, "FSE", this.topicospesquisa.get(3));
			storeArtigo(artId, art6);
			Artigo art7 = new Artigo(++artId, "COTs", 6, "ICSE", this.topicospesquisa.get(1));
			storeArtigo(artId, art7);
			Artigo art8 = new Artigo(++artId, "Pointcut", 7, "ICSE", this.topicospesquisa.get(5));
			storeArtigo(artId, art8);
			Artigo art9 = new Artigo(++artId, "Product Derivation", 8, "ICSE", this.topicospesquisa.get(0));
			storeArtigo(artId, art9);
			Artigo art10 = new Artigo(++artId, "Architecture Comformance", 9, "ICSE", this.topicospesquisa.get(4));
			storeArtigo(artId, art10);
			Artigo art11 = new Artigo(++artId, "Structural Testing", 10, "ICSE", this.topicospesquisa.get(3));
			storeArtigo(artId, art11);

		}
	}
}
