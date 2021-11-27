package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.AlumnoDaoImpl;
import entidades.Alumno;

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
			if(request.getParameter("btnMostrarAlumnos")!=null) {
				AlumnoDaoImpl alumDao = new AlumnoDaoImpl();
				ArrayList<Alumno> lista = alumDao.ListarAlumnos();
				 
				 request.setAttribute("ListaA", lista);
				 
				 RequestDispatcher rd = request.getRequestDispatcher("AdminAlumnos.jsp");
				 rd.forward(request, response);
			}
	}

}
