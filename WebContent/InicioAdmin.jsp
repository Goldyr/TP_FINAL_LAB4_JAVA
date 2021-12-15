<%@page import="entidades.Usuario" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>


<title>Inicio here</title>
</head>
	<style>
		a{
			color: blue!important;
		}
	
		a:visited{
			color: inherit;
		}
		
	
	</style>
<body>
<header>
	<div class="container-fluid my-2">
		<div class="row">
		<div class="col">
		<h3>Bienvenido/a a la administración</h3>
		</div>
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
		<div class="col text-right d-flex justify-content-end">
			<form method="post" action="Servlet_Login" >
				<p style="display:inline-block; margin:0; padding:0.375rem 0.75rem;">Administrador: <%= user.getNombre_Usuario() %> </p>
				<input type="submit" value="Cerrar Sesión" class="btn btn-outline-primary" name="btnCerrarSesion">
			</form>
		</div>
	
		</div>
	</div>
</head>
<section>
<div class="container-fluid">
	<form method="get" action="Servlet_InicioAdmin">
	
	<p>Administrar Alumnos</p>
	<ul>
		<li>
			<a style=""href="Servlet_InicioAdmin?Param=1">Alta de Alumno</a> 
		</li>
		<li> 
			<a href="Servlet_InicioAdmin?Param=2">Listado y modificacion de alumnos</a>
		</li>
	</ul>
	<p>Administrar Profesores</p>
	<ul>
		<li>
			<a href="Servlet_InicioAdmin?Param=3">Alta de Profesor </a>
		</li>
		<li>
			<a href="Servlet_InicioAdmin?Param=4">Listado y modificacion de profesores </a>
		</li>
	</ul>
	<p>Administrar cursos </p>
	<ul>
		<li>
			<a href="Servlet_InicioAdmin?Param=5">Alta de Curso </a>
		</li>
		<li>
			<a href="Servlet_InicioAdmin?Param=6"> Listado de cursos </a>
		</li>
	</ul>
	</form>
	</div>
</section>
</body>
</html>