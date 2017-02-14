package it.uniroma2.ispw.bean;

import java.util.List;

import it.uniroma2.ispw.controller.AcquistaProdotto;
import it.uniroma2.ispw.model.LineaOrdine;

public class VenditeBean {

	private List<LineaOrdine> listaLineeOrdine;
	
	public VenditeBean(){
		this.listaLineeOrdine = null;
	}

	public List<LineaOrdine> getListaLineeOrdine() {
		return listaLineeOrdine;
	}

	public void setListaLineeOrdine(List<LineaOrdine> listaLineeOrdine) {
		this.listaLineeOrdine = listaLineeOrdine;
	}
	
	public void riempiLista(String email){
		
		AcquistaProdotto ap = AcquistaProdotto.getInstance();
		listaLineeOrdine = ap.venditeUtente(email);
	}
	
}
