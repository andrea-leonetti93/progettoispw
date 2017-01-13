package it.uniroma2.ispw.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.uniroma2.ispw.bean.RicercaBean;
import it.uniroma2.ispw.controller.GestisciRicerca;
import it.uniroma2.ispw.controller.GestisciUtente;
import it.uniroma2.ispw.model.Consumatore;
import it.uniroma2.ispw.model.Prodotto;
import it.uniroma2.ispw.model.PropostaVendita;
import it.uniroma2.ispw.model.UtenteRegistrato;
import it.uniroma2.ispw.model.Venditore;
import it.uniroma2.ispw.persistence.ProdottoDAO;
import it.uniroma2.ispw.persistence.UtenteDAO;
import it.uniroma2.ispw.session.UtenteSessione;

public class Test {



	public static void main(String[] args) {
		
		ProdottoDAO pdao = new ProdottoDAO();
		
		Prodotto p = pdao.prendiProdottoPerID(11);
		
		System.out.println(p.getUtenteRegistrato().getNome());
		
	
	

	}


}