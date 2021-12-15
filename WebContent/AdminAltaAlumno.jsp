<%@page import="entidades.Usuario" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>


<title>Alta Alumno</title>
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
 			<h3>Bienvenido/a a la administración - Alta de alumno</h3>
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
		<li> <a href="InicioAdmin.jsp">Inicio</a></li>
		<li><a href="Servlet_InicioAdmin?Param=2">Listado y modificación de alumnos</a> </li>
	</ul>
	<section  class="container-fluid">
	<div >
	
	<form method="post" action="Servlet_AltaAlumno">
		<h4>Alta Alumno</h4>
		<p>Nombre 				<input type="text" placeholder="Ingrese el Nombre" name="txtNombre" required> </p>
		<p>Apellido 			<input type="text" placeholder="Ingrese el Apellido" name="txtApellido" required> </p>
		<p>DNI 					<input type="text" name="txtDNI" placeholder="Ingrese el DNI" pattern="[0-9]{8}" title="Debe ingresar 8 números" required />
		<p>Fecha de nacimiento 	<input type="date" pattern="/d{1,2}/\d{1,2}/\d{4}" name="txtFechaNacimiento" required> </p>
		<p>Direccion 			<input type="text" placeholder="Ingrese la Direccion" name="txtDireccion" required> </p>
		<p>Nacionalidad			<input type="text" placeholder="Ingrese la Nacionalidad" name="txtNacionalidad" required> </p>
		<p>Provincia 			<input type="text" name="txtProvincia" required> </p>
		<p>Email 				<input type="email" laceholder="Ingrese el Email" name="txtEmail" required> </p>
		<p>Telefono 			<input type="tel"  placeholder="Ingrese el Telefono" name="txtTelefono" required> </p>
		
		<input type="submit" name="btnAgregarAlumno" value="Agregar Alumno">
	</form>
	
		<%
		if(request.getAttribute("AlumnoAlta")!=null){
			if((boolean)request.getAttribute("AlumnoAlta")){
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

</body>
</html>