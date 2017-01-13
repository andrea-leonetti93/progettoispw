package it.uniroma2.ispw.bean;

import java.util.List;

import it.uniroma2.ispw.controller.GestisciRicerca;
import it.uniroma2.ispw.model.Prodotto;
import it.uniroma2.ispw.model.PropostaVendita;

public class RicercaBean {
	
	private List<PropostaVendita> lpv;
	private String categoria;
	private String tipologia;
	private String nomeRicerca;
	private int prezzomin;
	private int prezzomax;
	private int idProdotto;
	
	
	public int getIdProdotto() {
		return idProdotto;
	}

	public void setIdProdotto(int idProdotto) {
		this.idProdotto = idProdotto;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public String getNomeRicerca() {
		return nomeRicerca;
	}

	public void setNomeRicerca(String nomeRicerca) {
		this.nomeRicerca = nomeRicerca;
	}

	public int getPrezzomin() {
		return prezzomin;
	}

	public void setPrezzomin(int prezzomin) {
		this.prezzomin = prezzomin;
	}

	public int getPrezzomax() {
		return prezzomax;
	}

	public void setPrezzomax(int prezzomax) {
		this.prezzomax = prezzomax;
	}

	public List<PropostaVendita> getLpv() {
		return lpv;
	}

	public void setLpv(List<PropostaVendita> lpv) {
		this.lpv = lpv;
	}
	
	public void ricercaProdotto(){
		
		GestisciRicerca gr = GestisciRicerca.getInstance();
		
		lpv = gr.ricercaProdotto(nomeRicerca, categoria, tipologia, prezzomin, prezzomax);
		
		
		
	}
	
	
	
	

}
