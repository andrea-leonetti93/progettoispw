package it.uniroma2.ispw.laptopBean;

import it.uniroma2.ispw.controller.GestioneSistema;

public class LoginLaptopBean {

	String email;
	String password;
	
	public LoginLaptopBean(){
		this.email = "";
		this.password = "";
	}

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
	
	public boolean validaAmministratore(){
		
		GestioneSistema gu = GestioneSistema.getInstance();
		if(gu.effettuaLoginAdmin(this)){
			return true;
		}
		return false;
	}
	
}
