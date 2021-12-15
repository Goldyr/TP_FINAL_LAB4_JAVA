package dao;

import entidades.Curso;
import entidades.Notas;
import entidades.Alumno;

public interface AlumnoxCursoDao {
	
	public boolean AltaAlumnoxCurso(Alumno alumno, Curso curso);
    public boolean ExisteAlumnoxCurso(String legajo, String Codigo_Curso);

}