package it.uniroma2.ispw.controller;

import java.util.List;

import it.uniroma2.ispw.bean.InsProdottoBean;
import it.uniroma2.ispw.model.Prodotto;
import it.uniroma2.ispw.model.UtenteRegistrato;
import it.uniroma2.ispw.persistence.ProdottoDAO;
import it.uniroma2.ispw.persistence.UtenteDAO;

public class GestisciProdotto {

	ProdottoDAO p = new ProdottoDAO();
	UtenteDAO u = new UtenteDAO();
	
	public GestisciProdotto(){	
		
	}
	
	public Prodotto inserisciProdotto(InsProdottoBean iPBean){
		
		UtenteRegistrato ur = u.checkUtente(iPBean.getUtente().getEmail(), iPBean.getUtente().getPassword());
		
		Prodotto newProdotto = new Prodotto(iPBean.getName(), iPBean.getCategory(), iPBean.getTypology(), iPBean.getAmount(), iPBean.getPrice(), 
				iPBean.getMethodPay(), iPBean.getDeliveryType(), iPBean.getSale(), ur);
		p.addProdotto(newProdotto);
		
		return newProdotto;
	}
	
	/*carica tipo prodotti in liste*/
	public List<Prodotto> prodottiUtente(String email){
		
		List<Prodotto> listaP = null;
		listaP = p.listaProdottiUtente(email);
		return listaP;
	}
}
