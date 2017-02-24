package it.uniroma2.ispw.test;

public class ProvaRunnable implements Runnable{

	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Hello world");
	}

	public ProvaRunnable(){}
	
	public static void main(String args[]){
		ProvaRunnable p = new ProvaRunnable();
		Thread t = new Thread(p);
		t.start();
		
	}
}
