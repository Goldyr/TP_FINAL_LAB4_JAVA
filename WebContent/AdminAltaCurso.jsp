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

	<form method="post" action="Servlet_Login">
	<div style=text-align:right><%= user.getNombre_Usuario() %>
	<input type="submit" value="CerrarSesion" name="btnCerrarSesion">
	</div>
	</form>
	
	<form action="Servlet_AdminAltaCurso" method="post">
		<h3>Alta Curso</h3>
		<b>Seleccionar Materia</b>
		
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
		<p>Semestre 			<input type="text"  placeholder="Ingrese el semestre" name="txtSemestre" required> </p>
		<p>A�o 				<input type="text"  placeholder="Ingrese el A�o" pattern="[0-9]{4}" title="Debe ingresar 4 digitos" name="txtAnio" required> </p>
	
		
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
</body>
</html>