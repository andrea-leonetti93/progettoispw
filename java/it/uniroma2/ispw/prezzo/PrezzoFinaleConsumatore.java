package it.uniroma2.ispw.prezzo;

import it.uniroma2.ispw.bean.ProdottoBean;
import it.uniroma2.ispw.model.Prodotto;


public class PrezzoFinaleConsumatore extends PrezzoFinale {

	
	public int calcolaPrezzoFinale(ProdottoBean pB){
		return pB.getPrice();
	}
	
	public int calcolaPrezzoFinale(Prodotto p){
		return p.getPrezzo();
	}


}
