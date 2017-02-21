package it.uniroma2.ispw.model;


//import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "venditore")
public class Venditore extends UtenteRegistrato{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Venditore(){
		super();
	}
	public Venditore(String userid, String nome, String cognome, String email, String password, 
			String telefono, String residenza){
		super(userid, nome, cognome, email, password, telefono, residenza);
	}
}
