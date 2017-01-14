package it.uniroma2.ispw.model;

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
@Table(name = "pagamento")
public class Pagamento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idPagamento")
	private int idPagamento;
	
	@ManyToOne()
	@JoinColumn(name = "emailConsumatore", referencedColumnName = "email")
	protected UtenteRegistrato utenteRegistrato;
	
	@Column(name = "metodo")
	private String metodo;
	
	@OneToOne
	@JoinColumn(name = "idOrdine", referencedColumnName = "idOrdine")
	private Ordine ordine;

	@Column(name = "numeroCarta")
	private String numeroCarta;
	
	@Column(name = "scadenzaCarta")
	private String scadenzaCarta;
	
	@Column(name = "numeorDiScadenza")
	private int numeroDiSicurezza;
	
	@Column(name = "codiceIBAN")
	private String codiceIBAN;
	
	@Column(name = "causale")
	private String causale;

	public Pagamento(){}
	
	public Pagamento(UtenteRegistrato utenteRegistrato, String metodo, Ordine ordine, String numeroCarta, 
			String scadenzaCarta, int numeroDiSicurezza, String codiceIBAN, String causale){
		this.utenteRegistrato = utenteRegistrato;
		this.metodo = metodo;
		this.ordine = ordine;
		this.numeroCarta = numeroCarta;
		this.scadenzaCarta = scadenzaCarta;
		this.numeroDiSicurezza = numeroDiSicurezza;
		this.codiceIBAN = codiceIBAN;
		this.causale = causale;
	}

	public int getIdPagamento() {
		return idPagamento;
	}

	public void setIdPagamento(int idPagamento) {
		this.idPagamento = idPagamento;
	}

	public UtenteRegistrato getUtenteRegistrato() {
		return utenteRegistrato;
	}

	public void setUtenteRegistrato(UtenteRegistrato utenteRegistrato) {
		this.utenteRegistrato = utenteRegistrato;
	}

	public String getMetodo() {
		return metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

	public Ordine getOrdine() {
		return ordine;
	}

	public void setOrdine(Ordine ordine) {
		this.ordine = ordine;
	}

	public String getNumeroCarta() {
		return numeroCarta;
	}

	public void setNumeroCarta(String numeroCarta) {
		this.numeroCarta = numeroCarta;
	}

	public String getScadenzaCarta() {
		return scadenzaCarta;
	}

	public void setScadenzaCarta(String scadenzaCarta) {
		this.scadenzaCarta = scadenzaCarta;
	}

	public int getNumeroDiSicurezza() {
		return numeroDiSicurezza;
	}

	public void setNumeroDiSicurezza(int numeroDiSicurezza) {
		this.numeroDiSicurezza = numeroDiSicurezza;
	}

	public String getCodiceIBAN() {
		return codiceIBAN;
	}

	public void setCodiceIBAN(String codiceIBAN) {
		this.codiceIBAN = codiceIBAN;
	}

	public String getCausale() {
		return causale;
	}

	public void setCausale(String causale) {
		this.causale = causale;
	}

	
}
