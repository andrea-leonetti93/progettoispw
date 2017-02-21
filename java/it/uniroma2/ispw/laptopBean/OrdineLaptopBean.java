package it.uniroma2.ispw.laptopBean;

import java.util.List;

import it.uniroma2.ispw.controller.GestioneSistema;



public class OrdineLaptopBean {

	private int idOrdine;
	private int prezzo;
	private String tipoSped;
	private List<LineaOrdineLaptopBean> lineeOrdineB;
	private String emailUtente;
	private String metodoPag;
	
	public OrdineLaptopBean(){
		this.idOrdine = 0;
		this.prezzo = 0;
		this.tipoSped = "";
		this.lineeOrdineB = null;
		this.emailUtente = "";
		this.metodoPag = "";
	}

	public int getIdOrdine() {
		return idOrdine;
	}

	public void setIdOrdine(int idOrdine) {
		this.idOrdine = idOrdine;
	}

	public int getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}

	public String getTipoSped() {
		return tipoSped;
	}

	public void setTipoSped(String tipoSped) {
		this.tipoSped = tipoSped;
	}

	public List<LineaOrdineLaptopBean> getLineeOrdineB() {
		return lineeOrdineB;
	}

	public void setLineeOrdineB(List<LineaOrdineLaptopBean> lineeOrdineB) {
		this.lineeOrdineB = lineeOrdineB;
	}

	public String getEmailUtente() {
		return emailUtente;
	}

	public void setEmailUtente(String emailUtente) {
		this.emailUtente = emailUtente;
	}

	public String getMetodoPag() {
		return metodoPag;
	}

	public void setMetodoPag(String metodoPag) {
		this.metodoPag = metodoPag;
	}
	
	public List<OrdineLaptopBean> ottieniListaOrdini(){
		
		List<OrdineLaptopBean> lob = null;
		GestioneSistema gs = GestioneSistema.getInstance();
		if((lob = gs.visualizzaOrdini())!=null){
			return lob;
		}
		return null;
	}
	
	public void visualizzaLineaOrdine(OrdineLaptopBean olb){
		
		GestioneSistema gs = GestioneSistema.getInstance();
		gs.visualizzaLineaOrdineFrame(olb);
	}
}
