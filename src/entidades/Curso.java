package entidades;

import entidades.Materia;

public class Curso {
	

	private String codCurso;
	private Materia materia = new Materia();
	private String semestre_Curso;
	private String anio_Curso;
	private Boolean estado;
	
	public Curso() {};
			
	@Override
	public String toString() {
		return "Curso [codCurso=" + codCurso + ", materia=" + materia + ", semestre_Curso=" + semestre_Curso
				+ ", anio_Curso=" + anio_Curso + ", estado=" + estado + "]";
	}

	public Curso(String codCurso, String materia, String semestre_Curso, String anio_Curso, Boolean estado) {
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



	public Boolean getEstado() {
		return estado;
	}



	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

}
