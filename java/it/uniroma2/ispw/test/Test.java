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
import it.uniroma2.ispw.model.Consumatore;
import it.uniroma2.ispw.model.Ente;
import it.uniroma2.ispw.model.Ordine;
import it.uniroma2.ispw.model.Prodotto;
import it.uniroma2.ispw.model.PropostaVendita;
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
	
		rammDAO.addAmministratore(ruoloAmm);
		
		amm.setRuoloAmministrazione(ruoloAmm);

		ammDAO.addAmministratore(amm);
		
		GestisciUtente gu = GestisciUtente.getInstance();
		
		if (gu.loginAmministratore("giorgioiannone@hotmail.it","lamiapassword")!=null){
			System.out.println("login effettuato");
		}
		else{
			System.out.println("login NON effettuato");
		}
	
	

	}


}