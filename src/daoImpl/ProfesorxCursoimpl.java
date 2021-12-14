package daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.ProfesorxCursoDao;
import entidades.Curso;
import entidades.Profesor;

public class ProfesorxCursoimpl implements ProfesorxCursoDao {

	String readall = "SELECT CUR.Semestre_Curso, NombreMateria_Materia, US.Nombre_Usuario FROM Materias AS MAT" + 
					" INNER JOIN Cursos AS CUR ON MAT.CodMateria_Materia = CUR.CodMateria_Curso" + 
					" INNER JOIN CursosxUsuarios AS CURXU ON CURXU.CodCurso_CxU = CUR.CodCurso_Curso" + 
					" INNER JOIN Usuarios AS US WHERE CUR.Estado_Curso = 1 AND US.Legajo_Usuario = ";
	
	@Override
	public boolean AltaProfesorxCurso(Profesor profesor, Curso curso) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ExisteProfesorxCurso(String legajo, String Codigo_Curso) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
