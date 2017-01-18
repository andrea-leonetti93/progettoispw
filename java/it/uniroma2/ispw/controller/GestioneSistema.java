package it.uniroma2.ispw.controller;

import java.util.List;

import it.uniroma2.ispw.model.Amministratore;
import it.uniroma2.ispw.model.Ordine;
import it.uniroma2.ispw.model.Prodotto;
import it.uniroma2.ispw.model.UtenteRegistrato;

public class GestioneSistema {

	
	public List<UtenteRegistrato> visualizzaUtenti(){
		List<UtenteRegistrato> lur = null;
		return lur;
	}
	
	public List<Prodotto> visualizzaProdotti(String categoria, String tipologia){
		List<Prodotto> lp = null;
		return lp;
	}
	
	public List<Prodotto> visualizzaProdotti(){
		List<Prodotto> lp = null;
		return lp;
	}
	
	public List<Ordine> visualizzaOrdini(){
		List<Ordine> lo = null;
		return lo;
	}
	
	public Amministratore loginAmministratore(String email, String password){
		Amministratore admin = null;
		return admin;
	}
	
	public boolean aggiungiAmministratore(Amministratore admin){
		return true;
	}
	
}
