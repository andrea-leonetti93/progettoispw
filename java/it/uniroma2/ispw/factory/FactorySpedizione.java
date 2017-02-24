package it.uniroma2.ispw.factory;

import it.uniroma2.ispw.model.Spedizione;
import it.uniroma2.ispw.model.SpedizioneNormale;
import it.uniroma2.ispw.model.SpedizioneRapida;

public class FactorySpedizione {
	
	private FactorySpedizione(){}
	
	private static class LazyHolderFS{
		private static final FactorySpedizione INSTANCE = new FactorySpedizione();
	}
	
	public static FactorySpedizione getInstance(){
		return LazyHolderFS.INSTANCE;
	}
	
	public Spedizione creaSpedizione(String type){
		if (type.equals("Rapida")) return creaSpedizioneRapida();
		else if (type.equals("Normale")) return creaSpedizioneNormale();
		else return null;
	}
	
	public Spedizione creaSpedizioneRapida(){
		return new SpedizioneRapida();
	}
	
	public Spedizione creaSpedizioneNormale(){
		return new SpedizioneNormale();
	}

}
