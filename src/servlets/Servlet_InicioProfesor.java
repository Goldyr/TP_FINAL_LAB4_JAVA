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
import entidades.Curso;
import entidades.Materia;
import entidades.Notas;
import entidades.Usuario;
import negocio.CursoNeg;
import negocio.MateriaNeg;
import negocio.NotasNeg;

/**
 * Servlet implementation class Servlet_InicioProfesor
 */
@WebServlet("/Servlet_InicioProfesor")
public class Servlet_InicioProfesor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String selectedRadio;
	
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

		if(request.getParameter("btnBuscarAlumnos") != null) {
			buscarAlumnosxMateria(request, response);
			
		}

		if(request.getParameter("btnEditar") != null) {
			iniciarEdicionNotas(request, response);
		}
		
		if(request.getParameter("btnGuardar") != null) {
			guardarEdicionNotas(request, response);
		}
		
		if(request.getParameter("btnCargarNota") != null) {
			cargarNotasMasivas(request, response);
		}
	}

	public void buscarAlumnosxMateria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NotasNeg notasNeg = new NotasNeg();
		CursoNeg negCurso = new CursoNeg();
		
		selectedRadio = request.getParameter("radios");
		
		if(request.getParameter("radios").equals("Ambos")) {
		
		// Lista de las notas
		request.setAttribute("ListaNotas", notasNeg.obtenerNotasxCursoAlumnos(request.getParameter("legajoProfesor"),
				request.getParameter("materia_a_administrar")));
		}else {
			request.setAttribute("ListaNotas", notasNeg.obtenerNotasFiltrado(request.getParameter("legajoProfesor"),
					request.getParameter("materia_a_administrar"),
					request.getParameter("radios")));          
			request.getParameter("materia_a_administrar");
		}
		
		// Lista de cursos
		
		request.setAttribute("ListaCursos", negCurso.obtenerCursosDeMateriaxProfesor(request.getParameter("legajoProfesor"),
				request.getParameter("materia_a_administrar")));
		
		//Setea el de materias listado nuevamente
		
		MateriaNeg negMateria = new MateriaNeg();
		ArrayList<Materia> listamaterias = new ArrayList<Materia>();
		listamaterias = negMateria.TraerListadoMateria(request.getParameter("legajoProfesor"));
		request.setAttribute("listamaterias", listamaterias );

		RequestDispatcher rd = request.getRequestDispatcher("InicioProfesor.jsp");
		rd.forward(request, response);
	}
	
	public void iniciarEdicionNotas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		NotasNeg notasNeg = new NotasNeg();
		
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
	
	public void guardarEdicionNotas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mensajeResultado = null;
		Boolean resultado;
		
		NotasNeg notasNeg = new NotasNeg();

		resultado = notasNeg.guardarEdicionNotas(request.getParameter("CodNotaAlumno"), Float.parseFloat(request.getParameter("notaParcial1")), 
				Float.parseFloat(request.getParameter("notaParcial2")), Float.parseFloat(request.getParameter("notaRec1")), 
				Float.parseFloat(request.getParameter("notaRec2")));

		request.setAttribute("ListaNotas", notasNeg.obtenerNotasxCursoAlumnos(request.getParameter("legajoProfesor"), request.getParameter("materia_a_administrar")));
		
		if(resultado) mensajeResultado = "La nota del alumno de modificó correctamente.";
		else mensajeResultado = "Error al modificar la nota del alumno.";
		request.setAttribute("MensajeResultado", mensajeResultado);
		
		//Setea el listado nuevamente
		MateriaNeg negMateria = new MateriaNeg();
		ArrayList<Materia> listamaterias = new ArrayList<Materia>();
		listamaterias = negMateria.TraerListadoMateria(request.getParameter("legajoProfesor"));
		request.setAttribute("listamaterias", listamaterias );
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("InicioProfesor.jsp");
		rd.forward(request, response);
	}
	
	public void cargarNotasMasivas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mensajeResultado = null;
		Boolean resultado;
		
		NotasNeg notasNeg = new NotasNeg();
		float notaRec1 = 0, notaRec2 = 0;
		
		System.out.println(selectedRadio);
		
		if(!request.getParameter("txtRecuperatorio1").isEmpty())
		{
			notaRec1 = Float.parseFloat(request.getParameter("txtRecuperatorio1"));
		}
		
		if(!request.getParameter("txtRecuperatorio2").isEmpty())
		{
			notaRec2 = Float.parseFloat(request.getParameter("txtRecuperatorio2"));
		}
		
		
		resultado = notasNeg.modificarNotasMasivamente(request.getParameterValues("alumnosNotasMasiva"), request.getParameter("codCursoAlumno"),
				Float.parseFloat(request.getParameter("txtParcial1")), 
				Float.parseFloat(request.getParameter("txtParcial2")), notaRec1, notaRec2);  

		if(resultado) mensajeResultado = "Las notas de los alumnos se modificaron correctamente.";
		else mensajeResultado = "Error al modificar las notas de los alumnos.";
		
		request.setAttribute("MensajeResultado2", mensajeResultado);
		
		RequestDispatcher rd = request.getRequestDispatcher("InicioProfesor.jsp");
		
		rd.forward(request, response);

	}
	
	public static ArrayList<Materia> obtenerddlmateria(String legajo){
        MateriaNeg negMateria = new MateriaNeg();
        ArrayList<Materia> listamaterias = new ArrayList<Materia>();

        listamaterias = negMateria.TraerListadoMateria(legajo);

        return listamaterias;
    }
	
	public static ArrayList<Curso> obtenerCurso(String legajoProfesor, String codMateria)
	{
	       CursoNeg negCurso = new CursoNeg();
	        ArrayList<Curso> listamaterias;

	        listamaterias = negCurso.obtenerCursosDeMateriaxProfesor(legajoProfesor, codMateria);

	        return listamaterias;
	}
	
	public static ArrayList<Notas> obtenernotasalum(String legajo, String codMateria){
        NotasNeg notasNeg = new NotasNeg();
        return notasNeg.obtenerNotasxCursoAlumnos(legajo, codMateria);
    }

}