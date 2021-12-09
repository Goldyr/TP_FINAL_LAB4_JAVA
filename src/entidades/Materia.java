package entidades;

public class Materia {

	private String codigoMateria;
	private String nombreMateria;
	
	public Materia() {

		
	}
	
	public Materia(String codigo, String nombre)
	{
		this.setCodigoMateria(codigo);
		this.setNombreMateria(nombre);
	}
	
	public String getCodigoMateria() {
		return codigoMateria;
	}
	public void setCodigoMateria(String codigoMateria) {
		this.codigoMateria = codigoMateria;
	}
	public String getNombreMateria() {
		return nombreMateria;
	}
	public void setNombreMateria(String nombreMateria) {
		this.nombreMateria = nombreMateria;
	}

	@Override
	public String toString() {
		return "Materia [codigoMateria=" + codigoMateria + ", nombreMateria=" + nombreMateria + "]";
	}

	
}