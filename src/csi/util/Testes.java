package csi.util;

import java.util.ArrayList;
import csi.model.Aluno;
import csi.dao.AlunoDAO;

public class Testes {

	public static void main(String[] args) {
		
		//testar se a lista de alunos está vindo do banco
		ArrayList<Aluno> lista = new AlunoDAO().getAlunos();
		for (Aluno a: lista){
			System.out.println("ID: "+ a.getId() + " Nome: " + a.getNome());
		}
	}
}
