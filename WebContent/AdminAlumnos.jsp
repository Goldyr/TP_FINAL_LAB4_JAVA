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
    $('#tablaAlumnos').DataTable();
} );
</script>

</head>
<body>

	<h3>Listado Alumnos</h3>
	<a href="AdminAltaAlumno.jsp">Alta Alumno</a>
	
	<form method="post" action="Servlet_Alumnos">
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
	
	<table border="1" class="display" id="tablaAlumnos">
		<thead>
		<tr class="table-danger" scope="row">
			<td> </td>
			<td> </td>
			<th>Legajo</th>
			<th>DNI</th>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Fecha Nac</th>
			<th>Direccion</th>
	 		<th>Nacionalidad</th>
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
	 		<td><input type="submit" name="btnEditar" value="Editar" class="btn btn-warning"/></td>
			<td><input type="submit" name="btnEliminar" value="Eliminar" class="btn btn-danger"/></td>	
	 		<td><%=Alu.getLegajo_Alumno() %> <input type="hidden" name="legajoAlumno" value="<%=Alu.getLegajo_Alumno()%>"> </td> 	
	 		<td><%= Alu.getDni_Alumno() %></td>	 
	 		<td><%=Alu.getNombre_Alumno()%></td>
	 		<td><%=Alu.getApellido_Alumno()%></td>
	 		<td><%=Alu.getFechaNac_Alumno()%></td> 
	 		<td><%=Alu.getDireccion_Alumno()%></td>
	 		<td><%= Alu.getNacionalidad_Alumno() %></td>
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
	 			<td><input type="text" required name="emailAlumno" value="<%= alumnoEditable.getEmail_Alumno()%>"></td>
	 			<td><input type="text" required name="telefonoAlumno" value="<%= alumnoEditable.getTelefono_Alumno()%>"></td>
	 		</form>	
	 </tr>

	 <%
		 	}
		}
	 %>
	</table>
	
	
</body>
</html>