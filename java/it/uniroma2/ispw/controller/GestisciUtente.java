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
	AmministratoreDAO ad = new AmministratoreDAO();
	
	protected GestisciUtente(){}
	
	private static GestisciUtente instance;
	 
    public static GestisciUtente getInstance() {
        if (instance == null)
            instance = new GestisciUtente();
        return instance;
    }
	
	
	public UtenteSessione effettuaLogin(String email, String password){
		
		UtenteSessione us = new UtenteSessione();
		UtenteRegistrato ur = null;
		
		System.out.println("Entrato in effettualogin");
		if((ur = u.checkUtente(email, password)) != null){
			
			if(ur instanceof Venditore){
				us.setEmail(ur.getEmail());
				us.setType(1);
				us.setUserid(ur.getUserid());
				us.setPassword(ur.getPassword());
				us.setEnteB(false);
				return us;
			}
			
			else if(ur instanceof Consumatore){
				us.setEmail(ur.getEmail());
				us.setType(2);
				us.setUserid(ur.getUserid());
				us.setPassword(ur.getPassword());
				
				if (ur instanceof Ente) us.setEnteB(true);
				else us.setEnteB(false);
				return us;
			}
		}
		
		return null;
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
	
	
	public Amministratore effettuaLoginAdmin(String email, String password){
		Amministratore admin = null;
		if((admin = ad.checkamministratore(email, password))!=null){
			return admin;
		}
		return null;
	}
	
}
