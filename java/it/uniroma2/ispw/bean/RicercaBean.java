package it.uniroma2.ispw.bean;

import java.util.List;

import it.uniroma2.ispw.controller.GestisciRicerca;


public class RicercaBean {
	
	private List<ProdottoBean> lpB;
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
	
	public List<ProdottoBean> getLpB() {
		return lpB;
	}

	public void setLpB(List<ProdottoBean> lpB) {
		this.lpB = lpB;
	}

	public void ricercaProdotto(){
		
		GestisciRicerca gr = GestisciRicerca.getInstance();
		
		lpB = gr.ricercaProdotto(nomeRicerca, categoria, tipologia, prezzomin, prezzomax);
	}
	
	
	
	

}
