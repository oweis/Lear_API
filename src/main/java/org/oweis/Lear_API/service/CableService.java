package org.oweis.Lear_API.service;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.oweis.Lear_API.model.Family;
import org.oweis.Lear_API.model.Cable;

public class CableService {
	
	Cable cable;
	ArrayList<Cable> cables;
	
	Session session;
	Criteria criteria;
	
	public CableService(){
		if(!ConnexionService.open){
		ConnexionService.openConnexion();
		}
		this.session = ConnexionService.session;
	}		

	public ArrayList<Cable> getAllCables(){
		cables =  new ArrayList<>();
		
		criteria = session.createCriteria(Cable.class);
		cables = (ArrayList<Cable>) criteria.list();
		return cables;
	}
	
	public ArrayList<Cable> getAllCablesByIdFamily(int idFamily){
		cables =  new ArrayList<>();
	
		criteria = session.createCriteria(Cable.class).add(Restrictions.eq("idFamily", idFamily));
		cables = (ArrayList<Cable>) criteria.list();
		return cables;
	}
		
	public Cable getCable(int id){
	
		cable = (Cable) session.get(Cable.class, id);
		  session.flush();
	        session.clear();

		return cable;
	}
	
	public Cable getCableByNameUsedInLear(int idFamily,String nameUsedInLear){
		
	
	
		criteria = session.createCriteria(Cable.class).add(Restrictions.eq("idFamily",idFamily)).add(Restrictions.eq("nameUsedInLear", nameUsedInLear));		
		cable = (Cable) criteria.uniqueResult();
		  session.flush();
	        session.clear();
	
		return cable;
	}
	
	public Cable addCable(Cable partNumber){
	
		session.save(partNumber);
		  session.flush();
	        session.clear();
		
		return partNumber;
	}
	
	public Cable updateCable(Cable cable){
	

		session.update(cable);
		  session.flush();
	        session.clear();
	
		return cable;
	}
	

	public ArrayList<Cable> removeAllCables(){
		cables =  new ArrayList<>();

		criteria = session.createCriteria(Cable.class);
		
		cables = (ArrayList<Cable>) criteria.list();
		
		for(Cable cable : cables) session.delete(cable);
		  session.flush();
	        session.clear();
		
		return cables;
	}
	
	public ArrayList<Cable> removeAllCablesByIdFamily(int idFamily){
		cables =  new ArrayList<>();
	
		criteria = session.createCriteria(Cable.class).add(Restrictions.eq("idFamily", idFamily));
		cables = (ArrayList<Cable>) criteria.list();
		
		for(Cable cable : cables) {session.delete(cable);
		  session.flush();
	        session.clear();}

		return cables;
	}
	
	public Cable removeCable(Cable cable){
		

		session.delete(cable);
		  session.flush();
	        session.clear();

		return cable;
	}
	
	public Cable removeCable(int id){


		cable = (Cable) session.get(Cable.class,id);
		session.delete(cable);
		  session.flush();
	        session.clear();

		return cable;
	}

	public Cable removeCable(int idFamily,String nameUsedInLear){

		criteria = session.createCriteria(Cable.class).
				add(Restrictions.eq("idFamily",idFamily)).
				add(Restrictions.eq("nameUsedInLear", nameUsedInLear));
		cable = (Cable) criteria.uniqueResult();
		session.delete(cable);
		  session.flush();
	        session.clear();
	
		return cable;
	}
}

