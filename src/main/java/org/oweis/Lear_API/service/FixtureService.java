package org.oweis.Lear_API.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.oweis.Lear_API.model.Fixture;
import org.oweis.Lear_API.model.Wire;
import org.oweis.Lear_API.resource.FixtureResource;

public class FixtureService {
	
	Fixture fixture;
	ArrayList<Fixture> fixtures;
	
	
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session;
	Criteria criteria;
	
	public FixtureService(){}		

	public ArrayList<Fixture> getAllFixtures(){
		fixtures =  new ArrayList<>();
		session = sessionFactory.openSession();
		session.beginTransaction();
		criteria = session.createCriteria(Fixture.class);
		fixtures = (ArrayList<Fixture>) criteria.list();
		return fixtures;
	}
	
	public ArrayList<Fixture> getAllFixturesByIdFamily(int idFamily){
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		criteria = session.createCriteria(Fixture.class).add(Restrictions.eq("idFamily",idFamily));
		fixtures = (ArrayList<Fixture>) criteria.list();
		
		session.getTransaction().commit();
		session.close();
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
	
	
	public Fixture getFixtureByNameFixture(int idFamily,String nameFixture){
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		criteria = session.createCriteria(Fixture.class).
				add(Restrictions.eq("idFamily",idFamily)).
				add(Restrictions.eq("nameFixture",nameFixture));
		fixture = (Fixture) criteria.list().get(0);
		
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
	
	public Fixture removeAllFixtures(){
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		criteria = session.createCriteria(Fixture.class);
		fixtures = (ArrayList<Fixture>) criteria.list();
		
		for(Fixture fixture : fixtures) session.delete(fixture);
		session.getTransaction().commit();
		session.close();
		return fixture;
	}
	
	public Fixture removeAllFixturesByIdFamily(int idFamily){
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		criteria = session.createCriteria(Fixture.class).add(Restrictions.eq("idFamily",idFamily));
		fixtures = (ArrayList<Fixture>) criteria.list();
		
		for(Fixture fixture : fixtures) session.delete(fixture);
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

	public Fixture removeFixture(int idFamily,String nameFixture){
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		criteria = session.createCriteria(Fixture.class).add(Restrictions.eq("idFamily",idFamily)).add(Restrictions.eq("nameFixture",nameFixture));
		fixture = (Fixture) criteria.uniqueResult();
		
		session.delete(fixture);
		
		session.getTransaction().commit();
		session.close();
		return fixture;
	}
/*
	public List<Fixture> getAllFixturesByIdPartNumber(int idFamily,int idPartNumber){
		WireService wireService = new WireService();
		ArrayList<Wire> wires = wireService.getAllWiresByIdPartNumber(idPartNumber);
		ArrayList<String> nameFixtures = this.getAllNameFixturesFromWires(wires);
		ArrayList<Fixture> fixtures =  this.getAllFixtureByNameFixture(idFamily, nameFixtures);
		return fixtures;
	}


	public ArrayList<String> getAllNameFixturesFromWires(ArrayList<Wire> wires){
		ArrayList<String> nameFixtures;
		nameFixtures = null;
		for(Wire wire : wires){
		//Add Conditions after
		//if (!connector_A.equals("") & nameFixtures.contains(connector_A))
			nameFixtures.add(getFixtureAFromWire(1));
		//if (!connector_B.equals("") & nameFixtures.contains(connector_B))
			nameFixtures.add(getFixtureBFromWire(wire));
		}
		return nameFixtures;
	}*/
	public ArrayList<Fixture> getAllFixturesByIdPartNumber(int idFamily,int idPartNumber){
		
		List<String> nameFixtures = getAllNameFixturesByIdPartNumber(idPartNumber);
		for(String nameFixture : nameFixtures) {
			fixture = this.getFixtureByNameFixture(idFamily, nameFixture);
			fixtures.add(fixture);
		}
		return fixtures;
		
	}
	public List<String> getAllNameFixturesByIdPartNumber(int idPartNumber){
		WireService wireService = new WireService();
		ArrayList<Wire> wires = wireService.getAllWiresByIdPartNumber(idPartNumber);
		List<Integer> listIdWires = new ArrayList<>();
	
		for(Wire wire : wires) {
			listIdWires.add(wire.getId());
		}
		List<String> nameFixtures = new ArrayList<>();
		
		for(int idWire : listIdWires){
		//Add Conditions after
		//if (!connector_A.equals("") & nameFixtures.contains(connector_A))
			nameFixtures.add(getFixtureAByIdWire(idWire));
		//if (!connector_B.equals("") & nameFixtures.contains(connector_B))
			nameFixtures.add(getFixtureBByIdWire(idWire));
		}
		return nameFixtures;
	}
		
		public String getFixtureAByIdWire(int idWire){
			String connector_A;
			WireService wireService = new WireService();
			Wire wire =  wireService.getWire(idWire);
			connector_A = wire.getConnector_A();	
			return connector_A;
		}
		
		public String getFixtureBByIdWire(int idWire){
			String connector_B;
			WireService wireService = new WireService();
			Wire wire =  wireService.getWire(idWire);
			connector_B = wire.getConnector_B();	
			return connector_B;
		}
		
		
	
	public ArrayList<Fixture> getAllFixtureByNameFixture(int idFamily,ArrayList<String> nameFixtures){
		Fixture fixture;
		ArrayList<Fixture> fixtures = null;
		for(String nameFixture : nameFixtures){
			fixture = this.getFixtureByNameFixture(idFamily, nameFixture);
			fixtures.add(fixture);
		}
		return fixtures;
	}
}

