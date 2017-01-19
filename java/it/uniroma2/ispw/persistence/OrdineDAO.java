package it.uniroma2.ispw.persistence;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import it.uniroma2.ispw.model.Ordine;
import it.uniroma2.ispw.model.Prodotto;

public class OrdineDAO {

private static SessionFactory sessionFactory = buildSessionFactory();
	
	public OrdineDAO(){}
	
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
	
	public Ordine addOrdine(Ordine ordine){
		Session session = sessionFactory.openSession();
        Transaction tx = null;
            try{
                tx = session.beginTransaction();
                session.save(ordine);
                tx.commit();
                System.out.println("Ordine aggiunto");
            }catch (HibernateException e) {
                if (tx!=null) tx.rollback();
                e.printStackTrace();
                System.out.println("Ordine NON aggiunto");
                ordine = null;
            }finally {
             session.close(); 
            }
		return ordine;
	}
	
	public List<Ordine> listaOrdini(){
		Session session = sessionFactory.openSession();
        Transaction tx = null;
        List<Ordine> listaOrd = null;
            try{
                tx = session.beginTransaction();
                String hql = "FROM Ordine O";
                Query<Ordine> query = session.createQuery(hql);
                listaOrd = query.getResultList();
                tx.commit();
                System.out.println("Lista prodotti aggiunta");
            }catch (HibernateException e) {
                if (tx!=null) tx.rollback();
                e.printStackTrace();
                System.out.println("Lista prodotti NON aggiunta");
                listaOrd = null;
            }finally {
             session.close(); 
            }
            return listaOrd;
    
	}
	
}
