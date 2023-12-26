package ADNArus;

import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class ListaAdminPension {

	private Map<String, String> administradoraPension;

//	@EJB
//	@Inject
//	private AdministradoraSaludService administradoraSaludService;
//	
	public ListaAdminPension() {
		administradoraPension = new HashMap<String, String>();
	
		administradoraPension.put("Protección", "AFP001");
		administradoraPension.put("Porvenir", "AFP002");
		administradoraPension.put("Colpensiones", "AFP003");
	}

	public Map<String, String> getadministradoraPension() {
		return administradoraPension;
	}

	public void setadministradoraPension(Map<String, String> administradoraPension) {
		this.administradoraPension = administradoraPension;
	}

}
