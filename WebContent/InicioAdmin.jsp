<%@page import="entidades.Usuario" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inicio here</title>
</head>
<body>
	<h3>Bienvenido/a</h3>
	
	<% 
	//Validacion si hay un usuario y si es admin
	Usuario user = new Usuario();
	if(session.getAttribute("Usuario")!=null){
		
		user = (Usuario)session.getAttribute("Usuario");

		if(!user.isAdmin_Usuario()){
			response.sendRedirect("InicioProfesor.jsp");
		}
	}else{response.sendRedirect("Login.jsp");}
 %>
	
	<form method="post" action="Servlet_Login" >
	<div style=text-align:right><%= user.getNombre_Usuario() %>
	<input type="submit" value="CerrarSesion" name="btnCerrarSesion">
	</div>
	</form>
	
	<ul>
	
		<li>
	<a href="AdminAltaAlumno.jsp">Alta Alumno</a>
	</li>
		<li>
	<a href="AdminAlumnos.jsp">Listado y modificacion de alumnos</a>
	</li>
		<li>
	<a href="AdminAltaProfesor.jsp">Alta Profesor </a>
	</li>
		<li>
	<a href="AdminProfesores.jsp">Listado y modificacion de profesores </a>
	</li>
		<li>
	<a href="AdminAltaCurso.jsp">Alta Curso </a>
	</li>
		<li>
	<a href="AdminCursos.jsp"> Listado de cursos </a>
	</li>

	</ul>
</body>
</html>