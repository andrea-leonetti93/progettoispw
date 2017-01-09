package it.uniroma2.ispw.bean;

import it.uniroma2.ispw.controller.GestisciUtente;
import it.uniroma2.ispw.model.UtenteRegistrato;

public class UpdateUtenteBean {
	
    private String name;
    private String surname;
    private String password;
    private String rippassword;
    private String telephone;
    private String street;
	
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRippassword() {
		return rippassword;
	}
	public void setRippassword(String rippassword) {
		this.rippassword = rippassword;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
	public boolean getUtente(String email){
		
		GestisciUtente gu = new GestisciUtente();
		
		UtenteRegistrato ur = gu.visualizzaInformazioni(email);
		
		if (ur != null){
			this.name = ur.getNome();
			this.surname = ur.getCognome();
			this.password = ur.getPassword();
			this.rippassword = ur.getPassword();
			this.street = ur.getResidenza();
			this.telephone = ur.getTelefono();
			return true;
		}
		
		return false;
		
	}
	


}