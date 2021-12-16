package negocio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import daoImpl.ProfesorDaoImpl;
import daoImpl.ProfesorxCursoDaoImpl;
import entidades.Profesor;
import entidades.ProfesorxCurso;
import daoImpl.CursoDaoImpl;
import entidades.Curso;


public class ProfesorxCursoNeg {

	public ArrayList<Profesor> obtenerListaProfesores(){
		ProfesorDaoImpl ProfDao = new ProfesorDaoImpl();
		ArrayList<Profesor> lista = ProfDao.ListarProfesor();	
		return lista;
	}
	
	public Boolean AltaProfesorxCurso(String legajo, String Cod_Curso) {
			ProfesorxCurso ProfxCurs = new ProfesorxCurso();
			
			ProfxCurs.setCodCurso_pxc(Cod_Curso);
			ProfxCurs.setLegajoUsuario_pxc(legajo);
			
			ProfesorxCursoDaoImpl profxCursDaoimpl = new ProfesorxCursoDaoImpl();		
			
			return profxCursDaoimpl.AltaProfesorxCurso(ProfxCurs);
	}		
}
