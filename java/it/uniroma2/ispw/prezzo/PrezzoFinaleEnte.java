package it.uniroma2.ispw.prezzo;

public class PrezzoFinaleEnte extends PrezzoFinale {
	
	public int calcolaPrezzoFinale(int prezzoIniziale){
		
		int n = (prezzoIniziale*9)/10;
		return n;
		
	}

}
