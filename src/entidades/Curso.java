package entidades;

public class Curso {
	

	private int codCurso;
	private int codMateria;
	private String semestre_Curso;
	private String anio_Curso;
	
	public Curso() {}
	
	public int getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}

	public int getCodMateria() {
		return codMateria;
	}

	public void setCodMateria(int codMateria) {
		this.codMateria = codMateria;
	}

	public String getSemestre_Curso() {
		return semestre_Curso;
	}

	public void setSemestre_Curso(String semestre_Curso) {
		this.semestre_Curso = semestre_Curso;
	}

	public String getAnio_Curso() {
		return anio_Curso;
	}

	public void setAnio_Curso(String anio_Curso) {
		this.anio_Curso = anio_Curso;
	}

}
