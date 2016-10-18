	package org.oweis.Lear_API.resource;

import java.util.List;

import org.oweis.Lear_API.model.Family;
import org.oweis.Lear_API.service.FamilyService;

import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/familys")
@Produces(MediaType.APPLICATION_JSON)
public class FamilyResource {

	private FamilyService familyService = new FamilyService();
	
	@GET
	public List<Family> getAllFamily(){
		return familyService.getAllFamily();
	}

	@GET
	@Path("/search/nameUsedInLear/{nameUsedInLear}")
	public List<Family> getAllFamilysByNameUsedInLear(@PathParam("nameUsedInLear") String nameUsedInLear){
		return familyService.getAllFamilysByNameUsedInLear(nameUsedInLear);
	}	
	
	@GET
	@Path("/search/nameUsedInClient/{nameUsedInClient}")
	public List<Family> getAllFamilysByNameUsedInClient(@PathParam("nameUsedInClient") String nameUsedInClient){
		return familyService.getAllFamilysByNameUsedInClient(nameUsedInClient);
	}	
	
	@GET
	@Path("/search/idFamily/{idFamily}")
	public Family getFamily(@PathParam("idFamily") int idFamily){
		return familyService.getFamily(idFamily);
	}
	
	@GET
	@Path("/search/namePassByUser/{namePassByUser}")
	public Family getFamilyByNamePassByUser(@PathParam("namePassByUser") String namePassByUser){
		return familyService.getFamilyByNamePassByUser(namePassByUser);
	}
	
	@POST
	public Family addFamily(Family family){
		return familyService.addFamily(family);
	}
	
	@DELETE
	public void removeFamily(Family family){
		familyService.removeFamily(family);
	}
	
	@DELETE 
	@Path("/delete/idFamily/{idFamily}")
	public void removeFamily(@PathParam("idFamily") int idFamily){
		 familyService.removeFamily(idFamily);
	}
	
	@DELETE 
	@Path("/delete/namePassByUser/{namePassByUser}")
	public void removeFamily(@PathParam("namePassByUser") String namePassByUser){
		 familyService.removeFamily(namePassByUser);
	}
}	
