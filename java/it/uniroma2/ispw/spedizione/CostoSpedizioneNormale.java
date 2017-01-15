package it.uniroma2.ispw.spedizione;

public class CostoSpedizioneNormale implements CostoSpedizione {
	
public int calcolaCostoSpedizione(int numeroDiElementi){
		
		return numeroDiElementi*2;
	}

}
