package it.uniroma2.ispw.test;

public class SimpleThreadRunnable implements Runnable{

	private Thread thr;
	
	public void run() {
		// TODO Auto-generated method stub
		int i;
		for(i=0; i<10; i++){
			System.out.println(i + thr.getName());
		}
		try{
			Thread.sleep((long) (Math.random() * 1000));
		}catch(InterruptedException e){}
		System.out.println("finito" + thr.getName());
	}

	public SimpleThreadRunnable(String name){
		thr = new Thread(this, name);
		thr.start();
	}
	
	@SuppressWarnings("unused")
	public static void main(String args[]){
		SimpleThreadRunnable st1 = new SimpleThreadRunnable("primoThread");
		SimpleThreadRunnable st2 = new SimpleThreadRunnable("secondoThread");

	}
}
