package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.AlumnoDaoImpl;
import daoImpl.ProfesorDaoImpl;
import entidades.Alumno;
import entidades.Profesor;

/**
 * Servlet implementation class Servlet_Alumnos
 */
@WebServlet("/Servlet_Alumnos")
public class Servlet_Alumnos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_Alumnos() {
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
			if(request.getParameter("btnMostrarAlumnos")!=null || request.getParameter("btnVolver")!=null) {
				obtenerListaAlumnos(request, response);
			}
			
			if(request.getParameter("btnEditar") != null) {
				editarAlumno(request, response);
			}
			
			if(request.getParameter("btnGuardarEdicion") != null) {
				guardarEdicionAlumno(request, response);
			}
	}
	
	private void obtenerListaAlumnos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		AlumnoDaoImpl alumDao = new AlumnoDaoImpl();
		ArrayList<Alumno> lista = alumDao.ListarAlumnos();
		 
		 request.setAttribute("ListaA", lista);
		 
		 RequestDispatcher rd = request.getRequestDispatcher("AdminAlumnos.jsp");
		 rd.forward(request, response);
	}
	
	private void editarAlumno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String legajo = request.getParameter("legajoAlumno");
		
		AlumnoDaoImpl adao = new AlumnoDaoImpl();
		Alumno alumno = new Alumno();
	
		alumno = adao.obtenerAlumno(legajo);
		
		if(alumno != null) {
			request.setAttribute("AlumnoEditable", alumno);
			
			RequestDispatcher rd = request.getRequestDispatcher("AdminAlumnos.jsp");
			rd.forward(request, response);
		}
	}

	
	private void guardarEdicionAlumno(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
	{
		String legajo = request.getParameter("legajoUsuario");
		
		AlumnoDaoImpl adao = new AlumnoDaoImpl();
		Alumno alumno = new Alumno();
	
		alumno = adao.obtenerAlumno(legajo);
		
		if(alumno != null) {
			
			alumno.setDni_Alumno(request.getParameter("dniAlumno"));
			alumno.setNombre_Alumno(request.getParameter("nombreAlumno"));
			alumno.setApellido_Alumno(request.getParameter("apellidoAlumno"));
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String stringFechaNacimiento = request.getParameter("fechaNacAlumno");
			Date date;
			
			try {
				
				date = formatter.parse(stringFechaNacimiento);
				//formatter.format(date);
				alumno.setFechaNac_Alumno(date);
				
			} catch (ParseException e) {
					e.printStackTrace();
			}
			
			alumno.setDireccion_Alumno(request.getParameter("direccionAlumno"));
			alumno.setNacionalidad_Alumno(request.getParameter("nacionalidadAlumno"));
			alumno.setEmail_Alumno(request.getParameter("emailAlumno"));
			alumno.setTelefono_Alumno(request.getParameter("telefonoAlumno"));
			
			// ------------
			
			if(adao.ModificarAlumno(alumno)) {
				
				obtenerListaAlumnos(request, response);
				
				System.out.println("Modificado correctamente");
				
			}

		}
	}
	
}
