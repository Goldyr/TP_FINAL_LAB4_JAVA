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
		if(request.getParameter("btnMostrarProfesores")!=null || request.getParameter("btnVolver")!= null) 
		{ // Manda para mostrar la lista de los profesores
			request.setAttribute("ListaP",profNeg.obtenerListaProfesores());
			
			RequestDispatcher rd = request.getRequestDispatcher("AdminProfesores.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("btnEditar")!=null)
		{//Activa la edicion del profesor
			
			String legajo = request.getParameter("legajoUsuario");
			Profesor profesor = new Profesor();
			
			profesor = profNeg.obtenerProfesor(legajo);
			
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
		
	}
	

	

	
	

}
