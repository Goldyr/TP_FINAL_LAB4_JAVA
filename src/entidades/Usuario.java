package entidades;
import java.util.Date;

public class Usuario {

	private String legajo_Usuario;
	private String dni_Usuario;
	private String nombre_Usuario ;
	private String apellido_Usuario ;
	private String email_Usuario;
	private String telefono_Usuario;
	private boolean estado_Usuario;
	private boolean admin_Usuario;
	
	public Usuario(String legajo, String dni, String nombre, String apellido, String email, String telefono){
		legajo_Usuario = legajo;
		dni_Usuario = dni;
		nombre_Usuario = nombre;
		apellido_Usuario = apellido;
		email_Usuario = email;
		telefono_Usuario = telefono;
	}

	public String getLegajo_Usuario() {
		return legajo_Usuario;
	}

	public void setLegajo_Usuario(String legajo_Usuario) {
		this.legajo_Usuario = legajo_Usuario;
	}

	public String getDNI_Usuario() {
		return dni_Usuario;
	}

	public void setDNI_(String dni_Usuario) {
		this.dni_Usuario = dni_Usuario;
	}

	public String getNombre_Usuario() {
		return nombre_Usuario;
	}

	public void setNombre_Usuario(String nombre_Usuario) {
		this.nombre_Usuario = nombre_Usuario;
	}

	public String getApellido_Usuario() {
		return apellido_Usuario;
	}

	public void setApellido_Usuario(String apellido_Usuario) {
		this.apellido_Usuario = apellido_Usuario;
	}

	public String getEmail_Usuario() {
		return email_Usuario;
	}

	public void setEmail_Usuario(String email_Usuario) {
		this.email_Usuario = email_Usuario;
	}

	public String getTelefono_Usuario() {
		return telefono_Usuario;
	}

	public void setTelefono_Usuario(String telefono_Usuario) {
		this.telefono_Usuario = telefono_Usuario;
	}

	public boolean isEstado_Usuario() {
		return estado_Usuario;
	}

	public void setEstado_Usuario(boolean estado_Usuario) {
		this.estado_Usuario = estado_Usuario;
	}

	public boolean isAdmin_Usuario() {
		return admin_Usuario;
	}

	public void setAdmin_Usuario(boolean admin_Usuario) {
		this.admin_Usuario = admin_Usuario;
	}
	
	
}

