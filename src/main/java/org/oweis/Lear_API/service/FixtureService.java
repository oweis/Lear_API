package org.oweis.Lear_API.service;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.oweis.Lear_API.model.Fixture;
import org.oweis.Lear_API.model.Wire;

public class FixtureService {
	
	Fixture fixture;
	ArrayList<Fixture> fixtures;
	
	
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session;
	Criteria criteria;
	
	public FixtureService(){}		

	public ArrayList<Fixture> getAllFixture(){
		fixtures =  new ArrayList<>();
		session = sessionFactory.openSession();
		session.beginTransaction();
		criteria = session.createCriteria(Fixture.class);
		fixtures = (ArrayList<Fixture>) criteria.list();
		return fixtures;
	}
		
	public Fixture getFixture(int id){
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		

		fixture = (Fixture) session.get(Fixture.class, id);
		
		session.getTransaction().commit();
		session.close();
		return fixture;
	}
	
	
	public Fixture getFixture(String name){
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		criteria = session.createCriteria(Fixture.class).add(Restrictions.eq("name",name));
		fixture = (Fixture) criteria.uniqueResult();
		
		session.getTransaction().commit();
		session.close();
		return fixture;
	}
	
	public Fixture addFixture(Fixture fixture){
		
		session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(fixture);

		session.getTransaction().commit();
		session.close();
		
		return fixture;
	}
	
	public Fixture updateFixture(Fixture fixture){
		session = sessionFactory.openSession();
		session.beginTransaction();

		session.update(fixture);
		
		session.getTransaction().commit();
		session.close();
		return fixture;
}
	
	public Fixture removeFixture(int id){
		session = sessionFactory.openSession();
		session.beginTransaction();

		fixture = (Fixture) session.get(Fixture.class,id);
		session.delete(fixture);
		
		session.getTransaction().commit();
		session.close();
		return fixture;
	}

	public Fixture removeFixture(String name){
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		criteria = session.createCriteria(Fixture.class).add(Restrictions.eq("name",name));
		fixture = (Fixture) criteria.uniqueResult();
		
		session.delete(fixture);
		
		session.getTransaction().commit();
		session.close();
		return fixture;
	}
	
}

