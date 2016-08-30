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
		if(!ConnexionService.open){
		ConnexionService.openConnexion();
		}
		this.session = ConnexionService.session;
	}		

	public ArrayList<Pin> getAllPins(){
		
		criteria = session.createCriteria(Pin.class);
		pins = (ArrayList<Pin>) criteria.list();
		return pins;
	}	
	
	public ArrayList<Pin> getAllPinsByIdFamily(int idFamily){

		criteria = session.createCriteria(Pin.class).add(Restrictions.eq("idFamily",idFamily));
		pins = (ArrayList<Pin>) criteria.list();
		return pins;
	}	
	
	public ArrayList<Pin> getAllPinsByIdFixture(int idFixture){
	
		criteria = session.createCriteria(Pin.class).add(Restrictions.eq("idFixture",idFixture));
		pins = (ArrayList<Pin>) criteria.list();
		return pins;
	}	
	
	public Pin getPin(int id){
	
		pin = (Pin) session.get(Pin.class,id);				
		  session.flush();
	        session.clear();
		return pin;
	}
	
	public Pin getPinByNamePin(int idFamily,String namePin){
	

		criteria = session.createCriteria(Pin.class).add(Restrictions.eq("idFamily",idFamily)).add(Restrictions.eq("namePin", namePin));
		pin = (Pin) criteria.uniqueResult();
		  session.flush();
	        session.clear();	

		return pin;
	}
	

	
	
	public Pin addPin(Pin pin){
		
	
		session.save(pin);
		  session.flush();
	        session.clear();

		
		return pin;
	}
	
	public Pin updatePin(Pin pin){


		session.update(pin);
		  session.flush();
	        session.clear();
		
		return pin;
	}
	
	public ArrayList<Pin> removeAllPins(){
	

		criteria = session.createCriteria(Pin.class);
		pins = (ArrayList<Pin>) criteria.list();
		for(Pin pin:pins){session.delete(pin);}
		  session.flush();
	        session.clear();

		return pins;
	}
	
	public ArrayList<Pin> removeAllPinsByIdFamily(int idFamily){
		
		criteria = session.createCriteria(Pin.class).add(Restrictions.eq("idFamily",idFamily));
		pins = (ArrayList<Pin>) criteria.list();
		for(Pin pin:pins){session.delete(pin);}
		  session.flush();
	        session.clear();

		return pins;
	}
	
	public ArrayList<Pin> removeAllPinsByIdFixture(int idFixture){
	
		criteria = session.createCriteria(Pin.class).add(Restrictions.eq("idFixture",idFixture));
		pins = (ArrayList<Pin>) criteria.list();
		for(Pin pin:pins){session.delete(pin);}
		  session.flush();
	        session.clear();
		
		return pins;
	}
	
	public Pin removePin(int id){
	

		pin = (Pin) session.get(Pin.class,id);
		session.delete(pin);
		  session.flush();
	        session.clear();

		return pin;
	}
	
	public Pin removePin(Pin pin){
		
		session.delete(pin);
		  session.flush();
	        session.clear();
	
		return pin;
	}
	
	public Pin removePin(int idFamily, String namePin){
	
		criteria = session.createCriteria(Pin.class).add(Restrictions.eq("idFamily",idFamily)).add(Restrictions.eq("namePin", namePin));
		pin = (Pin) criteria.uniqueResult();
		session.delete(pin);
		  session.flush();
	        session.clear();
	
		return pin;
	}

}

