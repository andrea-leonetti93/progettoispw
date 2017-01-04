package it.uniroma2.ispw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipoProdotto")
public class TipoProdotto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tipoProdId")
	private int tipoProdId;
	
	@Column(name = "categoria")
	private String categoria;
	
	@Column(name = "tipologia")
	private String tipologia;

	
	public TipoProdotto(){
		
	}
	
	public TipoProdotto(String categoria, String tipologia){
		this.categoria = categoria;
		this.tipologia = tipologia;
	}
	
	
	public int getTipoProdId() {
		return tipoProdId;
	}

	public void setTipoProdId(int tipoProdId) {
		this.tipoProdId = tipoProdId;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
	
}
