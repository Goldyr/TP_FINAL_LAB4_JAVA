package dao;

import java.util.ArrayList;

import entidades.Profesor;

public interface ProfesorDao {

    ///Profesor se refiere a los Usuario con el campo Admin en 0
    public ArrayList<Profesor> ListarProfesor();
    public boolean EliminarProfesor(String legajo);
    public boolean AltaProfesor(Profesor profesor);
    public boolean ModificarProfesor(Profesor profesor);
    public boolean ExisteProfesor(String Dni ,String Email);
    public Profesor ObtenerProfesor(String legajo);

}