	package org.oweis.Lear_API.service;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.oweis.Lear_API.model.Family;

public class FamilyService {
	
	Family family;
	ArrayList<Family> familys;
	SessionFactory sessionFactory;
	Session session;
	Criteria criteria;
	
	public FamilyService(){
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}		

	public ArrayList<Family> getAllFamily(){
		System.out.println("getAllFamily");
		session = sessionFactory.openSession();
		session.beginTransaction();
		criteria = session.createCriteria(Family.class);
		familys = (ArrayList<Family>) criteria.list();
		session.getTransaction().commit();
		session.close();
		return familys;
		
	}	
	
	public Family getFamily(int id){
		session = sessionFactory.openSession();
		session.beginTransaction();
		family = (Family) session.get(Family.class,id);				
		session.getTransaction().commit();
		session.close();
		return family;
	}
	
	public Family getFamilyByNameUsedInLear(String nameUsedInLear){
		session = sessionFactory.openSession();
		session.beginTransaction();

		criteria = session.createCriteria(Family.class).add(Restrictions.eq("nameUsedInLear", nameUsedInLear));
		family = (Family) criteria.list().get(0);
		session.getTransaction().commit();
		session.close();
		return family;
	}
	
	public Family getFamilyByNamePassByUser(String namePassByUser){
		session = sessionFactory.openSession();
		session.beginTransaction();
		criteria = session.createCriteria(Family.class).add(Restrictions.eq("namePassByUser",namePassByUser ));
		family = (Family) criteria.list().get(0);
		session.getTransaction().commit();
		session.close();
		return family;
	}
	
	public Family getLastFamily(){
		session = sessionFactory.openSession();
		session.beginTransaction();

		criteria = session.createCriteria(Family.class).setProjection(Projections.max("date_creation"));
		family = (Family) criteria.uniqueResult();
				
		session.getTransaction().commit();
		session.close();
		return family;
		
	}

	public Family addFamily(Family family){
		
		session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(family);

		session.getTransaction().commit();
		session.close();
		
		return family;
	}
	
	public Family updateFamily(Family family){
		session = sessionFactory.openSession();
		session.beginTransaction();

		session.update(family);
		
		session.getTransaction().commit();
		session.close();
		return family;
}

	public Family removeFamily(Family family){
		session = sessionFactory.openSession();
		session.beginTransaction();

		session.delete(family);
		
		session.getTransaction().commit();
		session.close();
		return family;
}
	
	public Family removeFamily(int id){
		session = sessionFactory.openSession();
		session.beginTransaction();

		family = (Family) session.get(Family.class,id);
		session.delete(family);
		
		session.getTransaction().commit();
		session.close();
		return family;
	}
	
	public Family removeFamily(String namePassByUser){
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		criteria = session.createCriteria(Family.class).add(Restrictions.eq("namePassByUser", namePassByUser));
		familys = (ArrayList<Family>) criteria.list();
		for(Family family:familys){session.delete(family);}
		
		session.getTransaction().commit();
		session.close();
		return family;
	}

}

