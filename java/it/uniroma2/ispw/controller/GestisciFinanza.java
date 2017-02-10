package it.uniroma2.ispw.controller;

import java.util.List;

import it.uniroma2.ispw.model.PrezzoSpedizione;
import it.uniroma2.ispw.model.TipoProdotto;
import it.uniroma2.ispw.persistence.PrezzoSpedizioneDAO;
import it.uniroma2.ispw.persistence.TipoProdottoDAO;

public class GestisciFinanza {
	
	protected GestisciFinanza(){}
	
	private static GestisciFinanza instance;
	 
    public synchronized static GestisciFinanza getInstance() {
        if (instance == null)
            instance = new GestisciFinanza();
        return instance;
    }
	
	
	
	public synchronized boolean aggiungiTipoProdotto(TipoProdotto tp){
		TipoProdottoDAO tpdao = new TipoProdottoDAO();
		
		if (tpdao.addTipoProdotto(tp)!=null){
			return true;
		}
		return false;
	}
	
	public synchronized boolean eliminaTipoProdotto(TipoProdotto tp){
		TipoProdottoDAO tpdao = new TipoProdottoDAO();
		List<TipoProdotto> ltp = tpdao.listaTipiProdotto();
		
		for (TipoProdotto tps : ltp){
			if ((tp.getCategoria().equals(tps.getCategoria()))&&(tp.getTipologia().equals(tps.getTipologia()))){
				return tpdao.deleteTipoProdotto(tps);
			}
		}
		
		return true;
		
	}
	
	public synchronized List<TipoProdotto> visualizzaListaTipiProdotto(){
		TipoProdottoDAO tpdao = new TipoProdottoDAO();
		
		return tpdao.listaTipiProdotto();
	}
	
	public synchronized boolean aggiungiOModificaPrezzoSpedizione(PrezzoSpedizione ps){
		PrezzoSpedizioneDAO psdao = new PrezzoSpedizioneDAO();
		
		if (psdao.addOrUpdatePrezzoSpedizione(ps)!=null) return true;
		return false;
	}
	
	public synchronized PrezzoSpedizione prendiPrezzoSpedizione(String tipoSpedizione){
		PrezzoSpedizioneDAO psdao = new PrezzoSpedizioneDAO();
		
		return psdao.getPrezzoSpedizione(tipoSpedizione);
	}
	

}
