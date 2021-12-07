<%@page import="entidades.Usuario" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inicio</title>
</head>
<body>

	<%
	Usuario user = new Usuario();
	if(session.getAttribute("Usuario")!=null){
		user = (Usuario)session.getAttribute("Usuario");
	}else{response.sendRedirect("Login.jsp");}
	%>

	<h3>Bienvenido/a</h3>

	<form method="post" action="Servlet_Login">
	<div style=text-align:right><%= user.getNombre_Usuario() %>
	<input type="submit" value="CerrarSesion" name="btnCerrarSesion">
	</div>
	</form>
	
	<form>
		<b>Seleccionar Materia para administrar alumnos: </b>
		<select name="materia">
			<option> Laboratorio IV </option>
			<option> Laboratorio III </option>
			<option> Laboratorio II </option>
		</select>
		<input type="submit" value="Buscar" name="btnBuscarAlumnos">
	</form>
	
	<form>
		<b>Cargar Nota Masiva (curso seleccionado)</b>
		<br>
		<input type="text" name="txtParcial1">
		<input type="text" name="txtParcial2">
		<input type="text" name="txtRecuperatorio1">
		<input type="text" name="txtRecuperatorio1">
		<input type="submit" value="Cargar Nota" name="btnCargarNota">
	</form>
		<h3>Alumnos:</h3>
		<table border="1">
			<tr> 
				<td></td>
				<th>Materia</th>
				<th>Legajo</th>
				<th>DNI</th>
				<th>Nombre</th>
				<th>Apellido</th>
				<th>Email</th>
				<th>Parcial 1</th>
				<th>Parcial 2</th>
				<th>Recuperatorio 1</th>
				<th>Recuperatorio 2</th>
				<th>Estado Cursada</th>
		
			</tr>
			<tr>
				<td><a>Editar</a></td>
				<td>Laboratorio IV</td>
				<td>9999</td>
				<td>222222</td>
				<td>Mario</td>
				<td>Perez</td>
				<td>mario@alumno.com</td>
				<td>7</td>
				<td>7</td>
				<td>-</td>
				<td>-</td>
				<td>Regular</td>
			</tr>
			
			<tr>
				<td><a>Editar</a></td>
				<td>Laboratorio IV</td>
				<td>1111</td>
				<td>333333</td>
				<td>Elias</td>
				<td>Gonzales</td>
				<td>elias@alumno.com</td>
				<td>6</td>
				<td>5</td>
				<td>8</td>
				<td>-</td>
				<td>Regular</td>
			</tr>
	
		</table>
	
	
	
	
</body>
</html>