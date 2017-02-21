package it.uniroma2.ispw.laptopBean;

import it.uniroma2.ispw.controller.GestioneSistema;

public class RegistrazioneLaptopBean {

	String nome;
	String cognome;
	String email;
	String password;
	String ruolo;
	
	public RegistrazioneLaptopBean(){
		this.nome = "";
		this.cognome = "";
		this.email = "";
		this.password = "";
		this.ruolo = "";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
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

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	
	
	public boolean eseguiRegistrazione(){
		
		GestioneSistema gs = GestioneSistema.getInstance();
		if(gs.aggiungiAmministratore(this)){
			return true;
		}
		return false;
	}
}
