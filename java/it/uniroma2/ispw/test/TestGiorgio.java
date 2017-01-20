package it.uniroma2.ispw.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import it.uniroma2.ispw.model.PrezzoSpedizione;
import it.uniroma2.ispw.model.TipoProdotto;
import it.uniroma2.ispw.persistence.PrezzoSpedizioneDAO;
import it.uniroma2.ispw.persistence.TipoProdottoDAO;

public class TestGiorgio {

	public static void main(String[] args) {
		
		TipoProdottoDAO tpdao = new TipoProdottoDAO();
		
		List<TipoProdotto> ltp = tpdao.listaTipiProdotto();
		List<String> listaCategorie = new ArrayList<String>();
		
		for (TipoProdotto tp : ltp){
			listaCategorie.add(tp.getCategoria());
		}
		
		//Elimina Doppioni Categorie
		Set<String> se =new HashSet<String>(listaCategorie);
		listaCategorie.clear();
		listaCategorie = new ArrayList<String>(se);
		
		//Trova tipologie per ogni categoria
		for (String categoria : listaCategorie){
			System.out.println("valutazione categoria "+ categoria);
			for (TipoProdotto tp : ltp){
				
				if (tp.getCategoria().equals(categoria)) System.out.println(tp.getTipologia());
			}
		}
		
	
	}

}
