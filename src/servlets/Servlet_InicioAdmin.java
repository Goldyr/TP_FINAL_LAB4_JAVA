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
import negocio.MateriaNeg;

/**
 * Servlet implementation class Servlet_InicioAdmin
 */
@WebServlet("/Servlet_InicioAdmin")
public class Servlet_InicioAdmin extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_InicioAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Redireccion del menuAdmin para poder pasarle datos al inicio
                if(request.getParameter("Param")!=null)
                {
                    int numerito;
                    numerito = Integer.parseInt(request.getParameter("Param"));
                    
                    if(numerito == 1)
                    {
                        RequestDispatcher rd = request.getRequestDispatcher("/AdminAltaAlumno.jsp");
                        rd.forward(request, response);
                    }
                    else if(numerito == 2) 
                    {
                        RequestDispatcher rd = request.getRequestDispatcher("/AdminAlumnos.jsp");
                        rd.forward(request, response);
                    }
                    else if(numerito == 3) 
                    {
                        RequestDispatcher rd = request.getRequestDispatcher("/AdminAltaProfesor.jsp");
                        rd.forward(request, response);
                    }
                    else if(numerito == 4) 
                    {
                        RequestDispatcher rd = request.getRequestDispatcher("/AdminProfesores.jsp");
                        rd.forward(request, response);
                    }
                    else if(numerito == 5) {


                    
                    RequestDispatcher rd = request.getRequestDispatcher("/AdminAltaCurso.jsp");
                    rd.forward(request, response);
                    }
                    else if(numerito == 6) 
                    {
                        RequestDispatcher rd = request.getRequestDispatcher("/AdminCursos.jsp");
                        rd.forward(request, response);
                    }
                    
                
    
                
                }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }
    


}
