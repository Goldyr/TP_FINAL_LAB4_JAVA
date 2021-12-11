package daoImpl;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.NotasDao;
import entidades.Alumno;
import entidades.Notas;
import entidades.Usuario;

public class NotasDaoImpl implements NotasDao {

	@Override
	public boolean AltaNotas(Notas notas) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ModificarNotar(Notas notas) {

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

			if(filas_afectadas==1) {
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

	private Notas getNotas(ResultSet rs) throws SQLException
	{
		Alumno alumnoNota = new Alumno();

		String CodNota_Nota = rs.getString("CodNotas_Nota");
		String NombreMateria_Nota = rs.getString("NombreMateria_Materia");

		alumnoNota.setLegajo_Alumno(rs.getString("Legajo_Alumno"));
		alumnoNota.setNombre_Alumno(rs.getString("Nombre_Alumno"));
		alumnoNota.setApellido_Alumno(rs.getString("Apellido_Alumno"));
		alumnoNota.setEmail_Alumno(rs.getString("Email_Alumno"));

		float parcial_1_Nota = rs.getFloat("Parcial_1_Nota");
		float parcial_2_Nota = rs.getFloat("Parcial_2_Nota");
		float recuperatorio_1_Nota = rs.getFloat("Recuperatorio_1_Nota");
		float recuperatorio_2_Nota = rs.getFloat("Recuperatorio_2_Nota");
		String EstadoCursada_Nota = rs.getString("EstadoCursada_Nota");


		return new Notas(CodNota_Nota, NombreMateria_Nota, alumnoNota, parcial_1_Nota, parcial_2_Nota, recuperatorio_1_Nota, recuperatorio_2_Nota,
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

}