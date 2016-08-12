package org.oweis.Lear_API.resource;

import java.util.List;

import org.oweis.Lear_API.model.Wire;
import org.oweis.Lear_API.service.WireService;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/wires")
@Produces(MediaType.APPLICATION_JSON)
public class WireResource {
	private WireService wireService = new WireService();
	
	@GET
	public List<Wire> getAllWires(){
		return wireService.getAllWire();
	}
	
	@GET
	@Path("/search/idFamily/{idFamily}")
	public List<Wire> getAllWiresByIdFamily(@PathParam("idFamily") int idFamily){
		return wireService.getAllWiresByIdFamily(idFamily);
	}
	
	@GET
	@Path("/search/idFamily/{idFamily}/nameWire/{nameWire}")
	public Wire getWireByNameWire(@PathParam("idFamily") int idFamily,@PathParam("nameWire") String nameWire){
	return wireService.getWireByNameWire(idFamily,nameWire);
	}
	
	@GET
	@Path("/search/idWire/{idWire}")
	public Wire getWire(@PathParam("idWire") int idWire){
	return wireService.getWire(idWire);
	}
	
	@POST
	public Wire addWire(Wire wire){
		return wireService.addWire(wire);
	}

	@DELETE
	@Path("/delete/idFamily/{idFamily}")
	public void removeAllWirseByIdFamily(@PathParam("idFamily") int idFamily){
		wireService.removeAllWiresByIdFamily(idFamily);
	}
	
	@DELETE 
	public void removeWire(Wire wire){
		 wireService.removeWire(wire);
	}

	@DELETE 
	@Path("/delete/idFamily/{idFamily}/nameWire/{nameWire}")
	public void removeWireByNameWire(@PathParam("idFamily") int idFamily,@PathParam("nameWire") String nameWire){
		 wireService.removeWireByNameWire(idFamily,nameWire);
	}	

	@DELETE 
	@Path("/delete/idWire/{idWire}")
	public void removeWire(@PathParam("idWire") int idWire){
		 wireService.removeWire(idWire);
	}

}
	

