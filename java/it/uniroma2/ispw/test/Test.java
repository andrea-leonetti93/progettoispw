package it.uniroma2.ispw.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.uniroma2.ispw.bean.PagamentoBean;
import it.uniroma2.ispw.bean.RicercaBean;
import it.uniroma2.ispw.controller.AcquistaProdotto;
import it.uniroma2.ispw.controller.GestisciRicerca;
import it.uniroma2.ispw.controller.GestisciUtente;

import it.uniroma2.ispw.model.Consumatore;
import it.uniroma2.ispw.model.Ente;
import it.uniroma2.ispw.model.Prodotto;
import it.uniroma2.ispw.model.PropostaVendita;
import it.uniroma2.ispw.model.UtenteRegistrato;
import it.uniroma2.ispw.model.Venditore;
import it.uniroma2.ispw.persistence.ProdottoDAO;
import it.uniroma2.ispw.persistence.UtenteDAO;
import it.uniroma2.ispw.session.UtenteSessione;


public class Test {



	public static void main(String[] args) {
		
		UtenteDAO u = new UtenteDAO();
		UtenteRegistrato urCons = u.getUtente("giorgioiannone@gmail.com");
		UtenteRegistrato urVend = u.getUtente("giannino@hotmail.it");
		
		if (urCons instanceof Ente) System.out.println("ente");
		/*
		UtenteRegistrato ur = new Venditore("nickname","ilnome","ilcognome","unamail","pass","73476","addovivo");
		Prodotto p = new Prodotto("iphone 10","Elettronica","Cellulari", 433, 10, ur, 1, "commento blabla");
		List<Prodotto> lp = new ArrayList<Prodotto>();
		lp.add(p);
		ur.setProdotti(lp);
		u.addUtente(ur);*/
		
		/*
		rodotto(String nome, String categoria, String tipologia, int prezzo, 
				int sconto, UtenteRegistrato utenteRegistrato, int disponibilita, String commento){
			this.nome = nome;*/
		
		
		List<Prodotto> listProd = null;
		listProd = urVend.getProdotti();
		
		AcquistaProdotto ap = new AcquistaProdotto();
		
		PagamentoBean pb = new PagamentoBean();
		pb.setMetodoPag("Carta");
		pb.setNumeroCarta("b43hgt6t4");
		pb.setScadenzaCarta("2019");
		pb.setNumeroDiSicurezza("1234");
		
		ap.effettuaAcquisto(listProd, "Normale", urCons, pb, "Cassino");
		
		
		

	
	

	}


}