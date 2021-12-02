package dao;

import entidades.Usuario;

public interface UsuarioDao {
	
	public boolean AltaUsuario(Usuario user);
	public boolean BajaUsuario(String legajo);
	public Usuario ExisteUsuario(String Contraseña,String Email );
}
