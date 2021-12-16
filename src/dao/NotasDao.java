package dao;

import entidades.Notas;
import java.util.ArrayList;

public interface NotasDao {

	public boolean AltaNotas(Notas notas);
	public boolean ModificarNota(Notas notas);
	public ArrayList<Notas> ListarNotas(String legajoProfesor, String codMateria);
	public ArrayList<Notas> ListarNotasFiltradas(String legajoProfesor, String codMateria, String Semestre);
	public boolean ModificarNotasMasivamente(ArrayList<Notas> arrNotas);
	public boolean ModificarNotaxCurso(Notas notas);
	public Notas obtenerNotas(String codNotas);
}
