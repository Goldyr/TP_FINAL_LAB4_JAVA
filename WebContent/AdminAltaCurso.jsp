<%@page import="entidades.Usuario" %>
<%@page import="entidades.Materia" %>
<%@page import="servlets.Servlet_AdminAltaCurso" %>
<%@page import= "java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

<title>Alta Curso</title>
</head>
<body>

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

	<header>
	<div class="container-fluid my-2">
	<div class="row">
		<div class="col">
 			<h3>Bienvenido/a a la administración - Alta de Cursos</h3>
		</div>
		<div class="col text-right d-flex justify-content-end">
			<form method="post" action="Servlet_Login">
				<p style="display:inline-block; margin:0; padding:0.375rem 0.75rem;">Administrador: <%= user.getNombre_Usuario() %> </p>
				<input type="submit" value="Cerrar Sesión" class="btn btn-outline-primary" name="btnCerrarSesion">
			</form>
		</div>
	</div>
	</div>
</header>

	<ul>
	<li>
		<a href="InicioAdmin.jsp">Inicio</a>
	</li>
	<li>
	<a href="Servlet_InicioAdmin?Param=6">Listado de Cursos</a>
	</li>
	</ul>
	
	<section>
	<div class="container-fluid">
	<form action="Servlet_AdminAltaCurso" method="post">
		<h4>Alta Curso</h4>
		<b>Seleccionar Materia: </b>
		
		<select name="materia_curso">

				<%
				//se llamaba txtMateria este cosito
				ArrayList<Materia> listamaterias = new ArrayList<Materia>();
				listamaterias = Servlet_AdminAltaCurso.obtenerddlmateria();

					for(Materia mat : listamaterias)
					{
				%>
					<option value="<%=mat.getCodigoMateria()%>"> <%=mat.getNombreMateria()%> </option>
	
				<%
					}
				
				%>
			</select>
<!-- <p>Semestre 			<input type="text"  placeholder="Ingrese el semestre" name="txtSemestre" required> 	</p>  -->
		<p>Semestre
			<select name="txtSemestre" required> 
				<option value="Primer Semestre">Primer Semestre</option>
				<option value="Segundo Semestre">Segundo Semestre</option>
			</select>
		</p>
		<p>Año 				<input type="text"  placeholder="Ingrese el Año" pattern="[0-9]{4}" title="Debe ingresar 4 digitos" name="txtAnio" required> </p>
	
		
		<input type="submit" name="btnAgregarCurso" value="Agregar Curso">
		
		<%
		if(request.getAttribute("CursoAlta")!=null){
			if((boolean)request.getAttribute("CursoAlta")){
				%>
				Se dio de alta correctamente	
				<%	
			}else{
				%>
				Error: No pudo darse de alta correctamente	
				<%
			}
		}
		%>
	</form>
	</div>
</section>
</body>
</html>