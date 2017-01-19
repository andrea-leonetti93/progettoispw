package it.uniroma2.ispw.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "amministrazioneDiSistema")
public class AmministrazioneDiSistema extends RuoloAmministrazione{

	public AmministrazioneDiSistema() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
