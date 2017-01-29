package it.uniroma2.ispw.controller;

import java.util.ArrayList;
import java.util.List;

import it.uniroma2.ispw.bean.InsProdottoBean;
import it.uniroma2.ispw.bean.ProdottoBean;
import it.uniroma2.ispw.model.Prodotto;
import it.uniroma2.ispw.model.UtenteRegistrato;
import it.uniroma2.ispw.persistence.ProdottoDAO;
import it.uniroma2.ispw.persistence.UtenteDAO;

public class GestisciProdotto {

	ProdottoDAO p = new ProdottoDAO();
	UtenteDAO u = new UtenteDAO();
	
	public GestisciProdotto(){	
		
	}
	
	public boolean inserisciProdotto(InsProdottoBean iPBean){
		
		UtenteRegistrato ur = u.checkUtente(iPBean.getUtente().getEmail(), iPBean.getUtente().getPassword());
		
		Prodotto newProdotto = new Prodotto(iPBean.getNameProduct(), iPBean.getCategory(), iPBean.getTypology(), iPBean.getPrice(), 
				 iPBean.getSale(), ur, 1, iPBean.getComment());
		p.addProdotto(newProdotto);
		
		if (newProdotto == null) return false;
		return true;
	}
	
	/*carica tipo prodotti in liste*/
	public List<ProdottoBean> prodottiUtente(String email){
		
		List<Prodotto> listaP = null;
		listaP = p.listaProdottiUtente(email);
		if (listaP==null) return null;
		
		List<ProdottoBean> listaPBean = new ArrayList<ProdottoBean>();
		for (Prodotto pr : listaP){
			ProdottoBean prB = new ProdottoBean();
			prB.setIdProd(pr.getId());
			prB.setCategory(pr.getCategoria());
			prB.setDisponibilita(pr.getDisponibilita());
			prB.setEmailUser(pr.getUtenteRegistrato().getEmail());
			prB.setNameProduct(pr.getNome());
			prB.setPrice(pr.getPrezzo());
			prB.setSale(pr.getSconto());
			prB.setTypology(pr.getTipologia());
			prB.setComment(pr.getCommento());
			listaPBean.add(prB);
		}
		return listaPBean;
	}
	
	public boolean deleteProduct(int id){
		
		return p.deleteProduct(id);
		
	}
/*
	public Prodotto selezionaProdottoPerID(int idProd) {
		// TODO Auto-generated method stub
		Prodotto pr = null;
		if((pr = p.prendiProdottoPerID(idProd)) != null){
			return pr;
		}
		return null;
	}
*/
	
	public boolean selezionaProdottoPerId(InsProdottoBean insProdottoBean){
		
		Prodotto pr = null;
		if((pr = p.prendiProdottoPerID(insProdottoBean.getIdProd())) != null){
			insProdottoBean.setNameProduct(pr.getNome());
			insProdottoBean.setCategory(pr.getCategoria());
			insProdottoBean.setTypology(pr.getTipologia());
			insProdottoBean.setPrice(pr.getPrezzo());
			insProdottoBean.setSale(pr.getSconto());
			
			return true;
		}
		return false;
		
	}
	
	public boolean selezionaProdottoPerId(ProdottoBean prodottoBean){
		Prodotto pr = p.prendiProdottoPerID(prodottoBean.getIdProd());
		
		if (pr==null) return false;
		
		prodottoBean.setCategory(pr.getCategoria());
		prodottoBean.setComment(pr.getCommento());
		prodottoBean.setDisponibilita(pr.getDisponibilita());
		prodottoBean.setIdProd(pr.getId());
		prodottoBean.setNameProduct(pr.getNome());
		prodottoBean.setPrice(pr.getPrezzo());
		prodottoBean.setSale(pr.getSconto());
		prodottoBean.setTypology(pr.getTipologia());
		prodottoBean.setEmailUser(pr.getUtenteRegistrato().getEmail());
		
		
		return false;
		
	}
	
	public boolean aggiornaProdotto(ProdottoBean updateProductBean){
		
		UtenteRegistrato ur = u.getUtente(updateProductBean.getEmailUser());
		
		if (ur==null) return false;
		
		Prodotto updateProduct = new Prodotto(updateProductBean.getNameProduct(),updateProductBean.getCategory(),
				updateProductBean.getTypology(),updateProductBean.getPrice(),
				updateProductBean.getSale(), ur,1,updateProductBean.getComment());
		
		updateProduct.setId(updateProductBean.getIdProd());
		
		if (p.updateProdotto(updateProduct)){
			return true;
		}
		
		return false;
		
	}

}