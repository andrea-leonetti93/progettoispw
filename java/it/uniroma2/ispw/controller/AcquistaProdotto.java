package it.uniroma2.ispw.controller;

import it.uniroma2.ispw.model.Ordine;
import it.uniroma2.ispw.model.Prodotto;
import it.uniroma2.ispw.model.UtenteRegistrato;
import it.uniroma2.ispw.persistence.OrdineDAO;

public class AcquistaProdotto {

	private OrdineDAO od = new OrdineDAO();
	
	public AcquistaProdotto(){}

	public boolean acquistaProdotto(int prezzoFinale, String metodoPagamento, UtenteRegistrato utenteReg,
			Prodotto prodotto) {
		// TODO Auto-generated method stub
		
		Ordine newOrdine = new Ordine(prezzoFinale, metodoPagamento, utenteReg, prodotto);
		if(od.addOrdine(newOrdine) != null){
			return true;
		}
		return false;
	}
	
	
}
