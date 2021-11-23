package entidades;
import java.util.Date;

public class Usuario {

	private String legajo_Usuario;
	private String dni_Usuario;
	private String nombre_Usuario ;
	private String apellido_Usuario ;
	private Date fechaNac_Usuario;
	private String direccion_Usuario;
	private String localidad_Usuario;
	private String nacionalidad_Usuario;
	private String email_Usuario;
	private String telefono_Usuario;
	private boolean estado_Usuario;
	private boolean admin_Usuario;
	
	public Usuario() {}

	public String getLegajo_Usuario() {
		return legajo_Usuario;
	}

	public void setLegajo_Usuario(String legajo_Usuario) {
		this.legajo_Usuario = legajo_Usuario;
	}

	public String getDNI_() {
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

	public Date getFechaNac_Usuario() {
		return fechaNac_Usuario;
	}

	public void setFechaNac_Usuario(Date fechaNac_Usuario) {
		this.fechaNac_Usuario = fechaNac_Usuario;
	}

	public String getDireccion_Usuario() {
		return direccion_Usuario;
	}

	public void setDireccion_Usuario(String direccion_Usuario) {
		this.direccion_Usuario = direccion_Usuario;
	}

	public String getLocalidad_Usuario() {
		return localidad_Usuario;
	}

	public void setLocalidad_Usuario(String localidad_Usuario) {
		this.localidad_Usuario = localidad_Usuario;
	}

	public String getNacionalidad_Usuario() {
		return nacionalidad_Usuario;
	}

	public void setNacionalidad_Usuario(String nacionalidad_Usuario) {
		this.nacionalidad_Usuario = nacionalidad_Usuario;
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
