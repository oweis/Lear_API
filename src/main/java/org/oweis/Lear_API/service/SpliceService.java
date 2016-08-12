package org.oweis.Lear_API.service;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.oweis.Lear_API.model.Splice;
import org.oweis.Lear_API.model.Wire;

public class SpliceService {
	
	Splice splice;
	ArrayList<Splice> splices;
	
	
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session;
	Criteria criteria;
	
	public SpliceService(){}		

	public ArrayList<Splice> getAllSplice(){
		splices =  new ArrayList<>();
		session = sessionFactory.openSession();
		session.beginTransaction();
		criteria = session.createCriteria(Splice.class);
		splices = (ArrayList<Splice>) criteria.list();
		return splices;
	}
	
	public ArrayList<Splice> getAllSpliceByIdFamily(int idFamily){
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		criteria = session.createCriteria(Splice.class).add(Restrictions.eq("idFamily",idFamily));
		splices =  (ArrayList<Splice>) criteria.list();
		
		session.getTransaction().commit();
		session.close();
		return splices;
	}
	
	
	public Splice getSplice(int id){
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		splice = (Splice) session.get(Splice.class, id);
		
		session.getTransaction().commit();
		session.close();
		return splice;
	}
	
	public Splice getSpliceByNameSplice(int idFamily,String nameSplice){
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		criteria = session.createCriteria(Splice.class).add(Restrictions.eq("idFamily",idFamily)).add(Restrictions.eq("nameSplice",nameSplice));
		splice = (Splice) criteria.uniqueResult();
		
		session.getTransaction().commit();
		session.close();
		return splice;
	}
	
	public Splice addSplice(Splice splice){
		
		session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(splice);

		session.getTransaction().commit();
		session.close();
		
		return splice;
	}
	
	public Splice updateSplice(Splice splice){
		session = sessionFactory.openSession();
		session.beginTransaction();

		session.update(splice);
		
		session.getTransaction().commit();
		session.close();
		return splice;
}
	public Splice removeSplice(Splice splice){
		session = sessionFactory.openSession();
		session.beginTransaction();

		session.delete(splice);
		
		session.getTransaction().commit();
		session.close();
		return splice;
}
	
	public Splice removeSplice(int id){
		session = sessionFactory.openSession();
		session.beginTransaction();

		splice = (Splice) session.get(Splice.class,id);
		session.delete(splice);
		
		session.getTransaction().commit();
		session.close();
		return splice;
	}
	
	public Splice removeSplice(String nameSplice){
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		criteria = session.createCriteria(Splice.class).add(Restrictions.eq("nameSplice",nameSplice));
		splice = (Splice) criteria.uniqueResult();
		
		session.delete(splice);
		
		session.getTransaction().commit();
		session.close();
		return splice;
	}

}

