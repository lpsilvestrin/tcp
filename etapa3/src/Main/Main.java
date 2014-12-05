package Main;

import Dados.BancoDeDados;
import Interface.InterfacePrincipal;
import Operacoes.Operacoes;

public class Main {
	
	public static void main(String [] args) {
		Operacoes operacoes = new Operacoes();
		InterfacePrincipal iu = new InterfacePrincipal(operacoes);
		
		iu.iniciaInterface();
	}
	
}
