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
	private String emailUser;
	private String idUser;
	
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
	
	public String getEmailUser() {
		return emailUser;
	}
	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}
	
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	public boolean aggiornaProdotto(){
		
		GestisciProdotto gp = GestisciProdotto.getInstance();
		return (gp.aggiornaProdotto(this));

	}
	
	public boolean eliminaProdotto(){
		
		GestisciProdotto gp = GestisciProdotto.getInstance();
		return gp.deleteProduct(this.idProd);
	}
	
	public boolean selezionaProdottoPerId(){
		GestisciProdotto gp = GestisciProdotto.getInstance();
		return gp.selezionaProdottoPerId(this);
	}
	
}
