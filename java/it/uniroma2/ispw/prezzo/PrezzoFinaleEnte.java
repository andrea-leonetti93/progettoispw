package it.uniroma2.ispw.prezzo;

import it.uniroma2.ispw.model.Prodotto;

public class PrezzoFinaleEnte extends PrezzoFinale {
	
	public int calcolaPrezzoFinale(Prodotto p){
		
		int n = (p.getPrezzo()*(100-p.getSconto()))/100;
		return n;
		
	}

}
