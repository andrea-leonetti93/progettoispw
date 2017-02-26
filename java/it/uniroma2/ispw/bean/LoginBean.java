package it.uniroma2.ispw.bean;

import it.uniroma2.ispw.controller.GestisciUtente;
import it.uniroma2.ispw.eccezioni.ErroreEffettuaLogin;
import it.uniroma2.ispw.session.UtenteSessione;

public class LoginBean {
	
	private String email;
    private String password;
    
    private String userid;
    private int typeUser; /*1 venditore, 2 consumatore*/
    private boolean enteB;
	
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
    
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getTypeUser() {
		return typeUser;
	}
	public void setTypeUser(int type) {
		this.typeUser = type;
	}
	public boolean isEnteB() {
		return enteB;
	}
	public void setEnteB(boolean enteB) {
		this.enteB = enteB;
	}
	
	public UtenteSessione validate() throws ErroreEffettuaLogin{
        
        GestisciUtente gu = GestisciUtente.getInstance();
        UtenteSessione us = null;
        
        if ( gu.effettuaLogin(this)){
        	//login effettuato
        	us = new UtenteSessione();
        	us.setEmail(email);
        	us.setPassword(password);
        	us.setType(typeUser);
        	us.setUserid(userid);
        	us.setEnteB(enteB);
        	
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
