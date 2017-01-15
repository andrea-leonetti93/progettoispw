package it.uniroma2.ispw.bean;

import java.util.List;
import it.uniroma2.ispw.controller.AcquistaProdotto;
import it.uniroma2.ispw.model.Pagamento;
import it.uniroma2.ispw.model.Prodotto;
import it.uniroma2.ispw.model.UtenteRegistrato;

public class AcquistoBean {

	private List<Prodotto> prodotti;
	private String tipoSedizione;
	private UtenteRegistrato utenteReg;
	private PagamentoBean pagBean;
	private String recapito;

	public AcquistoBean(){
		this.prodotti = null;
		this.tipoSedizione = "";
		this.utenteReg = null;
		this.pagBean = null;
		this.recapito = "";
	}
	
	
	public List<Prodotto> getProdotti() {
		return prodotti;
	}

	public void setProdotti(List<Prodotto> prodotti) {
		this.prodotti = prodotti;
	}

	public String getTipoSedizione() {
		return tipoSedizione;
	}

	public void setTipoSedizione(String tipoSedizione) {
		this.tipoSedizione = tipoSedizione;
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


	public boolean iniziaAcquisto(){
		
		AcquistaProdotto ap = new AcquistaProdotto();
		if(ap.acquistaProdotto(prezzoFinale, metodoPagamento, utenteReg, prodotto)){
			return true;
		}
		return true;
	}
}
