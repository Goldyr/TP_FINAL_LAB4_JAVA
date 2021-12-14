package entidades;

public class ProfesorxCurso {

	private Profesor legajoUsuario_pxc = new Profesor();
	private Curso CodCurso_pxc = new Curso();
	
	public ProfesorxCurso() {}

	public String getLegajoUsuario_pxc() {
		return legajoUsuario_pxc.getLegajo_Usuario();
	}

	public void setLegajoUsuario_pxc(String legajoUsuario_pxc) {
		this.legajoUsuario_pxc.setLegajo_Usuario(legajoUsuario_pxc);
	}

	public String getCodCurso_pxc() {
		return CodCurso_pxc.getCodCurso();
	}

	public void setCodCurso_pxc(String codCurso_pxc) {
		CodCurso_pxc.setCodCurso(codCurso_pxc);
	};
	
	
	
}
