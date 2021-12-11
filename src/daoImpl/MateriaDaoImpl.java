package daoImpl;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.MateriaDao;
import entidades.Alumno;
import entidades.Materia;

public class MateriaDaoImpl implements MateriaDao{

	String codigosql = "SELECT CodMateria_Materia, NombreMateria_Materia FROM Materias AS MAT " + 
			" INNER JOIN Cursos AS CUR ON MAT.CodMateria_Materia = CUR.CodMateria_Curso" + 
			" INNER JOIN CursosxUsuarios AS CURXU ON CURXU.CodCurso_CxU = CUR.CodCurso_Curso" + 
			" INNER JOIN Usuarios AS US ON CUR.Estado_Curso = 1  US.Legajo_Usuario = ";
	String showall = "SELECT CodMateria_Materia, NombreMateria_Materia FROM Materias;";
	@Override
	public boolean ExisteMateria(int codigo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Materia> ListarMaterias(String legajo) {
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<Materia> ListadoMateria = new ArrayList<Materia>();
		Conexion conexion = new Conexion();
		try 
		{

			statement = conexion.getSQLConexion().prepareStatement(codigosql + "'" + legajo + "';");// codigo ' numeroslegajo ';
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				ListadoMateria.add(getMateria(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return ListadoMateria;

	}
	
	private Materia getMateria(ResultSet resultSet) throws SQLException
	{


		String CodigoMat = resultSet.getString("CodMateria_Materia");
		String NombreMat = resultSet.getString("NombreMateria_Materia");
		

		return new Materia(CodigoMat, NombreMat);	
	}
	
	public ArrayList<Materia> ListarTodas()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<Materia> ListadoMateria = new ArrayList<Materia>();
		
		Conexion conexion = new Conexion();
		try 
		{

			statement = conexion.getSQLConexion().prepareStatement(showall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				ListadoMateria.add(getMateria(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return ListadoMateria;
	}

}