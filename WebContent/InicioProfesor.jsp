<%@ page import="entidades.Usuario" %>
<%@ page import="entidades.Materia" %>
<%@ page import="entidades.Curso" %>
<%@page import="servlets.Servlet_InicioProfesor" %>
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

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>

<script type="text/javascript">
$(document).ready( function () {
    $('#tablaCursosxAlumnos').DataTable({searching: false, language: {url: '//cdn.datatables.net/plug-ins/1.11.3/i18n/es_es.json'}});
} );
</script>

</head>

<style>

.dataTables_length{
margin: 10px 0;
}

</style>

<body>

	<!-- DECLARACION DE VARIABLES -->
	
		<!-- CURSOS -->
	
	<%
	ArrayList<Curso> arrCursos = null;
	if(request.getAttribute("ListaCursos")!=null){
		arrCursos = (ArrayList<Curso>)request.getAttribute("ListaCursos");
	}
	%>

	<!-- USUARIO/PROFESOR -->

	<%
	Usuario user = new Usuario();
	if(session.getAttribute("Usuario")!=null){
		user = (Usuario)session.getAttribute("Usuario");

		
	}else{
		response.sendRedirect("Login.jsp");
		
	}
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
	


	<header class="my-2">
		<div class="container-fluid">
			<div class="row">
				<div class="col-8">
					<h3>Bienvenido/a </h3>
				</div>
				<div class="col-4 text-right d-flex justify-content-end">
					<form method="post" action="Servlet_Login">
						<p style="display:inline-block; margin:0; padding:0.375rem 0.75rem;">Docente: <%= user.getNombre_Usuario() %> </p>
						<input type="submit" class="btn btn-outline-primary" value="Cerrar Sesión" name="btnCerrarSesion">
					</form>
				</div>
			</div>
		</div>
	</header>

	
	<form method="post" action="Servlet_InicioProfesor">
	<div class="container-fluid">
		<div class="row">
			<div class="col-3">
				<p style="display:inline-block;">Selecciona una materia para administrar alumnos:  </p>
            	<input type="hidden" value="<%=user.getLegajo_Usuario() %>" name="legajoProfesor"/>
			</div>
			<div class="col-2">	
            	<select name="materia_a_administrar" class="form-select form-select-sm">
	
	                <%
	                ArrayList<Materia> listamaterias = new ArrayList<Materia>();
	
	                if(user.getLegajo_Usuario() != null){
	                	
	           
	                    listamaterias = Servlet_InicioProfesor.obtenerddlmateria(((Usuario)session.getAttribute("Usuario")).getLegajo_Usuario());
	                    for(Materia mat : listamaterias)
	                    {
	                %>
	                    <option value="<%=mat.getCodigoMateria()%>"> <%=mat.getNombreMateria()%> </option>
	
	                <%
	                    }
	                }
	
	                %>
	            </select>
	       
            </div>
            	<div class="col-1">
					<input type="submit" value="Buscar" name="btnBuscarAlumnos">
				</div>
			     <div>	
	            	<input type="radio" id="radioInput" name="radios" value="Primer Semestre">
	            	<label for="radioInput">Primer Semestre</label>
	            </div>
	            <div>
	            	<input type="radio" id="radioInput2" name="radios" value="Segundo Semestre">
	            	<label for="radioInput2">Segundo Semestre</label>
	            </div>
	            <div>
	            	<input type="radio" id="radioInput3" name="radios" value="Ambos">
	            	<label for="radioInput3">Ambos</label>
	            </div>
		</div>
		<h4>Modificar notas de manera masiva</h4>
		<div class="row my-3 container-fluid">
			 <div class="row justify-content-start"> 
				 <div class="col-5 ">
	
				 <p style="display:inline-block;">1. Selecciona un curso de la materia seleccionada </p>
				 <select name="cursoNotasMasiva" class="form-select form-select-sm">
				 	<%
				 	if(arrCursos != null){
				 		for(Curso curso : arrCursos){
				 	%>
				 	<option value="<%=curso.getCodCurso() %>"><%=curso.getSemestre_Curso() %> <%=curso.getAnio_Curso() %></option>
				 	<%
				 		}
				 	}
				 	
				 	%>
				 </select>
				 </div>
			 </div>
			 
			<div class="row justify-content-start"> 
				<div class="col-5">
					<p>2. Selecciona los alumnos que deseas modificar la nota (Ctrl + Clic Izq.)</p>
					 <select name="alumnosNotasMasiva" class="form-select form-select-sm" multiple>
						 <% if(arrListNotas != null) 
							{
								for(Notas nota : arrListNotas){
						%>
							 	<option value="<%=nota.getAlumno_Nota().getLegajo_Alumno() %>"><%=nota.getAlumno_Nota().getNombre_Alumno()%> <%=nota.getAlumno_Nota().getApellido_Alumno()%></option>
						<% 		} 
							}
						%>
			 		</select>
				</div>
			</div>
			<div class="row justify-content-start"> 
				<div class="col-5">
						 <div class="row"> 
				 	 	<p>3. Ingresar las notas y luego hacer clic botón</p>
				 	<div class="col">
				 		<label for="txtParcial1" name="lblParcial1">Nota parcial 1 (*)</label>
						<input class="form-control form-control-sm" type="number" placeholder="1.0" step="0.1" min="0" max="10" name="txtParcial1">
				 	</div>
				 	<div class="col">
				 		<label for="txtParcial2" name="lblParcial2">Nota parcial 2 (*)</label>
						<input class="form-control form-control-sm" type="number" placeholder="1.0" step="0.1" min="0" max="10" name="txtParcial2">
				 	</div>
				 </div>
				  <div class="row"> 
				  	<div class="col">
				  		<label for="txtRecuperatorio1" name="lblRecuperatorio1">Nota recuperatorio 1</label>
						<input class="form-control form-control-sm" type="number" placeholder="0" step="0.1" min="0" max="10" name="txtRecuperatorio1">
				  	</div>
				  	 <div class="col">
				  	 <label for="txtRecuperatorio2" name="lblRecuperatorio2">Nota recuperatorio 2</label>
						<input class="form-control form-control-sm" type="number" placeholder="0" step="0.1" min="0" max="10" name="txtRecuperatorio2">
				  	</div>
				 </div>
				  <div class="row"> 
					  <div class="col-1">
					  		<input type="submit" class="my-3" value="Cargar Notas" name="btnCargarNota">
					  </div>
				  </div>
	
				</div>
			</div>
		</div>
	</div>
