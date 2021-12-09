package negocio;


import daoImpl.UsuarioDaoImpl;
import entidades.Usuario;

public class UsuarioNeg {

	public Usuario ExisteUsuario(String mail, String pass) {
		UsuarioDaoImpl usudao = new UsuarioDaoImpl();
		return usudao.ExisteUsuario(mail, pass);
	}
	
	
}
