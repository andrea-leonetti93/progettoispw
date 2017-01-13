package it.uniroma2.ispw.model;


import javax.persistence.CascadeType;
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
@Table(name = "LineaOrdine")
public class LineaOrdine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idLineaOrdine;
	
	@Column(name = "prezzoFinale")
	private int prezzoFinale;
	
	@Column(name = "metodoPagamento")
	private String metodoPagamento;
	
	@ManyToOne
	@JoinColumn(name = "idOrdine", referencedColumnName = "idOrdine")
	protected Ordine ordine;
	
	@OneToOne()
	@JoinColumn(name = "idProdotto", referencedColumnName = "id")
	protected Prodotto prodotto;
	
	
	public LineaOrdine(){}
	
	public LineaOrdine(int prezzoFinale, String metodoPagamento, Ordine ordine, Prodotto prodotto){
		this.prezzoFinale = prezzoFinale;
		this.metodoPagamento = metodoPagamento;
		this.ordine = ordine;
		this.prodotto = prodotto;
	}
	
	
	
	public int getIdOrdine() {
		return idLineaOrdine;
	}

	public void setIdOrdine(int idLineaOrdine) {
		this.idLineaOrdine = idLineaOrdine;
	}

	public int getPrezzoFinale() {
		return prezzoFinale;
	}

	public void setPrezzoFinale(int prezzoFinale) {
		this.prezzoFinale = prezzoFinale;
	}

	public String getMetodoPagamento() {
		return metodoPagamento;
	}

	public void setMetodoPagamento(String metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}

	public Prodotto getProdotto() {
		return prodotto;
	}

	public void setProdotto(Prodotto prodotto) {
		this.prodotto = prodotto;
	}

	public int getIdLineaOrdine() {
		return idLineaOrdine;
	}

	public void setIdLineaOrdine(int idLineaOrdine) {
		this.idLineaOrdine = idLineaOrdine;
	}

	public Ordine getOrdine() {
		return ordine;
	}

	public void setOrdine(Ordine ordine) {
		this.ordine = ordine;
	}
	
}
