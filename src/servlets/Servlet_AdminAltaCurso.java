package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.CursoDaoImpl;
import entidades.Curso;

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
		if(request.getParameter("btnAgregarCurso")!=null) {
			Curso curs= new Curso();
			CursoDaoImpl cursDao= new CursoDaoImpl();
			
			curs.setCodMateria(request.getParameter("txtMateria"));
			curs.setSemestre_Curso(request.getParameter("txtSemestre"));
			curs.setAnio_Curso(request.getParameter("txtAnio"));
			
			
			System.out.println(curs.toString());
			request.setAttribute("CursoAlta", cursDao.AltaCurso(curs));
			
			RequestDispatcher rd = request.getRequestDispatcher("AdminAltaCurso.jsp");
			rd.forward(request, response);
		}
	}

}
