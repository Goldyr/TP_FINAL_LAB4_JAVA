package daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.UsuarioDao;
import entidades.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {

	
	private static String readall = "SELECT * FROM Usuarios where Estado_Usuario=1;";
	private static String userlogin = "SELECT * FROM Usuarios where Estado_Usuario=1 and Contraseņa_Usuario=? and Usuarios.Email_Usuario=?;";
	
	
	
	private Usuario getUsuario(ResultSet resultSet) throws SQLException
	{
		String Legajo = resultSet.getString("Legajo_Usuario");
		String Dni = resultSet.getString("DNI_Usuario");
		String Contraseņa = resultSet.getString("Contraseņa_Usuario");
		String Email = resultSet.getString("Email_Usuario");
		String Nombre = resultSet.getString("Nombre_Usuario");
		String Apellido = resultSet.getString("Apellido_Usuario");
		String Telefono = resultSet.getString("Telefono_Usuario");
		Boolean estado = resultSet.getBoolean("Estado_Usuario");
		Boolean Admin_Est = resultSet.getBoolean("Admin_Usuario");
		
		
		
		return new Usuario(Legajo, Dni, Nombre,Apellido, Email, Telefono, Contraseņa, estado, Admin_Est);
	}
	
	@Override
	public boolean AltaUsuario(Usuario user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean BajaUsuario(String legajo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Usuario ExisteUsuario(String Email, String Contraseņa) {
		PreparedStatement statement;
        ResultSet resultSet; //Guarda el resultado de la query
        Conexion conexion = new Conexion();
        Usuario User = new Usuario();

        try
        {
            statement = conexion.getSQLConexion().prepareStatement(userlogin);
            statement.setString(2, Email);
            statement.setString(1, Contraseņa);

            resultSet = statement.executeQuery();

           
           if(resultSet.next()) 
           {
        	   
        	   User = (getUsuario(resultSet));   
           }
           
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        
        return User;
	}

}
