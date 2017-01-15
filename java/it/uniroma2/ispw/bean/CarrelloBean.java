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
	
	public List<Prodotto> getListaProdotti(){
		List<Prodotto> lp = new ArrayList<Prodotto>();
		for (PropostaVendita pv: listaPropVend){
			lp.add(pv.getP());
		}
		return lp;
	}

	public void setListaPropVend(List<PropostaVendita> listaPropVend) {
		this.listaPropVend = listaPropVend;
	}

	
}
