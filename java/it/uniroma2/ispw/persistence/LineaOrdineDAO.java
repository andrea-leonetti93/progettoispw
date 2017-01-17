package it.uniroma2.ispw.persistence;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import it.uniroma2.ispw.model.LineaOrdine;
import it.uniroma2.ispw.model.Pagamento;
import it.uniroma2.ispw.model.Prodotto;

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
	
	public LineaOrdine addLineaOrdine(LineaOrdine lineaOrdine){
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
	
	public List<LineaOrdine> listaVenditeUtente(Prodotto prodotto){
		Session session = sessionFactory.openSession();
        Transaction tx = null;
        List<LineaOrdine> listaLineaOr = null;
        try{
            tx = session.beginTransaction();
            String hql = "FROM LineaOrdine LO WHERE LO.prodotto.id = :id_prodotto";
            Query<LineaOrdine> query = session.createQuery(hql);
            query.setParameter("id_prodotto", prodotto.getId());
            /*for(Object o : query.list()){
            	listaP.add((Prodotto) o);
            }*/
            listaLineaOr = query.getResultList();
            tx.commit();
            System.out.println("Lista pagamenti aggiunta");
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
            System.out.println("Lista pagamenti NON aggiunta");
            listaLineaOr = null;
        }finally {
         session.close(); 
        }
        return listaLineaOr;
	}
}
