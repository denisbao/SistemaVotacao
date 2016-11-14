package csi.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import csi.dao.AlunoDAO;


/**
 * Servlet implementation class principalServlet
 */
@WebServlet("/principalServlet")
public class principalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public principalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String opcao = request.getParameter("opcao");
		RequestDispatcher despachante;
		String pagina = "";
		
		
		if(opcao.equals("aluno")){
			pagina = "/WEB-INF/jsp/aluno.jsp";
			AlunoDAO dao = new AlunoDAO();
			request.setAttribute("alunos", dao.getAlunos()); //carrega a lista de alunos junto com a página
		}
		else if (opcao.equals("avaliacao")){
			pagina = "/WEB-INF/jsp/avaliacao.jsp";
			AlunoDAO dao = new AlunoDAO();			
			request.setAttribute("alunos", dao.getAlunos());
		}

		despachante = request.getServletContext().getRequestDispatcher(pagina);
		despachante.forward(request, response);

	}
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
