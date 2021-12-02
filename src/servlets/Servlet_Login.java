package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.AlumnoDaoImpl;
import daoImpl.UsuarioDaoImpl;
import entidades.Usuario;

/**
 * Servlet implementation class Servlet_Login
 */
@WebServlet("/Servlet_Login")
public class Servlet_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_Login() {
        super();
        // TODO Auto-generated constructor stub
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
		
		if(request.getParameter("btnIniciarSesion")!=null) {
			

			UsuarioDaoImpl Udao = new UsuarioDaoImpl();
			Usuario user = new Usuario();
			user = Udao.ExisteUsuario(request.getParameter("txtMail").toString(),request.getParameter("txtPass").toString());
			
			if(user.getLegajo_Usuario() != null) {
			request.setAttribute("usuarioA", user);
			}
			else {
			request.setAttribute("error", "No existe");
			}
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		
			
			
			
		}
			
			
	}

}
