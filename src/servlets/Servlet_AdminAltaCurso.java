package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Materia;
import negocio.CursoNeg;
import negocio.MateriaNeg;

/**
 * Servlet implementation class Servlet_AdminAltaCurso
 */
@WebServlet("/Servlet_AdminAltaCurso")
public class Servlet_AdminAltaCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_AdminAltaCurso() {
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
		CursoNeg curNeg = new CursoNeg();
		if(request.getParameter("btnAgregarCurso")!=null) {

			request.setAttribute("CursoAlta", curNeg.Altacurso(request.getParameter("materia_curso"), request.getParameter("txtSemestre"), request.getParameter("txtAnio")));
			
			RequestDispatcher rd = request.getRequestDispatcher("AdminAltaCurso.jsp");
			rd.forward(request, response);
		}
	}
	
    public static ArrayList<Materia> obtenerddlmateria(){
        MateriaNeg negMateria = new MateriaNeg();
        ArrayList<Materia> listamaterias = new ArrayList<Materia>();
        
        listamaterias = negMateria.MateriasDisponibles();
        
        return listamaterias;
    }

}
