package it.uniroma2.ispw.eccezioni;

public class ErroreInserimentoCredenziali extends EccezioniUtente{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ErroreInserimentoCredenziali(){
		super("Username già utilizzato!");
	}

	
}
