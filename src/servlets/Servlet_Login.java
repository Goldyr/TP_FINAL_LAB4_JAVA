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
		//Redireccion del menuAdmin para poder pasarle datos al inicio
		if(request.getParameter("Param")!=null)
		{
			int numerito;
			numerito = Integer.parseInt(request.getParameter("Param"));
			switch(numerito)
			{
				case 1:{
					RequestDispatcher rd = request.getRequestDispatcher("AdminAltaAlumno.jsp");
					rd.forward(request, response);
				}
				case 2:{
					RequestDispatcher rd = request.getRequestDispatcher("AdminAlumnos.jsp");
					rd.forward(request, response);
				}
				case 3:{
					RequestDispatcher rd = request.getRequestDispatcher("AdminAltaProfesor.jsp");
					rd.forward(request, response);
				}
				case 4:{
					RequestDispatcher rd = request.getRequestDispatcher("AdminProfesores.jsp");
					rd.forward(request, response);
				}
				case 5:{
				
					MateriaNeg negMateria = new MateriaNeg();
					ArrayList<Materia> listamaterias = new ArrayList<Materia>();
					
					listamaterias = negMateria.MateriasDisponibles();
					request.setAttribute("listamaterias", listamaterias );
					
					RequestDispatcher rd = request.getRequestDispatcher("AdminAltaCurso.jsp");
					rd.forward(request, response);
				}
				case 6:{
					RequestDispatcher rd = request.getRequestDispatcher("AdminAltaCurso.jsp");
					rd.forward(request, response);
				}
			
			}
		
		}
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
						//ACA MANDARLE SETEAR EL LISTADO PARA EL DDL DE INICIOPROFESOR
						MateriaNeg negMateria = new MateriaNeg();
						ArrayList<Materia> listamaterias = new ArrayList<Materia>();
						//Busco materias por el legajo y las cargo en la listamaterias
						listamaterias = negMateria.TraerListadoMateria(user.getLegajo_Usuario());

						//Seteo el atributo para preguntar cuando llegue a InicioProfe si no tiene no se hacer
						//request.getSession().setAttribute("seslistamaterias" , listamaterias);
						request.setAttribute("listamaterias", listamaterias );
						//
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

