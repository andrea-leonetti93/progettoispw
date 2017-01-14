package it.uniroma2.ispw.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pagamento")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "metodo", discriminatorType = DiscriminatorType.STRING)
public abstract class Pagamento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idPagamento")
	private int idPagamento;
	
	@ManyToOne()
	@JoinColumn(name = "emailConsumatore", referencedColumnName = "email")
	protected UtenteRegistrato utenteRegistrato;
	

	@Column(name = "importo")
	private int importo;
	
	public Pagamento(){}
	
	public Pagamento(UtenteRegistrato utenteRegistrato, String metodo, int importo){
		this.utenteRegistrato = utenteRegistrato;
		this.importo = importo;
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

	public int getImporto() {
		return importo;
	}

	public void setImporto(int importo) {
		this.importo = importo;
	}
	
}
