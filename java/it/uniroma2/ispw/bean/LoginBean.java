package it.uniroma2.ispw.bean;

import it.uniroma2.ispw.controller.GestisciUtente;
import it.uniroma2.ispw.model.Consumatore;
import it.uniroma2.ispw.model.Ente;
import it.uniroma2.ispw.model.UtenteRegistrato;
import it.uniroma2.ispw.model.Venditore;
import it.uniroma2.ispw.session.UtenteSessione;

public class LoginBean {
	
	private String email;
    private String password;
	
    public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
	public UtenteSessione validate(){
        
        GestisciUtente gu = GestisciUtente.getInstance();
        
        UtenteSessione us = null;
        UtenteRegistrato ur = null;
        ur = gu.effettuaLogin(this.email, this.password);
        
        if (ur!=null){
        	
        	us = new UtenteSessione();
        	
        	if(ur instanceof Venditore){
    			us.setEmail(ur.getEmail());
    			us.setType(1);
    			us.setUserid(ur.getUserid());
    			us.setPassword(ur.getPassword());
    			us.setEnteB(false);
    		}
    		
    		else if(ur instanceof Consumatore){
    			us.setEmail(ur.getEmail());
    			us.setType(2);
    			us.setUserid(ur.getUserid());
    			us.setPassword(ur.getPassword());
    			
    			if (ur instanceof Ente) us.setEnteB(true);
    			else us.setEnteB(false);
    		}
        }
        
        return us;
        
    }
	
	public String controlloCampi(){
		
		if (this.email==null) return "Inserisci una email";
		if (this.email.equals("")) return "Inserisci una email";
		
		if (this.password==null) return "Inserisci una password";
		if (this.email.equals("")) return "Inserisci una password";
		
		return null;
		
		
		
	}
    

}
