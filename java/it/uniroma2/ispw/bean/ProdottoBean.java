package it.uniroma2.ispw.bean;


import it.uniroma2.ispw.controller.GestisciProdotto;
import it.uniroma2.ispw.model.Prodotto;
import it.uniroma2.ispw.model.UtenteRegistrato;

public class ProdottoBean {
	
	private int idProd;
	private String nameProduct;
	private String category;
	private String typology;
	private int price;
	private int sale;
	private int disponibilita;
	private String comment;
	private UtenteRegistrato ur;
	
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
	
	public UtenteRegistrato getUr() {
		return ur;
	}
	public void setUr(UtenteRegistrato ur) {
		this.ur = ur;
	}
	public boolean aggiornaProdotto(){
		
		Prodotto p = new Prodotto(this.nameProduct,this.category,this.typology, this.price,
				this.sale, this.ur,this.disponibilita,this.comment);
		p.setId(this.idProd);
		
		GestisciProdotto gp = new GestisciProdotto();
		if (gp.aggiornaProdotto(p)!=null) return true;
		return false;
	}
	
	public boolean eliminaProdotto(){
		
		Prodotto p = new Prodotto(this.nameProduct,this.category,this.typology, this.price,
				this.sale, this.ur,this.disponibilita,this.comment);
		p.setId(this.idProd);
		
		GestisciProdotto gp = new GestisciProdotto();
		return gp.deleteProduct(this.idProd);
		
		
	}

	

}
