package it.uniroma2.ispw.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma2.ispw.bean.InsProdottoBean;
import it.uniroma2.ispw.bean.LoginBean;
import it.uniroma2.ispw.bean.RegistrazioneBean;
import it.uniroma2.ispw.controller.GestisciProdotto;
import it.uniroma2.ispw.controller.GestisciUtente;
import it.uniroma2.ispw.session.UtenteSessione;

public class ProdottoTest {
	
	@Before
	public void verificaPresenzaUtente(){
		
		RegistrazioneBean registrazioneBean = new RegistrazioneBean();
		registrazioneBean.setName("Giuseppe");
		registrazioneBean.setUserid("giusep78");
		registrazioneBean.setSurname("Lombardi");
		registrazioneBean.setPassword("passworddigiuseppe");
		registrazioneBean.setEmail("giulombardi@gmail.com");
		registrazioneBean.setTelephone("345742493");
		registrazioneBean.setStreet("Bari");
		registrazioneBean.setType("1");
		
		registrazioneBean.effettuaRegistrazione();
		
	}
	
	@Test
	public void inserimentoProdotto(){
		
		LoginBean loginBean = new LoginBean();
		loginBean.setEmail("giulombardi@gmail.com");
		loginBean.setPassword("passworddigiuseppe");
		
		UtenteSessione us = loginBean.validate();
		
		if (us==null) {
			assertTrue("impossibile reperire l'utente", false);
			return;
		}
		
		InsProdottoBean insProdottoBean = new InsProdottoBean();
		insProdottoBean.setCategory("Elettronica");
		insProdottoBean.setComment("bel telefono, ottima fotocamera da 20mpx, usato poco.");
		insProdottoBean.setDisponibilita(1);
		insProdottoBean.setNameProduct("Samsung Galaxy s6");
		insProdottoBean.setPrice(280);
		insProdottoBean.setSale(10);
		insProdottoBean.setTypology("Cellulari");
		insProdottoBean.setUtente(us);
		
		boolean inserimentoProdotto =  insProdottoBean.acquisisciProdotto();
		
		assertTrue("errore inserimento prodotto", inserimentoProdotto);
		
		
	}
	
	@After
	public void eliminazioneProdotto(){
		
		GestisciProdotto gp = GestisciProdotto.getInstance();
		
		LoginBean loginBean = new LoginBean();
		loginBean.setEmail("giulombardi@gmail.com");
		loginBean.setPassword("passworddigiuseppe");
		
		UtenteSessione us = loginBean.validate();
		
		if (us==null) {
			assertTrue("impossibile reperire l'utente", false);
			return;
		}
		
		InsProdottoBean insProdottoBean = new InsProdottoBean();
		insProdottoBean.setUtente(us);
		
		insProdottoBean.riempiLista(us.getEmail());
		
		if (insProdottoBean.getArrayProdotti().size()!=0)
				insProdottoBean.getArrayProdotti().get(0).eliminaProdotto();
		
		
	}
	

}
