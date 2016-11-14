package csi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import csi.model.Usuario;
import csi.util.ConcectaPostGres;

public class UsuarioDAO {

	public static void main (String args[]){
		ConcectaPostGres.conexao();
	}
	
	public boolean autenticado(Usuario user){
		
		try{
			//pega a conexao ============================================================
			
			Connection con = ConcectaPostGres.conexao();
			
			//cria declaracao ===========================================================
				/*
				jeito errado de montar a querry: (deixa passar SQL injector: 'or'1'='1);
				{
					//Statement stmt = con.createStatement();
					//String sql = "select * from usuario where nome ='" + user.getUser() + "' and senha ='" + user.getSenha() + "'";
				{
				*/
			
			String sql = "select * from usuario where nome =? and senha =?";
			PreparedStatement preStmt = con.prepareStatement(sql);
			preStmt.setString(1, user.getUser());
			preStmt.setString(2, user.getSenha());
			
			System.out.println("SQL: " + sql); //só para teste do query
			
			//executa sql 
			ResultSet rs = preStmt.executeQuery();
			
			while(rs.next()){
				System.out.println("ID: " +  rs.getInt("id"));
				System.out.println("NOME: " +  rs.getString("nome"));
				System.out.println("SENHA: " +  rs.getString("senha"));
				return true;
			}
			
			
			//manipula resultado
			
			
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		return false;
	}

}
