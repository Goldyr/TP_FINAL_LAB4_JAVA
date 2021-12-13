<%@page import="entidades.Usuario" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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

	<form method="post" action="Servlet_Login">
	<div style=text-align:right><%= user.getNombre_Usuario() %>
	<input type="submit" value="CerrarSesion" name="btnCerrarSesion">
	</div>
	</form>
	
	<form method="post" action="Servlet_AltaAlumno">
		<h3>Alta Alumno</h3>
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