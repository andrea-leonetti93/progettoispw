package it.uniroma2.ispw.test;


import it.uniroma2.ispw.bean.UpdateUtenteBean;
import it.uniroma2.ispw.controller.GestisciUtente;
import it.uniroma2.ispw.model.Consumatore;
import it.uniroma2.ispw.model.UtenteRegistrato;
import it.uniroma2.ispw.model.Venditore;
import it.uniroma2.ispw.persistence.UtenteDAO;


public class Test {

public static void main(String[] args) {
		
		//System.out.println("Sono un "+ c2.getType());
	/*
		Consumatore c1 = new Consumatore("Andrea", "Leonetti", "andrealeo09@gmail.com", "andrea", "01234", "via alamanni"); 
        Venditore v1 = new Venditore("Marco", "Grella", "marcogrella@gmail.com", "marco", "45678", "via ciao");		
        
        UtenteDAO u = new UtenteDAO();
        u.addUtente(c1);
        u.addUtente(v1);
        System.out.println("Utenti aggiunti");*/
	
		UpdateUtenteBean upub = new UpdateUtenteBean();
		
		upub.setName("giggio");
		
		upub.updateUtente("nick", "giorgioiannone@gmail.com");
	

		
	}
}
