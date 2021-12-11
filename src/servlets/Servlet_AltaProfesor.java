package servlets;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import negocio.ProfesorNeg;

/**
 * Servlet implementation class Servlet_AltaProfesor
 */
@WebServlet("/Servlet_AltaProfesor")
public class Servlet_AltaProfesor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_AltaProfesor() {
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
		ProfesorNeg profNeg = new ProfesorNeg();
		
		if(request.getParameter("btnAltaProfesor")!=null) {
			String Mensaje;
			Boolean flag;
			flag = profNeg.AltaProfesor(request.getParameter("txtDNI"), request.getParameter("txtNombre"), request.getParameter("txtApellido"), request.getParameter("txtFechaNacimiento"), request.getParameter("txtDireccion"), request.getParameter("txtLocalidad"), request.getParameter("txtNacionalidad"), request.getParameter("txtEmail"), request.getParameter("txtContraseña"), request.getParameter("txtRepContraseña"), request.getParameter("txtTelefono"));

			if(flag) {
				request.setAttribute("AltaProfesor", flag);
				Mensaje = "El profesor se agrego correctamente";
			}else {
				
				Mensaje = "El profesor no se agrego correctamente.Revise los campos";
			}
			
			request.setAttribute("MensajeError", Mensaje);

				
			RequestDispatcher rd = request.getRequestDispatcher("AdminAltaProfesor.jsp");
			rd.forward(request, response);
			
	  }
	}
	

}
