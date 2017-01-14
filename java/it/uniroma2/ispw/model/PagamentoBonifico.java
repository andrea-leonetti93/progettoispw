package it.uniroma2.ispw.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "pagamentoBonifico")
public class PagamentoBonifico extends Pagamento{

	@Column(name = "codiceIBAN")
	private String codiceIBAN;
	
	@Column(name = "causale")
	private String causale;
	
	public PagamentoBonifico(){
		super();
	}
	
	public PagamentoBonifico(UtenteRegistrato utenteRegistrato, String metodo, Ordine ordine, 
			int importo, String codiceIBAN, String causale){
		super(utenteRegistrato, metodo, ordine, importo);
		this.codiceIBAN = codiceIBAN;
		this.causale = causale;
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
