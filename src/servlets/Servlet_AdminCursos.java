package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.AlumnoDaoImpl;
import daoImpl.CursoDaoImpl;
import entidades.Alumno;
import entidades.Curso;

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
		if(request.getParameter("btnMostrarCursos")!=null) {
			CursoDaoImpl CursoDao = new CursoDaoImpl();
			ArrayList<Curso> lista = CursoDao.ListarCursos();
			
			 request.setAttribute("ListaC", lista);
					 
					 RequestDispatcher rd = request.getRequestDispatcher("AdminCursos.jsp");
					 rd.forward(request, response);

		}
	}

}
