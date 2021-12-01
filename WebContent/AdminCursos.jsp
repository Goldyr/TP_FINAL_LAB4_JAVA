<%@page import="java.util.ArrayList"  %>
<%@page import="entidades.Curso" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Listado Cursos</h3>
	<a href="AdminAltaCurso.jsp">Alta Curso</a>
	

	<form method="post" action="Servlet_AdminCursos">
	<input type="submit" name="btnMostrarCursos" value="Mostrar Cursos">
	</form>
	
	<%
	ArrayList<Curso> ListaCursos = null;
	if(request.getAttribute("ListaC")!=null){
		ListaCursos = (ArrayList<Curso>)request.getAttribute("ListaC");
	}
	%>
	
	<table border="1">
		<tr> 
			<th>Curso</th><th>Materia</th><th>Semestre</th><th>Año</th>
		</tr>
		<%if(ListaCursos != null){ %>
		<tr><%for(Curso curso : ListaCursos){ if(curso.getEstado()==true){%>
			<td><%=curso.getCodCurso() %></td>
			<td><%=curso.getCodMateria()%></td>
			<td><%=curso.getSemestre_Curso() %></td>
			<td><%=curso.getAnio_Curso() %></td>

		</tr>
		<%}}} %>
	</table>
</body>
</html>