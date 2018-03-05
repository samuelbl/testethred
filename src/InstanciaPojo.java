
public class InstanciaPojo {
	private String eppnid;
	private String autenticacao;
	private String id_msg_anterior;

	private static InstanciaPojo instancia;

	public static synchronized InstanciaPojo getInstance(String eppnid) {
		if (instancia == null || instancia.getEppnid() == null) {
			instancia = new InstanciaPojo(eppnid);
		} else {
			if (instancia.getEppnid().equals(eppnid)) {
				return instancia;
			}
			else {
				instancia = new InstanciaPojo(eppnid);
			}
			
				
		}
		return instancia;
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
	
}
