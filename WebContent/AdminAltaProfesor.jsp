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