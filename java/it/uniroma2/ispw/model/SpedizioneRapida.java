package it.uniroma2.ispw.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "spedizioneRapida")
public class SpedizioneRapida extends Spedizione{

	public SpedizioneRapida(){
		super();
	}
	
	public SpedizioneRapida(String statoSpedizione, String recapito, Ordine ordine){
		super(statoSpedizione, recapito, ordine);
	}
	
	public int calcolaCostoSpedizione(int numeroDiElementi) {
		return (numeroDiElementi*2);
	}
	
}
