package csi.dao;

import csi.model.Aluno;
import csi.model.Avaliacao;

public class AvaliacaoDAO {
	
	public boolean fezAvaliacao(Aluno avaliador, Avaliacao av){
		//vai incerir na tabela fez_avaliaca, depois chama o método inserir
		System.out.println("vai incerir na tabela Fez_Avaliacao");
		inserir(av);
		return true;
	}
	
	private boolean inserir(Avaliacao av){ //metodo private para que só essa classe possa chamá-lo.
		System.out.println("vai incerir na tabela Avaliacao");
		return true;
	}
	
}
