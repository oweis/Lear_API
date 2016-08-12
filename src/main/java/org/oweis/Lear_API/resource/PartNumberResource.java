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
	public List<PartNumber> getAllPartNumber(){
		return partNumberService.getAllPartNumber();
	}
	
	@GET
	@Path("/search/idFamily/{idFamily}")
	public List<PartNumber> getAllPartNumberByIdFamily(@PathParam("idFamily") int idFamily){
		return partNumberService.getAllPartNumberByIdFamily(idFamily);
	}
	
	@GET
	@Path("/search/idPartNumber/{idPartNumber}")
	public PartNumber getPartNumber(@PathParam("idPartNumber") int idPartNumber){
	return partNumberService.getPartNumber(idPartNumber);
	}
	
	@GET
	@Path("/search/idFamily/{idFamily}/namePartNumber/{namePartNumber}")
	public PartNumber getPartNumberByNamePartNumber(@PathParam("idFamily") int idFamily,@PathParam("namePartNumber") String namePartNumber){
		return partNumberService.getPartNumberByNamePartNumber(idFamily,namePartNumber);		
	}
	
	@POST
	public PartNumber addPartNumber(PartNumber partNumber){
		return partNumberService.addPartNumber(partNumber);
	}
	
	@PUT 	
	@Path("/{partNumberName}")
	public PartNumber updatePartNumber(@PathParam("partNumberName") String partNumberName,PartNumber partNumber){
		//partNumber.setPartNumberName(partNumberName);
		return partNumberService.updatePartNumber(partNumber);
	}
	
	@DELETE 
	@Path("/{partNumberName}")
	public void removePartNumber(@PathParam("partNumberName") String partNumberName){
		 partNumberService.removePartNumber(partNumberName);
	}

	}
	

