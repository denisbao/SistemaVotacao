package csi.model;

public class Usuario {

	private int codigo;
	private String user;
	private String senha;
	
	public Usuario(String user, String senha){
		this.user = user;
		this.senha = senha;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
