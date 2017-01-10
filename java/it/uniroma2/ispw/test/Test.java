package it.uniroma2.ispw.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.uniroma2.ispw.controller.GestisciUtente;
import it.uniroma2.ispw.model.Consumatore;
import it.uniroma2.ispw.model.Prodotto;
import it.uniroma2.ispw.model.UtenteRegistrato;
import it.uniroma2.ispw.model.Venditore;
import it.uniroma2.ispw.persistence.ProdottoDAO;
import it.uniroma2.ispw.persistence.UtenteDAO;
import it.uniroma2.ispw.session.UtenteSessione;

public class Test {


public static void main(String[] args) {
	
	GestisciUtente gu = new GestisciUtente();
	
	UtenteSessione us = gu.effettuaLogin("giorgioiannone@gmail.com", "miapass");
	if (us !=null){
		System.out.println("loggato");
	}
	
	else System.out.println("NON loggato");
	
		

	}

}
