package entidades;

public class Notas {
	private String NombreMateria_Nota;
	private Alumno Alumno_Nota;
	private String codNotas_Nota;
	private float parcial_1_Nota;
	private float parcial_2_Nota;
	private float recuperatorio_1_Nota;
	private float recuperatorio_2_Nota ;
	private String EstadoCursada_Nota;
	
	public Notas() {}

	public Notas(String CodNota, String _Materia, Alumno _Alumno, float parcial1, float parcial2,
			float recuperatorio1, float recuperatorio2, String _Estadocursada) {
		codNotas_Nota = CodNota;
		NombreMateria_Nota = _Materia;
		Alumno_Nota = _Alumno;
		parcial_1_Nota = parcial1;
		parcial_2_Nota = parcial2;
		recuperatorio_1_Nota = recuperatorio1;
		recuperatorio_2_Nota = recuperatorio2;
		EstadoCursada_Nota = _Estadocursada;
	}

	public String getNombreMateria_Nota() {
		return NombreMateria_Nota;
	}

	public void setNombreMateria_Nota(String nombreMateria_Nota) {
		NombreMateria_Nota = nombreMateria_Nota;
	}

	public Alumno getAlumno_Nota() {
		return Alumno_Nota;
	}

	public void setAlumno_Nota(Alumno alumno_Nota) {
		Alumno_Nota = alumno_Nota;
	}


	public String getEstadoCursada_Nota() {
		return EstadoCursada_Nota;
	}

	public void setEstadoCursada_Nota(String estadoCursada_Nota) {
		EstadoCursada_Nota = estadoCursada_Nota;
	}
	
	public String getCodNotas_Nota() {
		return codNotas_Nota;
	}

	public void setCodNotas_Nota(String codNotas_Nota) {
		this.codNotas_Nota = codNotas_Nota;
	}

	public float getParcial_1_Nota() {
		return parcial_1_Nota;
	}

	public void setParcial_1_Nota(float parcial_1_Nota) {
		this.parcial_1_Nota = parcial_1_Nota;
	}

	public float getParcial_2_Nota() {
		return parcial_2_Nota;
	}

	public void setParcial_2_Nota(float parcial_2_Nota) {
		this.parcial_2_Nota = parcial_2_Nota;
	}

	public float getRecuperatorio_1_Nota() {
		return recuperatorio_1_Nota;
	}

	public void setRecuperatorio_1_Nota(float recuperatorio_1_Nota) {
		this.recuperatorio_1_Nota = recuperatorio_1_Nota;
	}

	public float getRecuperatorio_2_Nota() {
		return recuperatorio_2_Nota;
	}

	public void setRecuperatorio_2_Nota(float recuperatorio_2_Nota) {
		this.recuperatorio_2_Nota = recuperatorio_2_Nota;
	}
	
	
}
