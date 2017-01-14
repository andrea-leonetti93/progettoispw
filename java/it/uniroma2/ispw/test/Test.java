package it.uniroma2.ispw.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.uniroma2.ispw.bean.RicercaBean;
import it.uniroma2.ispw.controller.GestisciRicerca;
import it.uniroma2.ispw.controller.GestisciUtente;
import it.uniroma2.ispw.factory.FactorySpedizione;
import it.uniroma2.ispw.model.Consumatore;
import it.uniroma2.ispw.model.Ente;
import it.uniroma2.ispw.model.Prodotto;
import it.uniroma2.ispw.model.PropostaVendita;
import it.uniroma2.ispw.model.UtenteRegistrato;
import it.uniroma2.ispw.model.Venditore;
import it.uniroma2.ispw.persistence.ProdottoDAO;
import it.uniroma2.ispw.persistence.UtenteDAO;
import it.uniroma2.ispw.session.UtenteSessione;
import it.uniroma2.ispw.spedizione.Spedizione;

public class Test {



	public static void main(String[] args) {
		
		UtenteDAO u = new UtenteDAO();
		UtenteRegistrato ur = u.getUtente("laziodisu@hotmail.it");
		
		if (ur!=null){
			System.out.println("bo");
			if (ur instanceof Consumatore) System.out.println("è istanza di consumatore");
			if (ur instanceof Ente) System.out.println("è istanza di ente");
		}
		
		FactorySpedizione fs = new FactorySpedizione();
		
		Spedizione sped = fs.creaSpedizione(1);
		
		System.out.println(sped.calcolaCostoSpedizione(5));
		
	
	

	}


}