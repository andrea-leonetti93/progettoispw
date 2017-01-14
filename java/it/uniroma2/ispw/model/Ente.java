package it.uniroma2.ispw.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "ente")
public class Ente extends Consumatore {

	public Ente(){
		super();
	}
	
	public Ente(String userid, String nome, String cognome, String email, String password,
			String telefono, String residenza){
		super(userid, nome, cognome, email, password, telefono, residenza);
	}
}
