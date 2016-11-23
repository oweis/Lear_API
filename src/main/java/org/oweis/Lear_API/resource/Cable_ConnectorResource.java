package org.oweis.Lear_API.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.oweis.Lear_API.model.Connector;
import org.oweis.Lear_API.model.Cable_Connector;
import org.oweis.Lear_API.service.ConnectorService;
import org.oweis.Lear_API.service.Cable_ConnectorService;

@Path("/cable_connectors")
@Produces(MediaType.APPLICATION_JSON)
public class Cable_ConnectorResource {
	
	Cable_ConnectorService cable_ConnectorService = new Cable_ConnectorService();

	@GET
	@Path("/search/idFamily/{idFamily}/idCable/{idCable}")
	public List<Cable_Connector> addAllCable_Connectors(@PathParam("idFamily") int idFamily, @PathParam("idCable") int idCable){
		return cable_ConnectorService.addAllCable_Connectors(idFamily, idCable);
	}

	@GET
	@Path("/search/hard/idCable/{idCable}")
	public List<Connector> getHardAllCable_ConnectorsByIdCable(@PathParam("idFamily") int idFamily,@PathParam("idCable") int idPartNumber){
		ConnectorService connectorsService = new ConnectorService();
		return connectorsService.getHardAllConnectorsByIdCable(idFamily,idPartNumber);
	}
	
	@GET
	@Path("/search/idCable/{idCable}")
	public List<Cable_Connector> getAllCable_ConnectorsByIdCable(@PathParam("idCable") int idCable){
		return cable_ConnectorService.getAllCable_ConnectorsByIdCable(idCable);
	}
	
}
