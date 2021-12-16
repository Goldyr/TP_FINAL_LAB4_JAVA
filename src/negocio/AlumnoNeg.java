package negocio;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;



import daoImpl.AlumnoDaoImpl;
import daoImpl.Conexion;
import entidades.Alumno;

public class AlumnoNeg {

	public Boolean guardarEdicionAlumno(String legajo, String dni, String nombre, String apellido,String fecha ,String direccion, String nacionalidad, String provincia,String email ,String telefono) 
	{
		AlumnoDaoImpl adao = new AlumnoDaoImpl();
		Alumno alumno = new Alumno();
	
		alumno = adao.obtenerAlumno(legajo);
		
		if(alumno != null) {
			//System.out.println(legajo);
			alumno.setDni_Alumno(dni);
			alumno.setNombre_Alumno(nombre);
			alumno.setApellido_Alumno(apellido);
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String stringFechaNacimiento = fecha;
			Date date;
			
			try {
				
				date = formatter.parse(stringFechaNacimiento);
				//formatter.format(date);
				alumno.setFechaNac_Alumno(date);
				
			} catch (ParseException e) {
					e.printStackTrace();
			}
			
			
			alumno.setDireccion_Alumno(direccion);
			alumno.setNacionalidad_Alumno(nacionalidad);
			alumno.setProvincia_Alumno(provincia);
			alumno.setEmail_Alumno(email);
			alumno.setTelefono_Alumno(telefono);
			
			// ------------
			
			if(adao.ModificarAlumno(alumno)) {
				
				System.out.println("Modificado correctamente");
				return true;
			}
			

		}
		return false;
	}
	
	public Boolean AltaAlumno(String nombre, String apellido, String dni, String fecha, String direccion, String nacionnalidad, String provincia, String email, String telefono) {
		Alumno alum = new Alumno();
		AlumnoDaoImpl alumDao = new AlumnoDaoImpl();
		
		alum.setNombre_Alumno(nombre);
		alum.setApellido_Alumno(apellido);
		alum.setDni_Alumno(dni);
		
		//alum.setFechaNac_Alumno(fecha);
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String stringFechaNacimiento = fecha;
		Date date;
		
		try {
			
			date = formatter.parse(stringFechaNacimiento);
			//formatter.format(date);
			alum.setFechaNac_Alumno(date);
			
		} catch (ParseException e) {
				e.printStackTrace();
		}
		
		alum.setDireccion_Alumno(direccion);
		alum.setNacionalidad_Alumno(nacionnalidad);
		alum.setProvincia_Alumno(provincia);
		alum.setEmail_Alumno(email);
		alum.setTelefono_Alumno(telefono);
		

		return alumDao.AltaAlumno(alum);
	}
	
	public ArrayList<Alumno> obtenerListaAlumnos()
	{
		AlumnoDaoImpl alumDao = new AlumnoDaoImpl();
		ArrayList<Alumno> lista = alumDao.ListarAlumnos();
		 
		return lista;
	}
	
	public Alumno obtenerAlumno(String legajo) {
		AlumnoDaoImpl alumDao = new AlumnoDaoImpl();
		return alumDao.obtenerAlumno(legajo);
	}
	


	public Boolean eliminarAlumno(String legajo) {
		AlumnoDaoImpl alumDao = new AlumnoDaoImpl();
		return alumDao.EliminarAlumno(legajo);
	}
}
