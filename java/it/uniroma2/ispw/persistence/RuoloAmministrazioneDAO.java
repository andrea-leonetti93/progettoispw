package it.uniroma2.ispw.persistence;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import it.uniroma2.ispw.model.RuoloAmministrazione;


public class RuoloAmministrazioneDAO {

private static SessionFactory sessionFactory = buildSessionFactory();
	
	public RuoloAmministrazioneDAO(){}
	
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
	
	public RuoloAmministrazione addAmministratore(RuoloAmministrazione ruoloAmmin){
		Session session = sessionFactory.openSession();
        Transaction tx = null;
            try{
                tx = session.beginTransaction();
                session.save(ruoloAmmin);
                tx.commit();
                System.out.println("RuoloAmministrazione aggiunto");
            }catch (HibernateException e) {
                if (tx!=null) tx.rollback();
                e.printStackTrace();
                System.out.println("RuoloAmministrazione NON aggiunto");
                ruoloAmmin = null;
            }finally {
             session.close(); 
            }
            return ruoloAmmin;
    }
	
}