<section>
		<div class="container-fluid"> 
			<h4>Tabla de los alumnos en cursos de la materia seleccionada</h4>
			<table border="1" id="tablaCursosxAlumnos" class="table table-sm">
				<thead class="table-dark">
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
						<td><%=nota.getMateria_Nota().getNombreMateria()%> <input type="hidden" name="CodNotaAlumno" value="<%=nota.getCodNotas_Nota() %>"/> </td>
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
				<td><%=notaEdit.getMateria_Nota().getNombreMateria() %> <input type="hidden" name="CodNotaAlumno" value="<%=notaEdit.getCodNotas_Nota() %>"/> </td>
				<td><%=notaEdit.getAlumno_Nota().getLegajo_Alumno() %></td>
				<td><%=notaEdit.getAlumno_Nota().getNombre_Alumno() %></td>
				<td><%=notaEdit.getAlumno_Nota().getApellido_Alumno() %></td>
				<td><%=notaEdit.getAlumno_Nota().getEmail_Alumno() %></td>
				<td><input name="notaParcial1"  required type="number" placeholder="1.0" step="0.1" min="0" max="10" value="<%=notaEdit.getParcial_1_Nota()%>" /></td>
				<td><input name="notaParcial2" required type="number" placeholder="1.0" step="0.1" min="0" max="10" value="<%=notaEdit.getParcial_2_Nota() %>" /></td>
				<td><input name="notaRec1" type="number" placeholder="1.0" step="0.1" min="0" max="10" value="<%=notaEdit.getRecuperatorio_1_Nota() %>" /></td>
				<td><input name="notaRec2" type="number" placeholder="1.0" step="0.1" min="0" max="10" value="<%=notaEdit.getRecuperatorio_2_Nota() %>" /></td>
				<td><%=notaEdit.getEstadoCursada_Nota() %></td>
			</tr>
			<%
			}
			%>
			</tbody>
			</table>
		</div>
	</section>
</form>
	

</body>
</html>