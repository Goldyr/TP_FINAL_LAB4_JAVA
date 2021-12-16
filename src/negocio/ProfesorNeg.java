package negocio;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.ProfesorDaoImpl;
import entidades.Profesor;
public class ProfesorNeg {

	
	public ArrayList<Profesor> obtenerListaProfesores(){
		ProfesorDaoImpl ProfDao = new ProfesorDaoImpl();
		ArrayList<Profesor> lista = ProfDao.ListarProfesor();

		return lista;
	}
	
	public Profesor obtenerProfesor(String legajo) {
		ProfesorDaoImpl profDao = new ProfesorDaoImpl();
		return profDao.ObtenerProfesor(legajo);
	}
	
	
	
	
	public Boolean guardarEdicionProfesor(String legajo, String dni, String nombre, String apellido, String fecha, String direccion, String localidad, String nacionalidad, String email, String constrase�a, String telefono){
		
		ProfesorDaoImpl udao = new ProfesorDaoImpl();
		Profesor profesor = new Profesor();
	
		profesor = udao.ObtenerProfesor(legajo);
		
		if(profesor != null) {
			
			profesor.setDNI_Usuario(dni);
			profesor.setNombre_Usuario(nombre);
			profesor.setApellido_Usuario(apellido);
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String stringFechaNacimiento = fecha;
			Date date;
			
			try {
				
				date = formatter.parse(stringFechaNacimiento);
				//formatter.format(date);
				profesor.setFechaNac_Profesor(date);
				
			} catch (ParseException e) {
					e.printStackTrace();
			}
			
			profesor.setDireccion_Profesor(direccion);
			profesor.setLocalidad_Profesor(localidad);
			profesor.setNacionalidad_Profesor(nacionalidad);
			profesor.setEmail_Usuario(email);
			profesor.setContrase�a_Usuario(constrase�a);
			profesor.setTelefono_Usuario(telefono);
			
			// ------------
			
			if(udao.ModificarProfesor(profesor)) {

				System.out.println("Modificado correctamente");
				return true;
			}

		}
		return false;
	}
	
	public Boolean AltaProfesor(String dni, String nombre, String apellido, String fecha, String direccion, String localidad, String nacionalidad, String email, String contrase�a, String repcontrase�a, String telefono) {
		Profesor prof = new Profesor();
		ProfesorDaoImpl profDaoimpl = new ProfesorDaoImpl();

		if(repcontrase�a.compareTo(contrase�a)!=0){
			System.out.println(repcontrase�a);
			System.out.println("error");
			System.out.println(contrase�a);
			return false;
		}else {
			prof.setDNI_Usuario(dni);
			prof.setNombre_Usuario(nombre);
			prof.setApellido_Usuario(apellido);
			prof.setContrase�a_Usuario(contrase�a);
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String stringFechaNacimiento = fecha;
			Date date;
			
			try {
				
				date = formatter.parse(stringFechaNacimiento);
				//formatter.format(date);
				prof.setFechaNac_Profesor(date);
				
			} catch (ParseException e) {
					e.printStackTrace();
			}
			
			prof.setDireccion_Profesor(direccion);
			prof.setNacionalidad_Profesor(nacionalidad);
			prof.setLocalidad_Profesor(localidad);
			prof.setEmail_Usuario(email);
			prof.setTelefono_Usuario(telefono);
			

			return profDaoimpl.AltaProfesor(prof);
		
		}
	}
	
	public Boolean existeProfesor(String dni, String email) {
        ProfesorDaoImpl profDaoimpl = new ProfesorDaoImpl();
        return profDaoimpl.ExisteProfesor(dni, email);

    }
	
	public Boolean eliminarProfesor(String legajo) {
		ProfesorDaoImpl profDao = new ProfesorDaoImpl();
		return profDao.EliminarProfesor(legajo);
	}
	


	
}
