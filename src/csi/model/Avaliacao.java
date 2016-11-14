package csi.model;

public class Avaliacao {
	
	private Aluno alunoAvaliado;
	private String comentario;
	private float nota;
	
	public Avaliacao(Aluno alAvaliado, String comentario, float nota) {
		this.alunoAvaliado = alAvaliado;
		this.comentario = comentario;
		this.nota = nota;
	}
	
	public Aluno getAlunoAvaliado() {
		return alunoAvaliado;
	}
	public void setAlunoAvaliado(Aluno alAvaliado) {
		this.alunoAvaliado = alAvaliado;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public float getNota() {
		return nota;
	}
	public void setNota(float nota) {
		this.nota = nota;
	}	
}
