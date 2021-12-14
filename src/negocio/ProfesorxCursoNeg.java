package negocio;

import java.util.ArrayList;

import daoImpl.ProfesorDaoImpl;
import entidades.Profesor;
import daoImpl.CursoDaoImpl;
import entidades.Curso;


public class ProfesorxCursoNeg {

	public ArrayList<Profesor> obtenerListaProfesores(){
		ProfesorDaoImpl ProfDao = new ProfesorDaoImpl();
		ArrayList<Profesor> lista = ProfDao.ListarProfesor();

		return lista;
	}
}
