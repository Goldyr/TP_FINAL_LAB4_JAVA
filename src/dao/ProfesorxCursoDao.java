package dao;

import java.util.ArrayList;

import entidades.Curso;
import entidades.Profesor;

public interface ProfesorxCursoDao {
	
	public boolean AltaProfesorxCurso(Profesor profesor, Curso curso);
    public boolean ExisteProfesorxCurso(String legajo, String Codigo_Curso);
    
	
}
