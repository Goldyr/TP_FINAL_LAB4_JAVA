<%@page import="entidades.Profesor" %>
<%@page import="dao.ProfesorDao" %>
<%@page import="entidades.Usuario" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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

	<form method="post" action="Servlet_Login">
	<div style=text-align:right><%= user.getNombre_Usuario() %>
	<input type="submit" value="CerrarSesion" name="btnCerrarSesion">
	</div>
	</form>

	<form method="post" action="Servlet_AltaProfesor">
		<h3>Alta Profesor</h3>
	    <p>DNI                     <input type="text" name="txtDNI"> </p>
	    <p>Nombre                 <input type="text" name="txtNombre"> </p>
	    <p>Apellido             <input type="text" name="txtApellido"> </p>
	    <p>Contraseña             <input type="password" name="txtContraseña"> </p>
	    <p>Repetir Contraseña     <input type="password" name="txtRepContraseña"> </p>
	    <p>Fecha de nacimiento     <input type="date" name="txtFechaNacimiento"> </p>
	    <p>Direccion             <input type="text" name="txtDireccion"> </p>
	    <p>Nacionalidad            <input type="text" name="txtNacionalidad"> </p>
	    <p>Localidad             <input type="text" name="txtLocalidad"> </p>
	    <p>Email                 <input type="text" name="txtEmail"> </p>
	    <p>Telefono             <input type="text" name="txtTelefono"> </p>
	    
		<input type="submit" name="btnAltaProfesor" value="AltaProfesor">
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
	
	

</body>
</html>