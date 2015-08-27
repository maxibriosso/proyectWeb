package persistencia;

import javax.ejb.Stateless;

import dominio.Usuario;

@Stateless
public class UsuarioDAO implements IUsuarioDAO {
	
	
	@javax.persistence.PersistenceContext(unitName = "PruebaWebServiceRestFul")
	private javax.persistence.EntityManager em;

	public boolean guardarUsuario(Usuario usuario) {

		try {
			em.persist(usuario);
			return true;

		} catch (Exception e) {

			e.printStackTrace();

		}

		return false;

	}
	
	
	public Usuario buscarUsuario(String nombre) {
		
		return em.find(Usuario.class, nombre);
	}

}
