package org.oweis.Lear_API.service;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.oweis.Lear_API.model.Family;
import org.oweis.Lear_API.model.PartNumber;

public class PartNumberService {
	
	PartNumber partNumber;
	ArrayList<PartNumber> partNumbers;
	
	Session session;
	Criteria criteria;
	
	public PartNumberService(){
		if(!ConnexionService.open){
		ConnexionService.openConnexion();
		}
		this.session = ConnexionService.session;
	}		

	public ArrayList<PartNumber> getAllPartNumbers(){
		partNumbers =  new ArrayList<>();
		
		criteria = session.createCriteria(PartNumber.class).addOrder(Order.desc("date_creation"));
		partNumbers = (ArrayList<PartNumber>) criteria.list();
		return partNumbers;
	}
	
	public ArrayList<PartNumber> getAllPartNumbersByIdFamily(int idFamily){
		partNumbers =  new ArrayList<>();
	
		criteria = session.createCriteria(PartNumber.class).add(Restrictions.eq("idFamily", idFamily)).addOrder(Order.desc("date_creation"));
		partNumbers = (ArrayList<PartNumber>) criteria.list();
		return partNumbers;
	}
		
	public PartNumber getPartNumber(int id){
	
		partNumber = (PartNumber) session.get(PartNumber.class, id);
		  session.flush();
	        session.clear();

		return partNumber;
	}
	
	public PartNumber getPartNumberByNameUsedInLear(int idFamily,String nameUsedInLear){
		
	
	
		criteria = session.createCriteria(PartNumber.class).add(Restrictions.eq("idFamily",idFamily)).add(Restrictions.eq("nameUsedInLear", nameUsedInLear));		
		partNumber = (PartNumber) criteria.uniqueResult();
		  session.flush();
	        session.clear();
	
		return partNumber;
	}
	
	public PartNumber addPartNumber(PartNumber partNumber){
	
		session.save(partNumber);
		  session.flush();
	        session.clear();
		
		return partNumber;
	}
	
	public PartNumber updatePartNumber(PartNumber partNumber){
	

		session.update(partNumber);
		  session.flush();
	        session.clear();
	
		return partNumber;
	}
	

	public ArrayList<PartNumber> removeAllPartNumbers(){
		partNumbers =  new ArrayList<>();

		criteria = session.createCriteria(PartNumber.class);
		
		partNumbers = (ArrayList<PartNumber>) criteria.list();
		
		for(PartNumber partNumber : partNumbers) session.delete(partNumber);
		  session.flush();
	        session.clear();
		
		return partNumbers;
	}
	
	public ArrayList<PartNumber> removeAllPartNumbersByIdFamily(int idFamily){
		partNumbers =  new ArrayList<>();
	
		criteria = session.createCriteria(PartNumber.class).add(Restrictions.eq("idFamily", idFamily)).addOrder(Order.desc("date_creation"));
		partNumbers = (ArrayList<PartNumber>) criteria.list();
		
		for(PartNumber partNumber : partNumbers) {session.delete(partNumber);
		  session.flush();
	        session.clear();}

		return partNumbers;
	}
	
	public PartNumber removePartNumber(PartNumber partNumber){
		

		session.delete(partNumber);
		  session.flush();
	        session.clear();

		return partNumber;
	}
	
	public PartNumber removePartNumber(int id){


		partNumber = (PartNumber) session.get(PartNumber.class,id);
		session.delete(partNumber);
		  session.flush();
	        session.clear();

		return partNumber;
	}

	public PartNumber removePartNumber(int idFamily,String nameUsedInLear){

		criteria = session.createCriteria(PartNumber.class).
				add(Restrictions.eq("idFamily",idFamily)).
				add(Restrictions.eq("nameUsedInLear", nameUsedInLear));
		partNumber = (PartNumber) criteria.uniqueResult();
		session.delete(partNumber);
		  session.flush();
	        session.clear();
	
		return partNumber;
	}
}

