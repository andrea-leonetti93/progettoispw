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
        
        return gu.effettuaLogin(this.email, this.password);
        
    }
	
	public String controlloCampi(){
		
		if (this.email==null) return "Inserisci una email";
		if (this.email.equals("")) return "Inserisci una email";
		
		if (this.password==null) return "Inserisci una password";
		if (this.email.equals("")) return "Inserisci una password";
		
		return null;
		
		
		
	}
    

}
