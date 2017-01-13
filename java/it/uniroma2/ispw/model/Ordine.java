package it.uniroma2.ispw.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "Ordine")
public class Ordine {

	@Column(name = "idOrdine")
	private int idOrdine;
	
	@Column(name = "prezzo")
	private int prezzo;
	
	@Column(name = "prezzoSpedizione")
	private int prezzoSped;
	
	@Column(name = "tipoSpedizione")
	private String tipoSped;
	
	@Column(name = "modalitaPagamento")
	private String modalitaPag;
	
	@ManyToOne
	@JoinColumn(name = "emailProprietario", referencedColumnName = "email")
	private UtenteRegistrato utenteRegistrato;
	
	/*@Temporal(TemporalType.DATE)*/
	@Column(name = "date")
	private Date created;

	
	public Ordine(){}
	
	public Ordine(int prezzo, int prezzoSped, String tipoSped, String modalitaPag, 
			UtenteRegistrato utenteRegistrato){
		this.prezzo = prezzo;
		this.prezzoSped = prezzoSped;
		this.tipoSped = tipoSped;
		this.modalitaPag = modalitaPag;
		this.utenteRegistrato = utenteRegistrato;
	}

	@PrePersist
	protected  void onCreate(){
		created = new Date();
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

	public int getPrezzoSped() {
		return prezzoSped;
	}

	public void setPrezzoSped(int prezzoSped) {
		this.prezzoSped = prezzoSped;
	}

	public String getTipoSped() {
		return tipoSped;
	}

	public void setTipoSped(String tipoSped) {
		this.tipoSped = tipoSped;
	}

	public String getModalitaPag() {
		return modalitaPag;
	}

	public void setModalitaPag(String modalitaPag) {
		this.modalitaPag = modalitaPag;
	}

	public UtenteRegistrato getUtenteRegistrato() {
		return utenteRegistrato;
	}

	public void setUtenteRegistrato(UtenteRegistrato utenteRegistrato) {
		this.utenteRegistrato = utenteRegistrato;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

}
