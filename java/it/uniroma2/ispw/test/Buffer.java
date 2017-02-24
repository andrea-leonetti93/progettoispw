package it.uniroma2.ispw.test;

public class Buffer {

	private int valore;
	private boolean disponibile = false;
	
	public synchronized int getBuf(){
		while(disponibile == false){
			try{
				wait();
			}catch(InterruptedException e){}
		}
		disponibile = false;
		notifyAll();
		return valore;
	}
	
	public synchronized void putBuf(int val){
		while(disponibile == true){
			try{
				wait();
			}catch(InterruptedException e){}
		}
		disponibile = true;
		valore = val;
		notifyAll();
	}
}
