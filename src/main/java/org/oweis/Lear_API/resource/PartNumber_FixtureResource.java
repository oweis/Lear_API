package org.oweis.Lear_API.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.oweis.Lear_API.model.Fixture;
import org.oweis.Lear_API.model.PartNumber_Fixture;
import org.oweis.Lear_API.service.FixtureService;
import org.oweis.Lear_API.service.PartNumber_FixtureService;

@Path("/partnumber_fixtures")
@Produces(MediaType.APPLICATION_JSON)
public class PartNumber_FixtureResource {
	
	PartNumber_FixtureService partNumber_FixtureService = new PartNumber_FixtureService();

	@GET
	@Path("/search/idFamily/{idFamily}/idPartNumber/{idPartNumber}")
	public List<PartNumber_Fixture> addAllPartNumber_Fixtures(@PathParam("idFamily") int idFamily, @PathParam("idPartNumber") int idPartNumber){
		return partNumber_FixtureService.addAllPartNumber_Fixtures(idFamily, idPartNumber);
	}

	@GET
	@Path("/search/hard/idPartNumber/{idPartNumber}")
	public List<Fixture> getHardAllPartNumber_FixturesByIdPartNumber(@PathParam("idFamily") int idFamily,@PathParam("idPartNumber") int idPartNumber){
		FixtureService fixtureService = new FixtureService();
		return fixtureService.getHardAllFixturesByIdPartNumber(idFamily,idPartNumber);
	}
	
	@GET
	@Path("/search/idPartNumber/{idPartNumber}")
	public List<PartNumber_Fixture> getAllPartNumber_FixturesByIdPartNumber(@PathParam("idPartNumber") int idPartNumber){
		return partNumber_FixtureService.getAllPartNumber_FixturesByIdPartNumber(idPartNumber);
	}
	
}
