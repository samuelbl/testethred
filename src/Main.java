
public class Main {

	public static void main(String[] args) throws InterruptedException{
		InstanciaPojo instance = InstanciaPojo.getInstance("eppn1");
		InstanciaPojo instance2 = InstanciaPojo.getInstance("eppn2");
		InstanciaPojo instance3 = InstanciaPojo.getInstance("eppn3");
		instance.setAutenticacao("true");
		Thread t1 = new Thread(new ThredTeste("eppn1")); 
		Thread t2 = new Thread(new ThredTeste("eppn2"));
		Thread t3 = new Thread(new ThredTeste("eppn3"));
		t1.start();
		t2.start();
		t3.start();
		synchronized(Thread.currentThread()){
			Thread.currentThread().wait(1000);
		}
							
		synchronized(instance2){
			instance2.notify();	
			InstanciaPojo.removeInstancia(instance2);
		}
															synchronized(Thread.currentThread()){
																Thread.currentThread().wait(1000);
															}
		synchronized (instance3) {
			instance3.notify();
			InstanciaPojo.removeInstancia(instance3);
		}
		
																synchronized(Thread.currentThread()){
																	Thread.currentThread().wait(1000);
																}
		
		synchronized(instance){
			instance.notify();
			InstanciaPojo.removeInstancia(instance);
		}
	}
	
}
