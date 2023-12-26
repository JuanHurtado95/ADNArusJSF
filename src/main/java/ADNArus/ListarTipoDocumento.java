package ADNArus;

import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class ListarTipoDocumento {
	
	private List<TipoDocumento> tiposDocumentos;
	
	public ListarTipoDocumento() {
		tiposDocumentos = Arrays.asList(TipoDocumento.values());
	}

	public List<TipoDocumento> getTiposDocumentos() {
		return tiposDocumentos;
	}

	public void setTiposDocumentos(List<TipoDocumento> tiposDocumentos) {
		this.tiposDocumentos = tiposDocumentos;
	}
	
}
