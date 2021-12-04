package daoImpl;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import dao.CursoDao;
import entidades.Alumno;
import entidades.Curso;
import entidades.Materia;

public class CursoDaoImpl implements CursoDao {

	
	private static final String readall = "SELECT * FROM cursos;";
	
	@Override
	public boolean AltaCurso(Curso alumno) {
		boolean resultado = false;
		
		Conexion conexion = new Conexion();
	
		try {
			
			CallableStatement cst = conexion.getSQLConexion().prepareCall("{call sp_AltaCursos(?, ?, ?)}");
			cst.setString(1, alumno.getCodMateria());
			cst.setString(2, alumno.getAnio_Curso());
			cst.setString(3, alumno.getSemestre_Curso());
				
			int filas_afectadas = cst.executeUpdate();
			
			resultado = true;
			if(filas_afectadas==1) {
				conexion.getSQLConexion().commit();
			}else {
				conexion.getSQLConexion().rollback();
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			try {
				conexion.getSQLConexion().rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}	
		}
		return resultado;
	}

	@Override
	public ArrayList<Curso> ListarCursos() {

		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<Curso> ListarCursos = new ArrayList<Curso>();
		Conexion conexion = new Conexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				ListarCursos.add(getCurso(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return ListarCursos;

	}
	
	private Curso getCurso(ResultSet resultSet) throws SQLException
	{
		
		
		String codCurso = resultSet.getString("CodCurso_Curso");
		String materia=resultSet.getString("CodMateria_Curso");
		String semestre_Curso = resultSet.getString("Semestre_Curso");
		String anio_Curso = resultSet.getString("Año_Curso");
		Boolean estado = resultSet.getBoolean("Estado_Curso");


	
	
		return new Curso(codCurso , materia, semestre_Curso, anio_Curso, estado);
	}

	@Override
	public boolean EliminarCurso(String legajo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ModificarCurso(Alumno alumno) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ExisteCurso(String legajo) {
		// TODO Auto-generated method stub
		return false;
	}

}
