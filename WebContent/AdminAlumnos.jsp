<%@page import="entidades.Usuario" %>
<%@page import="java.util.ArrayList"  %>
<%@page import="entidades.Alumno" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
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
    $('#tablaAlumnos').DataTable({searching: false, language: {url: '//cdn.datatables.net/plug-ins/1.11.3/i18n/es_es.json'}});
} );
</script>
<script type="text/javascript">
function ConfirmDelete()
{
	var respuesta = confirm("Estas seguro que desea Eliminar al Alumno?")
	
if(respuesta == true){
	return true;
}else{return false;}
}
</script>

<style>

.dataTables_length{
margin: 10px 0;
}

</style>


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

<header>
	<div class="container-fluid my-2">
	<div class="row">
		<div class="col">
 			<h3>Bienvenido/a a la administración - Listado y modificación de Alumnos</h3>
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
	<a href="Servlet_InicioAdmin?Param=1">Alta Alumno</a>
	</li>
	</ul>
	
<section>
	<div class="container-fluid">
	<h4>Listado de los alumnos en la carrera</h4>
	
	<form method="post" action="Servlet_Alumnos">
		<p>Haga clic en el boton para mostrar y modificar los alumnos inscritos</p>
		<input type="submit" name="btnMostrarAlumnos" value="Mostrar Alumnos">
	</form>
	
	<%
	ArrayList<Alumno> listaAlumno = null;
	if(request.getAttribute("ListaA")!=null){
		listaAlumno = (ArrayList<Alumno>)request.getAttribute("ListaA");
	}
	%>
	
	<%
	Alumno alumnoEditable = null;
	if(request.getAttribute("AlumnoEditable")!= null)
	{
		alumnoEditable = (Alumno)request.getAttribute("AlumnoEditable");
	}
	%>
	
	<table border="1" class="display table" id="tablaAlumnos">
		<thead>
		<tr class="table-dark" scope="row">
			<td> </td>
			<td> </td>
			<th>Legajo</th>
			<th>DNI</th>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Fecha Nac</th>
			<th>Direccion</th>
	 		<th>Nacionalidad</th>
	 		<th>Provincia</th>
	 		<th>Email</th>
	 		<th>Telefono</th>
	 	</tr>
	 	</thead>
	 <%
	 if(listaAlumno !=null) {
	 for(Alumno Alu : listaAlumno){
	 %>
	 <tbody>
	 <tr scope="row">
	 	<form method="post" action="Servlet_Alumnos">
	 		<td><input type="submit" name="btnEditar" value="Editar"/></td>
			<td><input type="submit" name="btnEliminar" value="Eliminar" onclick="return ConfirmDelete()"/></td>	
	 		<td><%=Alu.getLegajo_Alumno() %> <input type="hidden" name="legajoAlumno" value="<%=Alu.getLegajo_Alumno()%>"> </td> 	
	 		<td><%=Alu.getDni_Alumno() %></td>	 
	 		<td><%=Alu.getNombre_Alumno()%></td>
	 		<td><%=Alu.getApellido_Alumno()%></td>
	 		<td><%=Alu.getFechaNac_Alumno()%></td> 
	 		<td><%=Alu.getDireccion_Alumno()%></td>
	 		<td><%=Alu.getNacionalidad_Alumno() %></td>
	 		<td><%=Alu.getProvincia_Alumno()%></td>
	 		<td><%=Alu.getEmail_Alumno()%></td>
	 		<td><%=Alu.getTelefono_Alumno()%></td>
	  	</form>
	 </tr>
	 </tbody>
	 <%
	 	}
	 }
	 
	 else {
		 if(alumnoEditable != null){
			
	 %>

	 <tr scope="row">
	 		<form action="Servlet_Alumnos" method="post">
	 			<td><input type="submit" name="btnVolver" value="Volver" class="btn btn-warning"/></td>
				<td><input type="submit" name="btnGuardarEdicion" value="Guardar" class="btn btn-success"/></td>
	 			<td><%=alumnoEditable.getLegajo_Alumno()%> <input type="hidden" name="legajoAlumno" value="<%=alumnoEditable.getLegajo_Alumno() %>"></td>
	 			<td><input type="text" required name="dniAlumno" value="<%=alumnoEditable.getDni_Alumno() %>"></td> 
	 			<td><input type="text" required name="nombreAlumno" value="<%=alumnoEditable.getNombre_Alumno()%>"></td>
	 			<td><input type="text" required name="apellidoAlumno" value="<%=alumnoEditable.getApellido_Alumno()%>"></td>
	 			<td><input type="date"  required name="fechaNacAlumno" value="<%=alumnoEditable.getFechaNac_Alumno()%>"></td>
	 			<td><input type="text" name="direccionAlumno" value="<%=alumnoEditable.getDireccion_Alumno()%>"></td>
	 			<td><input type="text" name="nacionalidadAlumno" value="<%= alumnoEditable.getNacionalidad_Alumno() %>"></td>
	 			<td><input type="text" name="provinciaAlumno" value="<%=alumnoEditable.getProvincia_Alumno()%>"></td>
	 			<td><input type="text" required name="emailAlumno" value="<%= alumnoEditable.getEmail_Alumno()%>"></td>
	 			<td><input type="text" required name="telefonoAlumno" value="<%= alumnoEditable.getTelefono_Alumno()%>"></td>
	 		</form>	
	 </tr>

	 <%
		 	}
		}
	 %>
	</table>
	
	<% 
	String mensajeResultado = null; 
	if(request.getAttribute("MensajeResultado")!= null)
	{
		mensajeResultado = (String)request.getAttribute("MensajeResultado");
	}
	%>
	<% if(mensajeResultado != null){ %>
	<p style="font-weight: bold;"> <%=mensajeResultado %></p>
	<% } %>
	</div>
</section>
</body>
</html>