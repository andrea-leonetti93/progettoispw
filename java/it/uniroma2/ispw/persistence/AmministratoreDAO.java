package it.uniroma2.ispw.persistence;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import it.uniroma2.ispw.model.Amministratore;
import it.uniroma2.ispw.model.UtenteRegistrato;


public class AmministratoreDAO {

private static SessionFactory sessionFactory = buildSessionFactory();
	
	public AmministratoreDAO(){}
	
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
	
	public Amministratore addAmministratore(Amministratore amministratore){
		Session session = sessionFactory.openSession();
        Transaction tx = null;
            try{
                tx = session.beginTransaction();
                session.save(amministratore);
                tx.commit();
                System.out.println("Amministratore aggiunto");
            }catch (HibernateException e) {
                if (tx!=null) tx.rollback();
                e.printStackTrace();
                System.out.println("Amministratore NON aggiunto");
                amministratore = null;
            }finally {
             session.close(); 
            }
            return amministratore;
    }
	
	
	public Amministratore checkAmministratore(String email, String password){
		Session session = sessionFactory.openSession();
	    Transaction tx = null;
	    try{
	    	tx = session.beginTransaction();
	    	Amministratore admin = (Amministratore) session.get(Amministratore.class, email);
<<<<<<< HEAD
	    	System.out.println("Utente trovato");
=======
	    	System.out.println("Amministratore trovato");
>>>>>>> 76b2ee3095ab7baaa6f1a2b0a0febf89ab5e6df2
	    	if(admin != null){
	    		if(admin.getPassword().equals(password)){
	    			return admin;
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
<<<<<<< HEAD
=======
	
>>>>>>> 76b2ee3095ab7baaa6f1a2b0a0febf89ab5e6df2
}
