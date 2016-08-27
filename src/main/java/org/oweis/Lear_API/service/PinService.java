package org.oweis.Lear_API.service;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.oweis.Lear_API.model.Pin;

public class PinService {
	
	Pin pin;
	ArrayList<Pin> pins;
	SessionFactory sessionFactory;
	Session session;
	Criteria criteria;
	
	public PinService(){
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}		

	public ArrayList<Pin> getAllPins(){
		System.out.println("getAllPin");
		session = sessionFactory.openSession();
		session.beginTransaction();
		criteria = session.createCriteria(Pin.class);
		pins = (ArrayList<Pin>) criteria.list();
		return pins;
	}	
	
	public ArrayList<Pin> getAllPinsByIdFamily(int idFamily){
		System.out.println("getAllPin");
		session = sessionFactory.openSession();
		session.beginTransaction();
		criteria = session.createCriteria(Pin.class).add(Restrictions.eq("idFamily",idFamily));
		pins = (ArrayList<Pin>) criteria.list();
		return pins;
	}	
	
	public ArrayList<Pin> getAllPinsByIdFixture(int idFixture){
		System.out.println("getAllPin");
		session = sessionFactory.openSession();
		session.beginTransaction();
		criteria = session.createCriteria(Pin.class).add(Restrictions.eq("idFixture",idFixture));
		pins = (ArrayList<Pin>) criteria.list();
		return pins;
	}	
	
	public Pin getPin(int id){
		session = sessionFactory.openSession();
		session.beginTransaction();
		pin = (Pin) session.get(Pin.class,id);				
		session.getTransaction().commit();
		session.close();
		return pin;
	}
	
	public Pin getPinByNamePin(int idFamily,String namePin){
		session = sessionFactory.openSession();
		session.beginTransaction();

		criteria = session.createCriteria(Pin.class).add(Restrictions.eq("idFamily",idFamily)).add(Restrictions.eq("namePin", namePin));
		pin = (Pin) criteria.uniqueResult();
				
		session.getTransaction().commit();
		session.close();
		return pin;
	}
	

	
	
	public Pin addPin(Pin pin){
		
		session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(pin);

		session.getTransaction().commit();
		session.close();
		
		return pin;
	}
	
	public Pin updatePin(Pin pin){
		session = sessionFactory.openSession();
		session.beginTransaction();

		session.update(pin);
		
		session.getTransaction().commit();
		session.close();
		return pin;
	}
	
	public ArrayList<Pin> removeAllPins(){
		session = sessionFactory.openSession();
		session.beginTransaction();

		criteria = session.createCriteria(Pin.class);
		pins = (ArrayList<Pin>) criteria.list();
		for(Pin pin:pins){session.delete(pin);}
		
		session.getTransaction().commit();
		session.close();
		return pins;
	}
	
	public ArrayList<Pin> removeAllPinsByIdFamily(int idFamily){
		session = sessionFactory.openSession();
		session.beginTransaction();

		criteria = session.createCriteria(Pin.class).add(Restrictions.eq("idFamily",idFamily));
		pins = (ArrayList<Pin>) criteria.list();
		for(Pin pin:pins){session.delete(pin);}
		
		session.getTransaction().commit();
		session.close();
		return pins;
	}
	
	public ArrayList<Pin> removeAllPinsByIdFixture(int idFixture){
		session = sessionFactory.openSession();
		session.beginTransaction();

		criteria = session.createCriteria(Pin.class).add(Restrictions.eq("idFixture",idFixture));
		pins = (ArrayList<Pin>) criteria.list();
		for(Pin pin:pins){session.delete(pin);}
		
		session.getTransaction().commit();
		session.close();
		return pins;
	}
	
	public Pin removePin(int id){
		session = sessionFactory.openSession();
		session.beginTransaction();

		pin = (Pin) session.get(Pin.class,id);
		session.delete(pin);
		
		session.getTransaction().commit();
		session.close();
		return pin;
	}
	
	public Pin removePin(Pin pin){
		session = sessionFactory.openSession();
		session.beginTransaction();

		session.delete(pin);
		
		session.getTransaction().commit();
		session.close();
		return pin;
	}
	
	public Pin removePin(int idFamily, String namePin){
		session = sessionFactory.openSession();
		session.beginTransaction();

		criteria = session.createCriteria(Pin.class).add(Restrictions.eq("idFamily",idFamily)).add(Restrictions.eq("namePin", namePin));
		pin = (Pin) criteria.uniqueResult();
		session.delete(pin);
		session.getTransaction().commit();
		session.close();
		return pin;
	}

}

