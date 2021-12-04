package entidades;
import java.util.Date;
public class Alumno {

	private String legajo_Alumno;
	private String dni_Alumno;
	private String nombre_Alumno;
	private String apellido_Alumno;
	private Date fechaNac_Alumno;
	private String direccion_Alumno;
	private String nacionalidad_Alumno;
	private String email_Alumno;
	private String telefono_Alumno;
	private boolean estado_Alumno;
	
	public Alumno(String legajo, String dni, String nombre, String apellido, Date fechaNac, String direcc, String nacionalidad, String email, String telefono, Boolean estado){
        legajo_Alumno=legajo;
        dni_Alumno=dni;
        nombre_Alumno=nombre;
        apellido_Alumno=apellido;
        fechaNac_Alumno=fechaNac;
        direccion_Alumno=direcc;
        nacionalidad_Alumno=nacionalidad;
        email_Alumno=email;
        telefono_Alumno=telefono;
        estado_Alumno=estado;
    }

	public Alumno() {;}

	public String getLegajo_Alumno() {
		return legajo_Alumno;
	}

	public void setLegajo_Alumno(String legajo_Alumno) {
		this.legajo_Alumno = legajo_Alumno;
	}

	public String getDni_Alumno() {
		return dni_Alumno;
	}

	public void setDni_Alumno(String dni_Alumno) {
		this.dni_Alumno = dni_Alumno;
	}

	public String getNombre_Alumno() {
		return nombre_Alumno;
	}

	public void setNombre_Alumno(String nombre_Alumno) {
		this.nombre_Alumno = nombre_Alumno;
	}

	public String getApellido_Alumno() {
		return apellido_Alumno;
	}

	public void setApellido_Alumno(String apellido_Alumno) {
		this.apellido_Alumno = apellido_Alumno;
	}

	public Date getFechaNac_Alumno() {
		return fechaNac_Alumno;
	}

	public void setFechaNac_Alumno(Date fechaNac_Alumno) {
		this.fechaNac_Alumno = fechaNac_Alumno;
	}

	public String getDireccion_Alumno() {
		return direccion_Alumno;
	}

	public void setDireccion_Alumno(String direccion_Alumno) {
		this.direccion_Alumno = direccion_Alumno;
	}

	public String getNacionalidad_Alumno() {
		return nacionalidad_Alumno;
	}

	public void setNacionalidad_Alumno(String nacionalidad_Alumno) {
		this.nacionalidad_Alumno = nacionalidad_Alumno;
	}

	public String getEmail_Alumno() {
		return email_Alumno;
	}

	public void setEmail_Alumno(String email_Alumno) {
		this.email_Alumno = email_Alumno;
	}

	public String getTelefono_Alumno() {
		return telefono_Alumno;
	}

	public void setTelefono_Alumno(String telefono_Alumno) {
		this.telefono_Alumno = telefono_Alumno;
	}

	public boolean isEstado_Alumno() {
		return estado_Alumno;
	}

	public void setEstado_Alumno(boolean estado_Alumno) {
		this.estado_Alumno = estado_Alumno;
	}
	
	
}
