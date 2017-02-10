package it.uniroma2.ispw.bean;

import java.util.List;

import it.uniroma2.ispw.controller.AcquistaProdotto;
import it.uniroma2.ispw.model.Pagamento;
import it.uniroma2.ispw.model.UtenteRegistrato;

public class PagamentoBean {

	private List<Pagamento> listaPag;
	private String metodoPag;
	private String numeroCarta;
	private String scadenzaCarta;
	private String numeroDiSicurezza;
	
	private String codiceIBAN;
	private String causale;
	private UtenteRegistrato ur;
	
	public PagamentoBean(){
		this.metodoPag = "";
		this.numeroCarta = "";
		this.scadenzaCarta = "";
		this.numeroDiSicurezza = "";
		this.codiceIBAN = "";
		this.causale = "";
		this.listaPag = null;
	}


	public String getMetodoPag() {
		return metodoPag;
	}

	public void setMetodoPag(String metodoPag) {
		this.metodoPag = metodoPag;
	}

	public String getNumeroCarta() {
		return numeroCarta;
	}

	public void setNumeroCarta(String numeroCarta) {
		this.numeroCarta = numeroCarta;
	}

	public String getScadenzaCarta() {
		return scadenzaCarta;
	}

	public void setScadenzaCarta(String scadenzaCarta) {
		this.scadenzaCarta = scadenzaCarta;
	}

	public String getNumeroDiSicurezza() {
		return numeroDiSicurezza;
	}

	public void setNumeroDiSicurezza(String numeroDiSicurezza) {
		this.numeroDiSicurezza = numeroDiSicurezza;
	}

	public String getCodiceIBAN() {
		return codiceIBAN;
	}

	public void setCodiceIBAN(String codiceIBAN) {
		this.codiceIBAN = codiceIBAN;
	}

	public String getCausale() {
		return causale;
	}

	public void setCausale(String causale) {
		this.causale = causale;
	}

	public UtenteRegistrato getUr() {
		return ur;
	}

	public void setUr(UtenteRegistrato ur) {
		this.ur = ur;
	}


	public List<Pagamento> getListaPag() {
		return listaPag;
	}


	public void setListaPag(List<Pagamento> listaPag) {
		this.listaPag = listaPag;
	}
	
	public void popolaLista(String email){
		
		AcquistaProdotto ap = AcquistaProdotto.getInstance();
		listaPag = ap.acquistiUtente(email);
	}
	
}
