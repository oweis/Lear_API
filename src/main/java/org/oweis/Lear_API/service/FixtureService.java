package org.oweis.Lear_API.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.oweis.Lear_API.model.Fixture;
import org.oweis.Lear_API.model.PartNumber_Fixture;
import org.oweis.Lear_API.model.Wire;

public class FixtureService {
	
	Fixture fixture;
	ArrayList<Fixture> fixtures;
	
	
	Session session;
	Criteria criteria;
	
	public FixtureService(){
		if(!ConnexionService.open){
		ConnexionService.openConnexion();
		}
		this.session = ConnexionService.session;
	}		

	public ArrayList<Fixture> getAllFixtures(){
		fixtures =  new ArrayList<>();
		criteria = session.createCriteria(Fixture.class);
		fixtures = (ArrayList<Fixture>) criteria.list();
		return fixtures;
	}
	
	public ArrayList<Fixture> getAllFixturesByIdFamily(int idFamily){
		

		
		criteria = session.createCriteria(Fixture.class).add(Restrictions.eq("idFamily",idFamily));
		fixtures = (ArrayList<Fixture>) criteria.list();
		  session.flush();
	        session.clear();

		return fixtures;
	}
	
	public Fixture getFixture(int id){
		
		
		fixture = (Fixture) session.get(Fixture.class, id);
		  session.flush();
	        session.clear();
	
		return fixture;
	}
	
	
	public Fixture getFixtureByNameFixture(int idFamily,String nameFixture){

		criteria = session.createCriteria(Fixture.class).
				add(Restrictions.eq("idFamily",idFamily)).
				add(Restrictions.eq("nameFixture",nameFixture));
		fixture = (Fixture) criteria.uniqueResult();
		  session.flush();
	        session.clear();
		
		return fixture;
	}
	
	public Fixture addFixture(Fixture fixture){
		

		session.save(fixture);
		  session.flush();
	        session.clear();
	
		return fixture;
	}
	
	public Fixture updateFixture(Fixture fixture){
		
		session.update(fixture);
		  session.flush();
	        session.clear();

		return fixture;
	}
	
	public Fixture removeAllFixtures(){
		
		
		
		criteria = session.createCriteria(Fixture.class);
		fixtures = (ArrayList<Fixture>) criteria.list();
		
		for(Fixture fixture : fixtures){ session.delete(fixture);
		  session.flush();
	        session.clear();}
		
		return fixture;
	}
	
	public Fixture removeAllFixturesByIdFamily(int idFamily){
		
	
		
		criteria = session.createCriteria(Fixture.class).add(Restrictions.eq("idFamily",idFamily));
		fixtures = (ArrayList<Fixture>) criteria.list();
		
		for(Fixture fixture : fixtures){ session.delete(fixture);
		  session.flush();
	        session.clear();
		}
		return fixture;
	}
	
	public Fixture removeFixture(int id){
	
		fixture = (Fixture) session.get(Fixture.class,id);
		session.delete(fixture);
		  session.flush();
	        session.clear();

		return fixture;
	}

	public Fixture removeFixture(int idFamily,String nameFixture){
		

		criteria = session.createCriteria(Fixture.class).add(Restrictions.eq("idFamily",idFamily)).add(Restrictions.eq("nameFixture",nameFixture));
		fixture = (Fixture) criteria.uniqueResult();
		
		session.delete(fixture);
		  session.flush();
	        session.clear();
	
		return fixture;
	}
	
	
	public ArrayList<Fixture> getAllFixturesByIdPartNumber(int idPartNumber){
		
		PartNumber_FixtureService partNumber_FixtureService = new PartNumber_FixtureService();
		
		ArrayList<PartNumber_Fixture> partNumber_Fixtures = partNumber_FixtureService.getAllPartNumber_FixturesByIdPartNumber(idPartNumber);
		ArrayList<Fixture> fixtures = new ArrayList<Fixture>();
		Fixture fixture = new Fixture();
		for(PartNumber_Fixture partNumber_Fixture : partNumber_Fixtures){
			int idFixture = partNumber_Fixture.getIdFixture();
			fixture = getFixture(idFixture);
			fixtures.add(fixture);
		}
		return fixtures;	
	}
	
	//	Functions Serve the same purpose
	//	<Section : find fixtures used in a partnumber> 
	public ArrayList<Fixture> getHardAllFixturesByIdPartNumber(int idFamily,int idPartNumber){
		ArrayList<Fixture> fixtures = new ArrayList<Fixture>();
		Fixture fixture = new Fixture();
		List<String> nameFixtures = getAllNameFixturesByIdPartNumber(idPartNumber);
		for(String nameFixture : nameFixtures) {
			fixture = this.getFixtureByNameFixture(idFamily, nameFixture);
			fixtures.add(fixture);
		}
		return fixtures;	
	}
	
	public List<String> getAllNameFixturesByIdPartNumber(int idPartNumber){
		WireService wireService = new WireService();
		//if namefixture in wire with idPartNumber=x then fixture used in partnumber with id=x
		ArrayList<Wire> wires = wireService.getAllWiresByIdPartNumber(idPartNumber);
		//get wires ids, to make it easy to find nameFixture
		List<Integer> listIdWires = new ArrayList<>();
	
		for(Wire wire : wires) {
			listIdWires.add(wire.getId());
		}
		//get all nameFixtures
		List<String> nameFixtures = new ArrayList<>();
		
		for(int idWire : listIdWires){
			ArrayList<String> nameConnectors = getNameConnectorsByIdWire(idWire);
				for(String nameConnector : nameConnectors){
					checkExistThenAdd(nameFixtures, nameConnector);
				}
			}
			return nameFixtures;
	}
	
		public ArrayList<String>  getNameConnectorsByIdWire(int idWire){
			ArrayList<String> nameConnectors = new ArrayList<String>();
	
			WireService wireService = new WireService();
			Wire wire =  wireService.getWire(idWire);
			nameConnectors.add(wire.getConnector_A());
			nameConnectors.add(wire.getConnector_B());
			return nameConnectors;
		}
		
	public void checkExistThenAdd(List<String> nameFixtures,String newName){
			if (!newName.equals("") & !nameFixtures.contains(newName))
				nameFixtures.add(newName);
		}
	//	</Section : find fixtures used in a partnumber> 
		
	

}

