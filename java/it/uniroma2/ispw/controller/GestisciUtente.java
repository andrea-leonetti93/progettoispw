package it.uniroma2.ispw.controller;


import it.uniroma2.ispw.bean.RegistrazioneBean;
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
		
		if(u.checkUtente(email, password) == true){
			return true;
		}
		return false;
	}
	
	
	public UtenteRegistrato effettuaRegistrazione(RegistrazioneBean regBean){
		
		UtenteRegistrato newUtente = null;
		
		if(u.checkUtente(regBean.getEmail(), regBean.getPassword()) == true){
			return newUtente;
		}
		if(regBean.getType().equals("Venditore")){
			newUtente = new Venditore(regBean.getName(), regBean.getSurname(), regBean.getEmail(), regBean.getPassword(), regBean.getPassword(), regBean.getStreet());
			u.addUtente(newUtente);
		}else if(regBean.getType().equals("Consumatore")){
			newUtente = new Consumatore(regBean.getName(), regBean.getSurname(), regBean.getEmail(), regBean.getPassword(), regBean.getPassword(), regBean.getStreet());
			u.addUtente(newUtente);
		}
		return newUtente;
	}

}
