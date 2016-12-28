package it.uniroma2.ispw.controller;


import it.uniroma2.ispw.bean.UtenteBean;
import it.uniroma2.ispw.model.Consumatore;
import it.uniroma2.ispw.model.UtenteRegistrato;
import it.uniroma2.ispw.model.Venditore;
import it.uniroma2.ispw.persistence.UtenteDAO;

public class GestisciUtente {

	UtenteDAO u = new UtenteDAO();
	
	private static GestisciUtente instance;
	 
    public static GestisciUtente getInstance() {
        if (instance == null)
            instance = new GestisciUtente();
        return instance;
    }
     
    private GestisciUtente(){
         
    }
	
	
	public boolean effettuaLogin(String email, String password){
		
		if(u.checkUtente(email, password) != null){
			return true;
		}
		return false;
	}
	
	
	public UtenteRegistrato effettuaRegistrazione(UtenteBean uBean){
		
		UtenteRegistrato newUtente = null;
		
		if(u.checkUtente(uBean.getEmail(), uBean.getPassword()) != null){
			return newUtente;
		}
		if(uBean.getType().equals("Venditore")){
			newUtente = new Venditore(uBean.getName(), uBean.getSurname(), uBean.getEmail(), uBean.getPassword(), uBean.getPassword(), uBean.getStreet());
			u.addUtente(newUtente);
		}else if(uBean.getType().equals("Consumatore")){
			newUtente = new Consumatore(uBean.getName(), uBean.getSurname(), uBean.getEmail(), uBean.getPassword(), uBean.getPassword(), uBean.getStreet());
			u.addUtente(newUtente);
		}
		return newUtente;
	}

}
