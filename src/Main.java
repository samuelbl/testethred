
public class Main {

	public static void main(String[] args) throws InterruptedException{
		InstanciaPojo instance = InstanciaPojo.getInstance("eppn1");
		InstanciaPojo instance2 = InstanciaPojo.getInstance("eppn2");
		System.out.println("thred = " + Thread.currentThread() + "intancia = "+ instance);
		instance.setAutenticacao("true");
		Thread t1 = new Thread(new ThredTeste("eppn1")); 
		Thread t2 = new Thread(new ThredTeste("eppn2"));
		t1.start();
		t2.start();
		System.out.println("teste fim");
		synchronized(Thread.currentThread()){
			Thread.currentThread().wait(1000);
		}
		
		synchronized(instance){
			instance.notify();		
		}
		synchronized(instance){
			instance2.notify();		
		}
	}
	
}
