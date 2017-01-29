package it.uniroma2.ispw.bean;

import it.uniroma2.ispw.controller.GestisciUtente;
import it.uniroma2.ispw.model.UtenteRegistrato;
import it.uniroma2.ispw.model.Venditore;

public class UpdateUtenteBean {
	
    private String name;
    private String surname;
    private String password;
    private String rippassword;
    private String telephone;
    private String street;
    private int type;
	
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
	
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public boolean getUtente(String email){
		
		GestisciUtente gu = GestisciUtente.getInstance();
		return gu.visualizzaInformazioni(email, this);
		
		/*
		if (ur != null){
			this.name = ur.getNome();
			this.surname = ur.getCognome();
			this.password = ur.getPassword();
			this.rippassword = ur.getPassword();
			this.street = ur.getResidenza();
			this.telephone = ur.getTelefono();
			if(ur instanceof Venditore){
				this.type=1;
			}
			else this.type=2;
			return true;
		}
		
		return false;*/
		
	}
	
	//ok;
	public boolean controlloCampi(){
		
		return (this.password.equals(this.rippassword));
	}
	
	//ok;
	public boolean updateUtente(String userid, String email){
    	
    	GestisciUtente gu = GestisciUtente.getInstance();
    	
    	UtenteRegistrato ur = null;
    	
    	return gu.modificaInformazioni(userid, name, surname, email, password, telephone, street, type);
    }
	


}