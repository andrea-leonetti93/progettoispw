package it.uniroma2.ispw.spedizione;

public class SpedizioneNormale implements CostoSpedizione {
	
public int calcolaCostoSpedizione(int numeroDiElementi){
		
		return numeroDiElementi*2;
	}

}
