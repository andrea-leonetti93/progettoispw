package it.uniroma2.ispw.controller;

import java.util.ArrayList;
import java.util.List;

import it.uniroma2.ispw.bean.PagamentoBean;
import it.uniroma2.ispw.factory.FactoryPagamento;
import it.uniroma2.ispw.model.Consumatore;
import it.uniroma2.ispw.model.Ente;
import it.uniroma2.ispw.model.LineaOrdine;
import it.uniroma2.ispw.model.Ordine;
import it.uniroma2.ispw.model.Pagamento;
import it.uniroma2.ispw.model.Prodotto;
import it.uniroma2.ispw.model.Spedizione;
import it.uniroma2.ispw.model.SpedizioneNormale;
import it.uniroma2.ispw.model.SpedizioneRapida;
import it.uniroma2.ispw.model.UtenteRegistrato;
import it.uniroma2.ispw.persistence.OrdineDAO;
import it.uniroma2.ispw.prezzo.PrezzoFinale;
import it.uniroma2.ispw.prezzo.PrezzoFinaleConsumatore;
import it.uniroma2.ispw.prezzo.PrezzoFinaleEnte;
import it.uniroma2.ispw.spedizione.CostoSpedizione;
import it.uniroma2.ispw.spedizione.CostoSpedizioneNormale;
import it.uniroma2.ispw.spedizione.CostoSpedizioneRapida;


public class AcquistaProdotto {
	
	public boolean effettuaAcquisto(List<Prodotto> lp, String tipoSpedizione, 
			UtenteRegistrato ur, PagamentoBean pbean, String recapito){
		
		Ordine ord = new Ordine();
		
		/* prezzo totale senza sconto (e senza spedizione)*/
		int importoTotale = 0;
		for (Prodotto p : lp){
			importoTotale += p.getPrezzo();
		}
		System.out.println("L'importo totale senza spedizione e sconto è "+ importoTotale);
		
		/*calcolo sconto per ogni prodotto*/
		PrezzoFinale pf;
		if (ur instanceof Ente){
			pf = new PrezzoFinaleEnte();
		}
		else {
			pf = new PrezzoFinaleConsumatore();
		}
		
		
		/*generazione linee ordine*/
		int importoTotaleScontato = 0;
		int importoScontato = 0;
		LineaOrdine loTemp;
		List<LineaOrdine> lineeOrdine = new ArrayList<LineaOrdine>();
		for (Prodotto p : lp){
			loTemp = new LineaOrdine();
			loTemp.setOrdine(ord);
			loTemp.setProdotto(p);
			importoScontato = pf.calcolaPrezzoFinale(p.getPrezzo());
			loTemp.setPrezzoLinea(importoScontato);
			importoTotaleScontato += importoScontato;
			lineeOrdine.add(loTemp);
		}
		ord.setLineeOrdine(lineeOrdine);
		pbean.setImportoScontato(importoTotaleScontato);
		ord.setPrezzo(pbean.getImportoScontato());
		System.out.println("L'importo scontato senza spedizione è "+ importoTotaleScontato);
		
		
		/* prezzo di spedizione*/
		int costoSped;
		CostoSpedizione cs;
		if (tipoSpedizione.equals("Rapida")){
			cs = new CostoSpedizioneRapida();
		}
		else{
			cs = new CostoSpedizioneNormale();
		}
		costoSped = cs.calcolaCostoSpedizione(lp.size());
		ord.setPrezzoSped(costoSped);
		System.out.println("Il prezzo di spedizione è "+ costoSped);
		
		
		/*creazione pagamento*/
		FactoryPagamento factoryPag = new FactoryPagamento();
		Pagamento pag = factoryPag.creaPagamento(pbean);
		pag.setUtenteRegistrato(ur);
		System.out.println("Creato Pagamento");
		
		/*creazione spedizione*/
		Spedizione sped;
		if (tipoSpedizione.equals("Rapida")){
			sped = new SpedizioneRapida("In corso", recapito, ord);
		}
		
		else{
			sped = new SpedizioneNormale("In corso",recapito,ord);
			
		}
		System.out.println("Creata Spedizione");
		
		
		
		
		return false;
		
		
		
	}


	
}
