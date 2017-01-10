package it.uniroma2.ispw.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	
	
	GestisciRicerca gr = GestisciRicerca.getInstance();
	
	List<PropostaVendita> lpv = gr.ricercaProdotto("tuta nike","vestiti","sport",0,1000);
	
	for(PropostaVendita pv : lpv){
		System.out.println(pv.getP().getNome()+" "+ pv.getV().getEmail());
	}
	
	System.out.println(GestisciRicerca.distance("ciao", "ciaa"));
		
	
	

	}


}