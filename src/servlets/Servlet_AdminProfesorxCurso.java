package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Curso;
import entidades.Materia;
import negocio.CursoNeg;
import negocio.MateriaNeg;
import negocio.ProfesorNeg;
import negocio.ProfesorxCursoNeg;

/**
 * Servlet implementation class Servlet_AdminProfesorxCurso
 */
@WebServlet("/Servlet_AdminProfesorxCurso")
public class Servlet_AdminProfesorxCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_AdminProfesorxCurso() {
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
	
		ProfesorxCursoNeg profxCursNeg = new ProfesorxCursoNeg();
		
		if(request.getParameter("btnagregar_Alcurso")!=null) {
			String Mensaje;
			Boolean flag;
			flag = profxCursNeg.AltaProfesorxCurso((String)request.getSession().getAttribute("LegajoProfxCurs"), request.getParameter("CodCurso"));
			if(flag) {
				request.setAttribute("AltaProfesorxcurs", flag);
				Mensaje = "El profesor se agrego al curso correctamente";
			}else {
				
				Mensaje = "El profesor no se agrego al curso correctamente.";
			}
			
			request.setAttribute("MensajeError", Mensaje);
				
			RequestDispatcher rd = request.getRequestDispatcher("AdminProfesorxCurso.jsp");
			rd.forward(request, response);
			
	  }
	}

	public static ArrayList<Curso> Cursos(String legajo){
        CursoNeg negCurso = new CursoNeg();
        ArrayList<Curso> listacurso = new ArrayList<Curso>();
        
        listacurso = negCurso.CursosObtener(legajo);
        
        return listacurso;
    }
	
	public static ArrayList<Curso> Cursos_noProfesor(String legajo){
        CursoNeg negCurso = new CursoNeg();
        ArrayList<Curso> listacurso = new ArrayList<Curso>();
        
        listacurso = negCurso.obtenerCursos_noProfesor(legajo);
        
        return listacurso;
    }
	
	
	
	
}
