package it.uniroma2.ispw.persistence;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import it.uniroma2.ispw.model.LineaOrdine;

public class LineaOrdineDAO {
	
private static SessionFactory sessionFactory = buildSessionFactory();
	
	public LineaOrdineDAO(){}
	
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
	
	public LineaOrdine addOrdine(LineaOrdine lineaOrdine){
		Session session = sessionFactory.openSession();
        Transaction tx = null;
            try{
                tx = session.beginTransaction();
                session.save(lineaOrdine);
                tx.commit();
                System.out.println("Linea ordine aggiunta");
            }catch (HibernateException e) {
                if (tx!=null) tx.rollback();
                e.printStackTrace();
                System.out.println("Linea ordine NON aggiunta");
                lineaOrdine = null;
            }finally {
             session.close(); 
            }
		return lineaOrdine;
	}
}
