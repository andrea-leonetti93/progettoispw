package it.uniroma2.ispw.persistence;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import it.uniroma2.ispw.model.Prodotto;

public class ProdottoDAO {

	
private static SessionFactory sessionFactory = buildSessionFactory();
	
	public ProdottoDAO(){}
	
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
	
	
	public Prodotto addProdotto(Prodotto prodotto){
		Session session = sessionFactory.openSession();
        Transaction tx = null;
            try{
                tx = session.beginTransaction();
                session.save(prodotto);
                tx.commit();
                System.out.println("Prodotto aggiunto");
            }catch (HibernateException e) {
                if (tx!=null) tx.rollback();
                e.printStackTrace();
                System.out.println("Prodotto NON aggiunto");
                prodotto = null;
            }finally {
             session.close(); 
            }
            return prodotto;
    }
	
}
