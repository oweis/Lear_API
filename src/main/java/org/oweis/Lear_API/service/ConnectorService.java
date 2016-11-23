package org.oweis.Lear_API.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.oweis.Lear_API.model.Connector;
import org.oweis.Lear_API.model.Cable_Connector;
import org.oweis.Lear_API.model.Wire;

public class ConnectorService {
	
	Connector connector;
	ArrayList<Connector> connectors;
	
	
	Session session;
	Criteria criteria;
	
	public ConnectorService(){
		if(!ConnexionService.open){
		ConnexionService.openConnexion();
		}
		this.session = ConnexionService.session;
	}		

	public ArrayList<Connector> getAllConnectors(){
		connectors =  new ArrayList<>();
		criteria = session.createCriteria(Connector.class);
		connectors = (ArrayList<Connector>) criteria.list();
		return connectors;
	}
	
	public ArrayList<Connector> getAllConnectorsByIdFamily(int idFamily){
		

		
		criteria = session.createCriteria(Connector.class).add(Restrictions.eq("idFamily",idFamily));
		connectors = (ArrayList<Connector>) criteria.list();
		  session.flush();
	        session.clear();

		return connectors;
	}
	
	public Connector getConnector(int id){
		
		
		connector = (Connector) session.get(Connector.class, id);
		  session.flush();
	        session.clear();
	
		return connector;
	}
	
	
	public Connector getConnectorByNameConnector(int idFamily,String nameConnector){

		criteria = session.createCriteria(Connector.class).
				add(Restrictions.eq("idFamily",idFamily)).
				add(Restrictions.eq("nameConnector",nameConnector));
		connector = (Connector) criteria.uniqueResult();
		  session.flush();
	        session.clear();
		
		return connector;
	}
	
	public Connector addConnector(Connector connector){
		

		session.save(connector);
		  session.flush();
	        session.clear();
	
		return connector;
	}
	
	public Connector updateFixture(Connector connector){
		
		session.update(connector);
		  session.flush();
	        session.clear();

		return connector;
	}
	
	public Connector removeAllConnectors(){
		
		
		
		criteria = session.createCriteria(Connector.class);
		connectors = (ArrayList<Connector>) criteria.list();
		
		for(Connector connector : connectors){ session.delete(connector);
		  session.flush();
	        session.clear();}
		
		return connector;
	}
	
	public Connector removeAllConnectorsByIdFamily(int idFamily){
		
	
		
		criteria = session.createCriteria(Connector.class).add(Restrictions.eq("idFamily",idFamily));
		connectors = (ArrayList<Connector>) criteria.list();
		
		for(Connector connector : connectors){ session.delete(connector);
		  session.flush();
	        session.clear();
		}
		return connector;
	}
	
	public Connector removeConnector(int id){
	
		connector = (Connector) session.get(Connector.class,id);
		session.delete(connector);
		  session.flush();
	        session.clear();

		return connector;
	}

	public Connector removeConnector(int idFamily,String nameConnector){
		

		criteria = session.createCriteria(Connector.class)
				.add(Restrictions.eq("idFamily",idFamily))
				.add(Restrictions.eq("nameConnector",nameConnector));
		connector = (Connector) criteria.uniqueResult();
		
		session.delete(connector);
		  session.flush();
	        session.clear();
	
		return connector;
	}
	
	
	public ArrayList<Connector> getAllConnectorsByIdCable(int idCable){
		
		Cable_ConnectorService cable_ConnectorService = new Cable_ConnectorService();
		
		ArrayList<Cable_Connector> cable_Connectors = cable_ConnectorService.getAllCable_ConnectorsByIdCable(idCable);
		ArrayList<Connector> connectors = new ArrayList<Connector>();
		Connector connector = new Connector();
		for(Cable_Connector cable_Connector : cable_Connectors){
			int idConnector = cable_Connector.getIdConnector();
			connector = getConnector(idConnector);
			connectors.add(connector);
		}
		return connectors;	
	}
	
	//	Functions Serve the same purpose
	//	<Section : find fixtures used in a partnumber> 
	public ArrayList<Connector> getHardAllConnectorsByIdCable(int idFamily,int idCable){
		ArrayList<Connector> connectors = new ArrayList<Connector>();
		Connector connector = new Connector();
		List<String> nameConnectors = getAllNameConnectorsByCable(idCable);
		for(String nameConnector : nameConnectors) {
			connector = this.getConnectorByNameConnector(idFamily, nameConnector);
			connectors.add(connector);
		}
		return connectors;	
	}
	
	public List<String> getAllNameConnectorsByCable(int idCable){
		WireService wireService = new WireService();
		//if namefixture in wire with idPartNumber=x then fixture used in partnumber with id=x
		ArrayList<Wire> wires = wireService.getAllWiresByIdCable(idCable);
		//get wires ids, to make it easy to find nameFixture
		List<Integer> listIdWires = new ArrayList<>();
	
		for(Wire wire : wires) {
			listIdWires.add(wire.getId());
		}
		//get all nameFixtures
		List<String> nameConnectors = new ArrayList<>();
		
		for(int idWire : listIdWires){
			ArrayList<String> nameInnerConnectors = getNameConnectorsByIdWire(idWire);
				for(String nameConnector : nameInnerConnectors){
					checkExistThenAdd(nameConnectors, nameConnector);
				}
			}
			return nameConnectors;
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

