package daoImpl;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import dao.CursoDao;
import entidades.Alumno;
import entidades.Curso;
import entidades.Materia;

public class CursoDaoImpl implements CursoDao {

	
	private static final String readall = "SELECT * FROM cursos;";
	private  String readall2 = "select cursos.*, (Select NombreMateria_Materia from materias where CodMateria_Materia=cursos.CodMateria_Curso) as NombreMateria_Materia from cursos inner join cursosxusuarios on cursosxusuarios.CodCurso_CxU = cursos.CodCurso_Curso where cursosxusuarios.Legajo_Usuario_CxU = ";
	//select cursos.*, (Select NombreMateria_Materia from materias where CodMateria_Materia=cursos.CodMateria_Curso) as NombreMateria_Materia from cursos inner join cursosxusuarios on cursosxusuarios.CodCurso_CxU = cursos.CodCurso_Curso where cursosxusuarios.Legajo_Usuario_CxU =  '54321' 
	
	private  String cursos_noProfesor = "select c.* from cursos as c where c.Estado_Curso = 1 and not exists(select * from cursosxusuarios as c2 where c.CodCurso_Curso = c2.CodCurso_CxU and c2.Legajo_Usuario_CxU = ?);" ;
	// consulta para traer los cursos en donde no esta el profesor
	
	private String readall3 = "select cursos.* , (Select NombreMateria_Materia from materias where CodMateria_Materia=cursos.CodMateria_Curso) as NombreMateria_Materia from cursos inner join CursosxAlumnos on CursosxAlumnos.CodCurso_CxA = cursos.CodCurso_Curso where CursosxAlumnos.Legajo_Alumno_CxA = " ;
    private  String cursos_noAlumno = "select c.* from cursos as c "
            + "where c.Estado_Curso = 1 "
            + "and not exists(select * from CursosxAlumnos as c2 where c.CodCurso_Curso = c2.CodCurso_CxA and c2.Legajo_Alumno_CxA = ?);" ;
	
