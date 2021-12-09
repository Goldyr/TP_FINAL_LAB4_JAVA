package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import negocio.AlumnoNeg;

/**
 * Servlet implementation class Servlet_AltaAlumno
 */
@WebServlet("/Servlet_AltaAlumno")
public class Servlet_AltaAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_AltaAlumno() {
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
		AlumnoNeg alumNeg = new AlumnoNeg();
		
		if(request.getParameter("btnAgregarAlumno")!=null) {
			Boolean flag;
			flag = alumNeg.AltaAlumno(request.getParameter("txtNombre"), request.getParameter("txtApellido"), request.getParameter("txtDNI"), request.getParameter("txtFechaNacimiento"), request.getParameter("txtDireccion"), request.getParameter("txtNacionalidad"), request.getParameter("txtProvincia"), request.getParameter("txtEmail"), request.getParameter("txtTelefono"));

			request.setAttribute("AlumnoAlta", flag);
			
			RequestDispatcher rd = request.getRequestDispatcher("AdminAltaAlumno.jsp");
			rd.forward(request, response);
		}

	}

}