
public class ThredTeste implements Runnable {

	private String eppn;
	@Override
	public void run() {
		InstanciaPojo instance = InstanciaPojo.getInstance(getEppn());
		System.out.println("thred = " + Thread.currentThread() + "intancia = "+ instance );
		synchronized (instance) {
			try {
				instance.wait(300000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		System.out.println("Imprime resultado = "+instance);
		}
	}
	
	
	
	public ThredTeste(String eppn) {
		super();
		this.eppn = eppn;
	}



	public String getEppn() {
		return eppn;
	}
	public void setEppn(String eppn) {
		this.eppn = eppn;
	}

}
