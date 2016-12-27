package it.uniroma2.ispw.controller;


import it.uniroma2.ispw.model.Consumatore;
import it.uniroma2.ispw.model.Venditore;
import it.uniroma2.ispw.persistence.UtenteDAO;

public class GestisciUtente {

	UtenteDAO u = new UtenteDAO();
	
	public boolean effettuaLogin(String email, String password){
		
		if(u.checkUtente(email, password) == true){
			return true;
		}
		return false;
	}
	
	
	public boolean effettuaRegistrazione(String nome, String cognome, String email, String password, 
			String telefono, String residenza, String type){
		int a = 5;
		if(u.checkUtente(email, password) == true){
			return false;
		}
		if(type.equals("Venditore")){
			Venditore newUtente = new Venditore(nome, cognome, email, password, telefono, residenza);
			u.addUtente(newUtente);
		}else if(type.equals("Consumatore")){
			Consumatore newUtente = new Consumatore(nome, cognome, email, password, telefono, residenza);
			u.addUtente(newUtente);
		}
		return true;
	}

}
