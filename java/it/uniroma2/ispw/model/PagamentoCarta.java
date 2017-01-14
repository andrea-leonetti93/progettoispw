package it.uniroma2.ispw.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue(value = "pagamentoCarta")
public class PagamentoCarta extends Pagamento{

	@Column(name = "numeroCarta")
	private String numeroCarta;
	
	@Column(name = "scadenzaCarta")
	private String scadenzaCarta;
	
	@Column(name = "numeorDiScadenza")
	private int numeroDiSicurezza;
	
	public PagamentoCarta(){
		super();
	}
	
	public PagamentoCarta(UtenteRegistrato utenteRegistrato, String metodo, Ordine ordine, int importo, 
			String numeroCarta, String scadenzaCarta, int numeroDiSicurezza){
		super(utenteRegistrato, metodo, ordine, importo);
		this.numeroCarta = numeroCarta;
		this.scadenzaCarta = scadenzaCarta;
		this.numeroDiSicurezza = numeroDiSicurezza;
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
	
}
