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
		
		<p>Ingresar Contraseña:<p>
		<input type="text" name="txtPass">
		<br>
		<br>
		<input type="submit" name="btnIniciarSesion" value="Iniciar Sesion">
	</form>

	<%
	Usuario user = new Usuario();
	
	if(request.getAttribute("usuarioA")!=null)
	{
		user = (Usuario)request.getAttribute("usuarioA");
		
	}
	
	if(request.getAttribute("error")!= null)
	{
	%>
	Contraseña o email incorrecto	
	<% 
	}
	
	
	if(user.getLegajo_Usuario() != null)
	{
		session.setAttribute("legajo" , user.getLegajo_Usuario());//Atributo global del legajo del usuario en la sesion
		
		if(user.isAdmin_Usuario())
		{
			
			response.sendRedirect("InicioAdmin.jsp");
		}
		else
		{
			
			response.sendRedirect("InicioProfesor.jsp");
		}
	}
	
	
	 %>
</body>
</html>