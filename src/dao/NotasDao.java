package dao;

import entidades.Notas;
import java.util.ArrayList;

public interface NotasDao {

	public boolean AltaNotas(Notas notas);
	public boolean ModificarNotar(Notas notas);
	public ArrayList<Notas> ListarNotas(String legajoProfesor, String codMateria);
	public Notas obtenerNotas(String codNotas);
}
