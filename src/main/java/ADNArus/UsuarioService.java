package ADNArus;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class UsuarioService {
	
	@EJB
	private UsuarioServiceRestClient usuarioServiceRestClient;
	
	private Usuario usuario;
	
	private String mensajeExcepcion;

	public void registrarUsuario(Usuario usuario) throws Exception {

		usuarioServiceRestClient.registrarUsuario(usuario);

		String resultado = "Se crea el usuario identificado con: " + usuario.getTipoDocumento() + ": "
				+ usuario.getNumeroDocumento();
		System.out.println(resultado);
	}

	public String getMensajeExcepcion() {
		return mensajeExcepcion;
	}

	public void setMensajeExcepcion(String mensajeExcepcion) {
		this.mensajeExcepcion = mensajeExcepcion;
	}

	public void agregarMensajeExcepcion(String mensaje) {
		this.mensajeExcepcion += mensaje + "\n";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
