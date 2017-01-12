package it.uniroma2.ispw.bean;

import it.uniroma2.ispw.controller.AcquistaProdotto;
import it.uniroma2.ispw.model.Prodotto;
import it.uniroma2.ispw.model.UtenteRegistrato;

public class AcquistoBean {

	
	private int idOrdine;
	private int prezzoFinale;
	private String metodoPagamento;
	private UtenteRegistrato utenteReg;
	private Prodotto prodotto;
	
	public AcquistoBean(){
		this.idOrdine = 0;
		this.prezzoFinale = 0;
		this.metodoPagamento = "";
		this.utenteReg = null;
		this.prodotto = null;
	}

	public int getIdOrdine() {
		return idOrdine;
	}

	public void setIdOrdine(int idOrdine) {
		this.idOrdine = idOrdine;
	}

	public int getPrezzoFinale() {
		return prezzoFinale;
	}

	public void setPrezzoFinale(int prezzoFinale) {
		this.prezzoFinale = prezzoFinale;
	}

	public String getMetodoPagamento() {
		return metodoPagamento;
	}

	public void setMetodoPagamento(String metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}

	public UtenteRegistrato getUtenteReg() {
		return utenteReg;
	}

	public void setUtenteReg(UtenteRegistrato utenteReg) {
		this.utenteReg = utenteReg;
	}

	public Prodotto getProdotto() {
		return prodotto;
	}

	public void setProdotto(Prodotto prodotto) {
		this.prodotto = prodotto;
	}
	
	
	public boolean iniziaAcquisto(){
		
		AcquistaProdotto ap = new AcquistaProdotto();
		//ap.
		return true;
	}
	
}