    private String existe = "SELECT C.* FROM cursos as C where C.CodMateria_Curso = ? and C.Semestre_Curso = ?  and C.A?o_Curso = ? ;";
	@Override
	public boolean AltaCurso(Curso alumno) {
		boolean resultado = false;
		
		Conexion conexion = new Conexion();
	
		try {
			
			CallableStatement cst = conexion.getSQLConexion().prepareCall("{call sp_AltaCursos(?, ?, ?)}");
			cst.setString(1, alumno.getCodMateria());
			cst.setString(2, alumno.getSemestre_Curso());
			cst.setString(3, alumno.getAnio_Curso());
			
				
			int filas_afectadas = cst.executeUpdate();
			
			resultado = true;
			if(filas_afectadas==1) {
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
	
	private Curso getCursoMateria(ResultSet resultSet) throws SQLException
	{
		
		String codCurso = resultSet.getString("CodCurso_Curso");
		String materia=resultSet.getString("CodMateria_Curso");
		String nombre_Materia=resultSet.getString("NombreMateria_Materia"); 
		String semestre_Curso = resultSet.getString("Semestre_Curso");
		String anio_Curso = resultSet.getString("A?o_Curso");
		Boolean estado = resultSet.getBoolean("Estado_Curso");
		
		return new Curso(codCurso , materia, nombre_Materia , semestre_Curso, anio_Curso, estado);
		
	}
	
	@Override
	public ArrayList<Curso> ListarCursosxProfesor(String legajo) {
		readall2 += "'" + legajo + "';";
		
		System.out.println(readall2);
		
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<Curso> ListarCursos = new ArrayList<Curso>();
		Conexion conexion = new Conexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall2);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				ListarCursos.add(getCursoMateria(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return ListarCursos;
	}


	@Override
	public ArrayList<Curso> ListarCursos() {

		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<Curso> ListarCursos = new ArrayList<Curso>();
		Conexion conexion = new Conexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				ListarCursos.add(getCurso(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return ListarCursos;

	}
	
	public ArrayList<Curso> ListarCursos_noProfesor(String legajo){//devuelve cursos en los que no esta un profesor
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<Curso> ListarCursos = new ArrayList<Curso>();
		Conexion conexion = new Conexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(cursos_noProfesor);
			statement.setString(1, legajo);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				ListarCursos.add(getCurso(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return ListarCursos;
	}
	
	
	private Curso getCurso(ResultSet resultSet) throws SQLException
	{
		
		
		String codCurso = resultSet.getString("CodCurso_Curso");
		String materia=resultSet.getString("CodMateria_Curso");
		String semestre_Curso = resultSet.getString("Semestre_Curso");
		String anio_Curso = resultSet.getString("A?o_Curso");
		Boolean estado = resultSet.getBoolean("Estado_Curso");


	
	
		return new Curso(codCurso , materia, semestre_Curso, anio_Curso, estado);
	}

	@Override
	public boolean EliminarCurso(String legajo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ModificarCurso(Alumno alumno) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ExisteCurso(String codmateria, String semestre, String a?o) {
		PreparedStatement statement;
        ResultSet resultSet; //Guarda el resultado de la query
        Conexion conexion = new Conexion();
        boolean flag = false;
        try
        {
            statement = conexion.getSQLConexion().prepareStatement(existe);
            statement.setString(1, codmateria);
            statement.setString(2, semestre);
            statement.setString(3, a?o);


            resultSet = statement.executeQuery();

           
           if(resultSet.next()) 
           {
        	   flag = true;
           }
           
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        
        return flag;
	}

	@Override
	public ArrayList<Curso> ListarCursosxProfesorxMateria(String legajo, String CodMateria) {
		
		String stringQuery = String.format("select cursos.*, (Select NombreMateria_Materia " + 
				"from materias where CodMateria_Materia=cursos.CodMateria_Curso) as NombreMateria_Materia "+ 
				"from cursos " + 
				"inner join cursosxusuarios on cursosxusuarios.CodCurso_CxU = cursos.CodCurso_Curso " + 
				"where cursosxusuarios.Legajo_Usuario_CxU = '%s' and cursos.CodMateria_Curso = '%s' ", legajo, CodMateria);
		
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<Curso> ListarCursos = new ArrayList<Curso>();
		Conexion conexion = new Conexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(stringQuery);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				ListarCursos.add(getCursoMateria(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return ListarCursos;
	}
	
	@Override
	public ArrayList<Curso> ListarCursosxAlumno(String legajo) {
        readall3 += "'" + legajo + "';";

        //System.out.println(readall3);

        PreparedStatement statement;
        ResultSet resultSet; //Guarda el resultado de la query
        ArrayList<Curso> ListarCursos = new ArrayList<Curso>();
        Conexion conexion = new Conexion();
        try 
        {
            statement = conexion.getSQLConexion().prepareStatement(readall3);
            resultSet = statement.executeQuery();
            while(resultSet.next())
            {
                ListarCursos.add(getCursoMateria(resultSet));
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }

        return ListarCursos;
    }

	@Override
    public ArrayList<Curso> ListarCursos_noAlumno(String legajo){//devuelve cursos en los que no esta un alumno
        PreparedStatement statement;
        ResultSet resultSet; //Guarda el resultado de la query
        ArrayList<Curso> ListarCursos = new ArrayList<Curso>();
        Conexion conexion = new Conexion();
        try 
        {
            statement = conexion.getSQLConexion().prepareStatement(cursos_noAlumno);
            statement.setString(1, legajo);
            //System.out.println(statement);
            resultSet = statement.executeQuery();
            //System.out.println(resultSet);
            while(resultSet.next())
            {
                ListarCursos.add(getCurso(resultSet));
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }

        return ListarCursos;
    }
	
}
