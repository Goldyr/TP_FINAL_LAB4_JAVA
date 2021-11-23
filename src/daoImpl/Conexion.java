package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "bd_sist_educativo";
	
	private Connection connection;
	public static Conexion instancia;
	
	public Conexion() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		connection = null;
		try {
			connection = DriverManager.getConnection(host+dbName+"?useSSL=false&allowPublicKeyRetrieval=true", user, pass);
			connection.setAutoCommit(false);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static Conexion getConexion()   
	{								
		if(instancia == null)
		{
			instancia = new Conexion();
		}
		return instancia;
	}

	public Connection getSQLConexion() 
	{
		return this.connection;
	}
	
	public void cerrarConexion()
	{
		try 
		{
			this.connection.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		instancia = null;
	}
}


