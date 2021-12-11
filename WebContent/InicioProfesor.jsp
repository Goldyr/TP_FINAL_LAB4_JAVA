<%@ page import="entidades.Usuario" %>
<%@ page import="entidades.Materia" %>

<%@ page import="entidades.Notas" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "java.util.List" %>
<%@page import="entidades.Notas" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inicio</title>


<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>

<script type="text/javascript">
$(document).ready( function () {
    $('#tablaCursosxAlumnos').DataTable();
} );
</script>

</head>
<body>

	<!-- DECLARACION DE VARIABLES -->

	<!-- USUARIO/PROFESOR -->

	<%
	Usuario user = new Usuario();
	if(session.getAttribute("Usuario")!=null){
		user = (Usuario)session.getAttribute("Usuario");
	}else{response.sendRedirect("Login.jsp");}
	%>

	<!-- NOTAS -->
	<%
	ArrayList<Notas> arrListNotas = null;
	
	if(request.getAttribute("ListaNotas")!=null){
		arrListNotas = (ArrayList<Notas>)request.getAttribute("ListaNotas");
		
	}
	%>

	<!-- EDICION DE NOTAS -->

	<%
	Notas notaEdit = null;
	if(request.getAttribute("NotaEditable")!=null){
		notaEdit = (Notas)request.getAttribute("NotaEditable");
		
	}
	%>
	

	<h3>Bienvenido/a</h3>

	<form method="post" action="Servlet_Login">
	<div style=text-align:right><%= user.getNombre_Usuario() %>
	<input type="submit" value="CerrarSesion" name="btnCerrarSesion">
	</div>
	</form>
	
	<form method="post" action="Servlet_InicioProfesor">

		<b>Seleccionar Materia para administrar alumnos: </b>
			<input type="hidden" value="<%=user.getLegajo_Usuario() %>" name="legajoProfesor"/>

			<select name="materia_a_administrar">

				<%
				ArrayList<Materia> listamaterias = new ArrayList<Materia>();
				
				if(request.getAttribute("listamaterias")!=null)
				{
					listamaterias = (ArrayList<Materia>)request.getAttribute("listamaterias");
					for(Materia mat : listamaterias)
					{
				%>
					<option value="<%=mat.getCodigoMateria()%>"> <%=mat.getNombreMateria()%> </option>
	
				<%
					}
				}
				%>
			</select>
		<input type="submit" value="Buscar" name="btnBuscarAlumnos">
	</form>
	
	<!--
	<form>
		 <b>Cargar Nota Masiva (curso seleccionado)</b>
		<br>
		<input type="text" name="txtParcial1">
		<input type="text" name="txtParcial2">
		<input type="text" name="txtRecuperatorio1">
		<input type="text" name="txtRecuperatorio1">
		<input type="submit" value="Cargar Nota" name="btnCargarNota">
	</form>
	 	-->
		<h3>Alumnos:</h3>
		<table border="1" id="tablaCursosxAlumnos" class="display">
			<thead>
			<tr> 
				<td></td>
				<th>Materia</th>
				<th>Legajo</th>
				<th>Nombre</th>
				<th>Apellido</th>
				<th>Email</th>
				<th>Parcial 1</th>
				<th>Parcial 2</th>
				<th>Recuperatorio 1</th>
				<th>Recuperatorio 2</th>
				<th>Estado Cursada</th>
		
			</tr>
			</thead>
		<tbody>
		<% if(arrListNotas != null) 
			{
				for(Notas nota : arrListNotas){
			%>
			<tr>
			<form method="post" action="Servlet_InicioProfesor">
					<td><input type="submit" value="Editar" name="btnEditar" /></td>
					<td><%=nota.getNombreMateria_Nota()%> <input type="hidden" name="CodNotaAlumno" value="<%=nota.getCodNotas_Nota() %>"/> </td>
					<td><%=nota.getAlumno_Nota().getLegajo_Alumno() %></td>
					<td><%=nota.getAlumno_Nota().getNombre_Alumno() %></td>
					<td><%=nota.getAlumno_Nota().getApellido_Alumno() %></td>
					<td><%=nota.getAlumno_Nota().getEmail_Alumno() %></td>
					<td><%=nota.getParcial_1_Nota() %></td>
					<td><%=nota.getParcial_2_Nota() %></td>
					<td><%=nota.getRecuperatorio_1_Nota() %></td>
					<td><%=nota.getRecuperatorio_2_Nota() %></td>
					<td><%=nota.getEstadoCursada_Nota() %></td>
				</form>
			</tr>
		
		<% 
				}
		}
		else if(notaEdit != null)
		{
		%>
		<tr>
			<td><input type="submit" value="Guardar" name="btnGuardar" /></td>
			<td><%=notaEdit.getNombreMateria_Nota() %> <input type="hidden" name="CodNotaAlumno" value="<%=notaEdit.getCodNotas_Nota() %>"/> </td>
			<td><%=notaEdit.getAlumno_Nota().getLegajo_Alumno() %></td>
			<td><%=notaEdit.getAlumno_Nota().getNombre_Alumno() %></td>
			<td><%=notaEdit.getAlumno_Nota().getApellido_Alumno() %></td>
			<td><%=notaEdit.getAlumno_Nota().getEmail_Alumno() %></td>
			<td><input name="notaParcial1" type="number" placeholder="1.0" step="0.1" min="1" max="10" value="<%=notaEdit.getParcial_1_Nota()%>" /></td>
			<td><input name="notaParcial2" type="number" placeholder="1.0" step="0.1" min="1" max="10" value="<%=notaEdit.getParcial_2_Nota() %>" /></td>
			<td><input name="notaRec1" type="number" placeholder="1.0" step="0.1" min="1" max="10" value="<%=notaEdit.getRecuperatorio_1_Nota() %>" /></td>
			<td><input name="notaRec2" type="number" placeholder="1.0" step="0.1" min="1" max="10" value="<%=notaEdit.getRecuperatorio_2_Nota() %>" /></td>
			<td><%=notaEdit.getEstadoCursada_Nota() %></td>
		</tr>
		<%
		}
		%>
		</tbody>
		</table>
	
	
	
</body>
</html>