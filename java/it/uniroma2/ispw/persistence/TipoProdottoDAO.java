package it.uniroma2.ispw.persistence;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import it.uniroma2.ispw.model.TipoProdotto;


public class TipoProdottoDAO {

private static SessionFactory sessionFactory = buildSessionFactory();
	
	public TipoProdottoDAO(){}
	
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
	
	public TipoProdotto addTipoProdotto(TipoProdotto tipoProdotto){
		Session session = sessionFactory.openSession();
        Transaction tx = null;
            try{
                tx = session.beginTransaction();
                session.save(tipoProdotto);
                tx.commit();
                System.out.println("Nuova categoria aggiunta");
            }catch (HibernateException e) {
                if (tx!=null) tx.rollback();
                e.printStackTrace();
                System.out.println("Nuova categoria NON aggiunto");
                tipoProdotto = null;
            }finally {
             session.close(); 
            }
            return tipoProdotto;
    }

	/*get tipoProdotto*/
	
}
