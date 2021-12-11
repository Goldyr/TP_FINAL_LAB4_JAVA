<%@page import="entidades.Usuario" %>
<%@page import="java.util.ArrayList"  %>
<%@page import="entidades.Profesor" %>
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
    $('#tablaProfesores').DataTable();
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
	
<h3>Listado Profesores</h3>
	<a href="AdminAltaProfesor.jsp">Alta Profesor</a>
	
		<form method="post" action="Servlet_Profesores">
		<input type="submit" name="btnMostrarProfesores" value="Mostrar Profesores" > 
		</form>
	
	<%
	ArrayList<Profesor> listaProfesor = null;
	if(request.getAttribute("ListaP")!=null){
		listaProfesor = (ArrayList<Profesor>)request.getAttribute("ListaP");
	}
	%>
	
	<%
	Profesor profesorEdit = null;
	if(request.getAttribute("ProfesorEditable")!= null)
	{
		profesorEdit = (Profesor)request.getAttribute("ProfesorEditable");
	}
	%>
	
	<table border="1" class="display" id="tablaProfesores">
	<thead>
		<tr> 
			<td></td> <td></td> <th>Legajo</th> <th>DNI</th> <th>Nombre</th> <th>Apellido</th> <th>Fecha de Nacimiento</th>
			<th>Direccion</th> <th>Localidad</th> <th>Nacionalidad</th> <th>Email</th> <th>Contraseña</th> <th>Telefono</th>
			
		</tr>
	</thead>

	 	<tbody>
	 	<%
	 	if(listaProfesor!=null){
	 		for(Profesor Prof : listaProfesor){
	 	%>
	 	<tr>
	 		<form action="Servlet_Profesores" method="post">
	 			<td><input type="submit" name="btnEditar" value="Editar"/></td>
				<td><input type="submit" name="btnEliminar" value="Eliminar"/></td>
	 			<td><%=Prof.getLegajo_Usuario()%> <input type="hidden" name="legajoUsuario" value="<%=Prof.getLegajo_Usuario() %>"></td>
	 			<td><%= Prof.getDNI_Usuario() %></td> 
	 			<td><%=Prof.getNombre_Usuario()%></td>
	 			<td><%=Prof.getApellido_Usuario()%></td>
	 			<td><%=Prof.getFechaNac_Profesor()%></td>
	 			<td><%=Prof.getDireccion_Profesor()%></td>
	 			<td><%= Prof.getLocalidad_Profesor() %></td> 
	 			<td><%= Prof.getNacionalidad_Profesor() %></td>
	 			<td><%=Prof.getEmail_Usuario()%></td>
	 			<td><%=Prof.getContraseña_Usuario()%></td>
	 			<td><%=Prof.getTelefono_Usuario()%></td>
	 		</form>	
	 	</tr>
	 	</tbody>
	 	<%
	 		}
	 	}
		// Termina el if de listaProfesor != null
	 	else{
	 		if(profesorEdit != null)
	 		{
	 	%>

	 			<tr>
	 				<form action="Servlet_Profesores" method="post">
	 					<td><input type="submit" name="btnVolver" value="Volver"/></td>
						<td><input type="submit" name="btnGuardarEdicion" value="Guardar"/></td>
						
	 					<td><%=profesorEdit.getLegajo_Usuario()%> <input type="hidden" name="legajoUsuario" value="<%=profesorEdit.getLegajo_Usuario() %>"></td>
	 					<td><input type="text" required name="dniUsuario" value="<%= profesorEdit.getDNI_Usuario() %>"></td> 
	 					<td><input type="text" required name="nombreUsuario" value="<%=profesorEdit.getNombre_Usuario()%>"></td>
	 					<td><input type="text" required name="apellidoUsuario" value="<%=profesorEdit.getApellido_Usuario()%>"></td>
	 					<td><input type="date"  required name="fechaNacUsuario" value="<%=profesorEdit.getFechaNac_Profesor()%>"></td>
	 					<td><input type="text" name="direccionUsuario" value="<%=profesorEdit.getDireccion_Profesor()%>"></td>
	 					<td><input type="text" name="localidadUsuario" value="<%= profesorEdit.getLocalidad_Profesor() %>"></td> 
	 					<td><input type="text" name="nacionalidadUsuario" value="<%= profesorEdit.getNacionalidad_Profesor() %>"></td>
	 					<td><input type="text" required name="emailUsuario" value="<%= profesorEdit.getEmail_Usuario()%>"></td>
	 					<td><input type="text" required name="contraseñaUsuario" value="<%= profesorEdit.getContraseña_Usuario()%>"></td>
	 					<td><input type="text" required name="telefonoUsuario" value="<%= profesorEdit.getTelefono_Usuario()%>"></td>
	 				</form>	
	 			</tr>

	 	<%	
	 		}
	 	}
		 %>
	</table>
	
	<% String mensajeResultado = null; 
	if(request.getAttribute("MensajeResultado")!= null)
	{
		mensajeResultado = (String)request.getAttribute("MensajeResultado");
	}
	%>
	<% if(mensajeResultado != null){ %>
	<p style="font-weight: bold;"> <%=mensajeResultado %></p>
	<% } %>
	
	
</body>
</html>