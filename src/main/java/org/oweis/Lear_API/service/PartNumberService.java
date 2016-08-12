package org.oweis.Lear_API.service;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.oweis.Lear_API.model.Family;
import org.oweis.Lear_API.model.PartNumber;

public class PartNumberService {
	
	PartNumber partNumber;
	ArrayList<PartNumber> partNumbers;
	
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session;
	Criteria criteria;
	
	public PartNumberService(){}		

	public ArrayList<PartNumber> getAllPartNumber(){
		partNumbers =  new ArrayList<>();
		session = sessionFactory.openSession();
		session.beginTransaction();
		criteria = session.createCriteria(PartNumber.class);
		partNumbers = (ArrayList<PartNumber>) criteria.list();
		return partNumbers;
	}
	
	public ArrayList<PartNumber> getAllPartNumberByIdFamily(int idFamily){
		partNumbers =  new ArrayList<>();
		session = sessionFactory.openSession();
		session.beginTransaction();
		criteria = session.createCriteria(PartNumber.class).add(Restrictions.eq("idFamily", idFamily));
		partNumbers = (ArrayList<PartNumber>) criteria.list();
		return partNumbers;
	}
		
	public PartNumber getPartNumber(int id){
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		

		partNumber = (PartNumber) session.get(PartNumber.class, id);
		
		session.getTransaction().commit();
		session.close();
		return partNumber;
	}
	
	public PartNumber getPartNumberByNamePartNumber(int idFamily,String partNumberName){
		
		session = sessionFactory.openSession();
		session.beginTransaction();
	
		criteria = session.createCriteria(PartNumber.class).add(Restrictions.eq("idFamily",idFamily)).add(Restrictions.eq("nameUsedInLear", partNumberName));		
		partNumber = (PartNumber) criteria.uniqueResult();
		
		session.getTransaction().commit();
		session.close();
		return partNumber;
	}
	
	public PartNumber addPartNumber(PartNumber partNumber){
		
		session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(partNumber);

		session.getTransaction().commit();
		session.close();
		
		return partNumber;
	}
	
	public PartNumber updatePartNumber(PartNumber partNumber){
		session = sessionFactory.openSession();
		session.beginTransaction();

		session.update(partNumber);
		
		session.getTransaction().commit();
		session.close();
		return partNumber;
}
	
	public PartNumber removePartNumber(int id){
		session = sessionFactory.openSession();
		session.beginTransaction();

		partNumber = (PartNumber) session.get(PartNumber.class,id);
		session.delete(partNumber);
		
		session.getTransaction().commit();
		session.close();
		return partNumber;
	}

	public PartNumber removePartNumber(String nameUsedInLear){
		session = sessionFactory.openSession();
		session.beginTransaction();

		criteria = session.createCriteria(PartNumber.class).add(Restrictions.eq("nameUsedInLear", nameUsedInLear));
		partNumber = (PartNumber) criteria.uniqueResult();
		session.delete(partNumber);
		
		session.getTransaction().commit();
		session.close();
		return partNumber;
	}
}

