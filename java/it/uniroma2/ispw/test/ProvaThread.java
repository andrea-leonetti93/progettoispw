package it.uniroma2.ispw.test;

public class ProvaThread extends Thread{

	
	public void run(){
		System.out.println("Hello world");
	}
	
	public ProvaThread(){}
	
	public static void main(String args[]){
		Thread t = new ProvaThread();
		t.start();
		
	}
}


