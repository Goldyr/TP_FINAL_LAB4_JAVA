package entidades;

import entidades.Materia;

public class Curso {
	

	private int codCurso;
	private Materia materia;
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
		return materia.getCodigoMateria();
	}

	public void setCodMateria(int codMateria) {
		this.materia.setCodigoMateria(codMateria);
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
