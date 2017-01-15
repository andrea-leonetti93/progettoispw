package it.uniroma2.ispw.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "Ordine")
public class Ordine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idOrdine")
	private int idOrdine;
	
	@Column(name = "prezzo")
	private int prezzo;
	
	@Column(name = "prezzoSpedizione")
	private int prezzoSped;
	
	@Column(name = "tipoSpedizione")
	private String tipoSped;
	
	@OneToMany(mappedBy = "ordine")
	protected Set<LineaOrdine> lineeOrdine;
	
	@ManyToOne
	@JoinColumn(name = "emailProprietario", referencedColumnName = "email")
	protected UtenteRegistrato utenteReg;
	
	@OneToOne
	@JoinColumn(name = "idPagamento", referencedColumnName = "idPagamento")
	protected Pagamento pagamento;
	
	
	/*@Temporal(TemporalType.DATE)*/
	@Column(name = "date")
	private Date created;

	
	public Ordine(){}
	
	public Ordine(int prezzo, int prezzoSped, String tipoSped, String modalitaPag, Pagamento pagamento){
		this.prezzo = prezzo;
		this.prezzoSped = prezzoSped;
		this.tipoSped = tipoSped;
		this.pagamento = pagamento;
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

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Set<LineaOrdine> getLineeOrdine() {
		return lineeOrdine;
	}

	public void setLineeOrdine(Set<LineaOrdine> lineeOrdine) {
		this.lineeOrdine = lineeOrdine;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	
}
