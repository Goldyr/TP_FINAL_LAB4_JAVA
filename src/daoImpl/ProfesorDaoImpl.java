package daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import dao.ProfesorDao;
import entidades.Alumno;
import entidades.Profesor;

public class ProfesorDaoImpl implements ProfesorDao{

	private static final String readall = "SELECT * FROM Usuarios WHERE Admin_Usuario=0 and Estado_Usuario=1;";
	
	@Override
	public ArrayList<Profesor> ListarProfesor() {
		
		PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<Profesor> ListarProfesores = new ArrayList<Profesor>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			
			while(resultSet.next() == true) {
				ListarProfesores.add(getProfesor(resultSet));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return ListarProfesores;
	}
	
	private Profesor getProfesor(ResultSet resultSet) throws SQLException
	{
		String legajo = resultSet.getString("Legajo_Usuario");
		String dni = resultSet.getString("DNI_Usuario");
		String nombre = resultSet.getString("Nombre_Usuario");
		String apellido = resultSet.getString("Apellido_Usuario");
		String email = resultSet.getString("Email_Usuario");
		String telefono = resultSet.getString("Telefono_Usuario");
		String Contraseña = resultSet.getString("Contraseña_Usuario");
		String localidad = resultSet.getString("Localidad_Usuario");
		String direccion = resultSet.getString("Direccion_Usuario");
		String nacionalidad = resultSet.getString("Nacionalidad_Usuario");
		Boolean Admin_Est = resultSet.getBoolean("Admin_Usuario");
		Date fecha_nac = resultSet.getDate("FechaNac_Usuario");

		return new Profesor(legajo,dni,nombre,apellido,email,telefono,Contraseña,localidad, direccion, nacionalidad, fecha_nac, Admin_Est);
	}

	@Override
	public boolean EliminarProfesor(String legajo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean AltaProfesor(Profesor profesor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ModificarProfesor(Profesor profesor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ExisteProfesor(String legajo) {
		// TODO Auto-generated method stub
		return false;
	}

}
