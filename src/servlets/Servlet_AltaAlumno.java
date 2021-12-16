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
			String Mensaje;
			if(alumNeg.existeAlumno(request.getParameter("txtDNI"), request.getParameter("txtEmail"))== false) {
				flag = alumNeg.AltaAlumno(request.getParameter("txtNombre"), request.getParameter("txtApellido"), request.getParameter("txtDNI"), request.getParameter("txtFechaNacimiento"), request.getParameter("txtDireccion"), request.getParameter("txtNacionalidad"), request.getParameter("txtProvincia"), request.getParameter("txtEmail"), request.getParameter("txtTelefono"));
				if(flag) {
					request.setAttribute("AlumnoAlta", flag);
					Mensaje = "El Alumno se agrego correctamente";
				}else {
					
					Mensaje = "El Alumno no se agrego correctamente. Revise los campos";
				}
				
			}else {Mensaje = "El Alumno ya existe";}
			
			request.setAttribute("MensajeError", Mensaje);
			
			RequestDispatcher rd = request.getRequestDispatcher("AdminAltaAlumno.jsp");
			rd.forward(request, response);
		}

	}

}