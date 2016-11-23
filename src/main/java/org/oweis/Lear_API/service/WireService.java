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
	Session session;
	Criteria criteria;
	
	public WireService(){
		if(!ConnexionService.open){
		ConnexionService.openConnexion();
		}
		this.session = ConnexionService.session;
		}		

	public ArrayList<Wire> getAllWire(){
		wires =  new ArrayList<>();


		criteria = session.createCriteria(Wire.class).
				addOrder(Order.desc("date_creation"));

		wires = (ArrayList<Wire>) criteria.list();
		return wires;
	}
	
	public ArrayList<Wire> getAllWiresByIdFamily(int idFamily){
		
		criteria = session.createCriteria(Wire.class).
				add(Restrictions.eq("idFamily", idFamily));
		
		wires = (ArrayList<Wire>) criteria.list();
		  session.flush();
	        session.clear();
		
		return wires;
	}
	
	public ArrayList<Wire> getAllWiresByIdCable(int idCable){
		
		criteria = session.createCriteria(Wire.class).
				add(Restrictions.eq("idCable", idCable));
		
		wires = (ArrayList<Wire>) criteria.list();
		session.flush();
	    session.clear();
		return wires;
	}
	
	public ArrayList<Wire> getAllWiresByIdCableAdapt(int idCable){
		
		ArrayList<Wire> wires = this.getAllWiresByIdCable(idCable);
		AdaptWires adaptWires = new AdaptWires(wires);
		return adaptWires.updateWiresList();
	}
	
	public Wire getWire(int id){

		wire = (Wire) session.get(Wire.class, id);
		  session.flush();
	        session.clear();

		return wire;
	}
	
	public Wire getWireByNameWire(int idFamily,String nameWire){
		
		
		criteria = session.createCriteria(Wire.class).
				add(Restrictions.eq("idFamily", idFamily)).
				add(Restrictions.eq("nameWire",nameWire));
		wire = (Wire) criteria.uniqueResult();
	
		  session.flush();
	        session.clear();

		return wire;
	}
	
	public Wire addWire(Wire wire){
		
	
		session.save(wire);
		  session.flush();
	        session.clear();
	
		
		return wire;
	}
	
	public Wire updateWire(Wire wire){
		
		session.update(wire);
		  session.flush();
	        session.clear();
	
		return wire;
	}
	

	public void removeAllWires(){
		
	
		criteria = session.createCriteria(Wire.class);
		wires = (ArrayList<Wire>) criteria.list();
		
		for(Wire wire : wires)	session.delete(wire);
		
		  session.flush();
	        session.clear();
	     
	}
	
	public void removeAllWiresByIdFamily(int idFamily){
		
		
		criteria = session.createCriteria(Wire.class).add(Restrictions.eq("idFamily",idFamily));
		wires = (ArrayList<Wire>) criteria.list();
		
		for(Wire wire : wires) {session.delete(wire);
		  session.flush();
	        session.clear();}
	}
	
	public void removeAllWiresByIdCable(int idCable){
		
		
		criteria = session.createCriteria(Wire.class).add(Restrictions.eq("idCable",idCable));
		wires = (ArrayList<Wire>) criteria.list();
		for(Wire wire : wires)	{session.delete(wire);
		  session.flush();
	        session.clear();}
	}
	
	public Wire removeWire(Wire wire){
	

	session.delete(wire);
	  session.flush();
      session.clear();

	return wire;
	}
	
	public Wire removeWire(int id){
	
		wire = (Wire) session.get(Wire.class,id);
		session.delete(wire);
		  session.flush();
	        session.clear();
	
		return wire;
	}
	
	public Wire removeWire(int idFamily,String nameWire){
		
		criteria = session.createCriteria(Wire.class).
				add(Restrictions.eq("idFamily", idFamily)).
				add(Restrictions.eq("nameWire",nameWire));
		wire = (Wire) criteria.uniqueResult();
		  session.flush();
	        session.clear();
		session.delete(wire);		

		return wire;
	}
	
	

}

