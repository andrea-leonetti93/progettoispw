package it.uniroma2.ispw.eccezioni;

public class ErroreEffettuaLogin extends EccezioniUtente{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ErroreEffettuaLogin(){
		super("Campi email e password non validi! Riprovare...");
	}
}
