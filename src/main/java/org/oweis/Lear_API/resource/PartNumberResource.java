	package org.oweis.Lear_API.resource;
	
	import java.util.List;
	
	import org.oweis.Lear_API.model.PartNumber;
	import org.oweis.Lear_API.service.PartNumberService;
	
	import javax.ws.rs.Consumes;
	import javax.ws.rs.DELETE;
	import javax.ws.rs.POST;
	import javax.ws.rs.PUT;
	import javax.ws.rs.Path;
	import javax.ws.rs.GET;
	import javax.ws.rs.PathParam;
	import javax.ws.rs.Produces;
	import javax.ws.rs.core.MediaType;

	@Path("/partnumbers")
	@Produces(MediaType.APPLICATION_JSON)
	public class PartNumberResource {
	private PartNumberService partNumberService = new PartNumberService();
	
	@GET
	public List<PartNumber> getAllPartNumbers(){
		return partNumberService.getAllPartNumbers();
	}
	
	@GET
	@Path("/search/idFamily/{idFamily}")
	public List<PartNumber> getAllPartNumbersByIdFamily(@PathParam("idFamily") int idFamily){
		return partNumberService.getAllPartNumbersByIdFamily(idFamily);
	}
	
	@GET
	@Path("/search/idPartNumber/{idPartNumber}")
	public PartNumber getPartNumber(@PathParam("idPartNumber") int idPartNumber){
	return partNumberService.getPartNumber(idPartNumber);
	}
	
	@GET
	@Path("/search/idFamily/{idFamily}/nameUsedInLear/{nameUsedInLear}")
	public PartNumber getPartNumberByNameUsedInLear(@PathParam("idFamily") int idFamily,@PathParam("nameUsedInLear") String nameUsedInLear){
		return partNumberService.getPartNumberByNameUsedInLear(idFamily,nameUsedInLear);		
	}
	
	@POST
	public PartNumber addPartNumber(PartNumber partNumber){
		return partNumberService.addPartNumber(partNumber);
	}
	
	@DELETE 
	public void removeAllPartNumbers(){
		 partNumberService.removeAllPartNumbers();
	}
	
	@DELETE 
	@Path("/delete/idFamily/{idFamily}")
	public void removeAllPartNumbersByIdFamily(@PathParam("idFamily") int idFamily){
		 partNumberService.removeAllPartNumbersByIdFamily(idFamily);
	}
	
	@DELETE 
	@Path("/delete/idPartNumber/{idPartNumber}")
	public void removePartNumber(@PathParam("idPartNumber") int idPartNumber){
		 partNumberService.removePartNumber(idPartNumber);
	}

	@DELETE 
	@Path("/delete/idFamily/{idFamily}/namePartNumber/{namePartNumber}")
	public void removePartNumber(@PathParam("idFamily") int idFamily,@PathParam("namePartNumber") String namePartNumber){
		 partNumberService.removePartNumber(idFamily,namePartNumber);
	}
	
	}
	

