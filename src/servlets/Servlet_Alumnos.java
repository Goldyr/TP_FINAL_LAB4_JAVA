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
import negocio.AlumnoNeg;

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
			AlumnoNeg alneg = new AlumnoNeg();
			
			if(request.getParameter("btnInscribir") != null) {
                //activa la edicion del alumno
                request.getSession().setAttribute("LegajoAlumnoxCurso", request.getParameter("legajoAlumno"));

                RequestDispatcher rd = request.getRequestDispatcher("AdminAltaAlumnoxCurso.jsp");
                rd.forward(request, response);
            }
			
			if(request.getParameter("btnMostrarAlumnos")!=null || request.getParameter("btnVolver")!=null) {
				//lista los alumnos
				 request.setAttribute("ListaA", alneg.obtenerListaAlumnos());
				 
				 RequestDispatcher rd = request.getRequestDispatcher("AdminAlumnos.jsp");
				 rd.forward(request, response);
			}
			
			if(request.getParameter("btnEditar") != null) {
				//activa la edicion del alumno
				String legajo = request.getParameter("legajoAlumno");
				
				Alumno alumno = new Alumno();
				alumno = alneg.obtenerAlumno(legajo);
				
				if(alumno != null) {
					request.setAttribute("AlumnoEditable", alumno);
					
					RequestDispatcher rd = request.getRequestDispatcher("AdminAlumnos.jsp");
					rd.forward(request, response);
				}else {RequestDispatcher rd = request.getRequestDispatcher("AdminAlumnos.jsp");
				rd.forward(request, response);
				}
				
			}
			
			if(request.getParameter("btnGuardarEdicion") != null) {
				//guarda la modificacion
				alneg.guardarEdicionAlumno(request.getParameter("legajoAlumno"), request.getParameter("dniAlumno"), 
						request.getParameter("nombreAlumno"), request.getParameter("apellidoAlumno"), request.getParameter("fechaNacAlumno"), 
						request.getParameter("direccionAlumno"), request.getParameter("nacionalidadAlumno"),  request.getParameter("provinciaAlumno"), request.getParameter("emailAlumno"), 
						request.getParameter("telefonoAlumno"));
				
				request.setAttribute("ListaA", alneg.obtenerListaAlumnos());
				
				RequestDispatcher rd = request.getRequestDispatcher("AdminAlumnos.jsp");
				rd.forward(request, response);
			}
			
			if(request.getParameter("btnEliminar") != null) {

				String mensajeResultado = null;

				if(alneg.eliminarAlumno(request.getParameter("legajoAlumno")))
				{
					mensajeResultado = "El alumno se dió de baja correctamente.";
				}
				else
				{
					mensajeResultado = "Error al dar de baja al alumno.";
				}

				request.setAttribute("ListaA", alneg.obtenerListaAlumnos());
				request.setAttribute("MensajeResultado", mensajeResultado);

				RequestDispatcher rd = request.getRequestDispatcher("AdminAlumnos.jsp");
				rd.forward(request, response);
			}
	
	
		}
	
	public static ArrayList<Alumno> listarAlumnos() {
		AlumnoNeg alneg = new AlumnoNeg();
		ArrayList<Alumno> listarAlumnos = new ArrayList<Alumno>();
		listarAlumnos = alneg.obtenerListaAlumnos();
		return listarAlumnos;
	}

	
}
