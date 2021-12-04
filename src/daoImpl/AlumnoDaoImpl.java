package daoImpl;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.mysql.jdbc.exceptions.jdbc4.MySQLTransactionRollbackException;

import dao.AlumnoDao;
import entidades.Alumno;
import entidades.Profesor;




public class AlumnoDaoImpl implements AlumnoDao{
	
	private static final String readall = "SELECT * FROM alumnos WHERE Estado_Alumno = 1;";
	
	@Override
	
	public ArrayList<Alumno> ListarAlumnos() {

		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<Alumno> ListarAlumnos = new ArrayList<Alumno>();
		Conexion conexion = new Conexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				ListarAlumnos.add(getAlumno(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return ListarAlumnos;
	}

	private Alumno getAlumno(ResultSet resultSet) throws SQLException
	{
		String Legajo = resultSet.getString("Legajo_Alumno");
		String DNI = resultSet.getString("DNI_Alumno");
		String nombre = resultSet.getString("Nombre_Alumno");
		String apellido = resultSet.getString("Apellido_Alumno");
		Date fecha_nac = resultSet.getDate("FechaNac_Alumno");
		String direccion = resultSet.getString("Direccion_Alumno");
		String nacionalidad = resultSet.getString("Nacionalidad_Alumno");
		String email = resultSet.getString("Email_Alumno");
		String telefono = resultSet.getString("Telefono_Alumno");
		Boolean estado = resultSet.getBoolean("Estado_Alumno");

		return new Alumno(Legajo, DNI, nombre, apellido, fecha_nac, direccion, nacionalidad, email, telefono, estado);	
	}
	
	@Override
	public boolean EliminarAlumno(String legajo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean AltaAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ModificarAlumno(Alumno alumno) {
		
		boolean resultado = false;
		
		
		Conexion conexion = new Conexion();
		
		try {
			conexion.getSQLConexion().setAutoCommit(false);
			CallableStatement cst = conexion.getSQLConexion().prepareCall("call sp_modificarAlumno(?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			cst.setString(1, alumno.getDni_Alumno());
			cst.setString(2, alumno.getNombre_Alumno());
			cst.setString(3, alumno.getApellido_Alumno());
			
			java.sql.Date sqlDate = new java.sql.Date(alumno.getFechaNac_Alumno().getTime());
			
			cst.setDate(4, sqlDate);
			cst.setString(5, alumno.getDireccion_Alumno());
			cst.setString(6, alumno.getNacionalidad_Alumno());
			cst.setString(7, alumno.getEmail_Alumno());
			cst.setString(8, alumno.getTelefono_Alumno());
			cst.setString(9, alumno.getLegajo_Alumno());
			
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
	public boolean ExisteAlumno(String legajo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Alumno obtenerAlumno(String legajo) {
	
		PreparedStatement statement;
		ResultSet resultSet;
		Conexion conexion = new Conexion();
		
		String consulta = "SELECT * FROM Alumnos WHERE Legajo_Alumno = '" + legajo + "';";
		
		Alumno alumno = new Alumno();
		
		try {
			statement = conexion.getSQLConexion().prepareStatement(consulta);
			resultSet = statement.executeQuery();
			
			if(resultSet.next() == true) {
				alumno = getAlumno(resultSet);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return alumno;
	}

}
