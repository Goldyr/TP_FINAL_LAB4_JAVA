package negocio;

import java.util.ArrayList;


import daoImpl.MateriaDaoImpl;
import entidades.Materia;

public class MateriaNeg {

	public ArrayList<Materia> TraerListadoMateria(String legajo)
	{
		MateriaDaoImpl matImpl = new MateriaDaoImpl();
		return matImpl.ListarMaterias(legajo);
	
	}
	
}