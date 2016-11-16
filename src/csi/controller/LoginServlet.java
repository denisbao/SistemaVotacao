package csi.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import csi.dao.UsuarioDAO;
import csi.model.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		
		Usuario user = new Usuario(usuario, senha);
		
		boolean logado = new UsuarioDAO().autenticado(user);
		
//		if(usuario.equals("denis") && senha.equals("1234")){
//			logado = true;
//		}
		
		RequestDispatcher despat;
		if(logado){
			String pagina = "/WEB-INF/jsp/principal.jsp";
			despat = request.getServletContext().getRequestDispatcher(pagina);
			despat.forward(request, response);
		}
		else{
			String msg = "Usuário ou senha incorretos";
			String pagina = "/index.jsp";
			request.setAttribute("msgDoServidor", msg);
			despat = request.getServletContext().getRequestDispatcher(pagina);
			despat.forward(request, response);
		}
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
