package org.oweis.Lear_API.service;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.oweis.Lear_API.model.Family;
import org.oweis.Lear_API.model.Connector;
import org.oweis.Lear_API.model.Cable_Connector;
import org.oweis.Lear_API.model.Cable_Connector;

public class Cable_ConnectorService {

	Cable_Connector cable_Connector;
	ArrayList<Cable_Connector> cable_Connectors;
	Session session;
	Criteria criteria;
	
	public Cable_ConnectorService() {
		if(!ConnexionService.open){
		ConnexionService.openConnexion();
		}
		this.session = ConnexionService.session;
		
	}
	
	public ArrayList<Cable_Connector> getAllCable_ConnectorsByIdCable(int idCable){
		
		
		criteria = session.createCriteria(Cable_Connector.class).
				add(Restrictions.eq("idCable", idCable));
		
		cable_Connectors = (ArrayList<Cable_Connector>) criteria.list();
		  session.flush();
	        session.clear();

		return cable_Connectors;
	}
	
	public Cable_Connector getCable_Connector(int id){

		cable_Connector = (Cable_Connector) session.get(Cable_Connector.class,id);				
		  session.flush();
	        session.clear();
		
		return cable_Connector;
	}

	public Cable_Connector addCable_Connector(Cable_Connector cable_Connector){


		session.save(cable_Connector);
		  session.flush();
	        session.clear();
		
		
		return cable_Connector;
	}
	
	public ArrayList<Cable_Connector> addAllCable_Connectors(int idFamily,int idCable){
		
		ConnectorService connectorService = new ConnectorService();
		ArrayList<Connector> connectors = connectorService.getHardAllConnectorsByIdCable(idFamily, idCable);
		
		ArrayList<Cable_Connector> cable_Connectors = new ArrayList<>();
		
		for(Connector connector : connectors){
			int idConnector = connector.getId();
			Cable_Connector cable_Connector =  new Cable_Connector(idCable, idConnector);
			
			cable_Connectors.add(cable_Connector);
			
			addCable_Connector(cable_Connector);
			}
		return cable_Connectors;
		 
	}
}
