package it.uniroma2.ispw.experimental;

public class SingletonAccess {
	
	private int n;
	
	private SingletonAccess(){
		n = 0;
	}
	
	 private static class LazyHolder {
	        private static final SingletonAccess INSTANCE = new SingletonAccess();
	    }
	 
	 public static SingletonAccess getInstance() {
	        return LazyHolder.INSTANCE;
	    }
	 
	 public int getCount(){
		 return n;
	 }
	 
	 public void addCount(){
		 n++;
	 }

}
