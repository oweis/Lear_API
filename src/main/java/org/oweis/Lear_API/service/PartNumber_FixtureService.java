package org.oweis.Lear_API.service;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.oweis.Lear_API.model.Family;
import org.oweis.Lear_API.model.Fixture;
import org.oweis.Lear_API.model.PartNumber_Fixture;
import org.oweis.Lear_API.model.PartNumber_Fixture;

public class PartNumber_FixtureService {

	PartNumber_Fixture partNumber_Fixture;
	ArrayList<PartNumber_Fixture> partNumber_Fixtures;
	SessionFactory sessionFactory;
	Session session;
	Criteria criteria;
	
	public PartNumber_FixtureService() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	public ArrayList<PartNumber_Fixture> getAllPartNumber_FixturesByIdPartNumber(int idPartNumber){
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		criteria = session.createCriteria(PartNumber_Fixture.class).
				add(Restrictions.eq("idPartNumber", idPartNumber));
		
		partNumber_Fixtures = (ArrayList<PartNumber_Fixture>) criteria.list();
		
		session.getTransaction().commit();
		session.close();
		return partNumber_Fixtures;
	}
	
	public PartNumber_Fixture getPartNumber_Fixture(int id){
		session = sessionFactory.openSession();
		session.beginTransaction();
		partNumber_Fixture = (PartNumber_Fixture) session.get(PartNumber_Fixture.class,id);				
		session.getTransaction().commit();
		session.close();
		return partNumber_Fixture;
	}

	public PartNumber_Fixture addPartNumber_Fixture(PartNumber_Fixture partNumber_Fixture){

		session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(partNumber_Fixture);

		session.getTransaction().commit();
		session.close();
		
		return partNumber_Fixture;
	}
	
	public ArrayList<PartNumber_Fixture> addAllPartNumber_Fixtures(int idFamily,int idPartNumber){
		
		FixtureService fixtureService = new FixtureService();
		ArrayList<Fixture> fixtures = fixtureService.getHardAllFixturesByIdPartNumber(idFamily, idPartNumber);
		
		ArrayList<PartNumber_Fixture> partNumber_Fixtures = new ArrayList<>();
		
		for(Fixture fixture : fixtures){
			int idFixture = fixture.getId();
			PartNumber_Fixture partNumber_Fixture =  new PartNumber_Fixture(idPartNumber, idFixture);
			
			partNumber_Fixtures.add(partNumber_Fixture);
			
			addPartNumber_Fixture(partNumber_Fixture);
			}
		return partNumber_Fixtures;
		 
	}
}
