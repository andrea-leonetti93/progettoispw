package it.uniroma2.ispw.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "spedizioneNormale")
public class SpedizioneNormale extends Spedizione{

	public SpedizioneNormale(){
		super();
	}
	
	public SpedizioneNormale(String statoSpedizione, String recapito, Ordine ordine){
		super(statoSpedizione, recapito, ordine);
	}
	
	public int calcolaCostoSpedizione(int numeroDiElementi){
		return (numeroDiElementi*4);
	}
}
