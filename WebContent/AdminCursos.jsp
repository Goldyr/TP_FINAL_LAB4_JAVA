<%@page import="entidades.Usuario" %>
<%@page import="java.util.ArrayList"  %>
<%@page import="entidades.Curso" %>
<%@page import="servlets.Servlet_AdminCursos" %>
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
    $('#tablaCursos').DataTable({searching: false, language: {url: '//cdn.datatables.net/plug-ins/1.11.3/i18n/es_es.json'}});
} );
</script>

<style>

.dataTables_length{
margin: 10px 0;
}

</style>

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

	<header>
	<div class="container-fluid my-2">
	<div class="row">
		<div class="col">
 			<h3>Bienvenido/a a la administración - Listado de Cursos</h3>
		</div>
		<div class="col text-right d-flex justify-content-end">
			<form method="post" action="Servlet_Login">
				<p style="display:inline-block; margin:0; padding:0.375rem 0.75rem;">Administrador: <%= user.getNombre_Usuario() %> </p>
				<input type="submit" value="Cerrar Sesión" class="btn btn-outline-primary" name="btnCerrarSesion">
			</form>
		</div>
	</div>
	</div>
</header>

	<ul>
	<li>
		<a href="InicioAdmin.jsp">Inicio</a>
	</li>
	<li>
	<a href="Servlet_InicioAdmin?Param=5">Alta de Curso</a>
	</li>
	</ul>
	
<section>
<div class="container-fluid">
	<h4>Listado de los cursos de la carrera</h4>
	

	<form method="post" action="Servlet_AdminCursos">
	<input type="submit" name="btnMostrarCursos" value="Mostrar Cursos">
	</form>

	<%
	ArrayList<Curso> ListaCursos = null;
	if(request.getAttribute("ListaC")!=null){
		ListaCursos = (ArrayList<Curso>)request.getAttribute("ListaC");
	}else{ListaCursos = Servlet_AdminCursos.listarcursos();}
	%>
	
	<table border="1" id="tablaCursos" class="table">
	<thead class="table-dark">
		<tr> 
			<th>Cod. Curso</th><th>Materia</th><th>Semestre</th><th>Año</th>
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
	</div>
	</section>
</body>
</html>