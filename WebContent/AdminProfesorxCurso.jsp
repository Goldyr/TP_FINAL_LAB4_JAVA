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
	 	String legajo = "";
	 	if(request.getSession().getAttribute("LegajoProf")!=null){
	 		legajo = (String)request.getSession().getAttribute("LegajoProf");
	 		listaCurso = Servlet_AdminProfesorxCurso.Cursos(legajo);
	 	}
	 	%>
	 	
	 	<%
	 	ArrayList <Curso> listaCurso_noProfesor = null;    
	 	
	 	if(request.getSession().getAttribute("LegajoProf")!=null){
	 		legajo = (String)request.getSession().getAttribute("LegajoProf");
	 		listaCurso_noProfesor = Servlet_AdminProfesorxCurso.Cursos_noProfesor(legajo);
	 		session.setAttribute("LegajoProfxCurs",legajo);
	 	}
	 	
	 	%>
	 	
	
	<h3> Cursos en los que no esta inscripto </h3>
	<table border="1" class="display" id="tablaCursos" >
	<thead>
		<tr> 
			<th></th> <th>Codigo Curso</th> <th>Codigo Materia</th> <th>Semestre</th> <th>Año</th>
		</tr>
	</thead>

	 	<tbody>
	 		 	
	 	<%
	 	if(listaCurso_noProfesor!=null){
	 		for(Curso curs : listaCurso_noProfesor){
	 	%>
	 	<tr>
	 		<form action="Servlet_AdminProfesorxCurso" method="post">
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
	
	<h3> Cursos en los que esta inscripto </h3>
	
	<table border="1" class="display" id="tablaOnlyCursos">
	<thead>
		<tr> 
			<th>Codigo Curso</th> <th>Codigo Materia</th> <th>Nombre Materia</th> <th>Semestre</th> <th>Año</th>
		</tr>
	</thead>

	 	<tbody>
	 		 	
	 	<%
	 	if(listaCurso!=null){
	 		for(Curso curs : listaCurso){
	 	%>
	 	<tr>
	 		<form action="Servlet_AdminProfesorxCurso" method="post">
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
	 
	 <%
		String mensaje="";
		if(request.getAttribute("AltaProfesorxcurs")!=null){
	
			mensaje= (String)request.getAttribute("MensajeError");		
		}
		if(request.getAttribute("MensajeError")!=null){
			mensaje= (String)request.getAttribute("MensajeError");	
		}
	%>
	<%=mensaje %>
</body>
</html>