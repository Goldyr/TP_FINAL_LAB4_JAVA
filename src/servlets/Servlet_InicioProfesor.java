package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.NotasDaoImpl;
import entidades.Materia;
import entidades.Notas;
import negocio.MateriaNeg;
import negocio.NotasNeg;

/**
 * Servlet implementation class Servlet_InicioProfesor
 */
@WebServlet("/Servlet_InicioProfesor")
public class Servlet_InicioProfesor extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_InicioProfesor() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		NotasNeg notasNeg = new NotasNeg();

		if(request.getParameter("btnBuscarAlumnos") != null) {

			request.setAttribute("ListaNotas", notasNeg.obtenerNotasxCursoAlumnos(request.getParameter("legajoProfesor"),
					request.getParameter("materia_a_administrar")));
			
			
			//Setea el listado nuevamente
			MateriaNeg negMateria = new MateriaNeg();
			ArrayList<Materia> listamaterias = new ArrayList<Materia>();
			listamaterias = negMateria.TraerListadoMateria(request.getParameter("legajoProfesor"));
			request.setAttribute("listamaterias", listamaterias );

			RequestDispatcher rd = request.getRequestDispatcher("InicioProfesor.jsp");
			rd.forward(request, response);
		}

		if(request.getParameter("btnEditar") != null) {

			Notas notas = null;
			notas = notasNeg.obtenerNotas(request.getParameter("CodNotaAlumno"));

			if(notas != null) {
				//Setea el listado nuevamente
				MateriaNeg negMateria = new MateriaNeg();
				ArrayList<Materia> listamaterias = new ArrayList<Materia>();
				listamaterias = negMateria.TraerListadoMateria(request.getParameter("legajoProfesor"));
				request.setAttribute("listamaterias", listamaterias );
				
				request.setAttribute("NotaEditable", notas);
				RequestDispatcher rd = request.getRequestDispatcher("InicioProfesor.jsp");
				rd.forward(request, response);
			}
		}
		if(request.getParameter("btnGuardar") != null) {

			notasNeg.guardarEdicionNotas(request.getParameter("CodNotaAlumno"), Float.parseFloat(request.getParameter("notaParcial1")), 
					Float.parseFloat(request.getParameter("notaParcial2")), Float.parseFloat(request.getParameter("notaRec1")), 
					Float.parseFloat(request.getParameter("notaRec2")));

			request.setAttribute("ListaNotas", notasNeg.obtenerNotasxCursoAlumnos(request.getParameter("legajoProfesor"), request.getParameter("materia_a_administrar")));
			
			//Setea el listado nuevamente
			MateriaNeg negMateria = new MateriaNeg();
			ArrayList<Materia> listamaterias = new ArrayList<Materia>();
			listamaterias = negMateria.TraerListadoMateria(request.getParameter("legajoProfesor"));
			request.setAttribute("listamaterias", listamaterias );
			
			RequestDispatcher rd = request.getRequestDispatcher("InicioProfesor.jsp");
			rd.forward(request, response);

		}

	}

}