package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.ProfesorDaoImpl;
import entidades.Profesor;

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
		Profesor prof = new Profesor();
		
		if(request.getParameter("btnAltaProfesor")!=null) {
			String Contraseña = request.getParameter("txtContraseña").toString();
			String RepContraseña =request.getParameter("txtRepContraseña").toString();
			
			if(RepContraseña.trim()!=Contraseña.trim()){  ///NO ENTIENDE CUANDO SON DISTINTAS
				String Mensaje = "El profesor no se agrego correctamente.Las contraseñas deben ser iguales";
				
				System.out.println(Contraseña);
				System.out.println(RepContraseña);
				
				request.setAttribute("MensajeError", Mensaje);
			
				RequestDispatcher rd = request.getRequestDispatcher("AdminAltaProfesor.jsp");
				rd.forward(request, response);		
			}
			else{			
			String Mensaje = "El profesor se agrego correctamente";
			System.out.println(Contraseña);
			System.out.println(RepContraseña);
			
			prof.setDNI_Usuario(request.getParameter("txtDNI"));
			prof.setNombre_Usuario(request.getParameter("txtNombre"));
			prof.setApellido_Usuario(request.getParameter("txtApellido"));
			prof.setContraseña_Usuario(request.getParameter("txtRepContraseña"));
			
			/*
			prof.setFechaNac_Profesor(request.getParameter("txtFechaNac"));
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String stringFechaNacimiento = request.getParameter("txtFechaNacimiento");
			Date date;
			
			try {	
				date = formatter.parse(stringFechaNacimiento);
				//formatter.format(date);
				prof.setFechaNac_Profesor(date);
				
			} catch (ParseException e) {
				e.printStackTrace();
			}*/
			
			prof.setDireccion_Profesor(request.getParameter("txtDireccion"));
			prof.setNacionalidad_Profesor(request.getParameter("txtNacionalidad"));
			prof.setLocalidad_Profesor(request.getParameter("txtLocalidad"));
			prof.setEmail_Usuario(request.getParameter("txtEmail"));
			prof.setTelefono_Usuario(request.getParameter("txtTelefono"));
			
			ProfesorDaoImpl profDaoimpl = new ProfesorDaoImpl();

			request.setAttribute("AltaProfesor", profDaoimpl.AltaProfesor(prof));
			request.setAttribute("MensajeError", Mensaje);

				
			RequestDispatcher rd = request.getRequestDispatcher("AdminAltaProfesor.jsp");
			rd.forward(request, response);
		}	
	  }
	}
	

}
