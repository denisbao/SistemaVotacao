package csi.model;

import java.util.Calendar;

import sun.util.calendar.BaseCalendar.Date;

public class Aluno {
	
	private int id;
	private String nome;
	private String matricula;
	private Calendar data;
	
	public Aluno(String nome, String matricula, Calendar data) {
		this.nome = nome;
		this.matricula = matricula;
		this.data = data;
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
	
	
	
	
}
