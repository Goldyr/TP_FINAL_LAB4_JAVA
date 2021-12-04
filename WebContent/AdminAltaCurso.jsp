<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alta Curso</title>
</head>
<body>
	<form action="Servlet_AdminAltaCurso" method="post">
		<h3>Alta Curso</h3>
		<p>Materia 				<input type="text" name="txtMateria"> </p>
		<p>Semestre 			<input type="text" name="txtSemestre"> </p>
		<p>Anio 				<input type="text" name="txtAnio"> </p>
	
		
		<input type="submit" name="btnAgregarCurso" value="Agregar Curso">
		
		<%
		if(request.getAttribute("CursoAlta")!=null){
			if((boolean)request.getAttribute("CursoAlta")){
				%>
				Se dio de alta correctamente	
				<%	
			}else{
				%>
				Error: No pudo darse de alta correctamente	
				<%
			}
		}
		%>
	</form>
</body>
</html>