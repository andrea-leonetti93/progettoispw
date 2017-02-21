package it.uniroma2.ispw.laptopBean;



public class LineaOrdineLaptopBean {

	private int idLineaOrdine;
	private int prezzoLinea;
	private String emailVenditore; //da prodotto
	private String  nomeProdotto;

	public LineaOrdineLaptopBean(){
		this.idLineaOrdine = 0;
		this.prezzoLinea = 0;
		this.emailVenditore = "";
		this.nomeProdotto = "";
	}

	public int getIdLineaOrdine() {
		return idLineaOrdine;
	}

	public void setIdLineaOrdine(int idLineaOrdine) {
		this.idLineaOrdine = idLineaOrdine;
	}

	public int getPrezzoLinea() {
		return prezzoLinea;
	}

	public void setPrezzoLinea(int prezzoLinea) {
		this.prezzoLinea = prezzoLinea;
	}

	public String getEmailVenditore() {
		return emailVenditore;
	}

	public void setEmailVenditore(String emailVenditore) {
		this.emailVenditore = emailVenditore;
	}

	public String getNomeProdotto() {
		return nomeProdotto;
	}

	public void setNomeProdotto(String nomeProdotto) {
		this.nomeProdotto = nomeProdotto;
	}
	
}
