package it.uniroma2.ispw.test;

public class Semaphore {

	private int s;
	
	public Semaphore(int s){
		this.s = s;
	}
	
	//di default viene creato un mutex
	public Semaphore(){
		this.s = 0;
	}
	
	public synchronized void p(){
		
		while(s<0){
			try{
				wait();
			}catch(InterruptedException e){}
		}
		s--;
	}
	
	public synchronized void v(){
		s++;
		notifyAll();
	}
}
