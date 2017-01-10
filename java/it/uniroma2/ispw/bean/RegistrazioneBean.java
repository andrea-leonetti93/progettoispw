package it.uniroma2.ispw.bean;

import it.uniroma2.ispw.controller.GestisciUtente;
import it.uniroma2.ispw.model.UtenteRegistrato;

public class RegistrazioneBean {
	
	private String userid;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String rippassword;
    private String telephone;
    private String street;
    private String type;
    private String regcheck;
    
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
	
	public String getRippassword() {
		return rippassword;
	}
	public void setRippassword(String rippassword) {
		this.rippassword = rippassword;
	}
	/* 1 ok, 2 mail in uso, 3 userid in uso */
	public int effettuaRegistrazione(){
	    	
		int numerictype = 0;
		if (type.equals("Venditore")) numerictype = 1;
		else if (type.equals("Consumatore")) numerictype = 2;
	    	
		GestisciUtente gu = GestisciUtente.getInstance();
	    return gu.effettuaRegistrazione(userid, name, surname, email, password, telephone, street, numerictype);
	   
	}
	
	public String controlloCampi(){
		
		if (this.userid == null) return "Inserisci un userid";
		if (this.userid.equals("")) return "Inserisci un userid";
		
		if (this.name == null) return "Inserisci un nome";
		if (this.name.equals("")) return "Inserisci un nome";
		
		if (this.surname == null) return "Inserisci un cognome";
		if (this.surname.equals("")) return "Inserisci un cognome";
		
		if (this.email == null) return "Inserisci una email";
		if (this.email.equals("")) return "Inserisci un email";
		
		if (this.userid == null) return "Inserisci un userid";
		if (this.userid.equals("")) return "Inserisci un userid";
		
		if (this.password == null) return "Inserisci una password";
		if (this.password.equals("")) return "Inserisci una password";
		
		if (this.rippassword == null) return "Inserisci una password";
		if (this.rippassword.equals("")) return "Inserisci una password";
		
		if (this.telephone == null) return "Inserisci un telefono";
		if (this.telephone.equals("")) return "Inserisci un telefono";
		
		if (this.street == null) return "Inserisci una via";
		if (this.street.equals("")) return "Inserisci una via";
		
		if (this.userid == null) return "Inserisci un userid";
		if (this.userid.equals("")) return "Inserisci un userid";
		
		if (this.password.equals(this.rippassword)) return "Le 2 pass non coincidono";
		
		if (type==null) return "Scegli un utente";
		
		if (this.regcheck==null) return "Accetta il regolamento";
		
		return null;
		
	}

}
