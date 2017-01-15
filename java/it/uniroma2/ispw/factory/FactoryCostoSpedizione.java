package it.uniroma2.ispw.factory;

import it.uniroma2.ispw.spedizione.CostoSpedizione;
import it.uniroma2.ispw.spedizione.CostoSpedizioneNormale;
import it.uniroma2.ispw.spedizione.CostoSpedizioneRapida;


public class FactoryCostoSpedizione {
	
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
		return new CostoSpedizioneRapida();
	}
	
	public CostoSpedizione creaSpedizioneNormale(){
		return new CostoSpedizioneNormale();
	}

}
