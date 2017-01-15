package it.uniroma2.ispw.factory;

import it.uniroma2.ispw.bean.PagamentoBean;
import it.uniroma2.ispw.model.Pagamento;
import it.uniroma2.ispw.model.PagamentoBonifico;
import it.uniroma2.ispw.model.PagamentoCarta;

public class FactoryPagamento {
	
	/*
	 * "Bonifico", "Carta"
	 */
	
	public Pagamento creaPagamento(PagamentoBean pbean){
		if (pbean.getMetodoPag().equals("Bonifico"))  return creaPagamentoBonifico(pbean);
		else if (pbean.getMetodoPag().equals("Carta")) return creaPagamentoCarta(pbean);
		return null;
	}
	
	public Pagamento creaPagamentoBonifico(PagamentoBean pbean){
		PagamentoBonifico pbon = new PagamentoBonifico();
		pbon.setCausale(pbean.getCausale());
		pbon.setCodiceIBAN(pbean.getCodiceIBAN());
		pbon.setImporto(pbean.getImportoScontato());
		
		return pbon;
	}
	
	public Pagamento creaPagamentoCarta(PagamentoBean pbean){
		PagamentoCarta pcarta = new PagamentoCarta();
		pcarta.setNumeroCarta(pbean.getNumeroCarta());
		pcarta.setNumeroDiSicurezza(Integer.parseInt(pbean.getNumeroDiSicurezza()));
		pcarta.setScadenzaCarta(pbean.getScadenzaCarta());
		pcarta.setImporto(pbean.getImportoScontato());
		
		return pcarta;
		
	}
		
		

}
