package csi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import csi.model.Aluno;
import csi.model.Avaliacao;
import csi.util.ConcectaPostGres;

public class AvaliacaoDAO {
	
	public boolean fezAvaliacao(Aluno avaliador, Avaliacao av){
		System.out.println("vai inserir em FezAvalicao");
		
		String sql = "insert into fezAvaliacao (idAlunoAvaliado, idAlunoAvaliador) values (?,?);";
		try{
			PreparedStatement pre = ConcectaPostGres.conexao().prepareStatement(sql);
			pre.setInt(1, avaliador.getId());
			pre.setInt(2, av.getAlunoAvaliado().getId());					
			pre.execute();

			inserir(av);
			return true;
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}							
	}
	
	private boolean inserir(Avaliacao av){
		String sql = "insert into avaliacao (idAlunoAvaliado, comentario, nota) values (?,?,?);";
		//insert into avaliacao (idAlunoAvaliado, comentario, nota) 
		//values (1,'mas q lindeza',30.5);
		
		try{
		
			PreparedStatement pre = ConcectaPostGres.conexao().prepareStatement(sql);
			pre.setInt(1, av.getAlunoAvaliado().getId());
			pre.setString(2, av.getComentario());					
			pre.setFloat(3, av.getNota());
			pre.execute();					
			return true;		
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}	
	}
	
public float media(int id){
		
		float media = 0;
		Connection c = ConcectaPostGres.conexao();
		String sql = "SELECT AVG(nota) FROM avaliacao where idalunoavaliado = ?";
		
		try {			
			PreparedStatement preStmt = c.prepareStatement(sql);		
			preStmt.setInt(1, id);
			ResultSet rs =	preStmt.executeQuery();
			
			while(rs.next()){
				media = rs.getFloat(1);
				return media;
			}						
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return media;		
	}
}
