package it.uniroma2.ispw.test;


public class SimpleThread extends Thread{

	public void run(){
		int i;
		for(i=0; i<10; i++){
			System.out.println(i + getName());
			try{
				sleep((long) (Math.random() * 1000));
			}catch (InterruptedException e){}  /*eccezione quando il thread viene interrotto durante 
			l'esecuzione tramite il segnale interrupts*/
		}
			System.out.println(getName() + "finito!");
	}
	
	
	public SimpleThread(String nome){
		super(nome);
	}
	
	public static void main(String args[]) throws InterruptedException{
		Thread t1 = new SimpleThread("Gesu");
		Thread t2 = new SimpleThread("Dio");
		t1.start();
		t2.start();
		t1.join();	//per usare la join bisogna sempre utilizzare la throws exception sul metodo che chiama la join
		t2.join();
		System.out.println("main thread ha terminato");
		
		
	}
}
