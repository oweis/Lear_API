	package org.oweis.Lear_API.resource;
	
	import java.util.List;
	
	import org.oweis.Lear_API.model.Cable;
	import org.oweis.Lear_API.service.CableService;


	import javax.ws.rs.DELETE;
	import javax.ws.rs.POST;
	import javax.ws.rs.Path;
	import javax.ws.rs.GET;
	import javax.ws.rs.PathParam;
	import javax.ws.rs.Produces;
	import javax.ws.rs.core.MediaType;

	@Path("/cables")
	@Produces(MediaType.APPLICATION_JSON)
	public class CableResource {
	private CableService cableService = new CableService();
	
	@GET
	public List<Cable> getAllCables(){
		return cableService.getAllCables();
	}
	
	@GET
	@Path("/search/idFamily/{idFamily}")
	public List<Cable> getAllCablesByIdFamily(@PathParam("idFamily") int idFamily){
		return cableService.getAllCablesByIdFamily(idFamily);
	}
	
	@GET
	@Path("/search/idCable/{idCable}")
	public Cable getCable(@PathParam("idCable") int idCable){
	return cableService.getCable(idCable);
	}
	
	@GET
	@Path("/search/idFamily/{idFamily}/nameUsedInLear/{nameUsedInLear}")
	public Cable getCableByNameUsedInLear(@PathParam("idFamily") int idFamily,@PathParam("nameUsedInLear") String nameUsedInLear){
		return cableService.getCableByNameUsedInLear(idFamily,nameUsedInLear);		
	}
	
	@POST
	public Cable addCable(Cable cable){
		return cableService.addCable(cable);
	}
	
	@DELETE 
	public void removeAllCables(){
		 cableService.removeAllCables();
	}
	
	@DELETE 
	@Path("/delete/idFamily/{idFamily}")
	public void removeAllCablesByIdFamily(@PathParam("idFamily") int idFamily){
		 cableService.removeAllCablesByIdFamily(idFamily);
	}
	
	@DELETE 
	@Path("/delete/idCable/{idCable}")
	public void removeCable(@PathParam("idCable") int idCable){
		 cableService.removeCable(idCable);
	}

	@DELETE 
	@Path("/delete/idFamily/{idFamily}/nameCable/{nameCable}")
	public void removeCable(@PathParam("idFamily") int idFamily,@PathParam("nameCable") String nameCable){
		 cableService.removeCable(idFamily,nameCable);
	}
	
	}
	

