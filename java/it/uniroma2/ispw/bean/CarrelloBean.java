package it.uniroma2.ispw.bean;

import java.util.ArrayList;
import java.util.List;

import it.uniroma2.ispw.controller.AcquistaProdotto;
import it.uniroma2.ispw.model.Prodotto;
import it.uniroma2.ispw.model.PropostaVendita;
import it.uniroma2.ispw.model.UtenteRegistrato;

public class CarrelloBean {

	
	private List<PropostaVendita> listaPropVend;
	
	public CarrelloBean(){
		this.listaPropVend = new ArrayList<PropostaVendita>();
	}

	public List<PropostaVendita> getListaPropVend() {
		return listaPropVend;
	}

	public void setListaPropVend(List<PropostaVendita> listaPropVend) {
		this.listaPropVend = listaPropVend;
	}



	public boolean iniziaAcquisto(){
		
		AcquistaProdotto ap = new AcquistaProdotto();
		if(ap.acquistaProdotto(prezzoFinale, metodoPagamento, utenteReg, prodotto)){
			return true;
		}
		return true;
	}
	
}
