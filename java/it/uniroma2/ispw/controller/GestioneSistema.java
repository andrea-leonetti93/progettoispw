package it.uniroma2.ispw.controller;

import java.util.ArrayList;
import java.util.List;

import it.uniroma2.ispw.model.Amministratore;
import it.uniroma2.ispw.model.Ordine;
import it.uniroma2.ispw.model.Prodotto;
import it.uniroma2.ispw.model.UtenteRegistrato;
import it.uniroma2.ispw.persistence.AmministratoreDAO;
import it.uniroma2.ispw.persistence.OrdineDAO;
import it.uniroma2.ispw.persistence.ProdottoDAO;
import it.uniroma2.ispw.persistence.UtenteDAO;

public class GestioneSistema {

	
	public List<UtenteRegistrato> visualizzaUtenti(){
		List<UtenteRegistrato> lur = null;
		UtenteDAO uDAO = new UtenteDAO();
		lur = uDAO.listaUtenti();
		return lur;
	}
	
	public List<Prodotto> visualizzaProdotti(String categoria, String tipologia){
		List<Prodotto> lp = null;
		List<Prodotto> lpfinal = new ArrayList<Prodotto>();
		ProdottoDAO pdao = new ProdottoDAO();
		lp = pdao.listaProdotti();
		for (Prodotto p : lp){
			boolean b1 = p.getCategoria().equals(categoria);
			boolean b2 = p.getTipologia().equals(tipologia);
			if ((b1)&&(b2)) lpfinal.add(p);
		}
		return lpfinal;
	}
	
	public List<Prodotto> visualizzaProdotti(){
		List<Prodotto> lp = null;
		ProdottoDAO pdao = new ProdottoDAO();
		lp = pdao.listaProdotti();
		return lp;
	}
	
	public List<Ordine> visualizzaOrdini(){
		List<Ordine> lo = null;
		OrdineDAO odao = new OrdineDAO();
		lo = odao.listaOrdini();
		return lo;
	}
	
	public boolean aggiungiAmministratore(Amministratore admin){
		AmministratoreDAO ammDAO = new AmministratoreDAO();
		ammDAO.addAmministratore(admin);
		return true;
		
	}
	
}
