package it.uniroma2.ispw.controller;

import java.util.ArrayList;
import java.util.List;

import it.uniroma2.ispw.bean.AcquistoBean;
import it.uniroma2.ispw.bean.PagamentoBean;
import it.uniroma2.ispw.bean.ProdottoBean;
import it.uniroma2.ispw.factory.FactoryPagamento;
import it.uniroma2.ispw.factory.FactorySpedizione;
import it.uniroma2.ispw.model.Ente;
import it.uniroma2.ispw.model.LineaOrdine;
import it.uniroma2.ispw.model.Ordine;
import it.uniroma2.ispw.model.Pagamento;
import it.uniroma2.ispw.model.Prodotto;
import it.uniroma2.ispw.model.Spedizione;
import it.uniroma2.ispw.model.SpedizioneNormale;
import it.uniroma2.ispw.model.SpedizioneRapida;
import it.uniroma2.ispw.model.UtenteRegistrato;
import it.uniroma2.ispw.persistence.LineaOrdineDAO;
import it.uniroma2.ispw.persistence.OrdineDAO;
import it.uniroma2.ispw.persistence.PagamentoDAO;
import it.uniroma2.ispw.persistence.ProdottoDAO;
import it.uniroma2.ispw.persistence.UtenteDAO;
import it.uniroma2.ispw.prezzo.PrezzoFinale;
import it.uniroma2.ispw.prezzo.PrezzoFinaleConsumatore;
import it.uniroma2.ispw.prezzo.PrezzoFinaleEnte;




public class AcquistaProdotto {
	
	ProdottoDAO p = new ProdottoDAO();
	LineaOrdineDAO lo = new LineaOrdineDAO();
	UtenteDAO u = new UtenteDAO();
	
	public boolean effettuaAcquisto(List<ProdottoBean> lpB, String tipoSpedizione, 
			String emailUser, PagamentoBean pbean, String recapito){
		
		//trova utente registrato
		UtenteRegistrato ur = u.getUtente(emailUser);
		if (ur==null) return false;
		
		List<Prodotto> lp = new ArrayList<Prodotto>();
		for (ProdottoBean pB : lpB){
			Prodotto prodotto = p.prendiProdottoPerID(pB.getIdProd());
			lp.add(prodotto);
		}
		
		/* creazione ordine */
		Ordine ord = new Ordine();
		
		/* calcolo importo senza sconto*/
		int importoNonScontato = 0;
		for (Prodotto p : lp){
			importoNonScontato += p.getPrezzo();
		}
		
		/* calcolo importo con sconto */
		int importoScontato = 0;
		int sconto = 0;
		PrezzoFinale pf;
		if (ur instanceof Ente){
			pf = new PrezzoFinaleEnte();
		}
		else{
			pf = new PrezzoFinaleConsumatore();
		}
		
		for (Prodotto p : lp){
			importoScontato += pf.calcolaPrezzoFinale(p);
		}
		sconto = importoNonScontato - importoScontato;
		ord.setPrezzo(importoScontato);
		
		
		/* creazione lista linee ordine */
		List<LineaOrdine> lineeOrdine = new ArrayList<LineaOrdine>();
		for (Prodotto p : lp){
			LineaOrdine lo = new LineaOrdine(pf.calcolaPrezzoFinale(p),ord,p);
			lineeOrdine.add(lo);
			System.out.println(lo.getProdotto().getNome());
		}
		ord.setLineeOrdine(lineeOrdine);
		
		
		/* creazione Spedizione*/
		Spedizione sped;
		FactorySpedizione fs = new FactorySpedizione();
		sped = fs.creaSpedizione(tipoSpedizione);
		sped.setStatoSpedizione("In corso");
		sped.setRecapito(recapito);
		sped.setOrdine(ord);
		ord.setSped(sped);
		
		/* calcolo costo Spedizione*/
		int costoSped = sped.calcolaCostoSpedizione(lp.size());
		ord.setPrezzoSped(costoSped);	
		
		/* creazione pagamento */
		FactoryPagamento fp = new FactoryPagamento();
		Pagamento pag = fp.creaPagamento(pbean);
		pag.setImporto(importoScontato + costoSped);
		pag.setOrdine(ord);
		pag.setUtenteRegistrato(ur);
		ord.setPagamento(pag);
		
		
		OrdineDAO odao = new OrdineDAO();
		System.out.println("prova");
		
		
		ord.setUtenteReg(ur);
		odao.addOrdine(ord);
		
		/* aggiorna disponibilita*/
		ProdottoDAO pdao = new ProdottoDAO();
		for(Prodotto p :lp){
			p.setDisponibilita(0);
			pdao.updateProdotto(p);
		}
	
		return true;
		
		
		
	}

	public List<Pagamento> acquistiUtente(String email) {
		// TODO Auto-generated method stub
		List<Pagamento> listaPag = null;
		PagamentoDAO pd = new PagamentoDAO();
		listaPag = pd.listaAcquistiUtente(email);
		return listaPag;
	}

	public List<Prodotto> prodottiUtente(String email){
		
		List<Prodotto> prodotti = null;
		prodotti = p.listaProdottiUtente(email);
		return prodotti;
	}
	
	public List<LineaOrdine> venditeUtente(String email){
		
		List<Prodotto> listaP = prodottiUtente(email);
		List<LineaOrdine> listaLO = null;
		List<LineaOrdine> listaLO2 = new ArrayList<LineaOrdine>();
		Prodotto prod = null;
		for(int i=0; i<listaP.size(); i++){
			prod = listaP.get(i);
			listaLO = lo.listaVenditeUtente(prod);
			for(int j=0; j<listaLO.size(); j++){
				listaLO2.add(listaLO.get(j));
			}
		}
		return listaLO2;
	}
	
	public void riepilogoPrezzi(AcquistoBean acquistoBean){
		
		for (ProdottoBean pB : acquistoBean.getProdotti()){
			acquistoBean.setPrezzoNonScontato(acquistoBean.getPrezzoNonScontato() + pB.getPrice());
		}
		
		UtenteRegistrato utenteReg = u.getUtente(acquistoBean.getEmailUser());
		PrezzoFinale pf;
		if (utenteReg instanceof Ente){
			pf = new PrezzoFinaleEnte();
		}
		else{
			pf = new PrezzoFinaleConsumatore();
		}
		
		for (ProdottoBean pB : acquistoBean.getProdotti()){
			acquistoBean.setPrezzoScontato(acquistoBean.getPrezzoScontato()+ pf.calcolaPrezzoFinale(pB));
		}
		
		acquistoBean.setScontoEnte(acquistoBean.getPrezzoNonScontato()-acquistoBean.getPrezzoScontato());
	
		FactorySpedizione fs = new FactorySpedizione();
		Spedizione sped = fs.creaSpedizione(acquistoBean.getTipoSpedizione());
		acquistoBean.setPrezzoSpedizione(sped.calcolaCostoSpedizione(acquistoBean.getProdotti().size()));
		
		acquistoBean.setPrezzoFinale(acquistoBean.getPrezzoScontato()+acquistoBean.getPrezzoSpedizione());
		
		
		
		
	}
	
	
}
