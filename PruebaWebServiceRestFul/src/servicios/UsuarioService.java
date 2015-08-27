package servicios;


import java.io.IOException;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;









import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import controladores.IUsuarioController;
import dominio.Usuario;



@Path("/UsuarioService")
public class UsuarioService {
	 
	@EJB
	private IUsuarioController iuc;

	// localhost:8080/PruebaWebServiceRestFul/rest/UsuarioService/status/
		
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/status")
	public Response getStatus() {
		 System.out.println("WENOOOOOOOOOOOOOOOOOOO");
		 return Response
					.ok("{\"status\":\"El servicio de los usuarios esta funcionando...\"}")
					.build();
	}
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/usuario")
	public Response guardarUsuario(String datos) {
		
		System.out.println("Entre  Usuario Service ");
		System.out.println("Usuario - " + datos);
		
		ObjectMapper mapper = new ObjectMapper();
		boolean guardado = false;
		
			try {
				Usuario usuario = mapper.readValue(datos, Usuario.class);
				guardado = iuc.guardarUsuario(usuario);
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		if(guardado){
			return Response.ok("{\"status\":\"Usuario guardado\"}").build();
		}else{
			return Response.notModified("{\"status\":\"Usuario no guardado\"}").build();
		} 
	   
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/usuarioPrueba/{nombre}")
	public Response darUsuario(@PathParam("nombre") String nombre)
	{
		System.out.println("Entre get Usuario " + nombre);
		 JSONObject jsonObj = new JSONObject();

		 try {
			Usuario usuario = iuc.buscarUsuario(nombre);
			System.out.println("Entre get Usuario ");
			System.out.println("Usuario - " +usuario.getNombre());
			jsonObj.put("Nombre",usuario.getNombre());
			jsonObj.put("Apellido",usuario.getApellido());
			jsonObj.put("Edad",usuario.getEdad());
			jsonObj.put("Cedula",usuario.getCedula());
			jsonObj.put("Password", usuario.getPassword());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		 String json = jsonObj.toString(); 
		 return Response.ok(json).build();
	
		
	}
	
	

}
