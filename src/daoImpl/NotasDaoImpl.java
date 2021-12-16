package daoImpl;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import dao.NotasDao;
import entidades.Alumno;
import entidades.Curso;
import entidades.Materia;
import entidades.Notas;
import entidades.Usuario;

public class NotasDaoImpl implements NotasDao {

	
	String readall= "SELECT c.CodCurso_Curso, n.CodNotas_Nota, m.NombreMateria_Materia, a.Legajo_Alumno, Nombre_Alumno, a.Apellido_Alumno, a.Email_Alumno, n.Parcial_1_Nota, n.Parcial_2_Nota, " + 
			"n.Recuperatorio_1_Nota, Recuperatorio_2_Nota, n.EstadoCursada_Nota FROM Notas AS n " + 
			"INNER JOIN cursosxalumnos as cxa ON cxa.CodNotas_CxA = n.CodNotas_Nota " + 
			"INNER JOIN alumnos as a ON a.Legajo_Alumno = cxa.Legajo_Alumno_CxA " + 
			"INNER JOIN cursos as c ON c.CodCurso_Curso = cxa.CodCurso_CxA " + 
			"INNER JOIN materias as m ON m.CodMateria_Materia = c.CodMateria_Curso " + 
			"INNER JOIN cursosxusuarios AS cxu ON cxu.CodCurso_CxU = c.CodCurso_Curso " + 
			"INNER JOIN usuarios u ON u.Legajo_Usuario = cxu.Legajo_Usuario_CxU " + 
			"WHERE u.Legajo_Usuario = ? AND m.CodMateria_Materia = ? AND C.Semestre_Curso = ?;";
	@Override
	public boolean AltaNotas(Notas notas) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ModificarNota(Notas notas) {

		Boolean resultado = false;

		Conexion conexion = new Conexion();

		try {

			CallableStatement cst = conexion.getSQLConexion().prepareCall("{call sp_modificarNotas(?, ?, ?, ?, ?)}");
			
			cst.setFloat(1, notas.getParcial_1_Nota());
			cst.setFloat(2, notas.getParcial_2_Nota());
			cst.setFloat(3, notas.getRecuperatorio_1_Nota());
			cst.setFloat(4, notas.getRecuperatorio_2_Nota());
			cst.setString(5, notas.getCodNotas_Nota());

			int filas_afectadas = cst.executeUpdate();

			if(filas_afectadas != 0) {
				resultado=true;
				conexion.getSQLConexion().commit();
			}else {
				conexion.getSQLConexion().rollback();
			}

		}
		catch(SQLException e)
		{
			e.printStackTrace();
			try {
				conexion.getSQLConexion().rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		}

		return resultado;

	}

	@Override
	public ArrayList<Notas> ListarNotas(String legajoProfesor, String codMateria) {

		ArrayList<Notas> resultado = new ArrayList<Notas>();
		Conexion conexion = new Conexion();
		ResultSet resultSet;

		try {

			CallableStatement cst = conexion.getSQLConexion().prepareCall("{call sp_listarNotasMateriaxProfesor(?, ?)}");
			cst.setString(1, legajoProfesor);
			cst.setString(2, codMateria);

			resultSet = cst.executeQuery();

			while(resultSet.next()) {
				resultado.add(getNotas(resultSet));
			}

		}
		catch(SQLException e)
		{
			e.printStackTrace();
			try {
				conexion.getSQLConexion().rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		}

		return resultado;
	}
	@Override
	public ArrayList<Notas> ListarNotasFiltradas(String legajoProfesor, String codMateria, String Semestre) {
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<Notas> ListarNotas = new ArrayList<Notas>();
		Conexion conexion = new Conexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			statement.setString(1, legajoProfesor);
			statement.setString(2, codMateria);
			statement.setString(3, Semestre);
			resultSet = statement.executeQuery();
			//System.out.println(statement.toString());
			while(resultSet.next())
			{
				ListarNotas.add(getNotas(resultSet));
			}
		} 
		catch(SQLException e)
		{
			e.printStackTrace();
			try {
				conexion.getSQLConexion().rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		}

		return ListarNotas;
	}
	private Notas getNotas(ResultSet rs) throws SQLException
	{
		Alumno alumnoNota = new Alumno();
		Materia alumnoMateria = new Materia();
		Curso codCurso = new Curso();
		
		String CodNota_Nota = rs.getString("CodNotas_Nota");
		alumnoMateria.setNombreMateria(rs.getString("NombreMateria_Materia"));
		codCurso.setCodCurso(rs.getString("CodCurso_Curso"));

		alumnoNota.setLegajo_Alumno(rs.getString("Legajo_Alumno"));
		alumnoNota.setNombre_Alumno(rs.getString("Nombre_Alumno"));
		alumnoNota.setApellido_Alumno(rs.getString("Apellido_Alumno"));
		alumnoNota.setEmail_Alumno(rs.getString("Email_Alumno"));

		float parcial_1_Nota = rs.getFloat("Parcial_1_Nota");
		float parcial_2_Nota = rs.getFloat("Parcial_2_Nota");
		float recuperatorio_1_Nota = rs.getFloat("Recuperatorio_1_Nota");
		float recuperatorio_2_Nota = rs.getFloat("Recuperatorio_2_Nota");
		String EstadoCursada_Nota = rs.getString("EstadoCursada_Nota");


		return new Notas(CodNota_Nota, alumnoMateria, codCurso, alumnoNota, parcial_1_Nota, parcial_2_Nota, recuperatorio_1_Nota, recuperatorio_2_Nota,
				EstadoCursada_Nota);
	}

	@Override
	public Notas obtenerNotas(String codNotas) {

		Notas _notas = new Notas();
		Conexion conexion = new Conexion();
		ResultSet resultSet;

		try {

			CallableStatement cst = conexion.getSQLConexion().prepareCall("{call sp_obtenerNotasxCodigo(?)}");
			cst.setString(1, codNotas);

			resultSet = cst.executeQuery();

			if(resultSet.next()) {
				_notas = getNotas(resultSet);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			try {
				conexion.getSQLConexion().rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		}

		return _notas;
	}

	@Override
	public boolean ModificarNotasMasivamente(ArrayList<Notas> arrNotas) {
	
		boolean resultado = true;

		for(Notas NotaAlumno : arrNotas)
		{
			if(!ModificarNotaxCurso(NotaAlumno)) resultado = false;
		}
		
		return resultado;
	}

	@Override
	public boolean ModificarNotaxCurso(Notas notas) {

		Boolean resultado = false;

		Conexion conexion = new Conexion();

		try {

			CallableStatement cst = conexion.getSQLConexion().prepareCall("{call sp_modificarNotasCursosxAlumnos(?, ?, ?, ?, ?, ?)}");
			
			cst.setString(1, notas.getAlumno_Nota().getLegajo_Alumno());
			cst.setString(2, notas.getCurso_Nota().getCodCurso());
			cst.setFloat(3, notas.getParcial_1_Nota());
			cst.setFloat(4, notas.getParcial_2_Nota());
			cst.setFloat(5, notas.getRecuperatorio_1_Nota());
			cst.setFloat(6, notas.getRecuperatorio_2_Nota());
			

			int filas_afectadas = cst.executeUpdate();

			if(filas_afectadas != 0) {
				resultado=true;
				conexion.getSQLConexion().commit();
			}else {
				conexion.getSQLConexion().rollback();
			}

		}
		catch(SQLException e)
		{
			e.printStackTrace();
			try {
				conexion.getSQLConexion().rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		}

		return resultado;
	}

}