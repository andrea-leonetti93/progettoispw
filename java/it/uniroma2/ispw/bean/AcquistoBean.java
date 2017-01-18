package it.uniroma2.ispw.bean;

import java.util.ArrayList;
import java.util.List;
import it.uniroma2.ispw.controller.AcquistaProdotto;
import it.uniroma2.ispw.factory.FactorySpedizione;
import it.uniroma2.ispw.model.Ente;
import it.uniroma2.ispw.model.Pagamento;
import it.uniroma2.ispw.model.Prodotto;
import it.uniroma2.ispw.model.Spedizione;
import it.uniroma2.ispw.model.UtenteRegistrato;
import it.uniroma2.ispw.prezzo.PrezzoFinale;
import it.uniroma2.ispw.prezzo.PrezzoFinaleConsumatore;
import it.uniroma2.ispw.prezzo.PrezzoFinaleEnte;

public class AcquistoBean {

	/* input per caso d'uso */
	private List<Prodotto> prodotti = new ArrayList<Prodotto>();
	private String tipoSpedizione;
	private UtenteRegistrato utenteReg;
	private PagamentoBean pagBean;
	private String recapito;
	
	/*da visualizzare*/
	private int prezzoNonScontato = 0;
	private int prezzoScontato = 0;
	private int prezzoSpedizione = 0;
	private int prezzoFinale = 0;
	private int scontoEnte = 0;

	public AcquistoBean(){
		this.prodotti = null;
		this.tipoSpedizione = "";
		this.utenteReg = null;
		this.pagBean = null;
		this.recapito = "";
		prezzoNonScontato = 0;
		prezzoScontato = 0;
		prezzoSpedizione = 0;
		prezzoFinale = 0;
		scontoEnte = 0;
	}
	
	
	
	
	public List<Prodotto> getProdotti() {
		return prodotti;
	}

	public void setProdotti(List<Prodotto> prodotti) {
		this.prodotti = prodotti;
	}

	public String getTipoSpedizione() {
		return tipoSpedizione;
	}

	public void setTipoSpedizione(String tipoSpedizione) {
		this.tipoSpedizione = tipoSpedizione;
	}

	public UtenteRegistrato getUtenteReg() {
		return utenteReg;
	}

	public void setUtenteReg(UtenteRegistrato utenteReg) {
		this.utenteReg = utenteReg;
	}

	public PagamentoBean getPagBean() {
		return pagBean;
	}

	public void setPagBean(PagamentoBean pagBean) {
		this.pagBean = pagBean;
	}

	public String getRecapito() {
		return recapito;
	}

	public void setRecapito(String recapito) {
		this.recapito = recapito;
	}
	
	
	


	public int getScontoEnte() {
		return scontoEnte;
	}




	public void setScontoEnte(int scontoEnte) {
		this.scontoEnte = scontoEnte;
	}




	public int getPrezzoNonScontato() {
		return prezzoNonScontato;
	}




	public void setPrezzoNonScontato(int prezzoNonScontato) {
		this.prezzoNonScontato = prezzoNonScontato;
	}




	public int getPrezzoScontato() {
		return prezzoScontato;
	}




	public void setPrezzoScontato(int prezzoScontato) {
		this.prezzoScontato = prezzoScontato;
	}




	public int getPrezzoSpedizione() {
		return prezzoSpedizione;
	}




	public void setPrezzoSpedizione(int prezzoSpedizione) {
		this.prezzoSpedizione = prezzoSpedizione;
	}




	public int getPrezzoFinale() {
		return prezzoFinale;
	}




	public void setPrezzoFinale(int prezzoFinale) {
		this.prezzoFinale = prezzoFinale;
	}




	public boolean iniziaAcquisto(){
		
		AcquistaProdotto ap = new AcquistaProdotto();
		return ap.effettuaAcquisto(prodotti, tipoSpedizione, utenteReg, pagBean, recapito);
	}
	
	public void compilaPrezzi(){
		
		for (Prodotto p : prodotti){
			prezzoNonScontato += p.getPrezzo();
		}
		
		PrezzoFinale pf;
		if (utenteReg instanceof Ente){
			pf = new PrezzoFinaleEnte();
		}
		else{
			pf = new PrezzoFinaleConsumatore();
		}
		
		for (Prodotto p : prodotti){
			prezzoScontato += pf.calcolaPrezzoFinale(p);
		}
		scontoEnte = prezzoNonScontato - prezzoScontato;
		
		FactorySpedizione fs = new FactorySpedizione();
		Spedizione sped = fs.creaSpedizione(tipoSpedizione);
		prezzoSpedizione = sped.calcolaCostoSpedizione(prodotti.size());
		
		prezzoFinale = prezzoScontato + prezzoSpedizione;
	}
}
