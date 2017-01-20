package it.uniroma2.ispw.persistence;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import it.uniroma2.ispw.model.Prodotto;
import it.uniroma2.ispw.model.TipoProdotto;
import it.uniroma2.ispw.model.UtenteRegistrato;


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

	public boolean deleteTipoProdotto(TipoProdotto tp){
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.delete(tp);
			tx.commit();
			System.out.println("Tipo Prodotto eliminato");
		}catch(HibernateException e){
			if (tx!=null) tx.rollback();
            e.printStackTrace();
            System.out.println("Tipo Prodotto NON eliminato");
            return false;
		}finally {    
		session.close();
		}
		return true;
	}
	
	public List<TipoProdotto> listaTipiProdotto(){
		Session session = sessionFactory.openSession();
        Transaction tx = null;
        List<TipoProdotto> listaTP = null;
            try{
                tx = session.beginTransaction();
                String hql = "FROM TipoProdotto tp";
                Query query = session.createQuery(hql);
                listaTP = query.getResultList();
                tx.commit();
                System.out.println("Lista prodotti aggiunta");
            }catch (HibernateException e) {
                if (tx!=null) tx.rollback();
                e.printStackTrace();
                System.out.println("Lista prodotti NON aggiunta");
                listaTP = null;
            }finally {
             session.close(); 
            }
            return listaTP;
	}
	
}
