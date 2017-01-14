package it.uniroma2.ispw.spedizione;

public class SpedizioneRapida implements CostoSpedizione {
	
	public int calcolaCostoSpedizione(int numeroDiElementi){
		
		return numeroDiElementi*3;
	}

}
