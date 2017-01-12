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
	private String nome;
	
	@Column(name = "categoria")
	private String categoria;
	
	@Column(name ="tipologia")
	private String tipologia;
	
	/*@Column(name = "quantità")
	public int quantità;*/
	
	@Column(name = "prezzo")
	private int prezzo;
	
	@Column(name = "sconto")
	private int sconto;
	
	@Column(name = "disponibilita")
	private int disponibilita;
	
	@ManyToOne
	@JoinColumn(name = "emailProprietario", referencedColumnName = "email")
	protected UtenteRegistrato utenteRegistrato;
	
	
	public Prodotto(){}
	
	public Prodotto(String nome, String categoria, String tipologia, int prezzo, 
			int sconto, UtenteRegistrato utenteRegistrato, int disponibilita){
		this.nome = nome;
		this.categoria = categoria;
		this.tipologia = tipologia;
		this.prezzo = prezzo;
		this.sconto = sconto;
		this.utenteRegistrato = utenteRegistrato;
		this.disponibilita = disponibilita;
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

	public int getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}

	public int getSconto() {
		return sconto;
	}

	public void setSconto(int sconto) {
		this.sconto = sconto;
	}

	public int getDisponibilita() {
		return disponibilita;
	}

	public void setDisponibilita(int disponibilita) {
		this.disponibilita = disponibilita;
	}
	
	
	
}
