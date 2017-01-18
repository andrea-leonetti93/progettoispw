package it.uniroma2.ispw.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "amministrazioneFinanziaria")
public class AmministrazioneFinanziaria extends RuoloAmministrazione{

	public AmministrazioneFinanziaria(Amministratore amministratore) {
		super(amministratore);
		// TODO Auto-generated constructor stub
	}

}
