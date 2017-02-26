package it.uniroma2.ispw.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import it.uniroma2.ispw.bean.RegistrazioneBean;
import it.uniroma2.ispw.eccezioni.ErroreInserimentoCredenziali;
import it.uniroma2.ispw.model.Consumatore;
import it.uniroma2.ispw.persistence.UtenteDAO;

public class RegistrazioneTest {
	
	@Test
	public void registrazione(){
		
		RegistrazioneBean registrazioneBean = new RegistrazioneBean();
		registrazioneBean.setName("Matteo");
		registrazioneBean.setUserid("matt93");
		registrazioneBean.setSurname("Ferrari");
		registrazioneBean.setPassword("passworddimatteo");
		registrazioneBean.setEmail("matteoferrari@gmail.com");
		registrazioneBean.setTelephone("345728493");
		registrazioneBean.setStreet("Firenze");
		registrazioneBean.setType("2");
		
		int reg = 0;
		try {
			reg = registrazioneBean.effettuaRegistrazione();
		} catch (ErroreInserimentoCredenziali e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean esitoRegistrazione;
		
		if (reg==1) esitoRegistrazione = true;
		else esitoRegistrazione = false;
		
		assertTrue("registrazione fallita", esitoRegistrazione);
		
	}
	
	@After
	public void eliminazioneUtente(){
		
		UtenteDAO uDAO = new UtenteDAO();
		
		Consumatore utenteR = new Consumatore("matt93","Matteo","Ferrari",
				"matteoferrari@gmail.com","passworddimatteo","345728493","Firenze");
		
		uDAO.deleteUtente(utenteR);
	}

}
