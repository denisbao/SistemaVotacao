package csi.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import csi.model.Aluno;
import csi.model.Usuario;
import csi.util.ConcectaPostGres;

public class AlunoDAO {

	
	//create
	public boolean inserir(Aluno a){
		
		try{
			Connection con = ConcectaPostGres.conexao();
			String sql = "insert into aluno (nome, matricula, data, usuario, senha) VALUES (?,?,?,?,?)";
			PreparedStatement preStmt = con.prepareStatement(sql);
			preStmt.setString(1, a.getNome());
			preStmt.setString(2, a.getMatricula());
			preStmt.setDate(3, new Date(a.getData().getTimeInMillis()));
			preStmt.setString(4, a.getUsuario().getUser());
			preStmt.setString(5, a.getUsuario().getSenha());
			preStmt.execute();
			
			return true;
		
		}catch (SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
	public Aluno getAluno(int id) throws Exception{
		Connection con = ConcectaPostGres.conexao();
		String sql = "select * from aluno where id=?";
		PreparedStatement prt = con.prepareStatement(sql);
		prt.setInt(1, id);
		
		ResultSet rs = prt.executeQuery();	
		
		while(rs.next()){
			
			String nome = rs.getString("nome");							
			String matricula = rs.getString("matricula");								
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("data"));								
			String usuario = rs.getString("usuario");
			String senha = rs.getString("senha");
			float media = new AvaliacaoDAO().media(id);
			
			//montar obj aluno
			Aluno a = new Aluno(nome, matricula, data, usuario, senha, media);
			a.setId(id);
			
			return a;
		}
		return null;
	}
	
	//read
		public Aluno getAluno(String nome)throws Exception{
			return null;
		}
	
	//read all
	public ArrayList<Aluno> getAlunos(){
		//esse array server pra guardar cada aluno que for consultado no banco
		ArrayList<Aluno> listaAlunos = new ArrayList<Aluno>();
		Connection con = ConcectaPostGres.conexao();
		String sql = "select * from aluno";
		try {
			PreparedStatement preStmt = con.prepareStatement(sql);			
			ResultSet rs =	preStmt.executeQuery();
			
			while(rs.next()){
				int id = rs.getInt("id");						
				String nome = rs.getString("nome");							
				String matricula = rs.getString("matricula");								
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("data"));								
				String usuario = rs.getString("usuario");
				String senha = rs.getString("senha");
				float media = new AvaliacaoDAO().media(id);
				 
				//montar obj aluno
				Aluno a = new Aluno(nome, matricula, data, usuario, senha, media);
				a.setId(id);
				listaAlunos.add(a);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaAlunos;
	}
	
	//update
	public boolean atualizar(Aluno a) throws Exception{
		Connection con = ConcectaPostGres.conexao();
		String sql = "UPDATE aluno SET nome=?, matricula=?, data=?, usuario=?, senha=? WHERE id = ?";
		
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setString(1, a.getNome());
		pre.setString(2, a.getMatricula());
		pre.setDate(3, new Date(a.getData().getTimeInMillis()));
		pre.setString(4, a.getUsuario().getUser());
		pre.setString(5, a.getUsuario().getSenha());
		pre.setInt(6, a.getId());
		pre.execute();

		return true;
	}
	
	//delete
	public boolean deletar(Aluno aluno) throws Exception{
		
		Connection con = ConcectaPostGres.conexao();
		String sql = "delete from aluno where id= ?";
		PreparedStatement preStmt = con.prepareStatement(sql);
		preStmt.setInt(1, aluno.getId());
		preStmt.execute();
		return true;
	}
}
