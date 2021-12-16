<%@page import="entidades.Usuario" %>
<%@page import="entidades.Alumno" %>
<%@page import="java.util.ArrayList"  %>
<%@page import="entidades.Curso" %>
<%@page import="servlets.Servlet_AdminAltaAlumnoxCurso" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alta Alumno en el Curso</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
</head>
<script type="text/javascript">
$(document).ready( function () {
    $('#tablaCursos').DataTable({
         "bPaginate": true,
         "bLengthChange": false,
         "bInfo": false,
         "searching": false, 
         "ordering": true,
    });
    $('#tablaOnlyCursos').DataTable({
         "bPaginate": true,
         "bLengthChange": false,
         "bInfo": false,
         "searching": false, 
         "ordering": true,
    });

} );
</script>
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
			<div class="col text-right d-flex justify-content-end">
			<p style="display:inline-block; margin:0; padding:0.375rem 0.75rem;">Administrador: <%= user.getNombre_Usuario() %> </p>
			<input type="submit" value="Cerrar Sesión" class="btn btn-outline-primary" name="btnCerrarSesion">
		</div>
	</form>
	   
	 <div class="container-fluid">
    <a href="Servlet_InicioAdmin?Param=2">Volver Listado y modificacion de alumnos </a>
 
	<%
	String legajo ="";
	ArrayList <Curso> listaCurso = null;
	
	if(request.getSession().getAttribute("LegajoAlumnoxCurso")!=null){
		legajo = (String)request.getSession().getAttribute("LegajoAlumnoxCurso");
		listaCurso = Servlet_AdminAltaAlumnoxCurso.Cursos(legajo);
	}
	%> 
	
	<%
	ArrayList <Curso> listaCurso_noAlumno = null;
	
	if(request.getSession().getAttribute("LegajoAlumnoxCurso")!=null){
		legajo = (String)request.getSession().getAttribute("LegajoAlumnoxCurso");
		listaCurso_noAlumno = Servlet_AdminAltaAlumnoxCurso.Cursos_noAlumno(legajo);
	}
	%>
	
		<table border="1" class="display" id="tablaCursos">
	<thead>
		<tr> 
		 <td></td><th>Cod. Curso</th> <th>Cod. Materia</th> <th>Semestre</th> <th>Año</th>
		</tr>
	</thead>

	 	<tbody>
	 		 	
	 	<%
	 	if(listaCurso_noAlumno!=null){
	 		for(Curso curs : listaCurso_noAlumno){
	 	%>
	 	<tr>
	 		<form action="Servlet_AdminAltaAlumnoxCurso" method="post">
	 			<input type="hidden" name="LegajoAlumno" value="<%=legajo%>">
	 			<td><input type="submit" name="btnagregar_Alcurso" value="Agregar al curso"/></td>
	 			<td><%= curs.getCodCurso() %> <input type="hidden" name="CodCurso" value="<%=curs.getCodCurso()%>"></td>
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
	 
	 	<%
		String mensaje="";
		if(request.getAttribute("AltaAlumnoxCurso")!=null){
	
			mensaje= (String)request.getAttribute("MensajeError");	
			
		}
	
		if(request.getAttribute("MensajeError")!=null){
			mensaje= (String)request.getAttribute("MensajeError");	
		}
		%>
	
	<%=mensaje %>
	 
	 
		<h4> Cursos en los cuales esta inscripto el alumno </h4>
 		<table border="1" class="display" id="tablaOnlyCursos">
	<thead>
		<tr> 
		 <th>Cod. Curso</th> <th>Cod. Materia</th> <th>Nombre materia</th> <th>Semestre</th> <th>Año</th>
		</tr>
	</thead>

	 	<tbody>
	 		 	
	 	<%
	 	if(listaCurso!=null){
	 		for(Curso curs : listaCurso){
	 	%>
	 	<tr>
	 		<form action="Servlet_AdminAltaAlumnoxCurso" method="post">
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
 
 
 
	
</div>
 
</body>
</html>