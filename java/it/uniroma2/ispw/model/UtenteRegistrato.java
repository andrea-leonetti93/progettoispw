package it.uniroma2.ispw.model;


import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
	
	@OneToMany(mappedBy = "utenteRegistrato", cascade=CascadeType.ALL)
	protected List<Pagamento> pagamenti;
	
	//@OneToMany(mappedBy = "utenteRegistrato", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	//@OneToMany(mappedBy = "utenteRegistrato", fetch = FetchType.EAGER)
	//@OneToMany(mappedBy = "utenteRegistrato", fetch = FetchType.EAGER, cascade=CascadeType.DETACH)
	@OneToMany(mappedBy = "utenteRegistrato", fetch = FetchType.EAGER)
	protected List<Prodotto> prodotti;
	
	@OneToMany(mappedBy = "utenteReg")
	protected List<Ordine> ordini;
		
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
	
	
	
	public List<Pagamento> getPagamenti() {
		return pagamenti;
	}


	public void setPagamenti(List<Pagamento> pagamenti) {
		this.pagamenti = pagamenti;
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
	
	
	
	public List<Prodotto> getProdotti() {
		return prodotti;
	}

	public void setProdotti(List<Prodotto> prodotti) {
		this.prodotti = prodotti;
	}


	public List<Ordine> getOrdini() {
		return ordini;
	}


	public void setOrdini(List<Ordine> ordini) {
		this.ordini = ordini;
	}
	
}
