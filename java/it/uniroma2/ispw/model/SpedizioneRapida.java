package it.uniroma2.ispw.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import it.uniroma2.ispw.persistence.PrezzoSpedizioneDAO;

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
		PrezzoSpedizioneDAO psdao = new PrezzoSpedizioneDAO();
		PrezzoSpedizione ps = psdao.getPrezzoSpedizione("Rapida");
		
		if (ps==null) return (numeroDiElementi*4);
		else return (numeroDiElementi*ps.getCostoConsegna());
	}
	
}
