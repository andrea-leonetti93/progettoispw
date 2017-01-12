package it.uniroma2.ispw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Ordine")
public class Ordine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idOrdine;
	
	@Column(name = "prezzoFinale")
	private int prezzoFinale;
	
	@Column(name = "metodoPagamento")
	private String metodoPagamento;
	
	@ManyToOne
	@JoinColumn(name = "emailProprietario", referencedColumnName = "email")
	protected UtenteRegistrato utenteReg;
	
	@OneToOne
	@JoinColumn(name = "idProdotto", referencedColumnName = "id")
	protected Prodotto prodotto;
	
	
	public Ordine(){}
	
	public Ordine(int prezzoFinale, String metodoPagamento, UtenteRegistrato utenteReg, Prodotto prodotto){
		this.prezzoFinale = prezzoFinale;
		this.metodoPagamento = metodoPagamento;
		this.utenteReg = utenteReg;
		this.prodotto = prodotto;
	}
	
	
	public String getMetodoPagamento() {
		return metodoPagamento;
	}

	public void setMetodoPagamento(String metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}

	public UtenteRegistrato getUtenteReg() {
		return utenteReg;
	}

	public void setUtenteReg(UtenteRegistrato utenteReg) {
		this.utenteReg = utenteReg;
	}

	public Prodotto getProdotto() {
		return prodotto;
	}

	public void setProdotto(Prodotto prodotto) {
		this.prodotto = prodotto;
	}
	
	
}
