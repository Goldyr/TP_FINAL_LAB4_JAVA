package negocio;

import java.util.ArrayList;

import daoImpl.NotasDaoImpl;
import entidades.Curso;
import entidades.Notas;

public class NotasNeg {

	public ArrayList<Notas> obtenerNotasxCursoAlumnos(String legajoProfesor, String codigoMateria) {
		NotasDaoImpl ndao = new NotasDaoImpl();
		return ndao.ListarNotas(legajoProfesor, codigoMateria);
	}
	public ArrayList<Notas> obtenerNotasFiltrado(String legajoProfesor, String codMateria, String semestre) {
		NotasDaoImpl ndao = new NotasDaoImpl();
		
		return ndao.ListarNotasFiltradas(legajoProfesor, codMateria, semestre);
	}
	public Notas obtenerNotas(String CodNotas) {
		NotasDaoImpl ndao = new NotasDaoImpl();
		return ndao.obtenerNotas(CodNotas);
	}

	public Boolean guardarEdicionNotas(String CodNotas, float parcial1, float parcial2, float recup1, float recup2)
	{
		NotasDaoImpl ndao = new NotasDaoImpl();
		Notas notas = new Notas();

		notas.setCodNotas_Nota(CodNotas);
		notas.setParcial_1_Nota(parcial1);
		notas.setParcial_2_Nota(parcial2);
		notas.setRecuperatorio_1_Nota(recup1);
		notas.setRecuperatorio_2_Nota(recup2);
		
		//System.out.println(notas.toString());

		return ndao.ModificarNota(notas);
	}
	
	public Boolean modificarNotasMasivamente(String[] legajos, String CodCurso, float p1, float p2, float rec1, float rec2)
	{
		NotasDaoImpl ndaoImpl = new NotasDaoImpl();
		ArrayList<Notas> arrNotas = new ArrayList<Notas>();
		
		for(String strLegajo : legajos)
		{
			Notas tmpNotas = new Notas();
			Curso tmpCurso = new Curso();
			
			tmpNotas.getAlumno_Nota().setLegajo_Alumno(strLegajo);
			
			tmpCurso.setCodCurso(CodCurso);
			tmpNotas.setCurso_Nota(tmpCurso);
			
			tmpNotas.setParcial_1_Nota(p1);
			tmpNotas.setParcial_2_Nota(p2);
			tmpNotas.setRecuperatorio_1_Nota(rec1);
			tmpNotas.setRecuperatorio_2_Nota(rec2);
			

			arrNotas.add(tmpNotas);
		}
		
		return ndaoImpl.ModificarNotasMasivamente(arrNotas);
	}
}