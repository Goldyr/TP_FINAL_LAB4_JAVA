package daoImpl;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.AlumnoxCursoDao;
import entidades.Curso;
import entidades.Alumno;
import entidades.Notas;

public class AlumnoxCursoDaoImpl implements AlumnoxCursoDao{

	
	public boolean AltaAlumnoxCurso(Alumno alumno, Curso curso) {
		boolean resultado = false;
		
		Conexion conexion = new Conexion();
	
		try {
			
			CallableStatement cst = conexion.getSQLConexion().prepareCall("{call sp_altaCursosxAlumnos(?, ?)}");
			cst.setString(1, alumno.getLegajo_Alumno());
			cst.setString(2, curso.getCodCurso());
            System.out.println(cst.toString());
	
			int filas_afectadas = cst.executeUpdate();
            System.out.println("Filas afectadas: " + filas_afectadas);

			
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
	public boolean ExisteAlumnoxCurso(String legajo, String Codigo_Curso) {
		// TODO Auto-generated method stub
		return false;
	}
	

}