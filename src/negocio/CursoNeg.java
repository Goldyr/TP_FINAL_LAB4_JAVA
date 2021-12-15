package negocio;

import java.util.ArrayList;

import daoImpl.CursoDaoImpl;
import entidades.Curso;

public class CursoNeg {

	public ArrayList<Curso> obtenerCurso(){
		CursoDaoImpl CursoDao = new CursoDaoImpl();
		ArrayList<Curso> lista = CursoDao.ListarCursos();
		return lista;
	}
	
	public ArrayList<Curso> CursosObtener(String Legajo){
		CursoDaoImpl CursoDao = new CursoDaoImpl();
		ArrayList<Curso> lista = CursoDao.ListarCursosxProfesor(Legajo);
		return lista;
	}
	
	public ArrayList<Curso> obtenerCursos_noProfesor(String Legajo){
		CursoDaoImpl CursoDao = new CursoDaoImpl();
		ArrayList<Curso> lista = CursoDao.ListarCursos_noProfesor(Legajo);
		return lista;
	}
	
	public Boolean Altacurso(String materia, String semestre, String anio) {
		Curso curs= new Curso();
		CursoDaoImpl cursDao= new CursoDaoImpl();
		
		curs.setCodMateria(materia);
		curs.setSemestre_Curso(semestre);
		curs.setAnio_Curso(anio);
		
		return cursDao.AltaCurso(curs);
	}

	public ArrayList<Curso> obtenerCursosDeMateriaxProfesor(String Legajo, String CodMateria){
		CursoDaoImpl CursoDao = new CursoDaoImpl();
		return CursoDao.ListarCursosxProfesorxMateria(Legajo, CodMateria);
		
	}
	
	public ArrayList<Curso> CursosObtener_Alumno(String Legajo){
        CursoDaoImpl CursoDao = new CursoDaoImpl();
        ArrayList<Curso> lista = CursoDao.ListarCursosxAlumno(Legajo);
        return lista;
    }

    public ArrayList<Curso> obtenerCursos_noAlumno(String Legajo){
        CursoDaoImpl CursoDao = new CursoDaoImpl();
        ArrayList<Curso> lista = CursoDao.ListarCursos_noAlumno(Legajo);
        return lista;
    }
	
}
