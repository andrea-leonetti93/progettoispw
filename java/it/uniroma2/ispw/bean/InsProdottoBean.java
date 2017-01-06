package it.uniroma2.ispw.bean;

import java.util.List;

import it.uniroma2.ispw.controller.GestisciProdotto;
import it.uniroma2.ispw.model.Prodotto;

public class InsProdottoBean {

	private String name;
	private String category;
	private String typology;
	private int amount;
	private int price;
	private String methodPay;
	private String deliveryType;
	private int sale;
	private UtenteBean utente;
	private List<Prodotto> arrayProdotti;
	
	public InsProdottoBean(){
		this.name = "";
		this.category = "";
		this.typology = "";
		this.amount = 0;
		this.price = 0;
		this.methodPay = "";
		this.deliveryType = "";
		this.sale = 0;
		this.utente = null;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTypology() {
		return typology;
	}

	public void setTypology(String typology) {
		this.typology = typology;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getMethodPay() {
		return methodPay;
	}

	public void setMethodPay(String methodPay) {
		this.methodPay = methodPay;
	}

	public String getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}

	public int getSale() {
		return sale;
	}

	public void setSale(int sale) {
		this.sale = sale;
	}
	
	public UtenteBean getUtente() {
		return utente;
	}

	public void setUtente(UtenteBean utente) {
		this.utente = utente;
	}

	public List<Prodotto> getArrayProdotti() {
		return arrayProdotti;
	}

	public void setArrayProdotti(List<Prodotto> arrayProdotti) {
		this.arrayProdotti = arrayProdotti;
	}


	public boolean acquisisciProdotto(){
		
		GestisciProdotto gp = new GestisciProdotto();
		Prodotto p = null;
		
		p = gp.inserisciProdotto(this);
		if(p == null){
			return false;
		}
		arrayProdotti.add(p);
		return true;
	}
	
	public void riempiLista(String email){
		
		GestisciProdotto gp = new GestisciProdotto();
		arrayProdotti = gp.prodottiUtente(email);
	}
	
	
}
