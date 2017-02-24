package it.uniroma2.ispw.test;

public class Produttore extends Thread{

	private Buffer buffer;
	private int numero; //numero del thread

	public void run(){
		
		int i;
		for(i = 0; i < 10; i++){
			buffer.putBuf(i);
			System.out.println("Produttore #" + this.numero + "put:" + i);
		}
	}
	
	public Produttore(Buffer b, int numero){
		buffer = b;
		this.numero = numero;
	}
	
	
	public static void main(String args[]){
		int i;
		Thread t;
		Buffer bc = new Buffer();
		for(i=0; i<5; i++){
			t = new Produttore(bc, i);
			t.start();
		}
		for(i=0; i<5; i++){
			t = new Consumatore(bc, i);
			t.start();
		}
	}
}
