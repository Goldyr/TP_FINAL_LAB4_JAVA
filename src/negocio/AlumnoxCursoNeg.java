package negocio;

import java.util.ArrayList;

import daoImpl.AlumnoDaoImpl;
import daoImpl.AlumnoxCursoDaoImpl;
import entidades.Alumno;
import daoImpl.CursoDaoImpl;
import entidades.Curso;

public class AlumnoxCursoNeg {
	
	public ArrayList<Alumno> obtenerListaAlumno(){
		AlumnoDaoImpl AlumDao = new AlumnoDaoImpl();
		ArrayList<Alumno> lista = AlumDao.ListarAlumnos();

		return lista;
	}
	
	public Boolean AltaAlumnoxCurso(String LegajoAlu, String Codcurso) {
		Alumno alu = new Alumno();
		Curso cur = new Curso();
		
		alu.setLegajo_Alumno(LegajoAlu);
		cur.setCodCurso(Codcurso);
		
		AlumnoxCursoDaoImpl AluxCurso = new AlumnoxCursoDaoImpl();
		return AluxCurso.AltaAlumnoxCurso(alu, cur);
		
		}

}