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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ruoloAmministrazione")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipoAmministrazione", discriminatorType = DiscriminatorType.STRING)
public class RuoloAmministrazione {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idRuolo")
	private int idRuolo;
	
	@OneToOne
	@JoinColumn(name = "idAmministratore", referencedColumnName = "idAmministratore")
	protected Amministratore amministratore;

	public RuoloAmministrazione(Amministratore amministratore) {
		this.amministratore = amministratore;
	}

	public int getIdRuolo() {
		return idRuolo;
	}

	public void setIdRuolo(int idRuolo) {
		this.idRuolo = idRuolo;
	}

	public Amministratore getAmministratore() {
		return amministratore;
	}

	public void setAmministratore(Amministratore amministratore) {
		this.amministratore = amministratore;
	}
	
	
}
