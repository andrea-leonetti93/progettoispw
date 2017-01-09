package it.uniroma2.ispw.bean;

import it.uniroma2.ispw.controller.GestisciUtente;
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
        
        return gu.effettuaLogin(email, password);
         
        
    }
    

}
