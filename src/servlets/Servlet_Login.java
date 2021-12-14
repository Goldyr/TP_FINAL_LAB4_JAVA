package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import negocio.MateriaNeg;
import negocio.UsuarioNeg;
import daoImpl.UsuarioDaoImpl;
import entidades.Usuario;
import daoImpl.MateriaDaoImpl;
import entidades.Materia;

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


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Si apreto el boton
		UsuarioNeg usuNeg = new UsuarioNeg();
		if(request.getParameter("btnIniciarSesion")!=null) 
		{

			Usuario user = new Usuario();
			user = usuNeg.ExisteUsuario(request.getParameter("txtMail").toString(),request.getParameter("txtPass").toString());
			//Si encontro un usuario
			if(user.getLegajo_Usuario() != null) 
			{
				
					//Atributo global del usuario en la sesion
					request.getSession().setAttribute("Usuario" , user);
					
					//Dependiendo el tipo de usuario 
					if(user.isAdmin_Usuario())
					{
						RequestDispatcher rd = request.getRequestDispatcher("InicioAdmin.jsp");
						rd.forward(request, response);
					}
					else
					{

                        RequestDispatcher rd = request.getRequestDispatcher("InicioProfesor.jsp");
                        rd.forward(request, response);
					}
			}
			else//No existe lo devuelvo al login 
			{
			request.setAttribute("error", "No existe");
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
			}

	
		}
			

	
		//Si toco el boton para cerrar sesion 
		if(request.getParameter("btnCerrarSesion")!=null) 
		{
			request.getSession().setAttribute("Usuario", null);
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}
		
			
	}

}

