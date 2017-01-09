package it.uniroma2.ispw.model;

//import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue(value = "consumatore")
public class Consumatore extends UtenteRegistrato{

	public Consumatore(){
		super();
	}
	
	public Consumatore(String userid, String nome, String cognome, String email, String password,
			String telefono, String residenza){
		super(userid, nome, cognome, email, password, telefono, residenza);
	}
}
