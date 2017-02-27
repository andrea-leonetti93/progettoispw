package it.uniroma2.ispw.controller;

import java.util.ArrayList;
import java.util.List;

import it.uniroma2.ispw.laptop.AdminFinanceFrame;
import it.uniroma2.ispw.laptop.AdminFrame;
import it.uniroma2.ispw.laptop.RegisterAdminFrame;
import it.uniroma2.ispw.laptop.VisualLineeOrdine;
import it.uniroma2.ispw.laptop.VisualOrdiniFrame;
import it.uniroma2.ispw.laptop.VisualProdottiFrame;
import it.uniroma2.ispw.laptop.VisualUtentiFrame;
import it.uniroma2.ispw.model.Amministratore;
import it.uniroma2.ispw.model.AmministrazioneDiSistema;
import it.uniroma2.ispw.model.AmministrazioneFinanziaria;
import it.uniroma2.ispw.model.Ordine;
import it.uniroma2.ispw.model.Prodotto;
import it.uniroma2.ispw.model.RuoloAmministrazione;
import it.uniroma2.ispw.model.TipoProdotto;
import it.uniroma2.ispw.model.UtenteRegistrato;
import it.uniroma2.ispw.persistence.AmministratoreDAO;
import it.uniroma2.ispw.persistence.OrdineDAO;
import it.uniroma2.ispw.persistence.ProdottoDAO;
import it.uniroma2.ispw.persistence.RuoloAmministrazioneDAO;
import it.uniroma2.ispw.persistence.TipoProdottoDAO;
import it.uniroma2.ispw.persistence.UtenteDAO;

public class GestioneSistema {
	
	protected GestioneSistema(){}
	
	private static GestioneSistema instance;
	 
    public synchronized static GestioneSistema getInstance() {
        if (instance == null)
            instance = new GestioneSistema();
        return instance;
    }
	
	public synchronized List<UtenteRegistrato> visualizzaUtenti(){
		List<UtenteRegistrato> lur = null;
		UtenteDAO uDAO = new UtenteDAO();
		lur = uDAO.listaUtenti();
		return lur;
	}
	
	public synchronized List<Prodotto> visualizzaProdotti(String categoria, String tipologia){
		List<Prodotto> lp = null;
		List<Prodotto> lpfinal = new ArrayList<Prodotto>();
		ProdottoDAO pdao = new ProdottoDAO();
		lp = pdao.listaProdotti();
		for (Prodotto p : lp){
			boolean b1 = p.getCategoria().equals(categoria);
			boolean b2 = p.getTipologia().equals(tipologia);
			if ((b1)&&(b2)) lpfinal.add(p);
		}
		return lpfinal;
	}
	
	public synchronized List<Prodotto> visualizzaProdotti(){
		List<Prodotto> lp = null;
		ProdottoDAO pdao = new ProdottoDAO();
		lp = pdao.listaProdotti();
		return lp;
	}
	
	
	public synchronized List<Ordine> visualizzaOrdini(){
		List<Ordine> lo = null;
		OrdineDAO odao = new OrdineDAO();
		lo = odao.listaOrdini();
		return lo;
	}

	
	public void visualizzaLineaOrdineFrame(Ordine o){
		
		VisualLineeOrdine visualLineeOrdine = new VisualLineeOrdine(o);
		visualLineeOrdine.setVisible(true);
	    visualLineeOrdine.toFront();
	    visualLineeOrdine.repaint();
	}

	public synchronized boolean aggiungiAmministratore(String nome, String cognome, String email, String password, 
			String ruolo){
		Amministratore admin = new Amministratore(nome, cognome, email, password);
		RuoloAmministrazione rolAdmin;
		if(ruolo.equals("Amministratore di sistema")){
			rolAdmin = new AmministrazioneDiSistema();
		}else{
			rolAdmin = new AmministrazioneFinanziaria();
		}
		AmministratoreDAO ammDAO = new AmministratoreDAO();
		RuoloAmministrazioneDAO ruoloDAO = new RuoloAmministrazioneDAO();
		ruoloDAO.addRuoloAmministratore(rolAdmin);
		admin.setRuoloAmministrazione(rolAdmin);
		if(ammDAO.addAmministratore(admin)!= null){
			return true;
		}
		return false;
	}
	
	public synchronized List<TipoProdotto> visualizzaTipoProdotti(){
		List<TipoProdotto> listaTipiProdotti = null;
		TipoProdottoDAO tpd = new TipoProdottoDAO();
		if((listaTipiProdotti = tpd.listaTipiProdotto())!=null){
			return listaTipiProdotti;
		}
		return null;
	}
	
	
	public synchronized boolean effettuaLoginAdmin(String email, String password){
		Amministratore admin = null;
		AmministratoreDAO ad = new AmministratoreDAO();
		if((admin = ad.checkAmministratore(email, password))!=null){
			createMainUserFrame(admin);
			return true;
		}
		return false;
	}
	
	public void createMainUserFrame(Amministratore admin){
		if(admin.getRuoloAmministrazione() instanceof AmministrazioneDiSistema){
			AdminFrame mainFrame = new AdminFrame();
			mainFrame.setVisible(true);
		    mainFrame.toFront();
		    mainFrame.repaint();
		} else {
			AdminFinanceFrame mainFrame = new AdminFinanceFrame();
			mainFrame.setVisible(true);
		    mainFrame.toFront();
		    mainFrame.repaint();
		}	
	}
	
	public void apriFrame(String nomeFrame){
		
		if(nomeFrame.equals("UtentiFrame")){
			VisualUtentiFrame visualUtentiFrame = new VisualUtentiFrame();
			visualUtentiFrame.setVisible(true);
		    visualUtentiFrame.toFront();
		    visualUtentiFrame.repaint();
		}else if(nomeFrame.equals("OrdiniFrame")){
			VisualOrdiniFrame visualOrdiniFrame = new VisualOrdiniFrame();
			visualOrdiniFrame.setVisible(true);
		    visualOrdiniFrame.toFront();
		    visualOrdiniFrame.repaint();
		}else if(nomeFrame.equals("ProdottiFrame")){
			VisualProdottiFrame visualProdottiFrame = new VisualProdottiFrame();
			visualProdottiFrame.setVisible(true);
		    visualProdottiFrame.toFront();
		    visualProdottiFrame.repaint();
		}else if(nomeFrame.equals("RegistraAdmin")){
			RegisterAdminFrame registerAdminFrame = new RegisterAdminFrame();
			registerAdminFrame.setVisible(true);
		    registerAdminFrame.toFront();
		    registerAdminFrame.repaint();
		}
	}
}
