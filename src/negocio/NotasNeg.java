package negocio;

import java.util.ArrayList;

import daoImpl.NotasDaoImpl;
import entidades.Notas;

public class NotasNeg {

	public ArrayList<Notas> obtenerNotasxCursoAlumnos(String legajoProfesor, String codigoMateria) {
		NotasDaoImpl ndao = new NotasDaoImpl();
		return ndao.ListarNotas(legajoProfesor, codigoMateria);
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
		System.out.println(notas.toString());

		return ndao.ModificarNotar(notas);
	}
}