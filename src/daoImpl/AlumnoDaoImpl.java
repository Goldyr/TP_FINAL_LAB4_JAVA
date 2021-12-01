package daoImpl;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;


import dao.AlumnoDao;
import entidades.Alumno;




public class AlumnoDaoImpl implements AlumnoDao{
	
	private static final String readall = "SELECT * FROM alumnos;";
	
	@Override
	
	public ArrayList<Alumno> ListarAlumnos() {

		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<Alumno> ListarAlumnos = new ArrayList<Alumno>();
		Conexion conexion = Conexion.getConexion();
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ExisteAlumno(String legajo) {
		// TODO Auto-generated method stub
		return false;
	}

}
