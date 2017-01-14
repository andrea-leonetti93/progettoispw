package it.uniroma2.ispw.factory;

import it.uniroma2.ispw.spedizione.CostoSpedizione;
import it.uniroma2.ispw.spedizione.SpedizioneNormale;
import it.uniroma2.ispw.spedizione.SpedizioneRapida;

public class FactorySpedizione {
	
	/* 1->rapida
	 *  2->normale
	 *  3->lenta
	 */
	
	public CostoSpedizione creaSpedizione(int type){
		 switch (type)
	        {
	            case 1: return creaSpedizioneRapida();
	            case 2: return creaSpedizioneNormale();
	            default: return null;
	        }
	}
	
	public CostoSpedizione creaSpedizioneRapida(){
		return new SpedizioneRapida();
	}
	
	public CostoSpedizione creaSpedizioneNormale(){
		return new SpedizioneNormale();
	}

}
