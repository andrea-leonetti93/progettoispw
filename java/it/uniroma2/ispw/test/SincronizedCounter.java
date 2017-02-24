package it.uniroma2.ispw.test;

public class SincronizedCounter {

	private int c = 0;
	
	public SincronizedCounter(int val){
		c = val;
	}
	
	public synchronized void increment(){
		c++;
	}
	
	public synchronized void decrement(){
		c--;
	}
	
	public synchronized int value(){
		return c;
	}
}
