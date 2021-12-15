<%@page import="entidades.Profesor" %>
<%@page import="dao.ProfesorDao" %>
<%@page import="entidades.Usuario" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alta Profesor</title>
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

<head>
	<div class="container-fluid my-2">
	<div class="row">
		<div class="col">
 			<h3>Bienvenido/a a la administración - Alta de profesores</h3>
		</div>
		<div class="col text-right d-flex justify-content-end">
			<form method="post" action="Servlet_Login">
				<p style="display:inline-block; margin:0; padding:0.375rem 0.75rem;">Administrador: <%= user.getNombre_Usuario() %> </p>
				<input type="submit" value="Cerrar Sesión" class="btn btn-outline-primary" name="btnCerrarSesion">
			</form>
		</div>
	</div>
	</div>
</head>

	<ul>
	<li>
		<a href="InicioAdmin.jsp">Inicio</a>
	</li>
	<li>
	<a href="Servlet_InicioAdmin?Param=4">Listado de Profesores</a>
	</li>
	</ul>
	
<section>
<div class="container-fluid">
	<form method="post" action="Servlet_AltaProfesor">
		<h4>Alta de Profesor</h4>
		<p>DNI                     <input type="text" name="txtDNI" placeholder="Ingrese el DNI" pattern="[0-9]{8}" title="Debe ingresar 8 números" required />
	    <p>Nombre                 <input type="text" placeholder="Ingrese el Nombre" name="txtNombre" required> </p>
	    <p>Apellido             <input type="text" placeholder="Ingrese el Apellido" name="txtApellido" required> </p>
	    <p>Contraseña             <input type="password"  placeholder="Ingrese la contraseña"name="txtContraseña" required> </p>
	    <p>Repetir Contraseña     <input type="password"  placeholder="Repita la contraseña"name="txtRepContraseña" required> </p>
	    <p>Fecha de nacimiento     <input type="date" pattern="/d{1,2}/\d{1,2}/\d{4}" name="txtFechaNacimiento" required> </p>
	    <p>Direccion             <input type="text" placeholder="Ingrese la Direccion" name="txtDireccion" required> </p>
	    <p>Nacionalidad            <input type="text" placeholder="Ingrese la Nacionalidad"name="txtNacionalidad" required> </p>
	    <p>Localidad             <input type="text" name="txtLocalidad" required> </p>
	    <p>Email                 <input type="email" placeholder="Ingrese el Email"name="txtEmail" required> </p>
	    <p>Telefono             <input type="tel" placeholder="Ingrese el Telefono" name="txtTelefono" required> </p>
	    
		<input type="submit" name="btnAltaProfesor" value="Dar de alta">
	</form>
	  	
	<%
		String mensaje="";
		if(request.getAttribute("AltaProfesor")!=null){
	
			mensaje= (String)request.getAttribute("MensajeError");	
			
		}
	
		if(request.getAttribute("MensajeError")!=null){
			mensaje= (String)request.getAttribute("MensajeError");	
		}
	%>
	
	<%=mensaje %>
	
	</div>
</section>
</body>
</html>