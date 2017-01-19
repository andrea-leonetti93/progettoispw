package it.uniroma2.ispw.controller;



import it.uniroma2.ispw.model.Amministratore;
import it.uniroma2.ispw.model.Consumatore;
import it.uniroma2.ispw.model.Ente;
import it.uniroma2.ispw.model.UtenteRegistrato;
import it.uniroma2.ispw.model.Venditore;
import it.uniroma2.ispw.persistence.AmministratoreDAO;
import it.uniroma2.ispw.persistence.UtenteDAO;
import it.uniroma2.ispw.session.UtenteSessione;

public class GestisciUtente {

	UtenteDAO u = new UtenteDAO();
	
	protected GestisciUtente(){}
	
	private static GestisciUtente instance;
	 
    public static GestisciUtente getInstance() {
        if (instance == null)
            instance = new GestisciUtente();
        return instance;
    }
	
	
	public UtenteRegistrato effettuaLogin(String email, String password){
		
		UtenteRegistrato ur = null;
		ur = u.checkUtente(email, password);
		return ur;
	}
	
	public Amministratore loginAmministratore(String email, String password){
		Amministratore admin = null;
		
		AmministratoreDAO ammDAO = new AmministratoreDAO();
		return ammDAO.checkAmministratore(email, password);
		
		
	}
	
	/* 1 ok, 2 mail in uso, 3 userid in uso*/
	public int effettuaRegistrazione(String userid, String name, String surname, String email, String password, String telephone, String street, int type){
		
		UtenteRegistrato newUtente = null;
		
		if (u.getUtente(email)!=null) return 2;
		if (u.getUtenteByUserid(userid)!=null) return 3;
		
		if(type == 1){
			newUtente = new Venditore(userid , name, surname, email , password, telephone, street);
			u.addUtente(newUtente);
		}else if(type==2){
			newUtente = new Consumatore(userid , name, surname, email , password, telephone, street);
			u.addUtente(newUtente);
		}
		else if(type==3){
			newUtente = new Ente(userid , name, surname, email , password, telephone, street);
			u.addUtente(newUtente);
			
		}
		
		return 1;
	}
	
	public UtenteRegistrato modificaInformazioni(String userid, String name, String surname, String email, String password, String telephone, String street, int type){
		
		UtenteRegistrato newUtente = null;
		
		if(type==1){
			newUtente = new Venditore(userid , name, surname, email , password, telephone, street);
			u.modificaUtente(newUtente);
		}else if(type==2){
			newUtente = new Consumatore(userid , name, surname, email , password, telephone, street);
			u.modificaUtente(newUtente);
		}
		
		return newUtente;
		
	}
	
	public UtenteRegistrato visualizzaInformazioni(String email){
		
		UtenteRegistrato newUtente = null;
		
		newUtente = u.getUtente(email);
		
		return newUtente;
		
		
	}
	
	
	
	

}
