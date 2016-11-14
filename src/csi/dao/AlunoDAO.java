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
	public boolean inserir(Aluno aluno){
		
		try{
			Connection con = ConcectaPostGres.conexao();
			String sql = "insert into aluno (nome, matricula, data) VALUES (?,?,?)";
			PreparedStatement preStmt = con.prepareStatement(sql);
			preStmt.setString(1, aluno.getNome());
			preStmt.setString(2, aluno.getMatricula());
			preStmt.setDate(3, new Date(aluno.getData().getTimeInMillis()));
			//executa sql 
			preStmt.execute();
			
			System.out.println("SQL: " + sql); //só para teste do query
		
		}catch (SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
	//read
	public Aluno getAluno(int id) throws Exception{
		Connection con = ConcectaPostGres.conexao();
		String sql = "select * from aluno where id=?";
		PreparedStatement prt = con.prepareStatement(sql);
		prt.setInt(1, id);
		
		ResultSet rs = prt.executeQuery();	
		
		while(rs.next()){
			Aluno a = new Aluno();
			a.setId(id);
			
			String nome = rs.getString("nome");
			a.setNome(nome);
			
			String matricula = rs.getString("matricula");
			a.setMatricula(matricula);
			
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("data"));
			a.setData(data);
			
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
			ResultSet rs = preStmt.executeQuery();	
			while(rs.next()){
				//montar um objeto aluno com as infos que vem do banco
				Aluno a = new Aluno();
				a.setId(rs.getInt("id"));
				a.setNome(rs.getString("nome"));
				a.setMatricula(rs.getString("matricula"));
				//charopeira pra conseguir pegar a data:
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("data"));
				a.setData(data);
				//depois de setar tudo, jogar o aluno criado no arraylist, pra continuarmos tendo acesso
				listaAlunos.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaAlunos;
	}
	
	//update
	public boolean atualizar(Aluno aluno) throws Exception{
		Connection con = ConcectaPostGres.conexao();
		String sql = "UPDATE aluno SET nome=?, matricula=?, data=? WHERE id = ?";
		
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setString(1, aluno.getNome());
		pre.setString(2, aluno.getMatricula());
		pre.setDate(3, new Date(aluno.getData().getTimeInMillis()));
		pre.setInt(4, aluno.getId());
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
