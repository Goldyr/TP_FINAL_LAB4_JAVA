<%@page import="entidades.Usuario" %>
<%@page import="entidades.Curso" %>
<%@page import="java.util.ArrayList"  %>
<%@page import="servlets.Servlet_AdminProfesorxCurso" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>

<script type="text/javascript">
$(document).ready( function () {
	$('table.display').DataTable();

} );
</script>


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
	<input type="submit" value="Cerrar Sesion" name="btnCerrarSesion">
	</div>
	</form>
	 	<%
	 	ArrayList <Curso> listaCurso = null;    
	 	
	 	if(request.getAttribute("LegajoProf")!=null){
	 		String legajo = (String)request.getAttribute("LegajoProf");
	 		listaCurso = Servlet_AdminProfesorxCurso.Cursos(legajo);
	 	}
	 	%>
	 	
	 	<%
	 	ArrayList <Curso> listaCurso_noProfesor = null;    
	 	
	 	if(request.getAttribute("LegajoProf")!=null){
	 		String legajo = (String)request.getAttribute("LegajoProf");
	 		listaCurso_noProfesor = Servlet_AdminProfesorxCurso.Cursos_noProfesor(legajo);
	 	}
	 	%>
	 	
	 
	
	<table border="1" class="display" >
	<thead>
		<tr> 
			<td></td> <td></td> <th>codigo curso</th> <th>codigo materia</th> <th>semestre</th> <th>anio</th>
		</tr>
	</thead>

	 	<tbody>
	 		 	
	 	<%
	 	if(listaCurso_noProfesor!=null){
	 		for(Curso curs : listaCurso_noProfesor){
	 	%>
	 	<tr>
	 		<form action="Servlet_AdminProfesoresxCurso" method="post">
	 			<td><input type="submit" name="btnagregar_Alcurso" value="Agregar al curso"/></td>
	 			<td><%= curs.getCodCurso() %></td>
	 			<td><%= curs.getCodMateria() %></td> 
	 			<td><%= curs.getSemestre_Curso() %></td>
	 			<td><%= curs.getAnio_Curso() %></td>
	 		</form>	
	 	</tr>
	 	</tbody>
	 	<%
	 		}
	 	}
	 	%>
	 	</tbody>
	 </table>
	

	<table border="1" class="display" >
	<thead>
		<tr> 
			<td></td> <td></td> <th>codigo curso</th> <th>codigo materia</th> <th>Nombre materia</th> <th>semestre</th> <th>anio</th>
		</tr>
	</thead>

	 	<tbody>
	 		 	
	 	<%
	 	if(listaCurso!=null){
	 		for(Curso curs : listaCurso){
	 	%>
	 	<tr>
	 		<form action="Servlet_AdminProfesoresxCurso" method="post">
	 			<td><%= curs.getCodCurso() %></td>
	 			<td><%= curs.getCodMateria() %></td> 
	 			<td><%= curs.getMateria().getNombreMateria() %></td>
	 			<td><%= curs.getSemestre_Curso() %></td>
	 			<td><%= curs.getAnio_Curso() %></td>
	 		</form>	
	 	</tr>
	 	</tbody>
	 	<%
	 		}
	 	}
	 	%>
	 	</tbody>
	 </table>
</body>
</html>