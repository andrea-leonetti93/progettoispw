package it.uniroma2.ispw.controller;



import it.uniroma2.ispw.bean.LoginBean;
import it.uniroma2.ispw.bean.UpdateUtenteBean;
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
	 
    public synchronized static GestisciUtente getInstance() {
        if (instance == null)
            instance = new GestisciUtente();
        return instance;
    }
	
	
	public synchronized boolean effettuaLogin(LoginBean loginBean){
		
		UtenteRegistrato ur = null;
		ur = u.checkUtente(loginBean.getEmail(), loginBean.getPassword());
		
		if (ur ==null) return false;
		
		loginBean.setUserid(ur.getUserid());
		
		if (ur instanceof Venditore) loginBean.setTypeUser(1);
		else{
			
			loginBean.setTypeUser(2);
			
			if (ur instanceof Ente) loginBean.setEnteB(true);
			else loginBean.setEnteB(false);
		}
		
		return true;
	}
	
	public synchronized Amministratore loginAmministratore(String email, String password){
		Amministratore admin = null;
		
		AmministratoreDAO ammDAO = new AmministratoreDAO();
		return ammDAO.checkAmministratore(email, password);
		
		
	}
	
	/* 1 ok, 2 mail in uso, 3 userid in uso*/
	public synchronized int effettuaRegistrazione(String userid, String name, String surname, String email, String password, String telephone, String street, int type){
		
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
	
	public synchronized boolean modificaInformazioni(String userid, String name, String surname, String email, String password, String telephone, String street, int type){
		
		UtenteRegistrato newUtente = null;
		
		if(type==1){
			newUtente = new Venditore(userid , name, surname, email , password, telephone, street);
			u.modificaUtente(newUtente);
		}else if(type==2){
			newUtente = new Consumatore(userid , name, surname, email , password, telephone, street);
			u.modificaUtente(newUtente);
		}
		
		if (newUtente==null) return false;
		return true;
		
	}
	
	public synchronized boolean visualizzaInformazioni(String email, UpdateUtenteBean updateUtenteBean){
		
		UtenteRegistrato ur = null;
		ur = u.getUtente(email);
		
		if (ur==null) return false;
		
		updateUtenteBean.setName(ur.getNome());
		updateUtenteBean.setSurname(ur.getCognome());
		updateUtenteBean.setPassword(ur.getPassword());
		updateUtenteBean.setRippassword(ur.getPassword());
		updateUtenteBean.setStreet(ur.getResidenza());
		updateUtenteBean.setTelephone(ur.getTelefono());
		if(ur instanceof Venditore){
			updateUtenteBean.setType(1);
		}
		else updateUtenteBean.setType(2);
		
		return true;
		
		
		
	
		
		
	}
	
	
	public synchronized Amministratore effettuaLoginAdmin(String email, String password){
		Amministratore admin = null;
		if((admin = ad.checkAmministratore(email, password))!=null){
			return admin;
		}
		return null;
	}
	
}
