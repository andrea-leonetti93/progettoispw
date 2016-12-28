package it.uniroma2.ispw.bean;

import it.uniroma2.ispw.controller.GestisciUtente;
import it.uniroma2.ispw.model.UtenteRegistrato;


public class UtenteBean {
	



    private String name;
    private String surname;
    private String email;
    private String password;
    private String telephone;
    private String street;
    private String type;

    
    public UtenteBean(){
		this.name="";
		this.surname="";
		this.email="";
		this.password="";
		this.telephone="";
		this.street="";
		this.type="";
	}
    
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getTelephone() {
        return telephone;
    }
    public String getStreet() {
        return street;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
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
     
    public boolean validate(){
         
        System.out.println("entrato in validate");
         
        GestisciUtente gu = GestisciUtente.getInstance();
         
        UtenteRegistrato ur = null;
         
        ur = gu.effettuaRegistrazione(this);
        if (ur == null){
            return false;
        }
         
        return true;
    }
}
