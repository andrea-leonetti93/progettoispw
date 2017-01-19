package it.uniroma2.ispw.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "amministratore")
public class Amministratore {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idAmministratore")
	private int idAmministratore;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "cognome")
	private String cognome;
	
	@Id
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@OneToOne
	@JoinColumn(name = "idRuolo", referencedColumnName = "idRuolo")
	private RuoloAmministrazione ruoloAmministrazione;
	
	public Amministratore(){}

	public Amministratore(String nome, String cognome, String email, String password) {
		
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password = password;
	}

	public int getIdAmministratore() {
		return idAmministratore;
	}

	public void setIdAmministratore(int idAmministratore) {
		this.idAmministratore = idAmministratore;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RuoloAmministrazione getRuoloAmministrazione() {
		return ruoloAmministrazione;
	}

	public void setRuoloAmministrazione(RuoloAmministrazione ruoloAmministrazione) {
		this.ruoloAmministrazione = ruoloAmministrazione;
	}

	
}
