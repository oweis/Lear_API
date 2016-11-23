package org.oweis.Lear_API.resource;

import java.util.List;


import org.oweis.Lear_API.model.Connector;
import org.oweis.Lear_API.service.ConnectorService;

import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/connectors")
@Produces(MediaType.APPLICATION_JSON)
public class ConnectorResource {
	private ConnectorService connectorService = new ConnectorService();
	
	@GET
	public List<Connector> getAllConnectors(){
		return connectorService.getAllConnectors();
	}

	@GET
	@Path("/search/idFamily/{idFamily}")
	public List<Connector> getAllConnectorsByIdFamily(@PathParam("idFamily") int idFamily){
	return connectorService.getAllConnectorsByIdFamily(idFamily);
	}

	@GET
	@Path("/search/hard/idFamily/{idFamily}/idCable/{idCable}")
	public List<Connector> getHardAllConnectorsByIdCable(@PathParam("idFamily") int idFamily,@PathParam("idCable") int idCable){
		return  connectorService.getHardAllConnectorsByIdCable(idFamily,idCable);
	}
	

	@GET
	@Path("/search/idCable/{idCable}")
	public List<Connector> getAllConnectorsByIdCable(@PathParam("idCable") int idCable){
		return connectorService.getAllConnectorsByIdCable(idCable);
	}	
	

	@GET
	@Path("/search/idConnector/{idConnector}")
	public Connector getConnector(@PathParam("idConnector") int idConnector){
	return connectorService.getConnector(idConnector);
	}
	
	@GET
	@Path("/search/idFamily/{idFamily}/nameConnector/{nameConnector}")
	public Connector getConnectorByNameConnector(@PathParam("idFamily") int idFamily,@PathParam("nameConnector") String nameConnector){
	return connectorService.getConnectorByNameConnector(idFamily,nameConnector);
	}
	
	@POST
	public Connector addConnector(Connector connector){
		return connectorService.addConnector(connector);
	}
	
	@DELETE
	public void removeAllConnectors(){
	 connectorService.removeAllConnectors();
	}
	
	@DELETE
	@Path("/search/idFamily/{idFamily}")
	public void removeAllConnectorsByIdFamily(@PathParam("idFamily") int idFamily){
	 connectorService.removeAllConnectorsByIdFamily(idFamily);
	}

	@DELETE 
	@Path("/delete/idConnector/{idConnector}")
	public void removeConnector(@PathParam("idConnector") int idConnector){
		 connectorService.removeConnector(idConnector);
	}

	@DELETE 
	@Path("/delete/idFamily/{idFamily}/nameConnector/{nameConnector}")
	public void removeConnector(@PathParam("idFamily") int idFamily,@PathParam("nameConnector") String nameConnector){
		 connectorService.removeConnector(idFamily,nameConnector);
	}
	
	
}