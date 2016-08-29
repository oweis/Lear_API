package org.oweis.Lear_API.service;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.oweis.Lear_API.model.Wire;

public class WireService {
	
	Wire wire;
	ArrayList<Wire> wires;
	
	
	SessionFactory sessionFactory;
	
	Session session;
	Criteria criteria;
	
	public WireService(){
		sessionFactory = new Configuration().configure().buildSessionFactory();
	

		}		

	public ArrayList<Wire> getAllWire(){
		wires =  new ArrayList<>();
		
		session = sessionFactory.openSession();
		session.beginTransaction();

		criteria = session.createCriteria(Wire.class).
				addOrder(Order.desc("date_creation"));

		wires = (ArrayList<Wire>) criteria.list();
		return wires;
	}
	
	public ArrayList<Wire> getAllWiresByIdFamily(int idFamily){
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		criteria = session.createCriteria(Wire.class).
				add(Restrictions.eq("idFamily", idFamily)).
				addOrder(Order.desc("date_creation"));
		
		wires = (ArrayList<Wire>) criteria.list();
		
		session.getTransaction().commit();
		session.close();
		return wires;
	}
	
	public ArrayList<Wire> getAllWiresByIdPartNumber(int idPartNumber){
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		criteria = session.createCriteria(Wire.class).
				add(Restrictions.eq("idPartNumber", idPartNumber)).
				addOrder(Order.desc("date_creation"));
		
		wires = (ArrayList<Wire>) criteria.list();
		
		session.getTransaction().commit();
		session.close();
		return wires;
	}
	
	public ArrayList<Wire> getAllWiresByIdPartNumberAdapt(int idPartNumber){
		ArrayList<Wire> wires = this.getAllWiresByIdPartNumber(idPartNumber);
		AdaptWires adaptWires = new AdaptWires(wires);
		
		return adaptWires.updateWiresList();
	}
	
	public Wire getWire(int id){
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		

		wire = (Wire) session.get(Wire.class, id);
		
		session.getTransaction().commit();
		session.close();
		return wire;
	}
	
	public Wire getWireByNameWire(int idFamily,String nameWire){
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		criteria = session.createCriteria(Wire.class).
				add(Restrictions.eq("idFamily", idFamily)).
				add(Restrictions.eq("nameWire",nameWire));
		wire = (Wire) criteria.uniqueResult();
	
		
		session.getTransaction().commit();
		session.close();
		return wire;
	}
	
	public Wire addWire(Wire wire){
		
		session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(wire);

		session.getTransaction().commit();
		session.close();
		
		return wire;
	}
	
	public Wire updateWire(Wire wire){
		session = sessionFactory.openSession();
		session.beginTransaction();

		session.update(wire);
		
		session.getTransaction().commit();
		session.close();
		return wire;
	}
	

	public void removeAllWires(){
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		criteria = session.createCriteria(Wire.class);
		wires = (ArrayList<Wire>) criteria.list();
		
		for(Wire wire : wires)	session.delete(wire);
		session.getTransaction().commit();
		session.close();
	}
	
	public void removeAllWiresByIdFamily(int idFamily){
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		criteria = session.createCriteria(Wire.class).add(Restrictions.eq("idFamily",idFamily));
		wires = (ArrayList<Wire>) criteria.list();
		
		for(Wire wire : wires) session.delete(wire);
		session.getTransaction().commit();
		session.close();
	}
	
	public void removeAllWiresByIdPartNumber(int idPartNumber){
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		criteria = session.createCriteria(Wire.class).add(Restrictions.eq("idPartNumber",idPartNumber));
		wires = (ArrayList<Wire>) criteria.list();
		for(Wire wire : wires)	session.delete(wire);
		session.getTransaction().commit();
		session.close();
	}
	
	public Wire removeWire(Wire wire){
	session = sessionFactory.openSession();
	session.beginTransaction();

	session.delete(wire);
	
	session.getTransaction().commit();
	session.close();
	return wire;
	}
	
	public Wire removeWire(int id){
		session = sessionFactory.openSession();
		session.beginTransaction();

		wire = (Wire) session.get(Wire.class,id);
		session.delete(wire);
		
		session.getTransaction().commit();
		session.close();
		return wire;
	}
	
	public Wire removeWire(int idFamily,String nameWire){
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		criteria = session.createCriteria(Wire.class).
				add(Restrictions.eq("idFamily", idFamily)).
				add(Restrictions.eq("nameWire",nameWire));
		wire = (Wire) criteria.uniqueResult();
		
		session.delete(wire);		
		session.getTransaction().commit();
		session.close();
		return wire;
	}
	
	

}

