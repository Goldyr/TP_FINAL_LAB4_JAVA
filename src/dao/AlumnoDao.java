package dao;

import java.util.List;
import entidades.Alumno;

public interface AlumnoDao {
	
	public List<Alumno> ListarAlumnos();
	public boolean EliminarAlumno(String legajo);
	public boolean AltaAlumno(Alumno alumno);
	public boolean ModificarAlumno(Alumno alumno);
	public boolean ExisteAlumno(String legajo);
}
