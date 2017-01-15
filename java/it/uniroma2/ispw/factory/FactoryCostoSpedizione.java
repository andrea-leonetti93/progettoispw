package it.uniroma2.ispw.factory;

import it.uniroma2.ispw.spedizione.CostoSpedizione;
import it.uniroma2.ispw.spedizione.CostoSpedizioneNormale;
import it.uniroma2.ispw.spedizione.CostoSpedizioneRapida;


public class FactoryCostoSpedizione {
	
	/* 1->rapida
	 *  2->normale
	 *  
	 */
	
	public CostoSpedizione creaSpedizione(String type){
		if (type.equals("Normale")) return creaSpedizioneNormale();
		return creaSpedizioneRapida();
	}
	
	public CostoSpedizione creaSpedizioneRapida(){
		return new CostoSpedizioneRapida();
	}
	
	public CostoSpedizione creaSpedizioneNormale(){
		return new CostoSpedizioneNormale();
	}

}
