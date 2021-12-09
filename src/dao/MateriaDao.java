package dao;

import entidades.Materia;
import java.util.List;

public interface MateriaDao {

	public boolean ExisteMateria(int codigo);
	public List<Materia> ListarMaterias(String legajo);
}