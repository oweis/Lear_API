package org.oweis.Lear_API.service;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.oweis.Lear_API.model.Fixture_Pn;

public class Fixture_PnService {
	
	Fixture_Pn fixture_Pn;
	ArrayList<Fixture_Pn> fixture_Pns;
	SessionFactory sessionFactory;
	Session session;
	Criteria criteria;
	
	public Fixture_PnService(){
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}		

	public ArrayList<Fixture_Pn> getAllFixture_Pn(){
		System.out.println("getAllFixture_Pn");
		session = sessionFactory.openSession();
		session.beginTransaction();
		criteria = session.createCriteria(Fixture_Pn.class);
		fixture_Pns = (ArrayList<Fixture_Pn>) criteria.list();
		return fixture_Pns;
	}	
	
	public Fixture_Pn getFixture_Pn(String fixture_PnName){
		session = sessionFactory.openSession();
		session.beginTransaction();

		criteria = session.createCriteria(Fixture_Pn.class).add(Restrictions.eq("nameUsedInLear", fixture_PnName));
		fixture_Pn = (Fixture_Pn) criteria.uniqueResult();
				
		session.getTransaction().commit();
		session.close();
		return fixture_Pn;
	}
	

	public Fixture_Pn getFixture_Pn(int id){
		session = sessionFactory.openSession();
		session.beginTransaction();
		fixture_Pn = (Fixture_Pn) session.get(Fixture_Pn.class,id);				
		session.getTransaction().commit();
		session.close();
		return fixture_Pn;
	}
	
	
	
	public Fixture_Pn getLastFixture_Pn(){
		session = sessionFactory.openSession();
		session.beginTransaction();

		criteria = session.createCriteria(Fixture_Pn.class).setProjection(Projections.max("date_creation"));
		fixture_Pn = (Fixture_Pn) criteria.uniqueResult();
				
		session.getTransaction().commit();
		session.close();
		return fixture_Pn;
		
	}
	public Fixture_Pn addFixture_Pn(Fixture_Pn fixture_Pn){
		
		session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(fixture_Pn);

		session.getTransaction().commit();
		session.close();
		
		return fixture_Pn;
	}
	
	public Fixture_Pn updateFixture_Pn(Fixture_Pn fixture_Pn){
		session = sessionFactory.openSession();
		session.beginTransaction();

		session.update(fixture_Pn);
		
		session.getTransaction().commit();
		session.close();
		return fixture_Pn;
}
	
	public Fixture_Pn removeFixture_Pn(int id){
		session = sessionFactory.openSession();
		session.beginTransaction();

		fixture_Pn = (Fixture_Pn) session.get(Fixture_Pn.class,id);
		session.delete(fixture_Pn);
		
		session.getTransaction().commit();
		session.close();
		return fixture_Pn;
	}
	
	public Fixture_Pn removeFixture_Pn(String nameUsedInLear){
		session = sessionFactory.openSession();
		session.beginTransaction();

		criteria = session.createCriteria(Fixture_Pn.class).add(Restrictions.eq("nameUsedInLear", nameUsedInLear));
		fixture_Pns = (ArrayList<Fixture_Pn>) criteria.list();
		for(Fixture_Pn fixture_Pn:fixture_Pns){session.delete(fixture_Pn);}
		
		session.getTransaction().commit();
		session.close();
		return fixture_Pn;
	}

}

