package it.uniroma2.ispw.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import it.uniroma2.ispw.persistence.PrezzoSpedizioneDAO;

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
		
		PrezzoSpedizioneDAO psdao = new PrezzoSpedizioneDAO();
		PrezzoSpedizione ps = psdao.getPrezzoSpedizione("Normale");
		
		if (ps==null) return (numeroDiElementi*2);
		else return (numeroDiElementi*ps.getCostoConsegna());
		
	}
}
