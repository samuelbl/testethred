import java.util.ArrayList;
import java.util.List;

public class InstanciaPojo {
	private String eppnid;
	private String autenticacao;
	private String id_msg_anterior;

	private static List<InstanciaPojo> instancia = new ArrayList<InstanciaPojo>();

	public static synchronized InstanciaPojo getInstance(String eppnid) {
		InstanciaPojo aut = new InstanciaPojo(eppnid);
		if (!instancia.isEmpty()) {
			for (InstanciaPojo instanciaPojo : instancia) {
				if (instanciaPojo.getEppnid() != null && instanciaPojo.getEppnid().equals(eppnid)) {
					return instanciaPojo;
				}
			}
		}
		instancia.add(aut);
		return aut;
	}

	InstanciaPojo() {

	}

	public String getEppnid() {
		return eppnid;
	}

	public void setEppnid(String eppnid) {
		this.eppnid = eppnid;
	}

	public String getAutenticacao() {
		return autenticacao;
	}

	public void setAutenticacao(String autenticacao) {
		this.autenticacao = autenticacao;
	}

	public InstanciaPojo(String eppnid) {
		setEppnid(eppnid);
	}

	public String getId_msg_anterior() {
		return id_msg_anterior;
	}

	public void setId_msg_anterior(String id_msg_anterior) {
		this.id_msg_anterior = id_msg_anterior;
	}
	
	 public static void removeInstancia (InstanciaPojo autpojo) {
	        instancia.remove(autpojo);
	    }

}
