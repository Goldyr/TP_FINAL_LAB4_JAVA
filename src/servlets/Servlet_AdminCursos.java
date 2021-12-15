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
import negocio.CursoNeg;

/**
 * Servlet implementation class Servlet_AdminCursos
 */
@WebServlet("/Servlet_AdminCursos")
public class Servlet_AdminCursos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_AdminCursos() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CursoNeg curNeg = new CursoNeg();
		if(request.getParameter("btnMostrarCursos")!=null) {
			
			
			 request.setAttribute("ListaC", curNeg.obtenerCurso());
					 
					 RequestDispatcher rd = request.getRequestDispatcher("AdminCursos.jsp");
					 rd.forward(request, response);

		}
	}
	
	public static ArrayList<Curso> listarcursos() {
		CursoNeg curNeg = new CursoNeg();
		ArrayList<Curso> listaCurso = new ArrayList<Curso>();
		listaCurso = curNeg.obtenerCurso();
		return listaCurso;
		
	}

}
