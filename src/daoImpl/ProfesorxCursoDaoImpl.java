package daoImpl;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.ProfesorxCursoDao;
import entidades.Curso;
import entidades.Profesor;
import entidades.ProfesorxCurso;

public class ProfesorxCursoDaoImpl implements ProfesorxCursoDao {

	
	@Override
	public boolean AltaProfesorxCurso(ProfesorxCurso pxc ) {
		boolean resultado = false;

        Conexion cn = new Conexion(); 

        try {
            CallableStatement cst = cn.getSQLConexion().prepareCall("CALL sp_altaCursosxUsuarios(?, ?)");

            cst.setString(1, pxc.getLegajoUsuario_pxc());
            cst.setString(2, pxc.getCodCurso_pxc());

            System.out.println(cst.toString());
            int filas_afectadas = cst.executeUpdate();
            System.out.println("Filas afectadas: " + filas_afectadas);

            resultado = true;
            if(filas_afectadas==1) {
                cn.getSQLConexion().commit();
            }else {
                cn.getSQLConexion().rollback();
            }

        }catch(SQLException e) {
            e.printStackTrace();
            try {
                cn.getSQLConexion().rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        return resultado;
	}

	@Override
	public boolean ExisteProfesorxCurso(String legajo, String Codigo_Curso) {
		// TODO Auto-generated method stub
		return false;
	}

}
