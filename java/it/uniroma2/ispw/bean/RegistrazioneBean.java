package it.uniroma2.ispw.bean;

import it.uniroma2.ispw.controller.GestisciUtente;
import it.uniroma2.ispw.model.UtenteRegistrato;

public class RegistrazioneBean {
	
	private String userid;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String telephone;
    private String street;
    private String type;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
    
	 
	/* 1 ok, 2 mail in uso, 3 userid in uso */
	public int effettuaRegistrazione(){
	    	
		int numerictype = 0;
		if (type.equals("Venditore")) numerictype = 1;
		else if (type.equals("Consumatore")) numerictype = 2;
	    	
		GestisciUtente gu = GestisciUtente.getInstance();
	    return gu.effettuaRegistrazione(userid, name, surname, email, password, telephone, street, numerictype);
	   
	}

}
