package ADNArus;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;

import javax.ejb.Stateless;
import javax.json.Json;


@Stateless
public class UsuarioServiceRestClient {
	
	private static final String REST_URI = "http://localhost:8090/registro";
	
	private Client client = Client.create();
	
	private static final String FALLA_ADMINISTRADOR = "Falla en la conexion con el servicio, contacte a su administrador";

	private SimpleDateFormat formatoFecha;
		
	public void registrarUsuario(Usuario usuario) throws Exception {
		
		formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
		String apiRespuesta=null;
		
		String input = "{\"tipoDocumento\":\""+usuario.getTipoDocumento()+"\","
		+"\"numeroDocumento\":\""+usuario.getNumeroDocumento()+"\","
		+"\"primerNombre\":\""+usuario.getPrimerNombre()+"\","
		+"\"segundoNombre\":\""+usuario.getSegundoNombre()+"\","
		+"\"primerApellido\":\""+usuario.getPrimerApellido()+"\","
		+"\"segundoApellido\":\""+usuario.getSegundoApellido()+"\","
		+"\"administradoraSalud\":\""+usuario.getAdministradoraSalud()+"\","
		+"\"fechaAfiliacionSalud\":\""+formatoFecha.format(usuario.getFechaAfiliacionSalud())+"\","
		+"\"administradoraPension\":\""+usuario.getAdministradoraPension()+"\","
		+"\"fechaAfiliacionPension\":\""+formatoFecha.format(usuario.getFechaAfiliacionPension())+"\"}";
		      
        
		ClientResponse respuesta = client
				.resource(REST_URI)
				.type("application/json")
				.post(ClientResponse.class, input); 


		if(respuesta.getStatus() != 200 )
			apiRespuesta = respuesta.getEntity(String.class);
			int indiceMensaje = apiRespuesta.indexOf("mensaje\":");
			String mensaje = apiRespuesta.substring(indiceMensaje + 10);
			int indiceComillas = mensaje.indexOf("\"");
			mensaje = mensaje.substring(0, indiceComillas);
			throw new Exception(mensaje);
	}

}
