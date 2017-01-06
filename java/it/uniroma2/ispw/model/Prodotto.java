package it.uniroma2.ispw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Prodotto")
public class Prodotto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int id; 
	
	@Column(name = "nome")
	public String nome;
	/*
	@Column(name = "emailProprietario")
	protected String emailProprietario;*/
	
	@Column(name = "cateogria")
	public String categoria;
	
	@Column(name ="tipologia")
	public String tipologia;
	
	@Column(name = "quantità")
	public int quantità;
	
	@Column(name = "prezzo")
	public int prezzo;
	
	@Column(name = "metogoPag")
	public String metodoPag;
	
	@Column(name = "tipoConsegna")
	public String tipoConsegna;
	
	@Column(name = "sconto")
	public int sconto;
	
	
	@ManyToOne
	@JoinColumn(name = "emailProprietario", referencedColumnName = "email")
	protected UtenteRegistrato utenteRegistrato;
	
	
	public Prodotto(){}
	
	public Prodotto(String nome, String categoria, String tipologia, int quantità, int prezzo, 
			String metodoPag, String tipoConsegna, int sconto, UtenteRegistrato utenteRegistrato){
		this.nome = nome;
		this.categoria = categoria;
		this.tipologia = tipologia;
		this.quantità = quantità;
		this.prezzo = prezzo;
		this.metodoPag = metodoPag;
		this.tipoConsegna = tipoConsegna;
		this.sconto = sconto;
		this.utenteRegistrato = utenteRegistrato;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/*public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}*/

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public UtenteRegistrato getUtenteRegistrato() {
		return utenteRegistrato;
	}

	public void setUtenteRegistrato(UtenteRegistrato utenteRegistrato) {
		this.utenteRegistrato = utenteRegistrato;
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

	public int getQuantità() {
		return quantità;
	}

	public void setQuantità(int quantità) {
		this.quantità = quantità;
	}

	public int getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}

	public String getMetodoPag() {
		return metodoPag;
	}

	public void setMetodoPag(String metodoPag) {
		this.metodoPag = metodoPag;
	}

	public String getTipoConsegna() {
		return tipoConsegna;
	}

	public void setTipoConsegna(String tipoConsegna) {
		this.tipoConsegna = tipoConsegna;
	}

	public int getSconto() {
		return sconto;
	}

	public void setSconto(int sconto) {
		this.sconto = sconto;
	}
	
}
