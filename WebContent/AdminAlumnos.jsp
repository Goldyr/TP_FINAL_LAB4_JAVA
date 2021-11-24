<%@page import="java.util.List"  %>
<%@page import="entidades.Alumno" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
</head>
<body>

	<h3>Listado Alumnos</h3>
	<a href="AdminAltaAlumno.jsp">Alta Alumno</a>
	
	<form method="post" action="Servlet_Alumnos">
	<input type="submit" name="btnMostrarAlumnos" value="Mostrar Alumnos">
	</form>
	
	<%
	List<Alumno> listaAlumno = null;
	if(request.getAttribute("ListaA")!=null){
		listaAlumno = (List<Alumno>)request.getAttribute("ListaA");
	}
	%>
	
	<table border="1">
	<tr><th>Legajo</th><th>DNI</th><th>Nombre</th><th>Apellido</th><th>Fecha Nac</th> <th>Direccion</th>
	 <th>Nacionalidad</th><th>Email</th><th>Telefono</th></tr>
	 <%
	 if(listaAlumno !=null)
	 for(Alumno Alu : listaAlumno){
	 %>
	 <tr><td><%=Alu.getLegajo_Alumno() %></td> 	<td><%= Alu.getDni_Alumno() %></td>	 <td><%=Alu.getNombre_Alumno()%></td><td><%=Alu.getApellido_Alumno()%></td><td><%=Alu.getFechaNac_Alumno()%></td> <td><%=Alu.getDireccion_Alumno()%></td>
	 <td><%= Alu.getNacionalidad_Alumno() %></td><td><%=Alu.getEmail_Alumno()%></td><td><%=Alu.getTelefono_Alumno()%></td></tr>
	 
	 <%
	 }
	 %>
	</table>
	
	
</body>
</html>