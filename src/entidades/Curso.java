package entidades;

import entidades.Materia;

public class Curso {
	

	private String codCurso;
	private Materia materia;
	private String semestre_Curso;
	private String anio_Curso;
	private boolean estado;
	
	public Curso(String codCurso, String materia, String semestre_Curso, String anio_Curso, boolean estado) {
		this.codCurso=codCurso;
		this.materia.setCodigoMateria(materia);
		this.semestre_Curso=semestre_Curso;
		this.anio_Curso=anio_Curso;
		this.setEstado(estado);
		
		
		
	}
	


	public String getCodMateria() {
		return materia.getCodigoMateria();
	}

	public void setCodMateria(String codMateria) {
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



	public String getCodCurso() {
		return codCurso;
	}



	public void setCodCurso(String codCurso) {
		this.codCurso = codCurso;
	}



	public boolean isEstado() {
		return estado;
	}



	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}
