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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>

<script type="text/javascript">
$(document).ready( function () {
    $('#tablaCursos').DataTable();
} );
</script>
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
	
	<table border="1" id="tablaCursos" class="display">
	<thead>
		<tr> 
			<th>Curso</th><th>Materia</th><th>Semestre</th><th>Año</th>
		</tr>
	</thead>
		<%if(ListaCursos != null){ %>
		<tbody>
		<tr><%for(Curso curso : ListaCursos){ if(curso.getEstado()==true){%>
			<td><%=curso.getCodCurso() %></td>
			<td><%=curso.getCodMateria()%></td>
			<td><%=curso.getSemestre_Curso() %></td>
			<td><%=curso.getAnio_Curso() %></td>

		</tr>
		</tbody>
		<%}}} %>
	</table>
</body>
</html>