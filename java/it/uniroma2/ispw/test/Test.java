package it.uniroma2.ispw.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.uniroma2.ispw.bean.PagamentoBean;
import it.uniroma2.ispw.bean.ProdottoBean;
import it.uniroma2.ispw.bean.RicercaBean;
import it.uniroma2.ispw.controller.AcquistaProdotto;
import it.uniroma2.ispw.controller.GestioneSistema;
import it.uniroma2.ispw.controller.GestisciProdotto;
import it.uniroma2.ispw.controller.GestisciRicerca;
import it.uniroma2.ispw.controller.GestisciUtente;

import it.uniroma2.ispw.model.Amministratore;
import it.uniroma2.ispw.model.AmministrazioneDiSistema;
import it.uniroma2.ispw.laptop.LoginFrame;
import it.uniroma2.ispw.model.Consumatore;
import it.uniroma2.ispw.model.Ente;
import it.uniroma2.ispw.model.Ordine;
import it.uniroma2.ispw.model.Prodotto;
import it.uniroma2.ispw.model.RuoloAmministrazione;
import it.uniroma2.ispw.model.UtenteRegistrato;
import it.uniroma2.ispw.model.Venditore;
import it.uniroma2.ispw.persistence.AmministratoreDAO;
import it.uniroma2.ispw.persistence.ProdottoDAO;
import it.uniroma2.ispw.persistence.RuoloAmministrazioneDAO;
import it.uniroma2.ispw.persistence.UtenteDAO;
import it.uniroma2.ispw.session.UtenteSessione;


public class Test {



	public static void main(String[] args) {
		

		Amministratore amm = new Amministratore("Giorgio","Iannone","giorgioiannone@hotmail.it","lamiapassword");
		
		AmministratoreDAO ammDAO = new AmministratoreDAO();
		RuoloAmministrazioneDAO rammDAO = new RuoloAmministrazioneDAO();
		
		AmministrazioneDiSistema ruoloAmm = new AmministrazioneDiSistema();
	
		rammDAO.addRuoloAmministratore(ruoloAmm);
		
		amm.setRuoloAmministrazione(ruoloAmm);

		ammDAO.addAmministratore(amm);
		
		//GestisciUtente gu = GestisciUtente.getInstance();

		/*
		GestisciProdotto gp = new GestisciProdotto();
		
		Prodotto p = gp.selezionaProdottoPerID(38);
		System.out.println(p.getPrezzo());
		gp.deleteProduct(38);*/
		

		//GestisciUtente gu = GestisciUtente.getInstance();
		//UtenteRegistrato ur = gu.visualizzaInformazioni("paolo@hotmail.it");
		
		/*
		UtenteRegistrato ur = new Venditore("paolino", "paolo", "paolocogn","paolo@hotmail.it", "paolopass","3458943","viapaolo");
		
		Prodotto p = new Prodotto("Samsung S5", "Elettronica","Cellulari",50,20, ur, 1, "buon telefono");
		
		
		ur.setProdotti(new ArrayList<Prodotto>());
		ur.getProdotti().add(p);
		
		UtenteDAO udao = new UtenteDAO();
		udao.addUtente(ur);*/
		
		//LoginFrame windows = new LoginFrame();
		
		/*
		if (gu.loginAmministratore("giorgioiannone@hotmail.it","lamiapassword")!=null){
			System.out.println("login effettuato");
		}
		else{
			System.out.println("login NON effettuato");
		}*/
	
	

	}


}