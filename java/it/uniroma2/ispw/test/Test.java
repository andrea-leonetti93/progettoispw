package it.uniroma2.ispw.test;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.uniroma2.ispw.model.Consumatore;
import it.uniroma2.ispw.model.Prodotto;
import it.uniroma2.ispw.model.Venditore;
import it.uniroma2.ispw.persistence.ProdottoDAO;
import it.uniroma2.ispw.persistence.UtenteDAO;


public class Test {

public static void main(String[] args) {
		
		//System.out.println("Sono un "+ c2.getType());
		/*Consumatore c1 = new Consumatore("Andrea", "Leonetti", "andrealeo09@gmail.com", "andrea", "01234", "via alamanni"); 
        Venditore v1 = new Venditore("Marco", "Grella", "marcogrella@gmail.com", "marco", "45678", "via ciao");		
        
        UtenteDAO u = new UtenteDAO();
        u.addUtente(c1);
        u.addUtente(v1);
        System.out.println("Utenti aggiunti");
		*/
	/*Venditore v2 = new Venditore("gesù", "dio", "gesù@gmail.com", "bigbang", "0123456", "via del ciao");
	Prodotto p = new Prodotto("Iphone 6", "elettronica", "cellulari", 10, 300, "carta di credito", "Bartolini", 0, v2); 
	ProdottoDAO pd = new ProdottoDAO();
	//UtenteDAO ud = new UtenteDAO();
	Set<Prodotto> prodotti = new HashSet<Prodotto>();
	prodotti.add(p);
	v2.setProdotti(prodotti);
	//ud.addUtente(v2);
	pd.addProdotto(p);
	System.out.println("prodotto aggiunto");*/
	
		//List<Prodotto> listaP = null;
		ProdottoDAO pd = new ProdottoDAO();
		pd.deleteProduct(20);
		
		//listaP = p.listaProdottiUtente("gesù@gmail.com");
		/*for(int i = 0; i<listaP.size(); i++){
			System.out.println("Nome prodotto numero " + i + ":" + (listaP.get(i)).getNome());
		}*/
	}
}
