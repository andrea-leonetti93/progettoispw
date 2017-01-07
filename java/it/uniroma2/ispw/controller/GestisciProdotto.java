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
		
		Prodotto newProdotto = new Prodotto(iPBean.getNameProduct(), iPBean.getCategory(), iPBean.getTypology(), iPBean.getAmount(), iPBean.getPrice(), 
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
	
	public boolean deleteProduct(int id){
		
		if(p.deleteProduct(id)){
			return true;
		}
		return false;
	}

	public Prodotto selezionaProdottoPerID(int idProd) {
		// TODO Auto-generated method stub
		Prodotto pr = null;
		if((pr = p.prendiProdottoPerID(idProd)) != null){
			return pr;
		}
		return null;
	}

	public Prodotto aggiornaProdotto(InsProdottoBean iPBean) {
		// TODO Auto-generated method stub
		UtenteRegistrato ur = u.checkUtente(iPBean.getUtente().getEmail(), iPBean.getUtente().getPassword());
		
		Prodotto productChange = new Prodotto(iPBean.getNameProduct(), iPBean.getCategory(), iPBean.getTypology(), iPBean.getAmount(), iPBean.getPrice(), 
				iPBean.getMethodPay(), iPBean.getDeliveryType(), iPBean.getSale(), ur);
		
		productChange.setId(iPBean.getIdProd());
		if(p.updateProdotto(productChange)){
			return productChange;
		}
		return null;
	}

}