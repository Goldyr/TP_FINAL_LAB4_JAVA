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
	
	<table border="1">
		<tr> 
			<td></td> <td></td> <th>Legajo</th> <th>DNI</th> <th>Nombre</th> <th>Apellido</th> <th>Fecha de Nacimiento</th>
			<th>Direccion</th> <th>Localidad</th> <th>Nacionalidad</th> <th>Email</th> <th>Telefono</th>
			
		</tr>

		<%
	 	if(listaProfesor !=null){
	 	for(Profesor Prof : listaProfesor){
	 	%>
	 	<tr>
	 	<td>Editar </td>
		<td>Eliminar </td>
	 	<td><%=Prof.getLegajo_Usuario() %></td> <td><%= Prof.getDNI_Usuario() %></td> <td><%=Prof.getNombre_Usuario()%></td><td><%=Prof.getApellido_Usuario()%></td><td><%=Prof.getFechaNac_Profesor()%></td> <td><%=Prof.getDireccion_Profesor()%></td>
	 	<td><%= Prof.getLocalidad_Profesor() %></td> <td><%= Prof.getNacionalidad_Profesor() %></td> <td><%=Prof.getEmail_Usuario()%></td><td><%=Prof.getTelefono_Usuario()%></td>
	 	</tr>
	 
	 	<%
	 	}
	 	}
		
		 %>

	</table>
</body>
</html>