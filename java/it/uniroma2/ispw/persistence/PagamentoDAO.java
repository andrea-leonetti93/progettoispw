package it.uniroma2.ispw.persistence;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import it.uniroma2.ispw.model.Pagamento;
import it.uniroma2.ispw.model.Prodotto;

public class PagamentoDAO {

private static SessionFactory sessionFactory = buildSessionFactory();
	
	public PagamentoDAO(){}
	
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
	
	public Pagamento addPagamento(Pagamento pagamento){
		Session session = sessionFactory.openSession();
        Transaction tx = null;
            try{
                tx = session.beginTransaction();
                session.save(pagamento);
                tx.commit();
                System.out.println("Pagamento aggiunto");
            }catch (HibernateException e) {
                if (tx!=null) tx.rollback();
                e.printStackTrace();
                System.out.println("Pagamento NON aggiunto");
                pagamento = null;
            }finally {
             session.close(); 
            }
		return pagamento;
	}
	
	public List<Pagamento> listaAcquistiUtente(String email){
		Session session = sessionFactory.openSession();
        Transaction tx = null;
        List<Pagamento> listaPag = null;
        try{
            tx = session.beginTransaction();
            String hql = "FROM Pagamento P WHERE P.utenteRegistrato.email = :email_pagamento";
            Query<Pagamento> query = session.createQuery(hql);
            query.setParameter("email_pagamento", email);
            /*for(Object o : query.list()){
            	listaP.add((Prodotto) o);
            }*/
            listaPag = query.getResultList();
            tx.commit();
            System.out.println("Lista pagamenti aggiunta");
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
            System.out.println("Lista pagamenti NON aggiunta");
            listaPag = null;
        }finally {
         session.close(); 
        }
        return listaPag;
	}
	
}
