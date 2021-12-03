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

import daoImpl.ProfesorDaoImpl;
import entidades.Profesor;

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
		if(request.getParameter("btnMostrarProfesores")!=null) {
			ProfesorDaoImpl ProfDao = new ProfesorDaoImpl();
			ArrayList<Profesor> lista = ProfDao.ListarProfesor();
			request.setAttribute("ListaP",lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("AdminProfesores.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("btnEditar")!=null)
		{
			editarProfesor(request, response);
		}
		
		if(request.getParameter("btnGuardarEdicion")!=null)
		{
		
			guardarEdicionProfesor(request, response);
	
		}
		
	}
	
	private void editarProfesor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String legajo = request.getParameter("legajoUsuario");
			
			ProfesorDaoImpl udao = new ProfesorDaoImpl();
			Profesor profesor = new Profesor();
		
			profesor = udao.ObtenerProfesor(legajo);
			
			if(profesor != null) {
				request.setAttribute("ProfesorEditable", profesor);
				
				RequestDispatcher rd = request.getRequestDispatcher("AdminProfesores.jsp");
				rd.forward(request, response);
			}
	}
	
	private void guardarEdicionProfesor(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
	{
		String legajo = request.getParameter("legajoUsuario");
		
		ProfesorDaoImpl udao = new ProfesorDaoImpl();
		Profesor profesor = new Profesor();
	
		profesor = udao.ObtenerProfesor(legajo);
		
		if(profesor != null) {
			
			profesor.setDNI_(request.getParameter("dniUsuario"));
			profesor.setNombre_Usuario(request.getParameter("nombreUsuario"));
			profesor.setApellido_Usuario(request.getParameter("apellidoUsuario"));
			profesor.setDNI_(request.getParameter("dniUsuario"));
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			Date date;
			try {
				date = formatter.parse(request.getParameter("fechaNacUsuario"));
				profesor.setFechaNac_Profesor(date);
			} catch (ParseException e) {
	
			}
			
			profesor.setDireccion_Profesor(request.getParameter("direccionUsuario"));
			profesor.setLocalidad_Profesor(request.getParameter("localidadUsuario"));
			profesor.setNacionalidad_Profesor(request.getParameter("nacionalidadUsuario"));
			profesor.setEmail_Usuario(request.getParameter("emailUsuario"));
			profesor.setContraseña_Usuario(request.getParameter("contraseñaUsuario"));
			profesor.setTelefono_Usuario(request.getParameter("telefonoUsuario"));
			
			// ------------
			
			if(udao.ModificarProfesor(profesor)) {
				ProfesorDaoImpl ProfDao = new ProfesorDaoImpl();
				ArrayList<Profesor> lista = ProfDao.ListarProfesor();
				request.setAttribute("ListaP",lista);
				
				System.out.println("Modificado correctamente");
				
				RequestDispatcher rd = request.getRequestDispatcher("AdminProfesores.jsp");
				rd.forward(request, response);
			}

		}
	}

}
