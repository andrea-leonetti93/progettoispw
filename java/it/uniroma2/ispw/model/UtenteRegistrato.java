package it.uniroma2.ispw.model;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
//@IdClass(UtenteRegistratoPK.class)
@Table(name = "UtenteRegistrato")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public class UtenteRegistrato implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4294029448300657668L;
	
	@Column(name = "userid", unique = true)
	String userid;
	

	@Column(name = "nome")
	String nome;
	
	@Column(name = "cognome")
	String cognome;
	
	@Id
	@Column(name = "email", unique = true)
	String email;
	
	@Column(name = "password")
	String password;
	
	/*@Id
	@Column(name = "userID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userID;*/
	
	@Column(name = "telefono")
	String telefono;
	
	@Column(name = "residenza")
	String residenza;
	
	@OneToMany(mappedBy = "utenteRegistrato")
	protected Set<Pagamento> pagamenti;
	
	@OneToMany(mappedBy = "utenteRegistrato")
	protected Set<Prodotto> prodotti;
	
	@OneToMany(mappedBy = "utenteReg")
	protected Set<Ordine> ordini;
		
	public UtenteRegistrato(){}
	
	
	public UtenteRegistrato(String userid,String nome, String cognome, String email, String password, String telefono,
			String residenza) {
		
		this.userid = userid;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password = password;
		this.telefono = telefono;
		this.residenza = residenza;
		
	}
	
	public String getNome() {
		return nome;
	}
	public String getCognome() {
		return cognome;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	
	public String getTelefono() {
		return telefono;
	}
	public String getResidenza() {
		return residenza;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public void setResidenza(String residenza) {
		this.residenza = residenza;
	}

		public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	
	
	public Set<Prodotto> getProdotti() {
		return prodotti;
	}

	public void setProdotti(Set<Prodotto> prodotti) {
		this.prodotti = prodotti;
	}


	public Set<Ordine> getOrdini() {
		return ordini;
	}


	public void setOrdini(Set<Ordine> ordini) {
		this.ordini = ordini;
	}
	
}
