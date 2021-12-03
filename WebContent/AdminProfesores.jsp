<%@page import="java.util.ArrayList"  %>
<%@page import="entidades.Profesor" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
</head>
<body>

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
	
	<table border="1">
		<tr> 
			<td></td> <td></td> <th>Legajo</th> <th>DNI</th> <th>Nombre</th> <th>Apellido</th> <th>Fecha de Nacimiento</th>
			<th>Direccion</th> <th>Localidad</th> <th>Nacionalidad</th> <th>Email</th> <th>Contraseña</th> <th>Telefono</th>
			
		</tr>

		<%
	 	if(listaProfesor!=null){
	 		for(Profesor Prof : listaProfesor){
	 	%>
	 	<tr>
	 		<form action="Servlet_Profesores" method="post">
	 			<td><input type="submit" name="btnEditar" value="Editar"/></td>
				<td>Eliminar</td>
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
	
	
	
</body>
</html>