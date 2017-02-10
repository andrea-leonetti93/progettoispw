package it.uniroma2.ispw.bean;

import java.util.List;

import it.uniroma2.ispw.controller.GestisciProdotto;
import it.uniroma2.ispw.model.Prodotto;
import it.uniroma2.ispw.session.UtenteSessione;

public class InsProdottoBean {

	private int idProd;
	private String nameProduct;
	private String category;
	private String typology;
	private int price;
	private int sale;
	private int disponibilita;
	private String comment;
	private UtenteSessione utente;
	private List<ProdottoBean> arrayProdotti;
	
	public InsProdottoBean(){
		this.idProd = 0;
		this.nameProduct = "";
		this.category = "";
		this.typology = "";
		this.price = 0;
		this.sale = 0;
		this.disponibilita = 0;
		this.comment = "";
		this.utente = null;
		this.arrayProdotti = null;
	}

	
	public int getIdProd() {
		return idProd;
	}

	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSale() {
		return sale;
	}

	public void setSale(int sale) {
		this.sale = sale;
	}
	
	public UtenteSessione getUtente() {
		return utente;
	}

	public void setUtente(UtenteSessione utente) {
		this.utente = utente;
	}

	public List<ProdottoBean> getArrayProdotti() {
		return arrayProdotti;
	}

	public void setArrayProdotti(List<ProdottoBean> arrayProdotti) {
		this.arrayProdotti = arrayProdotti;
	}

	
	public int getDisponibilita() {
		return disponibilita;
	}


	public void setDisponibilita(int disponibilita) {
		this.disponibilita = disponibilita;
	}

	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	public boolean acquisisciProdotto(){
		
		GestisciProdotto gp = GestisciProdotto.getInstance();
		return gp.inserisciProdotto(this);
		
	}
	
	public void riempiLista(String email){
		
		GestisciProdotto gp = GestisciProdotto.getInstance();
		arrayProdotti = gp.prodottiUtente(email);
	}
	
	public boolean eliminaProdotto(){
		
		GestisciProdotto gp = GestisciProdotto.getInstance();
		return gp.deleteProduct(idProd);
		
	}
	
	/*
	public boolean trovaProdotto(){
		
		GestisciProdotto gp = new GestisciProdotto();
		Prodotto p = new Prodotto();
		if((p = gp.selezionaProdottoPerID(idProd)) == null){
			return false;
		}
		
		//idProd è qià quello del prodotto scelto
		nameProduct = p.getNome();
		category = p.getCategoria();
		typology = p.getTipologia();
		price = p.getPrezzo();
		sale = p.getSconto();
		System.out.println("nome prodotto" + nameProduct);
		return true;
	}*/
	
	public boolean trovaProdotto(){
		
		GestisciProdotto gp = GestisciProdotto.getInstance();
		return gp.selezionaProdottoPerId(this);
	}
	
}
