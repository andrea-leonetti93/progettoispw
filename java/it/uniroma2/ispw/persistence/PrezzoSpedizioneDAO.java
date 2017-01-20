package it.uniroma2.ispw.persistence;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import it.uniroma2.ispw.model.PrezzoSpedizione;
import it.uniroma2.ispw.model.TipoProdotto;
import it.uniroma2.ispw.model.UtenteRegistrato;

public class PrezzoSpedizioneDAO {
	
	private static SessionFactory sessionFactory = buildSessionFactory();
	
	public PrezzoSpedizioneDAO(){}
	
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
	
	
	public PrezzoSpedizione addOrUpdatePrezzoSpedizione(PrezzoSpedizione ps){
		Session session = sessionFactory.openSession();
        Transaction tx = null;
            try{
                tx = session.beginTransaction();
                session.saveOrUpdate(ps);
                tx.commit();
                System.out.println("Nuova categoria aggiunta");
            }catch (HibernateException e) {
                if (tx!=null) tx.rollback();
                e.printStackTrace();
                System.out.println("Nuova categoria NON aggiunto");
                ps = null;
            }finally {
             session.close(); 
            }
            return ps;
    }
	
	public PrezzoSpedizione getPrezzoSpedizione(String tipoSpedizione){

		Session session = sessionFactory.openSession();
	    Transaction tx = null;
	    try{
	    	tx = session.beginTransaction();
	    	PrezzoSpedizione ps = (PrezzoSpedizione) session.get(PrezzoSpedizione.class, tipoSpedizione);
	    	System.out.println("Utente trovato");
	    	return ps;
	    }catch (HibernateException e) {
    		if (tx!=null) tx.rollback();
    		e.printStackTrace(); 
    	}finally {
         session.close(); 
    	}
		
	    return null;
		
	}
	
	

}
