package persistencia;

import javax.ejb.Local;

import dominio.Usuario;

@Local
public interface IUsuarioDAO {

	public boolean guardarUsuario(Usuario usuario);	
	public Usuario buscarUsuario(String nombre);
	
}
