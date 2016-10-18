	package org.oweis.Lear_API.service;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.oweis.Lear_API.model.Family;

public class FamilyService {
	
	Family family;
	ArrayList<Family> familys;
	Session session;
	Criteria criteria;
	
	public FamilyService(){
		if(!ConnexionService.open){
		ConnexionService.openConnexion();
		}
		this.session = ConnexionService.session;
	}		

	public ArrayList<Family> getAllFamily(){
		criteria = session.createCriteria(Family.class).addOrder(Order.desc("date_creation"));
		familys = (ArrayList<Family>) criteria.list();
		session.flush();
	    session.clear();
		return familys;
		
	}
	
	public ArrayList<Family> getAllFamilysByNameUsedInLear(String nameUsedInLear){


		criteria = session.createCriteria(Family.class).
				add(Restrictions.eq("nameUsedInLear", nameUsedInLear)).
				addOrder(Order.desc("date_creation"));
		familys = (ArrayList<Family>) criteria.list();
		  session.flush();
	        session.clear();
	
		return familys;
	}
	
	public ArrayList<Family> getAllFamilysByNameUsedInClient(String nameUsedInClient){
	

		criteria = session.createCriteria(Family.class).
				add(Restrictions.eq("nameUsedInClient", nameUsedInClient)).
				addOrder(Order.desc("date_creation"));
		familys = (ArrayList<Family>) criteria.list();
		  session.flush();
	        session.clear();
	
		return familys;
	}
	
	public Family getFamily(int id){
	
		family = (Family) session.get(Family.class,id);	
		  session.flush();
	        session.clear();

		return family;
	}
	
	public Family getFamilyByNamePassByUser(String namePassByUser){
		
		criteria = session.createCriteria(Family.class).add(Restrictions.eq("namePassByUser",namePassByUser ));
		family = (Family) criteria.uniqueResult();
		  session.flush();
	        session.clear();
		
		return family;
	}
	
	public Family addFamily(Family family){
		

		session.save(family);
		  session.flush();
	        session.clear();
	
		
		return family;
	}
	
	public Family updateFamily(Family family){


		session.update(family);
		  session.flush();
	        session.clear();

		return family;
}

	public Family removeFamily(Family family){
			session.delete(family);
		  session.flush();
	        session.clear();
		
		return family;
}
	
	public Family removeFamily(int id){
	
		family = (Family) session.get(Family.class,id);
		session.delete(family);
		  session.flush();
	        session.clear();
	
		return family;
	}
	
	public void removeFamily(String namePassByUser){
	
		
		criteria = session.createCriteria(Family.class).add(Restrictions.eq("namePassByUser", namePassByUser));
		family = (Family) criteria.uniqueResult();
		session.delete(family);
		  session.flush();
	        session.clear();
	
	}
	
public void commitAll(){
	session.getTransaction().commit();
	session.close();
}
}

