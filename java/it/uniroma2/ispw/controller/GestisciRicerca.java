package it.uniroma2.ispw.controller;

import java.util.ArrayList;
import java.util.List;

import it.uniroma2.ispw.model.Prodotto;
import it.uniroma2.ispw.model.PropostaVendita;
import it.uniroma2.ispw.model.UtenteRegistrato;
import it.uniroma2.ispw.model.Venditore;
import it.uniroma2.ispw.persistence.ProdottoDAO;
import it.uniroma2.ispw.persistence.UtenteDAO;

public class GestisciRicerca {
	
	protected GestisciRicerca(){}
	
	private static GestisciRicerca instance;
	 
    public static GestisciRicerca getInstance() {
        if (instance == null)
            instance = new GestisciRicerca();
        return instance;
    }
	
	public List<PropostaVendita> ricercaProdotto(String nomeRicerca,String categoria, 
			String tipologia, int prezzomin, int prezzomax){
		
		ProdottoDAO pdao = new ProdottoDAO();
		List<Prodotto> plist = pdao.listaProdotti();
		List<Prodotto> plistf = new ArrayList<Prodotto>();
		
		/* filtro lista dei prodotti*/
		for (Prodotto p : plist){
			if ((distance(p.getNome(),nomeRicerca) < 5)&&(p.getCategoria().equals(categoria))
					&&(p.getTipologia().equals(tipologia))&&(p.getPrezzo()>prezzomin)&&(p.getPrezzo()<prezzomax))
							plistf.add(p);
		}
		
		
		UtenteDAO udao = new UtenteDAO();
		List<UtenteRegistrato> lutente = udao.listaUtenti();
		List<Venditore> lvenditori = new ArrayList<Venditore>();
		
		for (UtenteRegistrato u : lutente){
			if (u instanceof Venditore) lvenditori.add((Venditore) u);
		}
		
		List<PropostaVendita> lpv = new ArrayList<PropostaVendita>();
		
		for(Venditore v : lvenditori){
			for(Prodotto p : plistf){
				if (p.getUtenteRegistrato().getEmail().equals(v.getEmail())){
					PropostaVendita pv = new PropostaVendita();
					pv.setP(p);
					pv.setV(v);
					pv.setPrezzoFinale(p.getPrezzo());
					lpv.add(pv);
				}
			}
		}
		
		return lpv;
		
	}

	public static int distance(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();
        // i == 0
        int [] costs = new int [b.length() + 1];
        for (int j = 0; j < costs.length; j++)
            costs[j] = j;
        for (int i = 1; i <= a.length(); i++) {
            // j == 0; nw = lev(i - 1, j)
            costs[0] = i;
            int nw = i - 1;
            for (int j = 1; j <= b.length(); j++) {
                int cj = Math.min(1 + Math.min(costs[j], costs[j - 1]), a.charAt(i - 1) == b.charAt(j - 1) ? nw : nw + 1);
                nw = costs[j];
                costs[j] = cj;
            }
        }
        return costs[b.length()];
    }

}
