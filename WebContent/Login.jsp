<%@page import="entidades.Usuario" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h2>Login</h2>
	
	<form method="post" action="Servlet_Login">
		<p>Ingresar Mail:<p>
		<input type="text" name="txtMail">
		
		<p>Ingresar Contraseņa:<p>
		<input type="password" name="txtPass">
		<br>
		<br>
		<input type="submit" name="btnIniciarSesion" value="Iniciar Sesion">
	</form>
	
	<%

	if(request.getAttribute("error")!= null)
	{
	%>
	Contraseņa o email incorrecto	
	
	<% 
	}

	 %>
</body>
</html>