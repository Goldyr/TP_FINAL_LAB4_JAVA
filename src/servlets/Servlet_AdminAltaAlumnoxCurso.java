package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Alumno;
import entidades.Curso;
import negocio.AlumnoNeg;
import negocio.AlumnoxCursoNeg;
import negocio.CursoNeg;

/**
 * Servlet implementation class Servlet_AdminAltaAlumnoxCurso
 */
@WebServlet("/Servlet_AdminAltaAlumnoxCurso")
public class Servlet_AdminAltaAlumnoxCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_AdminAltaAlumnoxCurso() {
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
		AlumnoxCursoNeg alxcurNeg = new AlumnoxCursoNeg();

		if(request.getParameter("btnagregar_Alcurso") != null) {
			String Mensaje;
			Boolean flag;
			
			flag = alxcurNeg.AltaAlumnoxCurso(request.getParameter("LegajoAlumno"), request.getParameter("CodCurso"));
			
			if(flag) {
				request.setAttribute("AltaAlumnoxCurso", flag);
				Mensaje = "El Alumno se agrego al curso correctamente";
			}else {
				
				Mensaje = "El Alumno no se agrego al curso correctamente.Revise los campos";
			}
			
			request.setAttribute("MensajeError", Mensaje);

			
			RequestDispatcher rd = request.getRequestDispatcher("AdminAltaAlumnoxCurso.jsp");
			rd.forward(request, response);
		}
		
	}
	
	public static ArrayList<Curso> Cursos(String legajo){
		CursoNeg negCurso = new CursoNeg();
		ArrayList<Curso> listacurso = new ArrayList<Curso>();
		
		listacurso = negCurso.CursosObtener_Alumno(legajo);
		
		return listacurso;
	}
	
	public static ArrayList<Curso> Cursos_noAlumno(String legajo){
		CursoNeg negCurso = new CursoNeg();
		ArrayList<Curso> listacurso = new ArrayList<Curso>();
		
		listacurso = negCurso.obtenerCursos_noAlumno(legajo);
		
		return listacurso;
	}

}
