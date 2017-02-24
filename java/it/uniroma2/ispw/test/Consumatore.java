package it.uniroma2.ispw.test;

public class Consumatore extends Thread{

	private int numero;
	private Buffer buffer;
	
	public void run(){
		int valore;
		int i;
		for(i = 0; i < 10; i++){
			valore = buffer.getBuf();
			System.out.println("Consumatore #" + this.numero + "get:" +	valore);
		}
	}
	
	public Consumatore(Buffer b, int numero){
		buffer = b;
		this.numero = numero;
	}
	
}
