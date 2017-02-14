package it.uniroma2.ispw.prezzo;

import it.uniroma2.ispw.bean.ProdottoBean;
import it.uniroma2.ispw.model.Prodotto;

public abstract class PrezzoFinale {
	
	public abstract int calcolaPrezzoFinale(ProdottoBean pB);
	public abstract int calcolaPrezzoFinale(Prodotto p);

}
