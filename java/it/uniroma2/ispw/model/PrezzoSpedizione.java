package it.uniroma2.ispw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PrezzoSpedizione")
public class PrezzoSpedizione {
	
	@Id
	@Column(name = "tipologiaConsegna")
	private String tipologiaConsegna;
	
	@Column(name = "costoConsegna")
	private int costoConsegna;

	public PrezzoSpedizione(){}
	
	public PrezzoSpedizione(String tipologiaConsegna, int costoConsegna) {
		super();
		this.tipologiaConsegna = tipologiaConsegna;
		this.costoConsegna = costoConsegna;
	}

	public String getTipologiaConsegna() {
		return tipologiaConsegna;
	}

	public void setTipologiaConsegna(String tipologiaConsegna) {
		this.tipologiaConsegna = tipologiaConsegna;
	}

	public int getCostoConsegna() {
		return costoConsegna;
	}

	public void setCostoConsegna(int costoConsegna) {
		this.costoConsegna = costoConsegna;
	}
	
	
	
	

}
