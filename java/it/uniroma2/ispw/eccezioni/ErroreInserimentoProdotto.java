package it.uniroma2.ispw.eccezioni;

public class ErroreInserimentoProdotto extends EccezioniProdotti{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ErroreInserimentoProdotto(){
		super("Prodotto con lo stesso nome già inserito!");
	}

	
}
