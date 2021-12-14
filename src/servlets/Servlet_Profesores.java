package servlets;

import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import entidades.Profesor;
import negocio.CursoNeg;
import negocio.ProfesorNeg;

/**
 * Servlet implementation class Servlet_Profesores
 */
@WebServlet("/Servlet_Profesores")
public class Servlet_Profesores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_Profesores() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProfesorNeg profNeg = new ProfesorNeg();
		CursoNeg CursNeg = new CursoNeg();
		
		if(request.getParameter("btnMostrarProfesores")!=null || request.getParameter("btnVolver")!= null) 
		{ // Manda para mostrar la lista de los profesores
			request.setAttribute("ListaP",profNeg.obtenerListaProfesores());
			
			RequestDispatcher rd = request.getRequestDispatcher("AdminProfesores.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("btnEditar")!=null)
		{
			//Activa la edicion del profesor

			Profesor profesor = null;
			profesor = profNeg.obtenerProfesor(request.getParameter("legajoUsuario"));
			
			if(profesor != null) {
				request.setAttribute("ProfesorEditable", profesor);
				
				RequestDispatcher rd = request.getRequestDispatcher("AdminProfesores.jsp");
				rd.forward(request, response);
			}
		}
		
		if(request.getParameter("btnGuardarEdicion")!=null)
		{//modifica al profesor
			profNeg.guardarEdicionProfesor(request.getParameter("legajoUsuario"), request.getParameter("dniUsuario"), request.getParameter("nombreUsuario"), request.getParameter("apellidoUsuario"), request.getParameter("fechaNacUsuario"), request.getParameter("direccionUsuario"), request.getParameter("localidadUsuario"), request.getParameter("nacionalidadUsuario"), request.getParameter("emailUsuario"), request.getParameter("contraseñaUsuario"), request.getParameter("telefonoUsuario"));
			
			request.setAttribute("ListaP",profNeg.obtenerListaProfesores());
			
			RequestDispatcher rd = request.getRequestDispatcher("AdminProfesores.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("btnEliminar")!= null) {

			String mensajeResultado = null;

			if(profNeg.eliminarProfesor(request.getParameter("legajoUsuario")))
			{
				mensajeResultado = "El profesor se dió de baja correctamente.";
			}
			else {
				mensajeResultado = "Error al dar de baja al profesor.";
			}

			request.setAttribute("ListaP", profNeg.obtenerListaProfesores());
			request.setAttribute("MensajeResultado", mensajeResultado);

			RequestDispatcher rd = request.getRequestDispatcher("AdminProfesores.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("btnCursos")!= null) {

			request.setAttribute("LegajoProf", request.getParameter("legajoUsuario"));
			
			RequestDispatcher rd = request.getRequestDispatcher("AdminProfesorxCurso.jsp");
			rd.forward(request, response);
		}
	}
	

	

	
	

}
