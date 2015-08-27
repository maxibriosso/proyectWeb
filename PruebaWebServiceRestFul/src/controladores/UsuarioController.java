package controladores;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import persistencia.IUsuarioDAO;
import dominio.Usuario;

@Stateless
public class UsuarioController implements IUsuarioController {

	@EJB
	private IUsuarioDAO UsuarioDAO;
	
	
	public boolean guardarUsuario(Usuario usuario) {
		
		
		try{
			return UsuarioDAO.guardarUsuario(usuario);
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	
	public Usuario buscarUsuario(String nombre) {
		try{
			return UsuarioDAO.buscarUsuario(nombre);
			}catch(Exception e){
				e.printStackTrace();
				
			}
			return null;
	}

}
