package dao;

import java.util.ArrayList;

import entidades.Curso;
import entidades.Profesor;
import entidades.ProfesorxCurso;

public interface ProfesorxCursoDao {
	
	public boolean AltaProfesorxCurso(ProfesorxCurso pxc);
    public boolean ExisteProfesorxCurso(String legajo, String Codigo_Curso);
    
	
}