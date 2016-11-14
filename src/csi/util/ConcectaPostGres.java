package csi.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConcectaPostGres {

		public static Connection conexao(){
			Connection c = null;
			
			try{
				Class.forName("org.postgresql.Driver");
				String url = "jdbc:postgresql://localhost:5432/VotacaoBD";
				String user = "postgres";
				String senha = "1234";
				c = DriverManager.getConnection(url, user, senha);
			}catch (ClassNotFoundException e){
				e.printStackTrace();
			}catch (SQLException e){
				e.printStackTrace();
			}
			
			System.out.println("... coexao realizada ...");
			return c;
		}
}
