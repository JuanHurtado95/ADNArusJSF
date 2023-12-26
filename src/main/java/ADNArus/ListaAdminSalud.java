package ADNArus;

import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class ListaAdminSalud {

	private Map<String, String> administradorasSalud;

//	@EJB
//	@Inject
//	private AdministradoraSaludService administradoraSaludService;
//	
	public ListaAdminSalud() {
		administradorasSalud = new HashMap<String, String>();

		administradorasSalud.put("Sanitas EPS", "EPS001");
		administradorasSalud.put("Sura EPS", "EPS002");
		administradorasSalud.put("Coomeva", "EPS003");
		administradorasSalud.put("Medimas", "EPS004");

	}

	public Map<String, String> getAdministradorasSalud() {
		return administradorasSalud;
	}

	public void setAdministradorasSalud(Map<String, String> administradorasSalud) {
		this.administradorasSalud = administradorasSalud;
	}

}
