package daoImpl;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.AlumnoDao;
import entidades.Alumno;

public class AlumnoDaoImpl implements AlumnoDao{

	@Override
	public List<Alumno> ListarAlumnos() {
		Conexion cn = new Conexion();
		try {
			CallableStatement cst = cn.getSQLConexion().prepareCall("CALL sp_listarAlumnos");
			cst.execute();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public boolean EliminarAlumno(String legajo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean AltaAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ModificarAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ExisteAlumno(String legajo) {
		// TODO Auto-generated method stub
		return false;
	}

}
