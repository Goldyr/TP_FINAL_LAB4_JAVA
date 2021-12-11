package daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
		Conexion conexion = new Conexion();
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
		Boolean estad = resultSet.getBoolean("Estado_Usuario");
		Date fecha_nac = resultSet.getDate("FechaNac_Usuario");

		return new Profesor(legajo,dni,nombre,apellido,email,telefono,Contraseña,localidad, direccion, nacionalidad, fecha_nac, Admin_Est, estad);
	}

	@Override
	public boolean EliminarProfesor(String legajo) {
		
		boolean resultado = false;
		Conexion conexion = new Conexion();

		try {

			CallableStatement cst = conexion.getSQLConexion().prepareCall("{call sp_bajaUsuario(?)}");
			cst.setString(1, legajo);

			int filas_afectadas = cst.executeUpdate();

			if(filas_afectadas==1) {
				conexion.getSQLConexion().commit();
				resultado = true;
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
    public boolean AltaProfesor(Profesor profesor) {
        boolean resultado = false;

        Conexion cn = new Conexion(); 

        try {
            CallableStatement cst = cn.getSQLConexion().prepareCall("CALL sp_altaProfesor(?, ?, ?, ?, ?, ?, ?, ?, ?,?)");

            cst.setString(1, profesor.getDNI_Usuario());
            cst.setString(2, profesor.getNombre_Usuario());
            cst.setString(3, profesor.getApellido_Usuario());

            java.sql.Date sqlDate = new java.sql.Date(profesor.getFechaNac_Profesor().getTime());
            //java.sql.Date sqlDate = new java.sql.Date(1999-8-18);
            cst.setDate(4, sqlDate);

            cst.setString(5, profesor.getDireccion_Profesor());
            cst.setString(6, profesor.getLocalidad_Profesor());
            cst.setString(7, profesor.getNacionalidad_Profesor());
            cst.setString(8, profesor.getEmail_Usuario());
            cst.setString(9, profesor.getContraseña_Usuario());
            cst.setString(10, profesor.getTelefono_Usuario());


            System.out.println(cst.toString());
            int filas_afectadas = cst.executeUpdate();
            System.out.println("Filas afectadas: " + filas_afectadas);

            resultado = true;
            if(filas_afectadas==1) {
                cn.getSQLConexion().commit();
            }else {
                cn.getSQLConexion().rollback();
            }

        }catch(SQLException e) {
            e.printStackTrace();
            try {
                cn.getSQLConexion().rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

        return resultado;
    }

	@Override
	public boolean ModificarProfesor(Profesor profesor) {
		
		boolean resultado = false;
		
		Conexion conexion = new Conexion();
	
		try {
			
			
			CallableStatement cst = conexion.getSQLConexion().prepareCall("{call sp_ModificarUsuario(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
			cst.setString(1, profesor.getLegajo_Usuario());
			cst.setString(2, profesor.getDNI_Usuario());
			cst.setString(3, profesor.getNombre_Usuario());
			cst.setString(4, profesor.getApellido_Usuario());
			
			java.sql.Date sqlDate = new java.sql.Date(profesor.getFechaNac_Profesor().getTime());
		
			cst.setDate(5, sqlDate);
			cst.setString(6, profesor.getDireccion_Profesor());
			cst.setString(7, profesor.getLocalidad_Profesor());
			cst.setString(8, profesor.getNacionalidad_Profesor());
			cst.setString(9, profesor.getEmail_Usuario());
			cst.setString(10, profesor.getContraseña_Usuario());
			cst.setString(11, profesor.getTelefono_Usuario());
			
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
	public boolean ExisteProfesor(String legajo) {
		// TODO Auto-generated method stub
		return false;
	}

	
	@Override
	public Profesor ObtenerProfesor(String legajo)
	{
		PreparedStatement statement;
		ResultSet resultSet;
		Conexion conexion = new Conexion();
		
		String consulta = "SELECT * FROM Usuarios WHERE Legajo_Usuario = '" + legajo + "';";
		
		Profesor _profesor = new Profesor();
		
		try {
			statement = conexion.getSQLConexion().prepareStatement(consulta);
			resultSet = statement.executeQuery();
			
			if(resultSet.next() == true) {
				_profesor = getProfesor(resultSet);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return _profesor;
	}
}
