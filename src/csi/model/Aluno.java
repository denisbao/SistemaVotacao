package csi.model;

import java.util.Calendar;

public class Aluno {
	
	private int id;
	private String nome;
	private String matricula;
	private Calendar data;
	private Usuario usuario;
	private float media;
	
	public Aluno(String nome, String matricula, Calendar data) {
		this.nome = nome;
		this.matricula = matricula;
		this.data = data;
	}
	
	public Aluno(String nome, String m, Calendar d, String usuario, String senha, float media){
		this.nome = nome;
		this.matricula = m;
		this.data = d;
		this.usuario = new Usuario(usuario, senha);		
		this.media = media;
	}
	
	public Aluno(){ 
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public float getMedia() {
		return media;
	}

	public void setMedia(float media) {
		this.media = media;
	}
	
}
