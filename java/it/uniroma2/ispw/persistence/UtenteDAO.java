package it.uniroma2.ispw.persistence;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import it.uniroma2.ispw.model.Consumatore;
import it.uniroma2.ispw.model.UtenteRegistrato;
import it.uniroma2.ispw.model.Venditore;


public class UtenteDAO {

	
private static SessionFactory sessionFactory = buildSessionFactory();
	
	public UtenteDAO(){}
	
	private static SessionFactory buildSessionFactory() {
        
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            return sessionFactory;
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed. " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

 
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public UtenteRegistrato addUtente(UtenteRegistrato utente){
        Session session = sessionFactory.openSession();
        Transaction tx = null;
            try{
                tx = session.beginTransaction();
                session.save(utente);
                tx.commit();
                System.out.println("Utente aggiunto");
            }catch (HibernateException e) {
                if (tx!=null) tx.rollback();
                e.printStackTrace();
                System.out.println("Utente NON aggiunto");
                utente = null;
            }finally {
             session.close(); 
            }
            return utente;
    }
	
	public boolean checkUtente(String email, String password){
		return true;
	}
}
