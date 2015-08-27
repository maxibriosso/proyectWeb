package controladores;

import dominio.Usuario;

public interface IUsuarioController {
	
	public boolean guardarUsuario(Usuario usuario);	
	public Usuario buscarUsuario(String nombre);

}
