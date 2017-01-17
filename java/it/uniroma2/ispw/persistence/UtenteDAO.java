package it.uniroma2.ispw.persistence;


import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;

import it.uniroma2.ispw.model.UtenteRegistrato;


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
	
	public UtenteRegistrato checkUtente(String email, String password){
		Session session = sessionFactory.openSession();
	    Transaction tx = null;
	    try{
	    	tx = session.beginTransaction();
	    	UtenteRegistrato u = (UtenteRegistrato) session.get(UtenteRegistrato.class, email);
	    	System.out.println("Utente trovato");
	    	if(u != null){
	    		if(u.getPassword().equals(password)){
	    			return u;
	    		}
	    	}
	    }catch (HibernateException e) {
    		if (tx!=null) tx.rollback();
    		e.printStackTrace(); 
    	}finally {
         session.close(); 
    	}
		return null;
	}
	
	public UtenteRegistrato getUtente(String email){

		Session session = sessionFactory.openSession();
	    Transaction tx = null;
	    try{
	    	tx = session.beginTransaction();
	    	UtenteRegistrato u = (UtenteRegistrato) session.get(UtenteRegistrato.class, email);
	    	System.out.println("Utente trovato");
	    	return u;
	    }catch (HibernateException e) {
    		if (tx!=null) tx.rollback();
    		e.printStackTrace(); 
    	}finally {
         session.close(); 
    	}
		
	    return null;
		
	}
	

	public UtenteRegistrato getUtenteByUserid(String userid){
		Session session = sessionFactory.openSession();
	    Transaction tx = null;
	    try{
	    	tx = session.beginTransaction();
	    	@SuppressWarnings("unchecked")
	    	List<UtenteRegistrato> utenti = session.createQuery("FROM UtenteRegistrato").getResultList();
	        for (Iterator<UtenteRegistrato> iterator = utenti.iterator(); iterator.hasNext();){
	        	UtenteRegistrato u = (UtenteRegistrato) iterator.next();
	        	if (u.getUserid().equals(userid)) return u;}
	        tx.commit();
	    
	    }catch (HibernateException e) {
	    	if (tx!=null) tx.rollback();
	    	e.printStackTrace(); 
	   }finally {
		   session.close(); 
	   }
	    return null;
	}
	
	public UtenteRegistrato modificaUtente(UtenteRegistrato utente){
		
		Session session = sessionFactory.openSession();
	    Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.update(utente);
            tx.commit();
            System.out.println("Utente modificato");
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
            System.out.println("Utente non modificato");
            utente = null;
        }finally {
         session.close(); 
        }
        return utente;
	}
	
	public List<UtenteRegistrato> listaUtenti(){
		Session session = sessionFactory.openSession();
        Transaction tx = null;
        List<UtenteRegistrato> listaU = null;
            try{
                tx = session.beginTransaction();
                String hql = "FROM UtenteRegistrato u";
                Query query = session.createQuery(hql);
                listaU = query.getResultList();
                tx.commit();
                System.out.println("Lista prodotti aggiunta");
            }catch (HibernateException e) {
                if (tx!=null) tx.rollback();
                e.printStackTrace();
                System.out.println("Lista prodotti NON aggiunta");
                listaU = null;
            }finally {
             session.close(); 
            }
            return listaU;
	}
	
}
