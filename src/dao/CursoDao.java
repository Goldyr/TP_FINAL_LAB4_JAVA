package dao;

import java.util.ArrayList;

import entidades.Alumno;
import entidades.Curso;

public interface CursoDao {

	public boolean AltaCurso(Curso alumno);
	public ArrayList<Curso> ListarCursos();
	public ArrayList<Curso> ListarCursosxProfesor(String legajo);
	public ArrayList<Curso> ListarCursosxProfesorxMateria(String legajo, String CodMateria);
	public boolean EliminarCurso(String legajo);
	public boolean ModificarCurso(Alumno alumno);
	public boolean ExisteCurso(String legajo);
	public ArrayList<Curso> ListarCursosxAlumno(String legajo);
    public ArrayList<Curso> ListarCursos_noAlumno(String legajo);
}
