package csi.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import csi.dao.AlunoDAO;
import csi.model.Aluno;


/**
 * Servlet implementation class AlunoServlet
 */
@WebServlet("/AlunoServlet")
public class AlunoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlunoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("...chamou o AlunoServlet");
		
		String opcao = request.getParameter("opcao");
		String id_p = request.getParameter("id");
		int id = 0;
		if(id_p != null){
			id = Integer.parseInt(id_p);
		}
		
		if(opcao.equals("excluir")){
			deletaAluno(request, id);
		}	
		else if(opcao.equals("alterar")){
			alterarAluno(request, id);
		}
		else if(opcao.equals("inserir")){
			insereAluno(request);
		}
		else if(opcao.equals("buscar")){
			request.setAttribute("aluno", buscarAluno(id));
		}
		
		RequestDispatcher despachante;
		String paginaAluno = "/WEB-INF/jsp/aluno.jsp";
		AlunoDAO dao = new AlunoDAO();
		request.setAttribute("alunos", dao.getAlunos()); //carrega a lista de alunos junto com a página
		despachante = request.getServletContext().getRequestDispatcher(paginaAluno);
		despachante.forward(request, response);
	}
	
	private Aluno buscarAluno(int id){
		// opcao1
		//return new AlunoDAO().getAluno(id);
		//opcao2
		AlunoDAO dao = new AlunoDAO();
		try {
			Aluno a = dao.getAluno(id);
			return a;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private void alterarAluno(HttpServletRequest request, int id){
		System.out.println("...alterando aluno");
		Aluno al = montaAluno(request);
		al.setId(id); //setando o novo aluno com o id recebido pelo método
		AlunoDAO dao = new AlunoDAO();
		try{
			dao.atualizar(al);
		}catch(Exception e){
			e.printStackTrace();
		}
		

	}
	
	private boolean deletaAluno(HttpServletRequest request, int id){
		System.out.println("Deletando aluno...");
		Aluno a = new Aluno();
		a.setId(id);
		AlunoDAO dao = new AlunoDAO();
		try {
			return dao.deletar(a);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private void insereAluno(HttpServletRequest request){
		AlunoDAO alDao = new AlunoDAO();
		alDao.inserir(montaAluno(request));
	}
	
	private Aluno montaAluno(HttpServletRequest request){
		String nome = request.getParameter("nome");
		String matricula = request.getParameter("matricula");
		String dataNascimento = request.getParameter("data");
		
		//A data de nascimento é um tipo "date" no banco. E é importada do banco como String.
		//Aluno precisa receber essa variável como tipo "Calendar"
		//É necessário converter a String para Calendar
		Calendar dataNasc = null;
		try{
			Date data = new SimpleDateFormat("dd-MM-yyyy").parse(dataNascimento);
			dataNasc = Calendar.getInstance();
			dataNasc.setTime(data);
		}catch (Exception e){
			e.printStackTrace();
		}
		return new Aluno(nome, matricula, dataNasc);
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
