package it.uniroma2.ispw.bean;

import java.util.ArrayList;
import java.util.List;

import it.uniroma2.ispw.model.Prodotto;


public class CarrelloBean {

	
	private List<ProdottoBean> listaProdottiBean;
	
	public CarrelloBean(){
		this.listaProdottiBean= new ArrayList<ProdottoBean>();
	}

	public List<ProdottoBean> getListaProdottiBean() {
		return listaProdottiBean;
	}

	public void setListaProdottiBean(List<ProdottoBean> listaProdottiBean) {
		this.listaProdottiBean = listaProdottiBean;
	}
	
	/*
	public List<Prodotto> getListaProdotti(){
		List<Prodotto> lp = new ArrayList<Prodotto>();
		for (PropostaVendita pv: listaPropVend){
			lp.add(pv.getP());
		}
		return lp;
	}
	*/

	
	
}
