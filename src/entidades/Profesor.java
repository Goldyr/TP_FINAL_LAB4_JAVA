package entidades;

import java.util.Date;

public class Profesor extends Usuario{
	
	private String Localidad_Profesor;
	private String Direccion_Profesor;
	private String Nacionalidad_Profesor;
	private Date FechaNac_Profesor;
	
	
	public Profesor(String legajo, String dni, String nombre, String apellido, String email, String telefono, String Contraseņa,String localidad, String direcc, String nacionalidad, Date fechaNac, boolean Admin, boolean estado){
        super(legajo, dni, nombre, apellido, email, telefono, Contraseņa , Admin, estado);
		Localidad_Profesor=localidad;
        Direccion_Profesor=direcc;
        Nacionalidad_Profesor=nacionalidad;
        FechaNac_Profesor=fechaNac;
    }

	public Profesor() {
		// TODO Auto-generated constructor stub
		super();
	}


	public String getLocalidad_Profesor() {
		return Localidad_Profesor;
	}


	public void setLocalidad_Profesor(String localidad_Profesor) {
		Localidad_Profesor = localidad_Profesor;
	}


	public String getDireccion_Profesor() {
		return Direccion_Profesor;
	}


	public void setDireccion_Profesor(String direccion_Profesor) {
		Direccion_Profesor = direccion_Profesor;
	}


	public String getNacionalidad_Profesor() {
		return Nacionalidad_Profesor;
	}


	public void setNacionalidad_Profesor(String nacionalidad_Profesor) {
		Nacionalidad_Profesor = nacionalidad_Profesor;
	}


	public Date getFechaNac_Profesor() {
		return FechaNac_Profesor;
	}


	public void setFechaNac_Profesor(Date fechaNac_Profesor) {
		FechaNac_Profesor = fechaNac_Profesor;
	}
	
	
	
	
}
