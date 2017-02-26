package it.uniroma2.ispw.persistence;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import it.uniroma2.ispw.eccezioni.ErroreInserimentoProdotto;
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
	
	
	@SuppressWarnings({ "rawtypes", "deprecation" })
	public void checkProdottoPerUtente(String nomeP, String emailU) throws ErroreInserimentoProdotto{
		Session session = sessionFactory.openSession();
        Transaction tx = null;
        Prodotto p = null;
            try{
                tx = session.beginTransaction();
                String hql = "FROM Prodotto P WHERE (P.nome =: nomeP) AND (:emailU exist(FROM UtenteRegistrato U WHERE U.email =:emailU))";
				Query query = session.createQuery(hql);
				query.setParameter("nomeP", nomeP);
				query.setParameter("emailU", emailU);
				p = (Prodotto) query.getSingleResult();
                tx.commit();
                if(p == null){
                	throw new ErroreInserimentoProdotto();
                }
            }catch (HibernateException e) {
                if (tx!=null) tx.rollback();
                e.printStackTrace();
            }finally {
            	session.close(); 
            }
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
	
	@SuppressWarnings("deprecation")
	public List<Prodotto> listaProdottiUtente(String email){
		Session session = sessionFactory.openSession();
        Transaction tx = null;
        List<Prodotto> listaP = null;
            try{
                tx = session.beginTransaction();
                String hql = "FROM Prodotto P WHERE P.utenteRegistrato.email = :email_prodotto";
                @SuppressWarnings({ "unchecked" })
				Query<Prodotto> query = session.createQuery(hql);
                query.setParameter("email_prodotto", email);
                /*for(Object o : query.list()){
                	listaP.add((Prodotto) o);
                }*/
                listaP = query.getResultList();
                tx.commit();
                System.out.println("Lista prodotti aggiunta");
            }catch (HibernateException e) {
                if (tx!=null) tx.rollback();
                e.printStackTrace();
                System.out.println("Lista prodotti NON aggiunta");
                listaP = null;
            }finally {
            	session.close(); 
            }
            return listaP;
    
	}
	
	public boolean deleteProduct(int id){
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			Prodotto p = (Prodotto) session.get(Prodotto.class, id);
			session.delete(p);
			tx.commit();
			System.out.println("Prodotto eliminato");
		}catch(HibernateException e){
			if (tx!=null) tx.rollback();
            e.printStackTrace();
            System.out.println("Prodotto NON eliminato");
            return false;
		}finally {    
			session.close();
		}
		return true;
	}

	public Prodotto prendiProdottoPerID(int id) {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		Prodotto p = null;
		try{
			tx = session.beginTransaction();
			p = (Prodotto) session.get(Prodotto.class, id);
			tx.commit();
			System.out.println("Prodotto trovato");
		}catch(HibernateException e){
			if (tx!=null) tx.rollback();
            e.printStackTrace();
            System.out.println("Prodotto NON trovato");
            return p;
		}finally {    
		session.close();
		}
		return p;
	}

	public boolean updateProdotto(Prodotto productChange) {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.update(productChange);
			tx.commit();
			System.out.println("Prodotto aggiornato");
		}catch(HibernateException e){
			if (tx!=null) tx.rollback();
            e.printStackTrace();
            System.out.println("Prodotto NON aggiornato");
            return false;
		}finally {    
		session.close();
		}
		return true;
	}
	
	@SuppressWarnings("deprecation")
	public List<Prodotto> listaProdotti(){
		Session session = sessionFactory.openSession();
        Transaction tx = null;
        List<Prodotto> listaP = null;
            try{
                tx = session.beginTransaction();
                String hql = "FROM Prodotto P";
                @SuppressWarnings("unchecked")
				Query<Prodotto> query = session.createQuery(hql);
                listaP = query.getResultList();
                tx.commit();
                System.out.println("Lista prodotti aggiunta");
            }catch (HibernateException e) {
                if (tx!=null) tx.rollback();
                e.printStackTrace();
                System.out.println("Lista prodotti NON aggiunta");
                listaP = null;
            }finally {
             session.close(); 
            }
            return listaP;
    
	}
		
	
	
	

	
}
